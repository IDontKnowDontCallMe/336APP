package presentation.roomui;

import java.util.ArrayList;
import java.util.List;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import vo.RoomVO;

public class RoomMain extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		StackPane stackPane = new StackPane();
		Scene scene = new Scene(stackPane);

		List<RoomVO> roomList = new ArrayList<RoomVO>();
		RoomVO room1 = new RoomVO(1, "大床房", 150, 20, "大床", 2);
		RoomVO room2 = new RoomVO(2, "双床房", 200, 15, "双床", 2);
		RoomVO room3 = new RoomVO(3, "单人房", 100, 10, "小床", 1);
		roomList.add(room1);
		roomList.add(room2);
		roomList.add(room3);
		GridPane gridPane = new RoomInfoPanel(roomList);

		stackPane.getChildren().add(gridPane);
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}

}
