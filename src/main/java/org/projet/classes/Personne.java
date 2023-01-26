package org.projet.classes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Data
@NoArgsConstructor
public class Personne extends User{
    private List<Periode> periodesDoccupations;

    public Personne(String login,
                    String mdp){
        super(login, mdp);
    }

    public void addPeriode(Periode periode){
        if(periodesDoccupations == null){
            periodesDoccupations = new ArrayList<>();
        }
        periodesDoccupations.add(periode);
        periode.setExploitant(this);
    }

    public List<Etablissement> getAllEtablissement(){
        return periodesDoccupations.stream()
                .map(Periode::getEtablissement)
                .collect(Collectors.toList());
    }



}
