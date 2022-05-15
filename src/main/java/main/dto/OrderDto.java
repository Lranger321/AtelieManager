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

    private ClientDto client;
    private String modelName;
    private OffsetDateTime createdAt;
    private OrderStatus status;
    private List<ParameterDto> parameters;
    private List<AttributeDto> attributes;
}
