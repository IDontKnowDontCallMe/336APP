package businesslogic.promotionbl;

import vo.LevelVO;

public class LevelMethodImpl implements LevelMethod {

	int credit;
	LevelVO vo;

	public LevelMethodImpl(int credit) {
		this.credit = credit;
		vo = new LevelVO(10000, 10, 0.05);
		
	}

	@Override
	public int calculateLevel(int credit) {
		int level = credit / vo.creditDistance;
		System.out.println("用了策略模式中的一个策略");
		return (level <= vo.maxLevel) ? level : vo.maxLevel;
	}

	@Override
	public double getDiscount(int credit) {
		return 1-vo.discountDistance;
	}
	
	

}
