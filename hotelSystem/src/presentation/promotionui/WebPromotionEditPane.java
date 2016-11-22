package presentation.promotionui;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.util.Callback;
import vo.WebPromotionVO;

public class WebPromotionEditPane  extends GridPane{
	
	WebPromotionVO webPromotionVO;
	
	final int COLUMN_COUNT=10;
	final int YEAR_COLUMN_COUNT=3;
	final int LESS_COLUMN_COUNT=2;
	final int BOX_SPACING=15;
	
	HBox paramBox;
	HBox startBox;
	HBox endBox;
	HBox discountBox;
	VBox promotionBox;
	Text editText;
	Button confirmButton;
	Label startTimeLabel;
	Label endTimeLabel;
	Label businessCircleNameLabel;
	Label discountLabel;
	TextField businessCircleNameTextField;
	TextField discountTextField;
	DatePicker startDatePicker;
	DatePicker endDatePicker;
	
	public WebPromotionEditPane(WebPromotionVO webPromotionVO) {
		super();
		this.setHgap(10);
		this.setVgap(20);
		
		this.webPromotionVO = webPromotionVO;
		editText=new Text("编辑网站促销策略: ");
		this.add(editText, 0, 0,1,1);
		
		promotionBox = new VBox();
		promotionBox.setSpacing(BOX_SPACING);
		promotionBox.getChildren().clear();
		promotionBox.setAlignment(Pos.TOP_LEFT);
		
			switch(webPromotionVO.promotionType){
			case("特定时间促销策略"):
				promotionBox.getChildren().clear();
				showTimePromotionBox();
				break;
			case("特定商圈促销策略"):
				promotionBox.getChildren().clear();
				showBusinessCirclePromotionBox();
				break;
			}
		this.add(promotionBox, 0, 1,1,1);
			
		confirmButton = new Button("确认");
		GridPane.setHalignment(confirmButton, HPos.CENTER);
		this.add(confirmButton,0,2,1,1);
		
		confirmButton.addEventHandler(MouseEvent.MOUSE_CLICKED, (MouseEvent e)->{
			System.out.println("success");
			//关闭窗口
		});
		
		
	}
	
	public void showDiscountBox(){
		discountLabel = new Label("输入折扣: ");
		discountTextField = new TextField();
		discountTextField.setPrefColumnCount(COLUMN_COUNT);
		discountTextField.setTooltip(new Tooltip("输入不大于1的小数"));
		discountTextField.setText(String.valueOf(webPromotionVO.discount));
		
		discountBox = new HBox();
		discountBox.setSpacing(BOX_SPACING);
		discountBox.getChildren().clear();
		discountBox.getChildren().addAll(discountLabel,discountTextField);
		
		promotionBox.getChildren().add(discountBox);
	}
	
	public void showTimePromotionBox(){
		startTimeLabel = new Label("选择起始时间: ");
		endTimeLabel = new Label("选择结束时间: ");
		startDatePicker=new DatePicker();
		startDatePicker.setValue(webPromotionVO.startTime);
		endDatePicker=new DatePicker();
		endDatePicker.setValue(webPromotionVO.endTime);
		
		final Callback<DatePicker,DateCell> dayCellFactory = new Callback<DatePicker,DateCell>(){

			@Override
			public DateCell call(final DatePicker datePicker) {
				return new DateCell(){
					public void updateItem(LocalDate item,boolean empty){
						super.updateItem(item,empty);
						
						if(item.isBefore(startDatePicker.getValue())){
							setDisable(true);
							setStyle("-fx-background-color: #ffc0cb;");
						}
						long p=ChronoUnit.DAYS.between(startDatePicker.getValue(), item);
						setTooltip(new Tooltip("持续"+p+"天"));
					}
				};
			}
			
		};
		endDatePicker.setDayCellFactory(dayCellFactory);
		
		
		startBox=new HBox();
		endBox=new HBox();
		
		startBox.getChildren().addAll(startTimeLabel,startDatePicker);
		endBox.getChildren().addAll(endTimeLabel,endDatePicker);
		
		promotionBox.getChildren().addAll(startBox,endBox);
		showDiscountBox();
			
	}
	
	public void showBusinessCirclePromotionBox(){
		businessCircleNameLabel = new Label("输入特定商圈名称: ");
		businessCircleNameTextField = new TextField();
		businessCircleNameTextField.setText(webPromotionVO.businessCircleName);
		businessCircleNameTextField.setPrefColumnCount(COLUMN_COUNT);
		
		paramBox = new HBox();
		paramBox.setSpacing(BOX_SPACING);
		paramBox.getChildren().clear();
		paramBox.getChildren().addAll(businessCircleNameLabel,businessCircleNameTextField);

		promotionBox.getChildren().add(paramBox);
		showDiscountBox();
	}
}
