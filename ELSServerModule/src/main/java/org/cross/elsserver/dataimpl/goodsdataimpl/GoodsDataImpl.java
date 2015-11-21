package org.cross.elsserver.dataimpl.goodsdataimpl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.cross.elscommon.dataservice.goodsdataservice.GoodsDataService;
import org.cross.elscommon.po.GoodsPO;
import org.cross.elscommon.po.HistoryPO;
import org.cross.elscommon.po.Receipt_OrderPO;
import org.cross.elscommon.util.City;
import org.cross.elscommon.util.GoodsState;
import org.cross.elscommon.util.MySQL;
import org.cross.elscommon.util.StockType;
import org.cross.elscommon.util.StringToType;
import org.cross.elsserver.dataimpl.tools.HistoryTool;

@SuppressWarnings("serial")
public class GoodsDataImpl extends UnicastRemoteObject implements GoodsDataService {

	public ArrayList<GoodsPO> goodsList;
	public MySQL mysql;
	public HistoryTool historyTool;

	public GoodsDataImpl(HistoryTool historyTool) throws RemoteException {
		super();
		mysql = new MySQL();
		this.historyTool = historyTool;
	}

	@Override
	public GoodsPO show(String id) throws RemoteException {
//		System.out.println("ininin");
		String search = "select * from goods where number = '" + id + "'";
		ResultSet rs = mysql.query(search);
		GoodsPO goods = getFromDB(rs);
//		System.out.println("data : " + goods.getHistoryPO().size());
		return goods;
	}

	@Override
	public void updateLocation(String id, City nowLocation) throws RemoteException {
		String sql = "update goods set city = '" + nowLocation.toString() + "' where number = '" + id + "'";
		updateIntoDB(id, sql);
	}

	@Override
	public void updateState(String id, GoodsState state) throws RemoteException {
		String sql = "update goods set state = '" + state.toString() + "' where number = '" + id + "'";
		updateIntoDB(id, sql);
	}

	@Override
	public void updateTrans(String id, int transNum) throws RemoteException {
		String sql = "update goods set belongTrans = " + transNum + " where number = '" + id + "'";
		updateIntoDB(id, sql);
	}

	@Override
	public void updateStock(String id, int stockAreaNum) throws RemoteException {
		String sql = "update goods set belongStockArea = " + stockAreaNum + " where number = '" + id + "'";
		updateIntoDB(id, sql);
	}

	@Override
	public void updateHistory(String id, HistoryPO history) throws RemoteException {
		// TODO Auto-generated method stub
		String sql = "select * from goods where number = '"+id+"'";
		ResultSet rs = mysql.query(sql);
		try {
			if (rs.next()) {
				historyTool.insert(history, rs.getInt("ID"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void insert(GoodsPO goods) throws RemoteException {
		String sql = "insert into goods(type,city,state,weight,volume,number) values ('"
				+ goods.getGoodsType().toString() + "','" + goods.getCurrentLocate().toString() + "','"
				+ goods.getGoodsState().toString() + "'," + goods.getGoodsWeight() + "," + goods.getGoodsVolume() + ",'"
				+ goods.getOrderNumber() + "')";
		mysql.execute(sql);
	}

	public GoodsPO getFromDB(ResultSet rs) {
		GoodsPO goods = null;
		try {
			if (rs.next()) {
				StockType goodsType = StringToType.toGoodsType(rs.getString("type"));
				GoodsState goodsState = StringToType.toGoodsState(rs.getString("state"));
				int goodsID = rs.getInt("ID");
				ArrayList<HistoryPO> list = historyTool.findByGoodsID(goodsID);
				String number = rs.getString("number");
				City now = StringToType.toCity(rs.getString("city"));
				int weight = rs.getInt("weight");
				int volume = rs.getInt("volume");
				goods = new GoodsPO(weight, volume, now, goodsType);
				goods.setGoodsState(goodsState);
				goods.setOrderNumber(number);
				for (int i = 0; i < list.size(); i++) {
					goods.setHistoryPO(list.get(i));
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return goods;
	}

	public void updateIntoDB(String number, String sql) {
		String search = "select * from goods where number = '" + number + "'";
		ResultSet rs = mysql.query(search);
		try {
			if (!rs.next()) {
				System.out.println("not exist!");
			} else {
				mysql.execute(sql);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void main(String[] args) throws Exception {
//		GoodsPO good1 = new GoodsPO(300, 10, City.BEIJING, StockType.ECONOMICAL);
//		Receipt_OrderPO order1 = new Receipt_OrderPO("R120151023000005", "2016-11-25 01:10:10");
//		good1.setOrderNumber(order1.getNumber());
		HistoryTool historyTool = new HistoryDataImpl();
		GoodsDataImpl dataImpl = new GoodsDataImpl(historyTool);
		// dataImpl.updateLocation(good1.getOrderNumber(),
		// good1.getCurrentLocate());
		GoodsPO po = dataImpl.show("R120151023000002");
		System.out.println(po.getHistoryPO().size());
	}

}
