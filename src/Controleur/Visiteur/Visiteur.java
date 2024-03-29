package Controleur.Visiteur;

import Erreur.DeplacementImpossible;
import Erreur.NotYetImplementedException;
import Modele.Piece.*;

/**
 * Created by Paul on 06/11/2014.
 */
public interface Visiteur {
    public void visite(Pion pion) throws NotYetImplementedException, DeplacementImpossible;
    public void visite(Cavalier cavalier) throws NotYetImplementedException, DeplacementImpossible;
    public void visite(Fou fou) throws NotYetImplementedException, DeplacementImpossible;
    public void visite(Tour tour) throws DeplacementImpossible;
    public void visite(Roi roi) throws NotYetImplementedException, DeplacementImpossible;
    public void visite(Reine reine) throws NotYetImplementedException, DeplacementImpossible;
}
