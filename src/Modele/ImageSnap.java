/******************************************************
Cours:  LOG121
Projet: laboratoire 4
Nom du fichier: ImageSnap.java
Date créer: 2014-03-15

 *******************************************************
 *@author Alexis Vuillaume, David Murat, Idriss Aissou,
 *@date Hiver 2014
 *******************************************************/

package Modele;

import java.io.Serializable;

/**
 * Classe définissant une image à sauvegarder selon le patron memento
 * 
 */
public class ImageSnap implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4158159418018353748L;

	private double zoom;

	private int posY;
	private int posX;

	/**
	 * Constructeur par attributs
	 * 
	 * @param zoom
	 * @param posX
	 * @param posY
	 */
	public ImageSnap(double zoom, int posX, int posY) {
		this.zoom = zoom;
		this.posY = posY;
		this.posX = posX;
	}

	// ACCESSEURS

	public double getZoom() {
		return zoom;
	}

	public int getPosY() {
		return posY;
	}

	public int getPosX() {
		return posX;
	}
}
