/**
 * 车辆管理数据接口
 * @author raychen
 * @date 2015/10/19
 */
package org.cross.elscommon.dataservice.vehicledataservice;

import java.rmi.RemoteException;
import java.util.ArrayList;

import org.cross.elscommon.po.VehiclePO;

public interface VehicleDataService {
	public void insert(VehiclePO po) throws RemoteException;
	public void delete(VehiclePO po) throws RemoteException;
	public void update(VehiclePO po) throws RemoteException;
	public ArrayList<VehiclePO> show() throws RemoteException;
	public ArrayList<VehiclePO> find(String name) throws RemoteException;
}
