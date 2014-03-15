package Vue;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class EcouteurDeSouris implements MouseListener {
	
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

}
