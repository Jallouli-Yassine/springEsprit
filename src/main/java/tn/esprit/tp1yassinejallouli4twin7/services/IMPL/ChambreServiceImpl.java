package tn.esprit.tp1yassinejallouli4twin7.services.IMPL;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.tp1yassinejallouli4twin7.entities.*;
import tn.esprit.tp1yassinejallouli4twin7.repositories.IBlocRepo;
import tn.esprit.tp1yassinejallouli4twin7.repositories.IChambreRepo;
import tn.esprit.tp1yassinejallouli4twin7.repositories.IFoyerRepo;
import tn.esprit.tp1yassinejallouli4twin7.repositories.IReservationRepo;
import tn.esprit.tp1yassinejallouli4twin7.services.IChambreService;

import javax.management.Query;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Service
public class ChambreServiceImpl implements IChambreService {

    IChambreRepo chambreRepo;
    IBlocRepo blocRepo;
    IFoyerRepo foyerRepo;
    IReservationRepo reservationRepo;
    @PersistenceContext
    private EntityManager entityManager;

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

    @Override
    public List<Chambre> getChambresParNomBloc(String nomBloc) {
        Bloc b = blocRepo.findBlocByNomBloc(nomBloc);
        return new ArrayList<>(b.getChambres());
    }

    @Override
    public long nbChambreParTypeEtBloc(TypeChambre type, long idBloc) {
        Bloc b = blocRepo.findById(idBloc).orElse(null);
        int nb=0;
        for(Chambre ch :b.getChambres())
            if(ch.getTypeC()==type) nb++;
        return nb;
    }

    @Override
    public List<Chambre> getChambresNonReserveParNomFoyerEtTypeChambre(String nomFoyer, TypeChambre type) {
        Foyer f = foyerRepo.findFoyerByNomFoyer(nomFoyer);

        List<Chambre> NonResChambreList = new  ArrayList<>();
        f.getBlocs().forEach(bloc -> {
            bloc.getChambres().forEach(chambre -> {
                if (chambre.getTypeC()==type && chambre.getReservations().isEmpty()){
                    NonResChambreList.add(chambre);
                }
            });
        });
        return NonResChambreList;
    }
    @Override
    public List<Chambre> getChambresParBlocEtType(long idBloc, TypeChambre typeC) {
        Bloc b = blocRepo.findById(idBloc).orElse(null);

        return  chambreRepo.findByBlocAndTypeC(b,typeC);  }
}
