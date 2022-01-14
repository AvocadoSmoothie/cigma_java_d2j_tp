package service;

import dao.IClientDao;
import model.Client;

import java.util.List;

public class ClientServiceImpl implements IClientService {
    IClientDao dao;
    @Override
    public Client save(Client c) {
        return dao.save(c);
    }

    @Override
    public Client modify(Client c) {
        return dao.update(c);
    }

    @Override
    public List<Client> getAll() {
        return dao.findAll();
    }

    public void setDao(IClientDao dao) {
        this.dao = dao;
    }
}
