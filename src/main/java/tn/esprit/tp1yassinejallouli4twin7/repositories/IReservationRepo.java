package tn.esprit.tp1yassinejallouli4twin7.repositories;

import org.springframework.data.repository.CrudRepository;
import tn.esprit.tp1yassinejallouli4twin7.entities.Etudiant;
import tn.esprit.tp1yassinejallouli4twin7.entities.Reservation;

import java.util.Date;
import java.util.List;

public interface IReservationRepo extends CrudRepository<Reservation,Long> {
    List<Reservation> findByDateReservationBetween(Date dateDebut,Date dateFin);
    List<Reservation> findByEtudiants(Etudiant e);
}
