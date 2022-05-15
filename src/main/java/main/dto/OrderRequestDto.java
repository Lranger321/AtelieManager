package main.dto;

import lombok.*;

import java.util.List;

@AllArgsConstructor
@Getter
@NoArgsConstructor
@Setter
@Builder
public class OrderRequestDto {

    private ClientDto clientDto;
    private String model;
    private List<AttributeDto> attributes;
    private List<ParameterDto> parameters;
}
