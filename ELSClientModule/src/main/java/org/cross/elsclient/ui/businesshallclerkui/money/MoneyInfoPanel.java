package org.cross.elsclient.ui.businesshallclerkui.money;

import org.cross.elsclient.blservice.receiptblservice.ReceiptBLService;
import org.cross.elsclient.ui.component.ELSInfoPanel;
import org.cross.elsclient.vo.Receipt_MoneyInVO;

public class MoneyInfoPanel extends ELSInfoPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Receipt_MoneyInVO vo;
	public ReceiptBLService receiptbl;
	
	public MoneyInfoPanel(Receipt_MoneyInVO vo){
		this.vo = vo;
	}
	
	@Override
	public void init(){
		super.init();
		
		setTitle("收款单");
		addNormalItem("收款单编号", vo.number);
		addNormalItem("收款时间", vo.orderNumbers.get(0));
		addNormalItem("收款快递员", vo.person.name);
		addNormalItem("收款金额", String.valueOf(vo.money));
		
		container.packHeight();
	}

}
