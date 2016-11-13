package data.userdata;

import java.util.List;

import po.MarketerPO;

public interface MarketerDao {

	public int addMarketer(MarketerPO po);

	public List<MarketerPO> getMarketerList() ;

	public MarketerPO getMarketer(int MarketerID) ;

	public boolean updateMarketer(MarketerPO po);
	
}
