package tn.esprit.tp1yassinejallouli4twin7.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.tp1yassinejallouli4twin7.entities.Bloc;
import tn.esprit.tp1yassinejallouli4twin7.entities.Chambre;
import tn.esprit.tp1yassinejallouli4twin7.entities.TypeChambre;
import tn.esprit.tp1yassinejallouli4twin7.services.IBlocService;
import tn.esprit.tp1yassinejallouli4twin7.services.IChambreService;

import java.util.List;

@RequiredArgsConstructor //2eme lezem el final mawjouda
@RequestMapping("chambre")
@RestController
@CrossOrigin(origins = "*")
public class ChambreRestController {
    private final IChambreService chambreService;
/*
    @GetMapping("/all")
    public List<Chambre> getAleChambre(){
        return chambreService.getAllChambres();
    }

    @PostMapping("/add")
    public Chambre adeChambre(@RequestBody Chambre ch){
        return chambreService.ajouterChambre(ch);
    }

    @PostMapping("/update")
    public Chambre updateChambre(@RequestBody Chambre ch){
        return chambreService.updateChambre(ch);
    }

    @DeleteMapping ("/delete/{idChambre}")
    public void deleteChambre(@PathVariable Long idChambre){
        chambreService.supprimerChambre(idChambre);
    }
    @GetMapping ("/getChambresParNomBloc/{nomBloc}")
    public List<Chambre> getChambresParNomBlocApi(@PathVariable String nomBloc){
        return chambreService.getChambresParNomBloc(nomBloc);
    }
    @GetMapping ("/getChambresParNomBloc/{type}/{idBloc}")
    public long nbChambreParTypeEtBloc(@PathVariable TypeChambre type,@PathVariable long idBloc){
        return chambreService.nbChambreParTypeEtBloc(type,idBloc);
    }
    @GetMapping ("/getChambresNonReserveParNomFoyerEtTypeChambre/{nomFoyer}/{type}")
    public List<Chambre> getChambresNonReserveParNomFoyerEtTypeChambreApi(@PathVariable String nomFoyer,@PathVariable TypeChambre type){
        return chambreService.getChambresNonReserveParNomFoyerEtTypeChambre(nomFoyer,type);
    }
    @GetMapping ("/getChambresParBlocEtType/{idBloc}/{type}")
    public List<Chambre> getChambresParBlocEtTypeApi(@PathVariable long idBloc,@PathVariable TypeChambre type){
        return chambreService.getChambresParBlocEtType(idBloc,type);
    }
*/

/*yosr*/
    @GetMapping("getChambresNonAffecter")
    public List<Chambre> getChambresNonAffecter(){
        return chambreService.getChambresNonAffecter();
    }

    /*kamel*/
    @GetMapping("/all")
    public List<Chambre> getAleChambre(){
        return chambreService.getAllChambres();
    }

    @PostMapping("/add")
    public Chambre addChambre(@RequestBody Chambre ch){
        return chambreService.ajouterChambre(ch);
    }

    @PostMapping("/update")
    public Chambre updateChambre(@RequestBody Chambre ch){
        return chambreService.updateChambre(ch);
    }

    @DeleteMapping ("/delete/{idChambre}")
    public void deleteChambre(@PathVariable Long idChambre){
        chambreService.supprimerChambre(idChambre);
    }


    @GetMapping("getChambresParNomBloc/{nomBloc}")
    public List<Chambre> getChambresParNomBloc(@PathVariable String nomBloc){
        return chambreService.getChambresParNomBloc(nomBloc);

    }

    @GetMapping("nbChambreParTypeEtBloc/{type}/{idbloc}")
    public long nbChambreParTypeEtBloc(@PathVariable TypeChambre type, @PathVariable long idbloc){
        return chambreService.nbChambreParTypeEtBloc(type,idbloc);

    }

    @GetMapping("getChambresNonReserveParNomFoyerEtTypeChambre/{nomFoyer}/{type}")
    public List<Chambre> getChambresNonReserveParNomFoyerEtTypeChambre(@PathVariable String nomFoyer, @PathVariable TypeChambre type){
        return chambreService.getChambresNonReserveParNomFoyerEtTypeChambre(nomFoyer,type);

    }
    @GetMapping("getChambresParBlocEtType/{idBloc}/{typeC}")
    public List<Chambre> getChambresParBlocEtType(@PathVariable long idBloc, @PathVariable TypeChambre typeC){
        return chambreService.getChambresParBlocEtType(idBloc,typeC);

    }
    @GetMapping("getChambresParId/{idChambre}")
    public Chambre getChambresParId(@PathVariable long idChambre){
        return chambreService.getChambreParId(idChambre);
    }

}
