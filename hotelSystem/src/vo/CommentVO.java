package vo;

import java.io.Serializable;
import java.time.LocalDateTime;

public class CommentVO{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public int hotelID;
	public String hotelName;
	public String roomName;
	public int customerID;
	public String comment;
	public double score;
	public LocalDateTime produingDateTime;
	
	public CommentVO(int hotelID, String hotelName, String roomName, int customerID, String comment, double score, LocalDateTime producingDateTime) {
		// TODO Auto-generated constructor stub
		this.hotelID = hotelID;
		this.hotelName = hotelName;
		this.roomName = roomName;
		this.customerID = customerID;
		this.comment = comment;
		this.score = score;
		this.produingDateTime = producingDateTime;
	}
	
}
