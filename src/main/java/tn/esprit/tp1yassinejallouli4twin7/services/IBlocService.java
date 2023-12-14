package tn.esprit.tp1yassinejallouli4twin7.services;

import tn.esprit.tp1yassinejallouli4twin7.entities.Bloc;

import java.util.List;

public interface IBlocService {
    Bloc ajouterBloc(Bloc b);
    Bloc updateBloc(Bloc b);
    void supprimerBloc(long idBloc);
    Bloc getBloc(long idBloc);
    List<Bloc> getAllBlocs();
    Bloc affecterChambresABloc(List<Long> numChambre, String nomBloc);



    List<Bloc> getAllblocsWithFoyer();

    Bloc affecterBlocAFoyer( String nomBloc, String nomFoyer) ;

    Bloc getBlocById (long idBloc);

    Bloc getBlocByNom(String nomBloc);

}
