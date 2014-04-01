package Controleur;

import Modele.Image;
import Vue.PanneauImage;

import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * Classe gérant l'exécution d'une commande de retours en arrière
 */
public class CtrlZ extends Commande{

    /**
     * Méthode permetant d'exécuter le ctr + z
     * @param panneauImage
     */
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
