package tn.esprit.tp1yassinejallouli4twin7.services;

import tn.esprit.tp1yassinejallouli4twin7.entities.Chambre;
import tn.esprit.tp1yassinejallouli4twin7.entities.TypeChambre;

import java.util.List;

public interface IChambreService {
    Chambre ajouterChambre(Chambre ch);
    Chambre updateChambre(Chambre ch);
    void supprimerChambre(long idChambre);
    Chambre getChambre(long idChambre);
    List<Chambre> getAllChambres();
    List<Chambre> getChambresParNomBloc( String nomBloc);
    long nbChambreParTypeEtBloc(TypeChambre type, long idBloc) ;
    List<Chambre> getChambresNonReserveParNomFoyerEtTypeChambre( String nomFoyer,TypeChambre type);
}
