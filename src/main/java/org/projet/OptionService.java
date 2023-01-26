package org.projet;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.projet.classes.Periode;
import org.projet.classes.Personne;
import org.projet.classes.User;
import org.projet.util.RoleType;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OptionService {
    RoleService roleService = new RoleService();
    public void executeOption(int option, User connectedUser){
        switch (option){
            case 1:
                afficherEtablissement(connectedUser);
                break;
            case 2:
                calculerFacture(connectedUser);
                break;
            default:
                System.out.println(" !!! OPTION INCONNUE !!!");
                break;
        }
    }


    private void calculerFacture(User connectedUser) {
        if(roleService.getRole(connectedUser).equals(RoleType.EXPLOITANT)){
            Personne personne  = (Personne) connectedUser;
            personne.getPeriodesDoccupations().forEach(p-> p.calculFacture(connectedUser));
            personne.getPeriodesDoccupations().forEach(Periode::afficherFactures);
        }else {
            System.out.println(" !!! VOUS N'ETES PAS EXPLOITANT !!!");
        }

    }

    private void afficherEtablissement(User connectedUser) {
        if(roleService.getRole(connectedUser).equals(RoleType.EXPLOITANT) ){
            Personne personne = (Personne) connectedUser;
            personne.getPeriodesDoccupations().forEach(Periode::afficherEtablissement);
        }else {
            System.out.println("Vous n'avez pas les droits pour afficher les etablissements");
        }

    }
}



