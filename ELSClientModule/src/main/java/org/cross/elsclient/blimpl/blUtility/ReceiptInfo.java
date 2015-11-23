package org.cross.elsclient.blimpl.blUtility;

import org.cross.elsclient.vo.ReceiptVO;
import org.cross.elscommon.po.ReceiptPO;

public interface ReceiptInfo {
	public ReceiptVO toVO(ReceiptPO po);
	public ReceiptPO toPO(ReceiptVO vo);
	public ReceiptVO findByID(String ID);
}
