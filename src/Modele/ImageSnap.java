/******************************************************
Cours:  LOG121
Projet: laboratoire 4
Nom du fichier: ImageSnap.java
Date cr��: 2014-03-15

 *******************************************************
 *@author Alexis Vuillaume, David Murat, Idriss Aissou,
 *@date Hiver 2014
 *******************************************************/



package Modele;


public class ImageSnap {
    private double zoom;

    private int hauteur;
    private int largeur;

	public ImageSnap(double zoom, int hauteur, int largeur){
        this.zoom = zoom;
        this.hauteur = hauteur;
        this.largeur = largeur;
    }

    public double getZoom() {
        return zoom;
    }

    public int getHauteur() {
        return hauteur;
    }

    public int getLargeur() {
        return largeur;
    }
}
