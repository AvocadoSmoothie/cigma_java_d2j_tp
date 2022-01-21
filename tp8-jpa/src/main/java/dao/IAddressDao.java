package dao;


import model.Address;

import java.util.List;

public interface IAddressDao {
    Address save(Address address);
    Address update(Address address);
    List<Address> findAll();
    void deleteById(long id);
}

