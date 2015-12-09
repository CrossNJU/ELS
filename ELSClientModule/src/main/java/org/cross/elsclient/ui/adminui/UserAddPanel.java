package org.cross.elsclient.ui.adminui;

import java.rmi.RemoteException;

import org.cross.elsclient.blservice.userblservice.UserBLService;
import org.cross.elsclient.ui.component.ELSDatePicker;
import org.cross.elsclient.ui.component.ELSDialog;
import org.cross.elsclient.ui.component.ELSInfoPanel;
import org.cross.elsclient.ui.component.ELSStateBar;
import org.cross.elsclient.ui.util.GetPanelUtil;
import org.cross.elsclient.util.ConstantVal;
import org.cross.elsclient.vo.UserVO;
import org.cross.elscommon.dataservice.datafactoryservice.DataFactoryService;
import org.cross.elscommon.util.InfoType;
import org.cross.elscommon.util.NumberType;
import org.cross.elscommon.util.ResultMessage;
import org.cross.elscommon.util.StringToType;

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
//		vo = new UserVO("", "", null);
		
		//ELSInfoPanel提供了三种添加条目的类型:文字，编辑框，下拉框
		//要拿到其中的信息，要调用对应的itemLabel.toString()的方法
		setTitle("新增用户");
		addEditableItem("用户名", ConstantVal.getNumber().getPostNumber(NumberType.USER), false);
		addEditableItem("姓名","", true,InfoType.NAME);
		String items[] = {"快递员", "营业厅业务员","中转中心业务员","仓库管理人员","财务人员","高级财务人员","总经理","系统管理员"};
		addComboxItem("职位", items, true);
		addEditableItem("密码", "", true,InfoType.PASSWORD);
		addEditableItem("所属机构", "", true,InfoType.NAME);
		
		addConfirmAndCancelBtn();
		confirmBtn.setText("确认添加");
		cancelBtn.setText("取消添加");
		
	}
	
	@Override
	protected void confirm() throws RemoteException {
		if(isAllLegal()){
			vo = new UserVO(itemLabels.get(0).toString(), itemLabels.get(3).toString(),itemLabels.get(1).toString(), 
					StringToType.toUserType(itemLabels.get(2).toString()),itemLabels.get(4).toString());
			if(bl.add(vo)==ResultMessage.SUCCESS){
				ELSStateBar.showStateBar(GetPanelUtil.getFunctionPanel(this),"添加成功");
				back();
			}else{
				ELSStateBar.showStateBar(GetPanelUtil.getFunctionPanel(this),"添加失败");
			}
		}
	}
	
	@Override
	protected void cancel() {
		if(ELSDialog.showConfirmDlg(GetPanelUtil.getFunctionPanel(this), "取消新增", "确认退出新增界面？")){
			back();
		}
	}
}
