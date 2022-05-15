package main.dto;

import lombok.*;

import java.util.List;

@AllArgsConstructor
@Getter
@NoArgsConstructor
@Setter
@Builder
public class OrderPageDto {

    List<OrderDto> orders;
    private int pageCount;
    private long count;
}
