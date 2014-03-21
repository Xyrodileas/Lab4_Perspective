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

    private SingletonCommande(){
    }
	public static synchronized SingletonCommande getInstance() {
        if(instanceSingleton == null){
            instanceSingleton = new SingletonCommande();
        }
		return instanceSingleton;
	
	}
	
	public void Execution() {
	
	}
}
