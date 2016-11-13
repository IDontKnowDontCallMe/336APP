package data.userdata;

import java.util.List;

import po.WorkerPO;

public interface HotelDao {

	public List<WorkerPO> getWorkerList();
	
	public WorkerPO getWorker(int hotelID);
	
	public boolean updateWorker(int hotelID, WorkerPO po);
	
	public int addHotel(String hotelName);
	
}
