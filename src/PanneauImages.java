//    ______      __    __    __
//   / ____/___  / /_  / /_  / /__
//  / /   / __ \/ __ \/ __ \/ / _ \
// / /___/ /_/ / /_/ / /_/ / /  __/
// \____/\____/_.___/_.___/_/\___/

import java.awt.*;      
import javax.swing.*;
import java.io.File;
import java.io.IOException;
import java.util.Observable;
import java.util.Observer;

import javax.imageio.ImageIO;

public class PanneauImages extends JPanel implements Observer { 
private Image fond, im[];	// contient les objets Images correspondants aux fichiers des images
private Model model;	

	public PanneauImages(Model model){
		super();
		this.model = model;
		this.im= new Image[10];
		try{
			fond=ImageIO.read(new File("images/fond.png"));
			for(int i=0;i<10;i++){
				im[i]=ImageIO.read(new File("images/im"+i+".png"));
			}
		}catch(IOException e){System.out.println("PB chargement fichiers images "+e);};
	}
	
	/*
	 * Methode appelee automatiquement a la construction du JPanel
	 * pour l'appeler dans une autre methode, utiliser la methode repaint() 
	 */
	public void paintComponent(Graphics g) {
		super.paintComponent(g);	
		setBackground(Color.white);
		
		for(int i=0; i<5; i++) {
				for(int j=0; j<4; j++) {
						int pos = j*5+i;
						if (model.getVisible()[pos] == true) g.drawImage(im[model.getOrdre()[pos]], 5+i*115, 5+j*115, 115, 115, this);
						else g.drawImage(fond, 5+i*115, 5+j*115, 115, 115, this);
				}
		}
	}

	@Override
	public void update(Observable o, Object arg) {
		this.model=(Model)o;
		repaint();
	}

}
