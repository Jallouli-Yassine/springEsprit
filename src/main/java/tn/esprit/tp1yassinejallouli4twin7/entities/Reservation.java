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
    @JsonIgnore
    @ManyToMany(mappedBy = "reservations")
    private Set<Etudiant> etudiants;

    private Date dateReservation;

    private String numReservation;


    @Temporal(TemporalType.DATE)
    private LocalDate debuteAnneUniversite;

    @Temporal(TemporalType.DATE)
    private LocalDate finAnneUniversite;

    private boolean estValid ;

}
