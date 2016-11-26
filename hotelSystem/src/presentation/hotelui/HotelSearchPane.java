package presentation.hotelui;

import java.awt.Checkbox;
import java.util.List;
import java.util.Observable;

import businesslogic.hotelbl.HotelController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import presentation.mainui.TheMainFrame;
import vo.AreaVO;
import vo.HotelVO;

public class HotelSearchPane extends VBox{

	private int customerID;
	private AreaVO areaVO;
	
	
	
	public HotelSearchPane(AreaVO areaVO, int customerID) {
		// TODO Auto-generated constructor stub
		this.customerID = customerID;
		this.areaVO = areaVO;
		initSearchPane();
		initSortingPane();
		initHotelListPane();
	}
	
	private void initSearchPane(){
		GridPane gridPane = new GridPane();
		
		Text hotelNameText = new Text("酒店名称");
		TextField hotelNameTextField = new TextField();
		gridPane.add(new HBox(hotelNameText, hotelNameTextField), 0, 0, 3, 1);
		Button searchButton = new Button("搜索");
		Button backButton = new Button("退出搜索");
		gridPane.add(searchButton, 3, 0, 1, 1);
		gridPane.add(backButton, 4, 0, 1, 1);
		
		Text checkInText = new Text("入: ");
		Text checkOutText = new Text("离: ");
		DatePicker checkInDatePicker = new DatePicker();
		DatePicker checkOutDatePicker = new DatePicker();
		Button addButton = new Button("+");
		Button subButton = new Button("-");
		TextField numTextField = new TextField("1");
		numTextField.setEditable(false);
		numTextField.setPrefColumnCount(1);
		gridPane.add(new HBox(checkInText, checkInDatePicker), 0, 1, 2, 1);
		gridPane.add(new HBox(checkOutText,checkOutDatePicker), 2, 1, 2, 1);
		gridPane.add(new HBox(subButton,numTextField,addButton), 4, 1, 1, 1);
		
		ObservableList<String> roomTypeList = FXCollections.observableArrayList("不限","单人间(1人)", "双人房(2人)", "三人房(3人)");
		ChoiceBox<String> roomTypeChoiceBox = new ChoiceBox<>(roomTypeList);
		roomTypeChoiceBox.getSelectionModel().select(0);
		ObservableList<String> priceIntervalList = FXCollections.observableArrayList("不限","0 - 150 ¥", "151 - 300 ¥", "301 - 450 ¥" , "451 - 600 ¥", "601 ¥ 以上");
		ChoiceBox<String> priceIntervalChoiceBox = new ChoiceBox<>(priceIntervalList);
		priceIntervalChoiceBox.getSelectionModel().select(0);
		ObservableList<String> scoreList = FXCollections.observableArrayList("不限","2星以上","3星以上","4星以上","5星"); 
		ChoiceBox<String> scoreChoiceBox = new ChoiceBox<>(scoreList);
		scoreChoiceBox.getSelectionModel().select(0);
		ObservableList<String> commentScoreList = FXCollections.observableArrayList("不限","2分以上","3分以上","4分以上","5分以上");
		ChoiceBox<String> commentScoreChoiceBox = new ChoiceBox<>(commentScoreList);
		commentScoreChoiceBox.getSelectionModel().select(0);
		CheckBox isInteractiveCheckBox = new CheckBox("是独立条件");
		gridPane.add(new HBox(new Text("房间类型"),roomTypeChoiceBox), 0, 2, 1, 1);
		gridPane.add(new HBox(new Text("价格区间"),priceIntervalChoiceBox), 1, 2, 1, 1);
		gridPane.add(new HBox(new Text("星级"),scoreChoiceBox), 2, 2, 1, 1);
		gridPane.add(new HBox(new Text("评分"),commentScoreChoiceBox), 3, 2, 1, 1);
		gridPane.add(isInteractiveCheckBox, 4, 2, 1, 1);
		
		backButton.addEventHandler(MouseEvent.MOUSE_CLICKED, (event)->{
			TheMainFrame.backTo();
		});
		
		this.getChildren().add(gridPane); 
		
	}
	
	private void initSortingPane(){
		HBox hBox = new HBox();
		
		GridPane priceGridPane = new GridPane();
		Text priceText = new Text("价格排序");
		Button priceLowToHighButton = new Button("↑");
		Button priceHighToLowButton = new Button("↓");
		priceGridPane.add(priceText, 0, 0, 1, 2);
		priceGridPane.add(priceLowToHighButton, 1, 0, 1, 1);
		priceGridPane.add(priceHighToLowButton, 1, 1, 1, 1);
		
		GridPane scoreGridPane = new GridPane();
		Text scoreText = new Text("星级排序");
		Button scoreLowToHighButton = new Button("↑");
		Button scoreHighToLowButton = new Button("↓");
		scoreGridPane.add(scoreText, 0, 0, 1, 2);
		scoreGridPane.add(scoreLowToHighButton, 1, 0, 1, 1);
		scoreGridPane.add(scoreHighToLowButton, 1, 1, 1, 1);
		
		GridPane commentGridPane = new GridPane();
		Text commentText = new Text("评分排序");
		Button commentLowToHighButton = new Button("↑");
		Button commentHighToLowButton = new Button("↓");
		commentGridPane.add(commentText, 0, 0, 1, 2);
		commentGridPane.add(commentLowToHighButton, 1, 0, 1, 1);
		commentGridPane.add(commentHighToLowButton, 1, 1, 1, 1);
		
		hBox.getChildren().addAll(priceGridPane,scoreGridPane,commentGridPane);
		this.getChildren().add(hBox);
	}
	
	private void initHotelListPane(){
		List<HotelVO> hotelList = MockHotelController.getInstance().getHotelVOsOfArea(areaVO, customerID);
		HotelListPane hotelListPane = new HotelListPane(hotelList);
		this.getChildren().add(hotelListPane);
	}
	
}