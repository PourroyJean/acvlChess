package Controleur.Visiteur;

import Erreur.NotYetImplementedException;
import Modele.Piece.Coordonnees;
import Modele.Jeu;
import Modele.Piece.*;

import java.util.Vector;

/**
 * Created by Paul on 06/11/2014.
 */
public class DeplacementsPossibles implements  Visiteur{
    Vector<Coordonnees> deplacementsPossibles;
    public DeplacementsPossibles(){
        deplacementsPossibles = new Vector<Coordonnees>();
    }
    @Override
    public void visite(Pion pion) throws NotYetImplementedException {
        Piece[][] echiquier = Jeu.instance().getEchiquier();
        Piece p;
        int xi = pion.getCoordonnees().getX();
        int yi = pion.getCoordonnees().getY();
        int x, y;

        // Indique la direction si blanc pion avance en +1 si noir, avance en -1
        int dy = pion.isBlanc() ? 1 : -1;

        // En avant
        x = xi;
        y = yi + dy;
        if(Jeu.verifCase(x, y) && ((p = echiquier[x][y]) == null)) {
            addDeplacementPossible(pion, new Coordonnees(x, y));
            if(((pion.isBlanc() && yi == 1) || (!pion.isBlanc() && yi == 6)) && Jeu.verifCase(x, y+dy) && ((p = echiquier[x][y]) == null)) {
                addDeplacementPossible(pion, new Coordonnees(x, y+dy));
            }
        }

        // En avant-droit
        x = xi + 1;
        y = yi + dy;
        if(Jeu.verifCase(x, y) && ((p = echiquier[x][y]) != null && p.isBlanc() != pion.isBlanc())) {
            addDeplacementPossible(pion, new Coordonnees(x, y));
        }

        // En avant-gauche
        x = xi - 1;
        y = yi + dy;
        if(Jeu.verifCase(x, y) && ((p = echiquier[x][y]) != null && p.isBlanc() != pion.isBlanc())) {
            addDeplacementPossible(pion, new Coordonnees(x, y));
        }
    }

    @Override
    public void visite(Cavalier cavalier) throws NotYetImplementedException {
        Piece[][] echiquier = Jeu.instance().getEchiquier();
        Piece p;
        int xi = cavalier.getCoordonnees().getX();
        int yi = cavalier.getCoordonnees().getY();
        int x, y;

        //2Haut-Droit
        x = xi + 1;
        y = yi + 2;
        if(Jeu.verifCase(x, y) && ((p = echiquier[x][y]) == null || p.isBlanc() != cavalier.isBlanc())) {
            addDeplacementPossible(cavalier, new Coordonnees(x, y));
        }

        //2Haut-Gauche
        x = xi - 1;
        y = yi + 2;
        if(Jeu.verifCase(x, y) && ((p = echiquier[x][y]) == null || p.isBlanc() != cavalier.isBlanc())) {
            addDeplacementPossible(cavalier, new Coordonnees(x, y));
        }

        //Haut-Droit
        x = xi + 2;
        y = yi + 1;
        if(Jeu.verifCase(x, y) && ((p = echiquier[x][y]) == null || p.isBlanc() != cavalier.isBlanc())) {
            addDeplacementPossible(cavalier, new Coordonnees(x, y));
        }

        //Haut-Gauche
        x = xi - 2;
        y = yi + 1;
        if(Jeu.verifCase(x, y) && ((p = echiquier[x][y]) == null || p.isBlanc() != cavalier.isBlanc())) {
            addDeplacementPossible(cavalier, new Coordonnees(x, y));
        }

        //2Bas-Droit
        x = xi + 1;
        y = yi - 2;
        if(Jeu.verifCase(x, y) && ((p = echiquier[x][y]) == null || p.isBlanc() != cavalier.isBlanc())) {
            addDeplacementPossible(cavalier, new Coordonnees(x, y));
        }

        //2Bas-Gauche
        x = xi - 1;
        y = yi - 2;
        if(Jeu.verifCase(x, y) && ((p = echiquier[x][y]) == null || p.isBlanc() != cavalier.isBlanc())) {
            addDeplacementPossible(cavalier, new Coordonnees(x, y));
        }

        //Bas-Droit
        x = xi + 2;
        y = yi - 1;
        if(Jeu.verifCase(x, y) && ((p = echiquier[x][y]) == null || p.isBlanc() != cavalier.isBlanc())) {
            addDeplacementPossible(cavalier, new Coordonnees(x, y));
        }

        //Bas-Gauche
        x = xi - 2;
        y = yi - 1;
        if(Jeu.verifCase(x, y) && ((p = echiquier[x][y]) == null || p.isBlanc() != cavalier.isBlanc())) {
            addDeplacementPossible(cavalier, new Coordonnees(x, y));
        }
    }

