package presentation.promotionui;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class PromotionMain extends Application {
	public void start(Stage primaryStage) throws Exception {
		StackPane stackPane = new StackPane();
		Scene scene = new Scene(stackPane);
		VBox vBox = new HotelPromotionPanel(0);
		// VBox vBox = new WebPromotionPanel();

		// LevelDialog levelDialog = new LevelDialog();
		// levelDialog.show();

		stackPane.getChildren().add(vBox);
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}

}
