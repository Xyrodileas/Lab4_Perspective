/******************************************************
Cours:  LOG121
Projet: laboratoire 4
Nom du fichier: SauvegardePerspective.java
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
 * Classe permettant de sauvegarder une perspective
 *
 */
public class SauvegardePerspective extends Commande {

	/**
	 * Redéfinition de la méthode execution dans le cadre de l'utilisation du patron commande
	 */
	public void execution(PanneauImage image) {
		image.getImage().getPerspective().save();
		
	}

	@Override
	public Image[] execution() throws FileNotFoundException, IOException {
		// TODO Auto-generated method stub
		return null;
	}

}
