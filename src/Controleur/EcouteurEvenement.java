package Controleur;

import Vue.PanneauImage;

import java.awt.event.*;

public class EcouteurEvenement implements MouseListener, MouseWheelListener,
		KeyListener,MouseMotionListener {

	private PanneauImage panneauImage;


    private int x, y;
    private static int xClick, yClick;
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
        this.xClick = arg0.getX();
        System.out.println("Voici le X retenu par la souris "+this.xClick);
        this.yClick = arg0.getY();
        System.out.println("Voici le Y retenu par la souris "+this.yClick);
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		System.out.println("Souris pression relache");

	}

	@Override
	public void mouseWheelMoved(MouseWheelEvent arg0) {
		int[] tabParametres={0};
		if (arg0.getWheelRotation() < 0) {
			System.out.println("Zoom avant");
			
			
			panneauImage.rafraichirPanneauImage();
			tabParametres[0] = 1;
		} else {

			System.out.println("Zoom Arri�re");

		
			panneauImage.rafraichirPanneauImage();
			tabParametres[0] = 0 ;
		}
		

		SingletonCommande.execution(2, tabParametres, this.panneauImage);
		panneauImage.rafraichirPanneauImage();
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		
		System.out.println("Deplacement de la souris");
		int[] tabParametres = {e.getX() - this.xClick, e.getY() - this.yClick};
        System.out.println("x : "+ tabParametres[0] + " \ny : "+ tabParametres[1]);
        SingletonCommande.execution(1, tabParametres, this.panneauImage);
       panneauImage.rafraichirPanneauImage();
        this.xClick = e.getX();
        this.yClick = e.getY();

		

	}

	
	public void mouseMoved(MouseEvent e) {
	}

}
