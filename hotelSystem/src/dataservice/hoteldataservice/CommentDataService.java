package dataservice.hoteldataservice;

import po.CommentPO;

public interface CommentDataService {
	
	public void insert(CommentPO po);
	
	public void update(CommentPO po);
	
	public CommentPO[] getCommentList(String hotel);
	
	public void init();
	
	public void finish();
	

}
