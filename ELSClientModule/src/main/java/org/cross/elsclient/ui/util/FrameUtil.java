package org.cross.elsclient.ui.util;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.Window;

import javax.swing.JDialog;
import javax.swing.JFrame;

public class FrameUtil {

	public static void frameInit(JFrame frame){
		Toolkit kit2 = Toolkit.getDefaultToolkit(); // 定义工具包 
		Dimension screenSize = kit2.getScreenSize(); // 获取屏幕的尺寸 
		
		frame.setUndecorated(true);
		int screenWidth = screenSize.width/2; // 获取屏幕的宽
		int screenHeight = screenSize.height/2; // 获取屏幕的高
		int height = frame.getHeight(); 
		int width = frame.getWidth(); 
		frame.setLocation(screenWidth-width/2, screenHeight-height/2);
	}
	
	public static void frameInit(JDialog frame){
		Toolkit kit2 = Toolkit.getDefaultToolkit(); // 定义工具包 
		Dimension screenSize = kit2.getScreenSize(); // 获取屏幕的尺寸 
		
//		kit2. 
		frame.setUndecorated(true);
		int screenWidth = screenSize.width/2; // 获取屏幕的宽
		int screenHeight = screenSize.height/2; // 获取屏幕的高
		int height = frame.getHeight(); 
		int width = frame.getWidth(); 
		frame.setLocation(screenWidth-width/2, screenHeight-height/2);
		
	}
}
