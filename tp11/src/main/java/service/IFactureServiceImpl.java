package service;

import dao.IFactureDao;
import model.Facture;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class IFactureServiceImpl implements IFactureService {

    @Autowired
    IFactureDao dao;

    @Override
    @Transactional
    public Facture save(Facture facture) {
        return dao.save(facture);
    }

    @Override
    @Transactional
    public Facture modify(Facture facture) {
        return dao.save(facture);
    }

    @Override
    @Transactional
    public void delete(long id) {
        dao.deleteById(id);
    }

    @Override
    public List<Facture> getAll() {
        return dao.findAll();
    }
    @Override
    public List<Facture> findByClientId(Long id) {
        return dao.findByClient_Id(id);
    }

}
