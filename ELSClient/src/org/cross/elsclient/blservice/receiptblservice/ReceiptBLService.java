/**
 * 单据管理服务接口
 * @author raychen
 * @date 2015/10/19
 */
package org.cross.elsclient.blservice.receiptblservice;

import java.util.ArrayList;

import org.cross.elsclient.util.ResultMessage;
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
	 * 根据名称模糊查找
	 * @param names
	 * @return
	 */
	public ArrayList<ReceiptVO> find(String names);
	
	/**
	 * 审批单据
	 * @param vo
	 * @return
	 */
	public ResultMessage check(ReceiptVO vo);
}
