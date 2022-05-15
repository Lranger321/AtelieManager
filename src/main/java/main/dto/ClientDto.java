package main.dto;

import lombok.*;

@AllArgsConstructor
@Getter
@NoArgsConstructor
@Setter
@Builder
public class ClientDto {

    private String lastName;
    private String firstName;
    private String middleName;
    private String number;
}
