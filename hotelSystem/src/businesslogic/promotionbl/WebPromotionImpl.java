package businesslogic.promotionbl;

import java.util.List;

import data.factory.DataFactory;
import po.WebPromotionPO;
import vo.CalculationConditionVO;
import vo.CustomerVO;
import vo.WebPromotionVO;

public class WebPromotionImpl {

	public List<WebPromotionVO> getWebPromotionList() {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean addWebPromotion(WebPromotionVO vo) {
		WebPromotionPO po = new WebPromotionPO(vo.promotionType, vo.startTime, vo.endTime, vo.businessCircleName,
				vo.discount);
		DataFactory.getPromotionDataService().writeWebPromotionObject(po);
		return true;
	}

	public boolean updateWebPromotion(WebPromotionVO vo) {
		DataFactory.getPromotionDataService().deleteWebPromotionObject(vo.promotionType);
		WebPromotionPO po = new WebPromotionPO(vo.promotionType, vo.startTime, vo.endTime, vo.businessCircleName,
				vo.discount);
		DataFactory.getPromotionDataService().writeWebPromotionObject(po);
		return true;
	}

	public boolean deleteWebPromotion(WebPromotionVO vo) {
		DataFactory.getPromotionDataService().deleteWebPromotionObject(vo.promotionType);
		return true;
	}

	public int calculateOrder(CalculationConditionVO calculationVO, CustomerVO customerVO) {
		WebTimePromotion webTimePromotion = new WebTimePromotion();
		int webTimePrice = webTimePromotion.calculateOrder(calculationVO, customerVO);
		AreaPromotion areaPromotion = new AreaPromotion();
		int areaPrice = areaPromotion.calculateOrder(calculationVO, customerVO);
		LevelPromotion levelPromotion = new LevelPromotion();
		int levelPrice = levelPromotion.calculateOrder(calculationVO, customerVO);

		int resultPrice = (webTimePrice < areaPrice) ? webTimePrice : areaPrice;
		resultPrice = (resultPrice < levelPrice) ? resultPrice : levelPrice;
		return resultPrice;
	}
}
