/******************************************************
Cours:  LOG121
Projet: laboratoire 4
Nom du fichier: Image.java
Date cr��: 2014-03-15

 *******************************************************
 *@author Alexis Vuillaume, David Murat, Idriss Aissou,
 *@date Hiver 2014
 *******************************************************/

package Modele;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;




public class Image  {
	
	private BufferedImage image;	
	private Perspective perspective;
	
	private String chemin;
	private int imageLargeur;
	private int imageHauteur;

	
	
	public Image(String lienImage) throws IOException{
		
			image= ImageIO.read(new File(lienImage));
			chemin = lienImage;
			//	int imageLargeur = image.getWidth();
	        //int imageHauteur = image.getHeight();


            perspective = new Perspective ( image.getWidth(), image.getHeight());
	  
		 
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

    public int getPosx(){
        return this.perspective.getPositionY();
    }
    public int getPosy(){
        return this.perspective.getPositionX();
    }
    
    public int getLargeurImage(){
    	return this.perspective.getLargeurImage();
    }
	
    public int getHauteurImage(){
    	return this.perspective.getHauteurImage();
    }
    
    public int getFacteurDeplacementX(){
    	return perspective.getPositionX();
    }

    public int getFacteurDeplacementY(){
    	return perspective.getPositionY();
    }
    

	
}
