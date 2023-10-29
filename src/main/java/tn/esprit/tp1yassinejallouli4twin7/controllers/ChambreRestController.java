package tn.esprit.tp1yassinejallouli4twin7.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.tp1yassinejallouli4twin7.entities.Bloc;
import tn.esprit.tp1yassinejallouli4twin7.entities.Chambre;
import tn.esprit.tp1yassinejallouli4twin7.services.IBlocService;
import tn.esprit.tp1yassinejallouli4twin7.services.IChambreService;

import java.util.List;

@RequiredArgsConstructor //2eme lezem el final mawjouda
@RequestMapping("chambre")
@RestController
public class ChambreRestController {
    private final IChambreService chambreService;

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

}
