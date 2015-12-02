package org.cross.elsclient.blimpl.receiptblimpl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import org.cross.elscommon.dataservice.receiptdataservice.ReceiptDataService;
import org.cross.elscommon.po.ReceiptPO;
import org.cross.elscommon.po.Receipt_ArrivePO;
import org.cross.elscommon.po.Receipt_OrderPO;
import org.cross.elscommon.po.Receipt_TransPO;
import org.cross.elscommon.util.ApproveType;
import org.cross.elscommon.util.ReceiptType;
import org.cross.elscommon.util.ResultMessage;
import org.cross.elsclient.blimpl.blUtility.GoodsInfo;
import org.cross.elsclient.blimpl.blUtility.ReceiptInfo;
import org.cross.elsclient.blservice.receiptblservice.ReceiptBLService;
import org.cross.elsclient.vo.ReceiptVO;

public class ReceiptBLImpl implements ReceiptBLService{
	
	ReceiptDataService receiptdata;
	ReceiptInfo receiptInfo;
	
	GoodsInfo goodsInfo;
	
	public ReceiptBLImpl(ReceiptDataService receiptdata, ReceiptInfo receiptInfo, GoodsInfo goodsInfo){
		this.receiptdata = receiptdata;
		this.receiptInfo = receiptInfo;
		
		this.goodsInfo = goodsInfo;
	}
	
	@Override
	public ResultMessage add(ReceiptVO vo) throws RemoteException {
		ReceiptPO po = receiptInfo.toPO(vo);
		if(receiptdata.insert(po) == ResultMessage.FAILED) return ResultMessage.FAILED;
		switch (vo.type) {
		//如果是订单，则更新对应goods的orderNum，生成goodspo应在ui层调用goodsbl进行
		case ORDER:
			Receipt_OrderPO order = (Receipt_OrderPO)po;
			goodsInfo.addToOrder(order.getGoodsNum(), order.getNumber());
			break;
		//到达单，更新goods
		case ARRIVE:
			Receipt_ArrivePO arri = (Receipt_ArrivePO)po;
			ArrayList<String> argoodslist = arri.getGoodslist();
			for (int i = 0; i < argoodslist.size(); i++) {
				goodsInfo.addToArri(argoodslist.get(i), arri.getNumber());
			}
			break;
		//转运单，更新goods
		case TRANS:
			Receipt_TransPO trans = (Receipt_TransPO)po;
			ArrayList<String> trgoodslist = trans.getOrders();
			for (int i = 0; i < trgoodslist.size(); i++) {
				goodsInfo.addToArri(trgoodslist.get(i), trans.getNumber());
			}
			break;
		default:
			break;
		}
		return ResultMessage.SUCCESS;
	}

	@Override
	public ResultMessage delete(String number,ReceiptType type) throws RemoteException {
		return receiptdata.delete(number,type);
	}

	@Override
	public ResultMessage update(ReceiptVO vo) throws RemoteException {
		return receiptdata.update(receiptInfo.toPO(vo));
	}

	@Override
	public ArrayList<ReceiptVO> show() throws RemoteException {
		ArrayList<ReceiptVO> vos = new ArrayList<ReceiptVO>();
		ArrayList<ReceiptPO> list = receiptdata.show();
		for (int i = 0; i < list.size(); i++) {
			ReceiptVO vo = receiptInfo.toVO(list.get(i));
			vos.add(vo);
		}
		return vos;
	}

	@Override
	public ReceiptVO findByID(String names) throws RemoteException {
		ReceiptPO po = receiptdata.findByNum(names);
		return receiptInfo.toVO(po);
	}

	@Override
	public ResultMessage check(ReceiptVO vo, ApproveType approveState) throws RemoteException {
		return receiptdata.updateCheck(vo.number, approveState.toString());
	}

	@Override
	public ArrayList<ReceiptVO> findByTime(String startTime, String endTime) throws RemoteException {
		ArrayList<ReceiptPO> po = receiptdata.findByTime(startTime, endTime);
		ArrayList<ReceiptVO> vo = new ArrayList<ReceiptVO>();
		if (po == null) {
			return null;
		}else {
			int size = po.size();
			for (int i = 0; i < size; i++) {
				vo.add(receiptInfo.toVO(po.get(i)));
			}
		}
		return vo;
	}

	@Override
	public ArrayList<ReceiptVO> findByType(ReceiptType type) throws RemoteException {
		ArrayList<ReceiptPO> po = receiptdata.findByType(type);
		ArrayList<ReceiptVO> vo = new ArrayList<ReceiptVO>();
		if (po == null) {
			return null;
		}else {
			int size = po.size();
			for (int i = 0; i < size; i++) {
				vo.add(receiptInfo.toVO(po.get(i)));
			}
		}
		return vo;
	}

	@Override
	public ArrayList<ReceiptVO> findByTimeAndType(String startTime, String endTime, ReceiptType type) throws RemoteException {
		ArrayList<ReceiptPO> po = receiptdata.findByTimeAndType(startTime, endTime, type);
		ArrayList<ReceiptVO> vo = new ArrayList<ReceiptVO>();
		if (po == null) {
			return null;
		}else {
			int size = po.size();
			for (int i = 0; i < size; i++) {
				vo.add(receiptInfo.toVO(po.get(i)));
			}
		}
		return vo;
	}

	@Override
	public ArrayList<ReceiptVO> findByUser(String userId)
			throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<ReceiptVO> findByOrgan(String organId)
			throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}
	
}
