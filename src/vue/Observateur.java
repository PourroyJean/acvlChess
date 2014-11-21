package Vue;

import Erreur.NotYetImplementedException;

/**
 * Created by Jean on 12/11/14.
 */
public interface Observateur {
    abstract void MAJ () throws NotYetImplementedException;
}
