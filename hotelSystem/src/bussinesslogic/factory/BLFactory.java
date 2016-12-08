package bussinesslogic.factory;

import java.rmi.Remote;
import rmi.RemoteCustomerService;
import rmi.RemoteHotelBLService;
import rmi.RemoteOrderBLService;
import rmi.RemotePromotionBLService;
import rmi.RemoteRoomBLService;
import rmi.RemoteUserBLService;

public class BLFactory {
	private Remote remote;
	private static BLFactory blFactory = new BLFactory();
	public static BLFactory getInstance(){
		return blFactory;
	}
	
	private BLFactory() {
		
	}
	
	public void setRemote(Remote remote){
		this.remote = remote;
	}
	
	public RemoteCustomerService getCustomerBLService() {
		return (RemoteCustomerService)remote;
	}
	
	public RemoteHotelBLService getHotelBLService() {
		return (RemoteHotelBLService)remote;
	}
	
	public RemoteOrderBLService getOrderBLService() {
		return (RemoteOrderBLService)remote;
	}
	
	public RemotePromotionBLService getPromotionBLService() {
		return (RemotePromotionBLService)remote;
	}
	
	public RemoteRoomBLService getRoomBLService() {
		return (RemoteRoomBLService)remote;
	}
	
	
	public RemoteUserBLService getUserBLService() {
		return (RemoteUserBLService)remote;
	}
	
	
}
