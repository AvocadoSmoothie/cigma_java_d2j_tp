package presentation;

import model.Address;
import service.IAddressService;

import java.util.List;

public class AddressController {
    IAddressService service;

    public Address save(Address address) {
        return service.save(address);
    }

    public void setService(IAddressService service) {
        this.service = service;
    }

    public void modify(Address address){
        service.modify(address);
    }

    public void delete(long id){
        service.delete(id);
    }

    public List<Address> getAll() {
        return service.getAll();
    }

}
