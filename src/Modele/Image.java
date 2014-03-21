/******************************************************
Cours:  LOG121
Projet: laboratoire 4
Nom du fichier: Image.java
Date créé: 2014-03-15

 *******************************************************
 *@author Alexis Vuillaume, David Murat, Idriss Aissou,
 *@date Hiver 2014
 *******************************************************/

package Modele;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;




public class Image  {
	
	private BufferedImage image;	
	private Perspective perspective;
	
	private String chemin;
	private int imageLargeur;
	private int imageHauteur;


	
	
	public Image(String lienImage, int largeurDupanneau, int hauteurDuPanneau) throws IOException{
		
			image= ImageIO.read(new File(lienImage));
			chemin = lienImage;
	      	int imageLargeur = image.getWidth();
	        int imageHauteur = image.getHeight();
	        
	        perspective = new Perspective ((largeurDupanneau - imageLargeur) / 2,(hauteurDuPanneau - imageHauteur) / 2);
	  
		 
	}
	
	
	public BufferedImage getBufferedImage(){
		 return this.image;
	}
	
	public int getImageLargeur(){
		return imageLargeur;
	}
	
	public int getImageHauteur(){
		return imageHauteur;
	}
	public Perspective getPerspective(){
		return perspective;
	}
	
}
