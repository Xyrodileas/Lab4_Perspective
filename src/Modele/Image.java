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

/**
 * Classe correspondant à une superImage, contenant une image, une perspective
 * et un chemin Cette classe implémente sérializable car elle va etre
 * enregistrer dans la sauvegarde de l'objet
 * 
 */
public class Image implements Serializable {

	// Image concrete
	private transient BufferedImage image;
	// Perscpective de l'image
	private Perspective perspective;
	// Chemin de l'image dans le dossier
	private final String chemin;

	/**
	 * Constructeur de la classe avec le chemin en parametre
	 * 
	 * @param lienImage
	 * @throws IOException
	 */
	public Image(String lienImage) throws IOException {

		image = ImageIO.read(new File(lienImage));
		chemin = lienImage;
		// Création d'une nouvelle perspective
		perspective = new Perspective(image.getWidth(), image.getHeight());

	}

	/**
	 * Consructeur de la classe avec une image en parametre
	 * 
	 * @param img
	 */
	public Image(Image img) {
		this.image = img.image;
		this.perspective = img.perspective;
		this.chemin = img.chemin;

	}

	/**
	 * Méthode permettant de cloner une image
	 */
	public Image clone() throws CloneNotSupportedException {
		Image img = null;
		try {
			img = (Image) super.clone();
		} catch (CloneNotSupportedException cnse) {
			System.err.println("Impossible de cloner l'objet");
		}
		img.perspective = perspective.clone();
		return img;
	}

	/**
	 * Accesseur de l'image
	 * 
	 * @return l'image concrete
	 */
	public BufferedImage getBufferedImage() {
		return this.image;
	}

	/**
	 * Accesseur de la perspective
	 * 
	 * @return la perspective attaché à l'image
	 */
	public Perspective getPerspective() {
		return perspective;
	}

	/**
	 * Accesseur de la position x de la perspective
	 * 
	 * @return la position en x
	 */
	public int getPosx() {
		return this.perspective.getPositionY();
	}

	/**
	 * Accesseur de la position y de la perspective
	 * 
	 * @return la position en y
	 */
	public int getPosy() {
		return this.perspective.getPositionX();
	}

	/**
	 * Accesseur de la largeur de l'image
	 * 
	 * @return la largeur de l'image
	 */
	public int getLargeurImage() {
		return this.perspective.getLargeurImage();
	}

	/**
	 * Accesseur de la hauteur de l'image
	 * 
	 * @return la hauteur de l'image
	 */
	public int getHauteurImage() {
		return this.perspective.getHauteurImage();
	}

	/**
	 * Accesseur du chemin de l'image
	 * 
	 * @return
	 */
	public String getChemin() {
		return this.chemin;
	}

	/**
	 * Modificateur de la perspective
	 * 
	 * @param p
	 *            : Perspective à modifier
	 */
	public void setPerspective(Perspective p) {
		this.perspective = p;

	}

	/**
	 * 
	 * @param x
	 * @param y
	 */
	public void editPixel(int x, int y) {

		try {
			int rgb = 0x33FF00;
			int coordx = (int) ((x - this.perspective.getPositionX()) / (1 / this.perspective
					.getZoom()));
			int coordy = (int) ((y - this.perspective.getPositionY()) / (1 / this.perspective
					.getZoom()));
			this.image.setRGB(coordx, coordy, rgb);
			this.image.setRGB(coordx, coordy - 1, rgb);
			this.image.setRGB(coordx - 1, coordy, rgb);
			this.image.setRGB(coordx - 1, coordy - 1, rgb);
			this.image.setRGB(coordx, coordy + 1, rgb);
			this.image.setRGB(coordx + 1, coordy, rgb);
			this.image.setRGB(coordx + 1, coordy + 1, rgb);
			getPerspective().save();
			this.perspective.Notify();

		} catch (Exception e) {

		}
	}

}
