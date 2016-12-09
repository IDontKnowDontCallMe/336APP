package presentation.hotelui;

import java.rmi.RemoteException;
import java.util.List;

import bussinesslogic.factory.BLFactory;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import presentation.mainui.TheMainFrame;
import presentation.orderui.ProducingOrderDialog;
import vo.HotelVO;
import vo.RoomVO;

public class HotelListPane extends ScrollPane {

	private int customerID;

	public HotelListPane(List<HotelVO> hotelList, int customerID) throws RemoteException {
		super();
		this.customerID = customerID;

		VBox vBox = new VBox();
		vBox.setSpacing(20);
		this.setContent(vBox);

		for (HotelVO vo : hotelList) {
			vBox.getChildren().add(new SimpleHotelCell(vo));
		}
	}

	public class SimpleHotelCell extends GridPane {

		private HotelVO hotelVO;

		private Button produceButton;
		private Button detailedButton;

		public SimpleHotelCell(HotelVO hotelVO) throws RemoteException {
			super();
			this.hotelVO = hotelVO;

			this.setHgap(10);
			this.setVgap(20);

			this.add(new Text(hotelVO.hotelName), 1, 0, 1, 1);
			this.add(new Text(String.valueOf(hotelVO.commentScore) + "分"), 2, 0, 1, 1);
			this.add(new Text(String.valueOf(hotelVO.bookedTag)), 4, 1, 1, 1);
			this.add(new Text(String.valueOf(hotelVO.score) + "星级"), 3, 0, 1, 1);
			this.add(new Text("¥" + String.valueOf(hotelVO.minPrice) + "起"), 4, 0, 1, 1);
			this.add(new Text(String.valueOf(hotelVO.address)), 1, 1, 3, 1);

			produceButton = new Button("下订单");
			this.add(produceButton, 5, 1, 1, 1);
			List<RoomVO> roomList = BLFactory.getInstance().getRoomBLService().getRoomTypeList(hotelVO.hotelID);
			produceButton.addEventHandler(MouseEvent.MOUSE_CLICKED, (event) -> {
				ProducingOrderDialog producingOrderDialog = null;
				try {
					producingOrderDialog = new ProducingOrderDialog(customerID, hotelVO, roomList, 0);
				} catch (RemoteException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				producingOrderDialog.show();
			});

			detailedButton = new Button("详情");
			this.add(detailedButton, 6, 1, 1, 1);
			detailedButton.addEventHandler(MouseEvent.MOUSE_CLICKED, (event) -> {
				try {
					TheMainFrame.jumpTo(new CustomerHotelInfoPane(hotelVO.hotelID, customerID));
				} catch (RemoteException e) {
					e.printStackTrace();
				}
			});
		}
	}

}