package org.cross.elsclient.ui.adminui;

import org.cross.elsclient.blservice.userblservice.UserBLService;
import org.cross.elsclient.blservice.userblservice.UserBLService_Stub;
import org.cross.elsclient.ui.component.ELSButton;
import org.cross.elsclient.ui.component.ELSPanel;
import org.cross.elsclient.ui.component.ELSFunctionPanel;

public class AdminFunctionPanel extends ELSFunctionPanel{
	public UserBLService userbl;
	
	public AdminFunctionPanel() {
		super();
		userbl = new UserBLService_Stub();
		init();
	}
	
	@Override
	public void init() {
		super.init();
		addFunctionBtn("用户管理", "userManagement");
		addFunctionBtn("不知道什么功能", "233333");
		
		addFunctionPanel(new UserManagePanel(userbl),"manage", "userManagement");
		addFunctionPanel(new ELSPanel(), "noknow","233333");
		
		validate();
	}
}
