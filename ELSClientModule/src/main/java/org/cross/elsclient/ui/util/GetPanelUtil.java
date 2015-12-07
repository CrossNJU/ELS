package org.cross.elsclient.ui.util;

import java.awt.Component;
import java.awt.Window;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import org.cross.elsclient.ui.component.ELSFunctionPanel;
import org.cross.elsclient.ui.component.ELSPanel;

public class GetPanelUtil {
	/**
	 * 返回主窗口
	 * @para c-任意一个组件
	 * @return JFrame
	 */
	public static JFrame getMainFrame(JComponent c){
		JFrame frame = (JFrame)SwingUtilities.getWindowAncestor(c);
		return frame;
	}
	/**
	 * 返回当前的功能选择界面
	 * @para c-该功能选择界面下的任意一个组建
	 * @return ELSFunctionPanel
	 */
	public static ELSFunctionPanel getFunctionPanel(JComponent c){
		ELSPanel mainPanel = (ELSPanel)getMainFrame(c).getContentPane().getComponent(0);
		ELSFunctionPanel functionPanel = (ELSFunctionPanel)mainPanel.getComponent(1);
		return functionPanel;
	}
	/**
	 * 返回一个功能界面
	 * @para c-该功能界面下的任意一个组件, functionIndex-功能界面序号（参考加入的顺序）
	 * @return ELSPanel
	 */
	public static ELSPanel getSubFunctionPanel(JComponent c,int functionIndex){
		ELSPanel mainPanel = (ELSPanel)getMainFrame(c).getContentPane().getComponent(0);
		ELSFunctionPanel functionPanel = (ELSFunctionPanel)mainPanel.getComponent(1);
		ELSPanel subFunctionPanel = (ELSPanel)((JPanel)functionPanel.getComponent(0)).getComponent(functionIndex);
//		System.out.println(subFunctionPanel);
		return subFunctionPanel;
	}
	
	public static ELSPanel getSubFunctionPanel(JComponent c,String funcName){
		ELSPanel mainPanel = (ELSPanel)getMainFrame(c).getContentPane().getComponent(0);
		ELSFunctionPanel functionPanel = (ELSFunctionPanel)mainPanel.getComponent(1);
		for (Component panel : ((JPanel)functionPanel.getComponent(0)).getComponents()) {
			if(panel.getName().equals(funcName)){
				return (ELSPanel)panel;
			}
		};
		return null;
	}
}
