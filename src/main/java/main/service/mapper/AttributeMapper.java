package main.service.mapper;

import main.dao.entity.Attribute;
import main.dto.AttributeDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper
public interface AttributeMapper {

    @Mapping(source = "material.name", target = "material")
    @Mapping(source = "material.type", target = "materialType")
    AttributeDto toDto(Attribute attribute);

    List<AttributeDto> toDtos(List<Attribute> attributes);
}
