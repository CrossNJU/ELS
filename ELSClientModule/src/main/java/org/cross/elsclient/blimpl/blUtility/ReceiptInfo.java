package org.cross.elsclient.blimpl.blUtility;

import java.rmi.RemoteException;

import org.cross.elsclient.vo.ReceiptVO;
import org.cross.elsclient.vo.Receipt_OrderVO;
import org.cross.elscommon.po.ReceiptPO;
import org.cross.elscommon.util.ReceiptType;

public interface ReceiptInfo {
	public ReceiptVO toVO(ReceiptPO po);
	public ReceiptPO toPO(ReceiptVO vo);
	/**
	 * 根据单据编号查找
	 * @param names
	 * @return
	 * @throws RemoteException 
	 */
	public ReceiptVO findByID(String names) throws RemoteException;
	
	public Receipt_OrderVO findByMoneyin(String moneyinNum) throws RemoteException;
	
	public ReceiptVO findByTimeAndType(ReceiptType type, String start, String end) throws RemoteException;
	
	
}
