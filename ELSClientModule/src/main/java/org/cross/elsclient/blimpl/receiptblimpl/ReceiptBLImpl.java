package org.cross.elsclient.blimpl.receiptblimpl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import org.cross.elscommon.dataservice.receiptdataservice.ReceiptDataService;
import org.cross.elscommon.po.ReceiptPO;
import org.cross.elscommon.po.Receipt_OrderPO;
import org.cross.elscommon.util.ReceiptType;
import org.cross.elscommon.util.ResultMessage;
import org.cross.elsclient.blimpl.blUtility.GoodsInfo;
import org.cross.elsclient.blimpl.blUtility.ReceiptInfo;
import org.cross.elsclient.blservice.receiptblservice.ReceiptBLService;
import org.cross.elsclient.vo.ReceiptVO;
import org.cross.elsclient.vo.Receipt_OrderVO;

public class ReceiptBLImpl implements ReceiptBLService,ReceiptInfo{

	GoodsInfo goodsInfo;
	ReceiptDataService receiptDataService;
	
	public ReceiptBLImpl(GoodsInfo goodsInfo, ReceiptDataService receiptDataService){
		this.goodsInfo = goodsInfo;
		this.receiptDataService = receiptDataService;
	}

	@Override
	public ResultMessage add(ReceiptVO vo) {
		// TODO Auto-generated method stub
		ReceiptPO po = toPO(vo);
		ResultMessage result = ResultMessage.FAILED;
		try {
			result = receiptDataService.insert(po);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public ResultMessage delete(ReceiptVO vo) {
		// TODO Auto-generated method stub
		ReceiptPO po = toPO(vo);
		ResultMessage result = ResultMessage.FAILED;
		try {
			result = receiptDataService.delete(po);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public ResultMessage update(ReceiptVO vo) {
		// TODO Auto-generated method stub
		ReceiptPO po = toPO(vo);
		ResultMessage result = ResultMessage.FAILED;
		try {
			result = receiptDataService.update(po);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public ArrayList<ReceiptVO> show() {
		// TODO Auto-generated method stub
		ArrayList<ReceiptVO> receiptVOs = new ArrayList<ReceiptVO>();
		ArrayList<ReceiptPO> receiptPOs  = null;
		try {
			receiptPOs = receiptDataService.show();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(receiptPOs == null) return null;
		for (int i = 0; i < receiptPOs.size(); i++) {
			ReceiptPO po = receiptPOs.get(i);
			receiptVOs.add(toVO(po));
		}
		return receiptVOs;
	}

	@Override
	public ReceiptVO findByID(String names) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage check(ReceiptVO vo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<ReceiptVO> findByTime(String startTime, String endTime) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<ReceiptVO> findByType(ReceiptType type) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<ReceiptVO> findByTimeAndType(String startTime, String endTime, ReceiptType type) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ReceiptVO toVO(ReceiptPO po) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ReceiptPO toPO(ReceiptVO vo) {
		// TODO Auto-generated method stub
		Receipt_OrderVO order;
		if(vo.type == ReceiptType.ORDER) {
			order = (Receipt_OrderVO)vo;
			Receipt_OrderPO po = new Receipt_OrderPO(goodsInfo.toGoodsPO(order.goods),
				order.receiveTime, order.expectTime, order.number, order.targetPlace, order.startPlace, 
				order.pushPeople, order.receivePeople, vo.time);
			return po;
		}
		return null;
	}

	@Override
	public Receipt_OrderVO toVOsimple(Receipt_OrderPO po){
		Receipt_OrderVO vo = new Receipt_OrderVO(po.getNumber(), po.getExpectTime());
		return vo;
	}
}
