package org.cross.elsclient.ui.businesshallclerkui.deliver;

import org.cross.elsclient.blservice.receiptblservice.ReceiptBLService;
import org.cross.elsclient.ui.component.ELSInfoPanel;
import org.cross.elsclient.vo.Receipt_TransVO;

public class DeliverInfoPanel extends ELSInfoPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Receipt_TransVO vo;
	public ReceiptBLService receiptbl;
	
	public DeliverInfoPanel(Receipt_TransVO vo){
		this.vo = vo;
	}
	
	@Override
	public void init(){
		super.init();
		
		setTitle("创建派件单");
		addNormalItem("派件单编号", vo.number);
		addNormalItem("快件单编号", vo.orders.get(0));
		addNormalItem("快递员", vo.driver.name);
		
		container.packHeight();
	}

}
