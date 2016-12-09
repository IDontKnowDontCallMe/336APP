package presentation.hotelui;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;
import bussinesslogic.factory.BLFactory;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import presentation.mainui.TheMainFrame;
import presentation.orderui.ProducingOrderDialog;
import presentation.roomui.MockRoomController;
import presentation.roomui.RoomCell;
import vo.CommentVO;
import vo.HotelVO;
import vo.OrderVO;
import vo.RoomVO;

public class CustomerHotelInfoPane extends GridPane {

	private int hotelID;
	private int customerID;
	private GridPane infoPane;
	private ScrollPane orderPane;
	private ScrollPane commentPane;
	private ScrollPane roomPane;

	private Button backButton;
	private Button produceButton;
	private VBox orderBox;

	private Text addressText;
	private Text introductionText;
	private Text serviceText;

	HotelVO hotelVO;
	List<RoomVO> roomList;

	public CustomerHotelInfoPane(int hotelID, int customerID) throws RemoteException {
		super();
		this.setHgap(10);
		this.setVgap(20);

		this.hotelID = hotelID;
		this.customerID = customerID;

		hotelVO = BLFactory.getInstance().getHotelBLService().getHotelInfo(hotelID);
		String hotelName = hotelVO.hotelName;

		initInfoPane();
		initOrderPane(hotelID, customerID);
		initCommentPane(hotelID);
		initRoomPane(hotelID);

		this.add(new Text(hotelName), 0, 0, 1, 1);
		this.add(new Text("酒店信息"), 0, 1, 1, 1);
		this.add(infoPane, 0, 2, 1, 1);
		this.add(new Text("我的订单"), 2, 3, 1, 1);
		this.add(orderPane, 2, 4, 1, 1);
		this.add(new Text("评论列表"), 0, 3, 1, 1);
		this.add(commentPane, 0, 4, 1, 1);
		this.add(new Text("房型列表"), 2, 1, 1, 1);
		this.add(roomPane, 2, 2, 1, 1);

		backButton = new Button("返回");
		this.add(backButton, 1, 0, 1, 1);
		backButton.addEventHandler(MouseEvent.MOUSE_CLICKED, (event) -> {
			TheMainFrame.backTo();
		});

		produceButton = new Button("下订单");
		this.add(produceButton, 2, 0, 1, 1);
		produceButton.addEventHandler(MouseEvent.MOUSE_CLICKED, (event) -> {
			ProducingOrderDialog producingOrderDialog = null;
			try {
				producingOrderDialog = new ProducingOrderDialog(customerID, hotelVO, roomList, 0);
			} catch (RemoteException e) {
				e.printStackTrace();
			}
			producingOrderDialog.show();
		});
	}

	private void initRoomPane(int hotelID) throws RemoteException {
		roomList = BLFactory.getInstance().getRoomBLService().getRoomTypeList(hotelID);
		roomPane = new ScrollPane();
		TableView<RoomCell> tableView = new TableView<>();
		roomPane.setContent(tableView);

		TableColumn<RoomCell, String> roomIDCol = new TableColumn<>("房间号");
		roomIDCol.setCellValueFactory(new PropertyValueFactory<>("roomID"));
		TableColumn<RoomCell, String> roomNameCol = new TableColumn<>("房间类型");
		roomNameCol.setCellValueFactory(new PropertyValueFactory<>("roomName"));
		TableColumn<RoomCell, String> priceCol = new TableColumn<>("房间单价");
		priceCol.setCellValueFactory(new PropertyValueFactory<>("price"));
		TableColumn<RoomCell, String> numOfRoomCol = new TableColumn<>("房间数量");
		numOfRoomCol.setCellValueFactory(new PropertyValueFactory<>("numOfRoom"));
		TableColumn<RoomCell, String> serviceCol = new TableColumn<>("服务设施");
		serviceCol.setCellValueFactory(new PropertyValueFactory<>("service"));
		TableColumn<RoomCell, String> maxNumOfPeopleCol = new TableColumn<>("最大房客数");
		maxNumOfPeopleCol.setCellValueFactory(new PropertyValueFactory<>("maxNumOfPeople"));

		tableView.getColumns().addAll(roomIDCol, roomNameCol, priceCol, numOfRoomCol, serviceCol, maxNumOfPeopleCol);
		tableView.setPrefWidth(450);
		ObservableList<RoomCell> roomCells = FXCollections.observableArrayList();
		for (RoomVO vo : roomList) {
			RoomCell cell = new RoomCell(vo);
			roomCells.add(cell);
		}

		tableView.setItems(roomCells);

	}

