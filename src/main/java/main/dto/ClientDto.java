package main.dto;

import lombok.*;

@AllArgsConstructor
@Getter
@NoArgsConstructor
@Setter
@Builder
public class ClientDto {

    private String name;
    private String number;
    private String email;
}
