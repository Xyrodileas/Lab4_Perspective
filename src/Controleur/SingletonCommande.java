/******************************************************
Cours:  LOG121
Projet: laboratoire 4
Nom du fichier: SingletonCommande.java
Date cr��: 2014-03-15

 *******************************************************
 *@author Alexis Vuillaume, David Murat, Idriss Aissou,
 *@date Hiver 2014
 *******************************************************/

package Controleur;

import Vue.PanneauImage;

public class SingletonCommande {

	public static SingletonCommande instanceSingleton;

	private SingletonCommande() {
	}

	public static synchronized SingletonCommande getInstance() {
		if (instanceSingleton == null) {
			instanceSingleton = new SingletonCommande();
		}
		return instanceSingleton;

	}

	public static void execution(int action, int[] valeurs, PanneauImage panneauImage) {

        Commande maCommande;
		switch (action) {

		case 1:
            maCommande = new Translation(valeurs[0], valeurs[1]);
            break;
		case 2:
            maCommande = new Zoom(valeurs[0]);
            break;
		default:
			maCommande = null;
            break;
        }
        if(maCommande != null)
            maCommande.execution(panneauImage);
        else{}
            // throw Exception;


	}
}
