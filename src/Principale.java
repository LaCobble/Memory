//    ______      __    __    __
//   / ____/___  / /_  / /_  / /__
//  / /   / __ \/ __ \/ __ \/ / _ \
// / /___/ /_/ / /_/ / /_/ / /  __/
// \____/\____/_.___/_.___/_/\___/

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;

public class Principale {

	public static void main(String[] args) {
		
		JPanel panneauSud;
		PanneauImages pims;
		VueNbCoups nbCoups;
		VueNbPaires nbPaires;
		Border compound;
		
		Model model = new Model();
		Controler controler = new Controler(model);


		/**********************************
		* Cr�ation des bords des composants
		***********************************/
		Border raisedbevel 	= BorderFactory.createRaisedBevelBorder();
		Border loweredbevel = BorderFactory.createLoweredBevelBorder();
		compound 			= BorderFactory.createCompoundBorder(raisedbevel, loweredbevel);
			
	

		/********************************************************************
		* Le JPanel panneauSud du Sud qui s'ouvre � l'ouverture du jeu
		********************************************************************/
		panneauSud= new JPanel(new GridLayout(2,1));
		
		nbCoups=new VueNbCoups(" Nombre de coups joués : 0 ",JLabel.CENTER);
		nbCoups.setPreferredSize(new Dimension(605,55));
		nbCoups.setOpaque(true);
		nbCoups.setForeground(Color.blue);
		nbCoups.setBorder(compound);
		panneauSud.add(nbCoups);
	
		nbPaires=new VueNbPaires("Nombre de paires découvertes :  0 ",JLabel.CENTER);
		nbPaires.setPreferredSize(new Dimension(605,55));
		nbPaires.setOpaque(true);
		nbPaires.setForeground(Color.blue);
		nbPaires.setBorder(compound);
		panneauSud.add(nbPaires);

		JPanel rejouer = new JPanel();
		rejouer.setPreferredSize(new Dimension(605,55));
		rejouer.setOpaque(true);
		rejouer.setForeground(Color.red);
		rejouer.setBorder(compound);

		JButton rej = new JButton("Rejouer");
		JButton quit = new JButton("Sortir");
		rejouer.add (rej);
		rejouer.add (quit);

		panneauSud.add(rejouer);
			
		pims=new PanneauImages(model);
		pims.setPreferredSize(new Dimension(605,485));
		pims.setBorder(compound);
		
		pims.addMouseListener(controler);
		model.addObserver(pims);
		model.addObserver(nbCoups);
		model.addObserver(nbPaires);
	 
		/**************************************
		* Construction de l'IG dans une JFrame	
		***************************************/	 
		JFrame frame=new JFrame("Memory MVC");
		frame.getContentPane().setBackground(Color.BLUE);	 
		
		frame.getContentPane().add(pims,BorderLayout.CENTER);
		frame.getContentPane().add(panneauSud,BorderLayout.SOUTH);
		  
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);	
	}

}
