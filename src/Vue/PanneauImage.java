/******************************************************
Cours:  LOG121
Projet: laboratoire 4
Nom du fichier: PanneauImage.java
Date cr��: 2014-03-15

 *******************************************************
 *@author Alexis Vuillaume, David Murat, Idriss Aissou,
 *@date Hiver 2014
 *******************************************************/


package Vue;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Observable;

public class PanneauImage extends JComponent implements Modele.Observer {
	
	//ATTRIBUTS DU PANNEAU IMAGE
	private Modele.Image image;
	private BufferedImage imageAdessiner;
	private Modele.Perspective perpective;
	private int x;
	private int y;
	private double zoom;
	private int largeurDeLimage;
	private int hauteurDeLimage;
   		
	/**
	 * Constructeur par defaut de la classe PanneauImage
	 */
	public PanneauImage(){	}
	
	/**
	 * Methode qui va permettre de dessiner
	 * l'image sur le panneau image selon ses 
	 * caracteristiques
	 */
	public void paint(Graphics g){
			   super.paintComponent(g);
			      Graphics2D graphic2d = (Graphics2D) g;
			      if (imageAdessiner != null) {
			    	  
			        int largeurDuPanneau = getSize().width - (getInsets().left + getInsets().right);
			        int hauteurDuPanneau = getSize().height - (getInsets().top + getInsets().bottom);
			        
			        graphic2d.drawImage(imageAdessiner, x,y, ((int)(largeurDeLimage*zoom)),((int)(hauteurDeLimage*zoom)), this);
		}
		else{
			g.drawString("Choisir une Image...", 650, 350);
			}
	}
	
	
	/**
	 * Methode qui permet d'initialiser l'image au panneau
	 * @param lienImage
	 * @throws IOException
	 */
	public void setImage(String lienImage) throws IOException{

		image = Modele.FabriqueImage.fabriqueImage(lienImage);
		imageAdessiner = image.getBufferedImage();
		perpective=image.getPerspective();
		perpective.addObserver(this);
		reactualiserPanneauImage();
		
	}
	
	
	/**
	 * Methode qui permet de retourner la perspective
	 * de l'image a dessiner
	 * @return Perspective
	 */
	public Modele.Perspective getPerspective(){
		return this.perpective;
	}
	
	
	/**
	 * Methode qui permet de savoir si
	 * le panneau Image dispose d'une image ou non
	 * @return boolean
	 * true = image non vide
	 * false = image vide
	 */
	public boolean imageEstVide(){
		if(imageAdessiner!=null)
			return true;
		return false;
	}

	
	/**
	 * Methode qui permet de rafraichir ou reactualiser
	 * les parametres de l'image a afficher 
	 * le panneauImage
	 */
	public void reactualiserPanneauImage(){
		x=perpective.getPositionX();
		y=perpective.getPositionY();
		zoom= (1/(image.getPerspective().getZoom()));
		hauteurDeLimage=perpective.getHauteurImage();
		largeurDeLimage=perpective.getLargeurImage();
		repaint();
	}
	
	
	/**
	 * Methode qui va permettre de mettre a jour
	 * le panneau image selon les variations de 
	 * perspective
	 * cette methode est appeler par la classe Observable
	 */
	public void update() {
		reactualiserPanneauImage();
	}


	
}
