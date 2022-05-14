package main.service.impl;

import lombok.RequiredArgsConstructor;
import main.common.OrderStatus;
import main.dao.entity.Order;
import main.dto.OrderChangeStatusDto;
import main.dto.OrderDto;
import main.dto.OrderPageDto;
import main.exception.OrderNotFoundException;
import main.dao.repository.OrderRepository;
import main.service.OrderService;
import main.service.mapper.OrderMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final OrderMapper mapper;

    @Override
    public OrderPageDto getOrders(OrderStatus orderStatus, Pageable pageable) {
        Page<Order> orderPage = orderRepository.findAllByStatus(orderStatus, pageable);
        return OrderPageDto.builder()
                .orders(mapper.toDtos(orderPage.getContent()))
                .pageCount(orderPage.getTotalPages())
                .count(orderPage.getTotalElements())
                .build();
    }

    @Override
    public OrderDto createOrder() {
        return null;
    }

    @Override
    public OrderDto changeStatus(OrderChangeStatusDto orderChangeStatusDto) {
        Order order = orderRepository.findById(orderChangeStatusDto.getId())
                .orElseThrow(() -> new OrderNotFoundException(String.format("Order with id [%d] not found", orderChangeStatusDto.getId())));
        order.setStatus(orderChangeStatusDto.getOrderStatus());
        return mapper.toDto(orderRepository.save(order));
    }
}
