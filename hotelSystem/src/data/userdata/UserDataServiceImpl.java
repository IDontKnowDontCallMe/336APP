package data.userdata;

import java.util.List;

import dataservice.userdataservice.UserDataService;
import po.CustomerPO;
import po.MarketerPO;
import po.WorkerPO;

public class UserDataServiceImpl implements UserDataService{
	
	private CustomerDao customerDao;
	private HotelDao hotelDao;
	private MarketerDao marketerDao;
	
	public UserDataServiceImpl() {
		// TODO Auto-generated constructor stub
		customerDao = UserDaoFactory.getCustomerDao();
		hotelDao = UserDaoFactory.getHotelDao();
		marketerDao = UserDaoFactory.getMarketerDao();
	}

	@Override
	public List<CustomerPO> getCustomerList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CustomerPO getCustomer(int customerID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean updateCustomer(int customerID, CustomerPO po) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<WorkerPO> getWorkerList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public WorkerPO getWorker(int hotelID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean updateWorker(int hotelID, WorkerPO po) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int addHotel(String hotelName) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int addMarketer(MarketerPO po) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<MarketerPO> getMarketerList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MarketerPO getMarketer(int MarketerID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean updateMarketer(MarketerPO po) {
		// TODO Auto-generated method stub
		return false;
	}

}
