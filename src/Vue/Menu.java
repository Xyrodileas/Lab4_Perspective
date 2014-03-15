/******************************************************
Cours:  LOG121
Projet: laboratoire 4
Nom du fichier: Menu.java
Date créé: 2014-03-15

 *******************************************************
 *@author Alexis Vuillaume, David Murat, Idriss Aissou,
 *@date Hiver 2014
 *******************************************************/


package Vue;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;



public class Menu extends JMenuBar {
	
	/**
	 * Attributs de Menu
	 */
	public FenetrePrincipale fenetrePrincipale;
	
		
		public Menu(FenetrePrincipale fenetre) {
			fenetrePrincipale= fenetre;
			addMenuFichier();
			addMenuPerspective();
			addMenuModifier();
			addMenuQuitter();
		}


		
		/**
		 * Methode qui permet d'ajouter 
		 * le menu fichier dans la menu globale
		 */
		private void addMenuFichier() {
			
			   		JMenu menufichier = new JMenu("Fichier ");

			   		JMenuItem ouvrir = new JMenuItem("Ouvrir");
			   		
			   		ouvrir.addActionListener(new ActionListener(){
			    			public void actionPerformed(ActionEvent arg0) {
			    		
			    		    }
			    	    });

			   		menufichier.add(ouvrir);
			   	  
				   add(menufichier);
			   
		}
		
		/**
		 * Methode qui permet d'ajouter 
		 * le menu perspective dans la menu globale
		 */
		private void addMenuPerspective() {
	   		JMenu perspective = new JMenu("Perspective ");

	   		JMenuItem fixe = new JMenuItem("Perspective fixe");
	   		JMenuItem zoom1 = new JMenuItem("Zoom1");
	   		JMenuItem zoom2 = new JMenuItem("Zoom2");
	   		JMenuItem zoom3 = new JMenuItem("Zoom3");
	   		
	   		
	   		fixe.addActionListener(new ActionListener(){
    			public void actionPerformed(ActionEvent arg0) {
    		
    		    }
    	    });
	   		
	   		zoom1.addActionListener(new ActionListener(){
	    			public void actionPerformed(ActionEvent arg0) {
	    		
	    		    }
	    	    });
	   		zoom2.addActionListener(new ActionListener(){
    			public void actionPerformed(ActionEvent arg0) {
    		
    		    }
    	    });
	   		zoom3.addActionListener(new ActionListener(){
    			public void actionPerformed(ActionEvent arg0) {
    		
    		    }
    	    });
	   		
	   		perspective.add(fixe);
	   		perspective.add(zoom1);
	   		perspective.add(zoom2);
	   		perspective.add(zoom3);
		   add(perspective);
			
		}
		
		
		/**
		 * Methode qui permet d'ajouter 
		 * le menu quitter dans la menu globale
		 */
		private void addMenuQuitter() {
			JMenu app = new JMenu("Application ");
			JMenuItem quitter = new JMenuItem("Quitter");
	   		
	   		quitter.addActionListener(new ActionListener(){
	    			public void actionPerformed(ActionEvent arg0) {
	    				System.exit(0); 
	    		    }
	    	    });

	   		app.add(quitter);
	   	  
		   add(app);
			
		}
		
		/**
		 * Methode qui permet d'ajouter 
		 * le menu Modifier dans la menu globale
		 */
		private void addMenuModifier() {
			
			JMenu modifier = new JMenu("Modifier");
			JMenuItem copier = new JMenuItem("Copier");
			JMenuItem coller = new JMenuItem("Coller");
			
	   		copier.addActionListener(new ActionListener(){
	    			public void actionPerformed(ActionEvent arg0) {
	    			
	    		    }
	    	    });

	   		coller.addActionListener(new ActionListener(){
	    			public void actionPerformed(ActionEvent arg0) {
	    			
	    		    }
	    	    });

	   		modifier.add(copier);
	   		modifier.add(coller);
	   		
		   add(modifier);
			
		}
		
	
}
