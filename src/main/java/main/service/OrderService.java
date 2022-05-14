package main.service;

import main.common.OrderStatus;
import main.dto.OrderChangeStatusDto;
import main.dto.OrderDto;
import main.dto.OrderPageDto;
import org.springframework.data.domain.Pageable;

public interface OrderService {

    OrderPageDto getOrders(OrderStatus orderStatus, Pageable pageable);

    OrderDto createOrder();

    OrderDto changeStatus(OrderChangeStatusDto orderChangeStatusDto);

}
