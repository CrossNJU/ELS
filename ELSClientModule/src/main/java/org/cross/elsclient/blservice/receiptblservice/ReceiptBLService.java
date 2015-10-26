/**
 * 单据管理服务接口
 * @author raychen
 * @date 2015/10/19
 */
package org.cross.elsclient.blservice.receiptblservice;

import java.util.ArrayList;

import org.cross.elscommon.util.ReceiptType;
import org.cross.elscommon.util.ResultMessage;
import org.cross.elsclient.vo.ReceiptVO;

public interface ReceiptBLService {
	
	/**
	 * 增加单据
	 * @param vo
	 * @return
	 */
	public ResultMessage add(ReceiptVO vo);
	
	/**
	 * 删除单据
	 * @param vo
	 * @return
	 */
	public ResultMessage delete(ReceiptVO vo);
	
	/**
	 * 更新单据信息
	 * @param vo
	 * @return
	 */
	public ResultMessage update(ReceiptVO vo);
	
	/**
	 * 显示所有单据信息
	 * @return
	 */
	public ArrayList<ReceiptVO> show();
	
	/**
	 * 根据单据编号查找
	 * @param names
	 * @return
	 */
	public ReceiptVO findByID(String names);
	
	/**
	 * 审批单据
	 * @param vo
	 * @return
	 */
	public ResultMessage check(ReceiptVO vo);
	
	/**
	 * 根据时间查找单据
	 */
	public ArrayList<ReceiptVO> findByTime(String startTime, String endTime);
	
	/**
	 * 根据类型查找单据
	 */
	public ArrayList<ReceiptVO> findByType(ReceiptType type);
	
	/**
	 * 根据时间、类型查找单据
	 */
	public ArrayList<ReceiptVO> findByTimeAndType(String startTime, String endTime, ReceiptType type);
}
