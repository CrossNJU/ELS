package org.cross.elsclient.blimpl.numberblimpl;

import java.rmi.RemoteException;

import org.cross.elsclient.blservice.numberblservice.NumberBLService;
import org.cross.elscommon.dataservice.numberdataservice.NumberDataService;
import org.cross.elscommon.po.NumberPO;
import org.cross.elscommon.util.NumberType;
import org.cross.elscommon.util.ResultMessage;

public class NumberBLImpl implements NumberBLService{
	
	NumberDataService numberdata;
	NumberPO numberpo;
	String returnS;
	
	public NumberBLImpl(NumberDataService numberdata){
		this.numberdata = numberdata;
	}

	@Override
	public String getPostNumber(NumberType type) {
		try {
			numberpo = numberdata.show();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		switch (type) {
		case USER:
			returnS = "U"+numberpo.getUserNum();
			numberpo.setUserNum(addOne(returnS));
			break;
		case ORGANIZATION:
			returnS = "O"+numberpo.getOrgNum();
			numberpo.setOrgNum(addOne(returnS));
			break;
		case PERSONNEL:
			returnS = "P"+numberpo.getPerNum();
			numberpo.setPerNum(addOne(returnS));
			break;
		case RECEIPT:
			returnS = "R"+numberpo.getReceiptNum();
			numberpo.setReceiptNum(addOne(returnS));
			break;
		case STOCK:
			returnS = "S"+numberpo.getStockAreaNum();
			numberpo.setStockNum(addOne(returnS));
			break;
		case STOCKAREA:
			returnS = "SA"+numberpo.getStockAreaNum();
			numberpo.setStockAreaNum(addOne(returnS));
			break;
		case GOODS:
			returnS = "G"+numberpo.getGoodsNum();
			numberpo.setGoodsNum(addOne(returnS));
			break;
		case VEHICLE:
			returnS = "V"+numberpo.getVehicleNum();
			numberpo.setVehicleNum(addOne(returnS));
			break;
		case LOG:
			returnS = "L"+numberpo.getLogNum();
			numberpo.setLogNum(addOne(returnS));
			break;
		case INITIAL:
			returnS = "I"+numberpo.getInitNum();
			numberpo.setInitNum(addOne(returnS));
			break;
			
		default:
			return null;
		}
		try {
			numberdata.insert(numberpo);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return returnS;
	}
	
	public String addOne(String number){
		int i = Integer.valueOf(number);
		i ++;
		return String.valueOf(i);
	}
}
