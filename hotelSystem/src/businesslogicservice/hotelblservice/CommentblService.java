package businesslogicservice.hotelblservice;

import po.CommentPO;
import vo.CommentVO;

public interface CommentblService {
	
	public CommentVO[] getCommentList(String hotelID);
	
	public void addComment(String hotelID, CommentPO po);

}
