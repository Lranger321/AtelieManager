package main.service.mapper;

import main.dao.entity.Parameter;
import main.dto.ParameterDto;
import org.mapstruct.Mapper;

@Mapper
public interface ParameterMapper {

    ParameterDto toDto(Parameter parameter);
}
