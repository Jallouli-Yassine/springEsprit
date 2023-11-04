package tn.esprit.tp1yassinejallouli4twin7.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.tp1yassinejallouli4twin7.entities.Foyer;

public interface IFoyerRepo extends JpaRepository<Foyer,Long> {
    Foyer findFoyerByNomFoyer(String nomF);
}
