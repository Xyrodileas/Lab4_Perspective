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



public class PanneauImage extends JPanel implements Modele.Observer {
	
	//ATTRIBUTS DE IMAGE
	public FenetrePrincipale fenetrePrincipale;
	public Modele.Image image;
	private BufferedImage imagebuffer;
	
	
	private Insets insets;
	private Dimension size;
	
	private  int largeurDuPanneau;
    private  int hauteurDuPanneau ;
    
   
    
    //protected JSlider zoomeur = new JSlider(JSlider.BOTTOM, 1, 4, 1);
		
	
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


			        int LargeurDeImage = (int) (imagebuffer.getWidth() * image.getPerspective().getZoom());
			        int hauteurDeImage = (int) (imagebuffer.getHeight() * image.getPerspective().getZoom());
			        
			        //Centre du panneau
			        int x = (largeurDuPanneau - LargeurDeImage) / 2;
			        int y = (hauteurDuPanneau - hauteurDeImage) / 2;
			        
			        // Pour permettre au bord optionnel d'etre dessine.
		
			        graphic2d.drawImage(imagebuffer, x, y, LargeurDeImage, hauteurDeImage, this);
			       			
			
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
		rafraichirPanneauImage();
		
	}


	
}
