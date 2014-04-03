/******************************************************
 Cours:  LOG121
 Projet: laboratoire 4
 Nom du fichier: EcouteurEvenement.java
 Date creer: 2014-03-15

 *******************************************************
 *@author Alexis Vuillaume, David Murat, Idriss Aissou,
 *@date Hiver 2014
 *******************************************************/

package Controleur;

import Vue.PanneauImage;

import java.awt.event.*;

public class EcouteurEvenement implements MouseListener, MouseWheelListener,
		KeyListener, MouseMotionListener {

	// LES ATTRIBUT DE EcouteurEvenement
	private PanneauImage panneauImage;
	private int x, y;
	private static int xClick, yClick;
	private PopMenuClicDroit menu;

	private static boolean bouttonGauche;
	private static boolean bouttonMolette;
	private boolean ctrl;
    private boolean focus;

	/**
	 * Constructeur par defaut de Ecouteur Evenement Il va permet de copier le
	 * panneauImage recu dans une variable panneauIamge et aussi d'instancier un
	 * menu popup PopMenuClicDroit(panneauImage)
	 * 
	 * @param im
	 */
	public EcouteurEvenement(PanneauImage im) {

		panneauImage = im;
		menu = new PopMenuClicDroit(panneauImage);
        focus = false;
	}

	// ---------------------------------------------------PARTIE
	// CLAVIER--------------------------------------------
	public void keyPressed(KeyEvent arg0) {
		if (arg0.getKeyCode() == 17 && !panneauImage.imageEstVide()) {
			ctrl = true;
		}
		// CAS CTRL Z
		else if (ctrl && arg0.getKeyCode() == 90 && focus) {
			System.out.println("CTRL Z");
			SingletonCommande.execution(4, null, this.panneauImage);
		}
		// CAS CTRL Y
		else if (ctrl && arg0.getKeyCode() == 89 && focus) {
			System.out.println("CTRL Y");
			SingletonCommande.execution(5, null, this.panneauImage);

		}
	}

	public void keyReleased(KeyEvent arg0) {
		// ON RELACHE CONTROLE
		if (arg0.getKeyCode() == 17 && !panneauImage.imageEstVide()) {
			ctrl = false;
		}

	}

	// ---------------------------------------------------PARTIE SOURIS
	// CLIC--------------------------------------------

	/**
	 * Methode qui permet de retenir la position du clic selon le bouton de la
	 * souris un evenement different se passe: Si clic gauche : On retient la
	 * position puis on deplacera la souris avec le drag Si clic droit : On
	 * affiche un menu popUp permettant de copier ou coller la perspective de
	 * l'image
	 */
	public void mousePressed(MouseEvent arg0) {
		if (arg0.getButton() == 1) {
			bouttonGauche = true;
			this.xClick = arg0.getX();
			this.yClick = arg0.getY();

		}

		// CLIC CENTRAL
		else if (arg0.getButton() == 2) {
			bouttonMolette = true;

		}
		// CLIC DROIT
		else if (arg0.getButton() == 3) {
			if (!panneauImage.imageEstVide())
				menu.declancheMenu(arg0.getComponent(), arg0.getX(),
						arg0.getY());
		}
	}

	public void mouseReleased(MouseEvent arg0) {
		if (arg0.getButton() == 1) {
			bouttonGauche = false;

		}

		// CLIC CENTRAL
		else if (arg0.getButton() == 2) {
			bouttonMolette = false;

		}
	}

	// ---------------------------------------------------PARTIE SOURIS
	// MOUVEMENT--------------------------------------------
	/**
	 * Methode qui permet d'utiliser le SingletonCommande afin d'utiliser la
	 * commande zoom selon la rotation de la molette de la souris Soit zoom
	 * avant Soit zoom Arriere
	 */
	public void mouseWheelMoved(MouseWheelEvent arg0) {

		// COMMANDE SAVE
		SingletonCommande.execution(6, null, this.panneauImage);
		int[] tabParametres = { 0 };

		// ZOOM AVANT
		if (arg0.getWheelRotation() < 0) {
			tabParametres[0] = 1;
		}
		// ZOOM ARRIERE
		else {
			tabParametres[0] = 0;
		}
		// APPEL DU SingletonCommande ----> ZOOM
		SingletonCommande.execution(2, tabParametres, this.panneauImage);
	}

	/**
	 * Methode qui permet de d'utiliser le SingletonCommande afin d'utiliser
	 * translation afin de d�placer l'image dans le panneau avec la souris
	 */
	public void mouseDragged(MouseEvent e) {
		if (bouttonGauche == true && !panneauImage.imageEstVide()) {
			int[] tabParametres = { e.getX() - this.xClick,
					e.getY() - this.yClick };

			// COMMANDE SAVE
			SingletonCommande.execution(6, null, this.panneauImage);

			// APPEL DU SingletonCommande ----> Translation
			SingletonCommande.execution(1, tabParametres, this.panneauImage);
			this.xClick = e.getX();
			this.yClick = e.getY();
		} else if (bouttonMolette = true && !panneauImage.imageEstVide()) {
			int[] tab = { e.getX(), e.getY() };
			SingletonCommande.execution(7, tab, this.panneauImage);

		}
	}

	// -----------------------------------------NON
	// IMPLEMENTEES------------------------------------
	public void mouseMoved(MouseEvent e) {
	}

	public void mouseClicked(MouseEvent arg0) {
	}

	public void mouseEntered(MouseEvent arg0) {
        focus = true;
	}

	public void mouseExited(MouseEvent arg0) {
        focus = false;
	}

	public void keyTyped(KeyEvent arg0) {
	}

}
