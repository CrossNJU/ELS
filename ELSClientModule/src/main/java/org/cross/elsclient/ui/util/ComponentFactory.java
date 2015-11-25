package org.cross.elsclient.ui.util;

import java.awt.Dimension;

import org.cross.elsclient.ui.component.ELSButton;
import org.cross.elsclient.ui.component.ELSPanel;

public class ComponentFactory {
	public static ELSPanel createNormalPanel(){
		return new ELSPanel();
	}
	
	public static ELSButton createFunctionBtn(){
		return new ELSButton();
	}
	
	public static ELSButton	createInfoBackBtn(){
		return new ELSButton();
	}
	
	public static ELSButton createConfirmBtn(){
		return new ELSButton();
	}
	
	public static ELSButton createCancelBtn(){
		return new ELSButton();
	}
	
	public static ELSButton createUpdateBtn(){
		ELSButton updateBtn = new ELSButton("改");
		updateBtn.setPreferredSize(new Dimension(30, 30));
		updateBtn.setMaximumSize(new Dimension(30, 30));
		updateBtn.setMinimumSize(new Dimension(30, 30));
		updateBtn.setName("update");
		return updateBtn;
	}
	
	public static ELSButton createDeleteBtn(){
		ELSButton deleteBtn = new ELSButton("删");
		deleteBtn.setPreferredSize(new Dimension(30, 30));
		deleteBtn.setMaximumSize(new Dimension(30, 30));
		deleteBtn.setMinimumSize(new Dimension(30, 30));
		deleteBtn.setName("delete");
		return deleteBtn;
	}
	
}
