package Controleur;

import java.io.FileOutputStream;
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

			FileOutputStream fout = new FileOutputStream("perspective"
					+ compteurSave + ".psg");
			ObjectOutputStream oos = new ObjectOutputStream(fout);
			oos.writeObject(imageSave);
			oos.close();
			System.out.println("sauvegarde " + compteurSave + " faite");

		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}