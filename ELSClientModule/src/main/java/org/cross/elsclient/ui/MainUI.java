package org.cross.elsclient.ui;

import java.awt.Font;
import java.util.Enumeration;

import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.plaf.FontUIResource;

import org.cross.elsclient.ui.adminui.AdminFunctionPanel;
import org.cross.elsclient.ui.component.ELSPanel;
import org.cross.elsclient.ui.component.ELSFunctionPanel;
import org.cross.elsclient.ui.util.FrameUtil;
import org.cross.elsclient.ui.util.UIConstant;

public class MainUI extends JFrame {

	public static void main(String[] args) {
		try {
			FontUIResource fontUIResource = new FontUIResource(new Font("YouYuan",
					Font.PLAIN, 15));
			for (Enumeration<Object> keys = UIManager.getDefaults().keys(); keys
					.hasMoreElements();) {
				Object key = keys.nextElement();
				Object value = UIManager.get(key);
				if (value instanceof FontUIResource) {
					UIManager.put(key, fontUIResource);
				}
			}
			UIManager
					.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedLookAndFeelException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		JFrame jf = new JFrame();
		ELSPanel mainPanel = new ELSPanel();
		jf.setSize(UIConstant.WINDOW_WIDTH, UIConstant.WINDOW_HEIGHT);
		FrameUtil.frameInit(jf);
//		jf.setEnabled(false);
		mainPanel.add(new LoginPanel(), "login");
		jf.getContentPane().add(mainPanel);

		jf.setVisible(true);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
