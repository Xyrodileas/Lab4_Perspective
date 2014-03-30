package Modele;
/******************************************************
Cours:  LOG121
Projet: laboratoire 4
Nom du fichier: Gardien.java
Date crï¿½ï¿½: 2014-03-15

 *******************************************************
 *@author Alexis Vuillaume, David Murat, Idriss Aissou,
 *@date Hiver 2014
 *******************************************************/

import java.io.Serializable;
import java.util.Stack;

/**
 * Application du patron Memento :
 * Utilisation de deux piles pour restauration des états de l'image
 * revenir à l'instant t-1 ou t+1
 *
 */
class Gardien implements Serializable{

    Stack<ImageSnap> savedStatesOld;
    Stack<ImageSnap> savedStatesNext;
    Originator createur;

    /**
     * Constructeur par defaut de la classe Gardien
     * Qui permet d'instancier un Originator
     * Et deux piles qui vont permettre la restoration des états de l'image
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
    public Perspective restorLast(){
        savedStatesNext.push(savedStatesOld.peek());
        return createur.restoreFromMemento(savedStatesOld.pop());

    }
    
    /**
     * Methode qui permet de retourner un etat de l'image dans le 
     * memento
     * @return Perspective
     */
    public Perspective restorNext(){
        savedStatesOld.push(savedStatesNext.peek());
        return createur.restoreFromMemento(savedStatesNext.pop());
    }

}