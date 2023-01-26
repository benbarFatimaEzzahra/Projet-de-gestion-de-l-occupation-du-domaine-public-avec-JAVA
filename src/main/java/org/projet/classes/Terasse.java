package org.projet.classes;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Terasse {
    private float surface;
    private Date dateInstallation;
    private Etablissement etablissement;
    private TypeTerasse typeTerasse;
}
