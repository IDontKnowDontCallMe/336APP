package presentation.customerui;

import java.util.List;

import com.sun.corba.se.impl.logging.InterceptorsSystemException;

import javafx.beans.InvalidationListener;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.SplitPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.control.ScrollPane.ScrollBarPolicy;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import sun.java2d.pipe.SpanShapeRenderer.Simple;
import vo.CreditVO;
import vo.CustomerVO;


public class CustomerInfoPane extends GridPane {
	
	private int customerID;
	
	private GridPane infoPane;
	private Text nameText;
	private Text phoneNumberText;
	private Text levelText;
	private Text birtdayText;
	private Text companyText;
	private Button setBirthVIPButton;
	private Button setCompanyVIPButton;
	private TextField nameTextField;
	private TextField phoneTextField;
	private Button editButton;
	
	private ScrollPane creditPane;
	
	
	public CustomerInfoPane(int customerID) {
		// TODO Auto-generated constructor stub
		super();
		this.customerID = customerID;
		
		initInfoPane();
		initCreditList();
		this.add(infoPane, 0, 0, 1, 1);
		this.add(creditPane, 0, 1, 2, 1);
	}
	
	private void initInfoPane(){
		CustomerVO customerVO = MockCustomerController.getInstance().getCustomerInfo(customerID);
		
		infoPane = new GridPane();
		
		infoPane.add(new Text("姓名"), 0, 0, 1, 1);
		nameText = new Text(customerVO.customerName);
		infoPane.add(nameText, 1, 0, 1, 1);
		
		infoPane.add(new Text("电话"), 0, 1, 1, 1);
		phoneNumberText = new Text(customerVO.phoneNumber);
		infoPane.add(phoneNumberText, 1, 1, 1, 1);
		
		infoPane.add(new Text("等级"), 0, 2, 1, 1);
		levelText = new Text(String.valueOf(customerVO.level));
		infoPane.add(levelText, 1, 2, 1, 1);
		
		infoPane.add(new Text("生日会员"), 0, 3, 1, 1);
		setBirthVIPButton = new Button("注册");
		infoPane.add(setBirthVIPButton, 1, 3, 1, 1);
		
		infoPane.add(new Text("企业会员"), 0, 4, 1, 1);
		setCompanyVIPButton = new Button("注册");
		infoPane.add(setCompanyVIPButton, 1, 4, 1, 1);
		
		editButton = new Button("编辑");
		infoPane.add(editButton, 2, 1, 1, 1);
		
		nameTextField = new TextField();
		nameTextField.setPrefColumnCount(8);
		phoneTextField = new TextField();
		phoneTextField.setPrefColumnCount(8);
		
		editButton.addEventHandler(MouseEvent.MOUSE_CLICKED	, (event)->{
			if(editButton.getText().equals("编辑")){
				infoPane.getChildren().removeAll(nameText,phoneNumberText);
				infoPane.add(nameTextField, 1, 0, 1, 1);
				infoPane.add(phoneTextField, 1, 1, 1, 1);
				nameTextField.setText(nameText.getText());
				phoneTextField.setText(phoneNumberText.getText());
				editButton.setText("保存");
			}
			else if(editButton.getText().equals("保存")){
				infoPane.getChildren().removeAll(nameTextField	,phoneTextField);
				infoPane.add(nameText, 1, 0, 1, 1);
				infoPane.add(phoneNumberText, 1, 1, 1, 1);
				
				CustomerVO vo = MockCustomerController.getInstance().getCustomerInfo(customerID);
				vo.customerName = nameTextField.getText();
				vo.phoneNumber = phoneTextField.getText();
				if(MockCustomerController.getInstance().updateCustomerInfo(customerVO)){
					nameText.setText(nameTextField.getText());
					phoneNumberText.setText(phoneTextField.getText());
				}
				
				editButton.setText("编辑");
			}
		});
		
		
	}

	private void initCreditList(){
		creditPane = new ScrollPane();
		TableView<CreditCell> tableView = new TableView<>();
		creditPane.setContent(tableView);
		
		TableColumn<CreditCell, String> producingTimeCol = new TableColumn<>("时间");
		producingTimeCol.setCellValueFactory(new PropertyValueFactory<>("producingTime"));
		TableColumn<CreditCell, String> orderIDCol = new TableColumn<>("订单号");
		orderIDCol.setCellValueFactory(new PropertyValueFactory<>("orderID"));
		TableColumn<CreditCell, String> actionCol = new TableColumn<>("原因");
		actionCol.setCellValueFactory(new PropertyValueFactory<>("action"));
		TableColumn<CreditCell, String> creditDeltaCol = new TableColumn<>("变化");
		creditDeltaCol.setCellValueFactory(new PropertyValueFactory<>("creditDelta"));
		TableColumn<CreditCell, String> creditResultCol = new TableColumn<>("结果");
		creditResultCol.setCellValueFactory(new PropertyValueFactory<>("creditResult"));
		
		tableView.getColumns().addAll(producingTimeCol, orderIDCol, actionCol, creditDeltaCol, creditResultCol);
		tableView.setPrefWidth(450);
		List<CreditVO> creditList = MockCustomerController.getInstance().getCreditList(customerID);
		ObservableList<CreditCell> creditCells = FXCollections.observableArrayList();
		for(CreditVO vo: creditList){
			CreditCell cell = new CreditCell(vo);
			creditCells.add(cell);
		}
		
		tableView.setItems(creditCells);
	}
	
	public class CreditCell{
		
		private SimpleStringProperty producingTime;
		private SimpleStringProperty orderID;
		private SimpleStringProperty action;
		private SimpleStringProperty creditDelta;
		private SimpleStringProperty creditResult;
		
		public CreditCell(CreditVO vo) {
			// TODO Auto-generated constructor stub
			producingTime = new SimpleStringProperty(vo.producingDateTime.toString());
			orderID = new SimpleStringProperty(vo.orderID==-1? "无" : String.valueOf(vo.orderID));
			action = new SimpleStringProperty(String.valueOf(vo.action));
			creditDelta = new SimpleStringProperty(String.valueOf(vo.creditDelta));
			creditResult = new SimpleStringProperty(String.valueOf(vo.creditResult));
		}
		
		public void setProducingTime(String s){
			producingTime.set(s);
		}
		
		public String getProducingTime(){
			return producingTime.get();
		}
		
		public void setOrderID(String s){
			orderID.set(s);
		}
		
		public String getOrderID(){
			return orderID.get();
		}
		
		public void setAction(String s){
			action.set(s);
		}
		
		public String getAction(){
			return action.get();
		}
		
		public void setCreditDelta(String s){
			creditDelta.set(s);
		}
		
		public String getCreditDelta(){
			return creditDelta.get();
		}
		
		public void setCreditResult(String s){
			creditResult.set(s);
		}
		
		public String getCreditResult(){
			return creditResult.get();
		}
	}
}