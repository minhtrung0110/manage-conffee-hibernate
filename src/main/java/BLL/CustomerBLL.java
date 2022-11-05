/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BLL;

import DAL.CustomerDAL;
import hibernate.entities.Customer;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Trần Kim Phú
 */
public class CustomerBLL {

    private static List<Customer> listCus;
    private CustomerDAL data = new CustomerDAL();

    public CustomerBLL() {

    }

    public void loadData() {
        if (listCus == null) {
            listCus = new ArrayList<Customer>();
        }
        listCus = data.getAllCustomer("ASC");
    }

    public List<Customer> getListCustomer() {
        return listCus;
    }

    public void setListCustomer(List<Customer> listCus) {
        CustomerBLL.listCus = listCus;
    }

    public Customer getCustomerById(int id) {
        try {
            return data.getCustomerById(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public void add(Customer c) {
        try {
            data.insertCustomer(c);
            listCus.add(c);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void delete(String id) {
        int idCus = Integer.parseInt(id);
        for (int i = 0; i < listCus.size(); i++) {
            if (listCus.get(i).getId() == idCus) {
                try {
                    data.deleteCustomer(idCus);
                    listCus.remove(i);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void update(Customer c) {
        for (int i = 0; i < listCus.size(); i++) {
            if (listCus.get(i).getId() == c.getId()) {
                try {
                    data.updateCustomer(c);
                    listCus.set(i, c);

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public boolean checkIDCus(int idCus) {
        for (Customer c : listCus) {
            if (c.getId() == idCus) {
                return true;
            }
        }
        return false;
    }

    public List<Customer> searchCustomerWithFirstName(String fn) {
        List<Customer> search = null;
        for (Customer ps : listCus) {
            if (ps.getFirstName().trim().toLowerCase().contains(fn.trim().toLowerCase())) {
                search.add(ps);
            }
        }
        return search;
    }

    public List<Customer> searchCustomerWithLastName(String ln) {
        List<Customer> search = null;
        for (Customer ps : listCus) {
            if (ps.getLastName().trim().toLowerCase().contains(ln.trim().toLowerCase())) {
                search.add(ps);
            }
        }
        return search;
    }

//    public CustomerBLL(int i1) {
//        list();
//    }
//
//    public Customer getCustomerById(String MaKH) {
//        for (KhachHangDTO kh : khBUS) {
//            if (kh.getId_KH() == Integer.parseInt(MaKH)) {
//                return kh;
//            }
//        }
//        return null;
//    }
//
//    public void list() {
//        KhachHangDAO hdDAO = new KhachHangDAO();
//        khBUS = new ArrayList<>();
//        khBUS = hdDAO.findAll();
//    }
//
//    
//
//    
//
//    public void set(KhachHangDTO khachHangDTO) {
//        for (int i = 0; i < khBUS.size(); i++) {
//            if (khBUS.get(i).getId_KH() == khachHangDTO.getId_KH()) {
//                khBUS.set(i, khachHangDTO);
//                KhachHangDAO khDAO = new KhachHangDAO();
//                try {
//                    khDAO.update(khachHangDTO);
//                } catch (FileNotFoundException e) {
//                    System.out.println(e.getMessage());
//                }
//                return;
//            }
//        }
//    }
//
//    public boolean check(String makh) {
//        for (KhachHangDTO kh : khBUS) {
//            if (String.valueOf(kh.getId_KH()).equals(makh)) {
//                return true;
//            }
//        }
//        return false;
//    }
}
