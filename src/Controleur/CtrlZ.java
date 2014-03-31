package Controleur;

import java.io.FileNotFoundException;
import java.io.IOException;

import Modele.Image;
import Vue.PanneauImage;

public class CtrlZ extends Commande{

	@Override
	public void execution(PanneauImage panneauImage) {
        panneauImage.getImage().getPerspective().lastSnap();
		
	}

	@Override
	public Image execution() throws FileNotFoundException, IOException {
		// TODO Auto-generated method stub
		return null;
	}

}
