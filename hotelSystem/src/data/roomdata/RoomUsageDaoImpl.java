package data.roomdata;

import java.util.Date;
import java.util.List;

import po.UsagePO;

public class RoomUsageDaoImpl implements RoomUsageDao{

	@Override
	public List<UsagePO> getUsagePO(int roomID, Date start, Date end) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean updateUsage(int roomID, Date start, Date end, int delta) {
		// TODO Auto-generated method stub
		return false;
	}

}
