package Modele;

import Erreur.NotYetImplementedException;
import Modele.Piece.*;

/**
 * Created by Paul on 19/10/2014.
 */

// Singleton jeu
public class Jeu extends Sujet {
    private Piece[][] echiquier;
    private Joueur jBlanc;
    private Joueur jNoir;
    private CouleurPiece tour = CouleurPiece.BLANC;

    final private static Jeu jeu = new Jeu();
    private static boolean BLANC = true;
    private static boolean NOIR = false;

    private Roi roiBlanc;
    private Roi roiNoir;

    public Pion getPriseEnPassant() {
        return priseEnPassant;
    }

    public void setPriseEnPassant(Pion priseEnPassant) {
        this.priseEnPassant = priseEnPassant;
    }

    //Dernier pion deplacé de deux cases (pour la prise en passant)
    private Pion priseEnPassant = null;


    public Roi getRoiBlanc() {
        return roiBlanc;
    }



    public Roi getRoiNoir() {
        return roiNoir;
    }




    public void tourSuivant() {
        tour = (tour == CouleurPiece.BLANC) ? CouleurPiece.NOIR : CouleurPiece.BLANC;
    }


    public CouleurPiece getTour() {
        return tour;
    }

    //Singleton
    private Jeu() {
    }

    // Returns False if echec
    public boolean verificationEchec() {
        return verifLigne(this.echiquier) && verifDiagonale(this.echiquier) && verifCavalier(this.echiquier);
    }


    public void setRoiBlanc(Roi roiBlanc) {
        this.roiBlanc = roiBlanc;
    }


    public void setRoiNoir(Roi roiNoir) {
        this.roiNoir = roiNoir;
    }

    public boolean verificationEchec(Piece[][] echiquier) {
        return verifLigne(echiquier) && verifDiagonale(echiquier) && verifCavalier(echiquier);
    }

    public static boolean verifCase(int x, int y) {
        if (x > 7 || y > 7 || x < 0 || y < 0) {
            return false;
        }
        return true;
    }

    public boolean verifLigne(Piece[][] echiquier) {
        Piece p = null;
        int xRoi = (tour == CouleurPiece.BLANC) ? roiBlanc.getCoordonnees().getX() : roiNoir.getCoordonnees().getX();
        int yRoi = (tour == CouleurPiece.BLANC) ? roiBlanc.getCoordonnees().getY() : roiNoir.getCoordonnees().getY();

        //Vers le haut
        int x = xRoi;
        int y = yRoi + 1;
        while (verifCase(x, y)) {
            p = echiquier[x][y];
            if (p != null) {
                if ((p instanceof Tour || p instanceof Reine) && p.getCouleur() != tour) {
                    return false;
                }
            } else
                break;
            y++;
        }


        //Vers le bas
        x = xRoi;
        y = yRoi - 1;
        while (verifCase(x, y)) {
            p = echiquier[x][y];
            if (p != null) {
                if ((p instanceof Tour || p instanceof Reine) && p.getCouleur() != tour) {
                    return false;
                }
            } else
                break;
            y--;
        }


        //Vers la gauche
        x = xRoi - 1;
        y = yRoi;
        while (verifCase(x, y)) {
            p = echiquier[x][y];
            if (p != null) {
                if ((p instanceof Tour || p instanceof Reine) && p.getCouleur() != tour) {
                    return false;
                }

            } else
                break;
            x--;
        }

        //Vers la droite
        x = xRoi + 1;
        y = yRoi;
        while (verifCase(x, y)) {
            p = echiquier[x][y];
            if (p != null) {
                if ((p instanceof Tour || p instanceof Reine) && p.getCouleur() != tour) {
                    return false;
                }
            } else
                break;
            x++;
        }


        return true;
    }

    private boolean verifCavalier(Piece[][] echiquier) {
        Piece p = null;
        int x = (tour == CouleurPiece.BLANC) ? roiBlanc.getCoordonnees().getX() : roiNoir.getCoordonnees().getX();
        int y = ((tour == CouleurPiece.BLANC) ? roiBlanc.getCoordonnees().getY() : roiNoir.getCoordonnees().getY());

        //la case existe + c'est un cavalier  + couleur adverse

        if (verifCase(x + 1, y + 2) && echiquier[x + 1][y + 2] instanceof Cavalier && echiquier[x + 1][y + 2].getCouleur() != tour) {
            return false;
        }
        if (verifCase(x - 1, y + 2) && echiquier[x - 1][y + 2] instanceof Cavalier && echiquier[x - 1][y + 2].getCouleur() != tour) {
            return false;
        }
        if (verifCase(x + 1, y - 2) && echiquier[x + 1][y - 2] instanceof Cavalier && echiquier[x + 1][y - 2].getCouleur() != tour) {
            return false;
        }
        if (verifCase(x - 1, y - 2) && echiquier[x - 1][y - 2] instanceof Cavalier && echiquier[x - 1][y - 2].getCouleur() != tour) {
            return false;
        }
        if (verifCase(x + 2, y + 1) && echiquier[x + 2][y + 1] instanceof Cavalier && echiquier[x + 2][y + 1].getCouleur() != tour) {
            return false;
        }
        if (verifCase(x - 2, y + 1) && echiquier[x - 2][y + 1] instanceof Cavalier && echiquier[x - 2][y + 1].getCouleur() != tour) {
            return false;
        }
        if (verifCase(x + 2, y - 1) && echiquier[x + 2][y - 1] instanceof Cavalier && echiquier[x + 2][y - 1].getCouleur() != tour) {
            return false;
        }
        if (verifCase(x - 2, y - 1) && echiquier[x - 2][y - 1] instanceof Cavalier && echiquier[x - 2][y - 1].getCouleur() != tour) {
            return false;
        }

        return true;
    }

