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

import java.awt.BorderLayout;
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
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSlider;



public class PanneauImage extends JPanel implements Controleur.Observer {
	
	//ATTRIBUTS DE IMAGE
	public FenetrePrincipale fenetrePrincipale;
	public Modele.Image image;
	private BufferedImage imagebuffer;
	
	private int zoom=1;
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
			    	  
			     
			        int LargeurDeImage = imagebuffer.getWidth() * zoom;
			        int hauteurDeImage = imagebuffer.getHeight() * zoom;
			        
			        int x = (largeurDuPanneau - LargeurDeImage) / 2;
			        int y = (hauteurDuPanneau - hauteurDeImage) / 2;
			        
			        // Pour permettre au bord optionnel d'etre dessine.
		
			        graphic2d.drawImage(imagebuffer, x, y, LargeurDeImage, hauteurDeImage, null);
			        
			
			
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
	
	public void testIncrementerZoom(){
		zoom++;
	}
	
	public void testDecrementerZoom(){
		if( zoom >1)
			zoom--;
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
