/******************************************************
Cours:  LOG121
Projet: laboratoire 4
Nom du fichier: FabriqueImage.java
Date créé: 2014-03-15

 *******************************************************
 *@author Alexis Vuillaume, David Murat, Idriss Aissou,
 *@date Hiver 2014
 *******************************************************/

package Modele;

import java.awt.image.BufferedImage;
import java.io.IOException;


public class FabriqueImage {

	
	/**
	 * Methode qui permet de créer une instance
	 * de Image application du patron fabrique
	 * @param lienImage (String) largeurDuPanneau(int) hauteurDuPanneau (int)
	 * @return (Image)
	 * @throws IOException
	 */
	public static Image fabriqueImage(String lienImage) throws IOException {
		return new Image(lienImage,0,0);
	
	}
	
	public static Image fabriqueImageSnap(Image imageRecu) {
		return null;
	
	}
}