	public void initCommentPane(int hotelID) throws RemoteException {
		commentPane = new ScrollPane();

		List<CommentVO> hotelCommentList = new ArrayList<CommentVO>();
		List<CommentVO> commentList = BLFactory.getInstance().getHotelBLService().getCommentList(hotelID);
		for (CommentVO comment : commentList) {
			if (comment == null) {
				break;
			} else if (comment.hotelID == hotelID) {
				hotelCommentList.add(comment);
			}
		}

		TableView<CommentCell> tableView = new TableView<>();
		commentPane.setContent(tableView);

		TableColumn<CommentCell, String> producingTimeCol = new TableColumn<>("时间");
		producingTimeCol.setCellValueFactory(new PropertyValueFactory<>("producingDateTime"));
		TableColumn<CommentCell, String> customerIDCol = new TableColumn<>("客户ID");
		customerIDCol.setCellValueFactory(new PropertyValueFactory<>("customerID"));
		TableColumn<CommentCell, String> roomNameCol = new TableColumn<>("房间类型");
		roomNameCol.setCellValueFactory(new PropertyValueFactory<>("roomName"));
		TableColumn<CommentCell, String> scoreCol = new TableColumn<>("评分");
		scoreCol.setCellValueFactory(new PropertyValueFactory<>("score"));
		TableColumn<CommentCell, String> commentCol = new TableColumn<>("评价");
		commentCol.setCellValueFactory(new PropertyValueFactory<>("comment"));

		tableView.getColumns().addAll(producingTimeCol, customerIDCol, roomNameCol, scoreCol, commentCol);
		tableView.setPrefWidth(450);
		ObservableList<CommentCell> commentCells = FXCollections.observableArrayList();
		for (CommentVO vo : hotelCommentList) {
			CommentCell cell = new CommentCell(vo);
			commentCells.add(cell);
		}

		tableView.setItems(commentCells);
	}

	private void initInfoPane() {
		infoPane = new GridPane();

		infoPane.setHgap(10);
		infoPane.setVgap(20);
		// 地址、简介、设施服务、客房类型、各房型价格、
		// 该客户在该酒店的订单(正常订单、异常订单和撤销订单要分别标记)

		infoPane.add(new Text("酒店地址"), 0, 1, 1, 1);
		addressText = new Text(hotelVO.address);
		infoPane.add(addressText, 1, 1, 1, 1);

		infoPane.add(new Text("酒店简介"), 0, 2, 1, 1);
		introductionText = new Text(hotelVO.introduction);
		infoPane.add(introductionText, 1, 2, 1, 1);

		infoPane.add(new Text("设施服务"), 0, 3, 1, 1);
		serviceText = new Text(hotelVO.service);
		infoPane.add(serviceText, 1, 3, 1, 1);

	}

	private void initOrderPane(int hotelID, int customerID) throws RemoteException {
		List<OrderVO> orderList = BLFactory.getInstance().getOrderBLService().getOrderListOfHotel(hotelID, customerID);
		orderBox = new VBox();
		orderBox.setSpacing(15);
		buildOrderBox(orderList);

		orderPane = new ScrollPane(orderBox);

	}

	private void buildOrderBox(List<OrderVO> orderList) {
		orderBox.getChildren().clear();
		for (OrderVO vo : orderList) {
			orderBox.getChildren().add(new CustomerHotelInfoCell(vo));
		}
	}
}