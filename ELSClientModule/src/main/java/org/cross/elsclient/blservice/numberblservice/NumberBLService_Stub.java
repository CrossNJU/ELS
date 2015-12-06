package org.cross.elsclient.blservice.numberblservice;

import java.rmi.RemoteException;

import org.cross.elscommon.util.NumberType;
import org.cross.elscommon.util.ResultMessage;

public class NumberBLService_Stub implements NumberBLService {

	@Override
	public String getNumber(NumberType type) throws RemoteException {
		String s = "";
		switch (type) {
		case GOODS:
			s = "G";
			break;
		case INITIAL:
			s = "I";
			break;
		case LOG:
			s = "L";
			break;
		case ORGANIZATION:
			s = "O";
			break;
		case PERSONNEL:
			s = "P";
			break;
		case USER:
			s = "U";
			break;
		case RECEIPT:
			s = "R";
			break;
		case STOCK:
			s = "S";
			break;
		case STOCKAREA:
			s = "SA";
			break;
		case VEHICLE:
			s = "V";
			break;
		default:
			break;
		}
		return s+"000001";
	}

	@Override
	public ResultMessage saveNextNumber(NumberType type, String currentNum)
			throws RemoteException {
		// TODO Auto-generated method stub
		return ResultMessage.SUCCESS;
	}

}
