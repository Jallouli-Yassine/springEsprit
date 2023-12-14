package tn.esprit.tp1yassinejallouli4twin7.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Setter
@Getter
@Entity
public class Restaurant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idResto;

    private String nomResto;

    private String descriptionResto;

    private String telResto;

    @OneToMany(mappedBy = "resto", fetch = FetchType.EAGER)
    Set<Foyer> foyers;

}
