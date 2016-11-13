package dataservice.hoteldataservice;

import java.util.List;

import po.CommentPO;
import po.HotelPO;

public interface HotelDataService {
	
	public List<HotelPO> getHotelList(String city, String businessCircle);
	
	public boolean addComment(CommentPO po);

}
