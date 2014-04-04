/******************************************************
Cours:  LOG121
Projet: laboratoire 4
Nom du fichier: FabriqueImage.java
Date créer: 2014-03-15

 *******************************************************
 *@author Alexis Vuillaume, David Murat, Idriss Aissou,
 *@date Hiver 2014
 *******************************************************/

package Modele;

import java.io.IOException;

/**
 * Classe permettant de créer les instances des classes Image et ImageSnap
 * 
 * 
 */
public class FabriqueImage {

	/**
	 * Methode qui permet de cr�er une instance de Image application du patron
	 * fabrique
	 * 
	 * @param lienImage
	 *            (String) largeurDuPanneau(int) hauteurDuPanneau (int)
	 * @return (Image)
	 * @throws IOException
	 */
	public static Image fabriqueImage(String lienImage) throws IOException {
		return new Image(lienImage);

	}

	/**
	 * Methode qui permet de cr�er une instance de ImageSnap application du
	 * patron fabrique
	 * 
	 * @param zoom
	 *            : Zoom de l'image
	 * @param posX
	 *            : Position sur l'axe x de l'image
	 * @param posY
	 *            : Position sur l'axe y de l'image
	 * @return : retourne une instance de ImageSnap
	 */
	public static ImageSnap fabriqueImageSnap(double zoom, int posX, int posY) {
		return new ImageSnap(zoom, posX, posY);

	}

}
