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

import Vue.PanneauImage;

import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * Classe généralisant les commandes
 */
public abstract class Commande {

    /**
     * Methode général d'exécution d'une commande
     * @param image
     */
    public abstract void execution(PanneauImage image);

    /**
     * Méthode général d'exécution de commande retournant une exception
     * @return
     * @throws FileNotFoundException
     * @throws IOException
     */
    public abstract Modele.Image execution() throws FileNotFoundException, IOException;
}
