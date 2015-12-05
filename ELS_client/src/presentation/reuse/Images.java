package presentation.reuse;

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
	public static final ImageIcon MAIN_FRAME_BACKGROUND = createImageIcon("images/101_编辑.jpg");				
	
	public static final Image LOGIN_BACKGROUND = createImage(
			 "images/6238460_182600301162_2_副本_副本.jpg");

	public static final ImageIcon USER_IMAGE=createImageIcon("images/user.png");
	
	public static final ImageIcon USERLOGO_IMAGE=createImageIcon("images/userlogo.png");
	
	public static final ImageIcon PASSWORD_IMAGE=createImageIcon("images/password.png");
	
	public static final ImageIcon MINIMIZE_IMAGE=createImageIcon("images/minimize (2).png");
	
	public static final ImageIcon CLOSE_IMAGE=createImageIcon("images/close (2).png");
	
	public static final ImageIcon ADD_IMAGE=createImageIcon("images/add.png");
	
	public static final ImageIcon DELETE_IMAGE=createImageIcon("images/delete.png");
	
	public static final ImageIcon MODIFY_IMAGE=createImageIcon("images/modify.png");
	
	public static final ImageIcon SHEET_IMAGE=createImageIcon("images/sheet.png");
	
	public static final ImageIcon REVIEW_IMAGE=createImageIcon("images/review.png");
	
	public static final ImageIcon BELL_IMAGE=createImageIcon("images/bell.png");
	
	public static final ImageIcon LOGISTICS_IMAGE=createImageIcon("images/logistics.png");
}
