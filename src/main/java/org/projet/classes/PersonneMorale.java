package org.projet.classes;

import jdk.jfr.DataAmount;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Data
public class PersonneMorale extends Personne{
    private String raisonSociale;
    private String formJuridique;
    private String codeSIRET;

    public PersonneMorale(String raisonSociale,
                          String formJuridique,
                          String codeSIRET,
                          String login,
                          String mdp){
        super(login, mdp);
        this.raisonSociale = raisonSociale;
        this.codeSIRET = codeSIRET;
        this.formJuridique = formJuridique;
    }

}
