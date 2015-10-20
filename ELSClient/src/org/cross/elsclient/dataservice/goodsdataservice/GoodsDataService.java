package org.cross.elsclient.dataservice.goodsdataservice;

import org.cross.elsclient.po.GoodsPO;
import org.cross.elsclient.vo.GoodsVO;

public interface GoodsDataService {
	
	public void insert(GoodsPO goods);
	
	public void delete(GoodsPO goods);
	
	public void update(GoodsPO goods);
	
	public GoodsVO require(String id);

}
