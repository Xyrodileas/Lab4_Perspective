package Controleur;

public class Zoom extends Commande{

	
	
	private void zoomAvant(Modele.Perspective pRecu){
		pRecu.incrementeZoom();
	}
	private void zoomArriere(Modele.Perspective pRecu){
		pRecu.decrementeZoom();
		
	}
	
	//1 Pour zoom avant
	//0 Pour zoom arrière
	public void execution(Modele.Perspective p, int modeZoom) {
		if(modeZoom==1)
			zoomAvant(p);
		zoomArriere(p);
	}
	@Override
	public void execution() {
		// TODO Auto-generated method stub
		
	}
	
	
	

}
