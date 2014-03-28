package Controleur;

import Vue.PanneauImage;

public class CtrlY extends Commande{

	@Override
	public void execution(PanneauImage panneauImage) {
		panneauImage.image.getPerspective().nextSnap();
		
	}

}
