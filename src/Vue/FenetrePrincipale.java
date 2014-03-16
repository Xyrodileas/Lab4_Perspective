/******************************************************
Cours:  LOG121
Projet: laboratoire 4
Nom du fichier: FenetrePrincipale.java
Date créé: 2014-03-15

 *******************************************************
 *@author Alexis Vuillaume, David Murat, Idriss Aissou,
 *@date Hiver 2014
 *******************************************************/

package Vue;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JFrame;




public class FenetrePrincipale extends JFrame{
	
	/**
	 * Attributs de FenetrePrincipale
	 */
	public Controleur.Receiver receveur;
	public PanneauImage panneauImage;
	public Menu menu;


	    public FenetrePrincipale() {
		    	
	    		//Parametres globale de la fenetre
		        this.setTitle("Perspective");
		        this.setLayout(new BorderLayout());
		        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		        this.setExtendedState(MAXIMIZED_BOTH);
		        
		        
		        
		        //Creation des elements de la fenetre
		        menu = new Menu(this);
		        panneauImage = new PanneauImage(this);
		        
		        //Ajout ecouteur de souris au panneauImage
		        panneauImage.addMouseListener(new Vue.EcouteurDeSouris(this));
		        panneauImage.addMouseWheelListener(new Vue.EcouteurDeSouris(this));
		    
		        		        		        
		        //Ajout des elements a la fenetre PP
		        
		        this.setJMenuBar(menu);
		        this.getContentPane().add(panneauImage);
		        add(panneauImage,BorderLayout.CENTER);
		        
		        this.pack();
		        this.setVisible(true);
		        
		    }
	   
		    
		    
	
	
}
