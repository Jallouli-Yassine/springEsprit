package tn.esprit.tp1yassinejallouli4twin7.services;

import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import tn.esprit.tp1yassinejallouli4twin7.entities.Bloc;
import tn.esprit.tp1yassinejallouli4twin7.repositories.IBlocRepo;

import java.util.List;

@Primary
@AllArgsConstructor
@Service
public class BlocServiceImpl implements IBlocService{
    IBlocRepo blocRepo;
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
}
