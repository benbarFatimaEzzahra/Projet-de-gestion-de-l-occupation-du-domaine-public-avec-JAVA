package org.projet.classes;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.projet.util.TypeTerasseEnum;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Objects;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class Periode {
    private Date dateDebut;

    private Date dateFin;

    private Personne exploitant;
    private Facture factureRedevable;
    private  Etablissement etablissement;

    public void calculFacture(User connectedUser) {
        List<Terasse> terasses = etablissement.getTerasses();
        Facture facture = new Facture();
        for (Terasse t:terasses){
            switch (t.getTypeTerasse().getType()){
                case TERASSE_ETE:
                    calculerFactureTerasse(t, facture, TypeTerasseEnum.TERASSE_ETE, etablissement.getZone());
                    break;
                case TERASSE_PERMANENTE:
                    calculerFactureTerasse(t, facture, TypeTerasseEnum.TERASSE_PERMANENTE,etablissement.getZone());
                    break;
                case TERASSE_SEMI_PERMANENTE:
                    calculerFactureTerasse(t, facture, TypeTerasseEnum.TERASSE_SEMI_PERMANENTE, etablissement.getZone());
                    break;
                default:
                    break;
            }
        }
        factureRedevable = facture;
    }

    private void calculerFactureTerasse(Terasse t, Facture facture, TypeTerasseEnum typeTerasses, Zone zone) {
        float surfaceTerasse = t.getSurface();
        Tarif tarifs = t.getTypeTerasse().getTarifs().stream()
                .filter(tarif -> tarif.getTypeTerasse().getType() == typeTerasses)
                .filter(tarif -> tarif.getZone().getNomZone() == zone.getNomZone())
                .findFirst()
                .orElseThrow(()->new RuntimeException("Tarif non trouvée"));
        float prixParMetre = tarifs.getPrixParMetre();
        facture.setSommeRedevable(facture.getSommeRedevable()+(surfaceTerasse*prixParMetre));
    }

    public void afficherEtablissement(){
        String dateFinString = Objects.isNull(this.getDateFin()) ? "Maintenant" : new SimpleDateFormat("dd-MM-yyyy").format(this.getDateFin());
        System.out.println("Vous avez Occupé l'établissement : "+etablissement.getAppelationCommerciale()+" Depuis le : "+new SimpleDateFormat("dd-MM-yyyy").format(this.getDateDebut())+" Jusqu'au : "+ dateFinString);
    }
    public void afficherFactures() {
        System.out.println("Facture de "+exploitant.getLogin()+" "+" pour l'etablissement "+etablissement.getAppelationCommerciale() + ":\n");
        System.out.println("Somme redevable : "+factureRedevable.getSommeRedevable());
    }

    public void setFactureRedevable(Facture factureRedevable) {
        this.factureRedevable = factureRedevable;
        factureRedevable.setPeriode(this);
    }

    public void setEtablissement(Etablissement etablissement) {
        this.etablissement = etablissement;
    }
}
