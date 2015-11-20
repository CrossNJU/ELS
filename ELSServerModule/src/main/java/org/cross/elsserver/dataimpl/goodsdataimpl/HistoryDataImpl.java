package org.cross.elsserver.dataimpl.goodsdataimpl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.cross.elscommon.po.HistoryPO;
import org.cross.elscommon.util.MySQL;
import org.cross.elscommon.util.ResultMessage;
import org.cross.elscommon.util.StringToType;
import org.cross.elsserver.dataimpl.tools.HistoryTool;

public class HistoryDataImpl implements HistoryTool {

	public MySQL mysql;

	public HistoryDataImpl() {
		mysql = new MySQL();
	}

	@Override
	public ArrayList<HistoryPO> findByGoodsID(int id) {
		// TODO Auto-generated method stub
		ArrayList<HistoryPO> list = new ArrayList<HistoryPO>();
		String search = "select * from history where belongGoods = '" + id + "'";
		ResultSet rs = mysql.query(search);

		try {
			while (rs.next()) {
				HistoryPO historyPO = new HistoryPO(rs.getString("time"), StringToType.toCity(rs.getString("place")));
				list.add(historyPO);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public ResultMessage insert(HistoryPO po, int goodsID) {
		// TODO Auto-generated method stub
		String sql = "insert into history(belongGoods, time, place, number) VALUES( " + goodsID
				+ ", '" + po.getTime() + "', '" + po.getPlace().toString() + ")";
		mysql.execute(sql);
		return ResultMessage.SUCCESS;
	}

//	public static void main(String[] args) {
//		HistoryPO po = new HistoryPO("2015-10-25 01:10:10", City.BEIJING);
//		HistoryDataImpl impl = new HistoryDataImpl();
//		impl.insert(po, "1000001", 1);
//	}

}
