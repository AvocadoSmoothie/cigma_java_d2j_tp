package model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

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
@ToString
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

    public Facture() {
    }

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
}
