package Modèle;

/**
 * Created by Paul on 19/10/2014.
 */

// Singleton jeu
public class Jeu {
    private Echiquier echiquier;
    private Joueur blanc;
    private Joueur noir;
    final private static Jeu jeu = new Jeu();

    private Jeu() {





    }

    public static Jeu instance() {
        return jeu;
    }

    public Joueur getBlanc() {
        return blanc;
    }

    public Joueur getNoir() {
        return noir;
    }

    public Echiquier getEchiquier() {
        return echiquier;
    }
}
