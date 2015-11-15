package org.cross.elsclient.test;

import java.rmi.RemoteException;
import java.util.ArrayList;

import org.cross.elsclient.blimpl.blUtility.GoodsInfo;
import org.cross.elsclient.blimpl.goodsblimpl.GoodsBLImpl;
import org.cross.elsclient.blimpl.stockblimpl.StockBLImpl;
import org.cross.elsclient.network.Datafactory;
import org.cross.elsclient.vo.StockAreaVO;
import org.cross.elsclient.vo.StockVO;
import org.cross.elscommon.dataservice.datafactoryservice.DataFactoryService;
import org.cross.elscommon.util.ResultMessage;
import org.cross.elscommon.util.StockType;

public class StockBLTest {
	
	public static void main(String[] args) throws RemoteException{
		DataFactoryService dataFactoryService = new Datafactory();
//		ReceiptInfo receiptInfo = new ReceiptBLImpl(dataFactoryService.getReceiptData());
		GoodsInfo goodsInfo = new GoodsBLImpl(dataFactoryService.getGoodsData());
		StockBLImpl stockBLImpl = new StockBLImpl(dataFactoryService.getStockData(),dataFactoryService.getGoodsData(), goodsInfo);
		
//		System.out.println("=======测试库存盘点（生成库存快照）（showStockCheck）=======");
//		System.out.println("=======测试库存查看（showStockInfo）=======");
		System.out.println("=======测试寻找仓库（findStock）=======");
		StockVO stock = stockBLImpl.findStock("S00002");
		if (stock != null) {
			System.out.println("已找到 ： " + stock.stockIdentifier + " 仓库");	
		}else {
			System.out.println("未找到。。。");
		}

//		System.out.println("=======测试库存查看（showStockInfo）=======");
		
		System.out.println("=======测试快件入库（intoStock）=======");
		ResultMessage intoStockMessage = stockBLImpl.intoStock("R120151023000004", "S00002");
		if (intoStockMessage == ResultMessage.SUCCESS) {
			System.out.println("入库成功");
		}else {
			System.out.println("入库失败");
		}
		
		System.out.println("=======测试快件出库（outStock）=======");
		ResultMessage outStockMessage = stockBLImpl.outStock("R120151023000002", "S00002");
		if (outStockMessage == ResultMessage.SUCCESS) {
			System.out.println("出库成功");
		}else {
			System.out.println("出库失败");
		}
		
		System.out.println("=======测试查询特定仓库容量信息（stockCapacity）=======");
		int total = 0,used = 0;
		ArrayList<StockAreaVO> stockAreaVOs = stockBLImpl.stockCapacity("S00002", StockType.Fast);
		if (stockAreaVOs == null) {
			System.out.println("未找到该仓库中的该区域");
		}else {
			for (int i = 0; i < stockAreaVOs.size(); i++) {
				total += stockAreaVOs.get(i).totalCapacity;
				used += stockAreaVOs.get(i).usedCapacity;
			}
			System.out.println("该类型仓库（Area）的总容量为 ： " + total);
			System.out.println("该类型仓库（Area）的已用容量为 ： " + used);
			if (used == 0) 
				System.out.println("已用百分比为 ： 0%");
			else 
				System.out.println("已用百分比为 ： " + (double)used*100/total + "%");
		}
		
		System.out.println("=======测试仓库中快件信息核实（checkGoods）=======");
		ResultMessage checkMessage = stockBLImpl.checkGoods("R120151023000004", "S00002");
		if (checkMessage == ResultMessage.SUCCESS) {
			System.out.println("找到快件啦");
		}else {
			System.out.println("没有找到它。。。");
		}

	}

}
