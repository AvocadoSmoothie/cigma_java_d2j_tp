package tp.service;

import tp.model.Facture;

import java.util.List;

public interface IFactureService {
    Facture save(Facture facture);

    Facture modify(Facture facture);

    void delete(long id);

    List<Facture> getAll();

    List<Facture> findByClientId(Long id);

}
