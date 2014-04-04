/******************************************************
Cours:  LOG121
Projet: laboratoire 4
Nom du fichier: CtrlY.java
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
 * Classe permettant de définir une action lors d'un undo
 * 
 */
public class CtrlY extends Commande {

	/**
	 * Methode allant cherchée la perspective précédente
	 */
	@Override
	public void execution(PanneauImage panneauImage) {
		panneauImage.getImage().getPerspective().nextSnap();

	}

	@Override
	public Image[] execution() throws FileNotFoundException, IOException {
		// TODO Auto-generated method stub
		return null;
	}

}
