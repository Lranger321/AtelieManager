package main.service.impl;

import lombok.RequiredArgsConstructor;
import main.common.OrderStatus;
import main.dao.entity.Attribute;
import main.dao.entity.Order;
import main.dao.entity.Parameter;
import main.dao.repository.ModelRepository;
import main.dao.repository.OrderRepository;
import main.dto.*;
import main.exception.OrderNotFoundException;
import main.service.OrderService;
import main.service.mapper.ClientMapper;
import main.service.mapper.OrderMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final OrderMapper mapper;
    private final ClientMapper clientMapper;
    private final MaterialService materialService;
    private final ClientService clientService;
    private final ModelRepository modelRepository;

    @Override
    public OrderPageDto getOrders(OrderStatus orderStatus, Pageable pageable) {
        Page<Order> orderPage = orderRepository.findAllByStatus(orderStatus, pageable);
        return OrderPageDto.builder()
                .orders(mapper.toDtos(orderPage.getContent()))
                .pageCount(orderPage.getTotalPages())
                .count(orderPage.getTotalElements())
                .build();
    }

    @Transactional
    @Override
    public OrderDto createOrder(OrderRequestDto request) {
        Order order = Order.builder()
                .client(clientService.getClient(request.getClientDto()))
                .model(modelRepository.getModelByName(request.getModel()))
                .build();
        order.setCreatedAt(OffsetDateTime.now());
        order.setStatus(OrderStatus.BACKLOG);
        order.setAttributes(getAttributes(request.getAttributes(), order));
        order.setParameters(getParameters(request.getParameters(), order));
        return mapper.toDto(orderRepository.save(order));
    }

    @Override
    public OrderDto changeStatus(OrderChangeStatusDto orderChangeStatusDto) {
        Order order = orderRepository.findById(orderChangeStatusDto.getId())
                .orElseThrow(() -> new OrderNotFoundException(String.format("Order with id [%d] not found", orderChangeStatusDto.getId())));
        order.setStatus(orderChangeStatusDto.getOrderStatus());
        return mapper.toDto(orderRepository.save(order));
    }

    private List<Attribute> getAttributes(List<AttributeDto> attributeDtos, Order order) {
        return attributeDtos.stream()
                .map(attributeDto -> Attribute.builder()
                        .material(materialService.getMaterials(attributeDto.getMaterial()))
                        .name(attributeDto.getName())
                        .order(order)
                        .build())
                .collect(Collectors.toList());
    }

    private List<Parameter> getParameters(List<ParameterDto> parameterDtos, Order order) {
        return parameterDtos.stream()
                .map(parameterDto -> Parameter.builder()
                        .name(parameterDto.getName())
                        .size(parameterDto.getSize())
                        .order(order)
                        .build())
                .collect(Collectors.toList());
    }

}
