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
	private double zoom;
	public Gardien sauvegardes;
	
	private int hauteur;
	private int largeur;
	
	public Perspective(int largeurRecu, int hauteurRecu){
		this.zoom = 1.00;
		this.hauteur= hauteurRecu;
		this.largeur = largeurRecu;
        this.sauvegardes = new Gardien();
		
	}
    public Perspective(int largeurRecu, int hauteurRecu, double zoom){

        this.hauteur= hauteurRecu;
        this.largeur = largeurRecu;
        this.zoom = zoom;

    }

	
	public int getHauteur(){
		return hauteur;
	}
	
	public int getLargeur(){
		return largeur;
	}

    public double getZoom(){
        return zoom;
    }
	
	
}
