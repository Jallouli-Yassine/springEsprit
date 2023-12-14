package tn.esprit.tp1yassinejallouli4twin7.services.IMPL;

import lombok.AllArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import tn.esprit.tp1yassinejallouli4twin7.entities.Etudiant;
import tn.esprit.tp1yassinejallouli4twin7.repositories.IEtudiantRepo;
import tn.esprit.tp1yassinejallouli4twin7.services.IEtudiantService;

import java.util.List;

@AllArgsConstructor
@Service
public class EtudiantServiceImpl implements IEtudiantService {

    IEtudiantRepo etudiantRepository;
    BCryptPasswordEncoder passwordEncoder;

/*
    @Override
    public Etudiant ajouterEtudiant(Etudiant et) {
        return etudiantRepo.save(et);
    }

    @Override
    public Etudiant updateEtudiant(Etudiant et) {
        return etudiantRepo.save(et);
    }

    @Override
    public void supprimerEtudiant(long idEtudiant) {
         etudiantRepo.deleteById(idEtudiant);
    }

    @Override
    public Etudiant getEtudiant(long idEtudiant) {
        return etudiantRepo.findById(idEtudiant).orElse(null);
    }

    @Override
    public List<Etudiant> getAllEtudiants() {
        return (List<Etudiant>) etudiantRepo.findAll();
    }

 */

    @Override
    public Etudiant AjouterEtudiant(Etudiant e) {
        e.setRole("user");
        e.setEtat(1);
        String passwordcode = this.passwordEncoder.encode(e.getPassoword());
        e.setPassoword(passwordcode);
        etudiantRepository.save(e);
        return etudiantRepository.save(e);
    }


    @Override
    public Boolean AjouterEtudiantAPI(Etudiant e) {


        try {
            e.setRole("user");
            e.setEtat(0);
            etudiantRepository.save(e);
            return true;
        } catch (Exception ex) {
            return false;
        }
    }

    @Override
    public Etudiant UpdateEtudiant(Etudiant e) {
        return etudiantRepository.save(e);
    }

    @Override
    public void SupprimerEtdiant(long idEtudiant) {

        etudiantRepository.deleteById( idEtudiant);

    }

    @Override
    public Etudiant GetEtudiant(long idEtudiant) {
        return etudiantRepository.findById(idEtudiant).orElse(null);
    }

    @Override
    public List<Etudiant> GetAllEtudiant() {
        return (List<Etudiant>) etudiantRepository.findAll();
    }

    @Override
    public Etudiant loginetudiant(String email, String password) {
        Etudiant etudiant = etudiantRepository.findEtudiantByEmail(email);
        System.out.println("edha etudinat eli jebtou "+etudiant.getEmail());
        if(passwordEncoder.matches(password,etudiant.getPassoword())&& etudiant.getEtat()!=5){
            System.out.println("fi west if  "+etudiant.getEmail());

            etudiant.setEtat(1);
            etudiantRepository.save(etudiant);
            return etudiant;

        }


        return null;
    }

    @Override
    public Etudiant getEtudiant(long id) {
        return etudiantRepository.findById(id).orElse(null);
    }

    @Override
    public Etudiant etudiantBlocked(long id) {
        Etudiant etudiant = etudiantRepository.findById(id).orElse(null);
        assert etudiant != null;
        etudiant.setEtat(5);
        return etudiantRepository.save(etudiant);
    }

    @Override
    public Etudiant unblock(long id) {
        Etudiant etudiant = etudiantRepository.findById(id).orElse(null);
        assert etudiant != null;
        etudiant.setEtat(0);
        return etudiantRepository.save(etudiant);    }

    @Override
    public Etudiant etatOflline(long id) {
        Etudiant etudiant = etudiantRepository.findById(id).orElse(null);
        assert etudiant != null;
        etudiant.setEtat(0);
        return etudiantRepository.save(etudiant);
    }
}
