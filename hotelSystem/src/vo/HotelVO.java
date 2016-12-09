package vo;

import java.io.Serializable;

public class HotelVO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public int hotelID;
	public String hotelName;
	public String city;
	public String businessCircle;
	public String address;
	public String introduction;
	public String service;
	public int score;
	public double commentScore;
	public String workerName;
	public String phoneNumber;

	public int minPrice;
	public int bookedTag;

	public HotelVO(int hotelID, String hotelName, String city, String businessCircle, String address,
			String introduction, String service, int score, double commentScore, String workerName, String phoneNumber,
			int minPrice, int bookedTag) {
		this.hotelID = hotelID;
		this.hotelName = hotelName;
		this.city = city;
		this.businessCircle = businessCircle;
		this.address = address;
		this.introduction = introduction;
		this.service = service;
		this.score = score;
		this.commentScore = commentScore;
		this.workerName = workerName;
		this.phoneNumber = phoneNumber;
		this.minPrice = minPrice;
		this.bookedTag = bookedTag;
	}

	public HotelVO(HotelVO vo) {
		this.hotelID = vo.hotelID;
		this.hotelName = vo.hotelName;
		this.city = vo.city;
		this.businessCircle = vo.businessCircle;
		this.address = vo.address;
		this.introduction = vo.introduction;
		this.service = vo.service;
		this.score = vo.score;
		this.commentScore = vo.commentScore;
		this.workerName = vo.workerName;
		this.phoneNumber = vo.phoneNumber;
		this.minPrice = vo.minPrice;
		this.bookedTag = vo.bookedTag;
	}

}
