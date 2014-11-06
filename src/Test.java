import Modèle.*;
import Modèle.Pièce.*;
import Modèle.Pièce.Pion;

/**
 * Created by Paul on 16/10/2014.
 */
public class Test {
    public static void main(String[] args) {
        // write your code here
        System.out.println("plop");
        Piece p = new Pion(true, new Coordonnee(1, 2));
        System.out.print(Jeu.instance().getEchiquier()[0][1].getCoordonnee());
    }
}
