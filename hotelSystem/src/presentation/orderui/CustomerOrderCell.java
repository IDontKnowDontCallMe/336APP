package presentation.orderui;

import java.text.SimpleDateFormat;

import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import vo.OrderVO;

public class CustomerOrderCell extends GridPane{
	
	OrderVO orderVO;
	
	Text hotelText;
	Text roomText;
	Text checkInText;
	Text checkOutText;
	Text numText;
	Text childrenText;
	Text totalText;
	Text stateText;
	Button button;
	
	public CustomerOrderCell(OrderVO orderVO) {
		// TODO Auto-generated constructor stub
		super();
		this.orderVO = orderVO;
		
		hotelText = new Text(orderVO.hotelName);
		this.add(hotelText, 0, 0, 3, 1);
		stateText = new Text(orderVO.orderState);
		this.add(stateText, 4, 0, 1 ,1);
		roomText = new Text(orderVO.roomName);
		this.add(roomText, 0, 1, 2, 1);
		totalText = new Text("¥" + String.valueOf(orderVO.total));
		this.add(totalText, 4, 1, 1, 1);
		checkInText = new Text("入 " + orderVO.checkInTime.toString());
		this.add(checkInText, 0, 2, 1, 1);
		checkOutText = new Text("离" + orderVO.checkOutTime.toString());
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
			setRevokeButton();
		}
		else if(state.equals("已执行")){
			setCommentButton();
		}
		else{
			button = null;
		}
	}
	
	private void setRevokeButton(){
		button = new Button("撤销");
		button.addEventHandler(MouseEvent.MOUSE_CLICKED, (MouseEvent e)->{
			System.out.println("revoke");
		});
	}

	private void setCommentButton(){
		button = new Button("评价");
		button.addEventHandler(MouseEvent.MOUSE_CLICKED, (MouseEvent e)->{
			System.out.println("comment");
		});
	}
}
