package Controleur;

public class Translation extends Commande{

	int x, y;

    public Translation(int xModifie, int yModifie) {

        x = xModifie;
        y = yModifie;
    }

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}


    public void execution(){

    }


}
