package Modele.Piece;

import Controleur.Visiteur.Visiteur;
import Erreur.NotYetImplementedException;
import Modele.Coordonnees;

/**
 * Created by Paul on 16/10/2014.
 */
public class Fou extends Piece {
    public Fou(boolean blanc, Coordonnees c) {
        super(blanc, c);
    }

    @Override
    public void applique(Visiteur v) {
        try {
            v.visite(this);
        } catch (NotYetImplementedException e) {
            e.printStackTrace();
        }
    }
}
