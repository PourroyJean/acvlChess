package Modele.Piece;

/**
 * Created by Paul on 19/10/2014.
 */
public class Coordonnees {
    private int x = -1;
    private int y = -1;
    char[] position_letters = {'A','B','C','D','E','F','G','H'};

    public Coordonnees(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean equals(Object obj) {
        Coordonnees c = (Coordonnees) obj;
        return this.x == c.x && this.y == c.y;
    }

    public String toString() {
        return position_letters[x]+""+y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void set(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
