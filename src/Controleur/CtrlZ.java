/******************************************************
Cours:  LOG121
Projet: laboratoire 4
Nom du fichier: CtrlZ.java
Date creer le: 2014-03-15

 *******************************************************
 *@author Alexis Vuillaume, David Murat, Idriss Aissou,
 *@date Hiver 2014
 *******************************************************/

package Controleur;

import Modele.Image;
import Vue.PanneauImage;

import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * Classe gérant l'exécution d'une commande de retours en arrière
 */
public class CtrlZ extends Commande {

	/**
	 * Méthode permetant d'exécuter le ctr + Z
	 * 
	 * @param panneauImage
	 */
	@Override
	public void execution(PanneauImage panneauImage) {
		panneauImage.getImage().getPerspective().lastSnap();

	}

	@Override
	public Image[] execution() throws FileNotFoundException, IOException {
		// TODO Auto-generated method stub
		return null;
	}

}
