/******************************************************
Cours:  LOG121
Projet: laboratoire 4
Nom du fichier: Originator.java
Date cr��: 2014-03-15

 *******************************************************
 *@author Alexis Vuillaume, David Murat, Idriss Aissou,
 *@date Hiver 2014
 *******************************************************/


package Modele;

import java.io.Serializable;


public class Originator implements Serializable{
    public double zoom;
    public Image img;

    private int posX;
    private int posY;
	public void SetSave(Perspective maperspective) {

        this.posX = maperspective.getPositionX();
        this.posY = maperspective.getPositionY();
        this.zoom = maperspective.getZoom();
	}
	
	public ImageSnap CreateSave() {
        return Modele.FabriqueImage.fabriqueImageSnap(this.zoom, this.posX, this.posY);
	}
    public Perspective restoreFromMemento(ImageSnap snap){
        return new Perspective(snap.getPosX(), snap.getPosY(), snap.getZoom());
    }
}
