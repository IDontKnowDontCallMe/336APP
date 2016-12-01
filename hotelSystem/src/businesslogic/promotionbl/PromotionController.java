package businesslogic.promotionbl;

import java.rmi.RemoteException;
import java.util.List;

import businesslogicservice.promotionblservice.PromotionBLService;
import vo.CalculationConditionVO;
import vo.CustomerVO;
import vo.HotelPromotionVO;
import vo.LevelVO;
import vo.WebPromotionVO;

public class PromotionController implements PromotionBLService{
	
	private PromotionBLImpl promotionBLImpl;
	private LevelImpl levelImpl;

	@Override
	public List<HotelPromotionVO> getHotelPromotionList(int hotelID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean addHotelPromotion(HotelPromotionVO vo) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateHotelPromotion(HotelPromotionVO vo) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteHotelPromotion(HotelPromotionVO vo) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<WebPromotionVO> getWebPromotionList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean addWebPromotion(WebPromotionVO vo) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateWebPromotion(WebPromotionVO vo) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteWebPromotion(WebPromotionVO webPromotionVO) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public LevelVO getLevelMethod() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int calculateLevel(int credit) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean setLevelMethod(LevelVO levelVO) throws RemoteException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateLevelInfo(LevelVO levelVO) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int calculateOrder(CalculationConditionVO calculationConditionVO, CustomerVO customerVO) throws RemoteException {
		// TODO Auto-generated method stub
		return 0;
	}

}
