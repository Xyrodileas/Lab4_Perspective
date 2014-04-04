/******************************************************
Cours:  LOG121
Projet: laboratoire 4
Nom du fichier: Deserializer.java
Date creer le: 2014-03-15

 *******************************************************
 *@author Alexis Vuillaume, David Murat, Idriss Aissou,
 *@date Hiver 2014
 *******************************************************/

package Controleur;

import Modele.Image;
import Vue.PanneauImage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

/**
 * Cette classe permet de désérialiser un objet
 * 
 */
public class Deserializater extends Commande {

	// Chemin de l'image à réouvrire
	private String path;

	private ObjectInputStream objetFlux;

	/**
	 * Constructeur de la classe
	 * 
	 * @param pathASauvegarder
	 */
	public Deserializater(String pathASauvegarder) {
		path = pathASauvegarder;
	}

	/**
	 * Méthode permettant de faire concretement la désérialisation de l'objet
	 * sauvgardé
	 */
	public Image[] execution() throws FileNotFoundException, IOException {

		// On récupère la sauvegarde
		objetFlux = new ObjectInputStream(new FileInputStream(path));

		Modele.Image[] imageSauvergarde = new Modele.Image[2];
		try {
			// On récupere l'image
			imageSauvergarde[0] = (Modele.Image) objetFlux.readObject();
			imageSauvergarde[1] = (Modele.Image) objetFlux.readObject();
		} catch (ClassNotFoundException e) {

			e.printStackTrace();
		}
		// On retourne l'image
		return imageSauvergarde;
	}

	@Override
	public void execution(PanneauImage image) {

	}

}