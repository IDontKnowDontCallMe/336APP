package vo;

public class HotelVO {
	
	public int hotelID;
	public String hotelName;
	public String city;
	public String businessCircle;
	public String introduction;
	public String service;
	public int score;
	public double commentScore;
	public String workerName;
	public String phoneNumber;
	
	public String bookedTag;
	
	public HotelVO(int hotelID, String hotelName, String city, String businessCircle, String introduction, String service,
					int score, double commentScore, String workerName, String phoneNumber, String bookedTag) {
		// TODO Auto-generated constructor stub
		this.hotelID = hotelID;
		this.hotelName = hotelName;
		this.city = city;
		this.businessCircle = businessCircle;
		this.introduction = introduction;
		this.service = service;
		this.score = score;
		this.commentScore = commentScore;
		this.workerName = workerName;
		this.phoneNumber = phoneNumber;
		this.bookedTag = bookedTag;
	}

}
