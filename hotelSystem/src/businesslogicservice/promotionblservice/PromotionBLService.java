package businesslogicservice.promotionblservice;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import po.OrderPO;
import vo.HotelPromotionVO;
import vo.LevelVO;
import vo.WebPromotionVO;

public interface PromotionBLService extends Remote{
	
	
	public List<HotelPromotionVO> getHotelPromotionList(int hotelID) throws RemoteException;
	
	public boolean addHotelPromotion(HotelPromotionVO vo) throws RemoteException;
	
	public boolean updateHotelPromotion(HotelPromotionVO vo) throws RemoteException;
	
	public boolean deleteHotelPromotion(int hotelID, String promotionName) throws RemoteException;
	
	public List<WebPromotionVO> getWebPromotionList() throws RemoteException;
	
	public boolean addWebPromotion(WebPromotionVO vo) throws RemoteException;
	
	public boolean updateWebPromotion(WebPromotionVO vo) throws RemoteException;
	
	public boolean deleteWebPromotion(String promotionName) throws RemoteException;
	
	public boolean setLevelMethod(LevelVO vo) throws RemoteException;
	
	public LevelVO getLevelMethod() throws RemoteException;
	
	
	
	public int calculateOrder(OrderPO po) throws RemoteException;
	
	public int calculateLevel(int credit) throws RemoteException;
	

}
