package Modele.Piece;

import Controleur.Visiteur.Visiteur;
import Erreur.DeplacementImpossible;
import Erreur.NotYetImplementedException;

/**
 * Created by Paul on 16/10/2014.
 */
public class Roi extends Piece {
    public Roi(CouleurPiece b, Coordonnees c) {
        super(b, c);
    }

    @Override
    public void applique(Visiteur v) {
        try {
            v.visite(this);
        } catch (NotYetImplementedException e) {
            e.printStackTrace();
        } catch (DeplacementImpossible deplacementImpossible) {
            deplacementImpossible.printStackTrace();
        }

    }
}
