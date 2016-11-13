package data.promotiondata;

import java.util.List;

import businesslogic.promotionbl.LevelMethod;
import businesslogic.promotionbl.Promotion;
import dataservice.promotiondataservice.PromotionDataService;

public class PromotionDataServiceImpl implements PromotionDataService{
	
	private HotelPromotionDao hotelPromotionDao;
	private WebPromotionDao webPromotionDao;
	
	public PromotionDataServiceImpl() {
		// TODO Auto-generated constructor stub
		hotelPromotionDao = PromotionDaoFactory.getHotelPromotionDao();
		webPromotionDao = PromotionDaoFactory.getWebPromotionDao();
	}

	@Override
	public List<Promotion> getWebPromotionObject() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean writeWebPromotionObject(Promotion promotion) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteWebPromotionObject(String promotionName) {
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
	public List<Promotion> getHotelPromotionObject(int hotelID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean writeHotelPromotionObject(int hotelID, Promotion promotion) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteHotelPromotionObject(int hotelID, String promotionName) {
		// TODO Auto-generated method stub
		return false;
	}

}
