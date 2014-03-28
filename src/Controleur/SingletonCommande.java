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

/**
 * 
 *Classe qui permet d'obtenir une instance unique
 *des commandes
 */
public class SingletonCommande {

	//ATTRIBUT DE LA CLASSE SINGLETONCOMMANDE
	public static SingletonCommande instanceSingleton;

	/**
	 * Constructeur par defaut de SingletonCommande
	 */
	private SingletonCommande() {}

	/**
	 * Methode qui permet de retourner une instance de SingletonCommande
	 * le tout est synchronise
	 */
	public static synchronized SingletonCommande getInstance() {
		if (instanceSingleton == null) {
			instanceSingleton = new SingletonCommande();
			
		}
		return instanceSingleton;

	}

	/**
	 * Methode qui permet d'executer la commande en question
	 * selon le code recu
	 * @param action (Chaque code correspond a une commande)
	 * @param valeurs  (les parametres selon le type de commande dans un int[])
	 * @param panneauImage (Le panneau Image en question)
	 */
	public static void execution(int action, int[] valeurs, PanneauImage panneauImage) {
		
        Commande maCommande;

        
        /**
         * Chaque num�ro correspond a une commande
         */
		switch (action) {
		//CAS translation (deplacement image)
		case 1:
			maCommande = new Translation(valeurs[0], valeurs[1]);
            break;
        //CAS ZOOM
		case 2:
            maCommande = new Zoom(valeurs[0]);
            break;
        //CAS COLLER
		case 3 :
				maCommande = new Coller(valeurs);
				break;
		//UNDO
		case 4 :
			maCommande = new CtrlZ();
			break;
		//REDO
		case 5 :
			maCommande = new CtrlY();
			break;
		//SINON COMMANDE= NULL
		default:
			maCommande = null;
            break;
        }
		//SI COMMANDE DIFFERENT DE NULL EN L EXECUTE
        if(maCommande != null){
        	//SAVE A CHAQUE MODIFICATION
        	//new SauvegardePerspective().execution(panneauImage);
            maCommande.execution(panneauImage);
        }
        	
        else{}
            // throw Exception;


	}
}
