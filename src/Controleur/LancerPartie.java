package Controleur;

import Modèle.*;

/**
 * Created by perrettc on 23/10/14.
 */
public class LancerPartie {
    public static void lancement_partie(){

        //Création des 2 joueurs
        Joueur blanc   = new Joueur("blanc",null);
        Joueur noir    = new Joueur("noir",null);
        //Ajout des joueurs au singleton
        Jeu.instance().setJoueurBlanc(blanc);
        Jeu.instance().setJoueurNoir(noir);


        //Ajouter joueur au singleotn jeu

        //Creation echiquier
        Piece[][] tableau = new Piece[8][8];
        // BLANCS - Reine/Roi
        tableau[3][0] =  new Reine(blanc, new Coordonnee(3,0));
        tableau[4][0] =  new Roi(blanc, new Coordonnee(4,0));
        //fous
        tableau[5][0] =  new Fou(blanc, new Coordonnee(5,0));
        tableau[2][0] =  new Fou(blanc, new Coordonnee(2,0));
        //cavaliers
        tableau[6][0] =  new Cavalier(blanc, new Coordonnee(6,0));
        tableau[1][0] =  new Cavalier(blanc, new Coordonnee(1,0));
        //tours
        tableau[0][0] =  new Tour	(blanc, new Coordonnee(0,0));
        tableau[7][0] =  new Tour	(blanc, new Coordonnee(7,0));

        // NOIRS - Reine/Roi
        tableau[3][7] =  new Reine	(noir, new Coordonnee(3,0));
        tableau[4][7] =  new Roi	(noir, new Coordonnee(4,0));
        //fous
        tableau[5][7] =  new Fou(noir, new Coordonnee(5,0));
        tableau[2][7] =  new Fou(noir, new Coordonnee(2,0));
        //cavaliers
        tableau[6][7] =  new Cavalier(noir, new Coordonnee(6,0));
        tableau[1][7] =  new Cavalier(noir, new Coordonnee(1,0));
        //tours
        tableau[0][7] =  new Tour	(noir, new Coordonnee(0,0));
        tableau[7][7] =  new Tour	(noir, new Coordonnee(7,0));

        //PIONS
        for(int i=0; i<8; i++) {
            tableau[i][1] = new Pion(blanc, new Coordonnee(i, 1));
            tableau[i][6] = new Pion(noir, new Coordonnee(i, 6));
        }

        //echiquier = new Echiquier(tableau);
        //TODO setechiquier(tab)


    }
}
