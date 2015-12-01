package org.cross.elsserver.dataimpl.stockdataimpl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.cross.elscommon.dataservice.stockdataservice.StockDataService;
import org.cross.elscommon.po.StockAreaPO;
import org.cross.elscommon.po.StockOperationPO;
import org.cross.elscommon.po.StockPO;
import org.cross.elscommon.util.MySQL;
import org.cross.elscommon.util.ResultMessage;
import org.cross.elscommon.util.StockType;
import org.cross.elscommon.util.StringToType;

@SuppressWarnings("serial")
public class StockDataImpl extends UnicastRemoteObject implements StockDataService {

	private MySQL mysql;

	public StockDataImpl() throws RemoteException {
		super();
		mysql = new MySQL();
	}

	@Override
	public ResultMessage insert(StockPO po ) throws RemoteException {
		String sql = "insert ignore into `stock`(`number`, `totalArea`, `usedArea`, `numOut`, `numIn`, `moneyOut`, `moneyIn`, `numInStock`)"
				+ " values ('" + po.getNumber() + "'," + po.getTotalAreas() + ","+po.getUsedAreas()+",0,0,0,0,0)";
		if (!mysql.execute(sql)) 
			return ResultMessage.FAILED;
		ArrayList<StockAreaPO> areas = po.getStockAreas();
		for (int i = 0; i < areas.size(); i++) {
			addstockArea(areas.get(i), po.getNumber());
		}
		return ResultMessage.SUCCESS;
	}

	@Override
	public ResultMessage delete(String number) throws RemoteException {
		String sql = "delete from `stockArea` where `stockNum`='"+number +"'";
		if (!mysql.execute(sql)) return ResultMessage.FAILED;
		sql = "delete from `stock` where `number`='" + number + "'";
		if (!mysql.execute(sql)) return ResultMessage.FAILED;
		return ResultMessage.SUCCESS;
	}

