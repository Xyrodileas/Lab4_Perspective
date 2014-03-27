/******************************************************
Cours:  LOG121
Projet: laboratoire 4
Nom du fichier: FenetrePrincipale.java
Date crï¿½ï¿½: 2014-03-15

 *******************************************************
 *@author Alexis Vuillaume, David Murat, Idriss Aissou,
 *@date Hiver 2014
 *******************************************************/

package Vue;

import javax.swing.*;
import java.awt.*;


/**
 *Classe qui permet une JFrame a l'application
 *Permet de créer la fenetre principale de l'application
 */
public class FenetrePrincipale extends JFrame{
	
	/**
	 * Attributs de FenetrePrincipale
	 */
	public PanneauImage panneauImage;
	public Menu menu;


	/**
	 * Constructeur par defaut 
	 * de la classe FenetrePrincipale
	 * permet d'instancier la fenetre princiapale
	 */
	    public FenetrePrincipale() {
		    	
	    		//Parametres globale de la fenetre
		        this.setTitle("Perspective");
		        this.setLayout(new BorderLayout());
		        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		        this.setExtendedState(MAXIMIZED_BOTH);
		        
		        
		        
		        //Creation des elements de la fenetre
		        menu = new Menu(this);	//CREATION DU MENU
		        panneauImage = new PanneauImage();  //CREATION DU PANNEAU IMAGE
		        
		        
		        //Ajout des ecouteurs de souris et clavier au panneauImage
		        panneauImage.addMouseListener(new Controleur.EcouteurEvenement(panneauImage));
		        panneauImage.addMouseMotionListener(new Controleur.EcouteurEvenement(panneauImage));
		        panneauImage.addMouseWheelListener(new Controleur.EcouteurEvenement(panneauImage));
		        panneauImage.addKeyListener(new Controleur.EcouteurEvenement(panneauImage) );
		        		        		        
		        //Ajout des elements a la fenetre PP
		        
		        this.setJMenuBar(menu);  //LE MENU
		        add(panneauImage,BorderLayout.CENTER); //LE PANNEAU IMAGE
		        
		        this.pack();
		        this.setVisible(true);	//ON REND LA FENETRE VISIBLE
		        
		    }
	   
		    
		    
	
	
}
