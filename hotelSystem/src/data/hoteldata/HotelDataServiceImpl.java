package data.hoteldata;

import java.util.List;

import dataservice.hoteldataservice.HotelDataService;
import po.CommentPO;
import po.HotelPO;

public class HotelDataServiceImpl implements HotelDataService{
	
	private HotelInfoDao hotelInfoDao;
	
	public HotelDataServiceImpl() {
		// TODO Auto-generated constructor stub
		hotelInfoDao = HotelDaoFactory.getHotelInfoDao();
	}

	@Override
	public List<HotelPO> getHotelList(String city, String businessCircle) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean addComment(CommentPO po) {
		// TODO Auto-generated method stub
		return false;
	}

}
