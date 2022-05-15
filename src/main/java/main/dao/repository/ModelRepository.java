package main.dao.repository;

import main.dao.entity.Model;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ModelRepository extends CrudRepository<Model, Long> {

    Model getModelByName(String name);
}
