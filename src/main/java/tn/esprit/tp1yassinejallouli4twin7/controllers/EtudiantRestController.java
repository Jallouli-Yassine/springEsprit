package tn.esprit.tp1yassinejallouli4twin7.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.tp1yassinejallouli4twin7.entities.Etudiant;
import tn.esprit.tp1yassinejallouli4twin7.services.IEtudiantService;

import java.util.List;

@RequiredArgsConstructor //2eme lezem el final mawjouda
@RequestMapping("Etudiant")
@RestController
@CrossOrigin(origins = "*")
public class EtudiantRestController {
    private final IEtudiantService etudiantService;
    /*
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

     */

    @GetMapping("Alletudiant")
    public List<Etudiant> GetAlletudnat(){return etudiantService.GetAllEtudiant();}
    @PostMapping("AddEtudiant")
    public Etudiant AddEtudiant(@RequestBody Etudiant e){
        return etudiantService.AjouterEtudiant(e);
    }
    @PutMapping("UpdateEtudiant")
    public Etudiant UpdateEtudiant(@RequestBody Etudiant e){
        return etudiantService.UpdateEtudiant(e);
    }
    @DeleteMapping("delete/{id}")
    public void SupprimerChambre(@PathVariable long id){
        etudiantService.SupprimerEtdiant(id);}



    @PostMapping("AddEtudiantapi")
    public Boolean AddEtudiantAPI(@RequestBody Etudiant e){
        return etudiantService.AjouterEtudiantAPI(e);
    }

    @PostMapping("login")
    public Etudiant loginetudiant(@RequestBody Etudiant e){
        return etudiantService.loginetudiant(e.getEmail(),e.getPassoword());
    }


    @GetMapping("one/{id}")
    public Etudiant getEtudiant(@PathVariable long id){
        return etudiantService.getEtudiant(id);
    }

    @GetMapping("blocked/{id}")
    public Etudiant etudiantBlocked(@PathVariable long id){
        return etudiantService.etudiantBlocked(id);
    }@GetMapping("unblocked/{id}")
    public Etudiant unblock(@PathVariable long id){
        return etudiantService.unblock(id);
    }


    @PostMapping("offline/{id}")
    public Etudiant etatOflline(@PathVariable long id){
        return etudiantService.etatOflline(id);
    }

}
