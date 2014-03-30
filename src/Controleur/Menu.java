/******************************************************
Cours:  LOG121
Projet: laboratoire 4
Nom du fichier: Menu.java
Date cr��: 2014-03-15

 *******************************************************
 *@author Alexis Vuillaume, David Murat, Idriss Aissou,
 *@date Hiver 2014
 *******************************************************/


package Controleur;

import Modele.Image;
import Vue.FenetrePrincipale;

import javax.swing.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;




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

                    //Onglet nettoyer
                    JMenuItem clean = new JMenuItem("nettoyer");

			   		ouvrir.addActionListener(new ActionListener(){
			    			public void actionPerformed(ActionEvent arg0) {
			    				
			    				//Essaye de recupere un fichier
			    				try {
			    					//r�cup�ration du r�pertoire par d�faut
				    				File cheminParDefaut = new File(CHEMIN_REP+CHEMIN_DOSSIER_IMAGES); 
				    					    				
				    				JFileChooser boitedeChoix = new JFileChooser(cheminParDefaut);
				    				boitedeChoix.showOpenDialog(null);//cr�ation et affichage des JFileChooser
				    				
				    				
				    				//Envoie du chemin recu � la m�thode setImage du panneauImage
				    				fenetrePrincipale.panneauImage.setImage(boitedeChoix.getSelectedFile().getPath());
				    				
								} catch (IOException e) {
									
									//Sinon on affiche une petite fenetre d'erreur
									JOptionPane.showMessageDialog(fenetrePrincipale, "Erreur");

							
								}
			    		
			    		    }
			    	    });
			   		sauvegarder.addActionListener(new ActionListener(){
		    			public void actionPerformed(ActionEvent arg0) {
		    				System.out.println("Lancement sauvegarder");
		    				Controleur.Serializer.serializePerspective(fenetrePrincipale.panneauImage.getImage());
		    		    }
		    	    });
                    clean.addActionListener(new ActionListener(){
                        public void actionPerformed(ActionEvent arg0) {
                            System.out.println("Lancement nettoyage");

                            try{
                                Image img = new Image(fenetrePrincipale.panneauImage.getImage());
                                fenetrePrincipale.panneauImage.setImage(img.getChemin());
                                fenetrePrincipale.panneauImage.getImage().setPerspective(img.getPerspective());
                            }catch(Exception e){
                                System.err.println("Err");
                            }
                           fenetrePrincipale.panneauImage.reactualiserPanneauImage();
                        }

                    });

			   		//Ajout de l'onglet ouvrir dans le menu fichier
			   		menufichier.add(ouvrir);
			   		menufichier.add(sauvegarder);
                    menufichier.add(clean);
			   		//ajout de l'ongler fichier au JMenuBar global
			   		add(menufichier);
			   
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
			
			JMenuItem undo = new JMenuItem("Undo");
			
			JMenuItem redo = new JMenuItem("Redo");

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

	   		//Ajout du menu undo au menu modifier
	   		modifier.add(undo);
	   		//Ajout du menu redo au menu modifier
	   		modifier.add(redo);
	   		
	   		//Ajout du menu modifier au JMenuBar global
	   		add(modifier);
			
		}
		
	
}
