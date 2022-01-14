package dao;


import model.Client;

public interface IClientDao {
    Client save(Client c);
    Client update(Client c);
}

