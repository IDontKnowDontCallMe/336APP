package presentation.promotionui;

import businesslogic.promotionbl.PromotionController;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import presentation.customerui.MockCustomerController;
import vo.CustomerVO;
import vo.LevelVO;

public class LevelDialog extends Dialog{

	final int COLUMN_COUNT=4;
	Text creditDistanceTitle;
	Text maxLevelTitle;
	Text discountDistanceTitle;
	Text creditDistanceText;
	Text maxLevelText;
	Text discountDistanceText;
	Text percent;
	Text title;
	Text vacant;
	
	Button editButton;
	TextField creditDistanceTextField;
	TextField maxLevelTextField;
	TextField discountDistanceTextField;
	HBox creditDistanceBox;
	HBox maxLevelBox;
	HBox discountDistanceBox;
	HBox titleBox;
	
	VBox levelMethodBox;
	GridPane gridPane;
	PromotionController controller = new MockPromotionController();
	
	public LevelDialog(){
		super();
		LevelVO levelVO = MockPromotionController.getInstance().getLevelMethod();
		
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
		
		creditDistanceTitle=new Text("增加一级需要的信用值数: ");
		maxLevelTitle=new Text("最大会员等级: ");
		discountDistanceTitle=new Text("每升一级, 预订酒店时可享折扣增加百分数: ");
		percent=new Text("%");
		
		creditDistanceTextField=new TextField();
		creditDistanceTextField.setPrefColumnCount(COLUMN_COUNT);
		creditDistanceTextField.setTooltip(new Tooltip("输入大于0的整数"));
		maxLevelTextField=new TextField();
		maxLevelTextField.setPrefColumnCount(COLUMN_COUNT);
		maxLevelTextField.setTooltip(new Tooltip("输入大于0的整数"));
		discountDistanceTextField=new TextField();
		discountDistanceTextField.setPrefColumnCount(COLUMN_COUNT);
		discountDistanceTextField.setTooltip(new Tooltip("输入不大于100的整数"));
		
		creditDistanceText=new Text(String.valueOf(creditDistance));
		maxLevelText=new Text(String.valueOf(maxLevel));
		discountDistanceText=new Text(String.valueOf(discountDistance*100)+"            ");
		
		creditDistanceBox = new HBox();
		maxLevelBox = new HBox();
		discountDistanceBox = new HBox();
		creditDistanceBox.getChildren().addAll(creditDistanceTitle,creditDistanceText);
		maxLevelBox.getChildren().addAll(maxLevelTitle,maxLevelText);
		discountDistanceBox.getChildren().addAll(discountDistanceTitle,discountDistanceText,percent);
		
		vacant = new Text("\n");
		levelMethodBox = new VBox();
		levelMethodBox.getChildren().addAll(creditDistanceBox, maxLevelBox, discountDistanceBox,vacant);
		gridPane.add(levelMethodBox, 0, 1,1,1);
		
		editButton.addEventHandler(MouseEvent.MOUSE_CLICKED	, (event)->{
			if(editButton.getText().equals("编辑")){
				creditDistanceBox.getChildren().remove(creditDistanceText);
				maxLevelBox.getChildren().remove(maxLevelText);
				discountDistanceBox.getChildren().removeAll(discountDistanceText,percent);
				levelMethodBox.getChildren().remove(vacant);
				
				creditDistanceBox.getChildren().add(creditDistanceTextField);
				maxLevelBox.getChildren().add(maxLevelTextField);
				discountDistanceBox.getChildren().addAll(discountDistanceTextField,percent);
				
				creditDistanceTextField.setText(creditDistanceText.getText());
				maxLevelTextField.setText(maxLevelText.getText());
				discountDistanceTextField.setText(discountDistanceText.getText());
				
				editButton.setText("保存");
			}
			else if(editButton.getText().equals("保存")){
				creditDistanceBox.getChildren().remove(creditDistanceTextField);
				maxLevelBox.getChildren().remove(maxLevelTextField);
				discountDistanceBox.getChildren().removeAll(discountDistanceTextField,percent);
				
				creditDistanceBox.getChildren().add(creditDistanceText);
				maxLevelBox.getChildren().add(maxLevelText);
				discountDistanceBox.getChildren().addAll(discountDistanceText,percent);
				levelMethodBox.getChildren().add(vacant);
				
				creditDistanceText.setText(creditDistanceTextField.getText());
				maxLevelText.setText(maxLevelTextField.getText());
				discountDistanceText.setText(discountDistanceTextField.getText());
				
				editButton.setText("编辑");
				
				LevelVO vo = MockPromotionController.getInstance().getLevelMethod();
				vo.creditDistance = Integer.parseInt(creditDistanceTextField.getText());
				vo.maxLevel = Integer.parseInt(maxLevelTextField.getText());
				vo.discountDistance = Integer.parseInt(discountDistanceTextField.getText());
				
				if(MockPromotionController.getInstance().updateLevelInfo(levelVO)){
					creditDistanceText.setText(creditDistanceTextField.getText());
					maxLevelText.setText(maxLevelTextField.getText());
					discountDistanceText.setText(discountDistanceTextField.getText());
				}
				
			}
		});
		
		ButtonType ok = new ButtonType("确认", ButtonData.OK_DONE);
		this.getDialogPane().getButtonTypes().addAll(ok);
				
		this.getDialogPane().setContent(gridPane);
		
	}
}