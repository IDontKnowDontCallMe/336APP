package presentation.hotelui;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import businesslogic.orderbl.OrderController;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import presentation.orderui.CustomerOrderCell;
import presentation.orderui.MockOrderController;
import vo.HotelVO;
import vo.OrderVO;

public class CustomerHotelInfoPane extends GridPane {

	private int hotelID;
	private int customerID;
	private GridPane infoPane;
	private ScrollPane orderPane;
	private ScrollPane commentPane;
	private ScrollPane roomPane;

	private Button backButton;
	private VBox orderBox;

	// 地址、简介、设施服务、客房类型、各房型价格
	// 该客户在该酒店的订单(正常订单、异常订单和撤销订单要分别标记)

	private Text hotelNameText;
	private Text addressText;
	private Text introductionText;
	private Text serviceText;
	private Text roomTypeText;
	private Text priceText;

	HotelVO vo;

	public CustomerHotelInfoPane(int hotelID, int customerID) throws RemoteException {
		super();
		this.setHgap(10);
		this.setVgap(20);

		this.hotelID = hotelID;
		this.customerID = customerID;

		vo = MockHotelController.getInstance().getHotelInfo(hotelID);
		String hotelName = vo.hotelName;

		initInfoPane();
		initOrderPane(customerID, hotelName);
		initCommentPane();
		initRoomPane();
		this.add(infoPane, 0, 0, 1, 1);
		this.add(orderPane, 1, 1, 1, 1);
		this.add(commentPane, 0, 1, 1, 1);
		this.add(roomPane, 1, 0, 1, 1);
	}

	private void initRoomPane() {
		roomPane = new ScrollPane();

	}

	private void initCommentPane() {
		commentPane = new ScrollPane();

	}

	private void initInfoPane() {
		infoPane = new GridPane();

		infoPane.setHgap(10);
		infoPane.setVgap(20);
		// 地址、简介、设施服务、客房类型、各房型价格、
		// 该客户在该酒店的订单(正常订单、异常订单和撤销订单要分别标记)

		infoPane.add(new Text("酒店名称"), 0, 0, 1, 1);
		hotelNameText = new Text(vo.hotelName);
		infoPane.add(hotelNameText, 1, 0, 1, 1);

		infoPane.add(new Text("酒店地址"), 0, 1, 1, 1);
		addressText = new Text(vo.address);
		infoPane.add(addressText, 1, 1, 1, 1);

		infoPane.add(new Text("酒店简介"), 0, 2, 1, 1);
		introductionText = new Text(vo.service);
		infoPane.add(introductionText, 1, 2, 1, 1);

		infoPane.add(new Text("设施服务"), 0, 3, 1, 1);
		serviceText = new Text(vo.service);
		infoPane.add(serviceText, 1, 3, 1, 1);

	}

	private void initOrderPane(int customerID, String hotelName) throws RemoteException {

		OrderController controller = new MockOrderController();
		List<OrderVO> orderList = controller.getCustomerOrder(customerID);
		List<OrderVO> hotelOrderList = new ArrayList<OrderVO>();
		for (OrderVO order : orderList) {
			if (order.hotelName.equals(hotelName)) {
				hotelOrderList.add(order);
			}
		}

		orderBox = new VBox();
		orderBox.setSpacing(15);
		buildOrderBox(hotelOrderList);

		orderPane = new ScrollPane(orderBox);

	}

	private void buildOrderBox(List<OrderVO> orderList) {
		orderBox.getChildren().clear();
		for (OrderVO vo : orderList) {
			orderBox.getChildren().add(new CustomerHotelInfoCell(vo));
		}
	}
}