package presentation.promotionui;
	
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.util.Callback;
import vo.HotelPromotionVO;

public class HotelPromotionAddPane extends GridPane{

	HotelPromotionVO hotelPromotionVO;
	Text hotelPromotionTypeChoiceText;
	final ChoiceBox hotelPromotionTypeChoiceBox;
	
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
	Label companyNameLabel;
	Label minNumLabel;
	Label discountLabel;
	TextField companyNameTextField;
	TextField minNumTextField;
	TextField discountTextField;
	DatePicker startDatePicker;
	DatePicker endDatePicker;
	
	
	public HotelPromotionAddPane(){
		super();
		this.setHgap(10);
		this.setVgap(20);
		
		chooseBox = new HBox();
		chooseBox.setSpacing(BOX_SPACING);
		chooseBox.getChildren().clear();
		
		hotelPromotionTypeChoiceText = new Text("请选择新增酒店促销策略类型: ");
		hotelPromotionTypeChoiceBox = new ChoiceBox(FXCollections.observableArrayList
				("预订多间促销策略", "特定时间促销策略","合作企业促销策略","客户生日促销策略"));
		
		promotionBox = new VBox();
		promotionBox.setSpacing(BOX_SPACING);
		promotionBox.getChildren().clear();
		promotionBox.setAlignment(Pos.TOP_LEFT);
		
		hotelPromotionTypeChoiceBox.getSelectionModel().selectedIndexProperty().addListener(
				(ObservableValue <? extends Number> ov, Number old_val, Number new_val)->{
				switch(new_val.intValue()){
				//预订多间促销策略
				case(0):
					promotionBox.getChildren().clear();
					showRoomPromotionBox();
					break;
				case(1):
					promotionBox.getChildren().clear();
					showTimePromotionBox();
					break;
				case(2):
					promotionBox.getChildren().clear();
					showCompanyPromotionBox();
					break;
				case(3):
					promotionBox.getChildren().clear();
					showBirthdayPromotionBox();
					break;
				}
				});
		
		chooseBox.getChildren().addAll(hotelPromotionTypeChoiceText,hotelPromotionTypeChoiceBox);
		promotionBox.getChildren().add(chooseBox);
		this.add(promotionBox, 0, 0,1,1);
		
		ButtonType okButton=new ButtonType("确定", ButtonData.OK_DONE);
		ButtonType cancelButton=new ButtonType("取消", ButtonData.CANCEL_CLOSE);
		
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
	
	public void showRoomPromotionBox(){
		minNumLabel = new Label("输入最小房间数量: ");
		minNumTextField = new TextField();
		minNumTextField.setPrefColumnCount(COLUMN_COUNT);
		minNumTextField.setTooltip(new Tooltip("输入不小于0的整数"));
		paramBox = new HBox();
		paramBox.setSpacing(BOX_SPACING);
		paramBox.getChildren().clear();
		paramBox.getChildren().addAll(minNumLabel,minNumTextField);

		promotionBox.getChildren().addAll(chooseBox,paramBox);
		showDiscountBox();
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
	
	public void showCompanyPromotionBox(){
		companyNameLabel = new Label("输入合作企业名称: ");
		companyNameTextField = new TextField();
		companyNameTextField.setPrefColumnCount(COLUMN_COUNT);
		
		paramBox = new HBox();
		paramBox.setSpacing(BOX_SPACING);
		paramBox.getChildren().clear();
		paramBox.getChildren().addAll(companyNameLabel,companyNameTextField);

		promotionBox.getChildren().addAll(chooseBox,paramBox);
		showDiscountBox();
	}
	
	public void showBirthdayPromotionBox(){
		promotionBox.getChildren().addAll(chooseBox);
		showDiscountBox();
	}
	

}
