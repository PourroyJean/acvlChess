package vue.InterfaceGraphique;

import Controleur.Visiteur.Partie;
import Erreur.NotYetImplementedException;
import Modele.Jeu;
import Modele.Joueur;

/**
 * Created by Jean on 13/11/14.
 */
public class NouvellePartie implements Commande {
    @Override
    public void execute() {
        try {

            Partie.init("Joueur 1", "Joueur 2");
            //Jeu.instance().init(new Joueur("J1"), new Joueur("J2"));
            FrameJeu.instance().MAJ();
        } catch (NotYetImplementedException e) {
            e.printStackTrace();
        }
    }
}
