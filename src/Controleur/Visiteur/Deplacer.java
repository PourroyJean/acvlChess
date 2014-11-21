package Controleur.Visiteur;


import Erreur.*;
import Modele.Piece.Coordonnees;
import Modele.Jeu;
import Modele.Piece.*;


/**
 * Created by Paul on 06/11/2014.
 */

public class Deplacer implements Visiteur {
    Coordonnees nouvelleCoordonnees;

    public boolean isMiseEnEcheque() {
        return miseEnEcheque;
    }

    private boolean miseEnEcheque = false;

    public Deplacer(Coordonnees nouvellePosition) throws HorsDeLechiquier {
        //verification que la nouvelle coordonnée est sur l'echiquier
        if (!Jeu.verifCase(nouvellePosition.getX(), nouvellePosition.getY()))
            throw new HorsDeLechiquier();

        nouvelleCoordonnees = nouvellePosition;
    }

    @Override
    public void visite(Pion pion) throws NotYetImplementedException, DeplacementImpossible {

        DeplacementsPossibles dp = new DeplacementsPossibles();
        dp.visite(pion);
        if(!(dp.getDeplacementsPossibles().contains(nouvelleCoordonnees)))
            throw  new DeplacementImpossible();


        //le déplacement est possible en theorie
        DeplacementPiece(pion, nouvelleCoordonnees);

        //on met a jour le tour
        Jeu.instance().tourSuivant();

        //on lance la verification pour voir si on met en echeque l'adversaire
        miseEnEcheque = Jeu.instance().verificationEchec();

        Jeu.instance().informe();
    }

    @Override
    public void visite(Cavalier cavalier) throws NotYetImplementedException, DeplacementImpossible {

        DeplacementsPossibles dp = new DeplacementsPossibles();
        Coordonnees anciennesCoordonnes = cavalier.getCoordonnees();
        dp.visite(cavalier);
        if(!(dp.getDeplacementsPossibles().contains(nouvelleCoordonnees)))
            throw  new DeplacementImpossible();

        //le déplacement est possible en theorie
        DeplacementPiece(cavalier, nouvelleCoordonnees);
        if(!miseEnEcheque) {
            DeplacementPiece(cavalier, anciennesCoordonnes);
        }

        //on met a jour le tour
        Jeu.instance().tourSuivant();

        //on lance la verification pour voir si on met en echeque l'adversaire
        miseEnEcheque = Jeu.instance().verificationEchec();


        //on met a jour le dernier pion deplacer de deux cases
        Jeu.instance().setPriseEnPassant(null);

        //On informe les observateurs que le modele est modifié
        Jeu.instance().informe();

    }

    @Override
    public void visite(Fou fou) throws NotYetImplementedException, DeplacementImpossible {

        DeplacementsPossibles dp = new DeplacementsPossibles();
        Coordonnees anciennesCoordonnes = fou.getCoordonnees();
        dp.visite(fou);
        if(!(dp.getDeplacementsPossibles().contains(nouvelleCoordonnees)))
            throw  new DeplacementImpossible();

        //le déplacement est possible en theorie
        DeplacementPiece(fou, nouvelleCoordonnees);

        //on met a jour le tour
        Jeu.instance().tourSuivant();

        //on lance la verification pour voir si on met en echeque l'adversaire
        miseEnEcheque = Jeu.instance().verificationEchec();
        if(!miseEnEcheque) {
            DeplacementPiece(fou, anciennesCoordonnes);
        }


        //on met a jour le dernier pion deplacer de deux cases
        Jeu.instance().setPriseEnPassant(null);
        //on met à jour la vue

        //On informe les observateurs que le modele est modifié
        Jeu.instance().informe();

    }

