package Controleur;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import javax.swing.JOptionPane;

import Modele.Image;
import Vue.PanneauImage;

public class Serializer extends Commande {

	private Image imageASerialiser;
	private static final long serialVersionUID = 1L;

	public Serializer(Image valeurs) {
		imageASerialiser = valeurs;
	}

	public void execution(PanneauImage panneau) {

		String nom;

		nom = JOptionPane.showInputDialog(
				"Veuillez rentrer le nom de la sauvegarde", "imageSauvegardée");

		try {

			FileOutputStream fout = new FileOutputStream(nom + ".psg");
			ObjectOutputStream oos = new ObjectOutputStream(fout);
			oos.writeObject(imageASerialiser);
			oos.close();
			System.out.println("sauvegarde " + nom + " faite");

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