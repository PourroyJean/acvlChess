package Modèle;

import Erreur.NotYetImplementedException;
import Modèle.Pièce.*;

/**
 * Created by Paul on 19/10/2014.
 */

// Singleton jeu
public class Jeu {
    private Piece[][] echiquier;
    private Joueur jBlanc;
    private Joueur jNoir;
    private Piece roiBlanc;
    private Piece roiNoir;
    private boolean tour = true; // true = blanc
    final private static Jeu jeu = new Jeu();
    private static boolean BLANC = true;
    private static boolean NOIR  = false;


    //Singleton
    private Jeu() {
    }

    public  boolean verificationEchec (){
            return verifLigne() && verifDiagonale() && verifCavalier();
    }

    public boolean verifCase (int x, int y){
        if(x > 7 || y > 7 || x < 0 || y < 0){
            return false;
        }
        return true;
    }

    public boolean verifLigne(){
        Piece p = null;
        int xRoi = (BLANC) ? roiBlanc.getCoordonnee().getX() : roiNoir.getCoordonnee().getX();
        int yRoi = ((BLANC) ? roiBlanc.getCoordonnee().getY() : roiNoir.getCoordonnee().getY());

        //Vers le haut
        int x = xRoi;
        int y = yRoi + 1;
        while (verifCase(x, y)){
            p = echiquier[x][y];
            if(p != null){
                if( (p instanceof Tour || p instanceof Reine) && p.isBlanc() != tour) {
                    return false;
                }
            }
            else
                break;
            y++;
        }


        //Vers le bas
        x = xRoi;
        y = yRoi - 1;
        while (verifCase(x, y)){
            p = echiquier[x][y];
            if(p != null){
                if( (p instanceof Tour || p instanceof Reine) && p.isBlanc() != tour) {
                    return false;
                }
            }
            else
                break;
            y--;
        }


        //Vers la gauche
        x = xRoi - 1;
        y = yRoi;
        while (verifCase(x, y)){
            p = echiquier[x][y];
            if(p != null){
                if( (p instanceof Tour || p instanceof Reine) && p.isBlanc() != tour) {
                    return false;
                }

            }
            else
                break;
            x--;
        }

        //Vers la droite
        x = xRoi + 1;
        y = yRoi;
        while (verifCase(x, y)){
            p = echiquier[x][y];
            if(p != null){
                if( (p instanceof Tour || p instanceof Reine) && p.isBlanc() != tour) {
                    return false;
                }
            }
            else
                break;
            x++;
        }




        return true;
    }

    private boolean verifCavalier() {
        Piece p = null;
        int x = (BLANC) ? roiBlanc.getCoordonnee().getX() : roiNoir.getCoordonnee().getX();
        int y = ((BLANC) ? roiBlanc.getCoordonnee().getY() : roiNoir.getCoordonnee().getY());

        //la case existe + c'est un cavalier  + couleur adverse

        if(verifCase(x+1, y+2) && echiquier[x+1][y+2] instanceof Cavalier && echiquier [x+1][y+2].isBlanc() != tour){
            return false;
        }
        if(verifCase(x-1, y+2) && echiquier[x-1][y+2] instanceof Cavalier && echiquier [x-1][y+2].isBlanc() != tour){
            return false;
        }
        if(verifCase(x+1, y-2) && echiquier[x+1][y-2] instanceof Cavalier && echiquier [x+1][y-2].isBlanc() != tour){
            return false;
        }
        if(verifCase(x-1, y-2) && echiquier[x-1][y-2] instanceof Cavalier && echiquier [x-1][y-2].isBlanc() != tour){
            return false;
        }
        if(verifCase(x+2, y+1) && echiquier[x+2][y+1] instanceof Cavalier && echiquier [x+2][y+1].isBlanc() != tour){
            return false;
        }
        if(verifCase(x-2, y+1) && echiquier[x-2][y+1] instanceof Cavalier && echiquier [x-2][y+1].isBlanc() != tour){
            return false;
        }
        if(verifCase(x+2, y-1) && echiquier[x+2][y-1] instanceof Cavalier && echiquier [x+2][y-1].isBlanc() != tour){
            return false;
        }
        if(verifCase(x-2, y-1) && echiquier[x-2][y-1] instanceof Cavalier && echiquier [x-2][y-1].isBlanc() != tour){
            return false;
        }

        return true;
    }

