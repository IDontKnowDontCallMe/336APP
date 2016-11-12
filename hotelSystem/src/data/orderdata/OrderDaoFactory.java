package data.orderdata;

public class OrderDaoFactory {
	
	private static OrderDao orderDao = null;
	
	public static OrderDao getOrderDaoInstance(){
		if(orderDao==null){
			orderDao = new OrderDaoImpl();
		}
		return orderDao;
	}

}
