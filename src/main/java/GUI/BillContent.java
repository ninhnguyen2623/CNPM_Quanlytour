package GUI;

import BUS.*;
import DTO.*;
import org.apache.commons.math3.analysis.solvers.NewtonRaphsonSolver;

import javax.swing.*;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.text.Normalizer;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.regex.Pattern;

public class BillContent extends JPanel {

    private JPanel pnlBillContentTitle;
    private JLabel lblBillContentTitle;
    private JPanel pnlSearchBill;
    private JLabel lblSearchBill;
    private JPanel pnlContentBillDetail;
    private JPanel pnlEdit_ListBill;
    private JPanel pnlbtnEdit_ListBill;
    private JPanel pnlEditBill;
    private JScrollPane scrollFillInforBill;
    private JPanel pnlFillBill;
    private JPanel pnlIdBill;
    private JLabel lblIdBill;
    private JTextField txtIdBill;
    private JPanel pnlNumOfCus;
    private JLabel lblNumOfCus;
    private JTextField txtNumOfCus;
    private JPanel pnlListBill_Ser;
    private JPanel pnlButtonBill;
    private JButton btnAddBill;
    private JButton btnDeleteBill;

    private JButton btnRefreshBill;

    private JPanel pnlIdTourOfBill;
    private JLabel lblTourNameOfBill;
    private JPanel pnlTotalPrice;
    private JLabel lblTotalPrice;
    private JTextField txtTotalPrice;
    private JPanel pnlIdSerOfBill;
    private JLabel lblSerNameOfBill;
    private JComboBox cbxTourNameOfBill;
    private JComboBox cbxCusNameOfBill;
    private JPanel pnlSclSerNameOfBill;
    private JScrollPane scrollSerName;
    private JPanel pnlSerDetail = new JPanel();
    private JCheckBox chckbxNewCheckBox;
    private JCheckBox chckbxNewCheckBox_1;
    private JCheckBox chckbxNewCheckBox_2;
    private JCheckBox chckbxNewCheckBox_3;

    private JPanel pnlIconSrc_Txt;
    private JTextField txtSearchBill;
    private JPanel panel;
    private JPanel panel_1;
    private JPanel panel_2;
    private JPanel panel_6;
    private JPanel panel_3;
    private JPanel panel_4;
    private JPanel panel_5;
    private JButton btnEditBill;
    private JButton btnListBill;
    private JPanel pnlEdit_ListBillDetail;
    private JPanel pnlCusName;

    private JLabel lblCusName;

    private JPanel pnlBillContent;
    private JScrollPane sclListSer1;
    private JPanel pnlListBill;
    private JPanel pnlListSer1;
    private JTable ser1ListTable;
    private JScrollPane sclListBill;
    private JTable billListTable;
    private CardLayout cardLayoutEdit_ListBillDetail;
    private JButton btnUpdateBill;
    private JTextField txtSerBill;
    private JButton btnSerBill;

    DefaultTableModel model_bill;
    DefaultTableModel model_ser;
    private ArrayList<JCheckBox> arrCheckBox = new ArrayList<>();
    private ArrayList<String> arrServices = new ArrayList<>();
    private JButton btnTotalPrice;
    
    private double sumsertour = 0;
    public BillContent() {
        setUpTable();
        init();
        loadBillData();
        btnInteract();
    }

    private void setUpTable() {
        


        model_ser = new DefaultTableModel();
        model_ser.addColumn("id");
        model_ser.addColumn("Name");
        model_ser.addColumn("Price");

    }

