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

	private int hauteurImage;
	private int largeurImage;
	private int facteurDeDeplacementX;
	private int facteurDeDeplacementY;
	private int hauteur;
    private int largeur;
	
	public Perspective(int largeurImageR, int hauteurImageR){
		
		hauteurImage = hauteurImageR;
		largeurImage= largeurImageR;
		
		facteurDeDeplacementX=0;
		facteurDeDeplacementY=0;
		
		
		this.zoom = 1.00;
		//this.hauteur= (int)(hauteurPanneauR - (hauteurImage * zoom))/2;
		//this.largeur = (int)(largeurPanneauR - (largeurImage * zoom))/2;
		
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
		return this.hauteurImage;
	}
	
	public int getLargeur(){
		return this.largeurImage;
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
    
  
    public void inrementerFacteurDeDeplacementX(){
    	facteurDeDeplacementX++;
    }
    public void inrementerFacteurDeDeplacementy(){
    	facteurDeDeplacementY++;
    }
    public void decrementerFacteurDeDeplacementX(){
    	if (facteurDeDeplacementX >0)
    		facteurDeDeplacementX--;
    }
    public void decrementerFacteurDeDeplacementY(){
    	if (facteurDeDeplacementY >0)
    		facteurDeDeplacementY--;
    }
    
    public int getFacteurDeDeplacementX(){
    	return this.facteurDeDeplacementX;
    }
    public int getFacteurDeDeplacementY(){
    	return this.facteurDeDeplacementY;
    }
    
    
    
    
    public void setHauteur(int hauteur) {
        this.hauteur = hauteur;
    }

    public void setLargeur(int largeur) {
        this.largeur = largeur;
    }



}
