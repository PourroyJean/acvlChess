package Modele.Piece;

import Controleur.Visiteur.Visiteur;
import Erreur.DeplacementImpossible;
import Modele.Coordonnees;
import Modele.CouleurJoueur;

/**
 * Created by Paul on 16/10/2014.
 */
public abstract class Piece {

    public CouleurJoueur getCouleur() {
        return couleur;
    }

    public void setCouleur(CouleurJoueur couleur) {
        this.couleur = couleur;
    }

    private CouleurJoueur couleur;
    private Coordonnees coordonnees;

    public Piece() {}
    public Piece(CouleurJoueur couleur, Coordonnees coordonnees) {
        this.couleur = couleur;
        this.coordonnees = coordonnees;
    }

    public boolean isBlanc() {
        return couleur == CouleurJoueur.BLANC;
    }

    public Coordonnees getCoordonnees() {
        return coordonnees;
    }



    public void setCoordonnees(Coordonnees coordonnees) {
        this.coordonnees = coordonnees;
    }

    abstract public void applique(Visiteur v) throws DeplacementImpossible;
}

