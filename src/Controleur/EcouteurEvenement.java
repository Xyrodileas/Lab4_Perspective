package Controleur;

import Vue.PanneauImage;

import java.awt.event.*;

import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;

public class EcouteurEvenement implements MouseListener, MouseWheelListener,KeyListener,MouseMotionListener {

	//LES ATTRIBUT DE EcouteurEvenement
	private PanneauImage panneauImage;
    private int x, y;
    private static int xClick, yClick;
    private PopMenuClicDroit menu;
    public static boolean bouttonDroit;
    
    /**
     * Constructeur par defaut de Ecouteur Evenement
     * Il va permet de copier le panneauImage recu dans une variable
     * panneauIamge et aussi d'instancier un menu popup PopMenuClicDroit(panneauImage)
     * @param PanneauImage
     */
	public EcouteurEvenement(PanneauImage im) {

		panneauImage = im;
		menu = new PopMenuClicDroit(panneauImage);
	}
	
	
	//---------------------------------------------------PARTIE CLAVIER--------------------------------------------
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


	//---------------------------------------------------PARTIE SOURIS CLIC--------------------------------------------

	/**
	 * Methode qui permet de retenir la position du clic
	 * selon le bouton de la souris un evenement different se passe:
	 * Si clic gauche :
	 * 				On retient la position puis on deplacera la souris avec le drag
	 * Si clic droit :
	 * 				On affiche un menu popUp permettant de copier ou coller la perspective de l'image
	 */
	public void mousePressed(MouseEvent arg0) {
		if(arg0.getButton()==1){
				bouttonDroit=true;
			  	this.xClick = arg0.getX();
		        this.yClick = arg0.getY();
		}
			
		//CLIC CENTRAL
		else if (arg0.getButton()==2){
			bouttonDroit=false;
			
		}
		//CLIC DROIT
		else if (arg0.getButton()==3){
			bouttonDroit=false;
			if(panneauImage.imageEstVide())
			menu.declancheMenu(arg0.getComponent(),arg0.getX(),arg0.getY());
			
		}
	}



	//---------------------------------------------------PARTIE SOURIS MOUVEMENT--------------------------------------------
	/**
	 * Methode qui permet d'utiliser le SingletonCommande afin
	 * d'utiliser la commande zoom selon
	 * la rotation de la molette de la souris
	 * Soit zoom avant
	 * Soit zoom Arriere
	 */
	public void mouseWheelMoved(MouseWheelEvent arg0) {
		int[] tabParametres={0};
		
		//ZOOM AVANT
		if (arg0.getWheelRotation() < 0) {
			tabParametres[0] = 1;
		}
		//ZOOM ARRIERE
		else {
			tabParametres[0] = 0 ;
		}
		//APPEL DU SingletonCommande   ----> ZOOM
		SingletonCommande.execution(2, tabParametres, this.panneauImage);
	}

	
	/**
	 * Methode qui permet de
	 * d'utiliser le SingletonCommande afin 
	 * d'utiliser translation afin de déplacer
	 * l'image dans le panneau avec la souris
	 */
	public void mouseDragged(MouseEvent e) {
		if(bouttonDroit==true && panneauImage.imageEstVide()){
			int[] tabParametres = {e.getX() - this.xClick, e.getY() - this.yClick};
	
			//APPEL DU SingletonCommande   ----> Translation
			SingletonCommande.execution(1, tabParametres, this.panneauImage);
			this.xClick = e.getX();
			this.yClick = e.getY();
		}
	}

	//-----------------------------------------NON IMPLEMENTEES------------------------------------
	public void mouseMoved(MouseEvent e) {
	}
	public void mouseReleased(MouseEvent arg0) {
	}
	public void mouseClicked(MouseEvent arg0) {
	}
	public void mouseEntered(MouseEvent arg0) {
	}
	public void mouseExited(MouseEvent arg0) {
	}

}
