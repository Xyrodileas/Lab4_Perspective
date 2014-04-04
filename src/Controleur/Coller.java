/******************************************************
Cours:  LOG121
Projet: laboratoire 4
Nom du fichier: Coller.java
Date creer le: 2014-03-15

 *******************************************************
 *@author Alexis Vuillaume, David Murat, Idriss Aissou,
 *@date Hiver 2014
 *******************************************************/
package Controleur;

import java.io.FileNotFoundException;
import java.io.IOException;

import Modele.Image;
import Vue.PanneauImage;

/**
 * Classe qui permet de lancer la commande Pour coller la perspective de l'image
 * qui a ete copiee
 */
public class Coller extends Commande {

	// ATTRIBUT DE COLLER
	private int[] params;

	/**
	 * ConStructeur par default de Coller Qui a pour parametre la perspective a
	 * coller
	 * 
	 * @param pR
	 */
	public Coller(int[] tab) {

		params = tab.clone();
	}

	/**
	 * MEthode qui va permettre d'avertir la Perspective qu'il faut copier des
	 * nouveaux parmatres mais aussi d�s lors, la Perspective va avertir le
	 * panneauImage du changement par la methode notify()
	 */
	public void execution(PanneauImage image) {
		if (params[3] == 0) {
			image.getPerspective().collerUnePerspective(params);
		} else if (params[3] == 1) {
			image.getPerspective().setPositionX(params[0]);
			image.getPerspective().setPositionY(params[1]);
		} else if (params[3] == 2) {
			image.getPerspective().setZoom(((double) params[2] / 100));
		}

	}

	@Override
	public Image[] execution() throws FileNotFoundException, IOException {
		// TODO Auto-generated method stub
		return null;
	}

}
