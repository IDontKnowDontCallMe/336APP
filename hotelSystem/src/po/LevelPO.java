package po;

public class LevelPO {

	private int creditDistance;
	private int maxLevel;
	private double discountDistance;
	
	public LevelPO(int creditDistance, int maxLevel, double discountDistance){
		this.creditDistance=creditDistance;
		this.maxLevel=maxLevel;
		this.discountDistance=discountDistance;
	}
	
	public LevelPO(LevelPO po){
		this.creditDistance=po.creditDistance;
		this.maxLevel=po.maxLevel;
		this.discountDistance=po.discountDistance;
	}
}
