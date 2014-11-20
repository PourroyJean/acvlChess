import Controleur.Visiteur.Partie;
import Erreur.NotYetImplementedException;
import Modele.Jeu;
import Modele.Joueur;
import vue.InterfaceGraphique.FrameJeu;

/**
 * Created by Jean on 12/11/14.
 */
public class MAIN {
    public static void main(String[] args) throws NotYetImplementedException {
        Jeu j = Jeu.instance();
        Partie.init("Jean","Paul");
        FrameJeu f = FrameJeu.instance();
        j.attache(f);

    }
}
