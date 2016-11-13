package data.hoteldata;

import java.util.List;

import po.CommentPO;
import po.HotelPO;

public interface HotelInfoDao {

	public List<HotelPO> getHotelList(String city, String businessCircle);
	
	public boolean addComment(CommentPO po);
	
}
