/******************************************************
Cours:  LOG121
Projet: laboratoire 4
Nom du fichier: OriginatoPerspective.java
Date creer: 2014-03-15

 *******************************************************
 *@author Alexis Vuillaume, David Murat, Idriss Aissou,
 *@date Hiver 2014
 *******************************************************/

package Modele;

import java.io.Serializable;
import java.util.EmptyStackException;


public class Perspective extends Modele.Observable implements Serializable{
	
	//ATTRIBUTS DE LA CLASSE PERSPECTIVE
	private double zoom;
	public Gardien sauvegardes;
	private int hauteurImage;
	private int largeurImage;
	private int positionX;
	private int positionY;

    /**
     * Constructeur par défaut de Perspective
     */
    public Perspective(){}

	/**
	 * Constructeur de Perspective
	 * qui recoit en parametre la hauteur de l'image ainsi que sa hauteur
	 * @param largeurImageR
	 * @param hauteurImageR
	 */
    public Perspective(int largeurImageR, int hauteurImageR){
		
		hauteurImage = hauteurImageR;
		largeurImage= largeurImageR;
		positionX =0;
		positionY =0;
		this.zoom = 1;
        this.sauvegardes = new Gardien();

		
	}
    /**
     * Constructeur de Perspective qui va permettre de cr�er une perspective
     * en recevant en parametre une position a lecran X et Y ainsi qu'un zoom
     * @param PosX (Int)
     * @param PosY (Int)
     * @param zoom (double)
     */
    public Perspective(int PosX, int PosY, double zoom){
        this.positionY = PosY;
        this.zoom = zoom;
        this.positionX = PosX;
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

    //-------------------------------------------------------------Getteur------------------------------------------------
    /**
     * Methode qui va permettre de retourner la hauteur de l'image
     * @return hauteur (Int)
     */
    public int getHauteurImage(){
        return this.hauteurImage;
    }

    /**
     * Methode qui va permettre de retourner la largeur de l'image
     * @return largeur (Int)
     */
    public int getLargeurImage(){
        return this.largeurImage;
    }


    /**
     * Methode qui permet de retourner la valeur du zoom
     * de la perspective
     * @return zoom (double)
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




    //------------------------GESTION DU DEPLACEMENT DE L'IMAGE ( PERSPECTIVE )---------------------
    /**
     * Permet de modifier la position
     * de l'image en X
     * @param deplacementRecuX (Int)
     */
    public void setPositionX(int deplacementRecuX){
        positionX += deplacementRecuX;
        Notify();

    }
    
    /**
     * Permet de modifier la position
     * de l'image en Y
     * @param deplacementRecuY (Int)
     */
    public void setPositionY(int deplacementRecuY){

        positionY += deplacementRecuY;
        Notify();
    }
    
    /**
     * Methode qui permet de definir le niveau de zoom
     * @param zoom (double)
     */
    public void setZoom(double zoom){
        this.zoom = zoom;
        Notify();
    }

    /**
     * MEthode qui permet de restaurer une perspective
     * implique l'utilisation de la sauvegardes
     * @param snap
     */
    public void restorePerspective(Perspective snap){
        if(!(snap instanceof NullPerspective)){
            this.positionX = snap.positionX;
            this.positionY = snap.positionY;
            this.zoom = snap.getZoom();
        }
    }

    /**
     * MEthode qui permet de r�cuperer la premiere sauvegarde de l'image donc de la perspective
     */
    public void lastSnap(){
        restorePerspective(this.sauvegardes.restorLast());
        Notify();
    }

    /**
     * MEthode qui permet de restorer l'ancienne version de l'image donc de la perspective
     */
    public void nextSnap(){
    	
        try {
			restorePerspective(this.sauvegardes.restorNext());
			Notify();
		} catch (EmptyStackException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("JE suis dans l'exception");
		}
    }

    /**
     * Methode qui permet de sauvegarder une 
     * perspective dans la pile ( Memento)
     */
    public void save(){
        sauvegardes.ajouterSnap(this);
    }
    
    /**
     * Methode qui permet de coller une perspective
     * selon le menu copier coller ( clic droit )
     * @param tab
     */
    public void collerUnePerspective(int[] tab){
    	this.positionX = tab[0];
    	this.positionY = tab[1];
    	this.zoom = (double)tab[2]/100;
    	Notify();
    	
    }

    
    /**
     * Methode qui permet de cloner une perspective
     * permet de retourner une Perspective
     */
    public Perspective clone() {
        Perspective perp = null;
        try {
            perp = (Perspective) super.clone();
        } catch(CloneNotSupportedException e) {
            e.printStackTrace(System.err);
        }

        return perp;
    }

    public void resetStackNext() {
        this.sauvegardes.resetNextStack();
    }

 
}
