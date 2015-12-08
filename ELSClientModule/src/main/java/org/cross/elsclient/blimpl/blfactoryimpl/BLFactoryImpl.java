package org.cross.elsclient.blimpl.blfactoryimpl;

import java.rmi.RemoteException;

import org.cross.elsclient.blimpl.blUtility.GoodsInfo;
import org.cross.elsclient.blimpl.blUtility.OrganizationInfo;
import org.cross.elsclient.blimpl.blUtility.PersonnelInfo;
import org.cross.elsclient.blimpl.blUtility.ReceiptInfo;
import org.cross.elsclient.blimpl.blUtility.SalaryInfo;
import org.cross.elsclient.blimpl.blUtility.StockInfo;
import org.cross.elsclient.blimpl.blUtility.UserInfo;
import org.cross.elsclient.blimpl.blUtility.VehicleInfo;
import org.cross.elsclient.blimpl.goodsblimpl.GoodsInfoImpl;
import org.cross.elsclient.blimpl.numberblimpl.NumberBLImpl;
import org.cross.elsclient.blimpl.organizationblimpl.OrganizationInfoImpl;
import org.cross.elsclient.blimpl.personnelblimpl.PersonnelInfoImpl;
import org.cross.elsclient.blimpl.receiptblimpl.ReceiptBLImpl;
import org.cross.elsclient.blimpl.receiptblimpl.ReceiptInfoImpl;
import org.cross.elsclient.blimpl.salaryblimpl.SalaryBLImpl;
import org.cross.elsclient.blimpl.stockblimpl.StockBLImpl;
import org.cross.elsclient.blimpl.stockblimpl.StockInfoImpl;
import org.cross.elsclient.blimpl.userblimpl.UserBLImpl;
import org.cross.elsclient.blimpl.userblimpl.UserInfoImpl;
import org.cross.elsclient.blimpl.vehicleblimpl.VehicleBLImpl;
import org.cross.elsclient.blimpl.vehicleblimpl.VehicleInfoImpl;
import org.cross.elsclient.blservice.accountblservice.AccountBLService;
import org.cross.elsclient.blservice.analysisblservice.AnalysisBLService;
import org.cross.elsclient.blservice.blfactoryservice.BLFactoryService;
import org.cross.elsclient.blservice.constantblservice.ConstantBLService;
import org.cross.elsclient.blservice.goodsblservice.GoodsBLService;
import org.cross.elsclient.blservice.initialblservice.InitialBLService;
import org.cross.elsclient.blservice.logblservice.LogBLService;
import org.cross.elsclient.blservice.numberblservice.NumberBLService;
import org.cross.elsclient.blservice.organizationblservice.OrganizationBLService;
import org.cross.elsclient.blservice.personnelblservice.PersonnelBLService;
import org.cross.elsclient.blservice.receiptblservice.ReceiptBLService;
import org.cross.elsclient.blservice.stockblservice.StockBLService;
import org.cross.elsclient.blservice.userblservice.UserBLService;
import org.cross.elsclient.blservice.vehicleblservice.VehicleBLService;
import org.cross.elsclient.network.Datafactory;
import org.cross.elscommon.dataservice.constantdataservice.ConstantDataService;
import org.cross.elscommon.dataservice.datafactoryservice.DataFactoryService;
import org.cross.elscommon.dataservice.goodsdataservice.GoodsDataService;
import org.cross.elscommon.dataservice.numberdataservice.NumberDataService;
import org.cross.elscommon.dataservice.organizationdataservice.OrganizationDataService;
import org.cross.elscommon.dataservice.personneldataservice.PersonnelDataService;
import org.cross.elscommon.dataservice.receiptdataservice.ReceiptDataService;
import org.cross.elscommon.dataservice.salarydataservice.SalaryDataService;
import org.cross.elscommon.dataservice.stockdataservice.StockDataService;
import org.cross.elscommon.dataservice.userdataservice.UserDataService;
import org.cross.elscommon.dataservice.vehicledataservice.VehicleDataService;

