package Controleur;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import Modele.Image;
import Vue.PanneauImage;

public class Serializer extends Commande {

	private Image imageASerialiser;
	private static final long serialVersionUID = 1L;
	public static int compteurSave = 0;

	public Serializer(Image valeurs) {
		imageASerialiser = valeurs;
	}

	public void execution(Image valeurs, PanneauImage panneau) {

		try {

			FileOutputStream fout = new FileOutputStream("imageSave"
					+ +compteurSave + ".psg");
			ObjectOutputStream oos = new ObjectOutputStream(fout);
			oos.writeObject(imageASerialiser);
			oos.close();
			System.out.println("sauvegarde " + compteurSave + " faite");

		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	

	@Override
	public void execution(PanneauImage image) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Image execution() {
		// TODO Auto-generated method stub
		return null;
	}

}