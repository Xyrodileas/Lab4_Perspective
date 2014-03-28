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

import java.util.Stack;

/**
 * Created by Alexis on 19/03/14.
 */
class Gardien {

    Stack<ImageSnap> savedStatesOld;
    Stack<ImageSnap> savedStatesNext;
    Originator createur;

    public Gardien(){
        createur = new Originator();
        Stack<ImageSnap> savedStatesOld = new Stack<ImageSnap>();
        Stack<ImageSnap> savedStatesNext = new Stack<ImageSnap>();
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
        return createur.restoreFromMemento(savedStatesOld.pop());
    }






}