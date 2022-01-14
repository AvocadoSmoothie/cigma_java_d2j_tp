package service;

import model.Client;

import java.util.List;

public interface IClientService {
    Client save(Client c);

    Client modify(Client c);

    List<Client> getAll();
}
