package service;

import dao.IAddressDao;
import model.Address;

import java.util.List;

public class IAddressServiceImpl implements IAddressService {

    IAddressDao dao;
    @Override
    public Address save(Address address) {
        return dao.save(address);
    }

    @Override
    public Address modify(Address address) {
        return dao.update(address);
    }

    @Override
    public void delete(long id) {
        dao.deleteById(id);
    }

    @Override
    public List<Address> getAll() {
        return dao.findAll();
    }

    public void setDao(IAddressDao dao) {
        this.dao = dao;
    }
}
