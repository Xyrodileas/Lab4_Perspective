/******************************************************
Cours:  LOG121
Projet: laboratoire 4
Nom du fichier: SingletonCommande.java
Date creer le: 2014-03-15

 *******************************************************
 *@author Alexis Vuillaume, David Murat, Idriss Aissou,
 *@date Hiver 2014
 *******************************************************/
package Controleur;

import java.io.FileNotFoundException;
import java.io.IOException;

import Modele.Image;
import Vue.PanneauImage;

/**
 * Classe qui permet de lancer la commande
 * Pour coller la perspective de l'image
 * qui a ete copiee
 */
public class Coller extends Commande {
	
	//ATTRIBUT DE COLLER
	private int [] params;
	
	/**
	 * ConStructeur par defaut de Coller
	 * Qui a pour parametre la perspective a coller
	 * @param pR
	 */
	public Coller(int[] tab){
		
		params=tab.clone();
	}

	
	/**
	 * MEthode qui va permettre d'avertir la Perspective qu'il faut copier des nouveaux parmatres
	 * mais aussi d�s lors, la Perspective va avertir le panneauImage du changement par la methode
	 * notify()
	 */
	public void execution(PanneauImage image) {
		image.getPerspective().collerUnePerspective(params);
	}


	@Override
	public Image execution() throws FileNotFoundException, IOException {
		// TODO Auto-generated method stub
		return null;
	}

}
