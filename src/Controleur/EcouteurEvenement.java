package Controleur;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;

import Vue.FenetrePrincipale;
import Vue.PanneauImage;

public class EcouteurEvenement implements MouseListener,MouseWheelListener, KeyListener {
	
	private PanneauImage panneauImage;
	
	public EcouteurEvenement( PanneauImage im){
		
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
	  private void pause(){
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
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		System.out.println("Souris pression relache");

		
	}

	@Override
	public void mouseWheelMoved(MouseWheelEvent arg0) {
		if (arg0.getWheelRotation()<0){
            System.out.println("Zoom avant");
            panneauImage.testIncrementerZoom();
            panneauImage.rafraichirPanneauImage();
		}
		else {
			
			System.out.println("Zoom Arri�re");
			panneauImage.testDecrementerZoom();
			panneauImage.rafraichirPanneauImage();
		}
		
	}
	
}
