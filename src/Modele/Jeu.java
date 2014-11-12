package Modele;

import Erreur.NotYetImplementedException;
import Modele.*;
import Modele.Piece.*;

/**
 * Created by Paul on 19/10/2014.
 */

// Singleton jeu
public class Jeu {
    private Piece[][] echiquier;
    private Joueur jBlanc;
    private Joueur jNoir;

    public Roi getRoiBlanc() {
        return roiBlanc;
    }

    private Roi roiBlanc;

    public Roi getRoiNoir() {
        return roiNoir;
    }

    private Roi roiNoir;


    public void tourSuivant()
    {
        tour = (tour == CouleurJoueur.BLANC) ? CouleurJoueur.NOIR : CouleurJoueur.BLANC;
    }

    private CouleurJoueur tour = CouleurJoueur.BLANC;

    final private static Jeu jeu = new Jeu();



    //Singleton
    private Jeu() {
    }

    public  boolean verificationEchec (){
        return verifLigne(this.echiquier) && verifDiagonale(this.echiquier) && verifCavalier(this.echiquier);
    }

    public Piece getRoiBlanc() {
        return roiBlanc;
    }

    public void setRoiBlanc(Piece roiBlanc) {
        this.roiBlanc = roiBlanc;
    }

    public Piece getRoiNoir() {
        return roiNoir;
    }

    public void setRoiNoir(Piece roiNoir) {
        this.roiNoir = roiNoir;
    }

    public  boolean verificationEchec (Piece[][] echiquier){
            return verifLigne(echiquier) && verifDiagonale(echiquier) && verifCavalier(echiquier);
    }

    public static boolean verifCase(int x, int y){
        if(x > 7 || y > 7 || x < 0 || y < 0){
            return false;
        }
        return true;
    }

