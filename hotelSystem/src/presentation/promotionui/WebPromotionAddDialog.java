package presentation.promotionui;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.util.Callback;
import vo.WebPromotionVO;

public class WebPromotionAddDialog extends Dialog {

	WebPromotionVO webPromotionVO;
	Text webPromotionTypeChoiceText;
	ChoiceBox webPromotionTypeChoiceBox;

	final int COLUMN_COUNT = 10;
	final int YEAR_COLUMN_COUNT = 3;
	final int LESS_COLUMN_COUNT = 2;
	final int BOX_SPACING = 15;
	HBox chooseBox;
	HBox paramBox;
	HBox startBox;
	HBox endBox;
	HBox discountBox;
	VBox promotionBox;
	Button confirmButton;
	Label startTimeLabel;
	Label endTimeLabel;
	Label businessCircleNameLabel;
	Label discountLabel;
	TextField businessCircleNameTextField;
	TextField discountTextField;
	DatePicker startDatePicker;
	DatePicker endDatePicker;
	GridPane gridPane;

	public WebPromotionAddDialog() {
		super();
		gridPane = new GridPane();
		gridPane.setHgap(10);
		gridPane.setVgap(20);

		chooseBox = new HBox();
		chooseBox.setSpacing(BOX_SPACING);
		chooseBox.getChildren().clear();

		webPromotionTypeChoiceText = new Text("请选择新增网站促销策略类型: ");
		ObservableList<String> webPromotionTypeList = FXCollections.observableArrayList("特定时间促销策略", "特定商圈促销策略");
		ChoiceBox<String> webPromotionTypeChoiceBox = new ChoiceBox<>(webPromotionTypeList);

		promotionBox = new VBox();
		promotionBox.setSpacing(BOX_SPACING);
		promotionBox.getChildren().clear();
		promotionBox.setAlignment(Pos.TOP_LEFT);

		Text vacant = new Text("\n\n\n\n\n\n");
		promotionBox.getChildren().add(vacant);
		chooseBox.getChildren().addAll(webPromotionTypeChoiceText, webPromotionTypeChoiceBox);
		gridPane.add(chooseBox, 0, 0, 1, 1);
		gridPane.add(promotionBox, 0, 1, 1, 1);

		ButtonType ok = new ButtonType("确认", ButtonData.OK_DONE);
		ButtonType cancel = new ButtonType("取消", ButtonData.CANCEL_CLOSE);
		this.getDialogPane().getButtonTypes().addAll(ok, cancel);

		webPromotionTypeChoiceBox.getSelectionModel().selectedIndexProperty()
				.addListener((ObservableValue<? extends Number> ov, Number old_val, Number new_val) -> {
					switch (new_val.intValue()) {
					case (0):
						promotionBox.getChildren().clear();
						showTimePromotionBox();
						break;
					case (1):
						promotionBox.getChildren().clear();
						showBusinessCirclePromotionBox();
						break;
					}
				});

		Callback<ButtonType, WebPromotionVO> resultConverter = new Callback<ButtonType, WebPromotionVO>() {

			@Override
			public WebPromotionVO call(ButtonType param) {
				LocalDate startDate = null;
				LocalDate endDate = null;
				String cityName = null;
				String businessCircleName = null;
				double discount = 1.0;

				if (param.getButtonData() == ButtonData.OK_DONE) {
					if (startDatePicker != null) {
						startDate = startDatePicker.getValue();
					}
					if (endDatePicker != null) {
						startDate = startDatePicker.getValue();
					}
					if (businessCircleNameTextField != null) {
						businessCircleName = businessCircleNameTextField.getText();
					}

					if (discountTextField.getText() != null) {
						discount = Double.valueOf(discountTextField.getText());
					}
					return new WebPromotionVO(webPromotionTypeChoiceBox.getValue(), startDate, endDate, cityName,
							businessCircleName, discount);
				} else {
					return null;
				}
			}
		};
		this.setResultConverter(resultConverter);

		this.getDialogPane().setContent(gridPane);
	}

	public HBox showDiscountBox() {
		discountLabel = new Label("输入折扣: ");
		discountTextField = new TextField();
		discountTextField.setPrefColumnCount(COLUMN_COUNT);
		discountTextField.setTooltip(new Tooltip("输入不大于1的小数"));
		discountBox = new HBox();
		discountBox.setSpacing(BOX_SPACING);
		discountBox.getChildren().clear();
		discountBox.getChildren().addAll(discountLabel, discountTextField);

		return discountBox;
	}

	public void showTimePromotionBox() {
		startTimeLabel = new Label("选择起始时间: ");
		endTimeLabel = new Label("选择结束时间: ");
		startDatePicker = new DatePicker();
		endDatePicker = new DatePicker();

		final Callback<DatePicker, DateCell> dayCellFactory = new Callback<DatePicker, DateCell>() {

			@Override
			public DateCell call(final DatePicker datePicker) {
				return new DateCell() {
					public void updateItem(LocalDate item, boolean empty) {
						super.updateItem(item, empty);

						if (item.isBefore(startDatePicker.getValue())) {
							setDisable(true);
							setStyle("-fx-background-color: #ffc0cb;");
						}
						long p = ChronoUnit.DAYS.between(startDatePicker.getValue(), item);
						setTooltip(new Tooltip("持续" + p + "天"));
					}
				};
			}

		};
		endDatePicker.setDayCellFactory(dayCellFactory);

		startBox = new HBox();
		endBox = new HBox();

		startBox.getChildren().addAll(startTimeLabel, startDatePicker);
		endBox.getChildren().addAll(endTimeLabel, endDatePicker);

		promotionBox.getChildren().addAll(startBox, endBox, showDiscountBox());

	}

	public void showBusinessCirclePromotionBox() {
		businessCircleNameLabel = new Label("输入特定商圈名称: ");
		businessCircleNameTextField = new TextField();
		businessCircleNameTextField.setPrefColumnCount(COLUMN_COUNT);
		// 加上城市cityName，并变为复选框
		paramBox = new HBox();
		paramBox.setSpacing(BOX_SPACING);
		paramBox.getChildren().clear();
		paramBox.getChildren().addAll(businessCircleNameLabel, businessCircleNameTextField);

		promotionBox.getChildren().addAll(paramBox, showDiscountBox());
	}
}
