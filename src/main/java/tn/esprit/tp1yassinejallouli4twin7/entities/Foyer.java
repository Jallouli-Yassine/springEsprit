package tn.esprit.tp1yassinejallouli4twin7.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Set;
@Setter
@Getter
@Entity
public class Foyer implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idFoyer;

    @OneToOne(mappedBy = "foyer")
    @JsonIgnore
    private Universite u;

    @JsonIgnore
    @ManyToOne
    private Restaurant resto;


    @JsonIgnoreProperties("foyer")
    @OneToMany(mappedBy = "foyer",fetch = FetchType.EAGER, cascade = {CascadeType.PERSIST,CascadeType.REMOVE})
    Set<Bloc> blocs;

    private String nomFoyer;

    private long capaciteFoyer;

    private long etat;


}
