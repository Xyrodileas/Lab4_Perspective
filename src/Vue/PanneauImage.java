/******************************************************
Cours:  LOG121
Projet: laboratoire 4
Nom du fichier: PanneauImage.java
Date créer: 2014-03-15

 *******************************************************
 *@author Alexis Vuillaume, David Murat, Idriss Aissou,
 *@date Hiver 2014
 *******************************************************/

package Vue;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

/**
 * Classe définissant le comportement d'un panneau contenant une image
 * 
 */
public class PanneauImage extends JPanel implements Modele.Observer {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3033645178026518801L;
	// ATTRIBUTS DU PANNEAU IMAGE
	private Modele.Image image;
	private int x;
	private int y;
	private int largeurDeLimage;
	private int hauteurDeLimage;

	/**
	 * Constructeur par defaut de la classe PanneauImage
	 */
	public PanneauImage() {
	}

	/**
	 * Methode qui va permettre de dessiner l'image sur le panneau image selon
	 * ses caracteristiques
	 */
	public void paint(Graphics g) {
		super.paintComponent(g);
		Graphics2D graphic2d = (Graphics2D) g;
		try {
			if (this.image.getBufferedImage() != null) {

				graphic2d.drawImage(this.image.getBufferedImage(), x, y,
						largeurDeLimage, hauteurDeLimage, this);
			}
		} catch (NullPointerException e) {
			g.drawString("Choisir une Image...", 650, 350);
		}
	}

	/**
	 * Methode qui permet d'initialiser l'image au panneau
	 * 
	 * @param lienImage
	 * @throws IOException
	 */
	public void setImage(String lienImage, Modele.Image imageRecu)
			throws IOException {
		System.out.println(lienImage);
		this.image = Modele.FabriqueImage.fabriqueImage(lienImage);

		if (imageRecu == null) {
			System.out.println("Je suis dans le null dans set Image");

		} else {
			System.out.println("Je suis dans le SINON dans set Image");
			this.image.setPerspective(imageRecu.getPerspective());

		}
		validate();
		this.image.getPerspective().addObserver(this);
		this.reactualiserPanneauImage();

	}

	/**
	 * public void setPerspective(Perspective perspective){
	 * this.image.setPerspective(perspective);
	 * this.image.getPerspective().addObserver(this); }
	 **/

	/**
	 * Methode qui permet de retourner la perspective de l'image a dessiner
	 * 
	 * @return Perspective
	 */
	public Modele.Perspective getPerspective() {
		return this.image.getPerspective();
	}

	/**
	 * Methode qui permet de savoir si le panneau Image dispose d'une image ou
	 * non
	 * 
	 * @return boolean true = image non vide false = image vide
	 */
	public boolean imageEstVide() {
		if (this.image.getBufferedImage() != null)
			return false;
		return true;
	}

	/**
	 * Methode qui permet de rafraichir ou reactualiser les parametres de
	 * l'image a afficher le panneauImage
	 */
	public void reactualiserPanneauImage() {
		x = image.getPerspective().getPositionX();
		y = image.getPerspective().getPositionY();
		hauteurDeLimage = ((int) (image.getPerspective().getHauteurImage() * (1 / (image
				.getPerspective().getZoom()))));
		largeurDeLimage = ((int) (image.getPerspective().getLargeurImage() * (1 / (image
				.getPerspective().getZoom()))));
		repaint();
	}

	/**
	 * Methode qui va permettre de mettre a jour le panneau image selon les
	 * variations de perspective cette methode est appeler par la classe
	 * Observable
	 */
	public void update() {
		reactualiserPanneauImage();
	}

	public Modele.Image getImage() {
		return this.image;
	}

}
