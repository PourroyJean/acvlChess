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
    public void visite(Fou fou) throws NotYetImplementedException, DeplacementImpossible {
        //on verifit que le deplacement est bien en diagonnal
        if(Math.abs(nouvelleCoordonnees.getX()-fou.getCoordonnees().getX()) != Math.abs(nouvelleCoordonnees.getY()-fou.getCoordonnees().getY()))
            throw new DeplacementImpossible("Ceci n'est pas un déplacement autorisé pour le fou");

        //on verifit qu'il n'y a pas un de nos pion sur la case cible
        if (Jeu.instance().getPiece(nouvelleCoordonnees) != null && Jeu.instance().getPiece(nouvelleCoordonnees).isBlanc() == fou.isBlanc())
            throw new DeplacementImpossible("Une de nos pièce est sur la case cible");

        //on verifit qu'il n'y a rien sur le chemin du deplacement
        if(! ligneLibre(fou.getCoordonnees(), nouvelleCoordonnees))
            throw new DeplacementImpossible("Il y a un pion sur les cases intermediaires");

        //le déplacement est possible en theorie
        DeplacementPiece(fou, nouvelleCoordonnees);

        //on met a jour le tour
        Jeu.instance().tourSuivant();

        //on lance la verification pour voir si on met en echeque l'adversaire
        miseEnEcheque = Jeu.instance().verificationEchec();


        //on met a jour le dernier pion deplacer de deux cases
        Jeu.instance().setPriseEnPassant(null);
        //on met à jour la vue

    }

    @Override
    public void visite(Tour tour) throws DeplacementImpossible {

        //verification que la tour est sur la meme ligne ou la meme colonne que la nouvelle coordonnée
        if (nouvelleCoordonnees.getX() != tour.getCoordonnees().getX() && nouvelleCoordonnees.getY() != tour.getCoordonnees().getY())
            throw new DeplacementImpossible("Ceci n'est pas un déplacement autorisé pour la tour");

        //cas du roque
        //on verifit qu'il y 'est un roi sur la case cible
        Piece cible = Jeu.instance().getPiece(nouvelleCoordonnees);
        if(cible != null &&
                ((cible == Jeu.instance().getRoiBlanc() && tour.isBlanc()) ||
                        (!tour.isBlanc() && cible == Jeu.instance().getRoiNoir())))
        {
            //le roque est presque possible, il faut verifier que les cases intermediaire sont libre et non controler
            if(! ligneLibre(tour.getCoordonnees(), nouvelleCoordonnees))
                throw new DeplacementImpossible("Il y a un pion sur les cases intermediaires");

            //on verifit quelle ne sont pas controlé

            //le déplacement est possible en theorie


            //on met a jour le tour
            Jeu.instance().tourSuivant();

            //on lance la verification pour voir si on met en echeque l'adversaire
            miseEnEcheque = Jeu.instance().verificationEchec();

            //on met a jour le dernier pion deplacer de deux cases
            Jeu.instance().setPriseEnPassant(null);

            //on met à jour la vue

            //fin de la fonction
            return;
        }

        //on verifit qu'il n'y a pas un de nos pion sur la case cible
        if (Jeu.instance().getPiece(nouvelleCoordonnees) != null && Jeu.instance().getPiece(nouvelleCoordonnees).isBlanc() == tour.isBlanc())
            throw new DeplacementImpossible("Une de nos pièce est sur la case cible");

        //on verifit qu'il n'y a rien sur le chemin du deplacement
        if(! ligneLibre(tour.getCoordonnees(), nouvelleCoordonnees))
            throw new DeplacementImpossible("Il y a un pion sur les cases intermediaires");

        //le déplacement est possible en theorie
        DeplacementPiece(tour, nouvelleCoordonnees);

        //on met a jour le tour
        Jeu.instance().tourSuivant();

        //on lance la verification pour voir si on met en echeque l'adversaire
        miseEnEcheque = Jeu.instance().verificationEchec();

        //on met a jour le dernier pion deplacer de deux cases
        Jeu.instance().setPriseEnPassant(null);

        //on met à jour la vue



    }

    @Override
    public void visite(Roi roi) throws NotYetImplementedException {
        throw new NotYetImplementedException();
    }

    @Override
    public void visite(Reine reine) throws NotYetImplementedException, DeplacementImpossible {
        //on verifit que le deplacement est bien en diagonnal ou en ligne
        if(Math.abs(nouvelleCoordonnees.getX()-reine.getCoordonnees().getX()) == Math.abs(nouvelleCoordonnees.getY()-reine.getCoordonnees().getY())
                && (nouvelleCoordonnees.getX() != reine.getCoordonnees().getX() && nouvelleCoordonnees.getY() != reine.getCoordonnees().getY()) )
            throw new DeplacementImpossible("Ceci n'est pas un déplacement autorisé pour la reine");

        //on verifit qu'il n'y a pas un de nos pion sur la case cible
        if (Jeu.instance().getPiece(nouvelleCoordonnees) != null && Jeu.instance().getPiece(nouvelleCoordonnees).isBlanc() == reine.isBlanc())
            throw new DeplacementImpossible("Une de nos pièce est sur la case cible");

        //on verifit qu'il n'y a rien sur le chemin du deplacement
        if(! ligneLibre(reine.getCoordonnees(), nouvelleCoordonnees))
            throw new DeplacementImpossible("Il y a un pion sur les cases intermediaires");

        //le déplacement est possible en theorie
        DeplacementPiece(reine, nouvelleCoordonnees);

        //on met a jour le tour
        Jeu.instance().tourSuivant();

        //on lance la verification pour voir si on met en echeque l'adversaire
        miseEnEcheque = Jeu.instance().verificationEchec();

        //on met à jour la vue
    }

    private boolean ligneLibre(Coordonnees c1, Coordonnees c2){

        //3 cas :
        //sur la meme ligne
        if(c1.getY() == c2.getY())
        {
            if(c1.getX() < c2.getX())
            {
                for(int i = c1.getX()+1; i < c2.getX(); i++)
                {
                    if(Jeu.instance().getPiece(new Coordonnees(i,c1.getY())) != null)
                        return false;

                }
            }
            else
            {
                for(int i = c2.getX()-1; i < c1.getX(); i--)
                {
                    if(Jeu.instance().getPiece(new Coordonnees(i,c1.getY())) != null)
                        return false;

                }
            }
        }
        //sur la meme colonne
        else if(c1.getX() == c2.getX())
        {
            if(c1.getY() < c2.getY())
            {
                for(int i = c1.getY()+1; i < c2.getY(); i++)
                {
                    if(Jeu.instance().getPiece(new Coordonnees(c1.getX(),i)) != null)
                        return false;

                }
            }
            else
            {
                for(int i = c2.getY()-1; i < c1.getY(); i--)
                {
                    if(Jeu.instance().getPiece(new Coordonnees(c1.getX(),i)) != null)
                        return false;

                }
            }
        }
        //en diagonnale
        else if(Math.abs(c1.getX()-c2.getX()) == Math.abs(c1.getY()-c2.getY()))
        {
            int i, j;
            int incrementi, incrementj;

            if(c1.getX() < c2.getX())
            {
                i = c1.getX()+1;
                incrementi = 1;
            }
            else
            {
                i = c1.getX()-1;
                incrementi = -1;
            }

            if(c1.getY() < c2.getY())
            {
                j = c1.getX()+1;
                incrementj = +1;
            }
            else
            {
                j = c1.getX()-1;
                incrementj = -1;
            }


            while(c2.getX() != i && c2.getY() != j)
            {
                if(Jeu.instance().getPiece(new Coordonnees(i,j)) != null)
                    return false;

                i += incrementi;
                j += incrementj;
            }
        }

        return true;

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
    }
}
