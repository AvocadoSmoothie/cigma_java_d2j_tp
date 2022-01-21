package service;

import model.Address;

import java.util.List;

public interface IAddressService {
    Address save(Address address);

    Address modify(Address address);

    void delete(long id);

    List<Address> getAll();

}
