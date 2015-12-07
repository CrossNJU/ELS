package org.cross.elsclient.ui.counterui.initial;

import org.cross.elsclient.vo.InitialVO;

public class InitialInfoTable extends InitialManageTable{
	InitialVO vo;
	
	public InitialInfoTable(String []name,int[] itemWidth,InitialVO vo) {
		super(name, itemWidth);
		this.vo = vo;
	}
	
	@Override
	public void init() {
		super.init();
		isUpdateAndDelete = false;
	}
	
	@Override
	public void refresh() {
		removeAll();
		init();
		String item[] = {vo.id,vo.initialName,vo.time};
		addItemLabel(item);
	}
	
//	@Override
//	public void addItemLabel(String[] item) {
//		super.addItemLabel(item);
//	}
	
}
