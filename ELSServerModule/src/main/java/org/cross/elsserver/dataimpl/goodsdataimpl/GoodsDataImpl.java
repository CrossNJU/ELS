package org.cross.elsserver.dataimpl.goodsdataimpl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.cross.elscommon.dataservice.goodsdataservice.GoodsDataService;
import org.cross.elscommon.po.GoodsPO;
import org.cross.elscommon.po.HistoryPO;
import org.cross.elscommon.util.City;
import org.cross.elscommon.util.GoodsState;
import org.cross.elscommon.util.MySQL;
import org.cross.elscommon.util.OrganizationType;
import org.cross.elscommon.util.ResultMessage;
import org.cross.elscommon.util.StringToType;
import org.cross.elsserver.dataimpl.tools.HistoryTool;

@SuppressWarnings("serial")
public class GoodsDataImpl extends UnicastRemoteObject implements GoodsDataService {

	private HistoryTool historyTool;
	MySQL mysql;

	public GoodsDataImpl() throws RemoteException {
		super();
		this.historyTool = new HistoryDataImpl();
		mysql = new MySQL();
	}

	@Override
	public ResultMessage updateLocation(String number, City nowLocation, OrganizationType org) throws RemoteException {
		String sql = "update `goods` set `placeCity`='" + nowLocation.toString() + "',`placeOrg`='" + org.toString()
				+ "' where `number`='" + number + "'";
		if (mysql.execute(sql)) {
			return ResultMessage.SUCCESS;
		} else
			return ResultMessage.FAILED;
	}

	@Override
	public ResultMessage updateState(String number, GoodsState state) throws RemoteException {
		String sql = "update `goods` set `state`='" + state.toString() + "' where `number`='" + number + "'";
		if (mysql.execute(sql)) {
			return ResultMessage.SUCCESS;
		} else
			return ResultMessage.FAILED;
	}

	@Override
	public ResultMessage addToOrder(String number, String orderNum) throws RemoteException {
		String sql = "update `receiptOrder` set `goodsNum`='" + number + "' where `number`='" + orderNum + "'";
		if (!mysql.execute(sql)) {
			return ResultMessage.FAILED;
		}
		sql = "update `goods` set `orderNum`='" + orderNum + "' where `number`='" + number + "'";
		if (mysql.execute(sql)) {
			return ResultMessage.SUCCESS;
		} else
			return ResultMessage.FAILED;
	}

	@Override
	public ResultMessage addToTrans(String number, String transNum) throws RemoteException {
		String sql = "update `goods` set `transNum`='" + transNum + "' where `number`='" + number + "'";
		if (mysql.execute(sql)) {
			return ResultMessage.SUCCESS;
		} else
			return ResultMessage.FAILED;
	}

	@Override
	public ResultMessage addToArri(String number, String arriNum) throws RemoteException {
		String sql = "update `goods` set `arriNum`='" + arriNum + "' where `number`='" + number + "'";
		if (mysql.execute(sql)) {
			return ResultMessage.SUCCESS;
		} else
			return ResultMessage.FAILED;
	}

	@Override
	public ResultMessage addToStock(String number,String stockNum, String stockAreaNum) throws RemoteException {
		String sql = "update `goods` set `stockNum`='" + stockNum + "', `stockAreaNum`='"+stockAreaNum+"' where `number`='" + number + "'";
		if (mysql.execute(sql)) {
			return ResultMessage.SUCCESS;
		} else
			return ResultMessage.FAILED;
	}

	@Override
	public ResultMessage addHistory(String number, HistoryPO history) throws RemoteException {
		return historyTool.insert(history, number);
	}

	@Override
	public ResultMessage insertToDB(GoodsPO goods) throws RemoteException {
		String sql = "insert ignore into `goods`(`number`, `type`, `placeCity`, `placeOrg`, `state`, `weight`, `volume`)"
				+ " values ('" + goods.getNumber() + "','" + goods.getGoodsType().toString() + "','"
				+ goods.getPlaceCity().toString() + "','" + goods.getPlaceOrg().toString() + "','"
				+ goods.getState().toString() + "'," + goods.getWeight() + "," + goods.getVolume() + ")";
		if (mysql.execute(sql)) {
			return ResultMessage.SUCCESS;
		} else
			return ResultMessage.FAILED;
		//TODO 可能需要有反馈信息：仓库是否已经有了
	}

	@Override
	public GoodsPO findByNum(String number) throws RemoteException {
		GoodsPO po = null;
		String sql = "select * from `goods` where `number`='" + number + "'";
		ResultSet rs = mysql.query(sql);
		try {
			if (rs.next()) {
				po = new GoodsPO(StringToType.toGoodsType(rs.getString("type")), rs.getString("number"),
						StringToType.toCity(rs.getString("placeCity")), StringToType.toOrg(rs.getString("placeOrg")),
						rs.getInt("weight"), rs.getInt("volume"));
				ArrayList<HistoryPO> list = historyTool.findByGoodsNum(number);
				for (int i = 0; i < list.size(); i++) {
					po.addHistory(list.get(i));
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return po;
	}

	@Override
	public ResultMessage deleteFromOrder(String number) throws RemoteException {
		String sql = "update `goods` set `orderNum`=NULL where `number`='" + number + "'";
		if(mysql.execute(sql)) return ResultMessage.SUCCESS;
		else return ResultMessage.FAILED;
	}

	@Override
	public ResultMessage deleteFromTrans(String number) throws RemoteException {
		String sql = "update `goods` set `transNum`=NULL where `number`='" + number + "'";
		if(mysql.execute(sql)) return ResultMessage.SUCCESS;
		else return ResultMessage.FAILED;
	}

	@Override
	public ResultMessage deleteFromArri(String number) throws RemoteException {
		String sql = "update `goods` set `arriNum`=NULL where `number`='" + number + "'";
		if(mysql.execute(sql)) return ResultMessage.SUCCESS;
		else return ResultMessage.FAILED;
	}

	@Override
	public ResultMessage deleteFromStock(String number) throws RemoteException {
		String sql = "update `goods` set `stockAreaNum`=NULL where `number`='" + number + "'";
		if(mysql.execute(sql)) return ResultMessage.SUCCESS;
		else return ResultMessage.FAILED;
	}

	@Override
	public ArrayList<GoodsPO> findByStockAreaNum(String stockAreaNum) throws RemoteException {
		ArrayList<GoodsPO> list = new ArrayList<GoodsPO>();
		GoodsPO po = null;
		String sql = "select * from `goods` where `stockAreaNum`='" + stockAreaNum + "'";
		ResultSet rs = mysql.query(sql);
		try {
			while (rs.next()) {
				po = new GoodsPO(StringToType.toGoodsType(rs.getString("type")), rs.getString("number"),
						StringToType.toCity(rs.getString("placeCity")), StringToType.toOrg(rs.getString("placeOrg")),
						rs.getInt("weight"), rs.getInt("volume"));
				list.add(po);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public String findStockAreaNum(String number) throws RemoteException{
		String sql = "select * from `goods` where `number`='"+number+"'";
		ResultSet rs = mysql.query(sql);
		try {
			if (rs.next()) {
				return rs.getString("stockAreaNum");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public String findStockNum(String number) throws RemoteException {
		String sql = "select * from `goods` where `number`='"+number+"'";
		ResultSet rs = mysql.query(sql);
		try {
			if (rs.next()) {
				return rs.getString("stockNum");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
