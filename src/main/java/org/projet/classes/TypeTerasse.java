package org.projet.classes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.projet.util.TypeTerasseEnum;

import java.util.Date;
import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class TypeTerasse {
    private TypeTerasseEnum type;
    private Date dateDebut;
    private Date dateFin;
    private List<Tarif> tarifs;

    public TypeTerasse(TypeTerasseEnum type, Date dateDebut, Date dateFin) {
        this.type = type;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
    }

    @Override
    public String toString(){
        return "typeTerasse : "+ type;
    }
}
