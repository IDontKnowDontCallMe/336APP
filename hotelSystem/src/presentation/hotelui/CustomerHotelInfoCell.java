package presentation.hotelui;

import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import vo.OrderVO;

public class CustomerHotelInfoCell extends GridPane {

	OrderVO orderVO;

	Text hotelText;
	Text roomText;
	Text checkInText;
	Text checkOutText;
	Text numText;
	Text childrenText;
	Text totalText;
	Text stateText;

	public CustomerHotelInfoCell(OrderVO orderVO) {
		super();
		this.orderVO = orderVO;

		hotelText = new Text(orderVO.hotelName);
		this.add(hotelText, 0, 0, 3, 1);
		stateText = new Text(orderVO.orderState);
		this.add(stateText, 4, 0, 1, 1);
		roomText = new Text(orderVO.roomName);
		this.add(roomText, 0, 1, 2, 1);
		totalText = new Text("¥" + String.valueOf(orderVO.total));
		this.add(totalText, 4, 1, 1, 1);
		checkInText = new Text("入 " + orderVO.checkInTime.toString());
		this.add(checkInText, 0, 2, 1, 1);
		checkOutText = new Text("离" + orderVO.checkOutTime.toString());
		this.add(checkOutText, 1, 2, 1, 1);
		numText = new Text(String.valueOf(orderVO.roomNum) + "间");
		this.add(numText, 1, 1, 1, 1);
		childrenText = new Text(orderVO.hasChildren ? "有" : "无" + "儿童");
		this.add(childrenText, 2, 1, 1, 1);

		this.setHgap(10);
		this.setVgap(20);

	}

}
