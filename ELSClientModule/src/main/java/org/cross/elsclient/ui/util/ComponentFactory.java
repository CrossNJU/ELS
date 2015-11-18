package org.cross.elsclient.ui.util;

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
}
