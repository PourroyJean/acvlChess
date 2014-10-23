<<<<<<< HEAD
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
=======
package Modèle;

/**
 * Created by Paul on 20/10/2014.
 */
public class Echiquier {
    private Piece[][] tableau;

    public Echiquier() {

    }

    public Echiquier(Piece[][] tableau) {
        this.tableau = tableau;
    }

    /* Recupère une pièce de l'échiquier */
    public Piece get(int x, int y) {
        return this.tableau[x][y];
    }

    /* Ajoute une pièce p à l'échiquier */
    public void add(Piece p) {
        int x = p.getCoordonne().getX();
        int y = p.getCoordonne().getY();
        tableau[x][y] = p;
    }

    /* Enlever une pièce a partir de sa position */
    public void remove(int x, int y) {
        tableau[x][y] = null;
    }

    /* Enlever une pièce */
    public void remove(Piece p) {
        this.remove(p.getCoordonne().getX(), p.getCoordonne().getY());
    }
}
>>>>>>> cd70f2e3c6831c53254bbffc3cfd37580ae2a80c
