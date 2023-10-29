package tn.esprit.tp1yassinejallouli4twin7.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.tp1yassinejallouli4twin7.entities.Foyer;
import tn.esprit.tp1yassinejallouli4twin7.services.IFoyerServices;

import java.util.List;

@RequiredArgsConstructor //2eme lezem el final mawjouda
@RequestMapping("foyer")
@RestController
public class FoyerRestController {
    private final IFoyerServices foyerServices;

    @GetMapping("/all")
    public List<Foyer> getAllFoyer(){
        return foyerServices.getAllFoyer();
    }

    @PostMapping("/add")
    public Foyer addFoyer(@RequestBody Foyer f){
        return foyerServices.ajouterFoyer(f);
    }

    @PostMapping("/update")
    public Foyer updateFoyer(@RequestBody Foyer f){
        return foyerServices.updateFoyer(f);
    }

    @DeleteMapping ("/delete/{idFoyer}")
    public void deleteFoyer(@PathVariable Long idFoyer){
         foyerServices.supprimerFoyer(idFoyer);
    }

}