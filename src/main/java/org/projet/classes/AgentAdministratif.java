package org.projet.classes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AgentAdministratif extends Personne{

    String prenom;
    String nom;

    public AgentAdministratif(String login,
                              String mdp,
                              String prenom,
                              String nom){
        super(login, mdp);
        this.prenom = prenom;
        this.nom = nom;
    }
}
