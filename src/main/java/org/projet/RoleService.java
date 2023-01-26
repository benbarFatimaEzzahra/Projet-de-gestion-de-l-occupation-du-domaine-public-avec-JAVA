package org.projet;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.projet.classes.*;
import org.projet.util.RoleType;
import org.projet.util.TypeTerasseEnum;

import java.util.GregorianCalendar;
import java.util.List;

@Data
@NoArgsConstructor
public class RoleService {
    User personnePhysique = new PersonnePhysique("NAJARI","Maryam","célibataire","Angular Dev","najari","maryam123");
    User personneMorale = new PersonneMorale("AGILIS","SAS","D152874521","agilis","mdpAgilis123");
    User agent1 = new AgentAdministratif("agent", "agentMdp", "Yassine", "Yassine");
    User agent2 = new Surveillant("Laila", "Maryam","laila", "maryam");

    Zone zoneA = new Zone();
    Zone zoneB = new Zone();
    Zone zoneC = new Zone();
    TypeTerasse typeTerasseEte = new TypeTerasse(TypeTerasseEnum.TERASSE_ETE, new GregorianCalendar(2022, 5, 01).getTime(),new GregorianCalendar(2022, 9, 30).getTime());
    TypeTerasse typeTerassePermanente = new TypeTerasse(TypeTerasseEnum.TERASSE_PERMANENTE, new GregorianCalendar(2022, 1, 1).getTime(),new GregorianCalendar(2022, 12, 31).getTime());
    TypeTerasse typeTerasseSPermanente = new TypeTerasse(TypeTerasseEnum.TERASSE_SEMI_PERMANENTE, new GregorianCalendar(2022, 1, 1).getTime(),new GregorianCalendar(2022, 10, 31).getTime());
    Tarif TarifZoneAEte = new Tarif(42.92f, typeTerasseEte, zoneA);
    Tarif TarifZoneBEte = new Tarif(36.14f, typeTerasseEte, zoneB);
    Tarif TarifZoneCEte = new Tarif(25.39f, typeTerasseEte, zoneC);
    Tarif tarifZoneAPermanent = new Tarif(126.50f, typeTerassePermanente, zoneA);
    Tarif tarifZoneBPermanent = new Tarif(106.36f, typeTerassePermanente, zoneB);
    Tarif tarifZoneCPermanent = new Tarif(74.74f, typeTerassePermanente, zoneC);
    Tarif tarifZoneASemiPermanent = new Tarif(74.16f, typeTerasseSPermanente, zoneA);
    Tarif tarifZoneBSemiPermanent = new Tarif(62.36f, typeTerasseSPermanente, zoneB);
    Tarif tarifZoneCSemiPermanent = new Tarif(43.82f, typeTerasseSPermanente, zoneC);
    Periode periode1 = new Periode(new GregorianCalendar(2022, 5, 1).getTime(), new GregorianCalendar(2022, 9, 30).getTime(), null, null, null);
    Terasse terasse1 = new Terasse(15.25f, new GregorianCalendar(2012, 5, 1).getTime(), null, typeTerasseEte);
    Etablissement machicoulis = new Etablissement("UCX878", "Machicoulis", "18 Rue de la République",null, zoneA, List.of(terasse1));

    List<User> utilisateurs= List.of(personneMorale, personnePhysique, agent1, agent2);

    public void init(){
        Personne p = (Personne) personnePhysique;
       periode1.setEtablissement(machicoulis);
        p.addPeriode(periode1);
        typeTerasseEte.setTarifs(List.of(TarifZoneAEte, TarifZoneBEte, TarifZoneCEte));
        typeTerassePermanente.setTarifs(List.of(tarifZoneAPermanent, tarifZoneBPermanent, tarifZoneCPermanent));
        typeTerasseSPermanente.setTarifs(List.of(tarifZoneASemiPermanent, tarifZoneBSemiPermanent, tarifZoneCSemiPermanent));

    }

    public User retreiveRole(String login, String pwd) {
        if (!login.isEmpty() || !pwd.isEmpty()){
            return utilisateurs.stream()
                    .filter(utilisateur -> utilisateur.getLogin().equals(login) && utilisateur.getMdp().equals(pwd))
                    .findFirst()
                    .orElse(null);
        }
        return null;
    }

    public RoleType getRole(User user){
        if (user instanceof PersonnePhysique){
            return RoleType.EXPLOITANT;
        } else if (user instanceof PersonneMorale) {
            return RoleType.EXPLOITANT;
        } else if (user instanceof AgentAdministratif) {
            return RoleType.AGENT_ADMINISTRATIF;
        } else if (user instanceof Surveillant) {
            return RoleType.SURVEILLANT;
        } else{
            return null;
        }
    }
}
