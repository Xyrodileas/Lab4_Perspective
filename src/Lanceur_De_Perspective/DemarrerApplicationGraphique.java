/******************************************************
Cours:  LOG121
Projet: laboratoire 4
Nom du fichier: DemarrerApplicationGraphique.java
Date cr��: 2014-03-15

 *******************************************************
 *@author Alexis Vuillaume, David Murat, Idriss Aissou,
 *@date Hiver 2014
 *******************************************************/
package Lanceur_De_Perspective;

import Vue.FenetrePrincipale;


public class DemarrerApplicationGraphique {

       public static FenetrePrincipale fenetre;
	   public static void main(String[] args) {
	        fenetre = new Vue.FenetrePrincipale();
	   
	    }

        public static FenetrePrincipale getFenetre(){
            return fenetre;
        }

}
