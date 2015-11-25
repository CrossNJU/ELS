package org.cross.elsclient.ui.managerui;

import org.cross.elsclient.blservice.accountblservice.AccountBLService;
import org.cross.elsclient.blservice.analysisblservice.AnalysisBLService;
import org.cross.elsclient.blservice.constantblservice.ConstantBLService;
import org.cross.elsclient.blservice.constantblservice.ConstantBLService_Stub;
import org.cross.elsclient.blservice.logblservice.LogBLService;
import org.cross.elsclient.blservice.logblservice.LogBLService_Stub;
import org.cross.elsclient.blservice.organizationblservice.OrganizationBLService;
import org.cross.elsclient.blservice.personnelblservice.PersonnelBLService;
import org.cross.elsclient.blservice.receiptblservice.ReceiptBLService;
import org.cross.elsclient.blservice.receiptblservice.ReceiptBLService_Stub;
import org.cross.elsclient.blservice.userblservice.UserBLService;
import org.cross.elsclient.ui.adminui.UserManagePanel;
import org.cross.elsclient.ui.component.ELSFunctionPanel;
import org.cross.elsclient.ui.component.ELSManagePanel;
import org.cross.elsclient.ui.component.ELSPanel;

public class ManagerFunctionPanel extends ELSFunctionPanel{
	public OrganizationBLService organizationbl;
	public ReceiptBLService receiptbl;
	public PersonnelBLService personelbl;
	public AccountBLService accoutbl;
	public AnalysisBLService analysisbl;
	public ConstantBLService constantbl;
	public LogBLService logbl;
	
	
	@Override
	public void init() {
		super.init();
		
//		organizationbl = new OrganizationBlservice_Stub();
		receiptbl = new ReceiptBLService_Stub();
//		accoutbl = new AccountBLService_Stub();
//		analysisbl = new AnalysisBLService_Stub();
		constantbl = new ConstantBLService_Stub();
		logbl = new LogBLService_Stub();
		
		
		addFunctionBtn("单据审批", "receiptApproval");
		addFunctionBtn("机构管理", "organization");
		addFunctionBtn("人员管理", "personnel");
		addFunctionBtn("工资管理", "paymentManage");
		addFunctionBtn("账户查看", "accoutCheck");
		addFunctionBtn("统计分析", "analysis");
		addFunctionBtn("业务常量", "constant");
		addFunctionBtn("系统日志", "log");
		
		addFunctionPanel(new ELSManagePanel(),"manange", "receiptApproval");
		addFunctionPanel(new ELSManagePanel(),"manange", "organization");
		addFunctionPanel(new ELSManagePanel(),"manange", "personnelManage");
		addFunctionPanel(new ELSManagePanel(),"manange", "paymentManage");
		addFunctionPanel(new ELSManagePanel(),"manange", "accoutCheck");
		addFunctionPanel(new ELSManagePanel(),"manange", "analysis");
		addFunctionPanel(new ELSManagePanel(),"manange", "constant");
		addFunctionPanel(new ELSManagePanel(),"manange", "log");
		
		
		validate();
	}
}
