package businesslogicservice.promotionblservice;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import po.CustomerPO;
import vo.HotelPromotionVO;
import vo.LevelVO;
import po.OrderPO;
import vo.WebPromotionVO;

public interface PromotionBLService extends Remote{
	
	
	public List<HotelPromotionVO> getHotelPromotionList(int hotelID) throws RemoteException;
	
	public boolean addHotelPromotion(HotelPromotionVO hotelPromotionVO) throws RemoteException;
	
	public boolean updateHotelPromotion(HotelPromotionVO hotelPromotionVO) throws RemoteException;
	
	public boolean deleteHotelPromotion(int hotelID, String promotionName) throws RemoteException;
	
	public List<WebPromotionVO> getWebPromotionList() throws RemoteException;
	
	public boolean addWebPromotion(WebPromotionVO webPromotionVO) throws RemoteException;
	
	public boolean updateWebPromotion(WebPromotionVO webPromotionVO) throws RemoteException;
	
	public boolean deleteWebPromotion(String promotionName) throws RemoteException;
	
	public boolean setLevelMethod(LevelVO levelVO) throws RemoteException;
	
	public LevelVO getLevelMethod() throws RemoteException;
	
	
	
	public int calculateOrder(OrderPO orderPO, CustomerPO customerPO) throws RemoteException;
	
	public int calculateLevel(int credit) throws RemoteException;

	boolean updateLevelInfo(LevelVO levelVO);
	

}
