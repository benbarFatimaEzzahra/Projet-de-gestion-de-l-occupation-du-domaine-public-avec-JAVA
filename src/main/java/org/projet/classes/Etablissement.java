package org.projet.classes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class Etablissement {
    private String code;
    private String appelationCommerciale;
    private String addresse;
    private List<Periode> periodesDoccupations;
    private Zone zone;
    private List<Terasse> terasses;

    @Override
    public String toString() {
        return "Etablissement{" +
                "code='" + code + '\'' +
                ", appelationCommerciale='" + appelationCommerciale + '\'' +
                ", addresse='" + addresse + '\'' +
                '}';
    }
}
