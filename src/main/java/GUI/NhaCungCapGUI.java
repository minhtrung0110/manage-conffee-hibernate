///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package GUI;
//
//import BUS.NCCBUS;
//import DTO.NhaCungCapDTO;
//import com.kingaspx.toast.util.Toast;
//import java.awt.Color;
//import java.awt.Cursor;
//import java.awt.Dimension;
//import java.awt.Font;
//import java.awt.Rectangle;
//import java.awt.event.FocusAdapter;
//import java.awt.event.FocusEvent;
//import java.awt.event.MouseAdapter;
//import java.awt.event.MouseEvent;
//import java.util.ArrayList;
//import java.util.Vector;
//import java.util.regex.Matcher;
//import java.util.regex.Pattern;
//import static javax.swing.BorderFactory.createLineBorder;
//import javax.swing.ImageIcon;
//import javax.swing.JButton;
//import javax.swing.JComboBox;
//import javax.swing.JLabel;
//import javax.swing.JOptionPane;
//import javax.swing.JPanel;
//import javax.swing.JScrollPane;
//import javax.swing.JTable;
//import javax.swing.JTextField;
//import javax.swing.RowFilter;
//import javax.swing.event.DocumentEvent;
//import javax.swing.event.DocumentListener;
//import javax.swing.table.DefaultTableModel;
//import javax.swing.table.TableModel;
//import javax.swing.table.TableRowSorter;
//
///**
// *
// * @author ACER
// */
//public class NhaCungCapGUI extends JPanel {
//
//    private NCCBUS nccBUS = new NCCBUS();
//    private JTable tbl;
//    private JLabel lbMaNCC, lbTenNCC, lbDienThoai, lbSoFax, lbDiaChi, iconSearch;
//    private JTextField txtMaNCC, txtTenNCC, txtDiaChi, txtDienThoai, txtSearch;
//    JComboBox cmbChoice;
//    private DefaultTableModel model;
//    private int DEFAULT_WIDTH;
//    private boolean EditOrAdd = true;  //gan co cho EditAdd
//    private JButton btnAdd, btnEdit, btnConfirm, btnBack, btnFile;
//
//    private boolean tableSelectionActive = true;
//
//    public NhaCungCapGUI(int width) {
//        DEFAULT_WIDTH = width;
//        init();
//    }
//
//    public void init() {
//        setLayout(null);
//        setBackground(null);
//        setBounds(new Rectangle(50, 0, DEFAULT_WIDTH - 220, 1000));
//
//        Font font0 = new Font("Segoe UI", Font.PLAIN, 13);
//        Font font1 = new Font("Segoe UI", Font.BOLD, 13);
//
//        /**
//         * **************************** PH???N HI???N TH??? TH??NG TIN
//         * *****************************************
//         */
//        JPanel itemView = new JPanel(null);
//        itemView.setBounds(new Rectangle(30, 40, DEFAULT_WIDTH - 950, 600));
//        itemView.setBackground(new Color(247, 241, 227));
//
//        /**
//         * ****** Tao Cac Label & TextField ***********************
//         */
//        lbMaNCC = new JLabel("M?? NCC");
//        lbMaNCC.setFont(font1);
//        lbMaNCC.setBounds(new Rectangle(0, 0, 200, 30));
//        txtMaNCC = new JTextField("");
//        txtMaNCC.setFont(font0);
//        txtMaNCC.setBorder(null);
//        txtMaNCC.setBounds(new Rectangle(110, 0, 220, 30));
//        txtMaNCC.setEditable(false);
//
//        lbTenNCC = new JLabel("T??n NCC");
//        lbTenNCC.setFont(font1);
//        lbTenNCC.setBounds(new Rectangle(0, 40, 200, 30));
//        txtTenNCC = new JTextField("");
//        txtTenNCC.setFont(font0);
//        txtTenNCC.setBorder(null);
//        txtTenNCC.setBounds(new Rectangle(110, 40, 220, 30));
//
//        lbDiaChi = new JLabel("?????a ch???");
//        lbDiaChi.setFont(font1);
//        lbDiaChi.setBounds(new Rectangle(0, 80, 200, 30));
//        txtDiaChi = new JTextField("");
//        txtDiaChi.setFont(font0);
//        txtDiaChi.setBorder(null);
//        txtDiaChi.setBounds(new Rectangle(110, 80, 220, 30));
//
//        lbDienThoai = new JLabel("S??? ??i???n tho???i");
//        lbDienThoai.setFont(font1);
//        lbDienThoai.setBounds(new Rectangle(0, 120, 200, 30));
//        txtDienThoai = new JTextField("");
//        txtDienThoai.setFont(font0);
//        txtDienThoai.setBorder(null);
//        txtDienThoai.setBounds(new Rectangle(110, 120, 220, 30));
//
//        //  TH??M V??O PH???N HI???N TH???
//        itemView.add(lbMaNCC);
//        itemView.add(txtMaNCC);
//        itemView.add(lbTenNCC);
//        itemView.add(txtTenNCC);
//        itemView.add(lbDiaChi);
//        itemView.add(txtDiaChi);
//        itemView.add(lbDienThoai);
//        itemView.add(txtDienThoai);
//
//        add(itemView);
//
//        /**
//         * ************** T???O C??C BTN TH??M ,X??A, S???A *******************
//         */
//        Font font2 = new Font("Tahoma", Font.PLAIN, 25);
//        //        btnEdit,btnDelete,btnConfirm,btnBack,btnFile
//        btnAdd = new JButton("TH??M");
//        btnEdit = new JButton("S???A");
//        btnConfirm = new JButton("X??C NH???N");
//        btnBack = new JButton("QUAY L???I");
//        btnFile = new JButton("CH???N ???NH");
//
//        //font ch???
//        btnAdd.setFont(font2);
//        btnAdd.setForeground(Color.WHITE);
//        btnEdit.setFont(font2);
//        btnEdit.setForeground(Color.WHITE);
//        btnConfirm.setFont(font2);
//        btnConfirm.setForeground(Color.WHITE);
//        btnBack.setFont(font2);
//        btnBack.setForeground(Color.WHITE);
//        btnFile.setFont(font2);
//        btnFile.setForeground(Color.WHITE);
//
//        //m??u n???n
//        Color color = new Color(255, 218, 121);
//        btnAdd.setBackground(color);
//        btnEdit.setBackground(color);
//        btnConfirm.setBackground(color);
//        btnBack.setBackground(color);
//        btnFile.setBackground(color);
//
//        //vi???n
//        btnAdd.setBorder(createLineBorder(new Color(134, 64, 0), 5, true));
//        btnEdit.setBorder(createLineBorder(new Color(134, 64, 0), 5, true));
//        btnConfirm.setBorder(createLineBorder(new Color(134, 64, 0), 5, true));
//        btnBack.setBorder(createLineBorder(new Color(134, 64, 0), 5, true));
//        btnFile.setBorder(createLineBorder(new Color(134, 64, 0), 5, true));
//
//        //icon
//        JLabel lbAdd = new JLabel(new ImageIcon("./src/image/add-icon.png"));
//        lbAdd.setBounds(new Rectangle(0, 0, 50, 50));
//        btnAdd.add(lbAdd);
//
//        JLabel lbEdit = new JLabel(new ImageIcon("./src/image/icons8-gear-32.png"));
//        lbEdit.setBounds(new Rectangle(0, 0, 50, 50));
//        btnEdit.add(lbEdit);
//
//        JLabel lbDelete = new JLabel(new ImageIcon("./src/image/icons8-delete-32.png"));
//        lbDelete.setBounds(new Rectangle(0, 0, 50, 50));
//
//        //v??? tr??
//        btnAdd.setBounds(new Rectangle(110, 250, 200, 50));
//        btnAdd.setCursor(new Cursor(Cursor.HAND_CURSOR));
//
//        btnEdit.setBounds(new Rectangle(110, 320, 200, 50));
//        btnEdit.setCursor(new Cursor(Cursor.HAND_CURSOR));
//
//        btnConfirm.setVisible(false);
//        btnConfirm.setBounds(new Rectangle(110, 250, 200, 50));
//        btnConfirm.setCursor(new Cursor(Cursor.HAND_CURSOR));
//
//        btnBack.setVisible(false);
//        btnBack.setBounds(new Rectangle(110, 320, 200, 50));
//        btnBack.setCursor(new Cursor(Cursor.HAND_CURSOR));
//
//        //TH??M V??O PH???N HI???N TH???
//        itemView.add(btnAdd);
//        itemView.add(btnEdit);
//        itemView.add(btnConfirm);
//        itemView.add(btnBack);
//
//        // MouseClick btnADD
//        btnAdd.addMouseListener(new MouseAdapter() {
//            @Override
//            public void mouseClicked(MouseEvent e) {
//                EditOrAdd = true;
//
//                cleanView();
//                setEdit(true);
//                btnAdd.setVisible(!EditOrAdd);
//                btnEdit.setVisible(!EditOrAdd);
//
//                btnConfirm.setVisible(EditOrAdd);
//                btnBack.setVisible(EditOrAdd);
//                tbl.setEnabled(!EditOrAdd);
//                tableSelectionActive = false;
//            }
//        });
//
//        // MouseClick btnEdit
//        btnEdit.addMouseListener(new MouseAdapter() {
//            @Override
//            public void mouseClicked(MouseEvent e) {
//                if (txtMaNCC.getText().equals("")) {
//                    new Toast.ToastWarning("Vui l??ng ch???n nh?? cung c???p c???n s???a !!!", Toast.SHORT_DELAY);
//                    return;
//                }
//                tableSelectionActive = false;
//                setEdit(true);
//                txtMaNCC.setEditable(false);
//                btnAdd.setVisible(!EditOrAdd);
//                btnEdit.setVisible(!EditOrAdd);
//
//                btnConfirm.setVisible(EditOrAdd);
//                btnBack.setVisible(EditOrAdd);
//
//                tbl.setEnabled(!EditOrAdd);
//                EditOrAdd = false;
//            }
//        });
//
//        //MouseClick btnBack
//        btnBack.addMouseListener(new MouseAdapter() {
//            @Override
//            public void mouseClicked(MouseEvent e) {
//                cleanView();
//                EditOrAdd = true;
//                btnAdd.setVisible(EditOrAdd);
//                btnEdit.setVisible(EditOrAdd);
//                setEdit(false);
//                btnConfirm.setVisible(!EditOrAdd);
//                btnBack.setVisible(!EditOrAdd);
//
//                tbl.setEnabled(EditOrAdd);
//                tableSelectionActive = true;
//            }
//        });
//
//        //MouseClick btnConfirm
//        btnConfirm.addMouseListener(new MouseAdapter() {
//            @Override
//            public void mouseClicked(MouseEvent e) {
//                int mess;
//                if (EditOrAdd) {  //th??m NCC
//
//                    String sDT = txtDienThoai.getText();
//                    //validate SDT
//                    Pattern pattern = Pattern.compile("^\\d{10,11}$");
//                    Matcher m = pattern.matcher(sDT);   //so s??nh
//                    if (!m.matches()) {
//                        new Toast.ToastError("S??? ??i???n tho???i kh??ng h???p l???!! Vui l??ng nh???p 10 ho???c 11 s??? !!!", Toast.SHORT_DELAY);
//                        return;
//                    }
//                    //kiem tra ton tai
//                    for (int j = 0; j < nccBUS.getNccBUS().size(); j++) {
//                        if (nccBUS.getNccBUS().get(j).getPhone().equals(sDT)) {
//                            new Toast.ToastError("S??? ??i???n tho???i ???? t???n t???i, vui l??ng nh???p s??? kh??c !!!", Toast.SHORT_DELAY);
//                            return;
//                        }
//                    }
//
//                    mess = JOptionPane.showConfirmDialog(null, "X??c nh???n th??m nh?? cung c???p", "Th??ng b??o x??c nh???n", JOptionPane.YES_NO_OPTION);
//                    if (mess == 0) {     //YES
//                        String tenNCC = txtTenNCC.getText();
//                        String diaChi = txtDiaChi.getText();
//                        String sdt = txtDienThoai.getText();
//                        
//                        if(!tenNCC.equals("") && !diaChi.equals("") && !sdt.equals("")){
//                            //Upload nh?? cung c???p l??n DAO v?? BUS
//                            NhaCungCapDTO ncc = new NhaCungCapDTO(tenNCC, diaChi, sdt);
//                            nccBUS.add(ncc);
//                            new Toast.ToastSuccessful("Th??nh c??ng", "Th??m nh?? cung c???p th??nh c??ng !!!", Toast.SHORT_DELAY);
//                            outModel(model, (ArrayList<NhaCungCapDTO>) nccBUS.getNccBUS());
//                            cleanView();
//                        }
//                        else{
//                            new Toast.ToastError("Vui l??ng nh???p ?????y ????? th??ng tin !!!", Toast.SHORT_DELAY);
//                        }
//                    }
//                } else {   //s???a NCC
//                    mess = JOptionPane.showConfirmDialog(null, "X??c nh???n s???a nh?? cung c???p", "Th??ng b??o s???a", JOptionPane.YES_NO_OPTION);
//                    if (mess == 0) {  //YES
//
//                        String sDT = txtDienThoai.getText();
//                        for (int j = 0; j < nccBUS.getNccBUS().size(); j++) {
//                            if (nccBUS.getNccBUS().get(j).getPhone().equals(sDT) && nccBUS.getNccBUS().get(j).getId_NCC() != Integer.parseInt(txtMaNCC.getText())) {
//                                new Toast.ToastError("S??? ??i???n tho???i ???? t???n t???i, vui l??ng nh???p s??? kh??c !!!", Toast.SHORT_DELAY);
//                                return;
//                            }
//                        }
//                        //validate SDT
//                        Pattern pattern = Pattern.compile("^\\d{10,11}$");
//                        Matcher m = pattern.matcher(sDT);   //so s??nh
//                        if (!m.matches()) {
//                            new Toast.ToastError("S??? ??i???n tho???i kh??ng h???p l???!! Vui l??ng nh???p 10 ho???c 11 s??? !!!", Toast.SHORT_DELAY);
//                            return;
//                        }
//
//                        //L???y data t??? textField l??n
//                        int maNCC = Integer.parseInt(txtMaNCC.getText());
//                        String tenNCC = txtTenNCC.getText();
//                        String diaChi = txtDiaChi.getText();
//                        String sdt = txtDienThoai.getText();
//                        
//                        if(!tenNCC.equals("") && !diaChi.equals("") && !sdt.equals("")){
//                        //Upload nh?? cung c???p l??n DAO v?? BUS
//                        NhaCungCapDTO ncc = new NhaCungCapDTO(tenNCC, diaChi, sdt);
//                        ncc.setId_NCC(maNCC);
//                        nccBUS.set(ncc);
//                        new Toast.ToastSuccessful("Th??nh c??ng", "S???a th??ng tin nh?? cung c???pth??nh c??ng !!!", Toast.SHORT_DELAY);
//                        outModel(model, (ArrayList<NhaCungCapDTO>) nccBUS.getNccBUS());
//                        }
//                        else{
//                            new Toast.ToastError("Vui l??ng nh???p ?????y ????? th??ng tin !!!", Toast.SHORT_DELAY);
//                        }
//                    }
//                }
//            }
//        }
//        );
//
//        /**
//         * ******************TABLE***************************************************************************
//         */
//        /**
//         * ************ T???O MODEL V?? HEADER ********************
//         */
//        Vector header = new Vector();
//
//        header.add("M?? NCC");
//        header.add("T??n NCC");
//        header.add("?????a ch???");
//        header.add("SDT");
//        model = new MyTable(header, 4);
//        tbl = new JTable(model);
//        //sap xep
//        TableRowSorter<TableModel> rowSorter = new TableRowSorter<TableModel>(model);
//        tbl.setRowSorter(rowSorter);
//        listNCC();
//
//        /**
//         * ************ T???O TABLE ********************
//         */
//        //Ch???nh ????? r???ng c???t
//        tbl.getColumnModel().getColumn(0).setPreferredWidth(30);
//        tbl.getColumnModel().getColumn(1).setPreferredWidth(50);
//        tbl.getColumnModel().getColumn(2).setPreferredWidth(70);
//        tbl.getColumnModel().getColumn(3).setPreferredWidth(30);
//
//        //Ch???nh table
//        tbl.setFocusable(false);
//        tbl.getTableHeader().setFont(font1);
//        tbl.setRowHeight(30);
//        tbl.setShowVerticalLines(false);
//        tbl.getTableHeader().setBackground(new Color(134, 64, 0));
//        tbl.getTableHeader().setForeground(Color.WHITE);
//        tbl.setSelectionBackground(new Color(52, 152, 219));
//        tbl.setFillsViewportHeight(true);
//        tbl.getTableHeader().setOpaque(false);
//        tbl.setIntercellSpacing(new Dimension(0, 0));
//
//        //Add table v??o scrollPane
//        JScrollPane scroll = new JScrollPane(tbl);
//
//        scroll.setBounds(new Rectangle(400, 40, DEFAULT_WIDTH - 700, 500));
//        scroll.setBackground(null);
//        add(scroll);
//
//        //event click v??o Table
//        tbl.addMouseListener(
//                new MouseAdapter() {
//            @Override
//            public void mouseClicked(MouseEvent e) {
//                if (tableSelectionActive) {
//                    int click = tbl.getSelectedRow(); //Chon vao dong trong bang hi???n th??? l??n txt
//                    if (click == -1) {
//                        return;
//                    }
//                    txtMaNCC.setText(tbl.getModel().getValueAt(click, 0).toString());
//                    txtTenNCC.setText(tbl.getModel().getValueAt(click, 1).toString());
//                    txtDiaChi.setText(tbl.getModel().getValueAt(click, 2).toString());
//                    txtDienThoai.setText(tbl.getModel().getValueAt(click, 3).toString());
//                }
//            }
//        }
//        );
//
//        /**
//         * ********************* SORT TABLE ****************************
//         */
//        //PH???N CH???N SEARCH
//        cmbChoice = new JComboBox();
//
//        cmbChoice.setFont(font0);
//
//        cmbChoice.addItem("M?? NCC");
//        cmbChoice.addItem("T??n NCC");
//        cmbChoice.addItem("?????a ch???");
//        cmbChoice.addItem("SDT");
//        cmbChoice.setBounds(new Rectangle(0, 180, 100, 30));
//        cmbChoice.setEditable(false);
//
//        // Custem Icon search
//        iconSearch = new JLabel(new ImageIcon("./src/image/search_25px.png"));
//
//        iconSearch.setCursor(new Cursor(Cursor.HAND_CURSOR));
//        iconSearch.setBounds(290, 170, 50, 50);
//
//        //Ph???n TextField
//        txtSearch = new JTextField();
//
//        txtSearch.setFont(font0);
////        txtSearch.setBorder(null);
//
//        txtSearch.setBackground(Color.WHITE);
//
//        txtSearch.setOpaque(false);
//        txtSearch.setBounds(new Rectangle(110, 180, 220, 30));
//
//        //Add t???t c??? v??o ItemView
//        itemView.add(cmbChoice);
//
//        itemView.add(iconSearch);
//
//        itemView.add(txtSearch);
//
//        //b???t s??? ki???n FOCUS search box
//        txtSearch.addFocusListener(new FocusAdapter() {
//            @Override
//            public void focusGained(FocusEvent e) {
//                iconSearch.setIcon(new ImageIcon("./src/image/search_25px_focus.png"));
//            }
//
//            public void focusLost(FocusEvent e) {
//                iconSearch.setIcon(new ImageIcon("./src/image/search_25px.png"));
//                iconSearch.setBorder(createLineBorder(Color.BLACK));
//            }
//        });
//
//        txtSearch.getDocument().addDocumentListener(new DocumentListener() {
//            @Override
//            public void insertUpdate(DocumentEvent e) {
//                String text = txtSearch.getText();
//                int choice = cmbChoice.getSelectedIndex();
//
//                if (text.trim().length() == 0) {
//                    rowSorter.setRowFilter(null);
//                } else {
//                    rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + text + "", choice));
//                }
//            }
//
//            @Override
//            public void removeUpdate(DocumentEvent e) {
//                String text = txtSearch.getText();
//                int choice = cmbChoice.getSelectedIndex();
//
//                if (text.trim().length() == 0) {
//                    rowSorter.setRowFilter(null);
//                } else {
//                    rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + text + "", choice));
//                }
//            }
//
//            @Override
//            public void changedUpdate(DocumentEvent e) {
//                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//            }
//        });
//        setEdit(false);
//    }
//
////FUNCTION
//    public void cleanView() {
//        txtMaNCC.setEditable(false);
//        txtMaNCC.setText("");
//        txtTenNCC.setText("");
//        txtDiaChi.setText("");
//        txtDienThoai.setText("");
//    }
//
//    public void outModel(DefaultTableModel model, ArrayList<NhaCungCapDTO> ncc) // Xu???t ra Table t??? ArrayList
//    {
//        Vector data;
//        model.setRowCount(0);
//        for (NhaCungCapDTO n : ncc) {
//            data = new Vector();
//            data.add(n.getId_NCC());
//            data.add(n.getName_NCC());
//            data.add(n.getAddress());
//            data.add(n.getPhone());
//            model.addRow(data);
//        }
//        tbl.setModel(model);
//    }
//
//    //l???y data t??? BUS l??n Table
//    public void listNCC() {
//        if (nccBUS.getNccBUS() == null) {
//            nccBUS.list();
//        }
//
//        outModel(model, (ArrayList<NhaCungCapDTO>) nccBUS.getNccBUS());
//    }
//
//    private void setEdit(boolean flag) {
//        txtTenNCC.setEditable(flag);
//        txtDiaChi.setEditable(flag);
//        txtDienThoai.setEditable(flag);
//    }
//}
