package main.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Builder
@AllArgsConstructor
@Getter
public class OrderPageDto {

    List<OrderDto> orders;
    private int pageCount;
    private long count;
}
