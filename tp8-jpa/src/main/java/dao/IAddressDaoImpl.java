package dao;

import model.Address;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class IAddressDaoImpl implements IAddressDao {

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("unit_clients");
    EntityManager em = emf.createEntityManager();
    @Override
    public Address save(Address address) {
        em.getTransaction().begin();
        em.persist(address);
        em.getTransaction().commit();
        return address;
    }

    @Override
    public Address update(Address address) {
        em.getTransaction().begin();
        em.merge(address);
        em.getTransaction().commit();
        return address;
    }

    @Override
    public List<Address> findAll() {
        return em.createQuery("from Address ", Address.class).getResultList();
    }

    @Override
    public void deleteById(long id) {
        em.getTransaction().begin();
        Address address = em.find(Address.class,id);
        em.remove(address);
        em.getTransaction().commit();
    }
}
