package org.cross.elsclient.blservice.stockblservice;

import java.rmi.RemoteException;
import java.util.ArrayList;

import org.cross.elsclient.blservice.goodsblservice.GoodsBLImpl;
import org.cross.elsclient.blservice.goodsblservice.GoodsBLService;
import org.cross.elsclient.blservice.receiptblservice.ReceiptBLImpl;
import org.cross.elsclient.blservice.receiptblservice.ReceiptBLService;
import org.cross.elscommon.dataservice.stockdataservice.StockDataService;
import org.cross.elscommon.po.GoodsPO;
import org.cross.elscommon.po.StockAreaPO;
import org.cross.elscommon.po.StockOperationPO;
import org.cross.elscommon.po.StockPO;
import org.cross.elscommon.util.CompareTime;
import org.cross.elscommon.util.ResultMessage;
import org.cross.elscommon.util.StockType;
import org.cross.elsclient.vo.GoodsVO;
import org.cross.elsclient.vo.StockAreaVO;
import org.cross.elsclient.vo.StockOperationVO;
import org.cross.elsclient.vo.StockVO;

public class StockBLImpl implements StockBLService{
	
	public StockVO stockvo;
	public StockPO stockpo;
	public StockDataService stockData;
	GoodsBLImpl goodsbl;
	ReceiptBLImpl receiptbl;
	
	public StockBLImpl(StockDataService stockdata, ReceiptBLService receiptbl, GoodsBLService goodsbl){
		this.stockData = stockdata;
		this.goodsbl = (GoodsBLImpl)goodsbl;
		this.receiptbl = (ReceiptBLImpl)receiptbl;
	}
	
	@Override
	public ArrayList<StockVO> showStockCheck() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<StockOperationVO> showStockInfo(String time1, String time2) {
		ArrayList<StockOperationVO> ops = new ArrayList<StockOperationVO>();
		for (int i = 0; i < stockvo.stockOperations.size(); i++) {
			StockOperationVO vo = stockvo.stockOperations.get(i);
			if(CompareTime.compare(vo.time, time1)>=0 && 
					CompareTime.compare(time2, vo.time)>=0){
				ops.add(vo);
			}
		}
		return ops;
	}

	@Override
	public StockVO findStock(String ID) throws RemoteException {
		// TODO Auto-generated method stub
		stockpo = stockData.findStock(ID);
		stockvo = toVO(stockpo);
		return toVO(stockpo);
	}

	@Override
	public ResultMessage exportStockCheck() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage stockEnough(StockType type) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public StockAreaVO stockCapacity(StockType type) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage checkGoods(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage intoStock(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage outStock(String id) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public StockVO toVO(StockPO stockpo){
		StockVO stockvo = new StockVO(stockpo.getStockID(),stockpo.getNumOfBooths());
		stockvo.moneyIn = stockpo.getMoneyIn();
		stockvo.moneyOut = stockpo.getMoneyOut();
		stockvo.numIn = stockpo.getNumIn();
		stockvo.numInStock = stockpo.getNumInStock();
		stockvo.numOut = stockpo.getNumOut();
		stockvo.usedBooths = stockpo.getUsedBooths();
		stockvo.specialStockPOs = getAreasVO(stockpo.getSpecialStockPOs());
		stockvo.stockOperations = getopVO(stockpo.getStockOperations());
		return stockvo;
	}
	
	public ArrayList<StockAreaVO> getAreasVO(ArrayList<StockAreaPO> pos){
		ArrayList<StockAreaVO> areas = new ArrayList<StockAreaVO>();
		for (int i = 0; i < pos.size(); i++) {
			areas.add(toAreaVO(pos.get(i)));
		}
		return areas;
	}
	
	public ArrayList<StockOperationVO> getopVO(ArrayList<StockOperationPO> pos){
		ArrayList<StockOperationVO> ops = new ArrayList<StockOperationVO>();
		for (int i = 0; i < pos.size(); i++) {
			ops.add(toOpVO(pos.get(i)));
		}
		return ops;
	}
	
	public StockAreaVO toAreaVO(StockAreaPO po){
		StockAreaVO vo = new StockAreaVO(po.getStockType(), po.getTotalCapacity());
		vo.usedCapacity = po.getUsedCapacity();
		vo.goodsList = getGoodsVOs(po.getGoodsList());
		return vo;
	}
	
	public StockOperationVO toOpVO(StockOperationPO po){
		StockOperationVO vo = new StockOperationVO(po.getTime(), po.getType(),
				goodsbl.toVO(po.getGood()), po.getMoney(), po.getPlace());
		return vo;
	}
	
	public ArrayList<GoodsVO> getGoodsVOs(ArrayList<GoodsPO> pos){
		ArrayList<GoodsVO> vos = new ArrayList<GoodsVO>();
		for (int i = 0; i < pos.size(); i++) {
			vos.add(goodsbl.toVO(pos.get(i)));
		}
		return vos;
	}
}
