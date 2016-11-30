package presentation.mainui;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;

public class LoginPane extends GridPane {

	private TextField userIDTextField;
	private PasswordField passwordField;
	private Button loginButton;

	public LoginPane() {
		super();
		userIDTextField = new TextField();
		passwordField = new PasswordField();
		loginButton = new Button("登录");

		this.add(new Text("账号"), 0, 0, 1, 1);
		this.add(new Text("密码"), 0, 1, 1, 1);
		this.add(userIDTextField, 1, 0, 3, 1);
		this.add(passwordField, 1, 1, 3, 1);
		loginButton.setAlignment(Pos.CENTER_RIGHT);
		this.add(loginButton, 3, 2, 1, 1);

		loginButton.addEventHandler(MouseEvent.MOUSE_CLICKED, (event) -> {
			TheMainFrame.jumpTo(new CustomerMainPane(Integer.valueOf(userIDTextField.getText())));
		});

		// WebManager
		Button webManagerButton = new Button("网站管理人员快捷入口(用于测试)");
		this.add(webManagerButton, 3, 3, 1, 1);
		webManagerButton.addEventHandler(MouseEvent.MOUSE_CLICKED, (event) -> {
			TheMainFrame.jumpTo(new WebManagerMainPane());
		});

		// WebMarketer
		Button webMarketerButton = new Button("网站营销人员快捷入口(用于测试)");
		this.add(webMarketerButton, 3, 4, 1, 1);
		webMarketerButton.addEventHandler(MouseEvent.MOUSE_CLICKED, (event) -> {
			TheMainFrame.jumpTo(new WebMarketerMainPane());
		});
	}

}
