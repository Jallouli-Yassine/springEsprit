package tn.esprit.tp1yassinejallouli4twin7.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "matiere_etudiants")
public class MatiereEtudiant {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;




  @Column(name = "moyenne")
  private Double moyenne;

}
