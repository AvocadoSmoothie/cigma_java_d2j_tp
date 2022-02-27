package tp.service;

import tp.model.Client;

import java.util.List;

public interface IClientService {
    Client save(Client c);

    Client modify(Client c);

    List<Client> getAll();

    Client getOne(long id);

    List<Client> findByName(String name);
}
