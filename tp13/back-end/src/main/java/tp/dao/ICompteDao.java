package tp.dao;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import tp.model.Client;
import tp.model.Compte;

import java.util.List;

@Repository
public interface ICompteDao extends CrudRepository<Compte, Long> {
    List<Compte> findAll();
}

