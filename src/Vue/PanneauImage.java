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

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Insets;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Observable;

import javax.swing.JComponent;



public class PanneauImage extends JComponent implements Controleur.Observer {
	
	//ATTRIBUTS DE IMAGE
	public FenetrePrincipale fenetrePrincipale;
	public Modele.Image image;
	private BufferedImage imagebuffer;
	
	private int zoom=1;
	private Insets insets;
	private Dimension size;
	private  int largeurDuPanneau;
    private  int hauteurDuPanneau ;
		
	
	public PanneauImage(FenetrePrincipale fenetre){
		
		this.fenetrePrincipale=fenetre;
		
	}
	
	/**
	 * Methode qui va permettre de dessiner
	 * l'image sur le panneau image
	 */
	
	public void paint(Graphics g){
			
			   super.paintComponent(g);
			      Graphics2D graphic2d = (Graphics2D) g;
			      if (imagebuffer != null) {

			   	   	insets = getInsets();
			   	   	size = getSize();
			          
			        int largeurDuPanneau = size.width - (insets.left + insets.right);
			        int hauteurDuPanneau = size.height - (insets.top + insets.bottom);
			    	  
			     
			        int LargeurDeImage = imagebuffer.getWidth() * zoom;
			        int hauteurDeImage = imagebuffer.getHeight() * zoom;
			        
			        int x = (largeurDuPanneau - LargeurDeImage) / 2;
			        int y = (hauteurDuPanneau - hauteurDeImage) / 2;
			        
			        // Pour permettre au bord optionnel d'etre dessine.
			        graphic2d.translate(insets.left, insets.top);
			        graphic2d.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
			        graphic2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_OFF);
			        graphic2d.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_NEAREST_NEIGHBOR);
			        graphic2d.drawImage(imagebuffer, x, y, LargeurDeImage, hauteurDeImage, null);
			        
			        // Retour a l'origine du repere.
			        graphic2d.translate( -insets.left, -insets.top);
			
		}
		else{
			g.drawString("Choisir une Image...", 650, 350);
			}
			
		

	}
	
	
	public void setImage(String lienImage) throws IOException{
		image = Modele.FabriqueImage.fabriqueImage(lienImage);
		imagebuffer = image.getBufferedImage();
		repaint();
	}

	
	/**
	 * Methode qui permet de rafraichir 
	 * le panneauImage
	 */
	public void rafraichirPanneauImage(){
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
