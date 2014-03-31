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
import java.io.Serializable;




public class Image implements Serializable {
	
	private transient BufferedImage image;
	private Perspective perspective;
	private String chemin;


	
	
	public Image(String lienImage) throws IOException{
		
			image= ImageIO.read(new File(lienImage));
			chemin = lienImage;
            perspective = new Perspective ( image.getWidth(), image.getHeight());

		 
	}

    public Image(Image img){
        this.image = img.image;
        this.perspective = img.perspective;
        this.chemin = img.chemin;
    }

    public Image clone() throws CloneNotSupportedException{
        Image img = null;
        try{
            img = (Image) super.clone();
        } catch(CloneNotSupportedException cnse) {
        System.err.println("Impossible de cloner l'objet");
    }
        img.perspective = perspective.clone();
        return img;
    }
	
	
	public BufferedImage getBufferedImage(){
		 return this.image;
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
    

    public void editPixel(int x, int y){
    	
        try {
			int rgb = 0x33FF00;
			int coordx = (int) ((x - this.perspective.getPositionX()) / (1/this.perspective.getZoom()));
			int coordy = (int)((y - this.perspective.getPositionY()) / (1/this.perspective.getZoom()));
			this.image.setRGB(coordx, coordy, rgb);
			this.image.setRGB(coordx, coordy-1, rgb);
			this.image.setRGB(coordx-1, coordy, rgb);
			this.image.setRGB(coordx-1, coordy-1, rgb);
			this.image.setRGB(coordx, coordy+1, rgb);
			this.image.setRGB(coordx+1, coordy, rgb);
			this.image.setRGB(coordx+1, coordy+1, rgb);
			this.perspective.Notify();
			
		} catch (Exception e) {
	
		}
    }


    public String getChemin(){
        return this.chemin;
    }
    public void setPerspective(Perspective p){
        this.perspective = p;
        this.perspective.Notify();
    }
	
}
