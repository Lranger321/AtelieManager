package main.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class ClientDto {

    private String lastName;
    private String firstName;
    private String middleName;
    private String number;
}
