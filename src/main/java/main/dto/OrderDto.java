package main.dto;

import lombok.*;
import main.common.OrderStatus;

import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.util.List;

@AllArgsConstructor
@Getter
@NoArgsConstructor
@Setter
@Builder
public class OrderDto {

    private Long id;
    private ClientDto client;
    private String model;
    private String gender;
    private String color;
    private String type;
    private OffsetDateTime createdAt;
    private OrderStatus status;
    private List<ParameterDto> parameters;
    private List<AttributeDto> attributes;
}
