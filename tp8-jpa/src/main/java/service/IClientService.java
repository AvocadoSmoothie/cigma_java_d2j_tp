package service;

import model.Client;

public interface IClientService {
    Client save(Client c);

    Client modify(Client c);
}
