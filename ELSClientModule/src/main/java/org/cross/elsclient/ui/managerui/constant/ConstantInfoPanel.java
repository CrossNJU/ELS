package org.cross.elsclient.ui.managerui.constant;

import java.awt.Font;
import java.rmi.RemoteException;

import javax.swing.JLabel;

import org.cross.elsclient.blservice.constantblservice.ConstantBLService;
import org.cross.elsclient.ui.component.ELSInfoPanel;
import org.cross.elsclient.ui.component.ELSPanel;
import org.cross.elsclient.ui.util.ConstantValue;
import org.cross.elsclient.vo.ConstantVO;

public class ConstantInfoPanel extends ELSInfoPanel{
	ConstantBLService constantbl;
	ConstantVO vo;
	
	//城市间距离
	public ConstantInfoPanel(ConstantBLService constantbl) {
		this.constantbl = constantbl;
		vo = constantbl.show();
		init();
	}
	
	@Override
	public void init() {
		super.init();
		setTitle("业务常量");
		addNormalItem("城市距离", "");
		itemLabels.get(0).nameLabel.setFont(itemLabels.get(0).nameLabel.getFont().deriveFont(Font.BOLD));
		addNormalItem("北京-上海", vo.distance_Beijing_Shanghai+"km");
		addNormalItem("北京-南京", vo.distance_Beijing_Nanjing+"km");
		addNormalItem("北京-广州", vo.distance_Beijing_Guangzhou+"km");
		addNormalItem("南京-广州", vo.distance_Nanjing_Guangzhou+"km");
		addNormalItem("南京-上海", vo.distance_Nanjing_Shanghai+"km");
		addNormalItem("广州-上海", vo.distance_Shanghai_Guangzhou+"km");
//		addNormalItem("", "");
//		addNormalItem("底薪    ","" );
//		
//		itemLabels.get(8).nameLabel.setFont(itemLabels.get(8).nameLabel.getFont().deriveFont(Font.BOLD));
//		addNormalItem("快递员", vo.baseMoneyForCOURIER+"元/月");
//		addNormalItem("营业厅业务员", vo.baseMoneyForBUSINESSHALLCLERK+"元/月");
//		addNormalItem("中转中心业务员", vo.baseMoneyForTRANSITCENTERCLERK+"元/月");
//		addNormalItem("仓库管理员", vo.baseMoneyForSTOCKKEEPER+"元/月");
//		addNormalItem("财务人员", vo.baseMoneyForCOUNTER+"元/月");
//		addNormalItem("总经理", vo.baseMoneyForMANAGER+"元/月");
//		addNormalItem("系统管理员", vo.baseMoneyForADMINISTRATOR+"元/月");
		
		addNormalItem("", "");
		addNormalItem("价格", vo.price+"元/(kilo*kg)");
		addNormalItem("预估每公里所花时间", vo.timeBykilo+"hour/km");
		
		addConfirmAndCancelBtn();
		titlePanel.remove(titlePanel.backBtn);
		confirmBtn.setText("修改常量");
		cancelBtn.setVisible(false);
		
		container.packHeight();
	}
	
	@Override
	protected void confirm() throws RemoteException {
		super.confirm();
		ConstantUpdatePanel updatePanel = new ConstantUpdatePanel(constantbl);
		ELSPanel parent = (ELSPanel) getParent();
		parent.add("update",updatePanel);
		parent.cl.show(parent, "update");
	}
}
