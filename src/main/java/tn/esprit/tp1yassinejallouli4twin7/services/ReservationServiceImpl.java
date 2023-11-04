package tn.esprit.tp1yassinejallouli4twin7.services;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import tn.esprit.tp1yassinejallouli4twin7.entities.Chambre;
import tn.esprit.tp1yassinejallouli4twin7.entities.Etudiant;
import tn.esprit.tp1yassinejallouli4twin7.entities.Reservation;
import tn.esprit.tp1yassinejallouli4twin7.repositories.IChambreRepo;
import tn.esprit.tp1yassinejallouli4twin7.repositories.IEtudiantRepo;
import tn.esprit.tp1yassinejallouli4twin7.repositories.IReservationRepo;

import java.util.Date;
import java.util.List;

@Primary
@AllArgsConstructor
@Service
public class ReservationServiceImpl implements IReservationService{

    IReservationRepo reservationRepo;
    IChambreRepo chambreRepo;
    IEtudiantRepo etudiantRepo;

    @Override
    public Reservation ajouterReservation(Reservation r) {
        return reservationRepo.save(r);
    }

    @Override
    public Reservation updateReservation(Reservation r) {
        return reservationRepo.save(r);
    }

    @Override
    public void supprimerReservation(Long idReservation) {
         reservationRepo.deleteById(idReservation);
    }

    @Override
    public Reservation getReservation(Long idReservation) {
        return reservationRepo.findById(idReservation).orElse(null);
    }

    @Override
    public List<Reservation> getAllReservations() {
        return (List<Reservation>) reservationRepo.findAll();
    }

    @Override
    @Transactional
    public Reservation ajouterReservationEtAssignerAChambreEtAEtudiant(Reservation res, Long numChambre, long cin) {
        this.ajouterReservation(res);
        Chambre ch = chambreRepo.findChambreByNumeroChambre(numChambre);
        Etudiant et = etudiantRepo.findEtudiantByCin(cin);
        ch.getReservations().add(res);
        et.getReservations().add(res);
        return res;
    }

    @Override
    public long getReservationParAnneeUniversitaire(Date debutAnnee, Date finAnnee) {
        return  reservationRepo.findByDateReservationBetween(debutAnnee,finAnnee).size();

    }
}
