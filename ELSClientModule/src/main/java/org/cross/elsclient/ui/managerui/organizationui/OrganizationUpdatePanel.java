package org.cross.elsclient.ui.managerui.organizationui;

import java.rmi.RemoteException;

import org.cross.elsclient.blservice.organizationblservice.OrganizationBLService;
import org.cross.elsclient.ui.component.ELSDialog;
import org.cross.elsclient.ui.component.ELSInfoPanel;
import org.cross.elsclient.ui.component.ELSStateBar;
import org.cross.elsclient.ui.util.GetPanelUtil;
import org.cross.elsclient.ui.util.LogUtil;
import org.cross.elsclient.vo.OrganizationVO;
import org.cross.elscommon.util.InfoType;
import org.cross.elscommon.util.ResultMessage;
import org.cross.elscommon.util.StringToType;

public class OrganizationUpdatePanel extends ELSInfoPanel{
	OrganizationVO vo;
	OrganizationBLService bl;
	
	public OrganizationUpdatePanel(OrganizationVO vo,OrganizationBLService bl){
		this.bl = bl;
		this.vo = vo;
		init();
	}
	
	@Override
	public void init() {
		// TODO Auto-generated method stub
		super.init();
		
		String[] types = {"营业厅","中转中心", "总部"};
		String[] area = {"北京","上海", "南京","广州"};
		
		setTitle("机构详细信息");
		addEditableItem("机构编号", vo.number,false);
		addComboxItem("机构地区", area,vo.city.toString() ,true);
		addComboxItem("机构类型", types,vo.type.toString(),true);
		
		addConfirmAndCancelBtn();
		confirmBtn.setText("确认更改");
		cancelBtn.setText("放弃更改");
	}
	
	@Override
	protected void confirm() {
		if(isAllLegal()){
			vo = new OrganizationVO(StringToType.toCity(itemLabels.get(1).toString()),
					StringToType.toOrg(itemLabels.get(2).toString()), itemLabels.get(0).toString());
			try {
				if(bl.update(vo)==ResultMessage.SUCCESS){
					LogUtil.addLog("更新机构");
					ELSStateBar.showStateBar(GetPanelUtil.getFunctionPanel(this),"更改成功");
					back();
				}else{
					ELSStateBar.showStateBar(GetPanelUtil.getFunctionPanel(this),"更改失败");
				}
			} catch (RemoteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	@Override
	protected void cancel() {
		if(ELSDialog.showConfirmDlg(GetPanelUtil.getFunctionPanel(this), "取消", "确认退出修改界面？")){
			back();
		}
	}
}
