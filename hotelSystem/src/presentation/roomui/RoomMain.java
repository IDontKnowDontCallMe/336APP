package presentation.roomui;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import presentation.orderui.MarketerOrdersPane;

public class RoomMain extends Application{

	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		AnchorPane anchorPane = new AnchorPane();
		GridPane grid = new GridPane();
		anchorPane.getChildren().add(grid);
		anchorPane.setLeftAnchor(grid, 50.0);
		anchorPane.setTopAnchor(grid, 100.0);

        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));

        Label userName = new Label("房型");
        grid.add(userName, 0, 1);
        TextField userTextField = new TextField("总统套房");
        userTextField.setEditable(false);
        userTextField.setBackground(null);
        grid.add(userTextField, 1, 1);

        Label birthday = new Label("简介：");
        grid.add(birthday, 0, 2);
        TextField birthdayfield = new TextField();
        birthdayfield.setEditable(false);
        birthdayfield.setBackground(null);
        grid.add(birthdayfield, 1, 2);
        
        Label address = new Label("设施设备:");
        grid.add(address, 0, 3);
        TextField addressfield = new TextField();
        addressfield.setEditable(false);
        addressfield.setBackground(null);
        grid.add(addressfield, 1, 3);

        Button edit = new Button("编辑");
        Button save = new Button("保存");
        HBox hbBtn = new HBox(10);
        hbBtn.setAlignment(Pos.BOTTOM_RIGHT);
        hbBtn.getChildren().addAll(edit,save);
        grid.add(hbBtn, 0, 4);
	}
	
	public static void main(String[] args){
		launch(args);
	}

}
