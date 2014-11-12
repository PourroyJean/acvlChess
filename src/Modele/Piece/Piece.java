package Modele.Piece;

import Controleur.Visiteur.Visiteur;
import Modele.Coordonnees;

/**
 * Created by Paul on 16/10/2014.
 */
public abstract class Piece {
    /* VRAI si cette pièce est blanche ; FAUX si elle est noire */
    private boolean blanc;
    private Coordonnees coordonnees;

    public Piece() {}
    public Piece(boolean blanc, Coordonnees coordonnees) {
        this.blanc = blanc;
        this.coordonnees = coordonnees;
    }

    public boolean isBlanc() {
        return blanc;
    }

    public Coordonnees getCoordonnees() {
        return coordonnees;
    }

    public void setBlanc(boolean blanc) {
        this.blanc = blanc;
    }

    public void setCoordonnees(Coordonnees coordonnees) {
        this.coordonnees = coordonnees;
    }

    abstract public void applique(Visiteur v);
}

