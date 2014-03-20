package Vue;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;

public class EcouteurDeSouris implements MouseListener,MouseWheelListener {
	
	private FenetrePrincipale fenetrePrincipale;
	private PanneauImage panneauImage;
	
	public EcouteurDeSouris(FenetrePrincipale fenetre, PanneauImage im){
		fenetrePrincipale = fenetre;
		panneauImage = im;
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
            panneauImage.testIncrémenterZoom();
            panneauImage.rafraichirPanneauImage();
		}
		else {
			
			System.out.println("Zoom Arrière");
			panneauImage.testDecrémenterZoom();
			panneauImage.rafraichirPanneauImage();
		}
		
	}

}
