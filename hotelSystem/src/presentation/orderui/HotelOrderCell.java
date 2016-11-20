package presentation.orderui;

import java.text.SimpleDateFormat;

import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import vo.OrderVO;

public class HotelOrderCell extends GridPane{

	OrderVO orderVO;
	
	Text customerNameText;
	Text customerPhoneText;
	Text roomText;
	Text checkInText;
	Text checkOutText;
	Text numText;
	Text childrenText;
	Text totalText;
	Text stateText;
	Button button;
	
	public HotelOrderCell(OrderVO orderVO) {
		// TODO Auto-generated constructor stub
		super();
		this.orderVO = orderVO;
		
		customerNameText = new Text(orderVO.customerName);
		this.add(customerNameText, 0, 0, 1, 1);
		customerPhoneText = new Text(orderVO.customerPhoneNumber);
		this.add(customerPhoneText, 1, 0, 2, 1);
		stateText = new Text(orderVO.orderState);
		this.add(stateText, 4, 0, 1 ,1);
		roomText = new Text(orderVO.roomName);
		this.add(roomText, 0, 1, 2, 1);
		totalText = new Text("¥" + String.valueOf(orderVO.total));
		this.add(totalText, 4, 1, 1, 1);
		SimpleDateFormat format = new SimpleDateFormat("yyyy-mm-dd");
		checkInText = new Text("入 " + format.format(orderVO.checkInTime));
		this.add(checkInText, 0, 2, 1, 1);
		checkOutText = new Text("离" + format.format(orderVO.checkOutTime));
		this.add(checkOutText, 1, 2, 1, 1);
		numText = new Text(String.valueOf(orderVO.roomNum) + "间");
		this.add(numText, 1, 1, 1, 1);
		childrenText = new Text(orderVO.hasChildren? "有" : "无" + "儿童");
		this.add(childrenText, 2, 1, 1, 1);
		
		setButton(orderVO.orderState);
		if(button!=null){
			this.add(button, 4, 2, 1, 1);
		}
		
		this.setHgap(10);
		this.setVgap(20);
		
	}
	
	private void setButton(String state){
		if(state.equals("正常")){
			setExecutingButton();
		}
		else if(state.equals("异常")){
			setDelayInButton();
		}
		else{
			button = null;
		}
	}
	
	private void setExecutingButton(){
		button = new Button("执行订单");
		button.addEventHandler(MouseEvent.MOUSE_CLICKED, (MouseEvent e)->{
			System.out.println("excute");
		});
	}

	private void setDelayInButton(){
		button = new Button("延迟入住");
		button.addEventHandler(MouseEvent.MOUSE_CLICKED, (MouseEvent e)->{
			System.out.println("delay in");
		});
	}
	
}
