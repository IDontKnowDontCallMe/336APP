package presentation.hotelui;

import java.rmi.RemoteException;

import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import presentation.mainui.TheMainFrame;
import vo.AreaVO;

public class AreaInputPane extends VBox {

	final int COLUMN_COUNT = 10;

	private int customerID;
	private Text cityText;
	private Text businessCircleText;
	private TextField cityTextField;
	private TextField businessCircleTextField;

	private Button confirmButton;
	private Button backButton;
	private GridPane gridPane;

	public AreaInputPane(int customerID) {
		super();

		this.customerID = customerID;
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
		gridPane.add(confirmButton, 0, 2, 1, 1);

		confirmButton.addEventHandler(MouseEvent.MOUSE_CLICKED, (event) -> {
			String city = cityTextField.getText();
			String businessCircle = businessCircleTextField.getText();
			System.out.println("city is " + city);
			System.out.println("business circle is " + businessCircle);
			try {
				TheMainFrame.jumpTo(new HotelSearchPane(new AreaVO(city, businessCircle), customerID));
			} catch (RemoteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});

		backButton = new Button("返回");
		gridPane.add(backButton, 1, 2, 1, 1);

		backButton.addEventHandler(MouseEvent.MOUSE_CLICKED, (event) -> {
			TheMainFrame.backTo();
		});
		this.getChildren().add(gridPane);
	}

}
