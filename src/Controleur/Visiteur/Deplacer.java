package Controleur.Visiteur;


import Erreur.*;
import Modèle.Coordonnee;
import Modèle.Jeu;
import Modèle.Pièce.*;

/**
 * Created by Paul on 06/11/2014.
 */
public class Deplacer implements Visiteur {
    Coordonnee nouvelleCoordonnee;

    public Deplacer(Coordonnee nouvellePosition) throws HorsDeLechiquier {
        //verification que la nouvelle coordonnée est sur l'echiquier
        if(!Jeu.instance().verifCase(nouvellePosition.getX(),nouvellePosition.getY()))
            throw new HorsDeLechiquier();

        nouvelleCoordonnee = nouvellePosition;
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
        if(nouvelleCoordonnee.getX() != tour.getCoordonnee().getX() && nouvelleCoordonnee.getY() != tour.getCoordonnee().getY())
            throw new DeplacementImpossible("Ceci n'est pas un déplacement autorisé pour la tour");

        //cas sup

        //on verifit qu'il n'y a pas un de nos pion sur la case cible
        if(Jeu.instance().getPiece(nouvelleCoordonnee) != null && Jeu.instance().getPiece(nouvelleCoordonnee).isBlanc() == tour.isBlanc())
            throw new DeplacementImpossible("Une de nos pièce est sur la case cible");

        //si on est sur la ligne
        if(tour.getCoordonnee().getX() == nouvelleCoordonnee.getX())
        {
            int increment;

            //on cherche le sens de la progression
            if(tour.getCoordonnee().getY() > nouvelleCoordonnee.getY())
                increment = -1;
            else
                increment = 1;

            //on parcours les cases entre la tour et la nouvelle position
            for(int i = (tour.getCoordonnee().getY()+increment); i < nouvelleCoordonnee.getY(); i += increment )
            {
                //si la case n'est pas libre
                if(Jeu.instance().getEchiquier()[tour.getCoordonnee().getX()][i] == null)
                    throw new DeplacementImpossible("Une case intermediaire est occupée");
            }
        }

        //si on est sur la colonne
        else if(tour.getCoordonnee().getY() == nouvelleCoordonnee.getY())
        {
            int increment;

            //on cherche le sens de la progression
            if(tour.getCoordonnee().getX() > nouvelleCoordonnee.getX())
                increment = -1;
            else
                increment = 1;

            //on parcours les cases entre la tour et la nouvelle position
            for(int i = (tour.getCoordonnee().getX()+increment); i < nouvelleCoordonnee.getX(); i += increment )
            {
                //si la case n'est pas libre
                if(Jeu.instance().getEchiquier()[i][tour.getCoordonnee().getY()] == null)
                    throw new DeplacementImpossible("Une case intermediaire est occupée");
            }
        }

        //le déplacement est possible en theorie




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
