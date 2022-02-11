package dao;

import model.Facture;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class FactureDaoImpl implements IFactureDao {

    @PersistenceContext
    EntityManager em;

    @Override
    public Facture save(Facture facture) {
        em.persist(facture);
        return facture;
    }

    @Override
    public Facture update(Facture facture) {
        em.merge(facture);
        return facture;
    }

    @Override
    public List<Facture> findAll() {
        return em.createQuery("from Facture ", Facture.class).getResultList();
    }

    @Override
    public void deleteById(long id) {
        Facture facture = em.find(Facture.class, id);
        em.remove(facture);
    }
}
