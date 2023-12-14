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
public class Bloc implements Serializable {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long idBloc;

        private String nomBloc;

        private Long capaciteBloc;

        @JsonIgnore
        @ManyToOne(cascade = {CascadeType.PERSIST})
        private Foyer foyer;


        @OneToMany(mappedBy = "blocchambre", fetch =FetchType.EAGER, cascade ={CascadeType.PERSIST,CascadeType.REMOVE})
        Set<Chambre> chambres;

}

/*
* fama fetch lazy w eager : el max many par deafut lazy w max one par deafut eager
* */