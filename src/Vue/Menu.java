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
import java.io.File;
import java.io.IOException;

import javax.swing.JFileChooser;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;




public class Menu extends JMenuBar {
	
	/**
	 * Attributs de Menu
	 */
	private static final String CHEMIN_REP = System.getProperty("user.dir").replace("src", "");
	private static final String CHEMIN_DOSSIER_IMAGES = "\\src\\"+"\\images\\";
	public FenetrePrincipale fenetrePrincipale;
	
		
		/**
		 * Constructeur par defaut de la classe
		 * Menu.
		 * Permet d'initialiser le menu 
		 * @param fenetre (FenetrePrincipale)
		 */
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
			
					//Onglet Fichier du super menu
			   		JMenu menufichier = new JMenu("Fichier ");

			   		//Onglet ouvrir du sous menu Fichier
			   		JMenuItem ouvrir = new JMenuItem("Ouvrir");
			   		
			   		//Onglet sauvegarder
			   		JMenuItem sauvegarder = new JMenuItem("Sauvegarder");
			   		
			   		ouvrir.addActionListener(new ActionListener(){
			    			public void actionPerformed(ActionEvent arg0) {
			    				
			    				//Essaye de recupere un fichier
			    				try {
			    					//récupération du répertoire par défaut
				    				File cheminParDefaut = new File(CHEMIN_REP+CHEMIN_DOSSIER_IMAGES); 
				    					    				
				    				JFileChooser boitedeChoix = new JFileChooser(cheminParDefaut);
				    				boitedeChoix.showOpenDialog(null);//création et affichage des JFileChooser
				    				
				    				
				    				//Envoie du chemin recu à la méthode setImage du panneauImage
				    				fenetrePrincipale.panneauImage.setImage(boitedeChoix.getSelectedFile().getPath());
								} catch (IOException e) {
									//Sinon on affiche une petite fenetre d'erreur
									JOptionPane.showMessageDialog(fenetrePrincipale, "Erreur");

							
								}
			    		
			    		    }
			    	    });
			   		sauvegarder.addActionListener(new ActionListener(){
		    			public void actionPerformed(ActionEvent arg0) {
		    				System.out.println("SAVEEEEEEEEEEEEEEEEEEEEEEEEE");
		    		    }
		    	    });

			   		//Ajout de l'onglet ouvrir dans le menu fichier
			   		menufichier.add(ouvrir);
			   		menufichier.add(sauvegarder);
			   		//ajout de l'ongler fichier au JMenuBar global
			   		add(menufichier);
			   
		}
		
		/**
		 * Methode qui permet d'ajouter 
		 * le menu perspective dans la menu globale
		 */
		private void addMenuPerspective() {
			//menu Perspective du super menu
	   		JMenu perspective = new JMenu("Perspective ");

	   		//sous menu perspective fixe du menu perspective
	   		JMenuItem fixe = new JMenuItem("Perspective fixe");
	   		//sous menu zoom1 fixe du menu perspective
	   		JMenuItem zoom1 = new JMenuItem("Zoom1");
	   		//sous menu zoom2 fixe du menu perspective
	   		JMenuItem zoom2 = new JMenuItem("Zoom2");
	   		//sous menu zoom3 fixe du menu perspective
	   		JMenuItem zoom3 = new JMenuItem("Zoom3");
	   		
	   		
	   		//Avertisseur de fixe
	   		fixe.addActionListener(new ActionListener(){
    			public void actionPerformed(ActionEvent arg0) {
    				System.out.println("fixe");
    		    }
    	    });
	   		

	   		//Avertisseur de zoom1
	   		zoom1.addActionListener(new ActionListener(){
	    			public void actionPerformed(ActionEvent arg0) {
	    				System.out.println("Zoom 1");
	    		    }
	    	    });
	   		
	   		//Avertisseur de zoom2
	   		zoom2.addActionListener(new ActionListener(){
    			public void actionPerformed(ActionEvent arg0) {
    				System.out.println("Zoom 2");
    		    }
    	    });
	   		//Avertisseur de zoom3
	   		zoom3.addActionListener(new ActionListener(){
    			public void actionPerformed(ActionEvent arg0) {
    				System.out.println("Zoom 3");
    		
    		    }
    	    });
	   		
	   		
	   		//ajout de fixe au menu perspective
	   		perspective.add(fixe);
	   		//ajout de zoom1 au menu perspective
	   		perspective.add(zoom1);
	   		//ajout de zoom2 au menu perspective
	   		perspective.add(zoom2);
	   		//ajout de zoom3 au menu perspective
	   		perspective.add(zoom3);
	   		//ajout du menu perspective au JMenuBar global
	   		add(perspective);
			
		}
		
		
		/**
		 * Methode qui permet d'ajouter 
		 * le menu quitter dans la menu globale
		 */
		private void addMenuQuitter() {
			//Menu application
			JMenu app = new JMenu("Application ");
			//sous menu quitter de application
			JMenuItem quitter = new JMenuItem("Quitter");
			
	   		//Action du bouton quitter du menu
	   		quitter.addActionListener(new ActionListener(){
	    			public void actionPerformed(ActionEvent arg0) {
	    				System.exit(0); 
	    		    }
	    	    });

	   		//ajout du menu quitter au menu application
	   		app.add(quitter);
	   		//ajout du menu app au JMenuBar global
	   		add(app);
			
		}
		
		/**
		 * Methode qui permet d'ajouter 
		 * le menu Modifier dans la menu globale
		 */
		private void addMenuModifier() {
			
			//Menu modifier
			JMenu modifier = new JMenu("Modifier");
			//sous menu copier du menu modifier
			JMenuItem copier = new JMenuItem("Copier");
			//sous menu coller du menu modifier
			JMenuItem coller = new JMenuItem("Coller");
			
			JMenuItem undo = new JMenuItem("Undo");
			
			JMenuItem redo = new JMenuItem("Redo");
			//Action de copier
	   		copier.addActionListener(new ActionListener(){
	    			public void actionPerformed(ActionEvent arg0) {
	    				System.out.println("Copier");
	    			
	    		    }
	    	    });

	   		//Action de Coller
	   		coller.addActionListener(new ActionListener(){
	    			public void actionPerformed(ActionEvent arg0) {
	    				System.out.println("Coller");
	    		    }
	    	    });
	   		
	   		undo.addActionListener(new ActionListener(){
    			public void actionPerformed(ActionEvent arg0) {
    				System.out.println("Undo");
    		    }
    	    });
	   		redo.addActionListener(new ActionListener(){
    			public void actionPerformed(ActionEvent arg0) {
    				System.out.println("Redo");
    		    }
    	    });


	   		//Ajout du menu copier au menu modifier
	   		modifier.add(copier);
	   		//Ajout du menu coller au menu modifier
	   		modifier.add(coller);
	   		//Ajout du menu undo au menu modifier
	   		modifier.add(undo);
	   		//Ajout du menu redo au menu modifier
	   		modifier.add(redo);
	   		
	   		//Ajout du menu modifier au JMenuBar global
	   		add(modifier);
			
		}
		
	
}
