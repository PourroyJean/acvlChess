package vue.InterfaceGraphique;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Jean on 13/11/14.
 */
public class MenuBar extends JMenuBar {

    public MenuBar() {
        super();

        JMenu menu1 = new JMenu("Actions");

        JMenuItem eMenuItem = new JMenuItem("Nouvelle Partie");
        eMenuItem.setToolTipText("Lance une nouvelle partie");
        eMenuItem.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent event) {
                Commande c = new NouvellePartie();
                c.execute();
            }
        });

        menu1.add(eMenuItem);

        add(menu1);
    }
}
