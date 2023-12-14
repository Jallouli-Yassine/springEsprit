package tn.esprit.tp1yassinejallouli4twin7.DTO;

import jakarta.persistence.*;
import lombok.*;
import tn.esprit.tp1yassinejallouli4twin7.entities.EtatReservation;
import tn.esprit.tp1yassinejallouli4twin7.entities.Reservation;


import java.time.LocalDate;
import java.util.Date;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ReservationDTO {
    private Long idReservation;

    private String numReservation;

    private LocalDate debuteAnneUniversite;

    private LocalDate finAnneUniversite;

    private EtatReservation etat;

    private Long cinEtudiant;

    public ReservationDTO(Reservation reservation) {
        this.idReservation = reservation.getIdReservation();
        this.numReservation = reservation.getNumReservation();
        this.debuteAnneUniversite = reservation.getDebuteAnneUniversite();
        this.finAnneUniversite = reservation.getFinAnneUniversite();
        this.etat = reservation.getEtat();
        this.cinEtudiant = reservation.getEtudiants().iterator().next().getCin();
    }
}
