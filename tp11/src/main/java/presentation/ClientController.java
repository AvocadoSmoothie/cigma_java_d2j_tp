package presentation;

import model.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import service.IClientService;

import java.util.List;

@Controller("clientController")
public class ClientController {

    @Autowired
    IClientService service;

    public Client save(Client client) {
        return service.save(client);
    }

    public void modify(Client c) {
        service.modify(c);
    }

    public List<Client> getAll() {
        return service.getAll();
    }
    public List<Client> findByName(String name) {
        return service.findByName(name);
    }
}
