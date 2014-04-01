package Controleur;

import Modele.Image;
import Vue.PanneauImage;

import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * Created by Alexis on 01/04/14.
 */
public class Dessiner extends Commande {

    int x, y;
    public Dessiner(int x, int y){
        this.x = x;
        this.y = y;
    }
    @Override
    public void execution(PanneauImage image) {
        image.getImage().editPixel(this.x, this.y);
    }

    @Override
    public Image execution() throws FileNotFoundException, IOException {
        return null;
    }
}
