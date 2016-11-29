package presentation.userui;

import java.util.Optional;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Dialog;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import presentation.userui.CreditDialog;
import vo.CustomerVO;

public class CustomerCreditCell extends GridPane {

	CustomerVO customerVO;
	private int customerID;
	private GridPane infoPane;
	private Text nameText;
	private Text phoneNumberText;
	private Text creditText;
	private Text birthdayText;
	private Text companyText;
	private Button editButton;

	public CustomerCreditCell(CustomerVO customerVO) {
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

		infoPane.add(new Text("信用值"), 0, 2, 1, 1);
		creditText = new Text(String.valueOf(customerVO.credit));
		infoPane.add(creditText, 1, 2, 1, 1);

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

		editButton = new Button("信用充值");
		infoPane.add(editButton, 0, 5, 1, 1);
		editButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				System.out.println("add credit!");
				Dialog<Integer> creditDialog = new CreditDialog(customerVO.customerID);

				Optional<Integer> result = creditDialog.showAndWait();
				if (result.isPresent()) {
					int addCredit = result.get();
					customerVO.credit += addCredit;
					creditText.setText(String.valueOf(customerVO.credit));
					System.out.println("new credit is " + customerVO.credit);
				} else {
					System.out.println("nothing changed");
				}

			}
		});

		this.add(infoPane, 1, 0, 1, 1);

		this.setHgap(10);
		this.setVgap(20);
	}
}
