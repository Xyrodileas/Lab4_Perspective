/******************************************************
Cours:  LOG121
Projet: laboratoire 4
Nom du fichier: Dessiner.java
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
 */
public class Dessiner extends Commande {

	int x, y;

	public Dessiner(int x, int y) {
		this.x = x;
		this.y = y;
	}

	/**
	 * Redéfinition de la méthode execution qui permet de dessinner sur une
	 * image
	 */
	@Override
	public void execution(PanneauImage image) {
		image.getImage().editPixel(this.x, this.y);
	}

	@Override
	public Image execution() throws FileNotFoundException, IOException {
		return null;
	}
}
