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
		System.out.println(" Souris clic");
		
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		System.out.println(" Souris entrer");
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		System.out.println(" Souris mouseExited");
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		System.out.println(" Souris mousePressed");
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		System.out.println(" Souris mouseReleased");

		
	}

}
