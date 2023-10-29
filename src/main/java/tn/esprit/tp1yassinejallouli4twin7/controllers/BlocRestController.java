package tn.esprit.tp1yassinejallouli4twin7.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.tp1yassinejallouli4twin7.entities.Bloc;
import tn.esprit.tp1yassinejallouli4twin7.services.IBlocService;

import java.util.List;

@RequiredArgsConstructor //2eme lezem el final mawjouda
@RequestMapping("bloc")
@RestController
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

}
