package tn.esprit.tp1yassinejallouli4twin7.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;
import java.util.Set;
@Setter
@Getter
@Entity
public class Reservation implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idReservation;

    private Date dateReservation;

    private String numReservation;


    @Temporal(TemporalType.DATE)
    private LocalDate debuteAnneUniversite;

    @Temporal(TemporalType.DATE)
    private LocalDate finAnneUniversite;

    private boolean estValid ;


    /*nejd*/



    @Temporal(TemporalType.DATE)
    private Date anneeUniversitaire;

    private String description;

    private String email;

    private String phone;

    @Enumerated(EnumType.STRING)
    private EtatReservation etat;

    @Enumerated(EnumType.STRING)
    private TypePayment typePayment;

    @Enumerated(EnumType.STRING)
    private TypeRepat typeRepat;

    @JsonIgnore
    @ManyToMany
    private Set<Etudiant> etudiants;
}