package be.ehb.apihalalrecepten.model.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@JsonIgnoreProperties("recepten")
public class Cook {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String naam;
    @OneToMany(mappedBy = "cook")
    private List<Recept> recepten = new ArrayList<>();

    public Cook() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNaam() {
        return naam;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }

    public List<Recept> getRecepten() {
        return recepten;
    }

    public void setRecepten(List<Recept> recepten) {
        this.recepten = recepten;
    }
}
