package service;

import dao.IFactureDao;
import model.Facture;

import java.util.List;

public class IFactureServiceImpl implements IFactureService {

    IFactureDao dao;

    @Override
    public Facture save(Facture facture) {
        return dao.save(facture);
    }

    @Override
    public Facture modify(Facture facture) {
        return dao.update(facture);
    }

    @Override
    public void delete(long id) {
        dao.deleteById(id);
    }

    @Override
    public List<Facture> getAll() {
        return dao.findAll();
    }

    public void setDao(IFactureDao dao) {
        this.dao = dao;
    }
}
