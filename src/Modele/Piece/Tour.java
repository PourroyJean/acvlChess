package Modele.Piece;

import Controleur.Visiteur.Visiteur;
import Erreur.DeplacementImpossible;

/**
 * Created by Paul on 16/10/2014.
 */
public class Tour extends Piece {
    public Tour(CouleurPiece b, Coordonnees c) {
        super(b, c);
    }

    @Override
    public void applique(Visiteur v) {

        try {
            v.visite(this);
        } catch (DeplacementImpossible deplacementImpossible) {
            deplacementImpossible.printStackTrace();
        }
    }
}
