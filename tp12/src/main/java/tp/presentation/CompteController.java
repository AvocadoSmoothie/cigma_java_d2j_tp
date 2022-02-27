package tp.presentation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import tp.model.Compte;
import tp.service.ICompteService;

import java.util.List;

@RestController
@RequestMapping("/compte")
public class CompteController {

    @Autowired
    ICompteService service;

    @PostMapping
    public Compte save(@RequestBody Compte client) {
        return service.save(client);
    }

    @PutMapping
    public void modify(@RequestBody Compte c) {
        service.modify(c);
    }

    @GetMapping
    public List<Compte> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public Compte getOne(@PathVariable("id") long id) {
        return service.getOne(id);
    }

}
