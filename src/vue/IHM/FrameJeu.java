package vue.IHM;

import Modele.Coordonnees;
import Modele.CouleurJoueur;
import Modele.Jeu;
import Modele.Piece.Piece;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.Vector;

/**
 * Created by Jean on 12/11/14.
 */
public class FrameJeu extends JFrame {
    private JButton xButton62;
    private JButton xButton;
    private JButton xButton63;
    private JButton xButton1;
    private JButton xButton2;
    private JButton xButton3;
    private JButton xButton4;
    private JButton xButton5;
    private JButton xButton6;
    private JButton xButton7;
    private JButton xButton8;
    private JButton xButton9;
    private JButton xButton10;
    private JButton xButton11;
    private JButton xButton12;
    private JButton xButton13;
    private JButton xButton14;
    private JButton xButton15;
    private JButton xButton16;
    private JButton xButton17;
    private JButton xButton18;
    private JButton xButton19;
    private JButton xButton20;
    private JButton xButton21;
    private JButton xButton22;
    private JButton xButton23;
    private JButton xButton24;
    private JButton xButton25;
    private JButton xButton26;
    private JButton xButton27;
    private JButton xButton28;
    private JButton xButton29;
    private JButton xButton30;
    private JButton xButton31;
    private JButton xButton32;
    private JButton xButton33;
    private JButton xButton34;
    private JButton xButton35;
    private JButton xButton36;
    private JButton xButton37;
    private JButton xButton38;
    private JButton xButton39;
    private JButton xButton40;
    private JButton xButton41;
    private JButton xButton42;
    private JButton xButton43;
    private JButton xButton44;
    private JButton xButton45;
    private JButton xButton46;
    private JButton xButton47;
    private JButton xButton48;
    private JButton xButton49;
    private JButton xButton50;
    private JButton xButton51;
    private JButton xButton52;
    private JButton xButton53;
    private JButton xButton54;
    private JButton xButton55;
    private JButton xButton56;
    private JButton xButton57;
    private JButton xButton58;
    private JButton xButton59;
    private JButton xButton60;
    private JButton xButton61;
    private JPanel boutonPanel;

    JButton [] [] boutons;

    private Coordonnees selection = new Coordonnees(-1,-1); // case selectionnee

    ActionListener listener;

    //Singleton
    public static FrameJeu frameJeu = new FrameJeu();
    public static FrameJeu instance (){
        return frameJeu;
    }

    private FrameJeu() {
        super("Jeu d'Echec");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setContentPane(boutonPanel);
        setSize(640,662);
        setResizable(false);
        boutons = new JButton[8][8];
        setVisible(true);
        creationMatrice();



        listener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                clickCase(Integer.parseInt((((JButton) e.getSource()).getToolTipText()).charAt(0) + ""), Integer.parseInt((((JButton) e.getSource()).getToolTipText()).charAt(1) + ""));
            }
        };


        //Gestion general des boutons
        for(int i = 0; i < 8; ++ i){
            for(int j = 0; j < 8; ++j){
                JButton b = boutons[i][j];
                b.setText("");
                b.setToolTipText(i + "" + j);
                b.setPreferredSize(new Dimension(80, 80));
                b.setMargin(new Insets(0, 0, 0, 0));
                b.setBorder(new LineBorder(Color.BLACK));

                b.setContentAreaFilled(false);
                b.setFocusPainted(false);
                //b.setBorder(new EmptyBorder(0, 0, 0, 0));
                b.addActionListener(listener);
                if(i == 0 | i == 1 | i == 6 | i == 7) {
                    String path = "";
                    try {
                        Piece p = Jeu.instance().getEchiquier()[i][j];
                        path = "images/" + Jeu.parseNomPiece(p.getClass().getName());
                        path += p.getCouleur() == CouleurJoueur.BLANC ? "Blanc" : "Noir";
                        path += ".png";
                        b.setIcon(new ImageIcon(ImageIO.read(new File(path))));
                    } catch (IOException e) {
                        System.out.println(path);
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    private void clickCase (int x, int y){
        //System.out.println("click@["+ x + "][" +y+"]");
        JButton c = boutons[x][y];
        Piece piece = Jeu.instance().getEchiquier()[x][y];

        System.out.println(Jeu.parseNomPiece(piece.toString()));

        //Pas de piece ici : on deselection la case selectionnee

    }

    private void creationMatrice(){
        Vector<JButton> vbout = new Vector<JButton>(64);

        vbout.add(xButton);
        vbout.add(xButton1);
        vbout.add(xButton2);
        vbout.add(xButton3);
        vbout.add(xButton4);
        vbout.add(xButton5);
        vbout.add(xButton6);
        vbout.add(xButton7);
        vbout.add(xButton8);

        vbout.add(xButton9);
        vbout.add(xButton10);
        vbout.add(xButton11);
        vbout.add(xButton12);
        vbout.add(xButton13);
        vbout.add(xButton14);
        vbout.add(xButton15);
        vbout.add(xButton16);

        vbout.add(xButton17);
        vbout.add(xButton18);
        vbout.add(xButton19);
        vbout.add(xButton20);
        vbout.add(xButton21);
        vbout.add(xButton22);
        vbout.add(xButton23);
        vbout.add(xButton24);

        vbout.add(xButton25);
        vbout.add(xButton26);
        vbout.add(xButton27);
        vbout.add(xButton28);
        vbout.add(xButton29);
        vbout.add(xButton30);
        vbout.add(xButton31);
        vbout.add(xButton32);
        vbout.add(xButton33);

        vbout.add(xButton34);
        vbout.add(xButton35);
        vbout.add(xButton36);
        vbout.add(xButton37);
        vbout.add(xButton38);
        vbout.add(xButton39);
        vbout.add(xButton40);
        vbout.add(xButton41);
        vbout.add(xButton42);

        vbout.add(xButton43);
        vbout.add(xButton44);
        vbout.add(xButton45);
        vbout.add(xButton46);
        vbout.add(xButton47);
        vbout.add(xButton48);
        vbout.add(xButton49);
        vbout.add(xButton50);
        vbout.add(xButton51);

        vbout.add(xButton52);
        vbout.add(xButton53);
        vbout.add(xButton54);
        vbout.add(xButton55);
        vbout.add(xButton56);
        vbout.add(xButton57);
        vbout.add(xButton58);
        vbout.add(xButton59);
        vbout.add(xButton60);
        vbout.add(xButton61);
        vbout.add(xButton62);
        vbout.add(xButton63);

        int k = 0;
        for(int i = 0; i < 8; ++ i){
            for(int j = 0; j < 8; ++j){
                boutons[i][j] = vbout.get(k);
                ++k;
            }
        }

    }



}
