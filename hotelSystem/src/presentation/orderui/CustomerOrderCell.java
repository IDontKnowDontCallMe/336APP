package presentation.orderui;

import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import vo.OrderVO;

public class CustomerOrderCell extends GridPane {

	OrderVO orderVO;

	Text hotelText;
	Text roomText;
	Text checkInText;
	Text checkOutText;
	Text numText;
	Text childrenText;
	Text totalText;
	Text stateText;
	Text revokeText;
	Button button;

	public CustomerOrderCell(OrderVO orderVO) {
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

		if (orderVO.orderState.equals("正常")) {
			button = new Button("撤销");
			button.addEventHandler(MouseEvent.MOUSE_CLICKED, (MouseEvent e) -> {
				this.getChildren().remove(button);
				revokeText = new Text("已撤销");
				this.add(revokeText, 4, 2, 1, 1);
				// 修改bl层的订单状态

				System.out.println("revoke");
			});
		} else if (orderVO.orderState.equals("已执行")) {
			button = new Button("评价");
			button.addEventHandler(MouseEvent.MOUSE_CLICKED, (MouseEvent e) -> {
				CommentDialog commentDialog = new CommentDialog(orderVO);
				commentDialog.show();
				System.out.println("comment");
			});

		} else {
			button = null;
		}

		if (button != null) {
			this.add(button, 4, 2, 1, 1);
		}

		this.setHgap(10);
		this.setVgap(20);

	}

}
