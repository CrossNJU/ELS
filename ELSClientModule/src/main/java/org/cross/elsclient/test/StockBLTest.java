package org.cross.elsclient.test;

import java.rmi.RemoteException;
import java.util.ArrayList;

import org.cross.elsclient.blimpl.blUtility.GoodsInfo;
import org.cross.elsclient.blimpl.blUtility.StockInfo;
import org.cross.elsclient.blimpl.goodsblimpl.GoodsBLImpl;
import org.cross.elsclient.blimpl.goodsblimpl.GoodsInfoImpl;
import org.cross.elsclient.blimpl.stockblimpl.StockBLImpl;
import org.cross.elsclient.blimpl.stockblimpl.StockInfoImpl;
import org.cross.elsclient.network.Datafactory;
import org.cross.elsclient.vo.StockAreaVO;
import org.cross.elsclient.vo.StockOperationVO;
import org.cross.elsclient.vo.StockVO;
import org.cross.elscommon.dataservice.datafactoryservice.DataFactoryService;
import org.cross.elscommon.util.ResultMessage;
import org.cross.elscommon.util.StockType;

public class StockBLTest {
	
	public static void main(String[] args) throws RemoteException{
		DataFactoryService dataFactoryService = new Datafactory();
		GoodsInfo goodsInfo = new GoodsInfoImpl(dataFactoryService.getGoodsData());
		StockInfo stockInfo = new StockInfoImpl(goodsInfo);
		StockBLImpl stockBLImpl = new StockBLImpl(dataFactoryService.getStockData(), goodsInfo, stockInfo);
		
//		System.out.println("=======测试库存盘点（生成库存快照）（showStockCheck）=======");
		System.out.println("=======测试寻找仓库（findStock）=======");
		StockVO stockVO1 = stockBLImpl.findStock("C0100001");
		if (stockVO1 != null) {
			System.out.println("已找到 " + stockVO1.number);
		}else {
			System.out.println("can not find it...");
		}
		System.out.println("=======测试库存查看（showStockInfo）=======");
		ArrayList<StockOperationVO> stockOperationVOs = stockBLImpl.showStockInfo("C0100001", "2015/10/23 10:12:01", "2015/10/12 10:20:01");
		for (int i = 0; i < stockOperationVOs.size(); i++) {
			System.out.println(stockOperationVOs.get(i).time + " " + stockOperationVOs.get(i).type);
		}
		
		System.out.println("=======测试快件入库（intoStock）=======");
		ResultMessage intoStockMessage = stockBLImpl.intoStock("G001", "C0100001","2015-11-2 11:34:19");
		if (intoStockMessage == ResultMessage.SUCCESS) {
			System.out.println("入库成功");
		}else {
			System.out.println("入库失败");
		}
		
//		System.out.println("=======测试快件出库（outStock）=======");
//		ResultMessage outStockMessage = stockBLImpl.outStock("R120151023000003", "S00002","2015-11-2 11:34:19");
//		if (outStockMessage == ResultMessage.SUCCESS) {
//			System.out.println("出库成功");
//		}else {
//			System.out.println("出库失败");
//		}
//		
//		System.out.println("=======测试查询特定仓库容量信息（stockCapacity）=======");
//		int total = 0,used = 0;
//		ArrayList<StockAreaVO> stockAreaVOs = stockBLImpl.stockCapacity("S00002", StockType.COMMON);
//		if (stockAreaVOs == null) {
//			System.out.println("未找到该仓库中的该区域");
//		}else {
//			for (int i = 0; i < stockAreaVOs.size(); i++) {
//				total += stockAreaVOs.get(i).totalCapacity;
//				used += stockAreaVOs.get(i).usedCapacity;
//			}
//			System.out.println("该类型仓库（Area）的总容量为 ： " + total);
//			System.out.println("该类型仓库（Area）的已用容量为 ： " + used);
//			if (used == 0) 
//				System.out.println("已用百分比为 ： 0%");
//			else 
//				System.out.println("已用百分比为 ： " + (double)used*100/total + "%");
//		}
//
	}

}
