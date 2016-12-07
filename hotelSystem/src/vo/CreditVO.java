package vo;

import java.time.LocalDateTime;

public class CreditVO {

	public int customerID;
	public LocalDateTime producingDateTime;
	public int orderID;
	public String action;
	public int creditDelta;
	public int creditResult;

	public CreditVO(int customerID, LocalDateTime producingDateTime, int orderID, String action, int creditDelta,
			int creditResult) {
		this.customerID = customerID;
		this.producingDateTime = producingDateTime;
		this.orderID = orderID;
		this.action = action;
		this.creditDelta = creditDelta;
		this.creditResult = creditResult;
	}

}
