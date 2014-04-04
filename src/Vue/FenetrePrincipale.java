/******************************************************
 Cours:  LOG121
 Projet: laboratoire 4
 Nom du fichier: FenetrePrincipale.java
 Date créer: 2014-03-15

 *******************************************************
 *@author Alexis Vuillaume, David Murat, Idriss Aissou,
 *@date Hiver 2014
 *******************************************************/

package Vue;

import Controleur.Menu;

import javax.swing.*;

import java.awt.*;

/**
 * Classe qui permet une JFrame a l'application Permet de cr�er la fenetre
 * principale de l'application
 */
public class FenetrePrincipale extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1866335975983191971L;

	/**
	 * Attributs de FenetrePrincipale
	 */
	public PanneauImage panneauImage;

	public PanneauImage panneauImage2;

	public PanneauImage panneauImageFixe;
	public Menu menu;

	/**
	 * Constructeur par defaut de la classe FenetrePrincipale permet
	 * d'instancier la fenetre princiapale
	 */
	public FenetrePrincipale() {

		// Parametres globale de la fenetre
		this.setTitle("Perspective");
		GridBagLayout grille = new GridBagLayout();
		GridBagConstraints contrainte = new GridBagConstraints();
		setLayout(grille);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setExtendedState(MAXIMIZED_BOTH);
		this.setMinimumSize(new Dimension(1000, 100));

		// Creation des elements de la fenetre
		menu = new Menu(this); // CREATION DU MENU
		panneauImage = new PanneauImage(); // CREATION DU PANNEAU IMAGE
		panneauImage2 = new PanneauImage();
		panneauImageFixe = new PanneauImage();

		panneauImage.setName("Panneau 0");
		panneauImage2.setName("Panneau 1");
		panneauImageFixe.setName("Panneau 2");

		// Ajout des ecouteurs de souris et clavier au panneauImage
		panneauImage.addMouseListener(new Controleur.EcouteurEvenement(
				panneauImage));
		panneauImage.addMouseMotionListener(new Controleur.EcouteurEvenement(
				panneauImage));
		panneauImage.addMouseWheelListener(new Controleur.EcouteurEvenement(
				panneauImage));
		addKeyListener(new Controleur.EcouteurEvenement(panneauImage));

		panneauImage2.addMouseListener(new Controleur.EcouteurEvenement(
				panneauImage2));
		panneauImage2.addMouseMotionListener(new Controleur.EcouteurEvenement(
				panneauImage2));
		panneauImage2.addMouseWheelListener(new Controleur.EcouteurEvenement(
				panneauImage2));
		addKeyListener(new Controleur.EcouteurEvenement(panneauImage2));

		contrainte.fill = GridBagConstraints.VERTICAL;
		// LARGEUR X

		contrainte.ipadx = 600;

		contrainte.weighty = 1;
		contrainte.gridheight = 60;
		contrainte.gridwidth = 700;
		// grille.setConstraints(panneauImage, contrainte); // mise en forme des
		// objets
		// grille.setConstraints(panneauImage2, contrainte);
		add(panneauImage, contrainte);
		add(panneauImage2, contrainte);

		contrainte.fill = GridBagConstraints.CENTER;
		contrainte.ipadx = 110;
		contrainte.ipady = 100;
		// grille.setConstraints(mini, contrainte);

		add(panneauImageFixe, contrainte);

		// Ajout des elements a la fenetre PP

		this.setJMenuBar(menu); // LE MENU
		// add(panneauImage); //LE PANNEAU IMAGE
		// add(panneauImage2);
		// add(panneauImageFixe);

		this.pack();
		this.setVisible(true); // ON REND LA FENETRE VISIBLE

	}

}