    private void init() {

        setLayout(new BorderLayout(0, 0));

        pnlBillContentTitle = new JPanel();
        pnlBillContentTitle.setPreferredSize(new Dimension(10, 125));
        add(pnlBillContentTitle, BorderLayout.NORTH);
        pnlBillContentTitle.setLayout(new BorderLayout(0, 0));

        lblBillContentTitle = new JLabel("Bill Manager");
        lblBillContentTitle.setPreferredSize(new Dimension(200, 50));
        lblBillContentTitle.setHorizontalAlignment(SwingConstants.CENTER);
        lblBillContentTitle.setFont(new Font("Times New Roman", Font.PLAIN, 24));
        pnlBillContentTitle.add(lblBillContentTitle, BorderLayout.NORTH);

        pnlSearchBill = new JPanel();
        pnlSearchBill.setPreferredSize(new Dimension(10, 60));
        pnlBillContentTitle.add(pnlSearchBill, BorderLayout.CENTER);
        pnlSearchBill.setLayout(new BorderLayout(0, 0));

        pnlIconSrc_Txt = new JPanel();
        pnlSearchBill.add(pnlIconSrc_Txt, BorderLayout.CENTER);
        pnlIconSrc_Txt.setLayout(new BorderLayout(0, 0));

        txtSearchBill = new JTextField();
        txtSearchBill.setText("Search Bill");
        pnlIconSrc_Txt.add(txtSearchBill, BorderLayout.CENTER);
        txtSearchBill.setMargin(new Insets(2, 10, 2, 10));
        txtSearchBill.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                txtSearchBill.setText(null);
                txtSearchBill.requestFocus();;
                Font font = txtSearchBill.getFont();
                font = font.deriveFont(Font.PLAIN|Font.BOLD);
                txtSearchBill.setFont(font);
                txtSearchBill.setForeground(Color.black);
            }

