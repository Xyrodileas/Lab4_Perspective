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

import java.io.FileNotFoundException;
import java.io.IOException;

import Vue.PanneauImage;


public abstract class Commande {

    public abstract void execution(PanneauImage image);
    
    public abstract Modele.Image execution() throws FileNotFoundException, IOException;
}
