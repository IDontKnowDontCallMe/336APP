package businesslogicservice.orderblservice;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;
import po.OrderPO;
import presentation.orderui.CalculatingConditionVO;
import vo.CalculationConditionVO;
import vo.OrderVO;

/**
 * 
 * @author USER
 *
 */
public interface OrderBLService extends Remote{
	
	public List<OrderVO> getCustomerOrder(int customerID) throws RemoteException;
	
	public List<OrderVO> getHotelOrder(int hotelID) throws RemoteException;
	
	public List<OrderVO> getAbnormalOrdersOfToday() throws RemoteException;
	
	public List<OrderVO> filterCustomerList(int customerID, String state) throws RemoteException;
	
	public List<OrderVO> filterHotelList(int hotelID, String state) throws RemoteException;

	//public int calculateTotal() throws RemoteException;
	
	public int calculateTotal(CalculationConditionVO vo) throws RemoteException;
	
	public String canBeProduced(CalculationConditionVO vo) throws RemoteException;
	
	public boolean produceOrder(OrderVO orderVO, CalculationConditionVO calculationConditionVO) throws RemoteException;
	
	public boolean changeOrderState(int orderID, String state) throws RemoteException;
	
}
