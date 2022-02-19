package dao;


import model.Facture;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IFactureDao  extends CrudRepository<Facture, Long> {
    List<Facture> findAll();
    List<Facture> findByClient_Id(Long id);
}

