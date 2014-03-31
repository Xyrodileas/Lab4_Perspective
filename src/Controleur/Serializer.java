package Controleur;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import Modele.Image;

public class Serializer {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static int compteurSave = 0;

	public static void serializePerspective(Image imageSave) {

		try {

			FileOutputStream fout = new FileOutputStream("imageSave"+
					+ compteurSave + ".psg");
			ObjectOutputStream oos = new ObjectOutputStream(fout);
			oos.writeObject(imageSave);
			oos.close();
			System.out.println("sauvegarde " + compteurSave + " faite");

		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public static Modele.Image deSerialisateur(String path)
			throws FileNotFoundException, IOException {

		ObjectInputStream objetFlux = new ObjectInputStream(
				new FileInputStream(path));

		Modele.Image imageSauvergarde = null;
		try {

			imageSauvergarde = (Modele.Image) objetFlux.readObject();
		} catch (ClassNotFoundException e) {

			e.printStackTrace();
		}

		return imageSauvergarde;
	}
}