    @Override
    public void visite(Fou fou) throws NotYetImplementedException {

        Piece[][] echiquier = Jeu.instance().getEchiquier();
        Piece p;
        int xi = fou.getCoordonnees().getX();
        int yi = fou.getCoordonnees().getY();
        int x, y;
        //En haut-droite
        x = xi+1;
        y = yi+1;
        while(Jeu.verifCase(x, y)) {
            if((p = echiquier[x][y]) != null) {
                if(p.isBlanc() != fou.isBlanc()) {
                    addDeplacementPossible(fou, p.getCoordonnees());
                }
                break;
            } else {
                addDeplacementPossible(fou, new Coordonnees(x, y));
            }
            y++;
            x++;
        }


        //En haut-gauche
        x = xi-1;
        y = yi+1;
        while(Jeu.verifCase(x, y)) {
            if((p = echiquier[x][y]) != null) {
                if(p.isBlanc() != fou.isBlanc()) {
                    addDeplacementPossible(fou, p.getCoordonnees());
                }
                break;
            } else {
                addDeplacementPossible(fou, new Coordonnees(x, y));
            }
            y++;
            x--;
        }

        //En bas-droite
        x = xi+1;
        y = yi-1;
        while(Jeu.verifCase(x, y)) {
            if((p = echiquier[x][y]) != null) {
                if(p.isBlanc() != fou.isBlanc()) {
                    addDeplacementPossible(fou, p.getCoordonnees());
                }
                break;
            } else {
                addDeplacementPossible(fou, new Coordonnees(x, y));
            }
            y--;
            x++;
        }

        //En bas-gauche
        x = xi-1;
        y = yi-1;
        while(Jeu.verifCase(x, y)) {
            if((p = echiquier[x][y]) != null) {
                if(p.isBlanc() != fou.isBlanc()) {
                    addDeplacementPossible(fou, p.getCoordonnees());
                }
                break;
            } else {
                addDeplacementPossible(fou, new Coordonnees(x, y));
            }
            y--;
            x--;
        }
    }

    @Override
    public void visite(Tour tour){

        Piece[][] echiquier = Jeu.instance().getEchiquier();
        Piece p;
        int xi = tour.getCoordonnees().getX();
        int yi = tour.getCoordonnees().getY();
        int x, y;
        //En haut
        x = xi;
        y = yi+1;
        while(Jeu.verifCase(x, y)) {
            if((p = echiquier[x][y]) != null) {
                if(p.isBlanc() != tour.isBlanc()) {
                    addDeplacementPossible(tour, p.getCoordonnees());
                }
                break;
            } else {
                addDeplacementPossible(tour, new Coordonnees(x, y));
            }
            y++;
        }


        //En bas
        x = xi;
        y = yi-1;
        while(Jeu.verifCase(x, y)) {
            if((p = echiquier[x][y]) != null) {
                if(p.isBlanc() != tour.isBlanc()) {
                    addDeplacementPossible(tour, p.getCoordonnees());
                }
                break;
            } else {
                addDeplacementPossible(tour, new Coordonnees(x, y));
            }
            y--;
        }

        //A droite
        x = xi+1;
        y = yi;
        while(Jeu.verifCase(x, y)) {
            if((p = echiquier[x][y]) != null) {
                if(p.isBlanc() != tour.isBlanc()) {
                    addDeplacementPossible(tour, p.getCoordonnees());
                }
                break;
            } else {
                addDeplacementPossible(tour, new Coordonnees(x, y));
            }
            x++;
        }

        //A gauche
        x = xi-1;
        y = yi;
        while(Jeu.verifCase(x, y)) {
            if((p = echiquier[x][y]) != null) {
                if(p.isBlanc() != tour.isBlanc()) {
                    addDeplacementPossible(tour, p.getCoordonnees());
                }
                break;
            } else {
                addDeplacementPossible(tour, new Coordonnees(x, y));
            }
            x--;
        }

    }

