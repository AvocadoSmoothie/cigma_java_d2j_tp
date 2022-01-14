import model.Client;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import presentation.ClientController;

public class Start {
    public static void main(String[] args) {
        ApplicationContext context= new
                ClassPathXmlApplicationContext("spring.xml");
        ClientController ctrl = (ClientController)
                context.getBean("idCtrl");
        Client c1 = ctrl.save(new Client("OMAR"));
        Client c2 = ctrl.save(new Client("SIHAM"));
        Client c3 = ctrl.save(new Client("AHMED"));
        Client c4 = ctrl.save(new Client("FARAH"));
// Test modify use case for client with id==1
        ctrl.modify(new Client(c1.getId(),"new Name_"));
    }

}
