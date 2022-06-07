package main.controllers;

import lombok.RequiredArgsConstructor;
import main.dto.OrderChangeStatusDto;
import main.dto.OrderDto;
import main.dto.OrderRequestDto;
import main.service.OrderService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/orders")
public class OrderController {

    private final OrderService orderService;

    @GetMapping("/findAll")
    public List<OrderDto> getOrders() {
        return orderService.findAll();
    }

    @PostMapping("/")
    public OrderDto createOrder(@RequestBody OrderRequestDto request) {
        return orderService.createOrder(request);
    }

    @PostMapping("/changeStatus")
    public OrderDto changeStatus(@RequestBody OrderChangeStatusDto orderChangeStatusDto) {
        return orderService.changeStatus(orderChangeStatusDto);
    }

    @GetMapping("/{id}")
    public OrderDto getById(@PathVariable Long id) {
        return orderService.getById(id);
    }

}
