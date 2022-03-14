package tp.service;

import tp.model.Compte;

import java.util.List;

public interface ICompteService {
    Compte save(Compte c);

    Compte modify(Compte c);

    List<Compte> getAll();

    Compte getOne(long id);
}