    private boolean verifDiagonale(Piece[][] echiquier) {
        Piece p = null;
        int xRoi = (tour == CouleurPiece.BLANC) ? roiBlanc.getCoordonnees().getX() : roiNoir.getCoordonnees().getX();
        int yRoi = ((tour == CouleurPiece.BLANC) ? roiBlanc.getCoordonnees().getY() : roiNoir.getCoordonnees().getY());

        //Vers le haut-droit
        int x = xRoi + 1;
        int y = yRoi + 1;
        while (verifCase(x, y)) {
            p = echiquier[x][y];
            if (p != null) {
                if ((p instanceof Fou || p instanceof Reine) && p.getCouleur() != tour) {
                    return false;
                }
                if ((x == xRoi + 1) && (p instanceof Pion) && p.getCouleur() != tour) {
                    return false;
                }
            } else
                break;
            y++;
            x++;
        }


        //Vers le bas-droit
        x = xRoi + 1;
        y = yRoi - 1;
        while (verifCase(x, y)) {
            p = echiquier[x][y];
            if (p != null) {
                if ((p instanceof Fou || p instanceof Reine) && p.getCouleur() != tour) {
                    return false;
                }
                if ((x == xRoi + 1) && (p instanceof Pion) && p.getCouleur() != tour) {
                    return false;
                }
            } else
                break;
            x++;
            y--;
        }


        //Vers le haut-gauche
        x = xRoi - 1;
        y = yRoi + 1;
        while (verifCase(x, y)) {
            p = echiquier[x][y];
            if (p != null) {
                if ((p instanceof Tour || p instanceof Reine) && p.getCouleur() != tour) {
                    return false;
                }
                if ((x == xRoi - 1) && (p instanceof Pion) && p.getCouleur() != tour) {
                    return false;
                }
            } else
                break;
            x--;
            y++;
        }

        //Vers le bas-gauche
        x = xRoi - 1;
        y = yRoi - 1;
        while (verifCase(x, y)) {
            p = echiquier[x][y];
            if (p != null) {
                if ((p instanceof Tour || p instanceof Reine) && p.getCouleur() != tour) {
                    return false;
                }
                if ((x == xRoi - 1) && (p instanceof Pion) && p.getCouleur() != tour) {
                    return false;
                }
            } else
                break;
            x--;
            y--;
        }

        return true;
    }


    public Piece getPiece(Coordonnees c) {
        return echiquier[c.getX()][c.getY()];
    }


    public static Jeu instance() {
        return jeu;
    }

    public Piece[][] getEchiquier() {
        return echiquier;
    }

    public void init(Joueur blanc, Joueur noir) throws NotYetImplementedException {


        //Les blancs commencent
        tour = CouleurPiece.BLANC;

        //Création des 2 joueurs
        jBlanc = blanc;
        jNoir = noir;


        //Creation echiquier
        echiquier = new Piece[8][8];
        // BLANCS - Reine/Roi
        echiquier[3][0] = new Reine(CouleurPiece.BLANC, new Coordonnees(3,0));
        roiBlanc = new Roi(CouleurPiece.BLANC, new Coordonnees(4,0));
        echiquier[4][0] = roiBlanc;
        //fous
        echiquier[5][0] = new Fou(CouleurPiece.BLANC, new Coordonnees(5, 0));
        echiquier[2][0] = new Fou(CouleurPiece.BLANC, new Coordonnees(2, 0));
        //cavaliers
        echiquier[6][0] = new Cavalier(CouleurPiece.BLANC, new Coordonnees(6, 0));
        echiquier[1][0] = new Cavalier(CouleurPiece.BLANC, new Coordonnees(1, 0));
        //tours
        echiquier[0][0] = new Tour(CouleurPiece.BLANC, new Coordonnees(0, 0));
        echiquier[7][0] = new Tour(CouleurPiece.BLANC, new Coordonnees(7, 0));

        // NOIRS - Reine/Roi
        echiquier[3][7] = new Reine(CouleurPiece.NOIR, new Coordonnees(3, 7));
        roiNoir = new Roi(CouleurPiece.NOIR, new Coordonnees(4, 7));
        echiquier[4][7] = roiNoir;
        //fous
        echiquier[2][7] = new Fou(CouleurPiece.NOIR, new Coordonnees(2, 7));
        echiquier[5][7] = new Fou(CouleurPiece.NOIR, new Coordonnees(5, 7));
        //cavaliers
        echiquier[6][7] = new Cavalier(CouleurPiece.NOIR, new Coordonnees(6, 7));
        echiquier[1][7] = new Cavalier(CouleurPiece.NOIR, new Coordonnees(1, 7));
        //tours
        echiquier[0][7] = new Tour(CouleurPiece.NOIR, new Coordonnees(0, 7));
        echiquier[7][7] = new Tour(CouleurPiece.NOIR, new Coordonnees(7, 7));

        //PIONS
        for (int i = 0; i < 8; i++) {
            echiquier[i][1] = new Pion(CouleurPiece.BLANC, new Coordonnees(i, 1));
            echiquier[i][6] = new Pion(CouleurPiece.NOIR, new Coordonnees(i, 6));
        }
    }

    public static String parseNomPiece(String str) {
        return str.split("\\.")[2];
    }

    public void setEchiquier(Piece[][] echiquier) {
        this.echiquier = echiquier;
    }

}
