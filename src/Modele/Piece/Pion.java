package Modele.Piece;

import Controleur.Visiteur.Visiteur;
import Erreur.DeplacementImpossible;
import Erreur.NotYetImplementedException;
import Modele.Coordonnees;
import Modele.CouleurJoueur;

/**
 * Created by Paul on 16/10/2014.
 */
public class Pion extends Piece {
    public Pion(CouleurJoueur b, Coordonnees c) {
        super(b, c);
    }

    @Override
    public void applique(Visiteur v) {
        try {
            try {
                v.visite(this);
            } catch (DeplacementImpossible deplacementImpossible) {
                deplacementImpossible.printStackTrace();
            }
        } catch (NotYetImplementedException e) {
            e.printStackTrace();
        }
    }
}
