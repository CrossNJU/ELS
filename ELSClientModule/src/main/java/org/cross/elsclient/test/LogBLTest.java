package org.cross.elsclient.test;

import java.rmi.RemoteException;
import java.util.ArrayList;

import org.cross.elsclient.blimpl.logblimpl.LogBLImpl;
import org.cross.elsclient.network.Datafactory;
import org.cross.elsclient.vo.LogVO;
import org.cross.elscommon.dataservice.datafactoryservice.DataFactoryService;
import org.cross.elscommon.util.ResultMessage;

public class LogBLTest {

	public static void main(String[] args) throws RemoteException {
		DataFactoryService dataFactory = new Datafactory();
		LogBLImpl logBLImpl = new LogBLImpl(dataFactory.getlogData());

		System.out.println("test ---------- show");
		ArrayList<LogVO> show = logBLImpl.show("2015-10-1", "2015-10-2");
		for (int i = 0; i < show.size(); i++) {
			System.out.println(show.get(i).id + " " + show.get(i).operator
					+ " " + show.get(i).time);
		}
		
		System.out.println("test ---------- add");
		LogVO logVO = new LogVO("log001", "2015-10-1 19:12", "入库", "...");
		ResultMessage addMessage = logBLImpl.add(logVO);
		if (addMessage == ResultMessage.SUCCESS) {
			System.out.println("增加成功");
		}else {
			System.out.println("增加失败");
		}

	}

}
