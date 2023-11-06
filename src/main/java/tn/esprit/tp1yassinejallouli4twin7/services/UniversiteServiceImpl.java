package tn.esprit.tp1yassinejallouli4twin7.services;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.tp1yassinejallouli4twin7.entities.Foyer;
import tn.esprit.tp1yassinejallouli4twin7.entities.Universite;
import tn.esprit.tp1yassinejallouli4twin7.repositories.IFoyerRepo;
import tn.esprit.tp1yassinejallouli4twin7.repositories.IUniversiteRepo;

import java.util.List;

@AllArgsConstructor
@Service
public class UniversiteServiceImpl implements IUniversiteService{

    IUniversiteRepo universiteRepo;
    IFoyerRepo foyerRepo;
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

    @Override
    @Transactional
    public Universite affecterFoyerAUniversite(long idFoyer, String nomUniversite) {
        Universite u = universiteRepo.findUniversiteByNomUniversite(nomUniversite);
        u.setFoyer(foyerRepo.findById(idFoyer).orElse(null));
        return u;
    }
    //dima naadiw id mtaa parent f fnct ajout w desafecter

    @Override
    @Transactional
    public Universite desaffecterFoyerAUniversite(long idFoyer, long idUniversite) {
        Universite u = universiteRepo.findById(idUniversite).orElse(null);

        if(u!=null && u.getFoyer().getIdFoyer()==idFoyer )
            u.setFoyer(null);
        return u;
    }




}
