package tn.esprit.tp1yassinejallouli4twin7.services;

import tn.esprit.tp1yassinejallouli4twin7.entities.Reservation;

import java.util.Date;
import java.util.List;

public interface IReservationService {
    Reservation ajouterReservation(Reservation r);
    Reservation updateReservation(Reservation r);
    void supprimerReservation(Long idReservation);
    Reservation getReservation(Long idReservation);
    List<Reservation> getAllReservations();
    Reservation ajouterReservationEtAssignerAChambreEtAEtudiant (Reservation res, Long numChambre, long cin);
    long getReservationParAnneeUniversitaire(Date debutAnnee, Date finAnnee);
    Reservation ajouterReservation(long idChambre,long cinEtudiant);
    Reservation annulerReservation(long cinEtudiant);
}
