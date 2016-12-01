package businesslogicservice.promotionblservice;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import vo.CalculationConditionVO;
import vo.CustomerVO;
import vo.HotelPromotionVO;
import vo.LevelVO;
import vo.WebPromotionVO;

public interface PromotionBLService extends Remote{
	
	
	public List<HotelPromotionVO> getHotelPromotionList(int hotelID) throws RemoteException;
	
	public boolean addHotelPromotion(HotelPromotionVO hotelPromotionVO) throws RemoteException;
	
	public boolean updateHotelPromotion(HotelPromotionVO hotelPromotionVO) throws RemoteException;
	
	public boolean deleteHotelPromotion(HotelPromotionVO vo) throws RemoteException;
	
	public List<WebPromotionVO> getWebPromotionList() throws RemoteException;
	
	public boolean addWebPromotion(WebPromotionVO webPromotionVO) throws RemoteException;
	
	public boolean updateWebPromotion(WebPromotionVO webPromotionVO) throws RemoteException;
	
	public boolean deleteWebPromotion(WebPromotionVO webPromotionVO) throws RemoteException;
	
	public boolean setLevelMethod(LevelVO levelVO) throws RemoteException;
	
	public LevelVO getLevelMethod() throws RemoteException;
	
	public boolean updateLevelInfo(LevelVO levelVO);
	
	public int calculateOrder(CalculationConditionVO calculationConditionVO, CustomerVO customerVO) throws RemoteException;
	
	public int calculateLevel(int credit) throws RemoteException;
	

}
