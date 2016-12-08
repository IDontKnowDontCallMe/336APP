package presentation.hotelui;

import java.util.ArrayList;
import java.util.List;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.scene.control.TableColumn.CellEditEvent;
import presentation.mainui.TheMainFrame;
import presentation.roomui.MockRoomController;
import presentation.roomui.RoomCell;
import vo.HotelVO;
import vo.RoomVO;

public class WorkerHotelInfoPane extends GridPane {
	private int hotelID;
	private GridPane infoPane;
	private ScrollPane roomPane;
	private HBox addBox1;
	private HBox addBox2;
	private VBox roomBox;

	final int COLUMN = 6;
	private Button backButton;
	private Button infoEditButton;
	private Button addButton;

	private Text nameText;
	private Text addressText;
	private Text introductionText;
	private Text serviceText;
	private Text workerText;
	private Text phoneNumberText;
	private TextField nameTextField;
	private TextField addressTextField;
	private TextField introductionTextField;
	private TextField serviceTextField;
	private TextField workerTextField;
	private TextField phoneNumberTextField;
	private TextField addRoomNameTextField;
	private TextField addNumOfRoomTextField;
	private TextField addServiceTextField;
	private TextField addMaxNumOfPeopleTextField;
	private TextField addPriceTextField;

	HotelVO hotelVO;
	List<RoomVO> roomList;

	public WorkerHotelInfoPane(int hotelID) {
		super();
		this.setHgap(10);
		this.setVgap(20);

		this.hotelID = hotelID;
		hotelVO = MockHotelController.getInstance().getHotelInfo(hotelID);
		initInfoPane();
		initRoomPane(hotelID);

		this.add(new Text("酒店基本信息"), 0, 0, 1, 1);
		this.add(infoPane, 0, 1, 1, 1);

		this.add(new Text("房型列表"), 0, 2, 1, 1);
		this.add(roomBox, 0, 3, 2, 1);

	}

