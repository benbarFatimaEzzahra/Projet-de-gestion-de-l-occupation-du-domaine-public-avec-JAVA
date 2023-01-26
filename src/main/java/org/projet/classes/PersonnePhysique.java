package org.projet.classes;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class PersonnePhysique extends Personne{
    private String nom;
    private String prenom;
    private String civilite;
    private String profession;

    public PersonnePhysique(String nom,
                            String prenom,
                            String civilite,
                            String profession,
                            String login,
                            String mdp) {
        super(login, mdp);
        this.nom = nom;
        this.prenom = prenom;
        this.civilite = civilite;
        this.profession = profession;
    }


}
