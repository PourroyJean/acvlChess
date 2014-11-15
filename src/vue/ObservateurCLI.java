package vue;

import Erreur.NotYetImplementedException;
import vue.Observateur;

/**
 * Created by Jean on 13/11/14.
 */
public class ObservateurCLI implements Observateur{
    @Override
    public void MAJ() throws NotYetImplementedException {
        throw new NotYetImplementedException(toString());
    }
}
