package main.dto;

import lombok.*;

@AllArgsConstructor
@Getter
@NoArgsConstructor
@Setter
@Builder
public class AttributeDto {

    private String name;
    private String material;
    private String materialType;
}
