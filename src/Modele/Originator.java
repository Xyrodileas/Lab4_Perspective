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


public class Originator {
    public int zoom;
    public Image img;

    private int hauteur;
    private int largeur;
	public void SetSave(Perspective maperspective) {

        this.hauteur = maperspective.getHauteur();
        this.hauteur = maperspective.getLargeur();
        this.zoom = maperspective.getZoom();
	}
	
	public ImageSnap CreateSave() {
        return new ImageSnap(this.zoom, this.hauteur, this.largeur);
	}
    public Perspective restoreFromMemento(ImageSnap snap){
        return new Perspective(snap.getLargeur(), snap.getLargeur(), snap.getZoom());
    }
}
