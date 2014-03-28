package Controleur;

import Vue.PanneauImage;

public class CtrlZ extends Commande{

	@Override
	public void execution(PanneauImage panneauImage) {
        panneauImage.image.getPerspective().lastSnap();
		
	}

}
