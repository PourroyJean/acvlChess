import Modèle.Jeu;

/**
 * Created by Paul on 16/10/2014.
 */
public class Test {
    public static void main(String[] args) {
        // write your code here
        System.out.println("plop");
        System.out.print(Jeu.instance().getEchiquier().get(0,1).getCoordonne());
    }
}
