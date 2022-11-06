package BLL;

import DAL.OrderDetailDAL;
import hibernate.entities.OrderDetail;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class OrderDetailBLL {
    private List<OrderDetail> orderDetailsBLL;

    public OrderDetailBLL() {
        orderDetailsBLL = null;
    }

    public OrderDetailBLL(int i1)
    {
        listOrderDetail(i1);
    }

    public List<OrderDetail> getCt_hdBLL() {
        return orderDetailsBLL;
    }


    public void listOrderDetail(int orderID) {

        OrderDetailDAL orderDetailDAL = new OrderDetailDAL();
        orderDetailsBLL = new ArrayList<>();
        orderDetailsBLL = orderDetailDAL.getAllOrderDetail(orderID);
    }

//    public void add(ct_HoaDonDTO cthdDTO) {
//        ct_hdBUS.add(cthdDTO);
//        ct_HDDAO cthdDAO = new ct_HDDAO();
//        try {
//            cthdDAO.save(cthdDTO);
//        } catch (FileNotFoundException e) {
//            System.out.println(e.getMessage());
//        }
//    }

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
}
