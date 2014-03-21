package Vue;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class EcouteurClavier implements KeyListener {
	
	private FenetrePrincipale fenetrePrincipale;
	private PanneauImage panneauImage;
	
	public EcouteurClavier(FenetrePrincipale fenetre, PanneauImage im){
		fenetrePrincipale = fenetre;
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

}
