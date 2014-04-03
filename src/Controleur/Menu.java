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

/**
 * Classe correspondant au menu de la fenetre principale
 * 
 */
public class Menu extends JMenuBar {

	/**
	 * Attributs de Menu
	 */
	private static final String CHEMIN_REP = System.getProperty("user.dir")
			.replace("src", "");
	private static final String CHEMIN_DOSSIER_IMAGES = "\\src\\"
			+ "\\images\\";
	public FenetrePrincipale fenetrePrincipale;

	/**
	 * Constructeur par defaut de la classe Menu. Permet d'initialiser le menu
	 * 
	 * @param fenetre
	 *            (FenetrePrincipale)
	 */
	public Menu(FenetrePrincipale fenetre) {
		fenetrePrincipale = fenetre;
		addMenuFichier();
		addMenuModifier();
		addMenuQuitter();
	}

	/**
	 * Methode qui permet d'ajouter le menu fichier dans la menu globale
	 */
	private void addMenuFichier() {

		// Onglet Fichier du super menu
		JMenu menufichier = new JMenu("Fichier ");

		// Onglet ouvrir du sous menu Fichier
		JMenuItem ouvrir = new JMenuItem("Ouvrir");

		// Onglet sauvegarder
		JMenuItem sauvegarder = new JMenuItem("Sauvegarder");

		// Onglet nettoyer
		JMenuItem clean = new JMenuItem("Nettoyer");

		ouvrir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				// Essaye de recupere un fichier
				try {
					// r�cup�ration du r�pertoire par d�faut
					File cheminParDefaut = new File(CHEMIN_REP
							+ CHEMIN_DOSSIER_IMAGES);

					JFileChooser boitedeChoix = new JFileChooser(
							cheminParDefaut);
					boitedeChoix.showOpenDialog(null);// cr�ation et affichage
														// des JFileChooser

                    String extension = boitedeChoix.getSelectedFile().getPath().substring(boitedeChoix.getSelectedFile().getPath().length() - 3,
                            boitedeChoix.getSelectedFile().getPath().length());

                    if (boitedeChoix.getSelectedFile().getPath() != null) {
                    	  if (extension.equals("psg")) {
                    		  System.out.println("JE SUIS DANS OUVERTURE PSG");
                              deserialize(boitedeChoix.getSelectedFile().getPath());
                              
                          }
                    	  else {
                    		  System.out.println("JE SUIS DANS OUVERTURE NORMAL");
      						fenetrePrincipale.panneauImage.setImage(boitedeChoix
      								.getSelectedFile().getPath(),null);
      						fenetrePrincipale.panneauImage2.setImage(boitedeChoix
      								.getSelectedFile().getPath(),null);
                              fenetrePrincipale.panneauImageFixe.setImage(boitedeChoix
                                      .getSelectedFile().getPath(),null);
                              fenetrePrincipale.panneauImageFixe.getImage().getPerspective().setZoom(fenetrePrincipale.panneauImageFixe.getImage().getLargeurImage()/110.f);
                    }
                  
					
					}

				} catch (IOException e) {

					// Sinon on affiche une petite fenetre d'erreur
					JOptionPane.showMessageDialog(fenetrePrincipale, "Erreur");

				} catch (NullPointerException e) {

				}

			}
		});
		sauvegarder.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				SingletonCommande.execution(8, new int[1],
						fenetrePrincipale.panneauImage);

			}
		});

		clean.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("Lancement nettoyage");

				try {
					Image img = new Image(fenetrePrincipale.panneauImage
							.getImage());
					fenetrePrincipale.panneauImage.setImage(img.getChemin(),null);
					fenetrePrincipale.panneauImage.getImage().setPerspective(
							img.getPerspective());
				} catch (Exception e) {
					System.err.println("Err");
				}
				fenetrePrincipale.panneauImage.reactualiserPanneauImage();
			}

		});

		// Ajout de l'onglet ouvrir dans le menu fichier
		menufichier.add(ouvrir);
		menufichier.add(sauvegarder);
		menufichier.add(clean);
		// ajout de l'ongler fichier au JMenuBar global
		add(menufichier);

	}

    public void deserialize(String lienPsg) throws IOException{
        String extension;

        Modele.Image[] imageSave;

            imageSave = SingletonCommande.execution(lienPsg);

            try {
                fenetrePrincipale.panneauImageFixe.setImage((new Image(imageSave[0])).getChemin(), null);
                fenetrePrincipale.panneauImageFixe.getPerspective().setPositionX(0);
                fenetrePrincipale.panneauImageFixe.getPerspective().setPositionY(0);
                fenetrePrincipale.panneauImageFixe.getImage().getPerspective().setZoom(fenetrePrincipale.panneauImageFixe.getImage().getLargeurImage()/110.f);
                fenetrePrincipale.panneauImage.setImage(imageSave[0].getChemin(),imageSave[0]);
                fenetrePrincipale.panneauImage2.setImage(imageSave[1].getChemin(),imageSave[1]);
                //fenetrePrincipale.panneauImage.setImage(imageSave[0].getChemin(),imageSave[0]);
                //fenetrePrincipale.panneauImage2.setImage(imageSave[1].getChemin(),null);

        
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }


    }

	/**
	 * Methode qui permet d'ajouter le menu quitter dans la menu globale
	 */
	private void addMenuQuitter() {
		// Menu application
		JMenu app = new JMenu("Application ");
		// sous menu quitter de application
		JMenuItem quitter = new JMenuItem("Quitter");

		// Action du bouton quitter du menu
		quitter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});

		// ajout du menu quitter au menu application
		app.add(quitter);
		// ajout du menu app au JMenuBar global
		add(app);

	}

	/**
	 * Methode qui permet d'ajouter le menu Modifier dans la menu globale
	 */
	private void addMenuModifier() {

		// Menu modifier
		JMenu modifier = new JMenu("Modifier");

		JMenuItem undo = new JMenuItem("CTRL-Y");

		JMenuItem redo = new JMenuItem("CTRL-Z retour");

		undo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("Undo");
				SingletonCommande.execution(5, null,
						fenetrePrincipale.panneauImage);
			}
		});
		redo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("Redo");
				SingletonCommande.execution(4, null,
						fenetrePrincipale.panneauImage);
			}
		});

		// Ajout du menu redo au menu modifier
		modifier.add(redo);
		// Ajout du menu undo au menu modifier
		modifier.add(undo);

		// Ajout du menu modifier au JMenuBar global
		add(modifier);

	}

}
