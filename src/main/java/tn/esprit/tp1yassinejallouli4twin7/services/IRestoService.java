package tn.esprit.tp1yassinejallouli4twin7.services;

import tn.esprit.tp1yassinejallouli4twin7.entities.Foyer;
import tn.esprit.tp1yassinejallouli4twin7.entities.Restaurant;
import tn.esprit.tp1yassinejallouli4twin7.entities.Universite;

import java.util.List;

public interface IRestoService {
    Restaurant ajouterResto(Restaurant r);
    Restaurant updateResto(Restaurant r);
    void supprimerResto(long idResto);
    Restaurant getResto(long idResto);
    List<Restaurant> getAllResto();

    Restaurant ajouterRestoEtAffecterAplusiersFoyer(Restaurant r, List<Long> idFoyers);

    Restaurant getRestoOfFoyerDonner(long idFoyer);
}
