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
public class Prof implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String nom;

    private String prenom;

    private String email;

    private String password;

    private String tel;

    private Date dateNaissance;

    private String adresse;

    @ManyToMany(fetch = FetchType.EAGER)
    Set<Matiere> matieres;

    @ManyToOne(fetch = FetchType.EAGER)
    private Universite universite;




}
