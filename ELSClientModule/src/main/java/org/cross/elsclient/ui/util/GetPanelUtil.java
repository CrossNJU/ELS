package org.cross.elsclient.ui.util;

import java.awt.Window;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import org.cross.elsclient.ui.component.ELSFunctionPanel;
import org.cross.elsclient.ui.component.ELSPanel;

public class GetPanelUtil {
	public static JFrame getMainFrame(JComponent c){
		JFrame frame = (JFrame)SwingUtilities.getWindowAncestor(c);
		return frame;
	}
	public static ELSFunctionPanel getFunctionPanel(JComponent c){
		ELSPanel mainPanel = (ELSPanel)getMainFrame(c).getContentPane().getComponent(0);
		ELSFunctionPanel functionPanel = (ELSFunctionPanel)mainPanel.getComponent(1);
		return functionPanel;
	}
}
