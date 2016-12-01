package businesslogic.promotionbl;

public class LevelImpl{

	LevelMethodImpl levelMethodImpl;
	int credit;
	
	public LevelImpl(int credit){
		this.credit = credit;
	}
	
	public int getCalculateLevel(int credit){
		int level = levelMethodImpl.calculateLevel(credit);
		System.out.println("得到会员等级为"+level);
		return level;
	}

	public void setCalculateLevel(LevelMethodImpl levelMethodImpl){
		this.levelMethodImpl = levelMethodImpl;
	}
	
	public double getDiscount(int credit){
		return levelMethodImpl.getDiscount(credit);		
	}
	
	public void setDiscount(LevelMethodImpl levelMethodImpl){
		this.levelMethodImpl = levelMethodImpl;
	}
}
