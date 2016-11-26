package presentation.mainui;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;

public class LoginPane extends GridPane{

	private TextField userIDTextField;
	private PasswordField passwordField;
	private Button loginButton;
	
	public LoginPane() {
		// TODO Auto-generated constructor stub
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
		
		loginButton.addEventHandler(MouseEvent.MOUSE_CLICKED, (event)->{
			TheMainFrame.jumpTo(new CustomerMainPane(Integer.valueOf(userIDTextField.getText())));
		});
	}
	
}
