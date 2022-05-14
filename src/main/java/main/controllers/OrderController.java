package main.controllers;

import lombok.RequiredArgsConstructor;
import main.common.OrderStatus;
import main.dto.OrderChangeStatusDto;
import main.dto.OrderDto;
import main.dto.OrderPageDto;
import main.service.OrderService;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/orders")
public class OrderController {

    private final OrderService orderService;

    @GetMapping("/")
    public OrderPageDto getOrders(OrderStatus orderStatus, @PageableDefault(sort = "createdAt", direction = Sort.Direction.DESC) Pageable page) {
        return orderService.getOrders(orderStatus, page);
    }

    @PostMapping("/")
    public OrderDto createOrder() {
        return orderService.createOrder();
    }

    @PostMapping("/changeStatus")
    public OrderDto changeStatus(@RequestBody OrderChangeStatusDto orderChangeStatusDto) {
        return orderService.changeStatus(orderChangeStatusDto);
    }

}
