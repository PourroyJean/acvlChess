package Modèle.Pièce;

import Controleur.Visiteur.Visiteur;
import Modèle.Coordonnee;

/**
 * Created by Paul on 16/10/2014.
 */
public abstract class Piece {
    /* VRAI si cette pièce est blanche ; FAUX si elle est noire */
    private boolean blanc;
    private Coordonnee coordonnee;

    public Piece() {}
    public Piece(boolean blanc, Coordonnee coordonnee) {
        this.blanc = blanc;
        this.coordonnee = coordonnee;
    }

    public boolean isBlanc() {
        return blanc;
    }

    public Coordonnee getCoordonnee() {
        return coordonnee;
    }

    public void setBlanc(boolean blanc) {
        this.blanc = blanc;
    }

    public void setCoordonnee(Coordonnee coordonnee) {
        this.coordonnee = coordonnee;
    }

    abstract public void applique(Visiteur v);
}