public class BLFactoryImpl implements BLFactoryService{

	DataFactoryService dataFactoryService;

	UserDataService userDataService;
	ReceiptDataService receiptDataService;
	GoodsDataService goodsDataService;
	StockDataService stockDataService;
	PersonnelDataService personnelDataService;
	OrganizationDataService organizationDataService;
	SalaryDataService salaryDataService;
	VehicleDataService vehicleDataService;
	NumberDataService numberDataService;

	UserInfoImpl userInfo;
	ReceiptInfoImpl receiptInfo;
	GoodsInfoImpl goodsInfo;
	StockInfoImpl stockInfo;
	PersonnelInfoImpl personnelInfo;
	OrganizationInfoImpl organizationInfo;
	SalaryBLImpl salaryInfo;
	VehicleInfoImpl vehicleInfo;
	
	public BLFactoryImpl() throws RemoteException{
		this.dataFactoryService = new Datafactory();
		
		this.userDataService = dataFactoryService.getuserdaData();
		this.receiptDataService = dataFactoryService.getReceiptData();
		this.goodsDataService = dataFactoryService.getGoodsData();
		this.stockDataService = dataFactoryService.getStockData();
		this.personnelDataService = dataFactoryService.getPersonnelData();
		this.organizationDataService = dataFactoryService.getOrganizationData();
		this.salaryDataService = dataFactoryService.getSalaryData();
		this.vehicleDataService = dataFactoryService.getVehicleData();
		this.numberDataService = dataFactoryService.getNumberDataService();
		
		this.userInfo = new UserInfoImpl();
		this.receiptInfo = new ReceiptInfoImpl(receiptDataService);
		this.goodsInfo = new GoodsInfoImpl(goodsDataService);
		this.stockInfo = new StockInfoImpl(stockDataService);
		this.salaryInfo = new SalaryBLImpl(salaryDataService);
		this.personnelInfo = new PersonnelInfoImpl(personnelDataService, salaryInfo);
		this.organizationInfo = new OrganizationInfoImpl(organizationDataService);
		this.vehicleInfo = new VehicleInfoImpl(vehicleDataService);
		
		this.receiptInfo.goodsInfo = this.goodsInfo;
		this.receiptInfo.personnelInfo = this.personnelInfo;
		this.receiptInfo.stockInfo = this.stockInfo;
		this.goodsInfo.receiptInfo = this.receiptInfo;
		this.personnelInfo.receiptInfo = this.receiptInfo;
		this.stockInfo.goodsInfo = this.goodsInfo;
		this.stockInfo.orgInfo = this.organizationInfo;
	}
	
	@Override
	public UserBLService getUserBLService() throws RemoteException {
		
		return new UserBLImpl(userDataService, userInfo);
	}

	@Override
	public AccountBLService getAccountBLService() throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AnalysisBLService analysisBLService() throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ConstantBLService constantBLService() throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public GoodsBLService goodsBLService() throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public InitialBLService initialBLService() throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public LogBLService logBLService() throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public OrganizationBLService organizationBLService() throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PersonnelBLService personnelBLService() throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ReceiptBLService receiptBLService() throws RemoteException {
		return new ReceiptBLImpl(this.receiptDataService, this.receiptInfo, this.goodsInfo);
	}

	@Override
	public StockBLService stockBLService() throws RemoteException {
		return new StockBLImpl(this.stockDataService, this.goodsInfo, this.stockInfo, this.receiptInfo);
	}

	@Override
	public VehicleBLService vehicleBLService() throws RemoteException {
		return new VehicleBLImpl(vehicleDataService, vehicleInfo);
	}

	@Override
	public SalaryDataService salaryDataService() throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ConstantDataService constantDataService() throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public NumberBLService numberBLService() throws RemoteException {
		return new NumberBLImpl(this.numberDataService);
	}

}
