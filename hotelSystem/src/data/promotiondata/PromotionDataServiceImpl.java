package data.promotiondata;

import java.util.List;

import businesslogic.promotionbl.LevelMethod;
import businesslogic.promotionbl.PromotionType;
import dataservice.promotiondataservice.PromotionDataService;
import po.HotelPromotionPO;
import po.WebPromotionPO;

public class PromotionDataServiceImpl implements PromotionDataService{
	
	private HotelPromotionDao hotelPromotionDao;
	private WebPromotionDao webPromotionDao;
	
	public PromotionDataServiceImpl() {
		// TODO Auto-generated constructor stub
		hotelPromotionDao = PromotionDaoFactory.getHotelPromotionDao();
		webPromotionDao = PromotionDaoFactory.getWebPromotionDao();
	}

	@Override
	public List<PromotionType> getWebPromotionObject() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean writeWebPromotionObject(WebPromotionPO po) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteWebPromotionObject(String promotionType) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public LevelMethod getWebLevelObject() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean writeWebLevelObject(LevelMethod level) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<PromotionType> getHotelPromotionObject(int hotelID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean writeHotelPromotionObject(int hotelID, HotelPromotionPO po) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteHotelPromotionObject(int hotelID, String promotionType) {
		// TODO Auto-generated method stub
		return false;
	}


}
