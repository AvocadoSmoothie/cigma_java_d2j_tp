package tp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tp.dao.ICompteDao;
import tp.model.Compte;

import java.util.List;

@Service
public class CompteServiceImpl implements ICompteService {

    @Autowired
    ICompteDao dao;

    @Override
    @Transactional
    public Compte save(Compte c) {
        return dao.save(c);
    }

    @Override
    @Transactional
    public Compte modify(Compte c) {
        return dao.save(c);
    }

    @Override
    public List<Compte> getAll() {
        return dao.findAll();
    }

    @Override
    public Compte getOne(long id) {
        return dao.findById(id).orElse(null);
    }
}
