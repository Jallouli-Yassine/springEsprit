package tn.esprit.tp1yassinejallouli4twin7.repositories;

import org.springframework.data.repository.CrudRepository;
import tn.esprit.tp1yassinejallouli4twin7.entities.Bloc;
import tn.esprit.tp1yassinejallouli4twin7.entities.Chambre;
import tn.esprit.tp1yassinejallouli4twin7.entities.Reservation;
import tn.esprit.tp1yassinejallouli4twin7.entities.TypeChambre;

import java.util.List;

public interface IChambreRepo extends CrudRepository<Chambre,Long> {
    Chambre findChambreByNumeroChambre(Long numero);
    Chambre findChambreByReservations(Reservation r);
    List<Chambre> findByBlocAndTypeC(Bloc b, TypeChambre t);
}