	@Override
	public ResultMessage updateInstock(String stockNum, String stockAreaNum, StockOperationPO op)
			throws RemoteException {
		addstockOP(op, stockNum, stockAreaNum);
		String sql = "select * from `stockArea` where `number`='" + stockAreaNum + "'";
		ResultSet rs = mysql.query(sql);
		int usedCapacity = -1;
		try {
			rs.next();
			usedCapacity = rs.getInt("usedCapacity") + 1;
			sql = "update `stockArea` set `usedCapacity`=" + usedCapacity + " where `number`='" + stockAreaNum + "'";
			mysql.execute(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		int numIn = -1;
		double moneyIn = -1;
		int numInStock = -1;
		sql = "select * from `stock` where `number`='" + stockNum + "'";
		rs = mysql.query(sql);
		try {
			rs.next();
			numIn = rs.getInt("numIn") + 1;
			moneyIn = rs.getDouble("moneyIn") + op.getMoney();
			numInStock = rs.getInt("numInStock") + 1;
			sql = "update `stock` set `numIn`=" + numIn + ", `moneyIn`=" + moneyIn + ", `numInStock`=" + numInStock
					+ " where" + "`number` = '" + stockNum + "'";
			mysql.execute(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ResultMessage.SUCCESS;
	}

	@Override
	public ResultMessage updateOutstock(String stockNum, String stockAreaNum, StockOperationPO op)
			throws RemoteException {
		addstockOP(op, stockNum, stockAreaNum);
		String sql = "select * from `stockArea` where `number`='" + stockAreaNum + "'";
		ResultSet rs = mysql.query(sql);
		int usedCapacity = -1;
		try {
			rs.next();
			usedCapacity = rs.getInt("usedCapacity") - 1;
			sql = "update `stockArea` set `usedCapacity`=" + usedCapacity + " where `number`='" + stockAreaNum + "'";
			mysql.execute(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		int numOut = -1;
		double moneyOut = -1;
		int numInStock = -1;
		sql = "select * from `stock` where `number`='" + stockNum + "'";
		rs = mysql.query(sql);
		try {
			rs.next();
			numOut = rs.getInt("numOut") + 1;
			moneyOut = rs.getDouble("moneyOut") + op.getMoney();
			numInStock = rs.getInt("numInStock") - 1;
			sql = "update `stock` set `numOut`=" + numOut + ", `moneyOut`=" + moneyOut + ", `numInStock`=" + numInStock
					+ " where" + "`number` = '" + stockNum + "'";
			mysql.execute(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ResultMessage.SUCCESS;
	}

	@Override
	public ResultMessage updateAdjust(String stockAreaNum,StockType type) throws RemoteException {
		String sql = "select * from `stockArea` where `number`='" + stockAreaNum + "'";
		ResultSet rs = mysql.query(sql);
		try {
			rs.next();
			sql = "update `stockArea` set `type`=" + type.toString() + " where `number`='" + stockAreaNum + "'";
			mysql.execute(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ResultMessage.SUCCESS;
	}
//没写完
	@Override
	public ArrayList<StockOperationPO> showStockOps(String stockNum, String startTime, String endTime)
			throws RemoteException {
		ArrayList<StockOperationPO> list = new ArrayList<StockOperationPO>();
		String sql = "select * from `stockOperation` where `stockNum`='" + stockNum + "'";
		ResultSet rs = mysql.query(sql);
		try {
			while (rs.next()) {
				StockOperationPO po = new StockOperationPO(rs.getString("time"),
						StringToType.toStockOperation(rs.getString("type")), rs.getString("goodsNum"),
						rs.getDouble("money"), StringToType.toGoodsType(rs.getString("place")));
				list.add(po);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public StockPO findStockByNum(String number) throws RemoteException {
		StockPO po = null;
		String sql = "select * from `stock` where `number`='" + number + "'";
		ResultSet rs = mysql.query(sql);
		try {
			if (rs.next()) {
				po = new StockPO(number, rs.getInt("totalArea"));
				po.setInMoney(rs.getDouble("moneyIn"));
				po.setOutMoney(rs.getDouble("moneyOut"));
				po.setInNum(rs.getInt("numIn"));
				po.setOutNum(rs.getInt("numOut"));
				po.setUsedAreas(rs.getInt("usedArea"));
				po.setNumInStock(rs.getInt("numInStock"));
				ArrayList<StockAreaPO> areas = findAreas(number);
				ArrayList<StockOperationPO> ops = showStockOps(number, null, null);
				po.setStockAreas(areas);
				po.setStockOPs(ops);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return po;
	}
	@Override
	public ArrayList<StockAreaPO> findAreas(String stockNum) throws RemoteException{
		ArrayList<StockAreaPO> areas = new ArrayList<StockAreaPO>();
		String sql = "select * from `stockArea` where `stockNum`='" + stockNum + "'";
		ResultSet rs = mysql.query(sql);
		try {
			while (rs.next()) {
				String stockAreaNum = rs.getString("number");
				StockAreaPO po = new StockAreaPO(stockAreaNum, StringToType.toGoodsType(rs.getString("type")),
						rs.getInt("totalCapacity"));
				po.setUsedCapacity(rs.getInt("usedCapacity"));
				areas.add(po);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return areas;
	}

	public void addstockOP(StockOperationPO po, String stockNum, String stockAreaNum) {
		String sql = "insert into `stockOperation`(`time`, `type`, `goodsNum`, `money`, `place`, `stockAreaNum`, `stockNum`) values ('"
				+ po.getTime() + "','" + po.getType().toString() + "','" + po.getGoodNum() + "'," + po.getMoney() + ",'"
				+ po.getPlace().toString() + "','" + stockAreaNum + "','" + stockNum + "')";
		mysql.execute(sql);
	}

	public void addstockArea(StockAreaPO po, String stockNum) {
		String sql = "insert ignore into `stockArea`(`number`, `totalCapacity`, `usedCapacity`, `type`, `stockNum`) values ('"
				+ po.getNumber() + "'," + po.getTotalCapacity() + "," + po.getUsedCapacity() + ",'"
				+ po.getStockType().toString() + "','" + stockNum + "')";
		mysql.execute(sql);
	}

	@Override
	public ResultMessage addToInstock(String stockAreaNum, String receipt) throws RemoteException{
		String sql ="update `stockArea` set `reStockInNum`='"+receipt+"' where `number`='"+stockAreaNum+"'";
		if(mysql.execute(sql)) return ResultMessage.SUCCESS;
		return ResultMessage.FAILED;
	}

	@Override
	public ResultMessage deleteFromInstock(String stockAreaNum) throws RemoteException{
		String sql ="update `stockArea` set `reStockInNum`=NULL where `number`='"+stockAreaNum+"'";
		if(mysql.execute(sql)) return ResultMessage.SUCCESS;
		return ResultMessage.FAILED;
	}
//	public static void main(String[] args) throws RemoteException{
//		StockDataImpl stockDataImpl = new StockDataImpl();
//		stockDataImpl.updateAdjust("A0001", StockType.Fast);
//	}

	@Override
	public String getIntoStockTime(String stockNum,String goodsNum)throws RemoteException{
		ArrayList<StockOperationPO> list = new ArrayList<StockOperationPO>();
		String sql = "select * from `stockOperation` where `stockNum`='" + stockNum + "'";
		ResultSet rs = mysql.query(sql);
		try {
			while (rs.next()) {
				StockOperationPO po = new StockOperationPO(rs.getString("time"),
						StringToType.toStockOperation(rs.getString("type")), rs.getString("goodsNum"),
						rs.getDouble("money"), StringToType.toGoodsType(rs.getString("place")));
				list.add(po);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		int size = list.size();
		for (int i = size; i >= 0; i--) {
			if (list.get(i).getGoodNum().equals(goodsNum)) {
				return list.get(i).getTime();
			}
		}
		return null;
	}

}
