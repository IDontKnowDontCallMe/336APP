package presentation.promotionui;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import vo.WebPromotionVO;

public class WebPromotionCell  extends GridPane{
	
	WebPromotionVO webPromotionVO;
	
	Text webPromotionTypeText;
	Text startTimeText;
	Text endTimeText;
	Text businessCircleNameText;
	Text minNumText;
	Text discountText;
	
	Button editButton;
	Button deleteButton;
	
	public WebPromotionCell(WebPromotionVO webPromotionVO) {
		// TODO Auto-generated constructor stub
		super();
		this.webPromotionVO = webPromotionVO;
		
		webPromotionTypeText = new Text(webPromotionVO.promotionType);
		this.add(webPromotionTypeText, 0, 0, 3, 1);
		if(webPromotionVO.startTime!=null){
			startTimeText = new Text("开始时间: "+webPromotionVO.startTime.toString());
			endTimeText = new Text("结束时间: "+webPromotionVO.endTime.toString());
			this.add(startTimeText, 0,1, 3 ,1);
			this.add(endTimeText, 4,1,3,1);
		}
		if(webPromotionVO.businessCircleName!=null){
			businessCircleNameText = new Text("特定商圈名称: "+webPromotionVO.businessCircleName);
			this.add(businessCircleNameText, 0,1,3,1);
		}
		
		discountText = new Text("折扣: "+webPromotionVO.discount);
		this.add(discountText, 3,0,3,1);
		
		
		editButton = new Button("编辑");
		editButton.addEventHandler(MouseEvent.MOUSE_CLICKED, (MouseEvent e)->{
			System.out.println("edit");
			WebPromotionEditPane webPromotionEditPane = new WebPromotionEditPane(webPromotionVO);
			Scene scene = new Scene(webPromotionEditPane,330,200);
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
