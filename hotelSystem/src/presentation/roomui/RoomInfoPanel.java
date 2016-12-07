package presentation.roomui;

import java.util.List;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import vo.RoomVO;

public class RoomInfoPanel extends GridPane {

	private int hotelID;
	ScrollPane roomPane;

	public RoomInfoPanel(List<RoomVO> roomList) {

		super();
		this.setHgap(10);
		this.setVgap(20);

		this.hotelID = hotelID;

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
}
