package main.dto;

import lombok.*;

import java.util.List;

@AllArgsConstructor
@Getter
@NoArgsConstructor
@Setter
@Builder
public class OrderRequestDto {

    private ClientDto userInfo;
    private String model;
    private String gender;
    private String color;
    private String type;
    private List<ParameterDto> parameters;
}
