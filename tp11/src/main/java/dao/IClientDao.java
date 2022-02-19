package dao;


import model.Client;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IClientDao extends CrudRepository<Client, Long> {
    List<Client> findAll();
    List<Client> findByName(String name);
}

