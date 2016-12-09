package presentation.hotelui;

import javafx.beans.property.SimpleStringProperty;
import vo.CommentVO;

public class CommentCell {
	private SimpleStringProperty roomName;
	private SimpleStringProperty customerID;
	private SimpleStringProperty comment;
	private SimpleStringProperty score;
	private SimpleStringProperty producingDateTime;

	public CommentCell(CommentVO vo) {

		producingDateTime = new SimpleStringProperty(vo.produingDateTime.toString());
		customerID = new SimpleStringProperty(String.valueOf(vo.customerID));
		comment = new SimpleStringProperty(vo.comment);
		score = new SimpleStringProperty(String.valueOf(vo.score));
		roomName = new SimpleStringProperty(String.valueOf(vo.roomName));
	}

	public void setProducingDateTime(String s) {
		producingDateTime.set(s);
	}

	public String getProducingDateTime() {
		return producingDateTime.get();
	}

	public void setCustomerID(String s) {
		customerID.set(s);
	}

	public String getCustomerID() {
		return customerID.get();
	}

	public void setComment(String s) {
		comment.set(s);
	}

	public String getComment() {
		return comment.get();
	}

	public void setScore(String s) {
		score.set(s);
	}

	public String getScore() {
		return score.get();
	}

	public void setRoomName(String s) {
		roomName.set(s);
	}

	public String getRoomName() {
		return roomName.get();
	}
}
