package tp.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter

@NoArgsConstructor
public class Facture {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private Double amount;

    private String description;

    @ManyToOne
    private Client client;

    @OneToMany(cascade = {CascadeType.PERSIST}, mappedBy = "facture")
    private List<LigneFacture> ligneFactures = new ArrayList<>();

    public Facture(Double amount, String description) {
        this.amount = amount;
        this.description = description;
    }

    public Facture(Double amount, String description, Client client) {
        this.amount = amount;
        this.description = description;
        this.client = client;
    }

    public Double getAmount() {
        return amount;
    }

    public void addLigneFacture(LigneFacture ligneFacture) {
        ligneFacture.setFacture(this);
        ligneFactures.add(ligneFacture);
    }

    @Override
    public String toString() {
        return "Facture{" +
                "id=" + id +
                ", amount=" + amount +
                ", description='" + description + '\'' +
                ", client=" + client +
                '}';
    }
}
