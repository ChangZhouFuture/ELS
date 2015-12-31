package RMI;

import java.awt.Image;
import java.io.FileInputStream;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

public class Images {
	protected static ImageIcon createImageIcon(String path){
		ImageIcon icon = new ImageIcon(path);
		return icon;
	}

	protected static Image createImage(String path) {
		try {
			Image image = ImageIO.read(new FileInputStream(path));
			return image;
		} catch (Exception exception) {
			exception.printStackTrace();
		}
		return null;
	}
	public static final Image LOGIN_BACKGROUND = createImage(
			 "images/90h58PICgpP_¸±±¾.jpg");
	public static final ImageIcon MINIMIZE_IMAGE=createImageIcon("images/minimize.png");
}