    private boolean verifDiagonale() {
        Piece p = null;
        int xRoi = (BLANC) ? roiBlanc.getCoordonnee().getX() : roiNoir.getCoordonnee().getX();
        int yRoi = ((BLANC) ? roiBlanc.getCoordonnee().getY() : roiNoir.getCoordonnee().getY());

        //Vers le haut-droit
        int x = xRoi + 1;
        int y = yRoi + 1;
        while (verifCase(x, y)){
            p = echiquier[x][y];
            if(p != null){
                if( (p instanceof Fou || p instanceof Reine) && p.isBlanc() != tour) {
                    return false;
                }
                if((x == xRoi +1) && (p instanceof Pion) && p.isBlanc() != tour) {
                    return false;
                }
            }
            else
                break;
            y++;
            x++;
        }


        //Vers le bas-droit
        x = xRoi + 1;
        y = yRoi - 1;
        while (verifCase(x, y)){
            p = echiquier[x][y];
            if(p != null){
                if( (p instanceof Fou || p instanceof Reine) && p.isBlanc() != tour) {
                    return false;
                }
                if((x == xRoi +1) && (p instanceof Pion) && p.isBlanc() != tour) {
                    return false;
                }
            }
            else
                break;
            x++;
            y--;
        }


        //Vers le haut-gauche
        x = xRoi - 1;
        y = yRoi + 1;
        while (verifCase(x, y)){
            p = echiquier[x][y];
            if(p != null){
                if( (p instanceof Tour || p instanceof Reine) && p.isBlanc() != tour) {
                    return false;
                }
                if((x == xRoi - 1) && (p instanceof Pion) && p.isBlanc() != tour) {
                    return false;
                }
            }
            else
                break;
            x--;
            y++;
        }

        //Vers le bas-gauche
        x = xRoi - 1;
        y = yRoi - 1;
        while (verifCase(x, y)){
            p = echiquier[x][y];
            if(p != null){
                if( (p instanceof Tour || p instanceof Reine) && p.isBlanc() != tour) {
                    return false;
                }
                if((x == xRoi - 1) && (p instanceof Pion) && p.isBlanc() != tour) {
                    return false;
                }
            }
            else
                break;
            x--;
            y--;
        }

        return true;
    }



    public static Jeu instance() {
        return jeu;
    }

    public Piece[][] getEchiquier() {
        return echiquier;
    }

    public void init(Joueur blanc, Joueur noir) throws NotYetImplementedException {


        //Création des 2 joueurs
        jBlanc   = blanc;
        jNoir    = noir;

        //Creation echiquier
        echiquier = new Piece[8][8];
        // BLANCS - Reine/Roi
        echiquier[3][0] =  new Reine(BLANC, new Coordonnee(3,0));
        roiBlanc = new Roi(BLANC, new Coordonnee(4,0));
        echiquier[4][0] =  roiBlanc;
        //fous
        echiquier[5][0] =  new Fou(BLANC, new Coordonnee(5,0));
        echiquier[2][0] =  new Fou(BLANC, new Coordonnee(2,0));
        //cavaliers
        echiquier[6][0] =  new Cavalier(BLANC, new Coordonnee(6,0));
        echiquier[1][0] =  new Cavalier(BLANC, new Coordonnee(1,0));
        //tours
        echiquier[0][0] =  new Tour(BLANC, new Coordonnee(0,0));
        echiquier[7][0] =  new Tour	(BLANC, new Coordonnee(7,0));

        // NOIRS - Reine/Roi
        echiquier[3][7] =  new Reine	(NOIR, new Coordonnee(3,0));
        roiNoir = new Roi (NOIR, new Coordonnee(4,0));
        echiquier[4][7] =  roiNoir;
        //fous
        echiquier[5][7] =  new Fou(NOIR, new Coordonnee(5,0));
        echiquier[2][7] =  new Fou(NOIR, new Coordonnee(2,0));
        //cavaliers
        echiquier[6][7] =  new Cavalier(NOIR, new Coordonnee(6,0));
        echiquier[1][7] =  new Cavalier(NOIR, new Coordonnee(1,0));
        //tours
        echiquier[0][7] =  new Tour	(NOIR, new Coordonnee(0,0));
        echiquier[7][7] =  new Tour	(NOIR, new Coordonnee(7,0));

        //PIONS
        for(int i=0; i<8; i++) {
            echiquier[i][1] = new Pion(BLANC, new Coordonnee(i, 1));
            echiquier[i][6] = new Pion(NOIR, new Coordonnee(i, 6));
        }
    }

}
