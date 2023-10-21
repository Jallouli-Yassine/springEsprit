package tn.esprit.tp1yassinejallouli4twin7.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Set;

@Entity
public class Foyer implements Serializable {
    @Setter
    @Getter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idFoyer;

    @OneToOne(mappedBy = "foyer")
    private Universite u;

    @OneToMany(mappedBy = "foyer")
    Set<Bloc> blocs;

    private String nomFoyer;

    private long capaciteFoyer;



}
