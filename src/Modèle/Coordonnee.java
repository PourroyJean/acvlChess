<<<<<<< HEAD
<<<<<<< HEAD
package Modèle;

/**
 * Created by Paul on 19/10/2014.
 */
public class Coordonnee {
    private int x = -1;
    private int y = -1;
    char[] position_letters = {'A','B','C','D','E','F','G','H'};

    public Coordonnee(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public String toString() {
        return position_letters[x]+""+y;
    }

}
=======
package Modèle;

/**
 * Created by Paul on 19/10/2014.
 */
public class Coordonnee {
    private int x = -1;
    private int y = -1;
    char[] position_letters = {'A','B','C','D','E','F','G','H'};

    public Coordonnee(int x, int y) {
        this.x = x;
        this.y = y;
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
>>>>>>> cd70f2e... Piece deplacer + Coordonnee setter
=======
package Modèle;

/**
 * Created by Paul on 19/10/2014.
 */
public class Coordonnee {
    private int x = -1;
    private int y = -1;
    char[] position_letters = {'A','B','C','D','E','F','G','H'};

    public Coordonnee(int x, int y) {
        this.x = x;
        this.y = y;
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
>>>>>>> cd70f2e3c6831c53254bbffc3cfd37580ae2a80c