	private void initRoomPane(int hotelID) {
		roomList = MockRoomController.getInstance().getRoomTypeList(hotelID);
		roomPane = new ScrollPane();
		roomBox = new VBox();
		addBox1 = new HBox();
		addBox2 = new HBox();
		roomBox.setSpacing(10);
		addBox1.setSpacing(10);
		addBox2.setSpacing(10);

		TableView<RoomCell> tableView = new TableView<>();

		tableView.setEditable(true);
		roomPane.setContent(tableView);

		TableColumn<RoomCell, String> roomIDCol = new TableColumn<>("房间号");
		roomIDCol.setCellValueFactory(new PropertyValueFactory<>("roomID"));

		TableColumn<RoomCell, String> roomNameCol = new TableColumn<>("房间类型");
		roomNameCol.setCellValueFactory(new PropertyValueFactory<>("roomName"));
		roomNameCol.setCellFactory(TextFieldTableCell.<RoomCell>forTableColumn());
		roomNameCol.setOnEditCommit((CellEditEvent<RoomCell, String> t) -> {
			((RoomCell) t.getTableView().getItems().get(t.getTablePosition().getRow())).setRoomName(t.getNewValue());
		});

		TableColumn<RoomCell, String> priceCol = new TableColumn<>("房间单价");
		priceCol.setCellValueFactory(new PropertyValueFactory<>("price"));
		priceCol.setCellFactory(TextFieldTableCell.<RoomCell>forTableColumn());
		priceCol.setOnEditCommit((CellEditEvent<RoomCell, String> t) -> {
			((RoomCell) t.getTableView().getItems().get(t.getTablePosition().getRow())).setPrice(t.getNewValue());
		});

		TableColumn<RoomCell, String> numOfRoomCol = new TableColumn<>("房间数量");
		numOfRoomCol.setCellValueFactory(new PropertyValueFactory<>("numOfRoom"));
		numOfRoomCol.setCellFactory(TextFieldTableCell.<RoomCell>forTableColumn());
		numOfRoomCol.setOnEditCommit((CellEditEvent<RoomCell, String> t) -> {
			((RoomCell) t.getTableView().getItems().get(t.getTablePosition().getRow())).setNumOfRoom(t.getNewValue());
		});

		TableColumn<RoomCell, String> serviceCol = new TableColumn<>("服务设施");
		serviceCol.setCellValueFactory(new PropertyValueFactory<>("service"));
		serviceCol.setCellFactory(TextFieldTableCell.<RoomCell>forTableColumn());
		serviceCol.setOnEditCommit((CellEditEvent<RoomCell, String> t) -> {
			((RoomCell) t.getTableView().getItems().get(t.getTablePosition().getRow())).setService(t.getNewValue());
		});

		TableColumn<RoomCell, String> maxNumOfPeopleCol = new TableColumn<>("最大房客数");
		maxNumOfPeopleCol.setCellValueFactory(new PropertyValueFactory<>("maxNumOfPeople"));
		maxNumOfPeopleCol.setCellFactory(TextFieldTableCell.<RoomCell>forTableColumn());
		maxNumOfPeopleCol.setOnEditCommit((CellEditEvent<RoomCell, String> t) -> {
			((RoomCell) t.getTableView().getItems().get(t.getTablePosition().getRow()))
					.setMaxNumOfPeople(t.getNewValue());
		});

		tableView.getColumns().addAll(roomIDCol, roomNameCol, priceCol, numOfRoomCol, serviceCol, maxNumOfPeopleCol);
		tableView.setPrefWidth(450);
		ObservableList<RoomCell> roomCells = FXCollections.observableArrayList();

		addRoomNameTextField = new TextField();
		addNumOfRoomTextField = new TextField();
		addServiceTextField = new TextField();
		addMaxNumOfPeopleTextField = new TextField();
		addPriceTextField = new TextField();

		addRoomNameTextField.setPromptText("房间类型");
		addNumOfRoomTextField.setPromptText("房间数量");
		addServiceTextField.setPromptText("服务设施");
		addMaxNumOfPeopleTextField.setPromptText("最大房客数");
		addPriceTextField.setPromptText("房间单价");

		addRoomNameTextField.setPrefColumnCount(COLUMN);
		addNumOfRoomTextField.setPrefColumnCount(COLUMN);
		addServiceTextField.setPrefColumnCount(COLUMN);
		addMaxNumOfPeopleTextField.setPrefColumnCount(COLUMN);
		addPriceTextField.setPrefColumnCount(COLUMN);

		for (RoomVO vo : roomList) {
			RoomCell cell = new RoomCell(vo);
			roomCells.add(cell);
		}
		addButton = new Button("新增房间类型");
		addButton.setOnAction((ActionEvent e) -> {
			int count = 0;
			for (RoomVO vo : roomList) {
				count++;
			}
			final int COUNT = count;

			roomCells.add(new RoomCell(String.valueOf(COUNT + 1), addRoomNameTextField.getText(),
					addPriceTextField.getText(), addNumOfRoomTextField.getText(), addServiceTextField.getText(),
					addMaxNumOfPeopleTextField.getText()));
			addRoomNameTextField.clear();
			addNumOfRoomTextField.clear();
			addServiceTextField.clear();
			addMaxNumOfPeopleTextField.clear();
			addPriceTextField.clear();

			RoomVO newVO = new RoomVO(COUNT + 1, addRoomNameTextField.getText(),
					Integer.parseInt(addPriceTextField.getText()), Integer.parseInt(addNumOfRoomTextField.getText()),
					addServiceTextField.getText(), Integer.parseInt(addMaxNumOfPeopleTextField.getText()));
			roomList.add(newVO);
			// 将newVO加入BL层
			// .......

			TheMainFrame.backTo();
		});

		backButton = new Button("返回");
		backButton.setOnAction((ActionEvent e) -> {
			List<RoomVO> newRoomList = new ArrayList<RoomVO>();

			int count = 0;
			for (RoomVO vo : roomList) {
				count++;
			}
			for (int i = 0; i < count; i++) {
				RoomVO updateVO = new RoomVO(Integer.parseInt(tableView.getColumns().get(0).getCellData(i).toString()),
						tableView.getColumns().get(1).getCellData(i).toString(),
						Integer.parseInt(tableView.getColumns().get(2).getCellData(i).toString()),
						Integer.parseInt(tableView.getColumns().get(3).getCellData(i).toString()),
						tableView.getColumns().get(4).getCellData(i).toString(),
						Integer.parseInt(tableView.getColumns().get(5).getCellData(i).toString()));
				newRoomList.add(updateVO);
			}

			// 将newRoomList加入BL层
			// .......

		});
		tableView.setItems(roomCells);

		addBox1.getChildren().addAll(addRoomNameTextField, addPriceTextField, addNumOfRoomTextField);
		addBox2.getChildren().addAll(addServiceTextField, addMaxNumOfPeopleTextField, addButton, backButton);
		roomBox.getChildren().addAll(roomPane, addBox1, addBox2);
	}

