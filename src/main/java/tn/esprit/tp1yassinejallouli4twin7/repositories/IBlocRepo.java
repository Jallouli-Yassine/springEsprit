package tn.esprit.tp1yassinejallouli4twin7.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import tn.esprit.tp1yassinejallouli4twin7.entities.Bloc;
import tn.esprit.tp1yassinejallouli4twin7.entities.Foyer;

import java.util.List;

public interface IBlocRepo extends CrudRepository<Bloc,Long> {
    Bloc findBlocByNomBloc(String nom);

    @Query("SELECT b FROM Bloc b LEFT JOIN b.foyer")
    List<Bloc> findAllWithFoyer();

    Bloc getBlocByIdBloc(long idBloc);


    Bloc getBlocByNomBloc(String nomBloc);

    /*KAMEL*/
    Bloc findByNomBloc(String nombloc);
    List<Bloc> findByFoyer(Foyer foyer);


}
