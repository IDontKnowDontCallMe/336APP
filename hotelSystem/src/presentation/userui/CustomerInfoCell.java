package presentation.userui;

import java.rmi.RemoteException;

import bussinesslogic.factory.BLFactory;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import presentation.customerui.MockCustomerController;
import vo.CustomerVO;

public class CustomerInfoCell extends GridPane {

	CustomerVO customerVO;
	private int customerID;
	private GridPane infoPane;
	private Text nameText;
	private Text phoneNumberText;
	private Text levelText;
	private Text birthdayText;
	private Text companyText;
	private TextField nameTextField;
	private TextField phoneTextField;
	private TextField companyTextField;
	private Button editButton;
	private DatePicker birthdayDatePicker;

	public CustomerInfoCell(CustomerVO customerVO) {
		super();
		this.customerVO = customerVO;
		customerID = customerVO.customerID;
		infoPane = new GridPane();

		infoPane.add(new Text("姓名"), 0, 0, 1, 1);
		nameText = new Text(customerVO.customerName);
		infoPane.add(nameText, 1, 0, 1, 1);

		infoPane.add(new Text("电话"), 0, 1, 1, 1);
		phoneNumberText = new Text(customerVO.phoneNumber);
		infoPane.add(phoneNumberText, 1, 1, 1, 1);

		infoPane.add(new Text("等级"), 0, 2, 1, 1);
		levelText = new Text(String.valueOf(customerVO.level));
		infoPane.add(levelText, 1, 2, 1, 1);

		infoPane.add(new Text("生日会员  "), 0, 3, 1, 1);
		if (customerVO.isBirthVIP) {
			birthdayText = new Text(String.valueOf(customerVO.birthday));
		} else {
			birthdayText = new Text("无");
		}
		infoPane.add(birthdayText, 1, 3, 1, 1);

		infoPane.add(new Text("企业会员  "), 0, 4, 1, 1);
		if (customerVO.isCompanyVIP) {
			companyText = new Text(customerVO.companyName);
		} else {
			companyText = new Text("无");
		}
		infoPane.add(companyText, 1, 4, 1, 1);

		editButton = new Button("编辑");
		infoPane.add(editButton, 0, 5, 1, 1);

		nameTextField = new TextField();
		nameTextField.setPrefColumnCount(8);
		phoneTextField = new TextField();
		phoneTextField.setPrefColumnCount(8);
		companyTextField = new TextField();
		companyTextField.setPrefColumnCount(8);
		birthdayDatePicker = new DatePicker();

		editButton.addEventHandler(MouseEvent.MOUSE_CLICKED, (event) ->

		{
			if (editButton.getText().equals("编辑")) {
				infoPane.getChildren().removeAll(nameText, phoneNumberText, birthdayText, companyText);
				nameTextField.setText(nameText.getText());
				phoneTextField.setText(phoneNumberText.getText());

				if (customerVO.isBirthVIP) {
					birthdayDatePicker.setValue(customerVO.birthday);
				}
				companyTextField.setText(companyText.getText());

				infoPane.add(nameTextField, 1, 0, 1, 1);
				infoPane.add(phoneTextField, 1, 1, 1, 1);
				infoPane.add(birthdayDatePicker, 1, 3, 1, 1);
				infoPane.add(companyTextField, 1, 4, 1, 1);
				editButton.setText("保存");
			} else if (editButton.getText().equals("保存")) {
				infoPane.getChildren().removeAll(nameTextField, phoneTextField, birthdayDatePicker, companyTextField);
				infoPane.add(nameText, 1, 0, 1, 1);
				infoPane.add(phoneNumberText, 1, 1, 1, 1);
				infoPane.add(birthdayText, 1, 3, 1, 1);
				infoPane.add(companyText, 1, 4, 1, 1);

				CustomerVO vo = null;
				try {
					vo = BLFactory.getInstance().getCustomerBLService().getCustomerInfo(customerID);
				} catch (RemoteException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				vo.customerName = nameTextField.getText();
				vo.phoneNumber = phoneTextField.getText();
				if (birthdayDatePicker.getValue() != null) {
					vo.isBirthVIP = true;
					vo.birthday = birthdayDatePicker.getValue();
				} else {
					vo.isBirthVIP = false;
					vo.birthday = null;
				}
				if (companyTextField.getText().equals("")) {
					vo.isBirthVIP = false;
					vo.companyName = null;
				} else {
					vo.isCompanyVIP = true;
					vo.companyName = companyTextField.getText();
				}
				if (MockCustomerController.getInstance().updateCustomerInfo(customerVO)) {
					nameText.setText(nameTextField.getText());
					phoneNumberText.setText(phoneTextField.getText());
					if (birthdayDatePicker.getValue() != null) {
						birthdayText.setText(String.valueOf(birthdayDatePicker.getValue()));
					} else {
						birthdayText.setText("无");
					}
					if (companyTextField.getText().equals("")) {
						companyText.setText("无");
					} else {
						companyText.setText(companyTextField.getText());
					}

				}

				editButton.setText("编辑");
			}
		});
		this.add(infoPane, 1, 0, 1, 1);

		this.setHgap(10);
		this.setVgap(20);
	}
}
