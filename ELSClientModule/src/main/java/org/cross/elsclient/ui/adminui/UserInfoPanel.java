package org.cross.elsclient.ui.adminui;

import org.cross.elsclient.ui.component.ELSInfoPanel;
import org.cross.elsclient.vo.UserVO;

public class UserInfoPanel extends ELSInfoPanel {
	UserVO vo;
	
	public UserInfoPanel(UserVO vo) {
		this.vo = vo;
		init();
	}
	
	@Override
	public void init() {
		super.init();
		
		setTitle("用户信息");
		addNormalItem("用户名", vo.id);
		addNormalItem("姓名", vo.name);
		addNormalItem("职位", vo.type.toString());
		addNormalItem("密码", vo.password);

		container.packHeight();
	}
	
}
