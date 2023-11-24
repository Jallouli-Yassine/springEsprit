package tn.esprit.tp1yassinejallouli4twin7.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Set;

@Setter
@Getter
@Entity
public class Universite implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private long idUniversite;

    @OneToOne
    @JsonIgnore

    private Foyer foyer;

    @Column(unique = true) //maneha raho lattribut unique
    private String nomUniversite;

    private String adresse;

    @OneToMany(mappedBy = "universite",fetch = FetchType.EAGER)
    Set<Prof> professeurs;

}
