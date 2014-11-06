package Modèle.Pièce;

import Controleur.Visiteur.Visiteur;
import Erreur.NotYetImplementedException;
import Modèle.Coordonnee;
import Modèle.Joueur;

/**
 * Created by Paul on 16/10/2014.
 */
public class Fou extends Piece {
    public Fou(boolean blanc, Coordonnee c) {
        super(blanc, c);
    }

    @Override
    public void appliquer(Visiteur v) {
        try {
            v.visite(this);
        } catch (NotYetImplementedException e) {
            e.printStackTrace();
        }
    }
}
