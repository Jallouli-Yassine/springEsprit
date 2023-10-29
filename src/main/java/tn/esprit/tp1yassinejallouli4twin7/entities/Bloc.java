package tn.esprit.tp1yassinejallouli4twin7.entities;

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

    @OneToMany(mappedBy = "bloc")
    Set <Chambre> chambres;

    @ManyToOne
    private Foyer foyer;
    private String nomBloc;

    private long capaciteBloc;

}
