package presentation.hotelui;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class HotelMain extends Application {

	private int customerID;
	private int hotelID;

	public void start(Stage primaryStage) throws Exception {
		StackPane stackPane = new StackPane();
		Scene scene = new Scene(stackPane);
		GridPane gridPane = new WorkerHotelInfoPane(1011);

		stackPane.getChildren().add(gridPane);
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}

}
