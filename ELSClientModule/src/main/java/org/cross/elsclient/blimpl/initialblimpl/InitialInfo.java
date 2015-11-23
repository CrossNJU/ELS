package org.cross.elsclient.blimpl.initialblimpl;

import org.cross.elsclient.vo.InitialVO;
import org.cross.elscommon.po.InitialPO;

public interface InitialInfo {

	public InitialVO toInitialVO(InitialPO po);
	
	public InitialPO toInitialPO(InitialVO vo);
	
}
