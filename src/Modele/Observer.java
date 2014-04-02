/******************************************************
Cours:  LOG121
Projet: laboratoire 4
Nom du fichier: Observer.java
Date cr��: 2014-03-15

 *******************************************************
 *@author Alexis Vuillaume, David Murat, Idriss Aissou,
 *@date Hiver 2014
 *******************************************************/

package Modele;

import java.util.Observable;

/**
 * Cette classe permet de définir le conportement d'une classe Oservateur selon
 * le patron Observable
 * 
 * @author David
 * 
 */
public interface Observer {

	/**
	 * Méthode appelé lors d'une notification de la classe observée pour les
	 * observateurs
	 */
	public void update();
}
