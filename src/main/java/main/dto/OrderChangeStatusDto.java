package main.dto;

import lombok.*;
import main.common.OrderStatus;

@AllArgsConstructor
@Getter
@NoArgsConstructor
@Setter
@Builder
public class OrderChangeStatusDto {

    private Long id;
    private OrderStatus orderStatus;
}
