package org.cross.elsclient.blimpl.numberblimpl;

import java.rmi.RemoteException;

import org.cross.elsclient.blservice.numberblservice.NumberBLService;
import org.cross.elsclient.network.Datafactory;
import org.cross.elscommon.dataservice.datafactoryservice.DataFactoryService;
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
			if (numberpo == null) {
				numberpo = new NumberPO();
				numberdata.update(numberpo);
			}
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		switch (type) {
		case USER:
			returnS = numberpo.getUserNum();
			numberpo.setUserNum(addOne(returnS));
			returnS = "U"+ returnS;
			break;
		case ORGANIZATION:
			returnS = numberpo.getOrgNum();
			numberpo.setOrgNum(addOne(returnS));
			returnS = "O"+ returnS;
			break;
		case PERSONNEL:
			returnS = numberpo.getPerNum();
			numberpo.setPerNum(addOne(returnS));
			returnS = "P"+ returnS;
			break;
		case RECEIPT:
			returnS = numberpo.getReceiptNum();
			numberpo.setReceiptNum(addOne(returnS));
			returnS = "R"+ returnS;
			break;
		case STOCK:
			returnS = numberpo.getStockNum();
			numberpo.setStockNum(addOne(returnS));
			returnS = "S"+ returnS;
			break;
		case STOCKAREA:
			returnS = numberpo.getStockAreaNum();
			numberpo.setStockAreaNum(addOne(returnS));
			returnS = "SA"+ returnS;
			break;
		case GOODS:
			returnS = numberpo.getGoodsNum();
			numberpo.setGoodsNum(addOne(returnS));
			returnS = "G"+ returnS;
			break;
		case VEHICLE:
			returnS = numberpo.getVehicleNum();
			numberpo.setVehicleNum(addOne(returnS));
			returnS = "V"+ returnS;
			break;
		case LOG:
			returnS = numberpo.getLogNum();
			numberpo.setLogNum(addOne(returnS));
			returnS = "L"+ returnS;
			break;
		case INITIAL:
			returnS = numberpo.getInitNum();
			numberpo.setInitNum(addOne(returnS));
			returnS = "I"+ returnS;
			break;
			
		default:
			return null;
		}
		try {
			numberdata.update(numberpo);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return returnS;
	}
	
	public String addOne(String number){
		int i = Integer.valueOf(number);
		int l = number.length();
		i ++;
		String left = String.valueOf(i);
		String ans = "";
		for (int j = 0; j < l-left.length(); j++) {
			ans+="0";
		}
		ans+=left;
		return ans;
	}
	
	public NumberPO getPO() throws RemoteException{
		return numberdata.show();
	}
	
	public static void main(String [] args)throws RemoteException{
		DataFactoryService dataFactoryService = new Datafactory();
		NumberDataService numberdata = dataFactoryService.getNumberDataService();
		NumberBLImpl impl = new NumberBLImpl(numberdata);
		String p1 = impl.getPostNumber(NumberType.RECEIPT);
		impl = new NumberBLImpl(dataFactoryService.getNumberDataService());
		String p2 = impl.getPostNumber(NumberType.RECEIPT);
		System.out.println(p1+" "+p2);
	}

}
