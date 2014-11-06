package Controleur.Visiteur;

import Erreur.NotYetImplementedException;
import Modèle.Pièce.*;

/**
 * Created by Paul on 06/11/2014.
 */
public class VerifEchec implements Visiteur {
    public VerifEchec(){}
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
    public void visite(Tour tour) throws NotYetImplementedException {
        throw new NotYetImplementedException();
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
