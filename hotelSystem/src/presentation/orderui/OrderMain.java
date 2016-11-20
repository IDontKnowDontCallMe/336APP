package presentation.orderui;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.sun.media.jfxmedia.control.VideoDataBuffer;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import po.OrderPO;
import vo.OrderVO;

public class OrderMain extends Application{

	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		StackPane stackPane = new StackPane();
		Scene scene = new Scene(stackPane);
		
		//SimpleDateFormat format = new SimpleDateFormat("yyyy-mm-dd");
		//OrderVO orderVO = new OrderVO(2, "daming", 1, format.parse("2016-11-17") , "如家", "大床房", 1, 
		//								false,  format.parse("2016-11-18"), format.parse("2016-11-19"),233, "正常");
		
		VBox vBox = new MarketerOrdersPane();
		
		stackPane.getChildren().add(vBox);
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	public static void main(String[] args){
		launch(args);
	}

}
