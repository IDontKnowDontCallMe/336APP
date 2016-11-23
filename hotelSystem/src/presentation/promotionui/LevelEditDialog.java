package presentation.promotionui;

import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.util.Callback;
import vo.LevelVO;

public class LevelEditDialog extends Dialog{

	final int COLUMN_COUNT=4;
	Text creditDistanceText;
	Text maxLevelText;
	Text discountDistanceText;
	Text percent;
	
	TextField creditDistanceTextField;
	TextField maxLevelTextField;
	TextField discountDistanceTextField;
	HBox creditDistanceBox;
	HBox maxLevelBox;
	HBox discountDistanceBox;
	
	Text title;
	VBox levelMethodBox;
	GridPane gridPane;
	
	public LevelEditDialog(int creditDistance, int maxLevel, double discountDistance){
		super();
		
		gridPane = new GridPane();
		gridPane.setHgap(10);
		gridPane.setVgap(20);
		
		title = new Text("会员等级制度编辑");
		gridPane.add(title, 0, 0,1,1);
		
		creditDistanceText=new Text("增加一级需要的信用值数: ");
		maxLevelText=new Text("最大会员等级: ");
		discountDistanceText=new Text("每升一级, 预订酒店时可享折扣增加百分数: ");
		percent=new Text("%");
		
		creditDistanceTextField=new TextField(String.valueOf(creditDistance));
		creditDistanceTextField.setPrefColumnCount(COLUMN_COUNT);
		creditDistanceTextField.setTooltip(new Tooltip("输入大于0的整数"));
		maxLevelTextField=new TextField(String.valueOf(maxLevel));
		maxLevelTextField.setPrefColumnCount(COLUMN_COUNT);
		maxLevelTextField.setTooltip(new Tooltip("输入大于0的整数"));
		discountDistanceTextField=new TextField(String.valueOf(discountDistance*100));
		discountDistanceTextField.setPrefColumnCount(COLUMN_COUNT);
		discountDistanceTextField.setTooltip(new Tooltip("输入不大于100的整数"));
		
		creditDistanceBox = new HBox();
		maxLevelBox = new HBox();
		discountDistanceBox = new HBox();
		creditDistanceBox.getChildren().addAll(creditDistanceText,creditDistanceTextField);
		maxLevelBox.getChildren().addAll(maxLevelText,maxLevelTextField);
		discountDistanceBox.getChildren().addAll(discountDistanceText,discountDistanceTextField,percent);
		
		levelMethodBox = new VBox();
		levelMethodBox.getChildren().addAll(creditDistanceBox, maxLevelBox, discountDistanceBox);
		gridPane.add(levelMethodBox, 0, 1,1,1);
		
		ButtonType ok = new ButtonType("确认", ButtonData.OK_DONE);
		ButtonType cancel = new ButtonType("取消", ButtonData.CANCEL_CLOSE);
		this.getDialogPane().getButtonTypes().addAll(ok, cancel);
		Callback<ButtonType, LevelVO> resultConverter = new Callback<ButtonType, LevelVO>() {

			
			@Override
			public LevelVO call(ButtonType param) {
				int newCreditDistance = 0;
				int newMaxLevel = 0;
				double newDiscountDistance = 0.0;
				
				if(param.getButtonData() == ButtonData.OK_DONE){
					return new LevelVO(newCreditDistance, newMaxLevel, newDiscountDistance);
				}
				else {
					return null;
				}
			}
		};
		this.setResultConverter(resultConverter);
		
		
		this.getDialogPane().setContent(gridPane);
		
	}
}