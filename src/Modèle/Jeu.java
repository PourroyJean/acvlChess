package Modèle;

import Erreur.NotYetImplementedException;
import Modèle.Pièce.Piece;

/**
 * Created by Paul on 19/10/2014.
 */

// Singleton jeu
public class Jeu {
    private Piece[][] echiquier;
    private Joueur blanc;
    private Joueur noir;
    final private static Jeu jeu = new Jeu();

    //Singleton
    private Jeu() {}

    public static Jeu instance() {
        return jeu;
    }

    public Joueur getBlanc() {
        return blanc;
    }

    public Joueur getNoir() {
        return noir;
    }

    public Piece[][] getEchiquier() {
        return echiquier;
    }

    public void setJoueurBlanc(Joueur j) {
        this.blanc = j;
    }

    public void setJoueurNoir(Joueur j) {
        this.noir = j;
    }

    public void init() throws NotYetImplementedException {
        throw new NotYetImplementedException();
    }

}
