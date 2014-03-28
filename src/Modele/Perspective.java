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
	private int zoom;
	public Gardien sauvegardes;

	private int hauteurImage;
	private int largeurImage;
	private int positionX;
	private int positionY;

    public Perspective(int largeurImageR, int hauteurImageR){
		
		hauteurImage = hauteurImageR;
		largeurImage= largeurImageR;
		
		positionX =0;
		positionY =0;
		
		
		this.zoom = 1;
		
		
        this.sauvegardes = new Gardien();

		
	}
    public Perspective(int largeurRecu, int hauteurRecu, int zoom){

        this.positionX = hauteurRecu;
        this.zoom = zoom;
        positionX = 0;
        positionY = 0;
    }

	


    public int getZoom(){
        return zoom;
    }
    
    
    
    public void incrementeZoom(){
    	
    	this.zoom++;
  
    	//--------AJOUTER NOTIFY APRES----------
    	//notify();
    }
    public void decrementeZoom(){
    	if(zoom>1)
    	this.zoom--;
     	//--------AJOUTER NOTIFY APRES----------
    	//notify();
    }

    public int getHauteurImage(){
        return this.hauteurImage;
    }

    public int getLargeurImage(){
        return this.largeurImage;
    }
    
    //------------------------GESTION DU DEPLACEMENT DE L'IMAGE---------------------
    /**
     * Permet de modifier la position
     * de l'image en X
     * @param deplacementRecuX
     */
    public void setPositionX(int deplacementRecuX){
        positionX += deplacementRecuX;

    }
    
    /**
     * Permet de modifier la position
     * de l'image en Y
     * @param deplacementRecuY
     */
    public void setPositionY(int deplacementRecuY){

        positionY += deplacementRecuY;

    }

    /**
     * Permet de retourner la position de l'image selon X
     * @return (int)
     */
    public int getPositionX(){
    	return this.positionX;
    }
    
    /**
     * Permet de retourner la position de l'image selon Y
     * @return (int)
     */
    public int getPositionY(){
    	return this.positionY;
    }
    
    public int recupereCentreXDImage(){
    	return this.positionY /2;
    }
    public int recupereCentreYDImage(){
    	return this.hauteurImage/2;
    }

    public void restorePerspective(Perspective snap){
        this.positionX = snap.positionX;
        this.positionY = snap.positionY;
        this.zoom = snap.getZoom();
    }

    public void lastSnap(){
        restorePerspective(this.sauvegardes.restorLast());
    }

    public void nextSnap(){
        restorePerspective(this.sauvegardes.restorNext());
    }


}
