package tn.esprit.tp1yassinejallouli4twin7.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
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

    private String nomEt;

    private String prenomet;

    private long cin;

    private String ecole;

    private Date dateNaissance;

    private String email;

    private String passoword;

    private long etat;

    private String role;

    @JsonIgnore
    @ManyToMany(cascade = {CascadeType.PERSIST},fetch = FetchType.EAGER)
    private Set<Reservation> reservations;
}
