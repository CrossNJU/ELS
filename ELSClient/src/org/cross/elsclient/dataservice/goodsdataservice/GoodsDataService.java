/**
 * 快件管理数据接口
 * @author danni
 * @date 2015/10/22
 */
package org.cross.elsclient.dataservice.goodsdataservice;

import java.rmi.RemoteException;

import org.cross.elsclient.po.GoodsPO;
import org.cross.elsclient.vo.GoodsVO;

public interface GoodsDataService {
	
	public void update(GoodsPO goods) throws RemoteException;
	
	public GoodsPO show(String id)throws RemoteException;

}
