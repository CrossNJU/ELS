package org.cross.elsclient.ui.functionPanel;

import org.cross.elsclient.ui.component.ELSButton;
import org.cross.elsclient.ui.component.ELSPanel;
import org.cross.elsclient.ui.component.ELSFunctionPanel;
import org.cross.elsclient.ui.userUI.UserManagePanel;

public class AdminFunctionPanel extends ELSFunctionPanel{
	
	@Override
	public void init() {
		super.init();
		addFunctionBtn("用户管理", "userManagement");
		addFunctionBtn("不知道什么功能", "233333");
		
		addFunctionPanel(new UserManagePanel(),"manage", "userManagement");
		addFunctionPanel(new ELSPanel(), "noknow","233333");
		
		validate();
	}
}
