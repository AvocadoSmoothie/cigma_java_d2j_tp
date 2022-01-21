import model.Client;
import model.Facture;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import presentation.AddressController;
import presentation.ClientController;
import presentation.FactureController;

import java.util.Date;
import java.util.List;

public class Start {
    public static void main(String[] args) {
        ApplicationContext context= new
                ClassPathXmlApplicationContext("spring.xml");
        testClient(context);
        testFacture(context);

        testClientWithAddress(context);

    }

    private static void testClientWithAddress(ApplicationContext context) {

        AddressController controller = (AddressController) context.getBean("addressController");
    }

    private static void testFacture(ApplicationContext context) {
        FactureController controller = (FactureController) context.getBean("factureController");

        Facture f1 = controller.save(new Facture(new Date(), 8000D));
        Facture f2 = controller.save(new Facture(new Date(), 100D));
        Facture f3 = controller.save(new Facture(new Date(), 185.88D));
        List<Facture> factures = controller.getAll();
        for(Facture facture: factures) {
            System.out.println(facture);
        }
        Facture toModify = factures.get(0);
        toModify.setAmount(266D);
        controller.modify(toModify);

        controller.delete(factures.get(1).getId());
    }

    private static void testClient(ApplicationContext context) {
        ClientController ctrl = (ClientController)
                context.getBean("idCtrl");
        Client c1 = ctrl.save(new Client("OMAR"));
        Client c2 = ctrl.save(new Client("SIHAM"));
        Client c3 = ctrl.save(new Client("AHMED"));
        Client c4 = ctrl.save(new Client("FARAH"));
// Test modify use case for client with id==1
        ctrl.modify(new Client(c1.getId(),"new Name_"));
        List<Client> clients = ctrl.getAll();
        for(Client client: clients) {
            System.out.println(client);
        }
    }

}
