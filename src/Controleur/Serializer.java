package Controleur;

import java.io.FileOutputStream;

import java.io.ObjectOutputStream;

import javax.swing.JOptionPane;

import Modele.Image;
import Vue.PanneauImage;

/**
 * Classe permettant de sérialiser une image
 * 
 */
public class Serializer extends Commande {

	// Image à Sérialisée sauvegardée en attribut de las classe
	private Image imageASerialiser;

	private static final String CHEMIN_REP = System.getProperty("user.dir")
			.replace("src", "");
	private static final String CHEMIN_DOSSIER_IMAGES = "\\src\\"
			+ "\\images\\";

	/**
	 * Constructeur de la classe, permet de créer un objet Serializer
	 * 
	 * @param valeurs
	 */
	public Serializer(Image valeurs) {
		imageASerialiser = valeurs;
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
			oos.close();

		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	@Override
	public Image execution() {
		// TODO Auto-generated method stub
		return null;
	}

}