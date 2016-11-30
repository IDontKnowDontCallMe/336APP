package presentation.promotionui;

import java.util.List;

import businesslogic.promotionbl.PromotionController;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import presentation.mainui.TheMainFrame;
import vo.WebPromotionVO;

public class WebPromotionPanel extends VBox {

	PromotionController controller = new MockPromotionController();
	private ScrollPane listPane;
	private VBox webPromotionBox;
	private HBox addBox;
	private Button addButton;
	private Button backButton;
	private Text title;

	public WebPromotionPanel() {

		List<WebPromotionVO> webPromotionList = controller.getWebPromotionList();
		webPromotionBox = new VBox();
		webPromotionBox.setSpacing(15);
		buildWebPromotionBox(webPromotionList);
		listPane = new ScrollPane(webPromotionBox);

		title = new Text("网站促销策略");
		addButton = new Button("新增");
		addButton.addEventHandler(MouseEvent.MOUSE_CLICKED, (MouseEvent e) -> {
			System.out.println("add");
			WebPromotionAddDialog webPromotionAddDialog = new WebPromotionAddDialog();
			webPromotionAddDialog.show();
		});

		backButton = new Button("返回");
		backButton.addEventHandler(MouseEvent.MOUSE_CLICKED, (event) -> {
			TheMainFrame.backTo();
		});
		addBox = new HBox();
		addBox.setSpacing(10);
		addBox.setPrefWidth(500);
		addBox.getChildren().addAll(title, addButton, backButton);
		this.getChildren().addAll(addBox, listPane);
	}

	private void buildWebPromotionBox(List<WebPromotionVO> webPromotionList) {
		webPromotionBox.getChildren().clear();
		for (WebPromotionVO vo : webPromotionList) {
			webPromotionBox.getChildren().add(new WebPromotionCell(vo));
		}
	}
}
