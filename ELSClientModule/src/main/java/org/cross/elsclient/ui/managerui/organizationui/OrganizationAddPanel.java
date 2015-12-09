package org.cross.elsclient.ui.managerui.organizationui;

import java.rmi.RemoteException;

import org.cross.elsclient.blservice.organizationblservice.OrganizationBLService;
import org.cross.elsclient.ui.component.ELSDialog;
import org.cross.elsclient.ui.component.ELSInfoPanel;
import org.cross.elsclient.ui.component.ELSStateBar;
import org.cross.elsclient.ui.util.GetPanelUtil;
import org.cross.elsclient.util.ConstantVal;
import org.cross.elsclient.vo.OrganizationVO;
import org.cross.elscommon.util.InfoType;
import org.cross.elscommon.util.NumberType;
import org.cross.elscommon.util.ResultMessage;
import org.cross.elscommon.util.StringToType;

public class OrganizationAddPanel extends ELSInfoPanel{
	OrganizationVO vo;
	OrganizationBLService bl;
	
	public OrganizationAddPanel(OrganizationBLService bl){
		this.bl = bl;
		init();
	}
	
	@Override
	public void init() {
		// TODO Auto-generated method stub
		super.init();
		
		String[] types = {"营业厅","中转中心", "总部"};
		String[] area = {"北京","上海", "南京","广州"};
		
		setTitle("机构详细信息");
		addEditableItem("机构编号", ConstantVal.numberbl.getPostNumber(NumberType.ORGANIZATION),true,InfoType.NUM);
		addComboxItem("机构地区", area, true);
		addComboxItem("机构类型", types,true);
		
		addConfirmAndCancelBtn();
		confirmBtn.setText("确认添加");
		cancelBtn.setText("取消添加");
	}
	
	@Override
	protected void confirm() {
		if(isAllLegal()){
			vo = new OrganizationVO(StringToType.toCity(itemLabels.get(1).toString()),
					StringToType.toOrg(itemLabels.get(2).toString()), itemLabels.get(0).toString());
			try {
				if(bl.add(vo)==ResultMessage.SUCCESS){
					ELSStateBar.showStateBar(GetPanelUtil.getFunctionPanel(this),"添加成功");
					back();
				}else{
					ELSStateBar.showStateBar(GetPanelUtil.getFunctionPanel(this),"添加失败");
				}
			} catch (RemoteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
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