    @Override
    public void visite(Tour tour) throws DeplacementImpossible {

        DeplacementsPossibles dp = new DeplacementsPossibles();
        Coordonnees anciennesCoordonnes = tour.getCoordonnees();
        dp.visite(tour);
        if(!(dp.getDeplacementsPossibles().contains(nouvelleCoordonnees)))
            throw  new DeplacementImpossible();

        //le déplacement est possible en theorie
        DeplacementPiece(tour, nouvelleCoordonnees);

        //on met a jour le tour
        Jeu.instance().tourSuivant();

        //on lance la verification pour voir si on met en echeque l'adversaire
        miseEnEcheque = Jeu.instance().verificationEchec();
        if(!miseEnEcheque) {
            DeplacementPiece(tour, anciennesCoordonnes);
        }


        //on met a jour le dernier pion deplacer de deux cases
        Jeu.instance().setPriseEnPassant(null);

        //On informe les observateurs que le modele est modifié
        Jeu.instance().informe();

    }

    @Override
    public void visite(Roi roi) throws NotYetImplementedException, DeplacementImpossible {

        DeplacementsPossibles dp = new DeplacementsPossibles();
        Coordonnees anciennesCoordonnes = roi.getCoordonnees();
        dp.visite(roi);
        if(!(dp.getDeplacementsPossibles().contains(nouvelleCoordonnees)))
            throw  new DeplacementImpossible();

        //le déplacement est possible en theorie
        DeplacementPiece(roi, nouvelleCoordonnees);

        //on met a jour le tour
        Jeu.instance().tourSuivant();

        //on lance la verification pour voir si on met en echeque l'adversaire
        miseEnEcheque = Jeu.instance().verificationEchec();
        if(!miseEnEcheque) {
            DeplacementPiece(roi, anciennesCoordonnes);
        }


        //on met a jour le dernier pion deplacer de deux cases
        Jeu.instance().setPriseEnPassant(null);

        //On informe les observateurs que le modele est modifié
        Jeu.instance().informe();


    }

    @Override
    public void visite(Reine reine) throws NotYetImplementedException, DeplacementImpossible {

        DeplacementsPossibles dp = new DeplacementsPossibles();
        Coordonnees anciennesCoordonnes = reine.getCoordonnees();
        dp.visite(reine);
        if(!(dp.getDeplacementsPossibles().contains(nouvelleCoordonnees)))
            throw  new DeplacementImpossible();

        //le déplacement est possible en theorie
        DeplacementPiece(reine, nouvelleCoordonnees);

        //on met a jour le tour
        Jeu.instance().tourSuivant();

        //on lance la verification pour voir si on met en echeque l'adversaire
        miseEnEcheque = Jeu.instance().verificationEchec();
        if(!miseEnEcheque) {
            DeplacementPiece(reine, anciennesCoordonnes);
        }


        //on met a jour le dernier pion deplacer de deux cases
        Jeu.instance().setPriseEnPassant(null);

        //On informe les observateurs que le modele est modifié
        Jeu.instance().informe();
    }


    private void DeplacementPiece(Piece p, Coordonnees nc) throws DeplacementImpossible {
        //on creer une copie de l'echiquier pour verifier si c'est possible de faire le deplacement
        Piece[][] tmpEchiquier = Jeu.instance().getEchiquier().clone();

        //on sauvegarde les coordonnées
        Coordonnees ancienne = p.getCoordonnees();

        //on modifit les coordonnées
        p.setCoordonnees(nouvelleCoordonnees);
        tmpEchiquier[p.getCoordonnees().getX()][p.getCoordonnees().getY()] = p;

        //on verifit que le verif echec fonctionne
        //si il ne fonctionne pas on remet les ancienne coordonner dans la piece et on leve une exception
        if(!Jeu.instance().verificationEchec(tmpEchiquier)){
            p.setCoordonnees(ancienne);
            throw new DeplacementImpossible("Vous vous mettez en echec");
        }

        p.setDejaDeplace(true);
        //dans le cas ou tout va bien on garde le nouvelle echiqier
        Jeu.instance().setEchiquier(tmpEchiquier);
        //On a deplace la piece, elle n'est plus a son ancienne position
        Jeu.instance().getEchiquier()[ancienne.getX()][ancienne.getY()] = null;


    }
}
