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

import Controleur.Menu;

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
	
	public PanneauImage panneauImage2;
	
	public PanneauImage panneauImageFixe;
	public Menu menu;


	/**
	 * Constructeur par defaut 
	 * de la classe FenetrePrincipale
	 * permet d'instancier la fenetre princiapale
	 */
	    public FenetrePrincipale() {
		    	
	    		//Parametres globale de la fenetre
		        this.setTitle("Perspective");
		        this.setLayout(new GridLayout(1,2));
		        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		        this.setExtendedState(MAXIMIZED_BOTH);
		        this.setMinimumSize(new Dimension(800,600));
		        
		        
		        
		        //Creation des elements de la fenetre
		        menu = new Menu(this);	//CREATION DU MENU
		        panneauImage = new PanneauImage();  //CREATION DU PANNEAU IMAGE
		        panneauImage2 = new PanneauImage();
		        panneauImageFixe=new PanneauImage();
		        
		        //Ajout des ecouteurs de souris et clavier au panneauImage
		        panneauImage.addMouseListener(new Controleur.EcouteurEvenement(panneauImage));
		        panneauImage.addMouseMotionListener(new Controleur.EcouteurEvenement(panneauImage));
		        panneauImage.addMouseWheelListener(new Controleur.EcouteurEvenement(panneauImage));
		        addKeyListener(new Controleur.EcouteurEvenement(panneauImage));
		        
		        
		        
		        panneauImage2.addMouseListener(new Controleur.EcouteurEvenement(panneauImage2));
		        panneauImage2.addMouseMotionListener(new Controleur.EcouteurEvenement(panneauImage2));
		        panneauImage2.addMouseWheelListener(new Controleur.EcouteurEvenement(panneauImage2));
		        addKeyListener(new Controleur.EcouteurEvenement(panneauImage2));
		        		        		        
		        //Ajout des elements a la fenetre PP
		        
		        this.setJMenuBar(menu);  //LE MENU
		        add(panneauImage); //LE PANNEAU IMAGE
		        add(panneauImage2);
		        //add(panneauImageFixe);
		        this.pack();
		        this.setVisible(true);	//ON REND LA FENETRE VISIBLE
		        
		    }
	   
		    
		    
	
	
}
