package org.cross.elsclient.ui.counterui;

import org.cross.elsclient.blservice.receiptblservice.ReceiptBLService;
import org.cross.elsclient.ui.component.ELSFunctionPanel;
import org.cross.elsclient.ui.component.ELSManagePanel;

public class CounterFunctionPanel extends ELSFunctionPanel{
	ReceiptBLService receiptbl;
	
	public CounterFunctionPanel() {
		
		init();
	}
	
	@Override
	public void init() {
		// TODO Auto-generated method stub
		super.init();
		
		addFunctionBtn("成本管理", "cost");
		addFunctionBtn("结算管理", "settle");
		addFunctionBtn("账户管理", "accout");
		addFunctionBtn("期初建账", "initial");
		addFunctionBtn("统计分析", "analysis");
		addFunctionBtn("系统日志", "log");
		
		addFunctionPanel(new ELSManagePanel(),"add", "cost");
		addFunctionPanel(new ELSManagePanel(),"add", "settle");
		addFunctionPanel(new ELSManagePanel(),"add", "accout");
		addFunctionPanel(new ELSManagePanel(),"add", "initial");
		addFunctionPanel(new ELSManagePanel(),"add", "analysis");
		addFunctionPanel(new ELSManagePanel(),"add", "log");
		
		validate();
		
	}
	
}
