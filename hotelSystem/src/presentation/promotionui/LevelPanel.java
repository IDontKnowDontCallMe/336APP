package presentation.promotionui;

import businesslogic.promotionbl.PromotionController;
import javafx.geometry.HPos;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

public class LevelPanel extends VBox{

	PromotionController controller = new MockPromotionController();
	Text levelMethod;
	Button confirmButton;
	Button editButton;
	HBox buttonBox;
	
	public LevelPanel(){
		int creditDistance=controller.getLevelMethod().creditDistance;
		int maxLevel=controller.getLevelMethod().maxLevel;
		double discountDistance=controller.getLevelMethod().discountDistance;
		levelMethod=new Text("会员等级制度: \n1. 每增加"+creditDistance+"信用值升一级;\n"
				+ "2. 最大会员等级为"+maxLevel+"级;\n"+""
				+ "3. 每升一级, 预订酒店时可享折扣增加"+discountDistance*100+"%.");
		this.getChildren().add(levelMethod);
		
		confirmButton = new Button("确认");
		editButton = new Button("编辑");
		buttonBox = new HBox();
		buttonBox.getChildren().addAll(confirmButton,editButton);
		this.getChildren().add(buttonBox);
		
	}
}