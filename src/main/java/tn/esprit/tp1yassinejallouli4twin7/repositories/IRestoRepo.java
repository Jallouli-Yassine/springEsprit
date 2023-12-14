package tn.esprit.tp1yassinejallouli4twin7.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.tp1yassinejallouli4twin7.entities.Restaurant;

public interface IRestoRepo extends JpaRepository<Restaurant,Long> {

}
