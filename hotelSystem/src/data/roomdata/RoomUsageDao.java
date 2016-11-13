package data.roomdata;

import java.util.Date;
import java.util.List;

import po.UsagePO;

public interface RoomUsageDao {

	public List<UsagePO> getUsagePO(int roomID, Date start, Date end);
	
	public boolean updateUsage(int roomID, Date start, Date end, int delta);
	
}
