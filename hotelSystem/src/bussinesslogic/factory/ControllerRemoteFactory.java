package bussinesslogic.factory;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.time.LocalDate;
import java.util.List;
import businesslogic.customerbl.CustomerController;
import businesslogic.hotelbl.HotelController;
import businesslogic.orderbl.OrderController;
import businesslogic.promotionbl.PromotionController;
import businesslogic.roombl.RoomController;
import businesslogic.userbl.UserController;
import businesslogicservice.customerblservice.CustomerBLService;
import businesslogicservice.hotelblservice.HotelBLService;
import businesslogicservice.orderblservice.OrderBLService;
import businesslogicservice.promotionblservice.PromotionBLService;
import businesslogicservice.roomblservice.RoomBLService;
import businesslogicservice.userblservice.UserBLService;
import vo.AreaVO;
import vo.CalculationConditionVO;
import vo.CommentVO;
import vo.CreditVO;
import vo.CustomerVO;
import vo.HotelPromotionVO;
import vo.HotelVO;
import vo.LevelVO;
import vo.OrderVO;
import vo.RoomVO;
import vo.SearchConditionVO;
import vo.WebMarketerVO;
import vo.WebPromotionVO;

public class ControllerRemoteFactory extends UnicastRemoteObject implements CustomerBLService,HotelBLService,OrderBLService,PromotionBLService,RoomBLService,UserBLService{

	private CustomerBLService customerBLService;
	private OrderBLService orderBLService;
	private HotelBLService hotelBLService;
	private PromotionBLService promotioniBLService;
	private RoomBLService roomBLService;
	private UserBLService userBLService;
	
	protected ControllerRemoteFactory() throws RemoteException {
		customerBLService = new CustomerController();
		hotelBLService = new HotelController();
		promotioniBLService = new PromotionController();
		roomBLService = new RoomController();
		orderBLService = new OrderController();
		userBLService = new UserController();
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public List<CustomerVO> getCustomerList() throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean updateCustomer(CustomerVO customerVO) throws RemoteException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<HotelVO> getHotelList() throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean addHotel(HotelVO hotelVO) throws RemoteException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateHotelWorker(HotelVO hotelVO) throws RemoteException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<WebMarketerVO> getWebMarketerList() throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean addWebMarketer(WebMarketerVO webMarketerVO) throws RemoteException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateWebMarketer(WebMarketerVO webMarketerVO) throws RemoteException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteWebMarketer(WebMarketerVO webMarketerVO) throws RemoteException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateCreditOfCustomer(int customerID, int delta) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String login(int userID, String password) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean addRoomType(int hotelID, RoomVO roomVO) throws RemoteException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateRoomType(int hotelID, RoomVO roomVO) throws RemoteException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteRoomType(int roomID) throws RemoteException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<RoomVO> getRoomTypeList(int hotelID) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public RoomVO getRoomType(int roomID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<HotelPromotionVO> getHotelPromotionList(int hotelID) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean addHotelPromotion(HotelPromotionVO hotelPromotionVO) throws RemoteException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateHotelPromotion(HotelPromotionVO hotelPromotionVO) throws RemoteException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteHotelPromotion(HotelPromotionVO vo) throws RemoteException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<WebPromotionVO> getWebPromotionList() throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean addWebPromotion(WebPromotionVO webPromotionVO) throws RemoteException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateWebPromotion(WebPromotionVO webPromotionVO) throws RemoteException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteWebPromotion(WebPromotionVO webPromotionVO) throws RemoteException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean setLevelMethod(LevelVO levelVO) throws RemoteException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public LevelVO getLevelMethod() throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean updateLevelInfo(LevelVO levelVO) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int calculateOrder(CalculationConditionVO calculationConditionVO, CustomerVO customerVO)
			throws RemoteException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int calculateLevel(int credit) throws RemoteException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<OrderVO> getCustomerOrder(int customerID) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<OrderVO> getHotelOrder(int hotelID) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<OrderVO> getAbnormalOrdersOfToday() throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<OrderVO> filterCustomerList(int customerID, String state) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<OrderVO> filterHotelList(int hotelID, String state) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int calculateTotal(CalculationConditionVO vo) throws RemoteException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String canBeProduced(CalculationConditionVO vo) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean produceOrder(OrderVO orderVO, CalculationConditionVO calculationConditionVO) throws RemoteException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean changeOrderState(int orderID, String state) throws RemoteException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<HotelVO> getHotelVOsOfArea(AreaVO areaVO, int customerID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<HotelVO> search(AreaVO areaVO, SearchConditionVO searchCondionVO) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<HotelVO> sort(int customerID, String sortType) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<RoomVO> getRoomListOfHotel(int hotelID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<OrderVO> getOrderListOfHotel(int hotelID, int customerID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<HotelVO> getBookedHotelList(int customerID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CommentVO> getCommentList(int hotelID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean updateSimpleHotelInfo(HotelVO hotelVO) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addComment(CommentVO commentVO) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public HotelVO getHotelInfo(int hotelID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean update(HotelVO hotelVO) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(HotelVO hotelVO) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public CustomerVO getCustomerInfo(int customerID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean updateCustomerInfo(CustomerVO customerVO) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<CreditVO> getCreditList(int customerID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean registerBirthVIP(int customerID, LocalDate birthday) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean registerCompanyVIP(int customerID, String companyName) {
		// TODO Auto-generated method stub
		return false;
	}

}
