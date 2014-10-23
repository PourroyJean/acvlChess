package Modèle;

/**
 * Created by Paul on 19/10/2014.
 */
public class Joueur {
    String couleur = "";
    Piece  roi = null;

    public Joueur(String couleur, Piece roi) {
        this.couleur = couleur;
        this.roi = roi;
    }

    @Override
    public String toString() {
        return "Joueur{" +
                "couleur='" + couleur + '\'' +
                '}';
    }
}
