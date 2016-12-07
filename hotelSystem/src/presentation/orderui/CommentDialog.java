package presentation.orderui;

import java.time.LocalDateTime;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Dialog;
import javafx.scene.control.TextArea;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.util.Callback;
import vo.CommentVO;
import vo.OrderVO;

public class CommentDialog extends Dialog {

	final int WIDTH_COUNT = 300;
	final int HEIGHT_COUNT = 200;
	GridPane gridPane;
	private TextArea commentTextArea;

	public CommentDialog(OrderVO vo) {
		super();
		gridPane = new GridPane();
		gridPane.setHgap(10);
		gridPane.setVgap(20);

		gridPane.add(new Text("评分"), 0, 0, 1, 1);

		ObservableList<Integer> scoreList = FXCollections.observableArrayList(1, 2, 3, 4, 5);
		ChoiceBox<Integer> scoreBox = new ChoiceBox<>(scoreList);

		gridPane.add(scoreBox, 1, 0, 1, 1);
		gridPane.add(new Text("评价"), 0, 1, 1, 1);

		commentTextArea = new TextArea();
		commentTextArea.setPrefSize(WIDTH_COUNT, HEIGHT_COUNT);
		commentTextArea.setWrapText(true);
		gridPane.add(commentTextArea, 1, 1, 1, 1);

		ButtonType ok = new ButtonType("确认", ButtonData.OK_DONE);
		ButtonType cancel = new ButtonType("取消", ButtonData.CANCEL_CLOSE);
		this.getDialogPane().getButtonTypes().addAll(ok, cancel);

		Callback<ButtonType, CommentVO> resultConverter = new Callback<ButtonType, CommentVO>() {

			@Override
			public CommentVO call(ButtonType param) {

				if (param.getButtonData() == ButtonData.OK_DONE) {
					String comment = commentTextArea.getText();
					System.out.print("订单评价时间为" + LocalDateTime.now());
					return new CommentVO(0, vo.hotelName, vo.roomName, vo.customerID, comment, scoreBox.getValue(),
							LocalDateTime.now());// hotelID?
				} else {
					return null;
				}
			}
		};
		this.setResultConverter(resultConverter);

		this.getDialogPane().setContent(gridPane);
	}
}
