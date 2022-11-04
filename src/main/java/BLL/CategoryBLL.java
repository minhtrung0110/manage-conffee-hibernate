/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BLL;

import DAL.CategoryDAL;
import DAL.ProductDAL;
import hibernate.entities.Category;
import hibernate.entities.Category;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;


public class CategoryBLL {

    private static List<Category> listCategory;
    private CategoryDAL dal = new CategoryDAL();

    public CategoryBLL() {
    }

    public static List<Category> getListCategory() {
        return listCategory;
    }

    public static void setListCategory(List<Category> listCategory) {
        CategoryBLL.listCategory = listCategory;
    }
    //    public Category getByIdDuty(int id_duty) {
//        CategoryDAO category = new CategoryDAO();
//        return category.getByIdDuty(id_duty);
//    }

    public void loadListCategory() {
        if (listCategory== null) {
            listCategory = new ArrayList<Category>();
        }
        listCategory=dal.findAll();
    }
    public Category searchCourseWithID(int id) {
        List<Category> search = null;
        for (Category cs : listCategory) {
            if (cs.getId()==id) {
              return cs;
            }
        }
        return null;
    }
//
//    public void show() {
//        for (Category category : CategoryList) {
//            System.out.println(category.getName());
//        }
//    }
//
//    public void add(Category category) {
//        CategoryList.add(category);
//        CategoryDAO categoryDAO = new CategoryDAO();
//        try {
//            categoryDAO.save(category);
//        } catch (FileNotFoundException e) {
//            System.out.println(e.getMessage());
//        }
//    }
//
//    public void delete(int id_duty) {
//        for (Category categoryDTO : CategoryList) {
//            if (categoryDTO.getId_duty() == id_duty) {
//                CategoryList.remove(categoryDTO);
//                CategoryDAO categoryDAO = new CategoryDAO();
//                try {
//                    categoryDAO.delete(id_duty);
//                } catch (FileNotFoundException e) {
//                    System.out.println(e.getMessage());
//                }
//                return;
//            }
//        }
//    }
//
//    public void set(Category categoryDTO) {
//        for (int i = 0; i < CategoryList.size(); i++) {
//            if (CategoryList.get(i).getId_duty() == categoryDTO.getId_duty()) {
//                CategoryList.set(i, categoryDTO);
//                CategoryDAO categoryDAO = new CategoryDAO();
//                try {
//                    categoryDAO.update(categoryDTO);
//                } catch (FileNotFoundException e) {
//                    System.out.println(e.getMessage());
//                }
//                return;
//            }
//        }
//    }
}
