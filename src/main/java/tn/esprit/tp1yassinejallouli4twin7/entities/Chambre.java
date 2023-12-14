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
public class Chambre implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idChambre;

    @JsonIgnoreProperties("chambres")
    @ManyToOne
    private Bloc blocchambre;

    @JsonIgnore
    @OneToMany
    Set<Reservation> reservations;

    private long numeroChambre;

    @Enumerated(EnumType.STRING)
    private TypeChambre typeC;

}
