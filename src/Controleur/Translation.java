/******************************************************
Cours:  LOG121
Projet: laboratoire 4
Nom du fichier: SingletonCommande.java
Date creer le: 2014-03-15

 *******************************************************
 *@author Alexis Vuillaume, David Murat, Idriss Aissou,
 *@date Hiver 2014
 *******************************************************/

package Controleur;

import Vue.PanneauImage;

/**
 * Classe qui va permettre d'executer la commande
 * qui permettra de faire bouger l'image sur le panneau
 * d'Image
 * 
 */
public class Translation extends Commande{

	int x, y;

    public Translation(int xModifie, int yModifie) {

        x = xModifie;
        y = yModifie;
    }

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}


    public void execution(PanneauImage panneauImage){
        panneauImage.getPerspective().setPositionX(this.x);
        panneauImage.getPerspective().setPositionY(this.y);
    
        //-----------------------------------A SUPPRIMER APRES CREATION DU NOTIFY OBSERVATEUR -----------------
        panneauImage.repaint();
    }


}
