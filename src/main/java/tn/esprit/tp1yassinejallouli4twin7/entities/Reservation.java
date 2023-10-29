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
public class Reservation implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idReservation;

    @ManyToMany(mappedBy = "reservations")
    private Set<Etudiant> etudiants;

    private Date dateReservation;

    private boolean estValid ;

}
