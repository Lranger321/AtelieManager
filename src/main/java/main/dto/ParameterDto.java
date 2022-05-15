package main.dto;

import lombok.*;

@AllArgsConstructor
@Getter
@NoArgsConstructor
@Setter
@Builder
public class ParameterDto {

    private String name;
    private Double size;
}
