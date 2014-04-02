package Controleur;

import Modele.Image;
import Vue.PanneauImage;

/**
 * 
 * Classe Zoom qui va permettre de demander
 * A la classe perspective de modifier son zoom.
 * Excecution de commande  Zoom sur l'image modifiant la perspective
 * 
 * Cette classe herite de la l'interface Commande et implement execute()
 *
 */
public class Zoom extends Commande{

	//ATTRIBUT DE LA CLASSE ZOOM
	int typeZoom;
	
	
	/**
	 * Constructeur par defaut de la classe Zoom
	 * @param valeur
	 */
	public Zoom(int valeur) {
		typeZoom = valeur;
	}
	
	/**
	 * Methode qui va permettre de zoomer depuis perspective
	 * @param pRecu (int)
	 */
	private void zoomAvant(Modele.Perspective pRecu){
		pRecu.incrementeZoom();
	}
	
	/**
	 * Methode qui va permettre de dezoomer depuis perspective
	 * @param pRecu (int)
	 */
	private void zoomArriere(Modele.Perspective pRecu){
		pRecu.decrementeZoom();
		
	}
	
	
	/**
	 * Methode qui sera executer par le SingletonCommande
	 * afin d'appliquer les modifications
	 */
	public void execution(PanneauImage panneauImage) {

		// SI TypeZoom =1 donc zoomAvant
		if(typeZoom==1)
			zoomAvant(panneauImage.getPerspective());
		else
			// SINOn ZOOM ARRIERE
		zoomArriere(panneauImage.getPerspective());

        panneauImage.getImage().getPerspective().resetStackNext();
	}

	@Override
	public Image execution() {
		// TODO Auto-generated method stub
		return null;
	}

	
	
	

}
