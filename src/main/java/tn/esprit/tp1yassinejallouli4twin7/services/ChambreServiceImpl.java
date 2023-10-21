package tn.esprit.tp1yassinejallouli4twin7.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.tp1yassinejallouli4twin7.entities.Chambre;
import tn.esprit.tp1yassinejallouli4twin7.repositories.IChambreRepo;

import java.util.List;

@AllArgsConstructor
@Service
public class ChambreServiceImpl implements IChambreService{

    IChambreRepo chambreRepo;

    @Override
    public Chambre ajouterChambre(Chambre ch) {
        return chambreRepo.save(ch);
    }

    @Override
    public Chambre updateChambre(Chambre ch) {
        return chambreRepo.save(ch);
    }

    @Override
    public void supprimerChambre(long idChambre) {
        chambreRepo.deleteById(idChambre);
    }

    @Override
    public Chambre getChambre(long idChambre) {
        return chambreRepo.findById(idChambre).orElse(null);
    }

    @Override
    public List<Chambre> getAllChambres() {
        return (List<Chambre>) chambreRepo.findAll();
    }
}