            @Override
            public void focusLost(FocusEvent e) {
                Font font = txtSearchBill.getFont();
                font = font.deriveFont(Font.ITALIC);
                txtSearchBill.setFont(font);
                txtSearchBill.setForeground(Color.gray);
                txtSearchBill.setText("Search Bill");
            }
        });

        lblSearchBill = new JLabel();
        lblSearchBill.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
        pnlIconSrc_Txt.add(lblSearchBill, BorderLayout.EAST);
		lblSearchBill.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(Manager.class.getResource("../images/search.png"))));
        lblSearchBill.setCursor(new Cursor(Cursor.HAND_CURSOR));

        panel = new JPanel();
        panel.setPreferredSize(new Dimension(10, 20));
        pnlSearchBill.add(panel, BorderLayout.NORTH);

        panel_1 = new JPanel();
        panel_1.setPreferredSize(new Dimension(10, 20));
        pnlSearchBill.add(panel_1, BorderLayout.SOUTH);

        panel_2 = new JPanel();
        panel_2.setPreferredSize(new Dimension(250, 10));
        pnlSearchBill.add(panel_2, BorderLayout.EAST);

        panel_6 = new JPanel();
        panel_6.setPreferredSize(new Dimension(250, 10));
        pnlSearchBill.add(panel_6, BorderLayout.WEST);

        pnlContentBillDetail = new JPanel();
        add(pnlContentBillDetail, BorderLayout.CENTER);
        pnlContentBillDetail.setLayout(new BorderLayout(0, 0));

        pnlEdit_ListBill = new JPanel();
        pnlContentBillDetail.add(pnlEdit_ListBill, BorderLayout.CENTER);
        pnlEdit_ListBill.setLayout(new BorderLayout(0, 0));

        pnlbtnEdit_ListBill = new JPanel();
        pnlbtnEdit_ListBill.setPreferredSize(new Dimension(10, 50));
        pnlEdit_ListBill.add(pnlbtnEdit_ListBill, BorderLayout.NORTH);
        pnlbtnEdit_ListBill.setLayout(new BoxLayout(pnlbtnEdit_ListBill, BoxLayout.X_AXIS));

        btnEditBill = new JButton("Edit Bill");
        btnEditBill.setContentAreaFilled(false);
        btnEditBill.setFocusPainted(false);
        btnEditBill.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        pnlbtnEdit_ListBill.add(btnEditBill);
        btnEditBill.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayoutEdit_ListBillDetail.show(pnlEdit_ListBillDetail,"pnlEditBill");
            }
        });

        btnListBill = new JButton("List Bill");
        btnListBill.setContentAreaFilled(false);
        btnListBill.setFocusPainted(false);
        btnListBill.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        pnlbtnEdit_ListBill.add(btnListBill);
        btnListBill.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayoutEdit_ListBillDetail.show(pnlEdit_ListBillDetail,"pnlListBill");
            }
        });

        pnlEdit_ListBillDetail = new JPanel();
        pnlEdit_ListBill.add(pnlEdit_ListBillDetail, BorderLayout.CENTER);
        pnlEdit_ListBillDetail.setLayout(new CardLayout(0, 0));

        pnlEditBill = new JPanel();
        pnlEdit_ListBillDetail.add(pnlEditBill, "pnlEditBill");
        pnlEditBill.setLayout(new BorderLayout(0, 0));

        scrollFillInforBill = new JScrollPane();
        scrollFillInforBill.setBorder(new TitledBorder(null, "Edit Bill", TitledBorder.LEADING, TitledBorder.TOP, null, null));
        pnlEditBill.add(scrollFillInforBill, BorderLayout.CENTER);

        pnlFillBill = new JPanel();
        pnlFillBill.setBorder(null);
        scrollFillInforBill.setViewportView(pnlFillBill);
        pnlFillBill.setLayout(new GridLayout(0,1,0,0));

        pnlIdBill = new JPanel();
        pnlIdBill.setPreferredSize(new Dimension(320, 35));
        pnlFillBill.add(pnlIdBill);

        lblIdBill = new JLabel("ID Bill");
        lblIdBill.setPreferredSize(new Dimension(125, 25));
        pnlIdBill.add(lblIdBill);

        txtIdBill = new JTextField();
        txtIdBill.setPreferredSize(new Dimension(100, 25));
        pnlIdBill.add(txtIdBill);
        txtIdBill.setColumns(20);

        pnlIdTourOfBill = new JPanel();
        pnlFillBill.add(pnlIdTourOfBill);
        lblTourNameOfBill = new JLabel("Tour name");
        lblTourNameOfBill.setPreferredSize(new Dimension(126, 25));
        pnlIdTourOfBill.add(lblTourNameOfBill);

        cbxTourNameOfBill = new JComboBox();
        cbxTourNameOfBill.setPreferredSize(new Dimension(225, 25));
        pnlIdTourOfBill.add(cbxTourNameOfBill);

        pnlIdSerOfBill = new JPanel();
        pnlFillBill.add(pnlIdSerOfBill);
        lblSerNameOfBill = new JLabel("Services");
        lblSerNameOfBill.setPreferredSize(new Dimension(125, 25));
        pnlIdSerOfBill.add(lblSerNameOfBill);

        txtSerBill = new JTextField();
        txtSerBill.setPreferredSize(new Dimension(130, 25));
        txtSerBill.setEditable(false);
        pnlIdSerOfBill.add(txtSerBill);

        btnSerBill = new JButton("Services");
        btnSerBill.setPreferredSize(new Dimension(90, 25));
        pnlIdSerOfBill.add(btnSerBill);

        pnlCusName = new JPanel();
        pnlFillBill.add(pnlCusName);
        lblCusName = new JLabel("Customer name");
        lblCusName.setPreferredSize(new Dimension(125, 25));
        pnlCusName.add(lblCusName);

        cbxCusNameOfBill = new JComboBox();
        cbxCusNameOfBill.setPreferredSize(new Dimension(225, 25));
        pnlCusName.add(cbxCusNameOfBill);

        pnlNumOfCus = new JPanel();
        pnlNumOfCus.setPreferredSize(new Dimension(320, 35));
        pnlFillBill.add(pnlNumOfCus);


        lblNumOfCus = new JLabel("Number of customers");
        lblNumOfCus.setPreferredSize(new Dimension(125, 25));
        pnlNumOfCus.add(lblNumOfCus);

        txtNumOfCus = new JTextField("1");
        txtNumOfCus.setPreferredSize(new Dimension(100, 25));
        txtNumOfCus.setColumns(20);
        pnlNumOfCus.add(txtNumOfCus);

        pnlTotalPrice = new JPanel();
        pnlFillBill.add(pnlTotalPrice);

        lblTotalPrice = new JLabel("Total price");
        lblTotalPrice.setPreferredSize(new Dimension(125, 25));
        pnlTotalPrice.add(lblTotalPrice);

        txtTotalPrice = new JTextField();
        txtTotalPrice.setPreferredSize(new Dimension(150, 25));
        txtTotalPrice.setEditable(false);
        pnlTotalPrice.add(txtTotalPrice);

        btnTotalPrice = new JButton("Count");
        btnTotalPrice.setSize(50,50);
        pnlTotalPrice.add(btnTotalPrice);

        pnlButtonBill = new JPanel();
        pnlButtonBill.setPreferredSize(new Dimension(10, 40));
        pnlEditBill.add(pnlButtonBill, BorderLayout.SOUTH);
        pnlButtonBill.setLayout(new FlowLayout(FlowLayout.CENTER, 40, 10));

        btnAddBill = new JButton("Add");
        btnAddBill.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        btnAddBill.setBackground(new Color(66, 165, 243));
        btnAddBill.setFocusPainted(false);
        btnAddBill.setPreferredSize(new Dimension(100, 25));
        pnlButtonBill.add(btnAddBill);

        btnUpdateBill = new JButton("Update");
        btnUpdateBill.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        btnUpdateBill.setBackground(new Color(66, 165, 243));
        btnUpdateBill.setFocusPainted(false);
        btnUpdateBill.setPreferredSize(new Dimension(100, 25));
        pnlButtonBill.add(btnUpdateBill);

        btnDeleteBill = new JButton("Delete");
        btnDeleteBill.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        btnDeleteBill.setBackground(new Color(66, 165, 243));
        btnDeleteBill.setFocusPainted(false);
        btnDeleteBill.setPreferredSize(new Dimension(100, 25));
        pnlButtonBill.add(btnDeleteBill);

        btnRefreshBill = new JButton("Refresh");
        btnRefreshBill.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        btnRefreshBill.setBackground(new Color(66, 165, 243));
        btnRefreshBill.setFocusPainted(false);
        btnRefreshBill.setPreferredSize(new Dimension(100, 25));
        pnlButtonBill.add(btnRefreshBill);

        // Tạo pnlListBill_Ser gồm pnlListBill ở vị trí Center và pnlListSer1 ở vị trí South
        pnlListBill_Ser = new JPanel();
        pnlListBill_Ser.setBackground(new Color(240, 240, 240));
        pnlEdit_ListBillDetail.add(pnlListBill_Ser, "pnlListBill");
        pnlListBill_Ser.setLayout(new GridLayout(2, 1, 0, 30));
        
        // Tạo JPanel list Bill
        pnlListBill = new JPanel();
        pnlListBill.setBorder(new TitledBorder(null, "List Bill", TitledBorder.LEADING, TitledBorder.TOP, null, null));
        pnlListBill_Ser.add(pnlListBill);
        pnlListBill.setLayout(new BorderLayout(0, 0));
        // Tạo Scroll cho list bill
        sclListBill = new JScrollPane();
        pnlListBill.add(sclListBill);

        Object [][] data4 = {
                {"111", "Nha Trang", "Miền Trung", "20", "20","20", "20"},
        };

        String [] items4 = {"ID", "Name", "Area", "Number of days", "Number of peoples", "Number of peoples", "Number of peoples"};
        billListTable = new JTable(data4,items4);
        sclListBill.setViewportView(billListTable);

        // Tạo JPanel list ser1
        pnlListSer1 = new JPanel();
        pnlListBill_Ser.add(pnlListSer1);
        pnlListSer1.setLayout(new BorderLayout(0, 0));

        sclListSer1 = new JScrollPane();
        sclListSer1.setBorder(new TitledBorder(null, "List Service", TitledBorder.LEADING, TitledBorder.TOP, null, null));
        pnlListSer1.add(sclListSer1);

