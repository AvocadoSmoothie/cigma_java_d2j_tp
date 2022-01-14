package model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@Entity
public class Facture {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "col_date")
    private Date date;

    @Column
    private Double amount;

    public Facture() {
    }

    public Facture(Date date, Double amount) {
        this.date = date;
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "Facture{" +
                "id=" + id +
                ", date=" + date +
                ", amount=" + amount +
                '}';
    }
}
