package service;

import dao.IClientDao;
import model.Client;

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

    public void setDao(IClientDao dao) {
        this.dao = dao;
    }
}
