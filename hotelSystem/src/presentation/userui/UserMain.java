package presentation.userui;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class UserMain extends Application {
	public void start(Stage primaryStage) throws Exception {
		StackPane stackPane = new StackPane();
		Scene scene = new Scene(stackPane);
		VBox vBox = new HotelPanel();
		// VBox vBox = new WebMarketerPanel();
		// VBox vBox = new CustomerInfoPanel();
		// VBox vBox = new CustomerCreditPanel();

		stackPane.getChildren().add(vBox);
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}

}
