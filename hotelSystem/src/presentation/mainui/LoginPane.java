package presentation.mainui;


import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

public class LoginPane extends AnchorPane {

	private TextField userIDTextField;
	private PasswordField passwordField;
	private Button loginButton;
	private Button registerButton;
	private Label hint;

	public LoginPane() {
		super();
		userIDTextField = new TextField();
		userIDTextField.setPromptText("UserID");
		passwordField = new PasswordField();
		passwordField.setPromptText("Password");
		loginButton = new Button("Login");
		loginButton.setId("loginbutton");

		registerButton = new Button("现在注册一个");
		registerButton.setId("registerbutton");
		hint = new Label("有 Aipapa ID 吗?");

		
		this.getChildren().addAll(userIDTextField,passwordField,loginButton,registerButton,hint);
		AnchorPane.setLeftAnchor(userIDTextField, 425.0);
		AnchorPane.setLeftAnchor(passwordField, 425.0);
		AnchorPane.setTopAnchor(userIDTextField, 420.0);
		AnchorPane.setTopAnchor(passwordField, 450.0);
		AnchorPane.setLeftAnchor(loginButton, 690.0);
		AnchorPane.setTopAnchor(loginButton, 420.0);
		AnchorPane.setLeftAnchor(hint, 425.0);
		AnchorPane.setTopAnchor(hint, 485.0);
		AnchorPane.setLeftAnchor(registerButton, 520.0);
		AnchorPane.setTopAnchor(registerButton, 481.0);




		loginButton.setAlignment(Pos.CENTER_RIGHT);

		loginButton.addEventHandler(MouseEvent.MOUSE_CLICKED, (event) -> {
			TheMainFrame.jumpTo(new CustomerMainPane(Integer.valueOf(userIDTextField.getText())));
		});

		// WebManager
		Button webManagerButton = new Button("网站管理人员快捷入口(用于测试)");
		this.getChildren().add(webManagerButton);
		AnchorPane.setTopAnchor(webManagerButton, 20.0);
		webManagerButton.addEventHandler(MouseEvent.MOUSE_CLICKED, (event) -> {
			TheMainFrame.jumpTo(new WebManagerMainPane());
		});

		// WebMarketer
		Button webMarketerButton = new Button("网站营销人员快捷入口(用于测试)");
		this.getChildren().add(webMarketerButton);
		AnchorPane.setTopAnchor(webMarketerButton, 50.0);
		webMarketerButton.addEventHandler(MouseEvent.MOUSE_CLICKED, (event) -> {
			TheMainFrame.jumpTo(new WebMarketerMainPane());
		});

		// HotelWorker
		Button hotelWorkerButton = new Button("酒店工作人员快捷入口(用于测试)");
		this.getChildren().add(hotelWorkerButton);
		AnchorPane.setTopAnchor(hotelWorkerButton, 80.0);
		hotelWorkerButton.addEventHandler(MouseEvent.MOUSE_CLICKED, (event) -> {
			TheMainFrame.jumpTo(new HotelWorkerMainPane(Integer.valueOf(userIDTextField.getText())));
		});

		this.getStylesheets().add(getClass().getResource("LoginPane.css").toExternalForm());
	}

}
