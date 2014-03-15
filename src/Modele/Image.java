/******************************************************
Cours:  LOG121
Projet: laboratoire 4
Nom du fichier: Image.java
Date créé: 2014-03-15

 *******************************************************
 *@author Alexis Vuillaume, David Murat, Idriss Aissou,
 *@date Hiver 2014
 *******************************************************/

package Modele;

import java.io.File;

import javax.swing.ImageIcon;




public class Image  {
	
	private byte image;
	
	private static final String CHEMIN_REP = System.getProperty("user.dir").replace("src", "");
	private Perspective perspective;
	private ImageIcon [] tabImage;
	
	public Image(){
		initTableauImage();
	}
	
	
	
	public void initTableauImage(){
			
			File f;
			String [] s;
			
			f = new File(CHEMIN_REP+"\\src\\"+"\\images\\");
			System.out.println(f);
			s = f.list(null);
			ImageIcon[] tabImage= new ImageIcon[s.length];
			for(int i = 0; i < s.length;i++){
				
				System.out.println(s[i]);
				tabImage[i] = new ImageIcon(CHEMIN_REP+"\\src\\"+"\\images\\"+s[i]);
				System.out.println(tabImage[i]);
		}
	}

	
}
