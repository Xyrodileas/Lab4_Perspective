/******************************************************
Cours:  LOG121
Projet: laboratoire 4
Nom du fichier:  Observable.java
Date créer: 2014-03-15

 *******************************************************
 *@author Alexis Vuillaume, David Murat, Idriss Aissou,
 *@date Hiver 2014
 *******************************************************/

package Modele;

/**
 * Classe définissant le comportement d'une classe observable
 * 
 */
public class Observable {
	public Modele.Observer observeur;

	/**
	 * Permet d'ajouter un observateur à une classe observable
	 * 
	 * @param observeurRecu
	 *            : Observateur à rajouter
	 */
	public void addObserver(Modele.Observer observeurRecu) {
		observeur = observeurRecu;
	}

	/**
	 * Cette méthode permet de notifier d'un changement de la classe observé aux
	 * observateurs
	 */
	public void Notify() {
		observeur.update();
	}
}
