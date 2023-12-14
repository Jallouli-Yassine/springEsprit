package tn.esprit.tp1yassinejallouli4twin7.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.tp1yassinejallouli4twin7.entities.Bloc;
import tn.esprit.tp1yassinejallouli4twin7.entities.Universite;
import tn.esprit.tp1yassinejallouli4twin7.services.IBlocService;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping("bloc")
@RestController
@CrossOrigin(origins = "*")
public class BlocRestController {

    private final IBlocService blocService;

    @GetMapping("/all")
    public List<Bloc> getAllBloc(){
        return blocService.getAllBlocs();
    }

    @PostMapping("/add")
    public Bloc addBloc(@RequestBody Bloc b){
        return blocService.ajouterBloc(b);
    }

    @PostMapping("/update")
    public Bloc updateBloc(@RequestBody Bloc b){
        return blocService.updateBloc(b);
    }

    @DeleteMapping ("/delete/{idBloc}")
    public void deleteBloc(@PathVariable Long idBloc){
        blocService.supprimerBloc(idBloc);
    }


    @PutMapping("/affecterChambresABloc/{nomBloc}")
    public Bloc affecterChambresABloc(@RequestBody List<Long> numChambre, @PathVariable String nomBloc) {
        return blocService.affecterChambresABloc(numChambre,nomBloc);
    }
    @PutMapping("/affecterBlocAFoyerApi/{nomBloc}/{nomFoyer}")
    public Bloc affecterBlocAFoyerApi( @PathVariable String nomBloc,@PathVariable String nomFoyer){
        return blocService.affecterBlocAFoyer(nomBloc,nomFoyer);
    }


    @GetMapping("/{idBloc}")
    public Bloc getBlocById(@PathVariable Long idBloc) {
        return blocService.getBlocById(idBloc);
    }

    @GetMapping("getbyNom/{nomBloc}")
    public Bloc getBlocByNom(@PathVariable String nomBloc) {
        return blocService.getBlocByNom(nomBloc);
    }


}
