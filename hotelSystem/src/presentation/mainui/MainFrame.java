package presentation.mainui;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import bussinesslogic.factory.BLFactory;
import data.factory.DataFactory;
import po.OrderPO;

public class MainFrame {
	
	private BLFactory blFactory;
	
	public static void main(String[] args){
		//开启主面板并连接服务器
		MainFrame mainFrame = new MainFrame();
		mainFrame.linkToServer();
		
		OrderPO po = DataFactory.getOrderDataService().getOrderInfo(4);
		
		System.out.println(po.getCustomerName() + po.getHotelName());
	}
	
	private void linkToServer() {
		try {
			blFactory = BLFactory.getInstance();
			//括号中rmi后的地址是本机地址，还需要更改；  ***为服务器的远程对象名字
			blFactory.setRemote(Naming.lookup("rmi://localhost:8888/****"));
			System.out.println("linked");
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (NotBoundException e) {
			e.printStackTrace();
		}
	}

}
