package org.cross.elsclient.ui.userUI;

import org.cross.elsclient.blservice.userblservice.UserBLService;
import org.cross.elsclient.ui.component.ELSButton;
import org.cross.elsclient.ui.component.ELSInfoPanel;
import org.cross.elsclient.ui.util.ComponentFactory;
import org.cross.elsclient.vo.UserVO;

public class UserUpdatePanel extends ELSInfoPanel{
	UserVO vo;
	UserBLService bl;
	
	public UserUpdatePanel(UserVO vo, UserBLService bl) {
		this.vo = vo;
		this.bl = bl;
		init();
	}
	
	@Override
	public void init() {
		super.init();
		
		setTitle("修改用户");
		addEditableItem("用户名", "U000002", false);
		addEditableItem("姓名", vo.name, true);
		addEditableItem("职位", vo.type.toString(), true);
		
		addConfirmAndCancelBtn();
		confirmBtn.setText("确认修改");
		cancelBtn.setText("取消修改");
		
	}
	
	@Override
	protected void confirm() {
		super.confirm();
		bl.update(vo);
		back();
	}
	
	@Override
	protected void cancel() {
		super.cancel();
	}
}
