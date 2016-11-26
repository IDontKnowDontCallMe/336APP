package vo;

import java.time.LocalDate;

public class SearchConditionVO {

	public int customerID;
	
	public String hotelName;
	
	public boolean hasRoomTypeLimit;
	public int peopleNumOfRoom;
	
	public boolean hasPriceLimit;
	public int minPrice;
	public int maxPrice;
	
	public boolean hasDateLimit;
	public LocalDate checkInDate;
	public LocalDate checkOutDate;
	public int roomNum;
	
	public boolean hasScoreLimit;
	public int minScore;
	
	public boolean hasCommentScoreLimit;
	public double minCommentScore;
	
	public boolean isInteractive;
	
	public SearchConditionVO(int customerID, String hotelName, boolean hasRoomTypeLimit, int peopleNumOfRoom, boolean hasPriceLimit,
							int minPrice, int maxPrice, boolean hasDateLimit, LocalDate checkInDate, LocalDate checkOutDate, int roomNum,
							boolean hasScoreLimit, int minScore, boolean hasCommentScoreLimit, double minCommentScore, boolean isInteractive) {
		// TODO Auto-generated constructor stub
		this.customerID = customerID;
		this.hotelName = hotelName;
		this.hasRoomTypeLimit = hasRoomTypeLimit;
		this.peopleNumOfRoom = peopleNumOfRoom;
		this.hasPriceLimit = hasPriceLimit;
		this.minPrice = minPrice;
		this.maxPrice = maxPrice;
		this.hasDateLimit = hasDateLimit;
		this.checkInDate = checkInDate;
		this.checkOutDate = checkOutDate;
		this.roomNum = roomNum;
		this.hasScoreLimit = hasScoreLimit;
		this.minScore = minScore;
		this.hasCommentScoreLimit = hasCommentScoreLimit;
		this.minCommentScore = minCommentScore;
		this.isInteractive = isInteractive;
		
	}
}
