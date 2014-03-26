package Controleur;

import Vue.PanneauImage;

public class Zoom extends Commande{

	int typeZoom;
	
	public Zoom(int valeur) {
		typeZoom = valeur;
	}
	private void zoomAvant(Modele.Perspective pRecu){
		pRecu.incrementeZoom();
	}
	private void zoomArriere(Modele.Perspective pRecu){
		pRecu.decrementeZoom();
		
	}
	
/**	//1 Pour zoom avant
	//0 Pour zoom arri�re
	public void execution(Modele.Perspective p) {
		System.out.println(" Execution zoom bien");
		if(typeZoom==1)
			zoomAvant(p);
		else
		zoomArriere(p);
	}**/

	
	public void execution(PanneauImage panneauImage) {

		System.out.println(" Execution zoom bien po bien");
		
		if(typeZoom==1)
			zoomAvant(panneauImage.image.getPerspective());
		else
		zoomArriere(panneauImage.image.getPerspective());
	}

	
	
	

}
