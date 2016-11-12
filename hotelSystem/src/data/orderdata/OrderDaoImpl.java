package data.orderdata;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

import com.sun.crypto.provider.RSACipher;

import data.databaseutility.ConnectionFactory;
import dataservice.orderdataservice.OrderDataService;
import po.OrderPO;

public class OrderDaoImpl implements OrderDao{
	
	private Connection con = null;
	private PreparedStatement pps = null;
	
	

	@Override
	public OrderPO getOrderInfo(int orderID) {
		// TODO Auto-generated method stub
		
		OrderPO po = null;
		
		try{
			con = ConnectionFactory.getDatabaseConnectionInstance();
			String sql = "SELECT * FROM ordertable WHERE orderID = ?";
			pps = con.prepareStatement(sql);
			pps.setInt(1, orderID);
			ResultSet res =  pps.executeQuery();
			
			if(res.next()){
				//int orderID = res.getInt("orderID");
				int customerID = res.getInt("customerID");
				String customerName = res.getString("customerName");
				int hotelID = res.getInt("hotelID");
				String hotelName = res.getString("hotelName");
				String roomName = res.getString("roomName");
				int roomNum = res.getInt("roomNum");
				Date producingTime = res.getDate("producingTime");
				boolean hasChildren = res.getBoolean("hasChildren");
				int peopleNum = res.getInt("peopleNum");
				Date checkInTime = res.getDate("checkInTime");
				Date checkOutTime = res.getDate("checkOutTime");
				String orderState = res.getString("orderState");
				int total = res.getInt("total");
				
				po = new OrderPO(orderID, customerName, customerID, producingTime, hotelName, hotelID, roomName,
						                roomNum, hasChildren, peopleNum, checkInTime, checkOutTime, total, orderState);
			}
			
			pps.close();
			con.close();
			
			return po;
			
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		
		return null;
	}

	@Override
	public List<OrderPO> getCustomerOrder(int customerID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<OrderPO> getHotelOrder(int hotelID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean updateOrderState(int orderID,String orderState) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean insertOrder(OrderPO po) {
		// TODO Auto-generated method stub
		return false;
	}

}
