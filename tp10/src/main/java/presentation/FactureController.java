package presentation;

import model.Facture;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import service.IFactureService;

import java.util.List;

@Controller
public class FactureController {
    @Autowired
    IFactureService service;

    public Facture save(Facture facture) {
        return service.save(facture);
    }

    public void modify(Facture facture) {
        service.modify(facture);
    }

    public void delete(long id) {
        service.delete(id);
    }

    public List<Facture> getAll() {
        return service.getAll();
    }

}
