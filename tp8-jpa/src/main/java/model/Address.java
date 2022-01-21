package model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Getter
@Setter
@AllArgsConstructor
@Entity
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String description;

    @ManyToOne(cascade = {})
    private Client client;

    public Address() {
    }

    public Address(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Address{" +
                "id=" + id +
                ", description='" + description + '\'' +
                '}';
    }
}
