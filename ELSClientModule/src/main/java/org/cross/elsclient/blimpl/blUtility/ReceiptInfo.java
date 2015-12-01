package org.cross.elsclient.blimpl.blUtility;

import java.rmi.RemoteException;

import org.cross.elsclient.vo.ReceiptVO;
import org.cross.elscommon.po.ReceiptPO;

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
}
