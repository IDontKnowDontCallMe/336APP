package presentation.customerui;

import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.SplitPane;
import javafx.scene.control.TextField;
import javafx.scene.control.ScrollPane.ScrollBarPolicy;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;

//��ʾ�ͻ���Ϣ�����
public class CustomerInfoPanel {
	
	//��ʾ�ÿͻ������ñ仯�б�
	public void getCredit(){
		
	}
	
	//��ʾĳһ�����ñ仯�ľ�����Ϣ
	public void getConcreteCredit(){
		
	}
	
	//��ʾ�ÿͻ��Ļ�����Ϣ
	public void getInfo(){
		
	}
	
	//��ʾ�༭������Ϣ�Ľ���
	public void getInfoEdit(){
		SplitPane pane = new SplitPane();
        pane.setOrientation(Orientation.VERTICAL);

		ScrollPane scrollPane = new ScrollPane();
		scrollPane.fitToHeightProperty();
		scrollPane.setVbarPolicy(ScrollBarPolicy.ALWAYS);
		AnchorPane concreteCredit = new AnchorPane();
		
		GridPane credit = new GridPane();
		credit.setHgap(10);
		credit.setVgap(10);
		credit.setPadding(new Insets(10, 10, 10, 10));
		scrollPane.setContent(credit);
		
		for (int i = 0; i < 15; i++) {
			Label jLabel = new Label("1");
			credit.add(jLabel, 0, i);
		}
		
		SplitPane creditPane = new SplitPane();
		creditPane.getItems().addAll(scrollPane,concreteCredit);
		
        creditPane.setDividerPositions(0.4, 0.7);

		
		AnchorPane customerInfo = new AnchorPane();
		GridPane CustomerInfo = new GridPane();

		customerInfo.getChildren().add(CustomerInfo);
		customerInfo.setLeftAnchor(CustomerInfo, 50.0);
		customerInfo.setTopAnchor(CustomerInfo, 50.0);

		
		CustomerInfo.setAlignment(Pos.CENTER);
		CustomerInfo.setHgap(10);
		CustomerInfo.setVgap(10);
		CustomerInfo.setPadding(new Insets(10, 10, 10, 10));

        Label userName = new Label("姓名:");
        CustomerInfo.add(userName, 0, 1);
        TextField userTextField = new TextField("姜泽泯");
        userTextField.setEditable(false);
        userTextField.setBackground(null);
        CustomerInfo.add(userTextField, 1, 1);

        Label birthday = new Label("生日:");
        CustomerInfo.add(birthday, 0, 2);
        TextField birthdayfield = new TextField();
        birthdayfield.setEditable(false);
        birthdayfield.setBackground(null);
        CustomerInfo.add(birthdayfield, 1, 2);
        
        Label address = new Label("家庭住址:");
        CustomerInfo.add(address, 0, 3);
        TextField addressfield = new TextField();
        addressfield.setEditable(false);
        addressfield.setBackground(null);
        CustomerInfo.add(addressfield, 1, 3);

        Button btn = new Button("编辑");
        HBox hbBtn = new HBox(10);
        hbBtn.setAlignment(Pos.BOTTOM_RIGHT);
        hbBtn.getChildren().add(btn);
        CustomerInfo.add(hbBtn, 0, 4);
        
        pane.getItems().addAll(customerInfo,creditPane);
	}
	
	//��ʾע���Ա�Ľ���
	public void registerVIP(){
		
	}
	
	//ֹͣ��ʾ�����
	public void back(){
		
	}

}
