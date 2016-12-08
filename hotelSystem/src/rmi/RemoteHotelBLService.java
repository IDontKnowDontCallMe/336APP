package rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import vo.AreaVO;
import vo.CommentVO;
import vo.HotelVO;
import vo.OrderVO;
import vo.RoomVO;
import vo.SearchConditionVO;

public interface RemoteHotelBLService extends Remote{
	public List<HotelVO> getHotelVOsOfArea(AreaVO areaVO, int customerID)  throws RemoteException;

	public List<HotelVO> search(AreaVO areaVO,SearchConditionVO searchCondionVO) throws RemoteException;
	
	public List<HotelVO> sort(int customerID, String sortType) throws RemoteException;
	
	public List<RoomVO>   getRoomListOfHotel(int hotelID) throws RemoteException;
	
	public List<OrderVO> getOrderListOfHotel(int hotelID, int customerID) throws RemoteException;
	
	public List<HotelVO> getBookedHotelList(int customerID) throws RemoteException;
	
	public List<CommentVO> getCommentList(int hotelID) throws RemoteException;
	
	public boolean updateSimpleHotelInfo(HotelVO hotelVO) throws RemoteException;
	
	public boolean addComment(CommentVO commentVO) throws RemoteException;

	public HotelVO getHotelInfo(int hotelID) throws RemoteException;

	public boolean update(HotelVO hotelVO) throws RemoteException;

	public boolean delete(HotelVO hotelVO) throws RemoteException;
}
