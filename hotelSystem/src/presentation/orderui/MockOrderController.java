package presentation.orderui;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import businesslogic.orderbl.OrderBLImpl;
import businesslogic.orderbl.OrderController;
import vo.OrderVO;

public class MockOrderController extends OrderController{

	private List<OrderVO> orderList;
	
	public MockOrderController() {
		// TODO Auto-generated constructor stub
		
		SimpleDateFormat format = new SimpleDateFormat("yyyy-mm-dd");
		OrderVO vo1,vo2,vo3,vo4,vo5,vo6,vo7,vo8,vo9,vo10;
		try {
			orderList = new ArrayList<OrderVO>();
			vo1 = new OrderVO(1, "小明", 1, "18710101250", format.parse("2016-11-17") , "如家", "大床房", 1, 
					false,  format.parse("2016-11-18"), format.parse("2016-11-19"),233, "正常");
			vo2 = new OrderVO(2, "小红", 1, "18710101250",format.parse("2016-11-17") , "七天", "大床房", 1, 
					false,  format.parse("2016-11-18"), format.parse("2016-11-19"),111, "已执行");
			vo3 = new OrderVO(3, "小刚", 1, "18710101250",format.parse("2016-11-17") , "全季", "大床房", 1, 
					false,  format.parse("2016-11-18"), format.parse("2016-11-19"),56, "已执行");
			vo4 = new OrderVO(4, "小黄", 1, "18710101250",format.parse("2016-11-17") , "如家", "大床房", 1, 
					false,  format.parse("2016-11-18"), format.parse("2016-11-19"),76, "已撤销");
			vo5 = new OrderVO(5, "大黄", 1, "18710101250",format.parse("2016-11-17") , "如家", "大床房", 1, 
					false,  format.parse("2016-11-18"), format.parse("2016-11-19"),234, "已撤销");
			vo6 = new OrderVO(6, "大明", 1, "18710101250",format.parse("2016-11-17") , "如家", "大床房", 1, 
					false,  format.parse("2016-11-18"), format.parse("2016-11-19"),345, "正常");
			vo7 = new OrderVO(7, "小方", 1, "18710101250",format.parse("2016-11-17") , "如家", "大床房", 1, 
					false,  format.parse("2016-11-18"), format.parse("2016-11-19"),346, "正常");
			vo8 = new OrderVO(8, "小陈", 1, "18710101250",format.parse("2016-11-17") , "如家", "大床房", 1, 
					false,  format.parse("2016-11-18"), format.parse("2016-11-19"),120, "异常");
			vo9 = new OrderVO(9, "小章", 1, "18710101250",format.parse("2016-11-17") , "如家", "大床房", 1, 
					false,  format.parse("2016-11-18"), format.parse("2016-11-19"),200, "异常");
			vo10 = new OrderVO(10, "小强", 1, "18710101250",format.parse("2016-11-17") , "如家", "大床房", 1, 
					false,  format.parse("2016-11-18"), format.parse("2016-11-19"),100, "异常");
			orderList.add(vo1);
			orderList.add(vo2);
			orderList.add(vo3);
			orderList.add(vo4);
			orderList.add(vo5);
			orderList.add(vo6);
			orderList.add(vo7);
			orderList.add(vo8);
			orderList.add(vo9);
			orderList.add(vo10);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	@Override
	public List<OrderVO> getCustomerOrder(int customerID) {
		// TODO Auto-generated method stub
		List<OrderVO> list = new ArrayList<OrderVO>();
		for(OrderVO vo:orderList){
			OrderVO temp = new OrderVO(vo);
			list.add(temp);
		}
		return list;
	}

	@Override
	public List<OrderVO> getHotelOrder(int hotelID) {
		// TODO Auto-generated method stub
		List<OrderVO> list = new ArrayList<OrderVO>();
		for(OrderVO vo:orderList){
			OrderVO temp = new OrderVO(vo);
			list.add(temp);
		}
		return list;
	}
	
	@Override
	public List<OrderVO> getAbnormalOrdersOfToday(){
		List<OrderVO> list = new ArrayList<OrderVO>();
		for(OrderVO vo:orderList){
			if((vo.orderState).equals("异常")){
				OrderVO temp = new OrderVO(vo);
				list.add(temp);
			}
		}
		return list;
	}

	@Override
	public List<OrderVO> filterCustomerList(int userID, String state) {
		// TODO Auto-generated method stub
		if (state.equals("全部订单")) {
			return this.getCustomerOrder(userID);
		}
		
		List<OrderVO> list = new ArrayList<OrderVO>();
		for(OrderVO vo:orderList){
			if((vo.orderState).equals(state)){
				OrderVO temp = new OrderVO(vo);
				list.add(temp);
			}
		}
		return list;
	}
	
	@Override
	public List<OrderVO> filterHotelList(int hotelID, String state){
		// TODO Auto-generated method stub
		if (state.equals("全部订单")) {
			return this.getHotelOrder(hotelID);
		}
		
		List<OrderVO> list = new ArrayList<OrderVO>();
		for(OrderVO vo:orderList){
			if((vo.orderState).equals(state)){
				OrderVO temp = new OrderVO(vo);
				list.add(temp);
			}
		}
		return list;
	}

	@Override
	public boolean produceOrder(OrderVO vo) {
		// TODO Auto-generated method stub
		System.out.println("produce");
		return true;
	}

	@Override
	public boolean changeOrderState(int orderID, String state) {
		// TODO Auto-generated method stub
		OrderVO vo = orderList.get(orderID-1);
		vo.orderState = state;
		return true;
	}
		
		

	
	
}
