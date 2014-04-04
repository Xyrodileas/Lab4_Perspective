/******************************************************
Cours:  LOG121
Projet: laboratoire 4
Nom du fichier: Originator.java
Date créer: 2014-03-15

 *******************************************************
 *@author Alexis Vuillaume, David Murat, Idriss Aissou,
 *@date Hiver 2014
 *******************************************************/

package Modele;

import java.io.Serializable;

/**
 * Classe contenant les méthodes pour effectuer les sauvergardes d'imageSnap selon le patron memento
 *
 */
public class Originator implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 9034979774638388887L;
	// ATTRIBUTS DE LA CLASSE ORIGINATOR
	public double zoom;
	public Image img;
	private int posX;
	private int posY;

	/**
	 * Methode qui permet de r�cuperer les attributs d'une Perspective recu en
	 * param�tre
	 * 
	 * @param maperspective
	 */
	public void SetSave(Perspective maperspective) {

		this.posX = maperspective.getPositionX();
		this.posY = maperspective.getPositionY();
		this.zoom = maperspective.getZoom();
	}

	/**
	 * Methode qui permet de Creer une instance de ImageSnap afin de m�moriser
	 * l'�tat de l'image
	 * 
	 * @return ImageSnap (m�morisation de l'etat de l'image)
	 */
	public ImageSnap CreateSave() {
		return Modele.FabriqueImage.fabriqueImageSnap(this.zoom, this.posX,
				this.posY);
	}

	/**
	 * Methode qui permet de retourner une Perspective selon une sauvegarde recu
	 * en param�tre
	 * 
	 * @param snap
	 *            (ImageSnap)
	 * @return Perspective
	 */
	public Perspective restoreFromMemento(ImageSnap snap) {
		return new Perspective(snap.getPosX(), snap.getPosY(), snap.getZoom());
	}
}
