package dataservice.userdataservice;

import java.util.List;

import po.CustomerPO;
import po.MarketerPO;
import po.WorkerPO;

public interface UserDataService {
	
	public List<CustomerPO> getCustomerList();
	
	public CustomerPO getCustomer(int customerID);
	
	public boolean updateCustomer(int customerID, CustomerPO po);
	
	public List<WorkerPO> getWorkerList();
	
	public WorkerPO getWorker(int hotelID);
	
	public boolean updateWorker(int hotelID, WorkerPO po);
	
	public int addHotel(String hotelName);
	
	public int addMarketer(MarketerPO po);
	
	public List<MarketerPO> getMarketerList();
	
	public MarketerPO getMarketer(int MarketerID);
	
	public boolean updateMarketer(MarketerPO po);

}
