package tn.esprit.tp1yassinejallouli4twin7.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.tp1yassinejallouli4twin7.entities.Foyer;
import tn.esprit.tp1yassinejallouli4twin7.entities.Reservation;
import tn.esprit.tp1yassinejallouli4twin7.services.IFoyerServices;
import tn.esprit.tp1yassinejallouli4twin7.services.IReservationService;

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


}