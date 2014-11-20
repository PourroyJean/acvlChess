package Controleur.Visiteur;

import Erreur.NotYetImplementedException;
import Modele.Jeu;
import Modele.Joueur;
import Modele.Piece.*;

/**
 * Created by Clément PERRETTE on 20/11/2014.
 */
public class Partie {
    private Partie(){}

    //creation d'une partie
    public static void init(String nomJoueur1, String nomJoueur2){

        Joueur blanc = new Joueur(nomJoueur1);
        Joueur noir = new Joueur(nomJoueur2);

        //Les blancs commencent
        Jeu.instance().setTour(CouleurPiece.BLANC);

        //Création des 2 joueurs
        Jeu.instance().setjBlanc(blanc);
        Jeu.instance().setjNoir(noir);


        //Creation echiquier
        Jeu.instance().setEchiquier(new Piece[8][8]);

        // BLANCS - Reine/Roi
        Jeu.instance().getEchiquier()[3][0] = new Reine(CouleurPiece.BLANC, new Coordonnees(3,0));
        Jeu.instance().setRoiBlanc( new Roi(CouleurPiece.BLANC, new Coordonnees(4,0)));
        Jeu.instance().getEchiquier()[4][0] = Jeu.instance().getRoiBlanc();
        //fous
        Jeu.instance().getEchiquier()[5][0] = new Fou(CouleurPiece.BLANC, new Coordonnees(5, 0));
        Jeu.instance().getEchiquier()[2][0] = new Fou(CouleurPiece.BLANC, new Coordonnees(2, 0));
        //cavaliers
        Jeu.instance().getEchiquier()[6][0] = new Cavalier(CouleurPiece.BLANC, new Coordonnees(6, 0));
        Jeu.instance().getEchiquier()[1][0] = new Cavalier(CouleurPiece.BLANC, new Coordonnees(1, 0));
        //tours
        Jeu.instance().getEchiquier()[0][0] = new Tour(CouleurPiece.BLANC, new Coordonnees(0, 0));
        Jeu.instance().getEchiquier()[7][0] = new Tour(CouleurPiece.BLANC, new Coordonnees(7, 0));

        // NOIRS - Reine/Roi
        Jeu.instance().getEchiquier()[3][7] = new Reine(CouleurPiece.NOIR, new Coordonnees(3, 7));
        Jeu.instance().setRoiNoir(new Roi(CouleurPiece.NOIR, new Coordonnees(4, 7)));
        Jeu.instance().getEchiquier()[4][7] = Jeu.instance().getRoiNoir();
        //fous
        Jeu.instance().getEchiquier()[2][7] = new Fou(CouleurPiece.NOIR, new Coordonnees(2, 7));
        Jeu.instance().getEchiquier()[5][7] = new Fou(CouleurPiece.NOIR, new Coordonnees(5, 7));
        //cavaliers
        Jeu.instance().getEchiquier()[6][7] = new Cavalier(CouleurPiece.NOIR, new Coordonnees(6, 7));
        Jeu.instance().getEchiquier()[1][7] = new Cavalier(CouleurPiece.NOIR, new Coordonnees(1, 7));
        //tours
        Jeu.instance().getEchiquier()[0][7] = new Tour(CouleurPiece.NOIR, new Coordonnees(0, 7));
        Jeu.instance().getEchiquier()[7][7] = new Tour(CouleurPiece.NOIR, new Coordonnees(7, 7));

        //PIONS
        for (int i = 0; i < 8; i++) {
            Jeu.instance().getEchiquier()[i][1] = new Pion(CouleurPiece.BLANC, new Coordonnees(i, 1));
            Jeu.instance().getEchiquier()[i][6] = new Pion(CouleurPiece.NOIR, new Coordonnees(i, 6));
        }
    }
}
