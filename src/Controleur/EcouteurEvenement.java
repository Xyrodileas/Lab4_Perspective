package Controleur;

import Vue.PanneauImage;

import java.awt.event.*;

public class EcouteurEvenement implements MouseListener, MouseWheelListener,
		KeyListener,MouseMotionListener {

	private PanneauImage panneauImage;

    private int x, y;
	public EcouteurEvenement(PanneauImage im) {

		panneauImage = im;
	}

	@Override
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub
		System.out.println(arg0.getSource());
		System.out.println(arg0.getExtendedKeyCode());
		System.out.println(arg0.getID());
		pause();
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		System.out.println("Bonjour");
		pause();
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		System.out.println("Bonjour");
		pause();
	}

	private void pause() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		System.out.println(" Souris a clique");
        this.x = arg0.getX();
        this.y = arg0.getY();
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		System.out.println(" Souris entrer dans notre panneau Image");


	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		System.out.println(" Souris qui bouge");

	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		System.out.println(" Souris pression");

	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		System.out.println("Souris pression relache");

	}

	@Override
	public void mouseWheelMoved(MouseWheelEvent arg0) {
		if (arg0.getWheelRotation() < 0) {
			System.out.println("Zoom avant");
			// panneauImage.testIncrementerZoom();
			panneauImage.rafraichirPanneauImage();
		} else {

			System.out.println("Zoom Arri�re");
			// panneauImage.testDecrementerZoom();
			panneauImage.rafraichirPanneauImage();
		}

	}

	@Override
	public void mouseDragged(MouseEvent e) {
		
		System.out.println("Deplacement de la souris");
		
		int[] tabParametres = {e.getLocationOnScreen().x - this.x, e.getLocationOnScreen().y - this.y};
		
		// int xModifie = e.getX();
		// int yModifier = e.getY();





		// setLocation(e.getLocationOnScreen().x - dX, e.getLocationOnScreen().y
		// - dY);
		//
		//
		// dX = e.getLocationOnScreen().x - this.getX();
		// dY = e.getLocationOnScreen().y - this.getY();

		SingletonCommande.execution(1,tabParametres );
	}

	@Override
	public void mouseMoved(MouseEvent e) {
	}

}
