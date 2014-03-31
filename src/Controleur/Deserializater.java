package Controleur;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import Modele.Image;
import Vue.PanneauImage;

public class Deserializater extends Commande {

	private String path;
	private static final long serialVersionUID = 1L;
	private ObjectInputStream objetFlux;

	public Deserializater(String pathASauvegarder) {
		path = pathASauvegarder;
	}

	public Modele.Image execution() throws FileNotFoundException, IOException {

		objetFlux = new ObjectInputStream(
				new FileInputStream(path));

		Modele.Image imageSauvergarde = null;
		try {

			imageSauvergarde = (Modele.Image) objetFlux.readObject();
		} catch (ClassNotFoundException e) {

			e.printStackTrace();
		}

		return imageSauvergarde;
	}

	@Override
	public void execution(PanneauImage image) {
		// TODO Auto-generated method stub

	}

}