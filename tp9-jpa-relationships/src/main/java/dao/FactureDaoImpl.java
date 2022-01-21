package dao;

import model.Facture;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class FactureDaoImpl implements IFactureDao {
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("unit_tp9");
    EntityManager em = emf.createEntityManager();

    @Override
    public Facture save(Facture facture) {
        em.getTransaction().begin();
        em.persist(facture);
        em.getTransaction().commit();
        return facture;
    }

    @Override
    public Facture update(Facture facture) {
        em.getTransaction().begin();
        em.merge(facture);
        em.getTransaction().commit();
        return facture;
    }

    @Override
    public List<Facture> findAll() {
        return em.createQuery("from Facture ", Facture.class).getResultList();
    }

    @Override
    public void deleteById(long id) {
        em.getTransaction().begin();
        Facture facture = em.find(Facture.class, id);
        em.remove(facture);
        em.getTransaction().commit();
    }
}
