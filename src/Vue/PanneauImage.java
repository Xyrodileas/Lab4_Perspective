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

import Modele.Perspective;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class PanneauImage extends JPanel implements Modele.Observer {

	// ATTRIBUTS DU PANNEAU IMAGE
	private Modele.Image image;
	private BufferedImage imageAdessiner;
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
		if (imageAdessiner != null) {

			int largeurDuPanneau = getSize().width
					- (getInsets().left + getInsets().right);
			int hauteurDuPanneau = getSize().height
					- (getInsets().top + getInsets().bottom);

			graphic2d.drawImage(imageAdessiner, x, y, largeurDeLimage,
					hauteurDeLimage, this);
		} else {
			g.drawString("Choisir une Image...", 650, 350);
		}
	}

	/**
	 * Methode qui permet d'initialiser l'image au panneau
	 * 
	 * @param lienImage
	 * @throws IOException
	 */
	public void setImage(String lienImage) throws IOException {
			this.image = Modele.FabriqueImage.fabriqueImage(lienImage);

			imageAdessiner = this.image.getBufferedImage();
			image.getPerspective().addObserver(this);
			reactualiserPanneauImage();


	}

    public void setPerspective(Perspective perspective){
        this.image.setPerspective(perspective);
        this.image.getPerspective().addObserver(this);
    }

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
		if (imageAdessiner != null)
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
