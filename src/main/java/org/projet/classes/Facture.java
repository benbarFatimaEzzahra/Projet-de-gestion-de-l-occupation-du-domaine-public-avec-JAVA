package org.projet.classes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Facture {
    private float sommeRedevable;
    private Periode periode;
}
