package Modèle;

/**
 * Created by Paul on 19/10/2014.
 */

// Singleton jeu
public class Jeu {
    private Piece[][] echiquier;
    private Joueur blanc;
    private Joueur noir;
    final private static Jeu jeu = new Jeu();

    private Jeu() {
        blanc   = new Joueur();
        noir    = new Joueur();
        echiquier = new Piece[8][8];

        // BLANCS - Reine/Roi
        echiquier[3][0] =  new Reine	(blanc, new Coordonnee(3,0));
        echiquier[4][0] =  new Roi	(blanc, new Coordonnee(4,0));
            //fous
        echiquier[5][0] =  new Fou(blanc, new Coordonnee(5,0));
        echiquier[2][0] =  new Fou(blanc, new Coordonnee(2,0));
            //cavaliers
        echiquier[6][0] =  new Cavalier(blanc, new Coordonnee(6,0));
        echiquier[1][0] =  new Cavalier(blanc, new Coordonnee(1,0));
            //tours
        echiquier[0][0] =  new Tour	(blanc, new Coordonnee(0,0));
        echiquier[7][0] =  new Tour	(blanc, new Coordonnee(7,0));

        // NOIRS - Reine/Roi
        echiquier[3][7] =  new Reine	(noir, new Coordonnee(3,0));
        echiquier[4][7] =  new Roi	(noir, new Coordonnee(4,0));
            //fous
        echiquier[5][7] =  new Fou(noir, new Coordonnee(5,0));
        echiquier[2][7] =  new Fou(noir, new Coordonnee(2,0));
            //cavaliers
        echiquier[6][7] =  new Cavalier(noir, new Coordonnee(6,0));
        echiquier[1][7] =  new Cavalier(noir, new Coordonnee(1,0));
            //tours
        echiquier[0][7] =  new Tour	(noir, new Coordonnee(0,0));
        echiquier[7][7] =  new Tour	(noir, new Coordonnee(7,0));

        //PIONS
        for(int i=0; i<8; i++) {
            echiquier[i][1] = new Pion(blanc, new Coordonnee(i, 1));
            echiquier[i][6] = new Pion(noir, new Coordonnee(i, 6));
        }
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

    public Piece[][] getEchiquier() {
        return echiquier;
    }
}
