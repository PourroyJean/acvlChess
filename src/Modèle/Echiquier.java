package Modèle;

/**
 * Created by Paul on 20/10/2014.
 */
public class Echiquier {
    private Piece[][] tableau;

    public Echiquier(int taille) {
        tableau = new Piece[taille][taille];
    }

    public void add(Piece p)
    {
    }

    public Piece[][] getTableau() {
        return tableau;
    }

    public Piece get(int x, int y) {
        return this.tableau[x][y];
    }
}
