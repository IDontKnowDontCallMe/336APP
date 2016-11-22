import static org.junit.Assert.*;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;

import businesslogic.orderbl.OrderBLImpl;
import businesslogic.orderbl.OrderController;
import data.roomdata.RoomDataServiceImpl;
import po.CustomerPO;
import po.OrderPO;
import po.RoomPO;

public class CalculatorTest {

	OrderBLImpl orderbl;
	OrderController controller;
	MockCalculator mockCalculator;
	OrderPO orderpo;
	CustomerPO customerpo;
	Date start=null;
	Date end=null;
	
	@Before
	public void setUp(){
		orderbl = new OrderBLImpl();
		mockCalculator = new MockCalculator();
		orderbl.setCalculator(mockCalculator);
		orderpo = new OrderPO(123, "liuqin", 321, start, "" , 1234, "单人房", 2, false, 3, start, end, 1, "正常", end);
		customerpo = new CustomerPO("liuqin", "123", "VIP", "1949", "NJU", 100, 3);
	}	

	@Test
	public void testOrderPrice() {
		
		assertEquals(200,orderbl.getOrderPrice(orderpo, customerpo));
	}
	
	@Test
	public void testproduceOrder() {
		assertEquals(false, orderbl.produceOrder(customerpo));
	}
	


}
