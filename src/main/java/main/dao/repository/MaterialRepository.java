package main.dao.repository;

import main.dao.entity.Material;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MaterialRepository extends CrudRepository<Material, Long> {

    Material getMaterialByName(String name);

}
