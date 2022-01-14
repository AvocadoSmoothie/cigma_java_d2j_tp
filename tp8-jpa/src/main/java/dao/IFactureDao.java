package dao;


import model.Facture;

import java.util.List;

public interface IFactureDao {
    Facture save(Facture facture);
    Facture update(Facture facture);
    List<Facture> findAll();

    void deleteById(long id);
}

