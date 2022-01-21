package presentation;

import model.Facture;
import service.IFactureService;

import java.util.List;

public class FactureController {
    IFactureService service;

    public Facture save(Facture facture) {
        return service.save(facture);
    }

    public void setService(IFactureService service) {
        this.service = service;
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