//        Object [][] data10 = {
//                {"111", "Nha Trang", "Miền Trung", "20", "20","20", "20"},
//        };
//        String [] items10 = {"ID", "Name", "Area", "Number of days", "Number of peoples", "Number of peoples", "Number of peoples"};
        ser1ListTable = new JTable();
        sclListSer1.setViewportView(ser1ListTable);

        panel_3 = new JPanel();
        panel_3.setPreferredSize(new Dimension(50, 10));
        pnlContentBillDetail.add(panel_3, BorderLayout.EAST);

        panel_4 = new JPanel();
        panel_4.setPreferredSize(new Dimension(50, 10));
        pnlContentBillDetail.add(panel_4, BorderLayout.WEST);

        panel_5 = new JPanel();
        panel_5.setPreferredSize(new Dimension(10, 60));
        pnlContentBillDetail.add(panel_5, BorderLayout.SOUTH);

        // change form

        cardLayoutEdit_ListBillDetail = (CardLayout)(pnlEdit_ListBillDetail.getLayout());
    }

    private void loadBillData() {
    	model_bill = new DefaultTableModel();
        model_bill.addColumn("Id");
        model_bill.addColumn("Tour_id");
        model_bill.addColumn("Customer_id");
        model_bill.addColumn("Customer_number");
        model_bill.addColumn("Total_cost");
        model_bill.addColumn("Create_at");
        // load bill table
        BookingBUS bb = new BookingBUS();
        ArrayList<BookingDTO> bookings = bb.getAll();
        String new_id = String.valueOf(bookings.get(bookings.size()-1).getBooking_id()+1);
        txtIdBill.setText(new_id);
        
        TourBUS hdhdhd = new TourBUS();
        CustomerBUS fdfeee = new CustomerBUS();
        for (BookingDTO booking : bookings) {
            model_bill.addRow(new Object[]{
                    booking.getBooking_id(),
                    booking.getTour_id() + "-" + hdhdhd.getById(booking.getTour_id()).getTour_name()+"-"+String.format("%,.2f", hdhdhd.getById(booking.getTour_id()).getPrice())+" đ",
                    booking.getCustomer_id() + "-" + fdfeee.getById(booking.getCustomer_id()).getCustomer_name(),
                    booking.getCustomer_number(),
                    String.format("%,.2f", booking.getTotal_cost())+" đ",
                    booking.getCreate_at()
            });
        }
        billListTable.setModel(model_bill);

        // load combobox Tour
        DefaultComboBoxModel<String> model_tour = new DefaultComboBoxModel<String>();
        TourBUS tb = new TourBUS();
        ArrayList<TourDTO> tours = tb.getAll();

        for (TourDTO tour : tours) {
            model_tour.addElement(tour.getTour_id() + "-" + tour.getTour_name()+"-"+String.format("%,.2f", tour.getPrice())+" đ") ;
        }
        cbxTourNameOfBill.setModel(model_tour);

        // load combobox customer
        DefaultComboBoxModel<String> model_cus = new DefaultComboBoxModel<String>();
        CustomerBUS cb = new CustomerBUS();
        ArrayList<CustomerDTO> customers = cb.getAll();

        for (CustomerDTO customer : customers) {
            model_cus.addElement(customer.getCustomer_id() + "-" + customer.getCustomer_name());
        }
        cbxCusNameOfBill.setModel(model_cus);

        // load service
        arrServices.clear();
        txtSerBill.setText("");
        arrCheckBox.clear();
        pnlSerDetail.removeAll();
        ServiceBUS sbs = new ServiceBUS();
        ArrayList<ServiceDTO> services = sbs.getAll();
        for (ServiceDTO service : services) {
            JCheckBox cbx = new JCheckBox(service.getService_id() +"-" + service.getService_name()+"-"+String.format("%,.2f", service.getService_price())+" đ");
            arrCheckBox.add(cbx);
            pnlSerDetail.add(cbx);
        }
    }

    private void btnInteract() {
        billListTable.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int row = billListTable.getSelectedRow();
                // load form bill
                txtIdBill.setText(billListTable.getValueAt(row,0).toString());
                TourBUS tb = new TourBUS();
                TourDTO td = new TourDTO();
//                setCustomer_id(Integer.parseInt(cus_name.split("-")[0]));
                td = tb.getById( Integer.parseInt( billListTable.getValueAt(row,1).toString().split("-")[0]));
                cbxTourNameOfBill.setSelectedItem(td.getTour_id()+"-"+td.getTour_name()+"-"+String.format("%,.2f", td.getPrice())+" đ");

                CustomerBUS cbs = new CustomerBUS();
                CustomerDTO cdo = new CustomerDTO();
                cdo = cbs.getById(Integer.parseInt(billListTable.getValueAt(row,2).toString().split("-")[0]));
                cbxCusNameOfBill.setSelectedItem(cdo.getCustomer_id()+"-"+cdo.getCustomer_name());
                txtNumOfCus.setText(billListTable.getValueAt(row,3).toString());
                txtTotalPrice.setText(billListTable.getValueAt(row,4).toString());
                // load service table
                BookingBUS bb =new BookingBUS();
                ArrayList<ServiceDTO> services = bb.getServicesOfBooking(Integer.parseInt(billListTable.getValueAt(row,0).toString()));
                while (model_ser.getRowCount() >= 1){
                    model_ser.removeRow(0);
                }
                for (ServiceDTO serive : services) {
                    model_ser.addRow(new Object[]{
                            serive.getService_id(),
                            serive.getService_name(),
                            serive.getService_price()
                    });
                }
                ser1ListTable.setModel(model_ser);

                // load service checkbox
                arrServices.clear();
                for (JCheckBox cbx : arrCheckBox)
                    cbx.setSelected(false);

                for (JCheckBox cbx : arrCheckBox) {
                    for (ServiceDTO service : services)
                        if (Objects.equals(cbx.getText(),service.getService_id()+"-"+service.getService_name()+"-"+service.getService_price())){
                            cbx.setSelected(true);
                            arrServices.add(cbx.getText().split("-")[0]);
                            break;
                        }
                    System.out.println(cbx.isSelected());
                }
                txtSerBill.setText(String.join(",",arrServices));
                loadBillData();
            }
        });

        btnSerBill.addActionListener(e -> {
            JPanel popup = new JPanel(new GridLayout(0,1,0,0));
            JScrollPane scrollPlaceName = new JScrollPane();
            scrollPlaceName.setPreferredSize(new Dimension(300, 200));
            scrollPlaceName.setViewportView(pnlSerDetail);
            pnlSerDetail.setLayout(new GridLayout(0, 1, 0, 0));
            popup.add(scrollPlaceName);

            // load data following region
            for (JCheckBox cbx : arrCheckBox) {
                pnlSerDetail.add(cbx);
            }

            int result = JOptionPane.showConfirmDialog(null, popup, "Choose Services",
                    JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
            if (result == JOptionPane.OK_OPTION) {
                System.out.println("ok");
                arrServices.clear();
                for (JCheckBox cb : arrCheckBox) {
                    if (cb.isSelected()){
                        arrServices.add(cb.getText().split("-")[0]);
                    }
                }
                txtSerBill.setText(String.join(",",arrServices));
            } else {
                System.out.println("Cancelled");
            }
        });

        btnAddBill.addActionListener(e -> {
            if (txtIdBill.getText() == "" || txtNumOfCus.getText() == ""
                    || txtTotalPrice.getText() == "" || arrServices.size() == 0
                    || !isNumeric(txtIdBill.getText())) {
                JOptionPane.showMessageDialog(null,"Dữ liệu không được để trống hoặc sai sót!!");
                return;
            }
            String id = txtIdBill.getText(),
                    tour_name = Objects.requireNonNull(cbxTourNameOfBill.getSelectedItem()).toString(),
                    cus_name = Objects.requireNonNull(cbxCusNameOfBill.getSelectedItem()).toString(),
                    cus_num = txtNumOfCus.getText(),
                    total_price = txtTotalPrice.getText();
            
            BookingDTO bdo = new BookingDTO();
            bdo.setBooking_id(Integer.parseInt(id));
            bdo.setTour_id(Integer.parseInt(tour_name.split("-")[0]));
            bdo.setCustomer_id(Integer.parseInt(cus_name.split("-")[0]));
            bdo.setCustomer_number(Integer.parseInt(cus_num));
            bdo.setTotal_cost(Double.parseDouble(total_price));
            ArrayList<Booking_DetailDTO> booking_details = new ArrayList<>();
            for (String ap : arrServices) {
                Booking_DetailDTO booking_detail = new Booking_DetailDTO();
                booking_detail.setBooking_id(Integer.parseInt(id));
                booking_detail.setService_id( Integer.parseInt(ap));
                booking_details.add(booking_detail);
            }

            if (booking_details.size() == 0) {
                JOptionPane.showMessageDialog(null,"Bạn chưa chọn dịch vụ!!");
                return;
            }

            BookingBUS bbs = new BookingBUS();
            JOptionPane.showMessageDialog(null,bbs.add(bdo,booking_details));
            loadBillData();
        });

        btnUpdateBill.addActionListener(e -> {
            if (txtIdBill.getText() == "" || txtNumOfCus.getText() == ""
                    || txtTotalPrice.getText() == "" || arrServices.size() == 0
                    || !isNumeric(txtIdBill.getText())) {
                JOptionPane.showMessageDialog(null,"Dữ liệu không được để trống hoặc sai sót!!");
                return;
            }
            String id = txtIdBill.getText(),
                    tour_name = Objects.requireNonNull(cbxTourNameOfBill.getSelectedItem()).toString(),
                    cus_name = Objects.requireNonNull(cbxCusNameOfBill.getSelectedItem()).toString(),
                    cus_num = txtNumOfCus.getText(),
                    total_price = txtTotalPrice.getText();

            BookingDTO bdo = new BookingDTO();
            bdo.setBooking_id(Integer.parseInt(id));
            bdo.setTour_id(Integer.parseInt(tour_name.split("-")[0]));
            bdo.setCustomer_id(Integer.parseInt(cus_name.split("-")[0]));
            bdo.setCustomer_number(Integer.parseInt(cus_num));
            bdo.setTotal_cost(Double.parseDouble(total_price));
            ArrayList<Booking_DetailDTO> booking_details = new ArrayList<>();
            for (String ap : arrServices) {
                Booking_DetailDTO booking_detail = new Booking_DetailDTO();
                booking_detail.setBooking_id(Integer.parseInt(id));
                booking_detail.setService_id( Integer.parseInt(ap));
                booking_details.add(booking_detail);
            }

            if (booking_details.size() == 0) {
                JOptionPane.showMessageDialog(null,"Bạn chưa chọn dịch vụ!!");
                return;
            }

            BookingBUS bbs = new BookingBUS();
            JOptionPane.showMessageDialog(null,bbs.update(bdo,booking_details));
            loadBillData();
        });

        btnDeleteBill.addActionListener(e -> {
            if ( txtIdBill.getText() == "" || !isNumeric( txtIdBill.getText())) {
                JOptionPane.showMessageDialog(null,"Id không được để trống và phải là số!!");
                return;
            }
            String id = txtIdBill.getText();

            BookingBUS tb = new BookingBUS();
            JOptionPane.showMessageDialog(null,tb.delete(Integer.parseInt(id)));
        });

        btnRefreshBill.addActionListener(e -> {
            while (model_bill.getRowCount() >= 1){
                model_bill.removeRow(0);
            }
            billListTable.setModel(model_bill);
            loadBillData();
            txtNumOfCus.setText("");
           txtTotalPrice.setText("");
           loadBillData();

        });

        btnTotalPrice.addActionListener(e -> {
            if (Objects.equals(txtNumOfCus.getText(), "")) {
                JOptionPane.showMessageDialog(null,"Bạn chưa nhập số lượng khách hàng!!");
                return;
            }
            double total=0;
            int tourid = Integer.parseInt(Objects.requireNonNull(cbxTourNameOfBill.getSelectedItem()).toString().split("-")[0]);
            TourBUS tourbs = new TourBUS();
            double price_tour = tourbs.getById(tourid).getPrice();
//            double tour_name = Double.parseDouble(Objects.requireNonNull(cbxTourNameOfBill.getSelectedItem()).toString().split("-")[2]);
            double cus_num = Double.parseDouble(txtNumOfCus.getText());
            if (cus_num < 1 ){
                JOptionPane.showMessageDialog(null,"Số lượng khách hàng không được bé hơn 1!!");
                return;
            }

            if (arrServices.size() == 0 ){
                JOptionPane.showMessageDialog(null,"Bạn chưa chọn dịch vụ!!");
                return;
            }
            ServiceBUS sbs = new ServiceBUS();
            for (String ser : arrServices) {
                total += sbs.getById(Integer.parseInt(ser)).getService_price();
            }
            total += price_tour*cus_num;
            sumsertour = total;
            txtTotalPrice.setText(String.valueOf(total));
        });

        lblSearchBill.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent me) {
                if ( txtSearchBill.getText() == "") {
                    JOptionPane.showMessageDialog(null,"Ô tìm kiếm đang trống!!");
                    return;
                }
                String shString = txtSearchBill.getText().trim();
                BookingBUS bbs = new BookingBUS();
                if(isNumeric(shString)) {
                    BookingDTO bookingdto= bbs.getById(Integer.parseInt(shString.trim()));
                    if(bookingdto != null) {
                        txtIdBill.setText( String.valueOf(bookingdto.getBooking_id()));
                        TourBUS tbs = new TourBUS();
                        TourDTO tdo = tbs.getById(bookingdto.getTour_id());
                        cbxTourNameOfBill.setSelectedItem(tdo.getTour_id()+"-"+tdo.getTour_name()+"-"+tdo.getPrice());

                        // ----------------------------- load service checkbox
                        BookingBUS bb = new BookingBUS();
                        ArrayList<ServiceDTO> services = bb.getServicesOfBooking(bookingdto.getBooking_id());
                        arrServices.clear();
                        for (JCheckBox cbx : arrCheckBox)
                            cbx.setSelected(false);

                        for (JCheckBox cbx : arrCheckBox) {
                            for (ServiceDTO service : services)
                                if (Objects.equals(cbx.getText(),service.getService_id()+"-"+service.getService_name()+"-"+String.format("%,.2f", service.getService_price())+" đ")){
                                    cbx.setSelected(true);
                                    arrServices.add(cbx.getText().split("-")[0]);
                                    break;
                                }
                            System.out.println(cbx.isSelected());
                        }
                        txtSerBill.setText(String.join(",",arrServices));

                        // ----------------------------------------
                        txtNumOfCus.setText(String.valueOf( bookingdto.getCustomer_number()));
                        CustomerBUS cusbs = new CustomerBUS();
                        CustomerDTO cdo = cusbs.getById(bookingdto.getCustomer_id());
                        cbxCusNameOfBill.setSelectedItem(cdo.getCustomer_id()+"-"+cdo.getCustomer_name());

                        txtTotalPrice.setText(String.valueOf(bookingdto.getTotal_cost()));
                    }
                    if(bookingdto ==null) {
                        JOptionPane.showMessageDialog(null, "Không tìm thấy thông tin bill !");
                    }
                }
            }
        });
    }


    private boolean isNumeric(String strNum) {
        Pattern pattern = Pattern.compile("-?\\d+(\\.\\d+)?");
        if (strNum == null) {
            return false;
        }
        return pattern.matcher(strNum).matches();
    }
}
