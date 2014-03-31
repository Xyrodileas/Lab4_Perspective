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

import java.io.Serializable;


public class ImageSnap implements Serializable{
    private double zoom;

    private int posY;
    private int posX;

	public ImageSnap(double zoom, int posX, int posY){
        this.zoom = zoom;
        this.posY = posY;
        this.posX = posX;
    }

    public double getZoom() {
        return zoom;
    }

    public int getPosY() {
        return posY;
    }

    public int getPosX() {
        return posX;
    }
}
