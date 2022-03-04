package ma.cigma.frontend.controllers;

import ma.cigma.frontend.models.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;


@Controller
public class ClientController {

    @Value("${api.url}")
    private String apiUrl;
    @Autowired
    private RestTemplate restTemplate;

    @GetMapping(value = {"/", "/clients"})
    public String home(Model model, @ModelAttribute("client") Client client) {
        List<Client> clients = restTemplate.getForObject(apiUrl + "/client", List.class);
        if (client == null) {
            client = new Client();
        }
        model.addAttribute("clients", clients);
        model.addAttribute("client", client);
        return "index-client";
    }

    @GetMapping("/show-client/{id}")
    public String show(@PathVariable long id, RedirectAttributes redirectAttributes) {
        Client client = restTemplate.getForObject(apiUrl + "/client/" + id, Client.class);
        redirectAttributes.addFlashAttribute("client", client);
        return "redirect:/clients";
    }

    @PostMapping(value = "/add-client")
    public String addClient(Model model, @ModelAttribute("client") Client client) {
        restTemplate.postForObject(apiUrl + "/client", client, Client.class);
        return "redirect:/clients";
    }

    @GetMapping(value = {"/delete-client/{id}"})
    public String deleteClientById(Model model, @PathVariable long id) {
        restTemplate.delete(apiUrl + "/client/" + id);
        return "redirect:/clients";
    }

}



