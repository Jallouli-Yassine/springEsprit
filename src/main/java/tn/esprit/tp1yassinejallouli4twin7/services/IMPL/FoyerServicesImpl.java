package tn.esprit.tp1yassinejallouli4twin7.services.IMPL;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import tn.esprit.tp1yassinejallouli4twin7.entities.Bloc;
import tn.esprit.tp1yassinejallouli4twin7.entities.Universite;
import tn.esprit.tp1yassinejallouli4twin7.repositories.IBlocRepo;
import tn.esprit.tp1yassinejallouli4twin7.repositories.IFoyerRepo;
import tn.esprit.tp1yassinejallouli4twin7.entities.Foyer;
import tn.esprit.tp1yassinejallouli4twin7.repositories.IUniversiteRepo;
import tn.esprit.tp1yassinejallouli4twin7.services.IBlocService;
import tn.esprit.tp1yassinejallouli4twin7.services.IFoyerServices;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Primary
//@AllArgsConstructor //2eme methode mta injec de dependance  w asah wahda ( nahi l final )
@RequiredArgsConstructor //2eme lezem el final mawjouda
@Service
public class FoyerServicesImpl implements IFoyerServices {

    //@Autowired 1er methode(par attribut) mta injec de dependance ama tmchy kken ala oel star tahtha
  final IFoyerRepo foyerRepository;
  final IUniversiteRepo universiteRepo;
  final IBlocService blocService;
  final IBlocRepo blocRepo;

    //2eme methode mta injec de dependance
    /*
    public FoyerServicesImpl(IFoyerRepository foyerRepository) {
        this.foyerRepository = foyerRepository;
    }*/

    @Override
    public Foyer ajouterFoyer(Foyer f) {
        return foyerRepository.save(f);
    }

    @Override
    public Foyer updateFoyer(Foyer f) {
        return foyerRepository.save(f);
    }

    @Override
    public void supprimerFoyer(long idFoyer) {
        foyerRepository.deleteById(idFoyer);
    }

    @Override
    public Foyer getFoyer(long idFoyer) {
        //maghir get bchy yarja optional bl get ywali Foyer
        //fama orElse kif mayalkach lobjet yraja excetpion
        return foyerRepository.findById(idFoyer).orElse(null);

    }

    @Override
    public List<Foyer> getAllFoyer() {
        return (List<Foyer>) foyerRepository.findAll();
    }

    @Override
    @Transactional
    public Foyer ajouterFoyerEtAffecterAUniversite(Foyer f, Long idUniv) {
        this.ajouterFoyer(f);

        //ajouter bloc et affecter au foyer
        for(Bloc b:f.getBlocs() ){
            this.blocService.ajouterBloc(b);
            b.setFoyer(f);
        }

        Universite u = universiteRepo.findById(idUniv).orElse(null);
        assert u != null;
        u.setFoyer(f);

        return f;
    }

}
