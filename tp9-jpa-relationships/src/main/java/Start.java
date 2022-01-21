import model.Address;
import model.CarteFidelio;
import model.Client;
import model.Facture;
import model.LigneFacture;
import model.Produit;
import model.Promotion;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import presentation.ClientController;

import java.util.Arrays;
import java.util.List;

public class Start {
    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");
        ClientController ctr = (ClientController) ctx.getBean("clientController");
        Client client = new Client("OMAR");

        // addresses
        client.addAddress(new Address("H2", "Casa", "MA"));
        client.addAddress(new Address("M5", "Casa", "MA"));

        // ajout des facture
        List<Facture> factures = Arrays.asList(new Facture(1500.0, "facture1"), new
                Facture(2000.0, "facture2"));

        //produit
        Produit chocolate = new Produit("Choco", 0.5);
        Produit bimo = new Produit("Golden", 1D);

        //remplissage des facture
        for (Facture facture : factures) {
            facture.setClient(client);
            facture.addLigneFacture(new LigneFacture(10, chocolate));
            facture.addLigneFacture(new LigneFacture(2, bimo));
            client.addFacture(facture);
        }


        //Promotions
        List<Promotion> promotions = Arrays.asList(new Promotion("remise 10%"), new
                Promotion("solde 40%"));
        client.setPromotions(promotions);

        //Fidelio
        CarteFidelio carteFidelio = new CarteFidelio("A29930489");
        carteFidelio.setClient(client);
        client.setCarteFidelio(carteFidelio);


        //saving. should save all entities
        ctr.save(client);

    }

}
