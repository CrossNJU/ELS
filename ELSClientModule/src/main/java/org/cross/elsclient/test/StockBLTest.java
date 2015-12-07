//库存盘点没有测
package org.cross.elsclient.test;

import java.rmi.RemoteException;
import java.util.ArrayList;

import org.cross.elsclient.blimpl.blUtility.GoodsInfo;
import org.cross.elsclient.blimpl.blUtility.OrganizationInfo;
import org.cross.elsclient.blimpl.blUtility.PersonnelInfo;
import org.cross.elsclient.blimpl.blUtility.ReceiptInfo;
import org.cross.elsclient.blimpl.blUtility.SalaryInfo;
import org.cross.elsclient.blimpl.blUtility.StockInfo;
import org.cross.elsclient.blimpl.goodsblimpl.GoodsInfoImpl;
import org.cross.elsclient.blimpl.organizationblimpl.OrganizationInfoImpl;
import org.cross.elsclient.blimpl.personnelblimpl.PersonnelInfoImpl;
import org.cross.elsclient.blimpl.receiptblimpl.ReceiptInfoImpl;
import org.cross.elsclient.blimpl.salaryblimpl.SalaryBLImpl;
import org.cross.elsclient.blimpl.stockblimpl.StockBLImpl;
import org.cross.elsclient.blimpl.stockblimpl.StockInfoImpl;
import org.cross.elsclient.network.Datafactory;
import org.cross.elsclient.vo.GoodsVO;
import org.cross.elsclient.vo.StockAreaVO;
import org.cross.elsclient.vo.StockCheckVO;
import org.cross.elsclient.vo.StockOperationVO;
import org.cross.elsclient.vo.StockSeeVO;
import org.cross.elsclient.vo.StockVO;
import org.cross.elscommon.dataservice.datafactoryservice.DataFactoryService;
import org.cross.elscommon.util.ResultMessage;
import org.cross.elscommon.util.StockState;
import org.cross.elscommon.util.StockType;

public class StockBLTest {
	
	public static void main(String[] args) throws RemoteException{
		DataFactoryService dataFactoryService = new Datafactory();
		GoodsInfo goodsInfo = new GoodsInfoImpl(dataFactoryService.getGoodsData());
		OrganizationInfo orgInfo = new OrganizationInfoImpl(dataFactoryService.getOrganizationData());
		StockInfo stockInfo = new StockInfoImpl(goodsInfo, orgInfo, dataFactoryService.getStockData());
		SalaryInfo salaryInfo = new SalaryBLImpl(dataFactoryService.getSalaryData());
		PersonnelInfo personnelInfo = new PersonnelInfoImpl(dataFactoryService.getPersonnelData(), salaryInfo);
		ReceiptInfo receiptInfo = new ReceiptInfoImpl(dataFactoryService.getReceiptData(), stockInfo, personnelInfo);
		StockBLImpl stockBLImpl = new StockBLImpl(dataFactoryService.getStockData(), goodsInfo, stockInfo, receiptInfo);
		StockAreaVO area1 = new StockAreaVO("SA00001", "S0032902", StockType.Fast, 100, 0, null);
		StockAreaVO area2 = new StockAreaVO("SA00002", "S0032902", StockType.COMMON, 100, 0, null);
		StockAreaVO area3 = new StockAreaVO("SA00003", "S0032903", StockType.COMMON, 100, 0, null);
		StockAreaVO area4 = new StockAreaVO("SA00004", "S0032904", StockType.ECONOMICAL, 100, 0, null);
		ArrayList<StockAreaVO> areas = new ArrayList<StockAreaVO>();
		areas.add(area1); 
		areas.add(area2);
		areas.add(area3);
		areas.add(area4);
		StockVO stockVO = new StockVO("S0032902", 10000, 0, 0, 0, 0, 0, 0, "O283789",areas);
		
		System.out.println("=======测试增加仓库（addStock）=======");
		ResultMessage addResult = stockBLImpl.addStock(stockVO);
		if (addResult == ResultMessage.SUCCESS) {
			System.out.println("增加 " + stockVO.number + " 成功");
		}else {
			System.out.println("增加失败");
		}
//		System.out.println("=======测试删除仓库（addStock）=======");
//		ResultMessage deleteMessage = stockBLImpl.deleteStock("S0002");
//		if (deleteMessage == ResultMessage.SUCCESS) {
//			System.out.println("删除成功");
//		}else{
//			System.out.println("删除失败");
//		}
		System.out.println("=======测试库存盘点（生成库存快照）（showStockCheck）=======");
		ArrayList<StockCheckVO> checkVOs = stockBLImpl.showStockCheck("S0002");
		int len = checkVOs.size();
		for (int i = 0; i < len; i++) {
			System.out.println(checkVOs.get(i).goodsNumber + " " + checkVOs.get(i).inTime + " " + checkVOs.get(i).targetCity + " " +
					checkVOs.get(i).stockAreaNum);
		}
		System.out.println("=======测试寻找仓库（findStock）=======");
		StockVO stockVO1 = stockBLImpl.findStock("S0002");
		if (stockVO1 != null) {
			System.out.println("已找到 " + stockVO1.number);
		}else {
			System.out.println("can not find it...");
		}
		System.out.println("=======测试库存查看（showStockInfo）=======");
		StockSeeVO seeVO = stockBLImpl.showStockInfo("S0002", "2015/10/23 10:12:01", "2015/10/12 10:20:01");
		System.out.println(seeVO.goodsIn + " " + seeVO.goodsOut);
		System.out.println(seeVO.moneyIn + " " + seeVO.moneyOut);
		ArrayList<GoodsVO> goods = seeVO.goods;
		System.out.println(goods.size());
		System.out.println("=======测试快件入库（intoStock）=======");
		ResultMessage intoStockMessage = stockBLImpl.intoStock("G002", "S0032902","2015-11-2 11:34:21","SA00001");
		if (intoStockMessage == ResultMessage.SUCCESS) {
			System.out.println("入库成功");
		}else {
			System.out.println("入库失败");
		}
		
//		goodsInfo.updateToArea("G002", "S0002", "000004");
		
//		System.out.println("=======测试快件出库（outStock）=======");
//		ResultMessage outStockMessage = stockBLImpl.outStock("G002", "S0002","2015-11-2 11:34:19");
//		if (outStockMessage == ResultMessage.SUCCESS) {
//			System.out.println("出库成功");
//		}else {
//			System.out.println("出库失败");
//		}
		
		System.out.println("=======测试查询特定仓库容量信息（stockCapacity）=======");
		int total = 0,used = 0;
		ArrayList<StockAreaVO> stockAreaVOs = stockBLImpl.stockCapacity("S0002", StockType.COMMON);
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
		System.out.println("=======测试库存报警（StockAlert）=======");
		StockState state = stockBLImpl.stockAlert("S0002", StockType.Fast);
		System.out.println(state.toString());
		System.out.println("=======测试库存调整（StockAdjust）=======");
		ResultMessage adjustMessage = stockBLImpl.stockAdjust("000002", StockType.Fast);
		if (adjustMessage == ResultMessage.SUCCESS) {
			System.out.println("调整成功");
		}else {
			System.out.println("调整失败");
		}
		System.out.println("=======测试得到可调整的仓库（getChangeableArea）=======");
		ArrayList<String> changeable = stockBLImpl.getChangeableArea("S0002");
		if (changeable != null) {
			int size3 = changeable.size();
			for (int i = 0; i < size3; i++) {
				System.out.println(changeable.get(i));
			}
		}else {
			System.out.println("没有可调整的");
		}
	}
}
