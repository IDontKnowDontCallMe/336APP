package presentation.userui;

import java.rmi.RemoteException;
import java.util.List;

import businesslogic.userbl.UserController;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import vo.CustomerVO;
import vo.HotelPromotionVO;

public class CustomerInfoPanel extends VBox {

	UserController controller = new MockUserController();
	private ScrollPane listPane;
	private VBox customerBox;
	private Text title;

	public CustomerInfoPanel() throws RemoteException {
		List<CustomerVO> customerList = controller.getCustomerList();
		
		customerBox = new VBox();
		customerBox.setSpacing(15);
		buildCustomerBox(customerList);
		listPane = new ScrollPane(customerBox);

		title = new Text("客户列表");
		this.getChildren().addAll(title, listPane);
	}

	public void buildCustomerBox(List<CustomerVO> customerList) {
		customerBox.getChildren().clear();
		for (CustomerVO vo : customerList) {
			customerBox.getChildren().addAll(new CustomerInfoCell(vo));
		}
	}
}
