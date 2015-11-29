package org.cross.elsclient.ui.businesshallclerkui;

import org.cross.elsclient.blservice.personnelblservice.PersonnelBLService;
import org.cross.elsclient.blservice.receiptblservice.ReceiptBLService;
import org.cross.elsclient.blservice.receiptblservice.ReceiptBLService_Stub;
import org.cross.elsclient.blservice.vehicleblservice.VehicleBLService;
import org.cross.elsclient.blservice.vehicleblservice.VehicleBLService_Stub;
import org.cross.elsclient.ui.businesshallclerkui.arri.ArriAddPanel;
import org.cross.elsclient.ui.businesshallclerkui.deliver.DeliverAddPanel;
import org.cross.elsclient.ui.businesshallclerkui.driver.DriverManagePanel;
import org.cross.elsclient.ui.businesshallclerkui.money.MoneyAddPanel;
import org.cross.elsclient.ui.businesshallclerkui.trans.TransAddPanel;
import org.cross.elsclient.ui.businesshallclerkui.vehicle.VehicleManagePanel;
import org.cross.elsclient.ui.component.ELSFunctionPanel;
import org.cross.elsclient.ui.component.ELSPanel;

public class BusinessFunctionPanel extends ELSFunctionPanel{
	public ReceiptBLService receiptbl;
	public VehicleBLService vehiclebl;
	public PersonnelBLService personnelbl;
	
	public BusinessFunctionPanel() {
		super();
		receiptbl = new ReceiptBLService_Stub();
		vehiclebl = new VehicleBLService_Stub();
		init();
	}
	@Override
	public void init() {
		super.init();
		addFunctionBtn("到达单", "arrive");
		addFunctionBtn("装车单", "trans");
		addFunctionBtn("收款单", "moneyin");
		addFunctionBtn("派件单", "send");
		addFunctionBtn("车辆管理", "vehicle");
		addFunctionBtn("司机管理", "driver");
		addFunctionBtn("单据管理", "receipts");
		
		addFunctionPanel(new ArriAddPanel(receiptbl), "manage","arrive");
		addFunctionPanel(new TransAddPanel(receiptbl), "manage","trans");
		addFunctionPanel(new MoneyAddPanel(receiptbl), "manage","moneyin");
		addFunctionPanel(new DeliverAddPanel(receiptbl), "manage","send");
		addFunctionPanel(new VehicleManagePanel(vehiclebl), "manage","vehicle");
		addFunctionPanel(new DriverManagePanel(personnelbl), "manage","driver");
		
		addFunctionPanel(new ReceiptManagePanel(receiptbl), "manage", "receipts");
	}
}
