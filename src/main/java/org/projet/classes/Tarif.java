package org.projet.classes;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Tarif {
    private float prixParMetre;
    private TypeTerasse typeTerasse;
    private Zone zone;
}