	private void initInfoPane() {
		infoPane = new GridPane();

		infoPane.setHgap(10);
		infoPane.setVgap(10);

		infoEditButton = new Button("编辑");
		infoPane.add(infoEditButton, 0, 0, 1, 1);

		infoPane.add(new Text("酒店名称"), 0, 1, 1, 1);
		nameText = new Text(hotelVO.hotelName);
		infoPane.add(nameText, 1, 1, 1, 1);

		infoPane.add(new Text("酒店地址"), 0, 2, 1, 1);
		addressText = new Text(hotelVO.address);
		infoPane.add(addressText, 1, 2, 1, 1);

		infoPane.add(new Text("酒店简介"), 0, 3, 1, 1);
		introductionText = new Text(hotelVO.introduction);
		infoPane.add(introductionText, 1, 3, 1, 1);

		infoPane.add(new Text("设施服务"), 0, 4, 1, 1);
		serviceText = new Text(hotelVO.service);
		infoPane.add(serviceText, 1, 4, 1, 1);

		infoPane.add(new Text("工作人员姓名"), 0, 5, 1, 1);
		workerText = new Text(hotelVO.workerName);
		infoPane.add(workerText, 1, 5, 1, 1);

		infoPane.add(new Text("工作人员联系方式"), 0, 6, 1, 1);
		phoneNumberText = new Text(hotelVO.phoneNumber);
		infoPane.add(phoneNumberText, 1, 6, 1, 1);

		infoEditButton.addEventHandler(MouseEvent.MOUSE_CLICKED, (event) -> {
			if (infoEditButton.getText().equals("编辑")) {
				infoPane.getChildren().removeAll(nameText, addressText, introductionText, serviceText, workerText,
						phoneNumberText);

				nameTextField = new TextField(hotelVO.hotelName);
				nameTextField.setPrefColumnCount(COLUMN);
				addressTextField = new TextField(hotelVO.address);
				addressTextField.setPrefColumnCount(COLUMN);
				introductionTextField = new TextField(hotelVO.introduction);
				introductionTextField.setPrefColumnCount(COLUMN);
				serviceTextField = new TextField(hotelVO.service);
				serviceTextField.setPrefColumnCount(COLUMN);
				workerTextField = new TextField(hotelVO.workerName);
				workerTextField.setPrefColumnCount(COLUMN);
				phoneNumberTextField = new TextField(hotelVO.phoneNumber);
				phoneNumberTextField.setPrefColumnCount(COLUMN);

				infoPane.add(nameTextField, 1, 1, 1, 1);
				infoPane.add(addressTextField, 1, 2, 1, 1);
				infoPane.add(introductionTextField, 1, 3, 1, 1);
				infoPane.add(serviceTextField, 1, 4, 1, 1);
				infoPane.add(workerTextField, 1, 5, 1, 1);
				infoPane.add(phoneNumberTextField, 1, 6, 1, 1);

				infoEditButton.setText("保存");
			} else if (infoEditButton.getText().equals("保存")) {
				infoPane.getChildren().removeAll(nameTextField, addressTextField, introductionTextField,
						serviceTextField, workerTextField, phoneNumberTextField);
				infoPane.add(nameText, 1, 1, 1, 1);
				infoPane.add(addressText, 1, 2, 1, 1);
				infoPane.add(introductionText, 1, 3, 1, 1);
				infoPane.add(serviceText, 1, 4, 1, 1);
				infoPane.add(workerText, 1, 5, 1, 1);
				infoPane.add(phoneNumberText, 1, 6, 1, 1);

				HotelVO newVO = MockHotelController.getInstance().getHotelInfo(hotelID);

				newVO.hotelName = nameTextField.getText();
				newVO.address = addressTextField.getText();
				newVO.introduction = introductionTextField.getText();
				newVO.service = serviceTextField.getText();
				newVO.workerName = workerTextField.getText();
				newVO.phoneNumber = phoneNumberTextField.getText();

				nameText.setText(nameTextField.getText());
				addressText.setText(addressTextField.getText());
				introductionText.setText(introductionTextField.getText());
				serviceText.setText(serviceTextField.getText());
				workerText.setText(workerTextField.getText());
				phoneNumberText.setText(phoneNumberTextField.getText());

				infoEditButton.setText("编辑");
			}
		});
	}
}
