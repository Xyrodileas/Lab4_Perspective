/******************************************************
Cours:  LOG121
Projet: laboratoire 4
Nom du fichier: PopMenuClicDroit.java
Date creer le: 2014-03-15

 *******************************************************
 *@author Alexis Vuillaume, David Murat, Idriss Aissou,
 *@date Hiver 2014
 *******************************************************/
package Controleur;

import Vue.PanneauImage;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Classe définissant le comportement de menu lors d'un clic droit
 * 
 */
public class PopMenuClicDroit extends JPopupMenu {

	// ATTRIBUTS DE LA CLASSE PoPMenuClicDroit
	private JPopupMenu menuClicDroit;
	private JMenuItem menu1;
	private JMenuItem menu2;
	private PanneauImage panneauImage;
	private static int[] perspective;

	/**
	 * Constructeur par defaut de la classe PoPMenuClicDroit
	 * 
	 * @param panneauR
	 *            (PanneauImage)
	 * 
	 *            Consequent : panneauImage=PanneauR; On ajoute les ecouteurs au
	 *            menu clic droit
	 */
	public PopMenuClicDroit(PanneauImage panneauR) {

		panneauImage = panneauR;
		perspective = new int[3];

		menuClicDroit = new JPopupMenu();

		menu1 = new JMenuItem("Copier Perspective");
		menu1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// COMMANDE SAVE
				SingletonCommande.execution(6, null, panneauImage);
				// RECUPERATION DES VALEUR PERSPECTIVE
				perspective[0] = panneauImage.getPerspective().getPositionX();
				perspective[1] = panneauImage.getPerspective().getPositionY();
				perspective[2] = (int) panneauImage.getPerspective().getZoom();
			}
		});

		menu2 = new JMenuItem("Coller Perspective");
		menu2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				SingletonCommande.execution(3, perspective, panneauImage);
			}
		});

		menuClicDroit.add(menu1);
		menuClicDroit.add(menu2);

	}

	/**
	 * Permet d'afficher le menu clic droit selon la position de la souris
	 * 
	 * @param comp
	 * @param x
	 * @param y
	 */
	public void declancheMenu(Component comp, int x, int y) {
		menuClicDroit.show(comp, x, y);
	}
}
