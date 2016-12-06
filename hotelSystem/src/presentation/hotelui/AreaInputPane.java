package presentation.hotelui;

import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import vo.AreaVO;

public class AreaInputPane extends VBox {

	final int COLUMN_COUNT = 10;

	Text cityText;
	Text businessCircleText;
	TextField cityTextField;
	TextField businessCircleTextField;

	Button confirmButton;
	GridPane gridPane;

	public AreaInputPane() {
		super();
		gridPane = new GridPane();
		gridPane.setHgap(10);
		gridPane.setVgap(20);

		cityText = new Text("城市");
		businessCircleText = new Text("商圈");
		cityTextField = new TextField();
		cityTextField.setPrefColumnCount(COLUMN_COUNT);

		businessCircleTextField = new TextField();
		businessCircleTextField.setPrefColumnCount(COLUMN_COUNT);

		gridPane.add(cityText, 0, 0, 1, 1);
		gridPane.add(cityTextField, 1, 0, 1, 1);
		gridPane.add(businessCircleText, 0, 1, 1, 1);
		gridPane.add(businessCircleTextField, 1, 1, 1, 1);

		confirmButton = new Button("开始搜索");
		gridPane.add(confirmButton, 1, 2, 1, 1);

		confirmButton.addEventHandler(MouseEvent.MOUSE_CLICKED, (MouseEvent e) -> {
			String city = cityTextField.getText();
			String businessCircle = businessCircleTextField.getText();
			System.out.println("city is " + city);
			System.out.println("business cicle is " + businessCircle);

			AreaVO vo = new AreaVO(city, businessCircle);
			HotelSearchPane hotelSearchPane = new HotelSearchPane(vo, 1);//customerID

		});

		this.getChildren().add(gridPane);
	}

}
