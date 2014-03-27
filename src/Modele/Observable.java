/******************************************************
Cours:  LOG121
Projet: laboratoire 4
Nom du fichier:  Observable.java
Date créé: 2014-03-15

 *******************************************************
 *@author Alexis Vuillaume, David Murat, Idriss Aissou,
 *@date Hiver 2014
 *******************************************************/

package Modele;



public class Observable  {
	public Modele.Observer observeur;
	
	public void addObserver(Modele.Observer observeurRecu){
		observeur = observeurRecu;
	}
	
	public void Notify() {
	observeur.update();
	}
}
