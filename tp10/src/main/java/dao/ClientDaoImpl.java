package dao;

import model.Client;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class ClientDaoImpl implements IClientDao {

    @PersistenceContext
    EntityManager em;


    @Override
    public Client save(Client c) {
        em.persist(c);
        return c;
    }

    @Override
    public Client update(Client c) {
        em.merge(c);
        return c;
    }

    @Override
    public void deleteById(long idClient) {
        Client clientInDataBase = em.find(Client.class, idClient);
        em.remove(clientInDataBase);
    }

    @Override
    public List<Client> findAll() {
        return em.createQuery("from Client", Client.class).getResultList();
    }

}
