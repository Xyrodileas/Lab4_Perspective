/******************************************************
Cours:  LOG121
Projet: laboratoire 4
Nom du fichier: PanneauImage.java
Date créé: 2014-03-15

 *******************************************************
 *@author Alexis Vuillaume, David Murat, Idriss Aissou,
 *@date Hiver 2014
 *******************************************************/


package Vue;

import java.awt.Graphics;
import java.util.Observable;

import javax.swing.JPanel;


public class PanneauImage extends JPanel implements Controleur.Observer {
	
	/**
	 * Attributs de PanneauImage
	 */
	public FenetrePrincipale fenetrePrincipale;
	
	public Modele.Image image;
	
	public PanneauImage(FenetrePrincipale fenetre){
		
		this.fenetrePrincipale=fenetre;
		
		this.setVisible(true);
		
	}
	
	/**
	 * Methode qui va permettre de dessiner
	 * l'image sur le panneau image
	 */
	public void paint(Graphics g){
		
		/**super.paintComponent(g);
		image = getToolkit().getImage("adresse de l'image");
		
		if(image != null) 
		g.drawImage(image, 200, 20, this);**/
	}
	
	
	public void setImage(){
		image = Modele.FabriqueImage.fabriqueImage();
	}
	
	/**
	 * Methode qui permet de rafraichir 
	 * le panneauImage
	 */
	public void rafraichirPanneauImage(){
		this.validate();
		this.repaint();
	}
	
	
	/**
	 * Methode qui va permettre de mettre a jour
	 * le panneau image selon les variations de 
	 * perspective
	 */
	public void update(Observable arg0, Object arg1) {
		// TODO Auto-generated method stub
		
	}

	
}
