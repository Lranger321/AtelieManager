package main.service;

import main.common.OrderStatus;
import main.dto.OrderChangeStatusDto;
import main.dto.OrderDto;
import main.dto.OrderPageDto;
import main.dto.OrderRequestDto;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface OrderService {

    OrderPageDto getOrders(OrderStatus orderStatus, Pageable pageable);

    List<OrderDto> findAll();

    OrderDto createOrder(OrderRequestDto request);

    OrderDto changeStatus(OrderChangeStatusDto orderChangeStatusDto);

    OrderDto getById(Long id);
}
