/**
 * 人员管理数据接口
 * @author Polaris Chen
 * @date 2015/10/19
 */
package org.cross.elsclient.dataservice.personneldataservice;

import java.util.ArrayList;

import org.cross.elsclient.po.PersonnelPO;

public interface PersonnelDataService {

	public ArrayList<PersonnelPO> findById(String id);

	public ArrayList<PersonnelPO> findByName(String name);

	public void insert(PersonnelPO po);

	public void delete(PersonnelPO po);

	public void update(PersonnelPO po);

	public ArrayList<PersonnelPO> show();
}
