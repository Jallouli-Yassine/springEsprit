package tn.esprit.tp1yassinejallouli4twin7.services;

import tn.esprit.tp1yassinejallouli4twin7.entities.Etudiant;

import java.util.List;

public interface IEtudiantService {
    Etudiant ajouterEtudiant(Etudiant et);
    Etudiant updateEtudiant(Etudiant et);
    void supprimerEtudiant(long idEtudiant);
    Etudiant getEtudiant(long idEtudiant);
    List<Etudiant> getAllEtudiants();
}
