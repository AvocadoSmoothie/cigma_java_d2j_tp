package presentation;

import dao.IClientDao;
import model.Client;
import service.IClientService;

import java.util.List;

public class ClientController {
    IClientService service;

    public Client save(Client client) {
        return service.save(client);
    }

    public void setService(IClientService service) {
        this.service = service;
    }

    public void modify(Client c){
        service.modify(c);
    }

    public List<Client> getAll() {
        return service.getAll();
    }
}
