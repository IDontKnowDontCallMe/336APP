package presentation.promotionui;

import java.rmi.RemoteException;
import java.util.List;

import bussinesslogic.factory.BLFactory;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import vo.HotelPromotionVO;

public class HotelPromotionPanel extends VBox {

	private ScrollPane listPane;
	private VBox hotelPromotionBox;
	private HBox addBox;
	private Button addButton;
	private Text title;

	public HotelPromotionPanel(int hotelID) throws RemoteException{
		List<HotelPromotionVO> hotelPromotionList = BLFactory.getInstance().getPromotionBLService().getHotelPromotionList(hotelID);
		hotelPromotionBox = new VBox();
		hotelPromotionBox.setSpacing(15);
		buildHotelPromotionBox(hotelPromotionList);
		listPane = new ScrollPane(hotelPromotionBox);

		title = new Text("酒店促销策略");
		addButton = new Button("新增");
		addButton.addEventHandler(MouseEvent.MOUSE_CLICKED, (MouseEvent e) -> {
			System.out.println("add");
			HotelPromotionAddDialog hotelPromotionAddDialog = new HotelPromotionAddDialog(hotelID);
			hotelPromotionAddDialog.show();

		});

		addBox = new HBox();
		addBox.setSpacing(10);
		addBox.setPrefWidth(500);
		addBox.getChildren().addAll(title, addButton);
		this.getChildren().addAll(addBox, listPane);
	}

	private void buildHotelPromotionBox(List<HotelPromotionVO> hotelPromotionList) {
		hotelPromotionBox.getChildren().clear();
		for (HotelPromotionVO vo : hotelPromotionList) {
			hotelPromotionBox.getChildren().add(new HotelPromotionCell(vo));
		}
	}
}
