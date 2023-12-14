package tn.esprit.tp1yassinejallouli4twin7.services.IMPL;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import tn.esprit.tp1yassinejallouli4twin7.entities.Foyer;
import tn.esprit.tp1yassinejallouli4twin7.entities.Restaurant;
import tn.esprit.tp1yassinejallouli4twin7.entities.Universite;
import tn.esprit.tp1yassinejallouli4twin7.repositories.IFoyerRepo;
import tn.esprit.tp1yassinejallouli4twin7.repositories.IRestoRepo;
import tn.esprit.tp1yassinejallouli4twin7.services.IRestoService;

import java.util.List;

@Primary
@RequiredArgsConstructor
@Service
public class RestaurantServiceImpl implements IRestoService {

    final IRestoRepo restoRepo;
    final IFoyerRepo foyerRepo;
    @Override
    public Restaurant ajouterResto(Restaurant r) {
        return restoRepo.save(r);
    }

    @Override
    public Restaurant updateResto(Restaurant r) {
        return restoRepo.save(r);
    }

    @Override
    public void supprimerResto(long idFoyer) {
        restoRepo.deleteById(idFoyer);
    }

    @Override
    public Restaurant getResto(long idFoyer) {
        return restoRepo.findById(idFoyer).orElse(null);
    }

    @Override
    public List<Restaurant> getAllResto() {
        return restoRepo.findAll();
    }

    @Override
    @Transactional
    public Restaurant ajouterRestoEtAffecterAplusiersFoyer(Restaurant r, List<Long> idFoyers) {
        this.ajouterResto(r);

        if(idFoyers!= null){
            for(long idFoyer : idFoyers){
                Foyer f = this.foyerRepo.findById(idFoyer).orElse(null);
                if (f != null) f.setResto(r);
            }
        }

        return r;
    }

    @Override
    public Restaurant getRestoOfFoyerDonner(long idFoyer) {
        Foyer f = foyerRepo.findById(idFoyer).orElse(null);
        if(f!=null && f.getResto()!=null){
            return f.getResto();

        }
        return null;
    }
}
