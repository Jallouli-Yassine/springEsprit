package tn.esprit.tp1yassinejallouli4twin7.repositories;

import org.springframework.data.repository.CrudRepository;
import tn.esprit.tp1yassinejallouli4twin7.entities.Chambre;
import tn.esprit.tp1yassinejallouli4twin7.entities.Reservation;

public interface IChambreRepo extends CrudRepository<Chambre,Long> {
    Chambre findChambreByNumeroChambre(Long numero);
    Chambre findChambreByReservations(Reservation r);
}
