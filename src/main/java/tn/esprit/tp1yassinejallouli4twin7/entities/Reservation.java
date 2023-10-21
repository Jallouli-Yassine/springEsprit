package tn.esprit.tp1yassinejallouli4twin7.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

@Entity
public class Reservation implements Serializable {
    @Setter
    @Getter
    @Id
    private Long idReservation;

    @ManyToMany(mappedBy = "reservations")
    private Set<Etudiant> etudiants;

    private Date dateNaissance;

    private boolean estValid ;

}
