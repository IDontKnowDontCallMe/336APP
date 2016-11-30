package vo;

public class WebMarketerVO {
	
	
	public int ID;
	public String name;
	public String phoneNumber;

	public WebMarketerVO(int ID, String name, String phoneNumber) {
		this.ID = ID;
		this.name = name;
		this.phoneNumber = phoneNumber;
	}
	
	public WebMarketerVO(WebMarketerVO vo) {
		this.ID = vo.ID;
		this.name = vo.name;
		this.phoneNumber = vo.phoneNumber;
	}
}
