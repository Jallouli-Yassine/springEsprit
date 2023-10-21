package tn.esprit.tp1yassinejallouli4twin7.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Set;

@Entity
public class Chambre implements Serializable {
    @Setter
    @Getter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idChambre;

    @ManyToOne
    private Bloc bloc;

    @OneToMany
    Set<Reservation> reservations;

    private long numeroChambre;
    private TypeChambre typeC;

}
