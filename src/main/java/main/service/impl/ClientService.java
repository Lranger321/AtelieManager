package main.service.impl;

import lombok.RequiredArgsConstructor;
import main.dao.entity.Client;
import main.dao.repository.ClientRepository;
import main.dto.ClientDto;
import main.service.mapper.ClientMapper;
import org.springframework.stereotype.Service;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class ClientService {

    private final ClientRepository clientRepository;
    private final ClientMapper clientMapper;

    public Client getClient(ClientDto clientDto) {
        Optional<Client> optionalClient = clientRepository.findByNumber(clientDto.getNumber());
        if (optionalClient.isEmpty()) {
            return clientRepository.save(clientMapper.toEntity(clientDto));
        }
        return optionalClient.get();
    }
}
