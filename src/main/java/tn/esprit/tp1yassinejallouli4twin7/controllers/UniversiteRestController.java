package tn.esprit.tp1yassinejallouli4twin7.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.tp1yassinejallouli4twin7.entities.Universite;
import tn.esprit.tp1yassinejallouli4twin7.services.IUniversiteService;

import java.util.List;

@RequiredArgsConstructor //2eme lezem el final mawjouda
@RequestMapping("universite")
@RestController
@CrossOrigin(origins = "*")
public class UniversiteRestController {
    private final IUniversiteService universiteService;

    @GetMapping("/all")
    public List<Universite> getAllUniversite(){
        return universiteService.getAllUniversite();
    }

    @PostMapping("/add")
    public Universite addUniversite(@RequestBody Universite u){
        return universiteService.ajouterUniversite(u);
    }

    @PostMapping("/update")
    public Universite updateUniversite(@RequestBody Universite u){
        return universiteService.updateUniversite(u);
    }

    @DeleteMapping ("/delete/{idUniversite}")
    public void deleteUniversite(@PathVariable Long idUniversite){
        universiteService.supprimerUniversite(idUniversite);
    }
/*
    @PutMapping("/affecterFoyerAUniversite/{idFoyer}/{nomUniversite}")
    public Universite affecterFoyerAUniversite (@PathVariable long idFoyer,@PathVariable String nomUniversite) {
        return universiteService.affecterFoyerAUniversite(idFoyer,nomUniversite);
    }

 */
    @PutMapping("/desaffecterFoyerAUniversite/{idFoyer}/{idUniversite}")
    public Universite desaffecterFoyerAUniversite (@PathVariable long idFoyer,@PathVariable long idUniversite) {
        return universiteService.desaffecterFoyerAUniversite(idFoyer,idUniversite);
    }

    /*BAYOUDH*/
    @PutMapping("/affecterFoyerAUniversite/{idFoyer}/{iduv}")
    public Universite affecterFoyerAUniversite (@PathVariable long idFoyer,@PathVariable long iduv) {
        return universiteService.affecterFoyerAUniversite(idFoyer,iduv);
    }

    @GetMapping("/getOne/{id}")
    public Universite getFoyer(@PathVariable Long id){
        return universiteService.getUniversite(id);
    }


}
