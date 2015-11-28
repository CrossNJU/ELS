package org.cross.elsclient.ui.businesshallclerkui.trans;

import org.cross.elsclient.ui.component.ELSInfoPanel;
import org.cross.elsclient.vo.Receipt_TransVO;

public class TransInfoPanel extends ELSInfoPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Receipt_TransVO vo;
	
	public TransInfoPanel(Receipt_TransVO vo){
		this.vo = vo;
	}
	
	@Override
	public void init(){
		super.init();
		
		setTitle("创建装车单");
		addNormalItem("装车单编号", vo.number);
		addNormalItem("快递单编号", vo.orders.get(0));
		addNormalItem("出发地", vo.startCity.toString());
		addNormalItem("到达地", vo.arriveCity.toString());
		addNormalItem("装车时间", vo.time);
		addNormalItem("运输编号", vo.localNum);
		addNormalItem("车辆编号", vo.vehicleNum);
		addNormalItem("监装员", vo.observer.name);
		addNormalItem("押运员", vo.driver.name);
		addNormalItem("运费", String.valueOf(vo.cost));
		
		container.packHeight();
	}
}
