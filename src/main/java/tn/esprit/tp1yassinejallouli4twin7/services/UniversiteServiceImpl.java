package tn.esprit.tp1yassinejallouli4twin7.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.tp1yassinejallouli4twin7.entities.Universite;
import tn.esprit.tp1yassinejallouli4twin7.repositories.IUniversiteRepo;

import java.util.List;

@AllArgsConstructor
@Service
public class UniversiteServiceImpl implements IUniversiteService{

    IUniversiteRepo universiteRepo;
    @Override
    public Universite ajouterUniversite(Universite u) {
        return universiteRepo.save(u);
    }

    @Override
    public Universite updateUniversite(Universite u) {
        return universiteRepo.save(u);
    }

    @Override
    public void supprimerUniversite(long idUniversite) {
        universiteRepo.deleteById(idUniversite);
    }

    @Override
    public Universite getUniversite(long idUniversite) {
        return universiteRepo.findById(idUniversite).orElse(null);
    }

    @Override
    public List<Universite> getAllUniversite() {
        return (List<Universite>) universiteRepo.findAll();
    }
}
