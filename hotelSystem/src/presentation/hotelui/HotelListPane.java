package presentation.hotelui;

import java.rmi.RemoteException;
import java.util.List;

import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import presentation.mainui.TheMainFrame;
import presentation.orderui.ProducingOrderDialog;
import vo.HotelVO;

public class HotelListPane extends ScrollPane {

	private int customerID;

	public HotelListPane(List<HotelVO> hotelList) {
		// TODO Auto-generated constructor stub
		super();
		VBox vBox = new VBox();
		this.setContent(vBox);

		for (HotelVO vo : hotelList) {
			vBox.getChildren().add(new SimpleHotelCell(vo));
		}
	}

	public class SimpleHotelCell extends GridPane {

		private HotelVO hotelVO;

		private Button produceButton;
		private Button detailedButton;

		public SimpleHotelCell(HotelVO hotelVO) {
			// TODO Auto-generated constructor stub
			super();
			this.hotelVO = hotelVO;

			this.add(new Text(hotelVO.hotelName), 1, 0, 3, 1);
			this.add(new Text(String.valueOf(hotelVO.commentScore) + "分"), 1, 1, 1, 1);
			this.add(new Text(hotelVO.bookedTag), 4, 1, 1, 1);
			this.add(new Text(String.valueOf(hotelVO.score) + "星级"), 1, 2, 1, 1);
			this.add(new Text("¥" + String.valueOf(hotelVO.minPrice) + "起"), 4, 2, 1, 1);
			this.add(new Text(String.valueOf(hotelVO.address)), 1, 3, 3, 1);

			produceButton = new Button("下订单");
			this.add(produceButton, 5, 4, 1, 1);
			produceButton.addEventHandler(MouseEvent.MOUSE_CLICKED, (event) -> {
				ProducingOrderDialog producingOrderDialog = new ProducingOrderDialog(customerID, hotelVO, null, 0);
				producingOrderDialog.show();
			});
			
			detailedButton = new Button("详情");
			this.add(detailedButton, 4, 4, 1, 1);
			detailedButton.addEventHandler(MouseEvent.MOUSE_CLICKED, (event) -> {
				try {
					TheMainFrame.jumpTo(new CustomerHotelInfoPane(hotelVO.hotelID, customerID));
				} catch (RemoteException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			});
		}
	}

}