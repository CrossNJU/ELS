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
	
	public NumberBLImpl(NumberDataService numberdata){
		this.numberdata = numberdata;
	}

	@Override
	public String getNumber(NumberType type) {
		try {
			numberpo = numberdata.show();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public ResultMessage saveNextNumber(NumberType type, String currentNum) {
		// TODO Auto-generated method stub
		return null;
	}

}
