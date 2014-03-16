package Vue;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;

public class EcouteurDeSouris implements MouseListener,MouseWheelListener {
	
	private FenetrePrincipale fenetrePrincipale;
	
	public EcouteurDeSouris(FenetrePrincipale fenetre){
		fenetrePrincipale = fenetre;
		
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
		
		}
		else {
			
			System.out.println("Zoom Arrière");
		}
		
	}

}
