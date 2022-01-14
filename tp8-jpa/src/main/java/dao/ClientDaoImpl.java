package dao;

import model.Client;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class ClientDaoImpl implements IClientDao {
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("unit_clients");
    EntityManager em = emf.createEntityManager();


    @Override
    public Client save(Client c) {
        em.getTransaction().begin();
        em.persist(c);
        em.getTransaction().commit();
        return c;
    }

    @Override
    public Client update(Client c) {

        em.getTransaction().begin();
        em.merge(c);
        em.getTransaction().commit();
        return c;
    }

    @Override
    public List<Client> findAll() {
        return em.createQuery("from TClients ", Client.class).getResultList();
    }

}
