/******************************************************
Cours:  LOG121
Projet: laboratoire 4
Nom du fichier: Observer.java
Date créé: 2014-03-15

 *******************************************************
 *@author Alexis Vuillaume, David Murat, Idriss Aissou,
 *@date Hiver 2014
 *******************************************************/

package Modele;

import java.util.Observable;


public interface Observer {
	
	public void update(Observable arg0, Object arg1);
}
