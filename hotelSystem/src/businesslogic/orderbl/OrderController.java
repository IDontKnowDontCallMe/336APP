package businesslogic.orderbl;

import java.rmi.RemoteException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import businesslogicservice.orderblservice.OrderBLService;
import presentation.orderui.CalculatingConditionVO;
import vo.CalculationConditionVO;
import vo.OrderVO;

public class OrderController implements OrderBLService{

	private OrderBLImpl orderBLImpl;
	
	@Override
	public List<OrderVO> getCustomerOrder(int customerID) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<OrderVO> getHotelOrder(int hotelID) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<OrderVO> getAbnormalOrdersOfToday() throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<OrderVO> filterCustomerList(int customerID, String state) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<OrderVO> filterHotelList(int hotelID, String state) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	

	@Override
	public int calculateTotal(CalculationConditionVO vo) throws RemoteException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean produceOrder(OrderVO orderVO , CalculationConditionVO calculationConditionVO) throws RemoteException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean changeOrderState(int orderID, String state) throws RemoteException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String canBeProduced(CalculationConditionVO vo) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	
	
	
	

}
