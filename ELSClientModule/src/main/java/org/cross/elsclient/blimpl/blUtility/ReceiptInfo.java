package org.cross.elsclient.blimpl.blUtility;

import org.cross.elsclient.vo.ReceiptVO;
import org.cross.elsclient.vo.Receipt_OrderVO;
import org.cross.elscommon.po.ReceiptPO;
import org.cross.elscommon.po.Receipt_OrderPO;

public interface ReceiptInfo {
	public Receipt_OrderVO toVOsimple(Receipt_OrderPO po);
	public ReceiptVO toVO(ReceiptPO po);
	public ReceiptPO toPO(ReceiptVO vo);
	public ReceiptVO findByID(String ID);
}
