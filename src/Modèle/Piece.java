package Modèle;

/**
 * Created by Paul on 16/10/2014.
 */
public abstract class Piece {
    private Coordonnee coordonne;
    private Joueur maitre;

    public Piece() {}
    public Piece(Joueur m, Coordonnee c) {
        maitre = m;
        coordonne = c;
    }

    public Coordonnee getCoordonne() {
        return coordonne;
    }

    public void deplacer(int x, int y) {
        coordonne.set(x, y);
    }
}

