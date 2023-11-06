package tn.esprit.tp1yassinejallouli4twin7.services;

import tn.esprit.tp1yassinejallouli4twin7.entities.Foyer;

import java.util.List;

public interface IFoyerServices {
    Foyer ajouterFoyer(Foyer f);
    Foyer updateFoyer(Foyer f);
    void supprimerFoyer(long idFoyer);
    Foyer getFoyer(long idFoyer);
    List<Foyer> getAllFoyer();

    public Foyer ajouterFoyerEtAffecterAUniversite(Foyer f,Long idUniv);

}
