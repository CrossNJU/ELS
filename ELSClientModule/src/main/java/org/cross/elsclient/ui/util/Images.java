package org.cross.elsclient.ui.util;

import java.awt.Image;
import java.io.FileInputStream;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

public class Images {
	public static ImageIcon createImageIcon(String path){
		ImageIcon icon = new ImageIcon(path);
		return icon;
	}

	public static Image createImage(String path) {
		try {
			Image image = ImageIO.read(new FileInputStream(path));
			return image;
		} catch (Exception exception) {
			exception.printStackTrace();
		}
		return null;
	}
	
	public final static ImageIcon BACK_IMAGEICON = createImageIcon("img/icons/Common/Icon Back.png");
	public final static ImageIcon UPDATE_IMAGEICON = createImageIcon("img/icons/Common/Icon Edit.png");
	public final static ImageIcon DELETE_IMAGEICON = createImageIcon("img/icons/Common/Icon Delete.png");
	public final static ImageIcon CORRECT_IMAGEICON = createImageIcon("img/icons/Common/Icon Correct.png");
	public final static ImageIcon WARNING_IMAGEICON = createImageIcon("img/icons/Common/Icon Warning.png");
	public final static ImageIcon LOGO_IMAGEICON = createImageIcon("img/Logo.png");
	public final static ImageIcon EXIT_IMAGEICON = createImageIcon("img/icons/Common/Icon Close.png");
	public final static ImageIcon ADD_IMAGEICON = createImageIcon("img/icons/Common/Icon Add.png");
	
	public static ImageIcon getImageIcon(String name){
		switch (name) {
		case "back":
			return BACK_IMAGEICON;
		case "update":
			return UPDATE_IMAGEICON;
		case "delete":
			return DELETE_IMAGEICON;
			
		default:
			return null;
		}
	}
	
}
