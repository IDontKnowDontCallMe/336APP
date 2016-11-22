package presentation.promotionui;

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
import presentation.orderui.CustomerOrdersPane;

public class PromotionMain extends Application{
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		StackPane stackPane = new StackPane();
		Scene scene = new Scene(stackPane);
//		VBox vBox = new HotelPromotionPanel(0);
		VBox vBox = new WebPromotionPanel();
		
		stackPane.getChildren().add(vBox);
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	public static void main(String[] args){
		launch(args);
	}


}
