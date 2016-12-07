package presentation.orderui;

import java.time.LocalDate;
import java.util.List;

import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.control.ButtonType;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DateCell;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Dialog;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import javafx.util.Callback;
import vo.CalculationConditionVO;
import vo.HotelVO;
import vo.OrderVO;
import vo.RoomVO;

public class ProducingOrderDialog extends Dialog<OrderVO> {

	HotelVO hotelVO;
	List<RoomVO> roomList;

	GridPane gridPane;
	ChoiceBox<String> roomTypeChoiceBox;
	DatePicker checkInDatePicker;
	DatePicker checkOutDatePicker;
	TextField numTextField;
	Button addButton;
	Button subButton;
	CheckBox childrenCheckBox;
	Text totalText;

	CalculationConditionVO calculationConditionVO;
	OrderVO orderVO;

	public ProducingOrderDialog(int customerID, HotelVO hotelVO, List<RoomVO> roomList, int roomIndex) {
		this.hotelVO = hotelVO;
		this.roomList = roomList;

		initUI(roomIndex);
		this.getDialogPane().setContent(gridPane);
		calculationConditionVO = new CalculationConditionVO(customerID, 2, 1, checkInDatePicker.getValue(),
				checkOutDatePicker.getValue(), Integer.valueOf(numTextField.getText()), roomIndex, false, null);
		updateTotal();

		Callback<ButtonType, OrderVO> resultConverter = new Callback<ButtonType, OrderVO>() {

			@Override
			public OrderVO call(ButtonType param) {
				if (param.getButtonData() == ButtonData.OK_DONE) {
					return new OrderVO(-1, null, customerID, null, null, hotelVO.hotelName,
							roomTypeChoiceBox.getValue(), Integer.valueOf(numTextField.getText()), 1,
							childrenCheckBox.isSelected(), checkInDatePicker.getValue(), null,
							checkOutDatePicker.getValue(), Integer.valueOf(totalText.getText()), "正常");
				} else {
					return null;
				}
			}
		};
		this.setResultConverter(resultConverter);

		ButtonType ok = new ButtonType("生产订单", ButtonData.OK_DONE);
		ButtonType cancle = new ButtonType("取消", ButtonData.CANCEL_CLOSE);
		this.getDialogPane().getButtonTypes().addAll(ok, cancle);

	}

	private void initUI(int roomIndex) {
		gridPane = new GridPane();

		roomTypeChoiceBox = new ChoiceBox<String>();
		for (RoomVO vo : roomList) {
			roomTypeChoiceBox.getItems().add(vo.roomName);
		}
		roomTypeChoiceBox.getSelectionModel().select(roomIndex);
		gridPane.add(new Text("房间类型"), 0, 1, 1, 1);
		gridPane.add(roomTypeChoiceBox, 1, 1, 1, 1);

		checkInDatePicker = new DatePicker();
		checkInDatePicker.setValue(LocalDate.now());
		checkOutDatePicker = new DatePicker();
		checkOutDatePicker.setValue(LocalDate.now().plusDays(1));
		Callback<DatePicker, DateCell> checkInDayCellFactory = new Callback<DatePicker, DateCell>() {
			@Override
			public DateCell call(final DatePicker datePicker) {
				return new DateCell() {
					@Override
					public void updateItem(LocalDate item, boolean empty) {
						super.updateItem(item, empty);

						if (item.isBefore(LocalDate.now()) || !item.isBefore(checkOutDatePicker.getValue())) {
							setDisable(true);
							setStyle("-fx-background-color: #ffc0cb;");
						}
					}
				};
			}
		};
		checkInDatePicker.setDayCellFactory(checkInDayCellFactory);
		Callback<DatePicker, DateCell> checkOutDayCellFactory = new Callback<DatePicker, DateCell>() {
			@Override
			public DateCell call(final DatePicker datePicker) {
				return new DateCell() {
					@Override
					public void updateItem(LocalDate item, boolean empty) {
						super.updateItem(item, empty);

						if (!item.isAfter(checkInDatePicker.getValue())) {
							setDisable(true);
							setStyle("-fx-background-color: #ffc0cb;");
						}
					}
				};
			}
		};
		checkOutDatePicker.setDayCellFactory(checkOutDayCellFactory);
		gridPane.add(new Text("入住时间"), 0, 2, 1, 1);
		gridPane.add(checkInDatePicker, 1, 2, 1, 1);
		gridPane.add(new Text("离店时间"), 0, 3, 1, 1);
		gridPane.add(checkOutDatePicker, 1, 3, 1, 1);

		numTextField = new TextField();
		numTextField.setEditable(false);
		numTextField.setPrefColumnCount(2);
		numTextField.setText("1");
		addButton = new Button("加");
		subButton = new Button("减");
		HBox numBox = new HBox();
		numBox.getChildren().addAll(new Text("数量:"), subButton, numTextField, addButton);
		gridPane.add(numBox, 1, 4, 1, 1);

		childrenCheckBox = new CheckBox("携带儿童");
		childrenCheckBox.setSelected(false);
		gridPane.add(childrenCheckBox, 0, 4, 1, 1);

		totalText = new Text("0");
		HBox totalBox = new HBox(new Text("优惠后总价:"), totalText);
		gridPane.add(totalBox, 0, 5, 1, 1);
	}

	private void updateTotal() {
		int total = new MockOrderController().calculateTotal(calculationConditionVO);
		totalText.setText(String.valueOf(total));
	}

}
