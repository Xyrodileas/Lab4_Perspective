package Modele;
/******************************************************
Cours:  LOG121
Projet: laboratoire 4
Nom du fichier: Gardien.java
Date cr��: 2014-03-15

 *******************************************************
 *@author Alexis Vuillaume, David Murat, Idriss Aissou,
 *@date Hiver 2014
 *******************************************************/

import java.io.Serializable;
import java.util.Stack;

/**
 * Created by Alexis on 19/03/14.
 */
class Gardien implements Serializable{

    Stack<ImageSnap> savedStatesOld;
    Stack<ImageSnap> savedStatesNext;
    Originator createur;

    public Gardien(){
        createur = new Originator();
        savedStatesOld = new Stack<ImageSnap>();
        savedStatesNext = new Stack<ImageSnap>();
    }

    public void ajouterSnap(Perspective state){
        createur.SetSave(state);
        savedStatesOld.push(createur.CreateSave());
    }

    public Perspective restorLast(){
        savedStatesNext.push(savedStatesOld.peek());
        return createur.restoreFromMemento(savedStatesOld.pop());

    }
    public Perspective restorNext(){
        savedStatesOld.push(savedStatesNext.peek());
        return createur.restoreFromMemento(savedStatesNext.pop());
    }






}