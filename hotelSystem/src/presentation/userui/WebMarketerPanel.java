package presentation.userui;

import java.rmi.RemoteException;
import java.util.List;

import businesslogic.userbl.UserController;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import vo.WebMarketerVO;

public class WebMarketerPanel extends VBox {

	UserController controller = new MockUserController();
	private ScrollPane listPane;
	private VBox webMarketerBox;
	private Text title;

	public WebMarketerPanel() throws RemoteException {
		List<WebMarketerVO> webMarketerList = controller.getWebMarketerList();
		
		webMarketerBox = new VBox();
		webMarketerBox.setSpacing(15);
		buildWebMarketerBox(webMarketerList);
		listPane = new ScrollPane(webMarketerBox);

		title = new Text("网站营销人员列表");
		this.getChildren().addAll(title, listPane);
	}

	public void buildWebMarketerBox(List<WebMarketerVO> webMarketerList) {
		webMarketerBox.getChildren().clear();
		for (WebMarketerVO vo : webMarketerList) {
			webMarketerBox.getChildren().addAll(new WebMarketerCell(vo));
		}
	}
}
