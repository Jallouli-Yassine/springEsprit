package tn.esprit.tp1yassinejallouli4twin7.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
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


    @OneToMany(mappedBy = "foyer",fetch = FetchType.EAGER, cascade = {CascadeType.PERSIST,CascadeType.REMOVE})
    Set<Bloc> blocs;

    private String nomFoyer;

    private long capaciteFoyer;



}
