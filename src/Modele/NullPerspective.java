/******************************************************
Cours:  LOG121
Projet: laboratoire 4
Nom du fichier: NullPerspective.java
Date créer: 2014-03-15

 *******************************************************
 *@author Alexis Vuillaume, David Murat, Idriss Aissou,
 *@date Hiver 2014
 *******************************************************/

package Modele;

/**
 * Classe permettant de définir un objet PerspectiveNull selon le patron Object Null
 *
 */
public class NullPerspective extends Perspective {

    public NullPerspective(int x, int y){

    }

    public NullPerspective(int PosX, int PosY, double zoom) {

    }

    public NullPerspective(){
    }


    @Override
    public void incrementeZoom() {

    }

    @Override
    public void decrementeZoom() {

    }

    @Override
    public int getHauteurImage() {
        return 0;
    }

    @Override
    public int getLargeurImage() {
        return 0;
    }

    @Override
    public double getZoom() {
        return 0;
    }

    @Override
    public int getPositionX() {
        return 0;
    }

    @Override
    public int getPositionY() {
       return 0;
    }

    @Override
    public void setPositionX(int deplacementRecuX) {

    }

    @Override
    public void setPositionY(int deplacementRecuY) {

    }

    @Override
    public void restorePerspective(Perspective snap) {

    }

    @Override
    public void lastSnap() {

    }

    @Override
    public void nextSnap() {

    }

    @Override
    public void save() {

    }

    @Override
    public void collerUnePerspective(int[] tab) {

    }

    @Override
    public Perspective clone() {
       return null;
    }
}
