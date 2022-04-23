package main.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Builder
@AllArgsConstructor
public class OrderDto {

    private ClientDto client;
    private LocalDate createdAt;
    private List<ParameterDto> parameters;
    private List<AttributeDto> attributes;
}
