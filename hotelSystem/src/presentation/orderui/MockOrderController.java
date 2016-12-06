package presentation.orderui;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

import businesslogic.orderbl.OrderController;
import vo.CalculationConditionVO;
import vo.OrderVO;

public class MockOrderController extends OrderController {

	private List<OrderVO> orderList;

	public MockOrderController() {
		// TODO Auto-generated constructor stub

		orderList = new ArrayList<OrderVO>();
		OrderVO vo1 = new OrderVO(1, "小明", 1, "18710101250", LocalDateTime.of(2016, 11, 16, 14, 00), "南大宿舍1", "大床房", 1,
				3, false, LocalDate.of(2016, 11, 18), LocalTime.of(14, 00, 00), LocalDate.of(2016, 11, 19), 233, "正常");
		OrderVO vo2 = new OrderVO(1, "小明", 1, "18710101250", LocalDateTime.of(2016, 11, 16, 14, 00), "南大宿舍2", "大床房", 1,
				3, false, LocalDate.of(2016, 11, 18), LocalTime.of(14, 00, 00), LocalDate.of(2016, 11, 19), 111, "已执行");
		OrderVO vo3 = new OrderVO(1, "小明", 1, "18710101250", LocalDateTime.of(2016, 11, 16, 14, 00), "南大宿舍1", "大床房", 1,
				3, false, LocalDate.of(2016, 11, 18), LocalTime.of(14, 00, 00), LocalDate.of(2016, 11, 19), 56, "已执行");
		OrderVO vo4 = new OrderVO(1, "小明", 1, "18710101250", LocalDateTime.of(2016, 11, 16, 14, 00), "南大宿舍2", "大床房", 1,
				3, false, LocalDate.of(2016, 11, 18), LocalTime.of(14, 00, 00), LocalDate.of(2016, 11, 19), 76, "已撤销");
		OrderVO vo5 = new OrderVO(1, "小明", 1, "18710101250", LocalDateTime.of(2016, 11, 16, 14, 00), "南大宿舍1", "大床房", 1,
				3, false, LocalDate.of(2016, 11, 18), LocalTime.of(14, 00, 00), LocalDate.of(2016, 11, 19), 234, "已撤销");
		OrderVO vo6 = new OrderVO(1, "小明", 1, "18710101250", LocalDateTime.of(2016, 11, 16, 14, 00), "南大宿舍3", "大床房", 1,
				3, false, LocalDate.of(2016, 11, 18), LocalTime.of(14, 00, 00), LocalDate.of(2016, 11, 19), 234, "异常");

		orderList.add(vo1);
		orderList.add(vo2);
		orderList.add(vo3);
		orderList.add(vo4);
		orderList.add(vo5);
		orderList.add(vo6);

	}

	@Override
	public List<OrderVO> getCustomerOrder(int customerID) {
		// TODO Auto-generated method stub
		List<OrderVO> list = new ArrayList<OrderVO>();
		for (OrderVO vo : orderList) {
			OrderVO temp = new OrderVO(vo);
			list.add(temp);
		}
		return list;
	}

	@Override
	public List<OrderVO> getHotelOrder(int hotelID) {
		// TODO Auto-generated method stub
		List<OrderVO> list = new ArrayList<OrderVO>();
		for (OrderVO vo : orderList) {
			OrderVO temp = new OrderVO(vo);
			list.add(temp);
		}
		return list;
	}

	@Override
	public List<OrderVO> getAbnormalOrdersOfToday() {
		List<OrderVO> list = new ArrayList<OrderVO>();
		for (OrderVO vo : orderList) {
			if ((vo.orderState).equals("异常")) {
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
		for (OrderVO vo : orderList) {
			if ((vo.orderState).equals(state)) {
				OrderVO temp = new OrderVO(vo);
				list.add(temp);
			}
		}
		return list;
	}

	@Override
	public List<OrderVO> filterHotelList(int hotelID, String state) {
		// TODO Auto-generated method stub
		if (state.equals("全部订单")) {
			return this.getHotelOrder(hotelID);
		}

		List<OrderVO> list = new ArrayList<OrderVO>();
		for (OrderVO vo : orderList) {
			if ((vo.orderState).equals(state)) {
				OrderVO temp = new OrderVO(vo);
				list.add(temp);
			}
		}
		return list;
	}

	@Override
	public boolean produceOrder(OrderVO vo, CalculationConditionVO calculationConditionVO) {
		// TODO Auto-generated method stub
		System.out.println("produce");
		return true;
	}

	@Override
	public boolean changeOrderState(int orderID, String state) {
		// TODO Auto-generated method stub
		OrderVO vo = orderList.get(orderID - 1);
		vo.orderState = state;
		return true;
	}

	@Override
	public int calculateTotal(CalculationConditionVO vo) {

		int result = 0;

		int days = Period.between(vo.startDate, vo.endDate).getDays();

		result = days * vo.roomNum * 100;

		return result;
	}

}
