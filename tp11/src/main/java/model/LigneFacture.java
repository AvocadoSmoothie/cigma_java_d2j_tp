package model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
public class LigneFacture {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private Integer qte;

    @ManyToOne
    private Facture facture;

    @ManyToOne(cascade = {CascadeType.PERSIST})
    private Produit produit;

    public LigneFacture(Integer qte, Produit produit) {
        this.qte = qte;
        this.produit = produit;
    }
}
