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
public class Bloc implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idBloc;


    @OneToMany(mappedBy = "bloc",fetch = FetchType.EAGER, cascade = {CascadeType.PERSIST,CascadeType.REMOVE})
    Set <Chambre> chambres;

    @JsonIgnore
    @ManyToOne(cascade = {CascadeType.PERSIST})
    private Foyer foyer;

    private String nomBloc;

    private long capaciteBloc;

}

/*
* fama fetch lazy w eager : el max many par deafut lazy w max one par deafut eager
* */