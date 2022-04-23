package main.service.mapper;

import main.dao.entity.Attribute;
import main.dto.AttributeDto;
import org.mapstruct.Mapper;

@Mapper
public interface AttributeMapper {

    AttributeDto toDto(Attribute attribute);
}
