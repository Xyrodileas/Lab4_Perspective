/******************************************************
Cours:  LOG121
Projet: laboratoire 4
Nom du fichier: Serializer.java
Date creer le: 2014-03-15

 *******************************************************
 *@author Alexis Vuillaume, David Murat, Idriss Aissou,
 *@date Hiver 2014
 *******************************************************/

package Controleur;

import Modele.Image;
import Vue.PanneauImage;

import javax.swing.*;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

/**
 * Classe permettant de sérialiser une image
 * 
 */
public class Serializer extends Commande {

	// Image à Sérialisée sauvegardée en attribut de las classe
	private Image imageASerialiser;
    private Image imageASerialiser2;

	private static final String CHEMIN_REP = System.getProperty("user.dir")
			.replace("src", "");
	private static final String CHEMIN_DOSSIER_IMAGES = "\\src\\"
			+ "\\images\\";
	/**
	 * Constructeur de la classe, permet de créer un objet Serializer
	 * 
	 * @param image, image2
	 */
	public Serializer(Image image, Image image2) {
		imageASerialiser = image;
        imageASerialiser2= image2;
	}

	/**
	 * Méthode qui sérialise l'objet, appelé par SingletonCommande
	 */
	public void execution(PanneauImage panneau) {

		String nom;

		// On demande à l'utilisateur le nom choisi
		nom = JOptionPane.showInputDialog(
				"Veuillez rentrer le nom de la sauvegarde", "imageSauvegardée");

		try {

			FileOutputStream fout = new FileOutputStream(CHEMIN_REP
					+ CHEMIN_DOSSIER_IMAGES + nom + ".psg");
			ObjectOutputStream oos = new ObjectOutputStream(fout);
			oos.writeObject(imageASerialiser);
            oos.writeObject(imageASerialiser2);
			oos.close();

		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	@Override
	public Image[] execution() {
		// TODO Auto-generated method stub
		return null;
	}

}