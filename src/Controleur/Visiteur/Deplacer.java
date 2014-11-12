package Controleur.Visiteur;


import Erreur.*;
import Modele.Coordonnees;
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
    public void visite(Pion pion) throws NotYetImplementedException {
        throw new NotYetImplementedException();
    }

    @Override
    public void visite(Cavalier cavalier) throws NotYetImplementedException {
        throw new NotYetImplementedException();
    }

    @Override
    public void visite(Fou fou) throws NotYetImplementedException {
        throw new NotYetImplementedException();
    }

    @Override
    public void visite(Tour tour) throws DeplacementImpossible {

        //verification que la tour est sur la meme ligne ou la meme colonne que la nouvelle coordonnée
        if (nouvelleCoordonnees.getX() != tour.getCoordonnees().getX() && nouvelleCoordonnees.getY() != tour.getCoordonnees().getY())
            throw new DeplacementImpossible("Ceci n'est pas un déplacement autorisé pour la tour");

        //cas sup

        //on verifit qu'il n'y a pas un de nos pion sur la case cible
        if (Jeu.instance().getPiece(nouvelleCoordonnees) != null && Jeu.instance().getPiece(nouvelleCoordonnees).isBlanc() == tour.isBlanc())
            throw new DeplacementImpossible("Une de nos pièce est sur la case cible");

        //si on est sur la ligne
        if (tour.getCoordonnees().getX() == nouvelleCoordonnees.getX()) {
            int increment;

            //on cherche le sens de la progression
            if (tour.getCoordonnees().getY() > nouvelleCoordonnees.getY())
                increment = -1;
            else
                increment = 1;

            //on parcours les cases entre la tour et la nouvelle position
            for (int i = (tour.getCoordonnees().getY() + increment); i < nouvelleCoordonnees.getY(); i += increment) {
                //si la case n'est pas libre
                if (Jeu.instance().getEchiquier()[tour.getCoordonnees().getX()][i] == null)
                    throw new DeplacementImpossible("Une case intermediaire est occupée");
            }
        }

        //si on est sur la colonne
        else if (tour.getCoordonnees().getY() == nouvelleCoordonnees.getY()) {
            int increment;

            //on cherche le sens de la progression
            if (tour.getCoordonnees().getX() > nouvelleCoordonnees.getX())
                increment = -1;
            else
                increment = 1;

            //on parcours les cases entre la tour et la nouvelle position
            for (int i = (tour.getCoordonnees().getX() + increment); i < nouvelleCoordonnees.getX(); i += increment) {
                //si la case n'est pas libre
                if (Jeu.instance().getEchiquier()[i][tour.getCoordonnees().getY()] == null)
                    throw new DeplacementImpossible("Une case intermediaire est occupée");
            }
        }

        //le déplacement est possible en theorie

        //on creer une copie de l'echiquier pour verifier si c'est possible de faire le deplacement
        Piece[][] tmpEchiquier = Jeu.instance().getEchiquier().clone();

        //on sauvegarde les coordonnées
        Coordonnees ancienne = tour.getCoordonnees();

        //on modifit les coordonnées
        tour.setCoordonnees(nouvelleCoordonnees);
        tmpEchiquier[tour.getCoordonnees().getX()][tour.getCoordonnees().getY()] = tour;

        //on verifit que le verif echec fonctionne
        //si il ne fonctionne pas on remet les ancienne coordonner dans la piece et on leve une exception
        if(!Jeu.instance().verificationEchec(tmpEchiquier)){
            tour.setCoordonnees(ancienne);
            throw new DeplacementImpossible("Vous vous mettez en echec");
        }

        //dans le cas ou tout va bien on garde le nouvelle echiqier
        Jeu.instance().setEchiquier(tmpEchiquier);

        //on met a jour le tour
        Jeu.instance().tourSuivant();

        //on lance la verification pour voir si on met en echeque l'adversaire
        miseEnEcheque = Jeu.instance().verificationEchec();

        //on met à jour la vue



    }

    @Override
    public void visite(Roi roi) throws NotYetImplementedException {
        throw new NotYetImplementedException();
    }

    @Override
    public void visite(Reine reine) throws NotYetImplementedException {
        throw new NotYetImplementedException();
    }
}
