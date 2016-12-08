package presentation.mainui;

import java.rmi.RemoteException;

import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import presentation.orderui.MarketerOrdersPane;
import presentation.promotionui.LevelPanel;
import presentation.promotionui.WebPromotionPanel;
import presentation.userui.CustomerCreditPanel;

public class WebMarketerMainPane extends VBox {

	public WebMarketerMainPane() {
		super();

		Button webPromotionButton = new Button("网站促销策略制定");
		Button levelButton = new Button("会员等级及会员等级促销策略制定");
		Button marketerOrderButton = new Button("异常订单处理");
		Button creditButton = new Button("信用充值");
		Button logoutButton = new Button("注销登录");

		this.getChildren().addAll(webPromotionButton, levelButton, marketerOrderButton, creditButton, logoutButton);
		
		
		webPromotionButton.addEventHandler(MouseEvent.MOUSE_CLICKED, (event) -> {
			try {
				TheMainFrame.jumpTo(new WebPromotionPanel());
			} catch (RemoteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});

		
		levelButton.addEventHandler(MouseEvent.MOUSE_CLICKED, (event) -> {
			TheMainFrame.jumpTo(new LevelPanel());
		});

		marketerOrderButton.addEventHandler(MouseEvent.MOUSE_CLICKED, (event) -> {
			try {
				TheMainFrame.jumpTo(new MarketerOrdersPane());
			} catch (RemoteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});

		creditButton.addEventHandler(MouseEvent.MOUSE_CLICKED, (event) -> {
			try {
				TheMainFrame.jumpTo(new CustomerCreditPanel());
			} catch (RemoteException e) {
				e.printStackTrace();
			}
		});

		logoutButton.addEventHandler(MouseEvent.MOUSE_CLICKED, (event) -> {
			TheMainFrame.backTo();
		});

	}
}
