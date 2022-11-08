package BLL;
import DAL.OrderDAL;
import hibernate.entities.Order;
import java.util.List;


public class HoaDonBLL {
    private static List<Order> listProduct;
    private OrderDAL dal = new OrderDAL();

    public HoaDonBLL() {
    }
    public List<Order> getListOrder() {
        return dal.getAllOrder("DESC");
    }

    public long getCountOrder(){
            return dal.getCount();
        }

    public long getTotalRevenue(){
            return dal.getTotalRevenue();
        }
}
