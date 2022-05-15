package main.service.impl;

import lombok.RequiredArgsConstructor;
import main.dao.entity.Material;
import main.dao.repository.MaterialRepository;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class MaterialService {

    private final MaterialRepository repository;

    @Cacheable
    public Material getMaterials(String name){
        return repository.getMaterialByName(name);
    }

}
