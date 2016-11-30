package businesslogic.orderbl;

import java.time.LocalDate;
import java.util.List;

import businesslogic.factory.BLFactory;
import po.OrderPO;
import vo.CalculationConditionVO;
import vo.CustomerVO;
import vo.RoomVO;

public class ValidOrderJudger {

	private int roomID;
	private int customerID;
	private LocalDate checkInDate;
	private LocalDate checkOutDate;
	private int num;
	private List<OrderPO> orderPOs;
	
	public ValidOrderJudger(CalculationConditionVO calculationConditionVO, List<OrderPO> orderPOs ) {
		// TODO Auto-generated constructor stub
		this.roomID = calculationConditionVO.roomID;
		this.customerID = calculationConditionVO.customerID;
		this.checkInDate = calculationConditionVO.startDate;
		this.checkOutDate = calculationConditionVO.endDate;
		this.num = calculationConditionVO.roomNum;
		this.orderPOs = orderPOs;
	}
	
	public String judge(){
		if(! creditIsValid()){
			return "信用值小于0";
		}
		
		if(roomNumIsValid()){
			return "房间充足";
		}
		else{
			return "房间不足";
		}
	}
	
	private boolean creditIsValid(){
		CustomerVO customerVO = BLFactory.getCustomerBLService().getCustomerInfo(customerID);
		
		if(customerVO.credit > 0){
			return true;
		}
		else{
			return false;
		}
	}
	
	private boolean roomNumIsValid(){
		RoomVO roomVO = BLFactory.getRoomBLService().getRoomType(roomID);
		
		int maxRoomNum = roomVO.numOfRoom;
		
		for(LocalDate i = checkInDate; i.isBefore(checkOutDate); i.plusDays(1)){
			int usedRoomNum = 0;
			for(OrderPO po: orderPOs){
				if(isUsed(po, roomVO) && inDateInterval(po, i)){
					usedRoomNum += po.getRoomNum();
				}
			}
			if(maxRoomNum - usedRoomNum < num){
				return false;
			}
		}
		
		return true;
	}
	
	private boolean isUsed(OrderPO orderPO ,RoomVO roomVO){
		return orderPO.getRoomName().equals(roomVO.roomName) && 
				(orderPO.getOrderState().equals("正常") || (orderPO.getOrderState().equals("已执行"))&&orderPO.getLeavingDateTime()==null);
	}
	
	private boolean inDateInterval(OrderPO po, LocalDate date){
		return (po.getCheckInDate().isBefore(date) || po.getCheckInDate().isEqual(date)) && po.getCheckOutDate().isAfter(date);
	}
	
}
