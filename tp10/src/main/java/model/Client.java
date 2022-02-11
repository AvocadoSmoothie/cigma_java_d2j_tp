package model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

@Getter
@Setter
@Entity
@ToString
@Inheritance(strategy = InheritanceType.JOINED)
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;

    @OneToMany(cascade = {CascadeType.PERSIST}, mappedBy = "client", orphanRemoval = true)
    private List<Address> addresses = new ArrayList<>();

    @OneToOne(cascade = {CascadeType.PERSIST}, mappedBy = "client")
    private CarteFidelio carteFidelio;

    @OneToMany(cascade = {CascadeType.PERSIST}, mappedBy = "client", orphanRemoval = true)
    private List<Facture> factures = new ArrayList<>();

    @ManyToMany(cascade = {CascadeType.PERSIST})
    @JoinTable(name = "my_join_table_client_promotion", joinColumns = @JoinColumn(
            name = "client_fk",
            referencedColumnName = "id"
    ),
            inverseJoinColumns = @JoinColumn(
                    name = "promotion_fk",
                    referencedColumnName = "id"
            ))
    private List<Promotion> promotions;

    public Client() {
    }

    public Client(String name) {
        this.name = name;
    }

    public void addFacture(Facture facture) {
        facture.setClient(this);
        factures.add(facture);
    }

    public void removeFacture(Facture facture) {
        facture.setClient(null);
        factures.remove(facture);
    }

    public void setFactures(List<Facture> factures) {
        Consumer<Facture> consumer = new Consumer<Facture>() {
            @Override
            public void accept(Facture facture) {
                facture.setClient(Client.this);
            }
        };
        factures.forEach(consumer);
        for (Facture facture : factures) {
            facture.setClient(this);
        }
        this.factures = factures;
    }


    public void addAddress(Address address) {
        address.setClient(this);
        addresses.add(address);
    }

}
