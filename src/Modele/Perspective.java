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


public class Perspective extends Modele.Observable {
	private double zoom;
	public Gardien sauvegardes;
	
	private int hauteur;
	private int largeur;
	
	public Perspective(int largeurPanneau, int hauteurPanneau, int largeurImage, int hauteurImage){
		this.zoom = 1.00;
		this.hauteur= (int)(hauteurPanneau - (hauteurImage * zoom))/2;
		this.largeur = (int)(largeurPanneau - (largeurImage * zoom))/2;
        this.sauvegardes = new Gardien();

        //(largeurDuPanneau - LargeurDeImage) / 2
        //int LargeurDeImage = (int) (imagebuffer.getWidth() * image.getPerspective().getZoom());
        //int hauteurDeImage = (int) (imagebuffer.getHeight() * image.getPerspective().getZoom());
		
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
    
    public void incrementeZoom(){
    	
    	this.zoom=zoom+0.10;
    	notify();
    }
    public void decrementeZoom(){
    	if(zoom>1.00)
    	this.zoom=zoom-0.10;
    	notify();
    }
	
	
}
