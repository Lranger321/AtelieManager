package main.service.mapper;

import main.dao.entity.Client;
import main.dto.ClientDto;
import org.mapstruct.Mapper;

@Mapper
public interface ClientMapper {

    ClientDto toDto(Client client);

    Client toEntity(ClientDto clientDto);
}
