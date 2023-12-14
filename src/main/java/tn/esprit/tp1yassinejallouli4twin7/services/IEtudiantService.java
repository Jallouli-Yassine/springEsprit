package tn.esprit.tp1yassinejallouli4twin7.services;

import tn.esprit.tp1yassinejallouli4twin7.entities.Etudiant;

import java.util.List;

public interface IEtudiantService {
    /*
    Etudiant ajouterEtudiant(Etudiant et);
    Etudiant updateEtudiant(Etudiant et);
    void supprimerEtudiant(long idEtudiant);
    Etudiant getEtudiant(long idEtudiant);
    List<Etudiant> getAllEtudiants();

     */

    Etudiant AjouterEtudiant(Etudiant e);
    Boolean AjouterEtudiantAPI(Etudiant e);
    Etudiant UpdateEtudiant (Etudiant e);
    void SupprimerEtdiant (long idEtudiant);
    Etudiant GetEtudiant(long idEtudiant);
    List<Etudiant> GetAllEtudiant();
    Etudiant loginetudiant(String email, String password);
    Etudiant getEtudiant(long id );
    Etudiant etudiantBlocked(long id);
    Etudiant unblock(long id);
    Etudiant etatOflline(long id);
}
