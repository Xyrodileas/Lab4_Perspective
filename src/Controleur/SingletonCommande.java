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

	public static void execution(int action, int[] valeurs) {

		switch (action) {

		case 1:

			break;
		case 2:

			break;
		case 3:

			break;
		case 4:

			break;
		case 5:

			break;
		case 6:

			break;
		case 7:

			Translation nouvelleTranslation = new Translation();
			nouvelleTranslation.setTranslation(valeurs[0], valeurs[1]);

			break;

		}

	}
}
