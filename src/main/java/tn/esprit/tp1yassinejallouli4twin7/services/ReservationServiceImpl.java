package tn.esprit.tp1yassinejallouli4twin7.services;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import tn.esprit.tp1yassinejallouli4twin7.entities.Chambre;
import tn.esprit.tp1yassinejallouli4twin7.entities.Etudiant;
import tn.esprit.tp1yassinejallouli4twin7.entities.Reservation;
import tn.esprit.tp1yassinejallouli4twin7.entities.TypeChambre;
import tn.esprit.tp1yassinejallouli4twin7.repositories.IChambreRepo;
import tn.esprit.tp1yassinejallouli4twin7.repositories.IEtudiantRepo;
import tn.esprit.tp1yassinejallouli4twin7.repositories.IReservationRepo;

import java.time.LocalDate;
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
    public long getReservationParAnneeUniversitaire(Date debutAnnee, Date finAnnee) {
        return  reservationRepo.findByDateReservationBetween(debutAnnee,finAnnee).size();

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
    @Transactional
    public Reservation ajouterReservation(long idChambre, long cinEtudiant) {
        Chambre ch = chambreRepo.findById(idChambre).orElse(null);
        Etudiant et = etudiantRepo.findEtudiantByCin(cinEtudiant);

        Reservation r = new Reservation();
        r.setNumReservation(ch.getNumeroChambre() + ch.getBloc().getNomBloc() + cinEtudiant);
        r.setDebuteAnneUniversite(LocalDate.parse(LocalDate.now().getYear()+"-09-01"));
        r.setFinAnneUniversite(LocalDate.parse( LocalDate.now().getYear()+1+"06-01-"));
        r.setEstValid(true);

        if(ch.getTypeC()== TypeChambre.SIMPLE && ch.getReservations().size()<1){
            this.ajouterReservation(r);
            ch.getReservations().add(r);
            //et.getReservations().add(r);
            r.getEtudiants().add(et);
        }

        if(ch.getTypeC()== TypeChambre.DOUBLE && ch.getReservations().size()<2){
            this.ajouterReservation(r);
            ch.getReservations().add(r);
            et.getReservations().add(r);
        }

        if(ch.getTypeC()== TypeChambre.TRIPLE && ch.getReservations().size()<3){
            this.ajouterReservation(r);
            ch.getReservations().add(r);
            et.getReservations().add(r);
        }

        return r;
    }

    @Transactional
    @Override
    public Reservation annulerReservation(long cinEtudiant) {
        Etudiant e = etudiantRepo.findEtudiantByCin(cinEtudiant);
        List<Reservation> r = reservationRepo.findByEtudiants(e);
        for (Reservation res : r) {
            Chambre ch = chambreRepo.findChambreByReservations(res);
            ch.getReservations().remove(res);
            res.getEtudiants().remove(e);
            res.setEstValid(false);
            reservationRepo.save(res);
        }
        return null;
    }


}