    @Override
    public void visite(Roi roi) throws NotYetImplementedException {
        Piece[][] echiquier = Jeu.instance().getEchiquier();
        int saveX = roi.getCoordonnees().getX();
        int saveY = roi.getCoordonnees().getY();
        Piece p;
        int x, y;
        Coordonnees tmp;

        //Haut
        x = saveX;
        y = saveY + 1;
        if(Jeu.verifCase(x, y) && ((p=echiquier[x][y]) == null || p.isBlanc() != roi.isBlanc())) {
            tmp = new Coordonnees(x, y);
            roi.setCoordonnees(tmp);
            if(Jeu.instance().verificationEchec()) {
                addDeplacementPossible(roi, tmp);
            }
        }

        //Haut-Droit
        x = saveX + 1;
        y = saveY + 1;
        if(Jeu.verifCase(x, y) && ((p=echiquier[x][y]) == null || p.isBlanc() != roi.isBlanc())) {
            tmp = new Coordonnees(x, y);
            roi.setCoordonnees(tmp);
            if(Jeu.instance().verificationEchec()) {
                addDeplacementPossible(roi, tmp);
            }
        }

        //Haut-Gauche
        x = saveX - 1;
        y = saveY + 1;
        if(Jeu.verifCase(x, y) && ((p=echiquier[x][y]) == null || p.isBlanc() != roi.isBlanc())) {
            tmp = new Coordonnees(x, y);
            roi.setCoordonnees(tmp);
            if(Jeu.instance().verificationEchec()) {
                addDeplacementPossible(roi, tmp);
            }
        }

        //Droite
        x = saveX + 1;
        y = saveY;
        if(Jeu.verifCase(x, y) && ((p=echiquier[x][y]) == null || p.isBlanc() != roi.isBlanc())) {
            tmp = new Coordonnees(x, y);
            roi.setCoordonnees(tmp);
            if(Jeu.instance().verificationEchec()) {
                addDeplacementPossible(roi, tmp);
            }
        }

        //Gauche
        x = saveX - 1;
        y = saveY;
        if(Jeu.verifCase(x, y) && ((p=echiquier[x][y]) == null || p.isBlanc() != roi.isBlanc())) {
            tmp = new Coordonnees(x, y);
            roi.setCoordonnees(tmp);
            if(Jeu.instance().verificationEchec()) {
                addDeplacementPossible(roi, tmp);
            }
        }

        //Haut
        x = saveX;
        y = saveY - 1;
        if(Jeu.verifCase(x, y) && ((p=echiquier[x][y]) == null || p.isBlanc() != roi.isBlanc())) {
            tmp = new Coordonnees(x, y);
            roi.setCoordonnees(tmp);
            if(Jeu.instance().verificationEchec()) {
                addDeplacementPossible(roi, tmp);
            }
        }

        //Bas-Droit
        x = saveX + 1;
        y = saveY - 1;
        if(Jeu.verifCase(x, y) && (((p = echiquier[x][y]) == null) || (p.isBlanc() != roi.isBlanc()))) {
            tmp = new Coordonnees(x, y);
            roi.setCoordonnees(tmp);
            if(Jeu.instance().verificationEchec()) {
                addDeplacementPossible(roi, tmp);
            }
        }

        //Bas-Gauche
        x = saveX - 1;
        y = saveY - 1;
        if(Jeu.verifCase(x, y) && ((echiquier[x][y]) == null)) {
            tmp = new Coordonnees(x, y);
            roi.setCoordonnees(tmp);
            if(Jeu.instance().verificationEchec()) {
                addDeplacementPossible(roi, tmp);
            }
        }

        roi.setCoordonnees(new Coordonnees(saveX, saveY));
    }

