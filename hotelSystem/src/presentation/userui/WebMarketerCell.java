package presentation.userui;

import java.rmi.RemoteException;
import java.util.List;

import bussinesslogic.factory.BLFactory;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import vo.WebMarketerVO;

public class WebMarketerCell extends GridPane {

	WebMarketerVO webMarketerVO;

	private int webMarketerID;
	private GridPane infoPane;
	private Text nameText;
	private Text phoneNumberText;
	private TextField nameTextField;
	private TextField phoneTextField;
	private Button editButton;

	public WebMarketerCell(WebMarketerVO webMarketerVO) {
		super();
		this.webMarketerVO = webMarketerVO;
		webMarketerID = webMarketerVO.ID;
		infoPane = new GridPane();

		infoPane.add(new Text("姓名"), 0, 0, 1, 1);
		nameText = new Text(webMarketerVO.name);
		infoPane.add(nameText, 1, 0, 1, 1);

		infoPane.add(new Text("电话"), 0, 1, 1, 1);
		phoneNumberText = new Text(webMarketerVO.phoneNumber);
		infoPane.add(phoneNumberText, 1, 1, 1, 1);

		editButton = new Button("编辑");
		infoPane.add(editButton, 0, 5, 1, 1);

		nameTextField = new TextField();
		nameTextField.setPrefColumnCount(8);
		phoneTextField = new TextField();
		phoneTextField.setPrefColumnCount(8);

		editButton.addEventHandler(MouseEvent.MOUSE_CLICKED, (event) ->

		{
			if (editButton.getText().equals("编辑")) {
				infoPane.getChildren().removeAll(nameText, phoneNumberText);
				nameTextField.setText(nameText.getText());
				phoneTextField.setText(phoneNumberText.getText());

				infoPane.add(nameTextField, 1, 0, 1, 1);
				infoPane.add(phoneTextField, 1, 1, 1, 1);
				editButton.setText("保存");
			} else if (editButton.getText().equals("保存")) {
				infoPane.getChildren().removeAll(nameTextField, phoneTextField);
				infoPane.add(nameText, 1, 0, 1, 1);
				infoPane.add(phoneNumberText, 1, 1, 1, 1);

				WebMarketerVO vo = null;
				List<WebMarketerVO> list = null;
				try {
					list = BLFactory.getInstance().getUserBLService().getWebMarketerList();
				} catch (RemoteException e1) {
					e1.printStackTrace();
				}
				for (WebMarketerVO v : list) {
					if (v.ID == webMarketerID) {
						vo = v;
					}
				}

				vo.name = nameTextField.getText();
				vo.phoneNumber = phoneTextField.getText();
				try {
					if (MockUserController.getInstance().updateWebMarketer(webMarketerVO)) {
						nameText.setText(nameTextField.getText());
						phoneNumberText.setText(phoneTextField.getText());
					}
				} catch (RemoteException e) {
					e.printStackTrace();
				}

				editButton.setText("编辑");
			}
		});
		this.add(infoPane, 1, 0, 1, 1);

		this.setHgap(10);
		this.setVgap(20);
	}
}
