package main.service.mapper;

import main.dao.entity.Order;
import main.dto.OrderDto;
import org.mapstruct.Mapper;

@Mapper
public interface OrderMapper {

    OrderDto toDto(Order order);
}
