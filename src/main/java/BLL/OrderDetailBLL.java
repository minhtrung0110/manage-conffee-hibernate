package BLL;

import DAL.OrderDetailDAL;
import hibernate.entities.Order;
import hibernate.entities.OrderDetail;
import hibernate.entities.Product;

import java.util.ArrayList;
import java.util.List;

public class OrderDetailBLL {
    private OrderDetailDAL orderDetailDAL = new OrderDetailDAL();
    private List<OrderDetail> orderDetailsBLL;

    public OrderDetailBLL() {
        orderDetailsBLL = null;
    }

    public OrderDetailBLL(int i1) {
        listOrderDetail(i1);
    }

    public List<OrderDetail> getCt_hdBLL() {
        return orderDetailsBLL;
    }


    public void listOrderDetail(int orderID) {
        orderDetailsBLL = new ArrayList<>();
        orderDetailsBLL = orderDetailDAL.getAllOrderDetail(orderID);
    }

    public void add(OrderDetail cthdDTO) {
        orderDetailsBLL.add(cthdDTO);
        OrderDetailDAL cthdDAO = new OrderDetailDAL();
        cthdDAO.insertOrderdetail(cthdDTO);
    }

    public void delete(String id) {
        int idHD = Integer.parseInt(id);
        listOrderDetail(idHD);
        for (OrderDetail cthdDTO : orderDetailsBLL) {
            if (cthdDTO.getOrder().getId() == idHD) {
                orderDetailsBLL.remove(cthdDTO);
                OrderDetailDAL cthdDAO = new OrderDetailDAL();
                cthdDAO.deleteOrderDetail(idHD);
                return;
            }
        }
    }

    public long getCountOrderDetail() {
        try {
            return orderDetailDAL.getCount();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

//    public void deleteMaSP(String id) {
//        int idSP = Integer.parseInt(id);
//        for (ct_HoaDonDTO cthdDTO : ct_hdBUS) {
//            if (cthdDTO.getId_SP() == idSP) {
//                ct_hdBUS.remove(cthdDTO);
//                ct_HDDAO cthdDAO = new ct_HDDAO();
//                try {
//                    cthdDAO.deleteByCodeProduct(idSP);
//                } catch (FileNotFoundException e) {
//                    System.out.println(e.getMessage());
//                }
//                return;
//            }
//        }
//    }

//    public void set(ct_HoaDonDTO cthdDTO) {
//        for (int i = 0; i < ct_hdBUS.size(); i++) {
//            if (ct_hdBUS.get(i).getId_HD() == cthdDTO.getId_HD()) {
//                ct_hdBUS.set(i, cthdDTO);
//                ct_HDDAO cthdDAO = new ct_HDDAO();
//                try {
//                    cthdDAO.update(cthdDTO);
//                } catch (FileNotFoundException e) {
//                    System.out.println(e.getMessage());
//                }
//                return;
//            }
//        }
//    }

    public static void main(String[] args) {
        OrderBLL odbll = new OrderBLL();
        Order order = odbll.getOrderById(6);

        SanPhamBLL spbll = new SanPhamBLL();
        Product product = spbll.getProductById(7);
        Product product2 = spbll.getProductById(8);

        OrderDetailBLL bll = new OrderDetailBLL(1);
        System.out.println(bll.getCountOrderDetail());

        int idKey = (int) (bll.getCountOrderDetail() +1);
        OrderDetail orderDetail = new OrderDetail(idKey, order, product, product.getName(), 2, 343400);
        idKey++;
        OrderDetail orderDetail2 = new OrderDetail(idKey, order, product2, product.getName(), 3, 76700);

        ArrayList<OrderDetail> dsct = new ArrayList<>();

        dsct.add(orderDetail);
        dsct.add(orderDetail2);
        for (OrderDetail od : dsct) {
            System.out.println(od);
            bll.add(od);
        }

    }
}
