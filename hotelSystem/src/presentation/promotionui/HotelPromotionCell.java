package presentation.promotionui;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import vo.HotelPromotionVO;

public class HotelPromotionCell  extends GridPane{
	
	HotelPromotionVO hotelPromotionVO;
	
	Text hotelPromotionTypeText;
	Text startTimeText;
	Text endTimeText;
	Text companyNameText;
	Text minNumText;
	Text discountText;
	
	Button editButton;
	Button deleteButton;
	
	public HotelPromotionCell(HotelPromotionVO hotelPromotionVO) {
		// TODO Auto-generated constructor stub
		super();
		this.hotelPromotionVO = hotelPromotionVO;
		
		hotelPromotionTypeText = new Text(hotelPromotionVO.promotionType);
		this.add(hotelPromotionTypeText, 0, 0, 3, 1);
		if(hotelPromotionVO.startTime!=null){
			startTimeText = new Text("开始时间: "+hotelPromotionVO.startTime.toString());
			endTimeText = new Text("结束时间: "+hotelPromotionVO.endTime.toString());
			this.add(startTimeText, 0,1, 3 ,1);
			this.add(endTimeText, 4,1,3,1);
		}
		if(hotelPromotionVO.companyName!=null){
			companyNameText = new Text("合作企业名称: "+hotelPromotionVO.companyName);
			this.add(companyNameText, 0,1,3,1);
		}
		if(hotelPromotionVO.minNum!=-1){
			minNumText = new Text("最小预订房间数量: "+hotelPromotionVO.minNum);
			this.add(minNumText, 0,1,3,1);
		}
		discountText = new Text("折扣: "+hotelPromotionVO.discount);
		this.add(discountText, 3,0,3,1);
		
		
		editButton = new Button("编辑");
		editButton.addEventHandler(MouseEvent.MOUSE_CLICKED, (MouseEvent e)->{
			System.out.println("edit");
			HotelPromotionEditPane hotelPromotionEditPane = new HotelPromotionEditPane(hotelPromotionVO);
			Scene scene = new Scene(hotelPromotionEditPane,330,200);
			Stage stage=new Stage();
			stage.setScene(scene);
			stage.show();
		});
		
		deleteButton = new Button("删除");
		deleteButton.addEventHandler(MouseEvent.MOUSE_CLICKED, (MouseEvent e)->{
			System.out.println("delete");
		});
		
		this.add(editButton, 10,0, 1, 1);
		this.add(deleteButton, 12,0,1,1);
		
		this.setHgap(10);
		this.setVgap(20);
		
	}
	
	
}
