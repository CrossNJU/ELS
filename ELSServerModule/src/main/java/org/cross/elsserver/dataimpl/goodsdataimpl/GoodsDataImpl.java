package org.cross.elsserver.dataimpl.goodsdataimpl;

import java.io.Serializable;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import org.cross.elscommon.dataservice.goodsdataservice.GoodsDataService;
import org.cross.elscommon.po.GoodsPO;
import org.cross.elscommon.util.Filename;
import org.cross.elscommon.util.SerIO;

public class GoodsDataImpl extends UnicastRemoteObject implements GoodsDataService,Serializable{
	public GoodsDataImpl() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	public ArrayList<GoodsPO> goodsList;
	static String fileName = Filename.GOODSPO.toString();
	
	String testString = "start";
	
	@SuppressWarnings("unchecked")
	@Override
	public void update(GoodsPO goods) throws RemoteException {
		// TODO Auto-generated method stub
		goodsList = (ArrayList<GoodsPO>)SerIO.readPO("GoodsPO.ser");
		if (goodsList == null) {
			goodsList = new ArrayList<GoodsPO>();
		}
		int find = -1;
		for (int i = 0; i < goodsList.size(); i++) {
			if(goods.getOrderNumber().equals(goodsList.get(i).getOrderNumber())){
				find = i;
				break;
			}
		}
		if (find >= 0){
			goodsList.remove(find);
			goodsList.add(goods);
		}else goodsList.add(goods);
		SerIO.writePO(goodsList, fileName);
	}

	@SuppressWarnings("unchecked")
	@Override
	public GoodsPO show(String id) throws RemoteException {
		// TODO Auto-generated method stub
		goodsList = (ArrayList<GoodsPO>)SerIO.readPO("GoodsPO.ser");
		if(goodsList==null)System.out.println("null");
		System.out.println(goodsList.size());
		for (int i = 0; i < goodsList.size(); i++) {
			System.out.println(goodsList.get(i).getOrderNumber()+"++++++");
			if (goodsList.get(i).getOrderNumber().equals(id)) {
				return goodsList.get(i);
			}
		}
		return null;
	}

	@Override
	public String justTest() throws RemoteException{
		// TODO Auto-generated method stub
		return this.testString+" throw remote\n";
	}

	@Override
	public void setTestString(String s) throws RemoteException {
		// TODO Auto-generated method stub
		this.testString = s;
	}

}
