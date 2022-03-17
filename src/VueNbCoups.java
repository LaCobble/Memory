//    ______      __    __    __
//   / ____/___  / /_  / /_  / /__
//  / /   / __ \/ __ \/ __ \/ / _ \
// / /___/ /_/ / /_/ / /_/ / /  __/
// \____/\____/_.___/_.___/_/\___/

import java.util.Observer;

import javax.swing.JLabel;

import java.util.Observable;


public class VueNbCoups extends JLabel implements Observer {

    public VueNbCoups(String string, int center) {
		super(string,center);
	}

	public void update(Observable o, Object obj) {
		int coups = ((Model) o).getNbCoups();

		if (((Model) o).getNbPaires() != 10) {
			this.setText(" Nombre de coups joues : "+ coups);
		}else {
			this.setText("Fin du jeu : Vous avez decouvert toute les paires en "+coups+" essais");
		}
		repaint();
    }
}
