package Controleur;

import java.io.FileNotFoundException;
import java.io.IOException;

import Modele.Image;
import Vue.PanneauImage;

public class SauvegardePerspective extends Commande {

	
	public void execution(PanneauImage image) {
		image.getImage().getPerspective().save();
		
	}

	@Override
	public Image[] execution() throws FileNotFoundException, IOException {
		// TODO Auto-generated method stub
		return null;
	}

}
