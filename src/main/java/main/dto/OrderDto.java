package main.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import main.common.OrderStatus;

import java.time.LocalDate;
import java.util.List;

@Getter
@Builder
@AllArgsConstructor
public class OrderDto {

    private ClientDto client;
    private String modelName;
    private LocalDate createdAt;
    private OrderStatus status;
    private List<ParameterDto> parameters;
    private List<AttributeDto> attributes;
}
