/******************************************************
Cours:  LOG121
Projet: laboratoire 4
Nom du fichier: OriginatoPerspective.java
Date crï¿½ï¿½: 2014-03-15

 *******************************************************
 *@author Alexis Vuillaume, David Murat, Idriss Aissou,
 *@date Hiver 2014
 *******************************************************/

package Modele;

/**
 * Classe qui permet de retenir la perspective d'une image,
 *
 */
public class Perspective extends Modele.Observable {
	
	//LES ATTRIBUTS DE PERSPËCTIVE
	private double zoom;
	public Gardien sauvegardes;
	private int hauteurImage;
	private int largeurImage;
	private int positionX;
	private int positionY;

	
	/**
	 * Constructeur par defaut de Perspective
	 * @param largeurImageR
	 * @param hauteurImageR
	 */
    public Perspective(int largeurImageR, int hauteurImageR){
		
		hauteurImage = hauteurImageR;
		largeurImage= largeurImageR;
		
		positionX =0;
		positionY =0;
		this.zoom = 1.00;
        this.sauvegardes = new Gardien();

		
	}
    /**
     * Constructeur de Perspective selon une image Snap 
     * @param largeurRecu
     * @param hauteurRecu
     * @param zoom
     */
    public Perspective(int largeurRecu, int hauteurRecu, double zoom){

        this.positionX = hauteurRecu;
        this.zoom = zoom;
        positionX = 0;
        positionY = 0;
    }
    
    //------------------------------------------LES GETS------------------------------------------------------------------------
    /**
     * Methode qui permet de retourner la hauteur de 
     * l'image
     * @return hauteurImage (int)
     */
    public int getHauteurImage(){
        return this.hauteurImage;
    }

    /**
     * Methode qui permet de retourner la largeur de 
     * l'image
     * @return largeurImage (int)
     */
    public int getLargeurImage(){
        return this.largeurImage;
    }
    
    /**
     * MEthode qui permet de retourner le niveau de zoom
     * de la perspective
     * @return (int) zoom
     */
    public double getZoom(){
        return zoom;
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

    //------------------------------------------------GESTION DU DEPLACEMENT DE L'IMAGE (SETS)---------------------
    /**
     * Methode qui Permet de modifier la position
     * de l'image en X
     * @param deplacementRecuX
     */
    public void setPositionX(int deplacementRecuX){
        positionX += deplacementRecuX;
        Notify();

    }
    
    /**
     * Methode qui Permet de modifier la position
     * de l'image en Y
     * @param deplacementRecuY
     */
    public void setPositionY(int deplacementRecuY){

        positionY += deplacementRecuY;
        Notify();
    }

        
    //------------------------------------------------ACTION SUR ZOOM--------------------------------------------------
    
    /**
     * Methode qui permet de incrémenter le zoom de la perspective
     * Le zoom se décrémente par pas de 0.02
     */
    public void incrementeZoom(){
    	
    	if(zoom>0.020)
    		this.zoom=this.zoom-0.020;
  
    	  Notify();
    }
    
    /**
     * Methode qui permet de décrémenter le zoom de la perspective
     * Le zoom se décrémente par pas de 0.02
     */
    public void decrementeZoom(){
    	
    	this.zoom=this.zoom+0.020;
    	  Notify();
    }
    
    /**
     * Methode qui permet de copier les 
     * paramètre d'une perspective a une autre
     * @param pR (Modele.Perspective)
     */
    public void collerUnePerspective(int[] params){
    	this.positionX = params[0] ;
		this.positionY = params[1]; 
		this.zoom = params[2];
    	Notify();
    }


   

}
