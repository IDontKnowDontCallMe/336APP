package presentation.hotelui;

import javafx.scene.control.ScrollPane;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import vo.HotelVO;

public class CustomerHotelInfoPane extends GridPane {

	private int hotelID;
	private GridPane infoPane;
	private ScrollPane listPane;

	// 地址、简介、设施服务、客房类型、各房型价格
	// 该客户在该酒店的订单(正常订单、异常订单和撤销订单要分别标记)

	private Text hotelNameText;
	private Text addressText;
	private Text introductionText;
	private Text service;
	private Text roomType;
	private Text price;

	public CustomerHotelInfoPane(int hotelID) {
		super();
		this.hotelID = hotelID;

		initInfoPane();
		initListList();
		this.add(infoPane, 0, 0, 1, 1);
		this.add(listPane, 0, 1, 2, 1);

	}

	private void initInfoPane() {
		HotelVO vo = MockHotelController.getInstance().getHotelInfo(hotelID);
		infoPane = new GridPane();

		// 地址、简介、设施服务、客房类型、各房型
		// 价格、该客户在该酒店的订单(正常订单、异常订单和撤销订单要分别标记)

		infoPane.add(new Text("酒店名称"), 0, 0, 1, 1);
		hotelNameText = new Text(vo.hotelName);
		infoPane.add(hotelNameText, 1, 0, 1, 1);
	}

	private void initListList() {
		// TODO Auto-generated method stub

	}
}