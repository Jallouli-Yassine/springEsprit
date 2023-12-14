package tn.esprit.tp1yassinejallouli4twin7.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import tn.esprit.tp1yassinejallouli4twin7.entities.Bloc;
import tn.esprit.tp1yassinejallouli4twin7.entities.Foyer;

public interface IFoyerRepo extends JpaRepository<Foyer, Long>, JpaSpecificationExecutor<Foyer> {
    Foyer findFoyerByNomFoyer(String nomF);
long findByNomFoyer(String nom);
}
