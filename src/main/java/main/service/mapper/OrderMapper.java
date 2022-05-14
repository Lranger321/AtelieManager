package main.service.mapper;

import main.dao.entity.Material;
import main.dao.entity.Model;
import main.dao.entity.Order;
import main.dto.OrderDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface OrderMapper {

    OrderDto toDto(Order order);

    List<OrderDto> toDtos(List<Order> order);

    default String map(Material material) {
        return material.getName();
    }

    default String map(Model model) {
        return model.getName();
    }
}
