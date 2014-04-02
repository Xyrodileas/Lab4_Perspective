package Modele;
/******************************************************
Cours:  LOG121
Projet: laboratoire 4
Nom du fichier: Gardien.java
Date creer: 2014-03-15

 *******************************************************
 *@author Alexis Vuillaume, David Murat, Idriss Aissou,
 *@date Hiver 2014
 *******************************************************/

import java.io.Serializable;
import java.util.EmptyStackException;
import java.util.Stack;

/**
 * Application du patron Memento :
 * Utilisation de deux piles pour restauration des �tats de l'image
 * revenir � l'instant t-1 ou t+1
 *
 */
class Gardien implements Serializable{

    Stack<ImageSnap> savedStatesOld;
    Stack<ImageSnap> savedStatesNext;
    Originator createur;
    Perspective actuelle;
    Perspective autre;

    /**
     * Constructeur par defaut de la classe Gardien
     * Qui permet d'instancier un Originator
     * Et deux piles qui vont permettre la restoration des �tats de l'image
     */
    public Gardien(){
        createur = new Originator();
        savedStatesOld = new Stack<ImageSnap>();
        savedStatesNext = new Stack<ImageSnap>();
    }

    /**
     * Methode qui permet d'ajouter un etat (Perspective)
     * dans la pile afin de concerver les modifications de l'image
     * et de pouvoir les restaurer par la suite
     * @param state (Perspective)
     */
    public void ajouterSnap(Perspective state){
        createur.SetSave(state);
        savedStatesOld.push(createur.CreateSave());
    }

    /**
     * Methode qui permet de retourner l'ancien etat de l'image dans le 
     * memento
     * @return Perspective
     */
    public Perspective restorLast() throws EmptyStackException{
    	try {
    		savedStatesNext.push(savedStatesOld.peek());
            return createur.restoreFromMemento(savedStatesOld.pop());

    	} catch (EmptyStackException e) {
			return new NullPerspective();
		}

    }
    
    /**
     * Methode qui permet de retourner un etat de l'image dans le 
     * memento
     * @return Perspective
     */
    public Perspective restorNext() throws EmptyStackException{
    	
        try {
			savedStatesOld.push(savedStatesNext.peek());
		    return createur.restoreFromMemento(savedStatesNext.pop());

		} catch (Exception e) {
			return new NullPerspective();
		}
    }

    public void resetNextStack() {
        if(!this.savedStatesNext.empty())
            this.savedStatesNext = new Stack<ImageSnap>();
    }
}