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

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;

import Vue.PanneauImage;

public class PopMenuClicDroit extends JPopupMenu {
	
	JPopupMenu menuClicDroit;
	JMenuItem menu1;
	JMenuItem menu2;

	PanneauImage panneauImage;
	
	public PopMenuClicDroit(PanneauImage panneauR){
		
		panneauImage=panneauR;
		
		menuClicDroit = new JPopupMenu();

		menu1 = new JMenuItem("Copier Perspective");
		menu1.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("Copier Perspective");
				//SingletonCommande.execution(2, tabParametres, this.panneauImage);
		    }
	    });
	    
	    menu2 = new JMenuItem("Coller Perspective");
		menu2.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("Coller Perspective");
				
				//SingletonCommande.execution(2, tabParametres, this.panneauImage);
		    }
	    });
	  
	    menuClicDroit.add(menu1);
	    menuClicDroit.add(menu2);
 
		
	}
	
	public void declancheMenu(Component comp,int x,int y){
		menuClicDroit.show(comp,x, y);
	}
}
