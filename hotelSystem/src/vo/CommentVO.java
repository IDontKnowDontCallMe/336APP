package vo;

import java.time.LocalDateTime;

public class CommentVO {

	public int hotelID;
	public String hotelName;
	public String roomName;
	public int customerID;
	public String comment;
	public int score;
	public LocalDateTime producingDateTime;

	public CommentVO(int hotelID, String hotelName, String roomName, int customerID, String comment, int score,
			LocalDateTime producingDateTime) {
		this.hotelID = hotelID;
		this.hotelName = hotelName;
		this.roomName = roomName;
		this.customerID = customerID;
		this.comment = comment;
		this.score = score;
		this.producingDateTime = producingDateTime;
	}

}
