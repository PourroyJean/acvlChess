package Modele.Piece;

import Controleur.Visiteur.Visiteur;
import Erreur.DeplacementImpossible;

/**
 * Created by Paul on 16/10/2014.
 */
public abstract class Piece {

    public CouleurPiece getCouleur() {
        return couleur;
    }

    public void setCouleur(CouleurPiece couleur) {
        this.couleur = couleur;
    }

    private CouleurPiece couleur;
    private Coordonnees coordonnees;

    public boolean isDejaDeplace() {
        return dejaDeplace;
    }

    public void setDejaDeplace(boolean dejaDeplace) {
        this.dejaDeplace = dejaDeplace;
    }

    private boolean dejaDeplace = false;

    public Piece() {}
    public Piece(CouleurPiece couleur, Coordonnees coordonnees) {
        this.couleur = couleur;
        this.coordonnees = coordonnees;
    }

    public boolean isBlanc() {
        return couleur == CouleurPiece.BLANC;
    }

    public Coordonnees getCoordonnees() {
        return coordonnees;
    }



    public void setCoordonnees(Coordonnees coordonnees) {
        this.coordonnees = coordonnees;
    }

    abstract public void applique(Visiteur v) throws DeplacementImpossible;

    @Override
    public String toString() {
        return getClass().getName();
    }
}

