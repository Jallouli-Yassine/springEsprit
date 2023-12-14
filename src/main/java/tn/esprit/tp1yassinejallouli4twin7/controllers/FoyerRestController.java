package tn.esprit.tp1yassinejallouli4twin7.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.esprit.tp1yassinejallouli4twin7.entities.Foyer;
import tn.esprit.tp1yassinejallouli4twin7.services.IFoyerServices;

import java.util.List;

@RequiredArgsConstructor //2eme lezem el final mawjouda
@RequestMapping("foyer")
@RestController
@CrossOrigin(origins = "*") // Replace with your Angular app's URL
public class FoyerRestController {
    private final IFoyerServices foyerServices;

    @GetMapping("/getOne/{idFoyer}")
    public Foyer getFoyer(@PathVariable Long idFoyer){
        return foyerServices.getFoyer(idFoyer);
    }

    @GetMapping("/allWP")
    public Page<Foyer> getAllFoyerWP(@PageableDefault(size = 6, sort = "idFoyer", direction = Sort.Direction.ASC) Pageable pageable) {
        return foyerServices.getAllFoyerWP(pageable);
    }

    @GetMapping("/all")
    public List<Foyer> getAllFoyer(){
        return foyerServices.getAllFoyer();
    }

    @PostMapping("/add")
    public Foyer addFoyer(@RequestBody Foyer f){
        return foyerServices.ajouterFoyer(f);
    }

    @PutMapping("/update")
    public Foyer updateFoyer(@RequestBody Foyer f){
        return foyerServices.updateFoyer(f);
    }

    @DeleteMapping ("/delete/{idFoyer}")
    public void deleteFoyer(@PathVariable Long idFoyer){
         foyerServices.supprimerFoyer(idFoyer);
    }
    @PutMapping ("/ajouterFoyerEtAffecterAUniversite/{idUniv}")
    public void ajouterFoyerEtAffecterAUniversiteApi(@RequestBody Foyer f,@PathVariable Long idUniv){
         foyerServices.ajouterFoyerEtAffecterAUniversite(f,idUniv);
    }

    @PostMapping("/ajouterFoyerEtAffecterAResto")
    public void ajouterFoyerEtAffecterAResto(@RequestBody Foyer f, @RequestParam Long idResto) {
        foyerServices.ajouterFoyerEtAffecterAResto(f, idResto);
    }


    @PutMapping ("/desaffecterFoyerAResto/{idResto}/{idFoyer}")
    public void desaffecterFoyerAResto(@PathVariable Long idFoyer ,@PathVariable Long idResto){
        foyerServices.desaffecterFoyerAResto(idFoyer,idResto);
    }

}
