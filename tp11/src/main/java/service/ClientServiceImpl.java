package service;

import dao.IClientDao;
import model.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ClientServiceImpl implements IClientService {

    @Autowired
    IClientDao dao;

    @Override
    @Transactional
    public Client save(Client c) {
        return dao.save(c);
    }

    @Override
    @Transactional
    public Client modify(Client c) {
        return dao.save(c);
    }

    @Override
    public List<Client> getAll() {
        return dao.findAll();
    }

    @Override
    public List<Client> findByName(String name) {
        return dao.findByName(name);
    }
}
