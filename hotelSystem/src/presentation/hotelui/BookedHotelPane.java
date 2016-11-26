package presentation.hotelui;

import java.util.List;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import presentation.mainui.TheMainFrame;
import vo.HotelVO;

public class BookedHotelPane extends VBox{
	
	public BookedHotelPane(int customerID) {
		// TODO Auto-generated constructor stub
		Button backButton = new Button("返回");
		backButton.setAlignment(Pos.CENTER_RIGHT);
		backButton.addEventHandler(MouseEvent.MOUSE_CLICKED	, (event)->{
			TheMainFrame.backTo();
		});
		
		List<HotelVO> hotelList = MockHotelController.getInstance().getBookedHotelList(customerID);
		
		this.getChildren().addAll(backButton, new HotelListPane(hotelList));
	}

}
