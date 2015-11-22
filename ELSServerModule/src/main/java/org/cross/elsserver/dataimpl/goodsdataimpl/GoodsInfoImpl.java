package org.cross.elsserver.dataimpl.goodsdataimpl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.cross.elscommon.po.GoodsPO;
import org.cross.elscommon.util.MySQL;
import org.cross.elscommon.util.StringToType;
import org.cross.elsserver.dataimpl.tools.GoodsTool;

public class GoodsInfoImpl implements GoodsTool {

	private MySQL mysql;

	public GoodsInfoImpl() {
		mysql = new MySQL();
	}

	@Override
	public void addToStock(String number, String stockAreaNum) {
		String sql = "update `goods` set `stockAreaNum`='" + stockAreaNum + "' where `number`='" + number + "'";
		mysql.execute(sql);
	}

	@Override
	public void deleteFromStock(String number) {
		String sql = "update `goods` set `stockAreaNum`=NULL where `number`='" + number + "'";
		mysql.execute(sql);
	}

	@Override
	public ArrayList<GoodsPO> findByStockAreaNum(String stockAreaNum) {
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
}
