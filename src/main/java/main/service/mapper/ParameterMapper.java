package main.service.mapper;

import main.dao.entity.Parameter;
import main.dto.ParameterDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface ParameterMapper {

    ParameterDto toDto(Parameter parameter);

    List<ParameterDto> toDtos(List<Parameter> parameters);
}
