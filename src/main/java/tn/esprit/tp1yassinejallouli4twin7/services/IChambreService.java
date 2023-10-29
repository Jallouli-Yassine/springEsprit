package tn.esprit.tp1yassinejallouli4twin7.services;

import tn.esprit.tp1yassinejallouli4twin7.entities.Chambre;

import java.util.List;

public interface IChambreService {
    Chambre ajouterChambre(Chambre ch);
    Chambre updateChambre(Chambre ch);
    void supprimerChambre(long idChambre);
    Chambre getChambre(long idChambre);
    List<Chambre> getAllChambres();
}
