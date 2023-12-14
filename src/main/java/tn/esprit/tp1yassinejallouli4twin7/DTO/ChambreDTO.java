package tn.esprit.tp1yassinejallouli4twin7.DTO;

import jakarta.persistence.ManyToOne;
import lombok.*;
import tn.esprit.tp1yassinejallouli4twin7.entities.Bloc;
import tn.esprit.tp1yassinejallouli4twin7.entities.Chambre;
import tn.esprit.tp1yassinejallouli4twin7.entities.TypeChambre;


@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ChambreDTO {
    private Long idChambre;
    private Long numeroChambre;
    private TypeChambre typeC;
    private Bloc blocChambre;
    private int numR;


    public ChambreDTO(Chambre chambre) {
        this.idChambre = chambre.getIdChambre();
        this.numeroChambre = chambre.getNumeroChambre();
        this.typeC = chambre.getTypeC();
        this.blocChambre = chambre.getBlocchambre();
        this.numR = chambre.getReservations().toArray().length;
    }
}
