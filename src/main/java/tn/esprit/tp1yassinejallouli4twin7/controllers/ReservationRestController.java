package tn.esprit.tp1yassinejallouli4twin7.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;
import tn.esprit.tp1yassinejallouli4twin7.entities.Foyer;
import tn.esprit.tp1yassinejallouli4twin7.entities.Reservation;
import tn.esprit.tp1yassinejallouli4twin7.services.IFoyerServices;
import tn.esprit.tp1yassinejallouli4twin7.services.IReservationService;

import java.util.Date;
import java.util.List;

@RequiredArgsConstructor //2eme lezem el final mawjouda
@RequestMapping("reservation")
@RestController
public class ReservationRestController {
    private final IReservationService reservationService;

    @GetMapping("/all")
    public List<Reservation> getAllReservation(){
        return reservationService.getAllReservations();
    }

    @PostMapping("/add")
    public Reservation addReservation(@RequestBody Reservation r){
        return reservationService.ajouterReservation(r);
    }

    @PostMapping("/update")
    public Reservation updateReservation(@RequestBody Reservation r){
        return reservationService.updateReservation(r);
    }

    @DeleteMapping ("/delete/{idReservation}")
    public void deleteReservation(@PathVariable Long idReservation){
        reservationService.supprimerReservation(idReservation);
    }
    @PutMapping("/ajouterReservationEtAssignerAChambreEtAEtudiant/{numChambre}/{cin}")
    public Reservation ajouterReservationEtAssignerAChambreEtAEtudiantAPI (@RequestBody Reservation res,@PathVariable Long numChambre,@PathVariable long cin){
       return reservationService.ajouterReservationEtAssignerAChambreEtAEtudiant(res,numChambre,cin);
    }
    @PostMapping("/getReservationParAnneeUniversitaire/{debutAnnee}/{finAnnee}")
    public long getReservationParAnneeUniversitaireApi(@PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)Date debutAnnee,@PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date finAnnee ){
       return reservationService.getReservationParAnneeUniversitaire(debutAnnee,finAnnee);
    }

    @PutMapping("/ajouterReservation/{idChambre}/{cinEtudiant}")
    public Reservation ajouterReservationApi(@PathVariable long idChambre,@PathVariable long cinEtudiant){
       return reservationService.ajouterReservation(idChambre,cinEtudiant);
    }


}
