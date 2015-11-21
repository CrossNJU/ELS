package org.cross.elsclient.ui.adminui;

import org.cross.elsclient.blservice.userblservice.UserBLService;
import org.cross.elsclient.ui.component.ELSInfoPanel;
import org.cross.elsclient.vo.UserVO;
import org.cross.elscommon.dataservice.datafactoryservice.DataFactoryService;

public class UserAddPanel extends ELSInfoPanel{
	UserVO vo;
	UserBLService bl;
	
	public UserAddPanel(UserBLService bl) {
		this.bl = bl;
		init();
	}
	
	@Override
	public void init() {
		super.init();
		vo = new UserVO("", "", null);
		
		setTitle("新增用户");
		addEditableItem("用户名", "U000001", false);
		addEditableItem("姓名","", true);
		addEditableItem("职位", "", true);
		
		addConfirmAndCancelBtn();
		confirmBtn.setText("确认添加");
		cancelBtn.setText("取消添加");
		
	}
	
	@Override
	protected void confirm() {
		super.confirm();
		bl.add(vo);
		back();
	}
	
	@Override
	protected void cancel() {
		super.cancel();
		back();
	}
}
