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
	private int facteurDeDeplacementX;
	private int facteurDeDeplacementY;

	
	private int hauteur;
    private int largeur;
	
	public Perspective(int largeurImageR, int hauteurImageR){
		
		hauteurImage = hauteurImageR;
		largeurImage= largeurImageR;
		
		facteurDeDeplacementX=0;
		facteurDeDeplacementY=0;
		
		
		this.zoom = 1;
		
		
        this.sauvegardes = new Gardien();

		
	}
    public Perspective(int largeurRecu, int hauteurRecu, int zoom){

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
    
    //------------------------GESTION DU DEPLACEMENT DE L'IMAGE---------------------
    /**
     * Permet de modifier la position
     * de l'image en X
     * @param deplacementRecuX
     */
    public void setFacteurDeDeplacementX(int deplacementRecuX){
    	System.out.println();
    	facteurDeDeplacementX=deplacementRecuX- (hauteurImage/2);
    	System.out.println("VOICI LA HAUTEUR / 2  " + hauteurImage/2);
    	System.out.println("VOICI LE FACTEUR DE DEPLACEMENT X  "+this.facteurDeDeplacementX);
    }
    
    /**
     * Permet de modifier la position
     * de l'image en Y
     * @param deplacementRecuY
     */
    public void setFacteurDeDeplacementY(int deplacementRecuY){
    	
    	facteurDeDeplacementY=deplacementRecuY- (largeurImage/2);
    	System.out.println("VOICI LARGEUR / 2  " + largeurImage/2);
    	System.out.println("VOICI LE FACTEUR DE DEPLACEMENT Y "+this.facteurDeDeplacementY);
    	
    }
    
    
    /**
     * Permet de retourner la position de l'image selon X
     * @return (int)
     */
    public int getFacteurDeDeplacementX(){
    	return this.facteurDeDeplacementX;
    }
    
    /**
     * Permet de retourner la position de l'image selon Y
     * @return (int)
     */
    public int getFacteurDeDeplacementY(){
    	return this.facteurDeDeplacementY;
    }
    
    public int recupereCentreXDImage(){
    	return this.largeur/2;
    }
    public int recupereCentreYDImage(){
    	return this.hauteurImage/2;
    }
    
    
    public void setHauteur(int hauteur) {
        this.hauteur = hauteur;
    }

    public void setLargeur(int largeur) {
        this.largeur = largeur;
    }



}
