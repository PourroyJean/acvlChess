package Modele.Piece;

import Controleur.Visiteur.Visiteur;
import Erreur.DeplacementImpossible;
import Erreur.NotYetImplementedException;
import Modele.Coordonnees;
import Modele.CouleurJoueur;

/**
 * Created by Paul on 16/10/2014.
 */
public class Fou extends Piece {
    public Fou(CouleurJoueur b, Coordonnees c) {
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
