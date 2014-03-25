package Controleur;

import Vue.PanneauImage;

public class Zoom extends Commande{

	
	
	private void zoomAvant(Modele.Perspective pRecu){
		pRecu.incrementeZoom();
	}
	private void zoomArriere(Modele.Perspective pRecu){
		pRecu.decrementeZoom();
		
	}
	
	//1 Pour zoom avant
	//0 Pour zoom arri�re
	public void execution(Modele.Perspective p, int modeZoom) {
		if(modeZoom==1)
			zoomAvant(p);
		zoomArriere(p);
	}
	@Override
	public void execution(PanneauImage panneauImage) {
		// TODO Auto-generated method stub
		
	}
	
	
	

}
