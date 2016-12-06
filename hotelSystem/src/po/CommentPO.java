package po;

public class CommentPO {
	
	private String nameOfHotel;
	private String nameOfRoom;
	private String comment;
	private int score;
	private String writer;
	private String time;
	
	
	public CommentPO(String nameOfHotel, String nameOfRoom, String comment, int score, String writer, String time){
		this.nameOfHotel = nameOfHotel;
		this.nameOfRoom = nameOfRoom;
		this.comment = comment;
		this.score = score;
		this.writer = writer;
		this.time = time;
	}
	
	public void setNameOfHotel(String nameOfHotel){
		this.nameOfHotel = nameOfHotel;
	}
	
	public String getNameOfHotel(){
		return this.nameOfHotel;
	}
	
	public void setNameOfRoom(String nameOfRoom){
		this.nameOfRoom = nameOfRoom;
	}
	
	public String getNameOfRoom(){
		return this.nameOfRoom;
	}
	
	public void setComment(String comment){
		this.comment = comment;
	}
	
	public String getComment(){
		return this.comment;
	}
	
	public void setScore(int score){
		this.score = score;
	}
	
	public int getScore(){
		return this.score;
	}
	
	public void setWriter(String writer){
		this.writer = writer;
	}
	
	public String getWriter(){
		return this.writer;
	}
	
	public void setTime(String time){
		this.time = time;
	}
	
	public String getTime(){
		return this.time;
	}

}
