package Modele;

import Erreur.NotYetImplementedException;
import vue.Observateur;

import java.util.Vector;

/**
 * Created by Jean on 13/11/14.
 */
public abstract class Sujet {
    private Vector<Observateur> observateurs;

    protected Sujet() {
        observateurs = new Vector<Observateur>(0);
    }

    public void attache(Observateur obs){
           observateurs.add(obs);
    }

    public void detache (Observateur obs){
        observateurs.remove(obs);
    }
    public void informe (){
        for(Observateur o : observateurs){
            try {
                o.MAJ();
            } catch (NotYetImplementedException e) {
                e.printStackTrace();

            }
        }
    }

}
