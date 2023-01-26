package org.projet.classes;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Surveillant extends Personne{
    private String prenom;
    private String nom;

    public Surveillant(String prenom,
                       String nom,
                       String login,
                       String mdp){
        super(login, mdp);
        this.prenom = prenom;
        this.nom = nom;
    }
}
