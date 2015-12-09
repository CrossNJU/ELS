package org.cross.elsclient.ui.counterui.initial;

import java.rmi.RemoteException;
import java.util.ArrayList;

import org.cross.elsclient.ui.component.ELSDialog;
import org.cross.elsclient.ui.component.ELSInfoPanel;
import org.cross.elsclient.ui.component.ELSStateBar;
import org.cross.elsclient.ui.util.GetPanelUtil;
import org.cross.elsclient.util.ConstantVal;
import org.cross.elsclient.vo.OrganizationVO;
import org.cross.elscommon.util.City;
import org.cross.elscommon.util.NumberType;
import org.cross.elscommon.util.OrganizationType;
import org.cross.elscommon.util.StringToType;

public class OrganAddPanel extends ELSInfoPanel{
	ArrayList<OrganizationVO> vos;
	OrganizationVO vo;
	
	public OrganAddPanel(ArrayList<OrganizationVO> vos) {
		super();
		this.vos = vos;
		init();
	}
	
	@Override
	public void init() {
		super.init();
		
		String citys[] = City.toStrings();
		String organs[] = OrganizationType.toStrings();
		
		setTitle("新增机构");
		addEditableItem("机构编号", ConstantVal.numberbl.getPostNumber(NumberType.ORGANIZATION),false);
		addComboxItem("地区", citys, true);
		addComboxItem("机构", organs, true);
	
		addConfirmAndCancelBtn();
		confirmBtn.setText("确认添加");
		cancelBtn.setText("取消添加");
		setBackPanel("add");
	}
	
	@Override
	protected void confirm() throws RemoteException {
		super.confirm();
		if(isAllLegal()){
			vo = new OrganizationVO(StringToType.toCity(itemLabels.get(1).toString()),
					StringToType.toOrg(itemLabels.get(2).toString()), itemLabels.get(0).toString());
			vos.add(vo);
			((InitialManagePanel)GetPanelUtil.getSubFunctionPanel(this, 3).getComponent(1)).refresh();
			ELSStateBar.showStateBar(GetPanelUtil.getFunctionPanel(this), "添加成功");
			back();
		}
	}
	
	@Override
	protected void cancel() {
		// TODO Auto-generated method stub
		super.cancel();
		if(ELSDialog.showConfirmDlg(GetPanelUtil.getFunctionPanel(this),
				"取消添加", "确认退出新增界面？")){
			
			back();
		}
	}
}
