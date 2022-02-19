package model;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
@Entity
@Data
@PrimaryKeyJoinColumn(name="normal_id")
@NoArgsConstructor
public class ClientNormal extends Client{

    private int importanceLevel;

    public ClientNormal(String name, int importanceLevel) {
        super(name);
        this.importanceLevel = importanceLevel;
    }
}