package tn.esprit.tp1yassinejallouli4twin7.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.tp1yassinejallouli4twin7.entities.Restaurant;
import tn.esprit.tp1yassinejallouli4twin7.services.IRestoService;

import java.util.List;

@RequiredArgsConstructor //2eme lezem el final mawjouda
@RequestMapping("resto")
@RestController
@CrossOrigin(origins = "*") // Replace with your Angular app's URL
public class RestoRestController {
    private final IRestoService restoService;

    @GetMapping("/getOne/{idResto}")
    public Restaurant getResto(@PathVariable Long idResto){
        return restoService.getResto(idResto);
    }

    @GetMapping("/all")
    public List<Restaurant> getAllResto(){
        return restoService.getAllResto();
    }

    @GetMapping("/getRestoOfFoyerDonner/{idFoyer}")
    public Restaurant getRestoOfFoyerDonnerApi(@PathVariable long idFoyer){
        return restoService.getRestoOfFoyerDonner(idFoyer);
    }

    @PostMapping("/add")
    public Restaurant addResto(@RequestBody Restaurant r){
        return restoService.ajouterResto(r);
    }

    @PostMapping("/update")
    public Restaurant updateResto(@RequestBody Restaurant r){
        return restoService.updateResto(r);
    }

    @DeleteMapping ("/delete/{idResto}")
    public void deleteFoyer(@PathVariable Long idResto){
        restoService.supprimerResto(idResto);
    }

    @PostMapping ("/ajouterRestoEtAffecterAplusiersFoyer")
    public Restaurant ajouterRestoEtAffecterAplusiersFoyerApi(@RequestBody Restaurant r, @RequestParam List<Long> foyers){
       return restoService.ajouterRestoEtAffecterAplusiersFoyer(r, foyers);
    }
}