    @Override
    public void visite(Reine reine) throws NotYetImplementedException {

    Piece[][] echiquier = Jeu.instance().getEchiquier();
    Piece p;
    // Deplacements comme TOUR
        int xi = reine.getCoordonnees().getX();
        int yi = reine.getCoordonnees().getY();
        int x, y;
            //En haut
            x = xi;
            y = yi + 1;
            while (Jeu.verifCase(x, y)) {
                if ((p = echiquier[x][y]) != null) {
                    if (p.isBlanc() != reine.isBlanc()) {
                        addDeplacementPossible(reine, p.getCoordonnees());
                    }
                    break;
                } else {
                    addDeplacementPossible(reine, new Coordonnees(x, y));
                }
                y++;
            }


            //En bas
            x = xi;
            y = yi - 1;
            while (Jeu.verifCase(x, y)) {
                if ((p = echiquier[x][y]) != null) {
                    if (p.isBlanc() != reine.isBlanc()) {
                        addDeplacementPossible(reine, p.getCoordonnees());
                    }
                    break;
                } else {
                    addDeplacementPossible(reine, new Coordonnees(x, y));
                }
                y--;
            }

            //A droite
            x = xi + 1;
            y = yi;
            while (Jeu.verifCase(x, y)) {
                if ((p = echiquier[x][y]) != null) {
                    if (p.isBlanc() != reine.isBlanc()) {
                        addDeplacementPossible(reine, p.getCoordonnees());
                    }
                    break;
                } else {
                    addDeplacementPossible(reine, new Coordonnees(x, y));
                }
                x++;
            }

            //A gauche
            x = xi - 1;
            y = yi;
            while (Jeu.verifCase(x, y)) {
                if ((p = echiquier[x][y]) != null) {
                    if (p.isBlanc() != reine.isBlanc()) {
                        addDeplacementPossible(reine, p.getCoordonnees());
                    }
                    break;
                } else {
                    addDeplacementPossible(reine, new Coordonnees(x, y));

                }
                x--;
            }

    // Partie Diagonnale (= fou)
        //En haut-droite
        x = xi+1;
        y = yi+1;
        while(Jeu.verifCase(x, y)) {
            if((p = echiquier[x][y]) != null) {
                if(p.isBlanc() != reine.isBlanc()) {
                    addDeplacementPossible(reine, p.getCoordonnees());
                }
                break;
            } else {
                addDeplacementPossible(reine, new Coordonnees(x, y));

            }
            y++;
            x++;
        }


        //En haut-gauche
        x = xi-1;
        y = yi+1;
        while(Jeu.verifCase(x, y)) {
            if((p = echiquier[x][y]) != null) {
                if(p.isBlanc() != reine.isBlanc()) {
                    addDeplacementPossible(reine, p.getCoordonnees());
                }
                break;
            } else {
                addDeplacementPossible(reine, new Coordonnees(x, y));
            }
            y++;
            x--;
        }

        //En bas-droite
        x = xi+1;
        y = yi-1;
        while(Jeu.verifCase(x, y)) {
            if((p = echiquier[x][y]) != null) {
                if(p.isBlanc() != reine.isBlanc()) {
                    addDeplacementPossible(reine, p.getCoordonnees());
                }
                break;
            } else {
                addDeplacementPossible(reine, new Coordonnees(x, y));
            }
            y--;
            x++;
        }

        //En bas-gauche
        x = xi-1;
        y = yi-1;
        while(Jeu.verifCase(x, y)) {
            if((p = echiquier[x][y]) != null) {
                if(p.isBlanc() != reine.isBlanc()) {
                    addDeplacementPossible(reine, p.getCoordonnees());
                }
                break;
            } else {
                addDeplacementPossible(reine, new Coordonnees(x, y));
            }
            y--;
            x--;
        }

}


    public void addDeplacementPossible(Piece p, Coordonnees c) {
        Coordonnees ancienneCoord = p.getCoordonnees();
        Piece ancienEch = Jeu.instance().getEchiquier()[c.getX()][c.getY()];
        Jeu.instance().getEchiquier()[p.getCoordonnees().getX()][p.getCoordonnees().getY()] = null;
        Jeu.instance().getEchiquier()[c.getX()][c.getY()] = p;
        p.setCoordonnees(c);
        boolean ech = Jeu.instance().verificationEchec();
        Jeu.instance().getEchiquier()[ancienneCoord.getX()][ancienneCoord.getY()] = p;
        Jeu.instance().getEchiquier()[c.getX()][c.getY()] = ancienEch;
        p.setCoordonnees(ancienneCoord);
        if(ech)
            deplacementsPossibles.add(c);
    }

    public Vector<Coordonnees> getDeplacementsPossibles() {
        return deplacementsPossibles;
    }
}
