package tn.esprit.tp1yassinejallouli4twin7.services.IMPL;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.tp1yassinejallouli4twin7.entities.Etudiant;
import tn.esprit.tp1yassinejallouli4twin7.repositories.IEtudiantRepo;
import tn.esprit.tp1yassinejallouli4twin7.services.IEtudiantService;

import java.util.List;

@AllArgsConstructor
@Service
public class EtudiantServiceImpl implements IEtudiantService {

    IEtudiantRepo etudiantRepo;

    @Override
    public Etudiant ajouterEtudiant(Etudiant et) {
        return etudiantRepo.save(et);
    }

    @Override
    public Etudiant updateEtudiant(Etudiant et) {
        return etudiantRepo.save(et);
    }

    @Override
    public void supprimerEtudiant(long idEtudiant) {
         etudiantRepo.deleteById(idEtudiant);
    }

    @Override
    public Etudiant getEtudiant(long idEtudiant) {
        return etudiantRepo.findById(idEtudiant).orElse(null);
    }

    @Override
    public List<Etudiant> getAllEtudiants() {
        return (List<Etudiant>) etudiantRepo.findAll();
    }
}
