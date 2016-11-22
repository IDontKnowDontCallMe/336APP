package presentation.promotionui;
	
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
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

public class WebPromotionAddPane extends GridPane{

	WebPromotionVO webPromotionVO;
	Text webPromotionTypeChoiceText;
	final ChoiceBox webPromotionTypeChoiceBox;
	
	final int COLUMN_COUNT=10;
	final int YEAR_COLUMN_COUNT=3;
	final int LESS_COLUMN_COUNT=2;
	final int BOX_SPACING=15;
	HBox chooseBox;
	HBox paramBox;
	HBox startBox;
	HBox endBox;
	HBox discountBox;
	VBox promotionBox;
	Button confirmButton;
	Label startTimeLabel;
	Label endTimeLabel;
	Label businessCircleNameLabel;
	Label discountLabel;
	TextField businessCircleNameTextField;
	TextField discountTextField;
	DatePicker startDatePicker;
	DatePicker endDatePicker;
	
	
	public WebPromotionAddPane(){
		super();
		this.setHgap(10);
		this.setVgap(20);
		
		chooseBox = new HBox();
		chooseBox.setSpacing(BOX_SPACING);
		chooseBox.getChildren().clear();
		
		webPromotionTypeChoiceText = new Text("请选择新增网站促销策略类型: ");
		webPromotionTypeChoiceBox = new ChoiceBox(FXCollections.observableArrayList
				("特定时间促销策略","特定商圈促销策略"));
		
		promotionBox = new VBox();
		promotionBox.setSpacing(BOX_SPACING);
		promotionBox.getChildren().clear();
		promotionBox.setAlignment(Pos.TOP_LEFT);
		
		webPromotionTypeChoiceBox.getSelectionModel().selectedIndexProperty().addListener(
				(ObservableValue <? extends Number> ov, Number old_val, Number new_val)->{
				switch(new_val.intValue()){
				//预订多间促销策略
				case(0):
					promotionBox.getChildren().clear();
					showTimePromotionBox();
					break;
				case(1):
					promotionBox.getChildren().clear();
					showBusinessCirclePromotionBox();
					break;
				}
				});
		
		chooseBox.getChildren().addAll(webPromotionTypeChoiceText,webPromotionTypeChoiceBox);
		promotionBox.getChildren().add(chooseBox);
		this.add(promotionBox, 0, 0,1,1);
		
		confirmButton = new Button("确认");
	    GridPane.setHalignment(confirmButton, HPos.CENTER);
		this.add(confirmButton,0,1,1,1);
		
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
		endDatePicker=new DatePicker();
		
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
		
		promotionBox.getChildren().addAll(chooseBox,startBox,endBox);
		showDiscountBox();
			
	}
	
	public void showBusinessCirclePromotionBox(){
		businessCircleNameLabel = new Label("输入特定商圈名称: ");
		businessCircleNameTextField = new TextField();
		businessCircleNameTextField.setPrefColumnCount(COLUMN_COUNT);
		
		paramBox = new HBox();
		paramBox.setSpacing(BOX_SPACING);
		paramBox.getChildren().clear();
		paramBox.getChildren().addAll(businessCircleNameLabel,businessCircleNameTextField);

		promotionBox.getChildren().addAll(chooseBox,paramBox);
		showDiscountBox();
	}
}
