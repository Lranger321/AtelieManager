package main.service.mapper;

import main.dao.entity.Material;
import main.dao.entity.Model;
import main.dao.entity.Order;
import main.dto.OrderDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper
public interface OrderMapper {

    @Mapping(source = "model.name", target = "modelName")
    OrderDto toDto(Order order);

    @Mapping(source = "model.name", target = "modelName")
    List<OrderDto> toDtos(List<Order> order);

    default String map(Material material) {
        return material.getName();
    }

    default String map(Model model) {
        return model.getName();
    }
}
