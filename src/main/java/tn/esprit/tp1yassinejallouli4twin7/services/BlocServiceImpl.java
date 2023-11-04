package tn.esprit.tp1yassinejallouli4twin7.services;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import tn.esprit.tp1yassinejallouli4twin7.entities.Bloc;
import tn.esprit.tp1yassinejallouli4twin7.entities.Chambre;
import tn.esprit.tp1yassinejallouli4twin7.entities.Foyer;
import tn.esprit.tp1yassinejallouli4twin7.repositories.IBlocRepo;
import tn.esprit.tp1yassinejallouli4twin7.repositories.IChambreRepo;
import tn.esprit.tp1yassinejallouli4twin7.repositories.IFoyerRepo;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Primary
@AllArgsConstructor
@Service
public class BlocServiceImpl implements IBlocService{
    IBlocRepo blocRepo;
    IChambreRepo chambreRepo;
    IFoyerRepo foyerRepo;
    @Override
    public Bloc ajouterBloc(Bloc b) {
        return blocRepo.save(b);
    }

    @Override
    public Bloc updateBloc(Bloc b) {
        return blocRepo.save(b);
    }

    @Override
    public void supprimerBloc(long idBloc) {
        blocRepo.deleteById(idBloc);
    }

    @Override
    public Bloc getBloc(long idBloc) {
        return blocRepo.findById(idBloc).orElse(null);
    }

    @Override
    public List<Bloc> getAllBlocs() {
        return (List<Bloc>) blocRepo.findAll();
    }

    @Override
    @Transactional
    public Bloc affecterChambresABloc(List<Long> numChambre, String nomBloc) {
        Bloc b = blocRepo.findBlocByNomBloc(nomBloc);

        for (Long num : numChambre) {
            Chambre ch = chambreRepo.findChambreByNumeroChambre(num);
            if (ch != null) {
                ch.setBloc(b);
            }
        }
        return b;
    }

    @Override
    @Transactional
    public Bloc affecterBlocAFoyer(String nomBloc, String nomFoyer) {
        Bloc b = blocRepo.findBlocByNomBloc(nomBloc);
        Foyer f = foyerRepo.findFoyerByNomFoyer(nomFoyer);

        if(b!=null && f!=null){
            b.setFoyer(f);
             return b;
        }
        return  null;

    }

}
