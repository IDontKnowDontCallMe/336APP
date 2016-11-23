package presentation.promotionui;

import businesslogic.promotionbl.PromotionController;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

public class LevelDialog extends Dialog{

	PromotionController controller = new MockPromotionController();
	Text creditDistanceText;
	Text maxLevelText;
	Text discountDistanceText;
	VBox levelMethodBox;
	Text title;
	Button editButton;
	HBox titleBox;
	GridPane gridPane;
	
	public LevelDialog(){
		super();
		
		gridPane = new GridPane();
		gridPane.setHgap(10);
		gridPane.setVgap(20);
		
		int creditDistance=controller.getLevelMethod().creditDistance;
		int maxLevel=controller.getLevelMethod().maxLevel;
		double discountDistance=controller.getLevelMethod().discountDistance;
		
		title = new Text("会员等级制度");
		editButton = new Button("编辑");
		titleBox = new HBox();
		titleBox.getChildren().addAll(title,editButton);
		gridPane.add(titleBox, 0, 0,1,1);
		
		creditDistanceText=new Text("增加一级需要的信用值数: "+creditDistance);
		maxLevelText=new Text("最大会员等级: "+maxLevel);
		discountDistanceText=new Text("每升一级, 预订酒店时可享折扣增加百分数: "+discountDistance*100+"%");
		levelMethodBox = new VBox();
		levelMethodBox.getChildren().addAll(creditDistanceText, maxLevelText, discountDistanceText);
		gridPane.add(levelMethodBox, 0, 1,1,1);
		
		ButtonType ok = new ButtonType("确认", ButtonData.OK_DONE);
		this.getDialogPane().getButtonTypes().addAll(ok);
		
		editButton.addEventHandler(MouseEvent.MOUSE_CLICKED, (MouseEvent e)->{
			System.out.println("edit");
			LevelEditDialog levelEditDialog = new LevelEditDialog(creditDistance,
					maxLevel, discountDistance);
			levelEditDialog.show();
		});
		this.getDialogPane().setContent(gridPane);
		
	}
}