package Controleur.Visiteur;

import Erreur.NotYetImplementedException;
import Modèle.Pièce.*;

/**
 * Created by Paul on 06/11/2014.
 */
public interface Visiteur {
    public void visite(Pion pion) throws NotYetImplementedException;
    public void visite(Cavalier cavalier) throws NotYetImplementedException;
    public void visite(Fou fou) throws NotYetImplementedException;
    public void visite(Tour tour) throws NotYetImplementedException;
    public void visite(Roi roi) throws NotYetImplementedException;
    public void visite(Reine reine) throws NotYetImplementedException;
}
