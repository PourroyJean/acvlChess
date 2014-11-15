package Erreur;

/**
 * Created by Clément PERRETTE on 12/11/2014.
 */
public class DeplacementImpossible extends Exception implements ExceptionsModele {
        public DeplacementImpossible(String message) {
            super(message);
        }
        public DeplacementImpossible() {
            super();
        }
}
