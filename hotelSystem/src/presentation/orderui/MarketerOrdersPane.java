package presentation.orderui;

import java.util.List;

import businesslogic.orderbl.OrderController;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import vo.OrderVO;

public class MarketerOrdersPane extends VBox{

	//以后用工厂模式替换之
	OrderController controller = new MockOrderController();
	
	private HBox radioBox;
	private ToggleGroup toggleGroup;
	private RadioButton abnormalButton;
	
	private ScrollPane listPane;
	private VBox orderBox;
	
	
	public MarketerOrdersPane() {
		// TODO Auto-generated constructor stub
		initRadioButton();
		//OrderController controller = new MockOrderController();
		List<OrderVO> orderList = controller.getAbnormalOrdersOfToday();
		orderBox = new VBox();
		orderBox.setSpacing(15);
		buildOrderBox(orderList);
		listPane = new ScrollPane(orderBox);
		this.getChildren().addAll(radioBox,listPane);
		this.setPrefWidth(500);
	}
	
	private void initRadioButton(){
		toggleGroup = new ToggleGroup();
		abnormalButton = new RadioButton("异常订单");
		abnormalButton.setSelected(true);
		abnormalButton.setUserData("异常");
		abnormalButton.setToggleGroup(toggleGroup);
		
		radioBox = new HBox();
		radioBox.setSpacing(10);
		radioBox.setPrefWidth(500);
		radioBox.getChildren().addAll(abnormalButton);
	}
	
	private void buildOrderBox(List<OrderVO> orderList){
		
		orderBox.getChildren().clear();
		for(OrderVO vo: orderList){
			orderBox.getChildren().add(new MarketerOrderCell(vo));
		}
	}
	
}
