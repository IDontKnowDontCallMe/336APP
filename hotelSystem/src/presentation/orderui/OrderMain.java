package presentation.orderui;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Optional;

import com.sun.media.jfxmedia.control.VideoDataBuffer;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Dialog;
import javafx.scene.control.ListView;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import po.OrderPO;
import vo.HotelVO;
import vo.OrderVO;
import vo.RoomVO;

public class OrderMain extends Application{

	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		StackPane stackPane = new StackPane();
		Scene scene = new Scene(stackPane, 400, 400);
		
		//SimpleDateFormat format = new SimpleDateFormat("yyyy-mm-dd");
		//OrderVO orderVO = new OrderVO(2, "daming", 1, format.parse("2016-11-17") , "如家", "大床房", 1, 
		//								false,  format.parse("2016-11-18"), format.parse("2016-11-19"),233, "正常");
		
		StackPane root = new StackPane();
		
		HotelVO hotelVO = new HotelVO(1010, "南大宿舍", "南京", "仙林", "97号仙林大道", "无", "热水、网线", 1, 4.8, "校长", "101010101010", 100,"未预定过");
		ArrayList<RoomVO> roomList = new ArrayList<RoomVO>();
		RoomVO room1 = new RoomVO(1, "大床房", 150, 20, "大床", 2);
		RoomVO room2 = new RoomVO(2, "双床房", 200, 15, "双床", 2);
		RoomVO room3 = new RoomVO(3, "单人房", 100, 10, "小床", 1);
		roomList.add(room1);
		roomList.add(room2);
		roomList.add(room3);
		
		
		Button button = new Button("produce");
		button.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				// TODO Auto-generated method stub
				Dialog<OrderVO> dialog = new ProducingOrderDialog(123, hotelVO, roomList, 0);
				Optional<OrderVO> result = dialog.showAndWait();
				if(result.isPresent()){
					OrderVO vo = result.get();
					System.out.println(vo.total);
				}
				else{
					System.out.println("NULL");
				}
			}
		});
		root.getChildren().addAll(button);
		
		stackPane.getChildren().add(root);
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	public static void main(String[] args){
		launch(args);
	}

}