    public boolean verifLigne(Piece[][] echiquier){
        Piece p = null;
        int xRoi = (tour == CouleurJoueur.BLANC) ? roiBlanc.getCoordonnees().getX() : roiNoir.getCoordonnees().getX();
        int yRoi = (tour == CouleurJoueur.BLANC) ? roiBlanc.getCoordonnees().getY() : roiNoir.getCoordonnees().getY();

        //Vers le haut
        int x = xRoi;
        int y = yRoi + 1;
        while (verifCase(x, y)){
            p = echiquier[x][y];
            if(p != null){
                if( (p instanceof Tour || p instanceof Reine) && p.getCouleur() != tour) {
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
                if( (p instanceof Tour || p instanceof Reine) && p.getCouleur() != tour) {
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
                if( (p instanceof Tour || p instanceof Reine) && p.getCouleur() != tour) {
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
                if( (p instanceof Tour || p instanceof Reine) && p.getCouleur() != tour) {
                    return false;
                }
            }
            else
                break;
            x++;
        }




        return true;
    }

    private boolean verifCavalier(Piece[][] echiquier) {
        Piece p = null;
        int x = (tour ==CouleurJoueur.BLANC) ? roiBlanc.getCoordonnees().getX() : roiNoir.getCoordonnees().getX();
        int y = ((tour ==CouleurJoueur.BLANC) ? roiBlanc.getCoordonnees().getY() : roiNoir.getCoordonnees().getY());

        //la case existe + c'est un cavalier  + couleur adverse

        if(verifCase(x+1, y+2) && echiquier[x+1][y+2] instanceof Cavalier && echiquier [x+1][y+2].getCouleur() != tour){
            return false;
        }
        if(verifCase(x-1, y+2) && echiquier[x-1][y+2] instanceof Cavalier && echiquier [x-1][y+2].getCouleur() != tour){
            return false;
        }
        if(verifCase(x+1, y-2) && echiquier[x+1][y-2] instanceof Cavalier && echiquier [x+1][y-2].getCouleur() != tour){
            return false;
        }
        if(verifCase(x-1, y-2) && echiquier[x-1][y-2] instanceof Cavalier && echiquier [x-1][y-2].getCouleur() != tour){
            return false;
        }
        if(verifCase(x+2, y+1) && echiquier[x+2][y+1] instanceof Cavalier && echiquier [x+2][y+1].getCouleur() != tour){
            return false;
        }
        if(verifCase(x-2, y+1) && echiquier[x-2][y+1] instanceof Cavalier && echiquier [x-2][y+1].getCouleur() != tour){
            return false;
        }
        if(verifCase(x+2, y-1) && echiquier[x+2][y-1] instanceof Cavalier && echiquier [x+2][y-1].getCouleur() != tour){
            return false;
        }
        if(verifCase(x-2, y-1) && echiquier[x-2][y-1] instanceof Cavalier && echiquier [x-2][y-1].getCouleur() != tour){
            return false;
        }

        return true;
    }

    private boolean verifDiagonale(Piece[][] echiquier) {
        Piece p = null;
        int xRoi = (tour ==CouleurJoueur.BLANC) ? roiBlanc.getCoordonnees().getX() : roiNoir.getCoordonnees().getX();
        int yRoi = ((tour ==CouleurJoueur.BLANC) ? roiBlanc.getCoordonnees().getY() : roiNoir.getCoordonnees().getY());

        //Vers le haut-droit
        int x = xRoi + 1;
        int y = yRoi + 1;
        while (verifCase(x, y)){
            p = echiquier[x][y];
            if(p != null){
                if( (p instanceof Fou || p instanceof Reine) && p.getCouleur() != tour) {
                    return false;
                }
                if((x == xRoi +1) && (p instanceof Pion) && p.getCouleur() != tour) {
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
                if( (p instanceof Fou || p instanceof Reine) && p.getCouleur() != tour) {
                    return false;
                }
                if((x == xRoi +1) && (p instanceof Pion) && p.getCouleur() != tour) {
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
                if( (p instanceof Tour || p instanceof Reine) && p.getCouleur() != tour) {
                    return false;
                }
                if((x == xRoi - 1) && (p instanceof Pion) && p.getCouleur() != tour) {
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
                if( (p instanceof Tour || p instanceof Reine) && p.getCouleur() != tour) {
                    return false;
                }
                if((x == xRoi - 1) && (p instanceof Pion) && p.getCouleur() != tour) {
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


    public Piece getPiece(Coordonnees c){
        return echiquier[c.getX()][c.getY()];
    }

    public void setPiece(Piece p){
        echiquier[p.getCoordonnees().getX()][p.getCoordonnees().getY()] = p;
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
        // CouleurJoueur.BLANCS - Reine/Roi
        echiquier[3][0] =  new Reine(CouleurJoueur.BLANC, new Coordonnees(3,0));
        roiBlanc = new Roi(CouleurJoueur.BLANC, new Coordonnees(4,0));
        echiquier[4][0] =  roiBlanc;
        //fous
        echiquier[5][0] =  new Fou(CouleurJoueur.BLANC, new Coordonnees(5,0));
        echiquier[2][0] =  new Fou(CouleurJoueur.BLANC, new Coordonnees(2,0));
        //cavaliers
        echiquier[6][0] =  new Cavalier(CouleurJoueur.BLANC, new Coordonnees(6,0));
        echiquier[1][0] =  new Cavalier(CouleurJoueur.BLANC, new Coordonnees(1,0));
        //tours
        echiquier[0][0] =  new Tour(CouleurJoueur.BLANC, new Coordonnees(0,0));
        echiquier[7][0] =  new Tour	(CouleurJoueur.BLANC, new Coordonnees(7,0));

        // CouleurJoueur.NOIRS - Reine/Roi
        echiquier[3][7] =  new Reine	(CouleurJoueur.NOIR, new Coordonnees(3,0));
        roiNoir = new Roi (CouleurJoueur.NOIR, new Coordonnees(4,0));
        echiquier[4][7] =  roiNoir;
        //fous
        echiquier[5][7] =  new Fou(CouleurJoueur.NOIR, new Coordonnees(5,0));
        echiquier[2][7] =  new Fou(CouleurJoueur.NOIR, new Coordonnees(2,0));
        //cavaliers
        echiquier[6][7] =  new Cavalier(CouleurJoueur.NOIR, new Coordonnees(6,0));
        echiquier[1][7] =  new Cavalier(CouleurJoueur.NOIR, new Coordonnees(1,0));
        //tours
        echiquier[0][7] =  new Tour	(CouleurJoueur.NOIR, new Coordonnees(0,0));
        echiquier[7][7] =  new Tour	(CouleurJoueur.NOIR, new Coordonnees(7,0));

        //PIONS
        for(int i=0; i<8; i++) {
            echiquier[i][1] = new Pion(CouleurJoueur.BLANC, new Coordonnees(i, 1));
            echiquier[i][6] = new Pion(CouleurJoueur.NOIR, new Coordonnees(i, 6));
        }
    }

    public void setEchiquier(Piece[][] echiquier) {
        this.echiquier = echiquier;
    }
}
