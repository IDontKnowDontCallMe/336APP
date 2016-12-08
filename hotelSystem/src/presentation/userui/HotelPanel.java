package presentation.userui;

import java.rmi.RemoteException;
import java.util.List;
import java.util.Optional;

import bussinesslogic.factory.BLFactory;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Dialog;
import javafx.scene.control.ScrollPane;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import presentation.mainui.TheMainFrame;
import vo.HotelVO;

public class HotelPanel extends VBox {
	private ScrollPane listPane;
	private VBox hotelBox;
	private Text title;
	private Button addButton;
	private Button backButton;
	private HBox titleBox;

	public HotelPanel() throws RemoteException {
		List<HotelVO> hotelList = BLFactory.getInstance().getUserBLService().getHotelList();

		hotelBox = new VBox();
		hotelBox.setSpacing(15);
		buildHotelBox(hotelList);
		listPane = new ScrollPane(hotelBox);

		title = new Text("酒店及酒店工作人员列表");
		addButton = new Button("新增酒店及酒店工作人员");

		addButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				System.out.println("add hotel!");
				Dialog<HotelVO> addHotelDialog = new AddHotelDialog();

				Optional<HotelVO> result = addHotelDialog.showAndWait();
				if (result.isPresent()) {
					HotelVO vo = result.get();
					System.out.println("new hotel is " + vo.hotelName);
				} else {
					System.out.println("nothing added");
				}

			}
		});
		backButton = new Button("返回");
		backButton.addEventHandler(MouseEvent.MOUSE_CLICKED, (event) -> {
			TheMainFrame.backTo();
		});
		titleBox = new HBox();
		titleBox.getChildren().addAll(title, addButton, backButton);
		this.getChildren().addAll(titleBox, listPane);
	}

	public void buildHotelBox(List<HotelVO> hotelList) {
		hotelBox.getChildren().clear();
		for (HotelVO vo : hotelList) {
			hotelBox.getChildren().addAll(new HotelCell(vo));
		}
	}
}
