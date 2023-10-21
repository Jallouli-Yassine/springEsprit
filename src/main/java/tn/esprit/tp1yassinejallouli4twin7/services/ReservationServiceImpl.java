package tn.esprit.tp1yassinejallouli4twin7.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.tp1yassinejallouli4twin7.entities.Reservation;
import tn.esprit.tp1yassinejallouli4twin7.repositories.IReservationRepo;

import java.util.List;

@AllArgsConstructor
@Service
public class ReservationServiceImpl implements IReservationService{

    IReservationRepo reservationRepo;

    @Override
    public Reservation ajouterReservation(Reservation r) {
        return reservationRepo.save(r);
    }

    @Override
    public Reservation updateReservation(Reservation r) {
        return reservationRepo.save(r);
    }

    @Override
    public void supprimerReservation(Long idReservation) {
         reservationRepo.deleteById(idReservation);
    }

    @Override
    public Reservation getReservation(Long idReservation) {
        return reservationRepo.findById(idReservation).orElse(null);
    }

    @Override
    public List<Reservation> getAllReservations() {
        return (List<Reservation>) reservationRepo.findAll();
    }
}
