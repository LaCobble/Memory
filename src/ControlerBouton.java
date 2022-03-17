//    ______      __    __    __
//   / ____/___  / /_  / /_  / /__
//  / /   / __ \/ __ \/ __ \/ / _ \
// / /___/ /_/ / /_/ / /_/ / /  __/
// \____/\____/_.___/_.___/_/\___/

import java.awt.event.*;
import javax.swing.*;

public class ControlerBouton implements ActionListener {

    Model m;

    public ControlerBouton(Model model)
    {
        m=model;
    }

    public void actionPerformed(ActionEvent arg)
    {
        Object source = arg.getSource();
        JButton texte = (JButton)source;
        if ("Rejouer".equals(texte.getText()))
        {   
            System.out.println("HOOO");
            m.init();
        }
        else
        {
            System.exit(0);   
            System.out.println("HIII"); 
        }

    }
}
