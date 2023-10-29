package tn.esprit.tp1yassinejallouli4twin7.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;
@Setter
@Getter
@Entity
public class Etudiant implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idEtudiant;

    @ManyToMany
    private Set <Reservation> reservations;

    private String nomEt;

    private String prenomEt;

    private long cin;

    private String ecole;

    private Date dateNaissance;

}
