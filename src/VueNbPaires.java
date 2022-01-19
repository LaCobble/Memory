import java.util.Observer;

import javax.swing.JLabel;

import java.util.Observable;


public class VueNbPaires extends JLabel implements Observer {

    public VueNbPaires(String string, int center) {
		super(string,center);
	}

	public void update(Observable o, Object obj) {
		int paires = ((Model) o).getNbPaires();
		if (((Model) o).getNbPaires() != 10) {
			this.setText("Nombre de paires decouvertes : "+ paires);
		}else {
			this.setText("Bravo !");
		}
		
		repaint();
    }
}