package tn.esprit.tp1yassinejallouli4twin7.repositories;

import org.springframework.data.repository.CrudRepository;
import tn.esprit.tp1yassinejallouli4twin7.entities.Reservation;

public interface IReservationRepo extends CrudRepository<Reservation,Long> {
}
