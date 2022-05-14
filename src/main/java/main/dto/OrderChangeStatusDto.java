package main.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import main.common.OrderStatus;

@AllArgsConstructor
@Getter
@NoArgsConstructor
@Setter
public class OrderChangeStatusDto {

    private Long id;
    private OrderStatus orderStatus;
}
