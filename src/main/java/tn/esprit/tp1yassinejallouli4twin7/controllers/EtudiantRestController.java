package tn.esprit.tp1yassinejallouli4twin7.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.tp1yassinejallouli4twin7.entities.Etudiant;
import tn.esprit.tp1yassinejallouli4twin7.entities.Foyer;
import tn.esprit.tp1yassinejallouli4twin7.services.IEtudiantService;
import tn.esprit.tp1yassinejallouli4twin7.services.IFoyerServices;

import java.util.List;

@RequiredArgsConstructor //2eme lezem el final mawjouda
@RequestMapping("etudiant")
@RestController
public class EtudiantRestController {
    private final IEtudiantService etudiantService;
    @GetMapping("/all")
    public List<Etudiant> getAllEtudiant(){
        return etudiantService.getAllEtudiants();
    }

    @PostMapping("/add")
    public Etudiant addEtudiant(@RequestBody Etudiant e){
        return etudiantService.ajouterEtudiant(e);
    }

    @PostMapping("/update")
    public Etudiant updateEtudiant(@RequestBody Etudiant e){
        return etudiantService.updateEtudiant(e);
    }

    @DeleteMapping ("/delete/{idEtudiant}")
    public void deleteEtudiant(@PathVariable Long idEtudiant){
        etudiantService.supprimerEtudiant(idEtudiant);
    }

}
