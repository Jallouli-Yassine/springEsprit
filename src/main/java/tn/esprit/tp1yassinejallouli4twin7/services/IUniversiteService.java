package tn.esprit.tp1yassinejallouli4twin7.services;

import tn.esprit.tp1yassinejallouli4twin7.entities.Universite;

import java.util.List;

public interface IUniversiteService {
    Universite ajouterUniversite(Universite u);
    Universite updateUniversite(Universite u);
    void supprimerUniversite(long idUniversite);
    Universite getUniversite(long idUniversite);
    List<Universite> getAllUniversite();
}
