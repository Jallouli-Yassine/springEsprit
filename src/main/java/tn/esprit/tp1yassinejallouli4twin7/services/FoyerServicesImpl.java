package tn.esprit.tp1yassinejallouli4twin7.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.tp1yassinejallouli4twin7.repositories.IFoyerRepo;
import tn.esprit.tp1yassinejallouli4twin7.entities.Foyer;

import java.util.List;

//@AllArgsConstructor //2eme methode mta injec de dependance  w asah wahda ( nahi l final )
@RequiredArgsConstructor //2eme lezem el final mawjouda
@Service
public class FoyerServicesImpl implements IFoyerServices{

    //@Autowired 1er methode(par attribut) mta injec de dependance ama tmchy kken ala oel star tahtha
  final IFoyerRepo foyerRepository;

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
}
