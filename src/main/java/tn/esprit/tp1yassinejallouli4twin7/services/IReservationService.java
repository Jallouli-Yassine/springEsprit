package tn.esprit.tp1yassinejallouli4twin7.services;

import tn.esprit.tp1yassinejallouli4twin7.entities.Reservation;

import java.util.List;

public interface IReservationService {
    Reservation ajouterReservation(Reservation r);
    Reservation updateReservation(Reservation r);
    void supprimerReservation(Long idReservation);
    Reservation getReservation(Long idReservation);
    List<Reservation> getAllReservations();
}
