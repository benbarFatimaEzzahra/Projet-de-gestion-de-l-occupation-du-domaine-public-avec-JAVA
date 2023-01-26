package org.projet;

import org.projet.classes.Personne;
import org.projet.classes.PersonnePhysique;
import org.projet.classes.User;
import org.w3c.dom.ls.LSOutput;

import java.util.Objects;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        RoleService roleService = new RoleService();
        OptionService optionService = new OptionService();
        int selectedOption;
        String login;
        String pwd;
        User connectedUser=null;
        roleService.init();
        do{
            Scanner sc = new Scanner(System.in);
            if (connectedUser == null){
                System.out.println("Bonjour Veuillez Renseigner votre login : \n");
                login = sc.next();
                System.out.println("Veuillez Renseigner votre mot de passe : \n");
                pwd = sc.next();
                connectedUser = roleService.retreiveRole(login,pwd);
            }
            if (Objects.isNull(roleService.getRole(connectedUser)) || Objects.isNull(connectedUser)) {
                System.out.println("!!! Profile inconnu !!!");
                System.exit(-1);
            }
            System.out.println("Bonjour " + connectedUser.getLogin() + " vous êtes connecté en tant que : \t" + roleService.getRole(connectedUser) +"\n " );
            System.out.println("connectedUser = " + connectedUser);
            System.out.println("selectionner ce que vous voulez faire :\n");
            System.out.println("1/- Afficher Vos etablissements\n" +
                    "2/- Calculer vos Factures\n" +
                    "3/- se déconnecter\n"+
                    "4/- Quitter\n");
            selectedOption = sc.nextInt();
            if (selectedOption == 3){
                connectedUser = null;
            }else {
            optionService.executeOption(selectedOption, connectedUser);
            }
        }while(selectedOption != 4);
    }
}