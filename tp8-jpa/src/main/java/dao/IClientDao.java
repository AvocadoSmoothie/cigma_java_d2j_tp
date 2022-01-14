package dao;


import model.Client;

import java.util.List;

public interface IClientDao {
    Client save(Client c);
    Client update(Client c);
    List<Client> findAll();
    void deleteById(long id);
}

