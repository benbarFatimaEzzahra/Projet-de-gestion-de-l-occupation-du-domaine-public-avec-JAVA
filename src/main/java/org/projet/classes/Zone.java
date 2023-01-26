package org.projet.classes;

import jdk.jfr.DataAmount;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Zone {
    private String nomZone;
    private List<Tarif> tarifs;

    public void addTarif(Tarif tarif){
        this.tarifs.add(tarif);
        tarif.setZone(this);
    }
}
