/******************************************************
Cours:  LOG121
Projet: laboratoire 4
Nom du fichier: OriginatoPerspective.java
Date cr��: 2014-03-15

 *******************************************************
 *@author Alexis Vuillaume, David Murat, Idriss Aissou,
 *@date Hiver 2014
 *******************************************************/

package Modele;


public class Perspective extends Controleur.Observable {
	public double zoom;
	public Image Unnamed1;
	public Originator Unnamed2;
	public Controleur.Command Unnamed3;
	public Controleur.Command Unnamed4;
	
	private int hauteur;
	private int largeur;
	
	public Perspective(int largeurRecu, int hauteurRecu){
		
		hauteur= hauteurRecu;
		largeur = largeurRecu;
		
	}
	
	public int getHauteur(){
		return hauteur;
	}
	
	public int getLargeur(){
		return largeur;
	}
	
	
	
}
