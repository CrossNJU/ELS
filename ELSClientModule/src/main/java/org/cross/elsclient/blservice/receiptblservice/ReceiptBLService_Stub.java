/**
 * 单据服务桩程序
 * @author raychen
 * @date 2015/10/20
 */
package org.cross.elsclient.blservice.receiptblservice;

import java.util.ArrayList;

import org.cross.elscommon.util.OrganizationType;
import org.cross.elscommon.util.PositionType;
import org.cross.elscommon.util.ResultMessage;
import org.cross.elscommon.util.ReceiptType;
import org.cross.elsclient.blimpl.receiptblimpl.Receipt_MoneyIn;
import org.cross.elsclient.vo.PersonnelVO;
import org.cross.elsclient.vo.ReceiptVO;
import org.cross.elsclient.vo.Receipt_MoneyInVO;

public class ReceiptBLService_Stub implements ReceiptBLService{

	@Override
	public ResultMessage add(ReceiptVO vo) {
		// TODO Auto-generated method stub
		return ResultMessage.SUCCESS;
	}

	@Override
	public ResultMessage delete(ReceiptVO vo) {
		// TODO Auto-generated method stub
		if (vo.number == "R120151023000001") {
			return ResultMessage.SUCCESS;
		}else return ResultMessage.FAILED;
	}

	@Override
	public ResultMessage update(ReceiptVO vo) {
		// TODO Auto-generated method stub
		if (vo.number == "R120151023000001") {
			return ResultMessage.SUCCESS;
		}else return ResultMessage.FAILED;
	}

	@Override
	public ArrayList<ReceiptVO> show() {
		// TODO Auto-generated method stub
		ArrayList<ReceiptVO> list = new ArrayList<ReceiptVO>();
		list.add(new ReceiptVO("R120151023000001", ReceiptType.ORDER, "2015-10-22 10:23:22"));
		list.add(new ReceiptVO("R120151023000002", ReceiptType.ORDER, "2015-10-23 10:23:22"));
		return list;
	}

	@Override
	public ReceiptVO findByID(String names) {
		// TODO Auto-generated method stub
		ReceiptVO receipt = new ReceiptVO("R120151023000001", ReceiptType.ORDER, "2015-10-22 10:23:22");
		return receipt;
	}

	@Override
	public ResultMessage check(ReceiptVO vo) {
		// TODO Auto-generated method stub
		return ResultMessage.SUCCESS;
	}

	@Override
	public ArrayList<ReceiptVO> findByTime(String startTime, String endTime) {
		// TODO Auto-generated method stub
		ArrayList<ReceiptVO> list = new ArrayList<ReceiptVO>();
		list.add(new ReceiptVO("R120151023000001", ReceiptType.ORDER, "2015-10-22 10:23:22"));
		return list;
	}

	@Override
	public ArrayList<ReceiptVO> findByType(ReceiptType type) {
		// TODO Auto-generated method stub
		ArrayList<ReceiptVO> list = new ArrayList<ReceiptVO>();
		if(type == ReceiptType.MONEYIN){
			PersonnelVO person = new PersonnelVO("111", "学睿", PositionType.ADMINISTRATOR, OrganizationType.BUSINESSHALL, "111111");
			list.add((ReceiptVO)new Receipt_MoneyInVO("2015-10-22 10:23:22", 2000.0, person, "R120151023000001"));
		}else{
			list.add(new ReceiptVO("R120151023000001", ReceiptType.ORDER, "2015-10-22 10:23:22"));
		}
		return list;
	}

	@Override
	public ArrayList<ReceiptVO> findByTimeAndType(String startTime, String endTime, ReceiptType type) {
		// TODO Auto-generated method stub
		ArrayList<ReceiptVO> list = new ArrayList<ReceiptVO>();
		list.add(new ReceiptVO("R120151023000001", ReceiptType.ORDER, "2015-10-22 10:23:22"));
		return list;
	}

}
