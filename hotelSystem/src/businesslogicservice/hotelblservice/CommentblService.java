package businesslogicservice.hotelblservice;

import java.rmi.Remote;
import java.rmi.RemoteException;

import po.CommentPO;
import vo.CommentVO;

public interface CommentblService extends Remote{
	
	public CommentVO[] getCommentList(String hotelID) throws RemoteException;
	
	public void addComment(String hotelID, CommentPO po) throws RemoteException;

}
