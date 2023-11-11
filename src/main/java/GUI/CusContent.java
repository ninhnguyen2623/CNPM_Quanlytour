package GUI;

import DAO.CustomerDAO;
import DTO.CustomerDTO;
import DTO.HotelDTO;

import com.toedter.calendar.JDateChooser;

import BUS.CustomerBUS;

import javax.swing.*;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.awt.*;
import java.awt.event.*;
import java.text.DateFormat;
import java.text.Normalizer;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.regex.Pattern;

public class CusContent extends JPanel{
    private JPanel pnlCusContentTitle;
    private JLabel lblCusContentTitle;
    private JPanel pnlSearchCus;
    private JLabel lblSearchCus;
    private JPanel pnlContentCusDetail;
    private JPanel pnlEdit_ListCus;
    private JPanel pnlbtnEdit_ListCus;
    private JPanel pnlEditCus;
    private JScrollPane scrollFillInforCus;
    private JPanel pnlFillCus;
    private JPanel pnlIdCus;
    private JLabel lblIdCus;
    private JTextField txtIdCus;
    private JPanel pnlNameCus;
    private JLabel lblNameCus;
    private JTextField txtNameCus;
    private JPanel pnlOldCus;
    private JLabel lblOldCus;
    private JPanel pnlGenderCus;
    private JLabel lblGenderCus;
    private ButtonGroup bgGenderCus;
    private JRadioButton rdbtnMale;
    private JRadioButton rdbtnFemale;
    private JPanel pnlPhoneCus;
    private JLabel lblPhoneCus;
    private JTextField txtPhoneCus;
    private JPanel pnlEmailCus;
    private JLabel lblEmailCus;
    private JTextField txtEmailCus;
    private JPanel pnlButtonCus;
    private JButton btnAddCus;
    private JButton btnDeleteCus;
    private JPanel pnlListCus;
    private JDateChooser OldCus;
    private JButton btnRefreshCus;
    private JTable cusListTable;
    private JScrollPane sclListCus;
    private JPanel pnlIconSrc_Txt;
    private JTextField txtSearchCus;
    private JPanel panel;
    private JPanel panel_1;
    private JPanel panel_2;
    private JPanel panel_6;
    private JPanel panel_3;
    private JPanel panel_4;
    private JPanel panel_5;
    private JButton btnEditCus;
    private JButton btnListCus;
    private JPanel pnlEdit_ListCusDetail;
    public JPanel getPnlEdit_ListCusDetail() {
        return this.pnlEdit_ListCusDetail;
    }
    private CardLayout cardLayoutEdit_ListCusDetail;


    public CusContent() {
        init();
    }

    private void init() {


        setLayout(new BorderLayout(0, 0));

        pnlCusContentTitle = new JPanel();
        pnlCusContentTitle.setPreferredSize(new Dimension(10, 125));
        add(pnlCusContentTitle, BorderLayout.NORTH);
        pnlCusContentTitle.setLayout(new BorderLayout(0, 0));

        lblCusContentTitle = new JLabel("Customer Manager");
        lblCusContentTitle.setPreferredSize(new Dimension(200, 50));
        lblCusContentTitle.setHorizontalAlignment(SwingConstants.CENTER);
        lblCusContentTitle.setFont(new Font("Times New Roman", Font.PLAIN, 24));
        pnlCusContentTitle.add(lblCusContentTitle, BorderLayout.NORTH);

        pnlSearchCus = new JPanel();
        pnlSearchCus.setPreferredSize(new Dimension(10, 60));
        pnlCusContentTitle.add(pnlSearchCus, BorderLayout.CENTER);
        pnlSearchCus.setLayout(new BorderLayout(0, 0));

        pnlIconSrc_Txt = new JPanel();
        pnlSearchCus.add(pnlIconSrc_Txt, BorderLayout.CENTER);
        pnlIconSrc_Txt.setLayout(new BorderLayout(0, 0));

        txtSearchCus = new JTextField();
        txtSearchCus.setText("Search Customer");
        pnlIconSrc_Txt.add(txtSearchCus, BorderLayout.CENTER);
        txtSearchCus.setMargin(new Insets(2, 10, 2, 10));
        txtSearchCus.addFocusListener(new FocusListener() {

            @Override
            public void focusLost(FocusEvent e) {
                Font font = txtSearchCus.getFont();
                font = font.deriveFont(Font.ITALIC);
                txtSearchCus.setFont(font);
                txtSearchCus.setForeground(Color.gray);
                txtSearchCus.setText("Search Customer");
            }

            @Override
            public void focusGained(FocusEvent e) {
                txtSearchCus.setText(null);
                txtSearchCus.requestFocus();;
                Font font = txtSearchCus.getFont();
                font = font.deriveFont(Font.PLAIN|Font.BOLD);
                txtSearchCus.setFont(font);
                txtSearchCus.setForeground(Color.black);

            }
        });
//		serach ------------------------------------------------------------------------------------------------------------------------------------
        lblSearchCus = new JLabel("");
        lblSearchCus.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent me) {

                String shString = txtSearchCus.getText().trim();
                if(isNumeric(shString)== true) {
                    int idcustomer = Integer.parseInt(shString.trim());
                    CustomerBUS customerBUS = new CustomerBUS();
                    CustomerDTO customerDTO = customerBUS.getById(idcustomer);
                    if(customerDTO != null) {
                        String idcustomerString = String.valueOf(customerDTO.getCustomer_id());
                        txtIdCus.setText(idcustomerString);
                        txtNameCus.setText(customerDTO.getCustomer_name());
                        String telcusString = String.valueOf(customerDTO.getTel());
                        txtPhoneCus.setText(telcusString);
                        txtEmailCus.setText(customerDTO.getEmail());
                        try {
                            Date date1 = new SimpleDateFormat("yyyy-MM-dd").parse(customerDTO.getBirthday());
                            OldCus.setDate(date1);
                        } catch (ParseException e) {
                            // TODO Auto-generated catch block
                            e.printStackTrace();
                        }
                    }
                    if(customerDTO == null) {
                        JOptionPane.showMessageDialog(null, "Không tìm thấy thông tin Customer !");
                    }
                }
                if (isNumeric(shString)== false) {
                	CustomerBUS customerBUS = new CustomerBUS();
                    ArrayList<CustomerDTO> arrhCustomerDTOs = customerBUS.getAll();
                    Boolean checkKQ = false;
                    for(CustomerDTO itemCustomerDTO: arrhCustomerDTOs) {
                        String temp = Normalizer.normalize(itemCustomerDTO.getCustomer_name(), Normalizer.Form.NFD);
                        String temp2 = Normalizer.normalize(shString, Normalizer.Form.NFD);
                        Pattern pattern = Pattern.compile("\\p{InCombiningDiacriticalMarks}+");
                        if(pattern.matcher(temp).replaceAll("").equalsIgnoreCase(pattern.matcher(temp2).replaceAll(""))) {
                            String idhotelString = String.valueOf(itemCustomerDTO.getCustomer_id());
                            txtIdCus.setText(idhotelString);
                            txtNameCus.setText(itemCustomerDTO.getCustomer_name());
                            String telcusString = String.valueOf(itemCustomerDTO.getTel());
                            txtPhoneCus.setText(telcusString);
                            txtEmailCus.setText(itemCustomerDTO.getEmail());
                            try {
                                Date date1 = new SimpleDateFormat("yyyy-MM-dd").parse(itemCustomerDTO.getBirthday());
                                OldCus.setDate(date1);
                            } catch (ParseException e) {
                                // TODO Auto-generated catch block
                                e.printStackTrace();
                            }
                            checkKQ = true;
                        }
                    }
                    if(checkKQ == false) {
                        JOptionPane.showMessageDialog(null, "Không tìm thấy thông tin Customer !");
                    }
                }
            }

        });
//		end serach ------------------------------------------------------------------------------------------------------------------------------------



        lblSearchCus.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
        pnlIconSrc_Txt.add(lblSearchCus, BorderLayout.EAST);
		lblSearchCus.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(Manager.class.getResource("../images/search.png"))));
        lblSearchCus.setCursor(new Cursor(Cursor.HAND_CURSOR));

        panel = new JPanel();
        panel.setPreferredSize(new Dimension(10, 20));
        pnlSearchCus.add(panel, BorderLayout.NORTH);

        panel_1 = new JPanel();
        panel_1.setPreferredSize(new Dimension(10, 20));
        pnlSearchCus.add(panel_1, BorderLayout.SOUTH);

        panel_2 = new JPanel();
        panel_2.setPreferredSize(new Dimension(250, 10));
        pnlSearchCus.add(panel_2, BorderLayout.EAST);

        panel_6 = new JPanel();
        panel_6.setPreferredSize(new Dimension(250, 10));
        pnlSearchCus.add(panel_6, BorderLayout.WEST);

        pnlContentCusDetail = new JPanel();
        add(pnlContentCusDetail, BorderLayout.CENTER);
        pnlContentCusDetail.setLayout(new BorderLayout(0, 0));

        pnlEdit_ListCus = new JPanel();
        pnlContentCusDetail.add(pnlEdit_ListCus, BorderLayout.CENTER);
        pnlEdit_ListCus.setLayout(new BorderLayout(0, 0));

        pnlbtnEdit_ListCus = new JPanel();
        pnlbtnEdit_ListCus.setPreferredSize(new Dimension(10, 50));
        pnlEdit_ListCus.add(pnlbtnEdit_ListCus, BorderLayout.NORTH);
        pnlbtnEdit_ListCus.setLayout(new BoxLayout(pnlbtnEdit_ListCus, BoxLayout.X_AXIS));

        btnEditCus = new JButton("Edit Customer");
        btnEditCus.setContentAreaFilled(false);
        btnEditCus.setFocusPainted(false);
        btnEditCus.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        pnlbtnEdit_ListCus.add(btnEditCus);
        btnEditCus.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayoutEdit_ListCusDetail.show(pnlEdit_ListCusDetail,"pnlEditCus");
            }
        });

        btnListCus= new JButton("List Customer");
        btnListCus.setContentAreaFilled(false);
        btnListCus.setFocusPainted(false);
        btnListCus.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        pnlbtnEdit_ListCus.add(btnListCus);
        btnListCus.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayoutEdit_ListCusDetail.show(pnlEdit_ListCusDetail,"pnlListCus");
            }
        });

        pnlEdit_ListCusDetail = new JPanel();
        pnlEdit_ListCus.add(pnlEdit_ListCusDetail, BorderLayout.CENTER);
        pnlEdit_ListCusDetail.setLayout(new CardLayout(0, 0));

        pnlEditCus = new JPanel();
        pnlEdit_ListCusDetail.add(pnlEditCus, "pnlEditCus");
        pnlEditCus.setLayout(new BorderLayout(0, 0));

        scrollFillInforCus = new JScrollPane();
        scrollFillInforCus.setBorder(new TitledBorder(null, "Edit Customer", TitledBorder.LEADING, TitledBorder.TOP, null, null));
        pnlEditCus.add(scrollFillInforCus, BorderLayout.CENTER);

        pnlFillCus = new JPanel();
        pnlFillCus.setBorder(null);
        scrollFillInforCus.setViewportView(pnlFillCus);
        pnlFillCus.setLayout(new GridLayout(6, 1, 0, 0));

        pnlIdCus = new JPanel();
        pnlIdCus.setPreferredSize(new Dimension(320, 35));
        pnlFillCus.add(pnlIdCus);
        pnlIdCus.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

        lblIdCus = new JLabel("ID");
        lblIdCus.setPreferredSize(new Dimension(125, 25));
        pnlIdCus.add(lblIdCus);

        txtIdCus = new JTextField();
        txtIdCus.setPreferredSize(new Dimension(100, 25));
        pnlIdCus.add(txtIdCus);
        txtIdCus.setColumns(20);

        pnlNameCus = new JPanel();
        pnlNameCus.setPreferredSize(new Dimension(320, 35));
        pnlFillCus.add(pnlNameCus);
        pnlNameCus.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

        lblNameCus = new JLabel("Name");
        lblNameCus.setPreferredSize(new Dimension(125, 25));
        pnlNameCus.add(lblNameCus);

        txtNameCus = new JTextField();
        txtNameCus.setPreferredSize(new Dimension(100, 25));
        txtNameCus.setColumns(20);
        pnlNameCus.add(txtNameCus);

        pnlOldCus = new JPanel();
        pnlOldCus.setPreferredSize(new Dimension(320, 35));
        pnlFillCus.add(pnlOldCus);
        pnlOldCus.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

        lblOldCus = new JLabel("Date of birth");
        lblOldCus.setPreferredSize(new Dimension(125, 25));
        pnlOldCus.add(lblOldCus);

        OldCus = new JDateChooser();
        OldCus.setPreferredSize(new Dimension(225, 25));
        pnlOldCus.add(OldCus);
        //		pnlGenderCus = new JPanel();
//		pnlFillCus.add(pnlGenderCus);
//		pnlGenderCus.setLayout(new FlowLayout(FlowLayout.CENTER, 85, 5));
//
//		lblGenderCus = new JLabel("Gender");
//		lblGenderCus.setPreferredSize(new Dimension(43, 25));
//		pnlGenderCus.add(lblGenderCus);
//
//		bgGenderCus = new ButtonGroup();
//		rdbtnMale = new JRadioButton("Male");
//		rdbtnMale.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
//		rdbtnMale.setFont(new Font("Times New Roman", Font.PLAIN, 12));
//		rdbtnMale.setFocusPainted(false);
//		rdbtnMale.setPreferredSize(new Dimension(72, 25));
//		pnlGenderCus.add(rdbtnMale);
//		bgGenderCus.add(rdbtnMale);
//
//		rdbtnFemale = new JRadioButton("Female");
//		rdbtnFemale.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
//		rdbtnFemale.setFont(new Font("Times New Roman", Font.PLAIN, 12));
//		rdbtnFemale.setFocusPainted(false);
//		rdbtnFemale.setPreferredSize(new Dimension(72, 25));
//		pnlGenderCus.add(rdbtnFemale);
//		bgGenderCus.add(rdbtnFemale);

//        pnlGenderCus = new JPanel();
//        pnlFillCus.add(pnlGenderCus);
//        pnlGenderCus.setLayout(new FlowLayout(FlowLayout.CENTER, 85, 5));
//
//        lblGenderCus = new JLabel("Gender");
//        lblGenderCus.setPreferredSize(new Dimension(43, 25));
//        pnlGenderCus.add(lblGenderCus);
//
//        bgGenderCus = new ButtonGroup();
//        rdbtnMale = new JRadioButton("Male");
//        rdbtnMale.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
//        rdbtnMale.setFont(new Font("Times New Roman", Font.PLAIN, 12));
//        rdbtnMale.setFocusPainted(false);
//        rdbtnMale.setPreferredSize(new Dimension(72, 25));
//        pnlGenderCus.add(rdbtnMale);
//        bgGenderCus.add(rdbtnMale);
//
//        rdbtnFemale = new JRadioButton("Female");
//        rdbtnFemale.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
//        rdbtnFemale.setFont(new Font("Times New Roman", Font.PLAIN, 12));
//        rdbtnFemale.setFocusPainted(false);
//        rdbtnFemale.setPreferredSize(new Dimension(72, 25));
//        pnlGenderCus.add(rdbtnFemale);
//        bgGenderCus.add(rdbtnFemale);

        pnlPhoneCus = new JPanel();
        pnlPhoneCus.setPreferredSize(new Dimension(320, 35));
        pnlFillCus.add(pnlPhoneCus);
        pnlPhoneCus.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

        lblPhoneCus = new JLabel("Phone");
        lblPhoneCus.setPreferredSize(new Dimension(125, 25));
        pnlPhoneCus.add(lblPhoneCus);

        txtPhoneCus = new JTextField();
        txtPhoneCus.setPreferredSize(new Dimension(100, 25));
        txtPhoneCus.setColumns(20);
        pnlPhoneCus.add(txtPhoneCus);

        pnlEmailCus = new JPanel();
        pnlEmailCus.setPreferredSize(new Dimension(320, 35));
        pnlFillCus.add(pnlEmailCus);
        pnlEmailCus.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

        lblEmailCus = new JLabel("Email");
        lblEmailCus.setPreferredSize(new Dimension(125, 25));
        pnlEmailCus.add(lblEmailCus);

        txtEmailCus = new JTextField();
        txtEmailCus.setPreferredSize(new Dimension(100, 25));
        txtEmailCus.setColumns(20);
        pnlEmailCus.add(txtEmailCus);

        pnlButtonCus = new JPanel();
        pnlButtonCus.setBorder(null);
        pnlButtonCus.setPreferredSize(new Dimension(10, 40));
        pnlEditCus.add(pnlButtonCus, BorderLayout.SOUTH);
        pnlButtonCus.setLayout(new FlowLayout(FlowLayout.CENTER, 40, 10));

        btnAddCus = new JButton("Add");
        btnAddCus.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String idString = txtIdCus.getText();
                CustomerBUS customerBUS = new CustomerBUS();
                int idcs = 0 ;
                if(isNumeric(idString)==true) {
                    idcs = Integer.parseInt(idString.trim());
                }
                String nameString = txtNameCus.getText().trim();
                String telString = txtPhoneCus.getText().trim();
                String telcs = "";
                if(isNumeric(telString)==true) {
                    telcs = telString.trim();
                }
                Date date1 = OldCus.getDate();
                SimpleDateFormat dddDateFormat = new SimpleDateFormat("yyyy-MM-dd");
                String dateString = dddDateFormat.format(date1);

                String emailString = txtEmailCus.getText().trim();
                boolean checkidhotel = false;
                ArrayList<CustomerDTO> csmdto = customerBUS.getAll();
                for(CustomerDTO jjjjdfe:csmdto) {
                	if(jjjjdfe.getCustomer_id()==idcs) {
                		checkidhotel = true;
                	}
                }
                if( isNumeric(idString)== false ) {
                    JOptionPane.showMessageDialog(null, "Định dạng id phải là số  !");
                    return;
                }
                else if(checkidhotel==true) {
                	JOptionPane.showMessageDialog(null, "id đã tồn tại vui lòng nhập số khác !");
                	return;
                }
                else if(checkPhone(telString)==false) {
                    JOptionPane.showMessageDialog(null, "Định dạng số điện thoại không dúng  !");
                    return;
                }
                else if(isEmail(emailString)== false) {
                    JOptionPane.showMessageDialog(null, "Định dạng email khong dung !");
                    return;
                }
                else {
                    CustomerDTO csCustomerDTO = new CustomerDTO(idcs,nameString,telcs,dateString,emailString,"");
                    int result = JOptionPane.showConfirmDialog(null,
                            "Bạn có muốn them hotel  " +nameString,
                            "Xác nhận",
                            JOptionPane.YES_NO_OPTION,
                            JOptionPane.QUESTION_MESSAGE);
                    if(result == JOptionPane.YES_OPTION){
//                        CustomerDAO.getInstance().add(csCustomerDTO);
                    	customerBUS.add(csCustomerDTO);
                        ClassLoaddataCustomer();
                    }
                    RefreshCustomer();
                }
            }

            private DateFormat SimpleDateFormat(String string) {
                // TODO Auto-generated method stub
                return null;
            }
        });
        btnAddCus.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        btnAddCus.setFocusPainted(false);
        btnAddCus.setBackground(new Color(66, 165, 243));
        btnAddCus.setPreferredSize(new Dimension(100, 25));
        pnlButtonCus.add(btnAddCus);

        btnDeleteCus = new JButton("Delete");
        btnDeleteCus.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String idString = txtIdCus.getText().trim();
                int idcs = Integer.parseInt(idString);
                int result = JOptionPane.showConfirmDialog(null,
                        "Bạn có chắc muốn xoa Customer id: " +idcs,
                        "Xác nhận",
                        JOptionPane.YES_NO_OPTION,
                        JOptionPane.QUESTION_MESSAGE);
                if(result == JOptionPane.YES_OPTION){
                	CustomerBUS customerBUS = new CustomerBUS();
                	customerBUS.delete(idcs);
//                    CustomerDAO.getInstance().delete(idcs);
                    ClassLoaddataCustomer();
                }
                RefreshCustomer();
            }
        });
        btnDeleteCus.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        btnDeleteCus.setBackground(new Color(66, 165, 243));
        btnDeleteCus.setFocusPainted(false);
        btnDeleteCus.setPreferredSize(new Dimension(100, 25));
        pnlButtonCus.add(btnDeleteCus);

        btnAddCus = new JButton("Update");
        btnAddCus.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String idString = txtIdCus.getText();
                int idcs = 0 ;
                if(isNumeric(idString)==true) {
                    idcs = Integer.parseInt(idString.trim());
                }
                String nameString = txtNameCus.getText().trim();
                String telString = txtPhoneCus.getText();
                String telcs= "";
                if(isNumeric(telString)==true) {
                    telcs =telString.trim();
                }
                Date date1 = OldCus.getDate();
                SimpleDateFormat dddDateFormat = new SimpleDateFormat("yyyy-MM-dd");
                String dateString = dddDateFormat.format(date1);

                String emailString = txtEmailCus.getText().trim();
                Boolean checkid = false;
                CustomerBUS customerBUS= new CustomerBUS();
                ArrayList<CustomerDTO> csmdto = customerBUS.getAll();
                for(CustomerDTO jjjjdfe:csmdto) {
                	if(jjjjdfe.getCustomer_id()==idcs) {
                		checkid = true;
                	}
                }
                if( isNumeric(idString)== false ) {
                    JOptionPane.showMessageDialog(null, "Định dạng id phải là số  !");
                    return;
                }
                else if(checkid == false) {
                	JOptionPane.showMessageDialog(null, "id không tồn tại vui lòng nhập lại !");
                	 return;
                }
                else if(checkPhone(telString)==false) {
                    JOptionPane.showMessageDialog(null, "Định dạng số điện thoại không dúng  !");
                    return;
                }
                else if(isEmail(emailString)== false) {
                    JOptionPane.showMessageDialog(null, "Định dạng email khong dung !");
                    return;
                }
                else {
                    CustomerDTO csCustomerDTO = new CustomerDTO(idcs,nameString,telcs,dateString,emailString,"");
                    int result = JOptionPane.showConfirmDialog(null,
                            "Bạn có muốn sửa :  " +nameString,
                            "Xác nhận",
                            JOptionPane.YES_NO_OPTION,
                            JOptionPane.QUESTION_MESSAGE);
                    if(result == JOptionPane.YES_OPTION){
                    	customerBUS.update(csCustomerDTO);
                        ClassLoaddataCustomer();
                    }
                    RefreshCustomer();
                }
            }
        });
        btnAddCus.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        btnAddCus.setBackground(new Color(66, 165, 243));
        btnAddCus.setFocusPainted(false);
        btnAddCus.setPreferredSize(new Dimension(100, 25));
        pnlButtonCus.add(btnAddCus);

        btnRefreshCus = new JButton("Refresh");
        btnRefreshCus.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                RefreshCustomer();
            }
        });
        btnRefreshCus.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        btnRefreshCus.setFocusPainted(false);
        btnRefreshCus.setBackground(new Color(66, 165, 243));
        btnRefreshCus.setPreferredSize(new Dimension(100, 25));
        pnlButtonCus.add(btnRefreshCus);

        pnlListCus = new JPanel();
        pnlListCus.setBorder(new TitledBorder(null, "List Customer", TitledBorder.LEADING, TitledBorder.TOP, null, null));
        pnlListCus.setBackground(new Color(240, 240, 240));
        pnlEdit_ListCusDetail.add(pnlListCus, "pnlListCus");
        pnlListCus.setLayout(new BorderLayout(0, 0));


        sclListCus = new JScrollPane();
        pnlListCus.add(sclListCus, BorderLayout.CENTER);

//  load du lieu
        ClassLoaddataCustomer();
        panel_4 = new JPanel();
        panel_4.setPreferredSize(new Dimension(50, 10));
        pnlContentCusDetail.add(panel_4, BorderLayout.WEST);

        panel_5 = new JPanel();
        panel_5.setPreferredSize(new Dimension(10, 60));
        pnlContentCusDetail.add(panel_5, BorderLayout.SOUTH);


        // ------------ Change Form -------------------- //

        cardLayoutEdit_ListCusDetail =  (CardLayout)(this.getPnlEdit_ListCusDetail().getLayout());
    }

    public void ClassLoaddataCustomer() {
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("ID");;
        model.addColumn("Name");
        model.addColumn("Tel");
        model.addColumn("Birthday");
        model.addColumn("Email");
        model.addColumn("Create_At");
        CustomerBUS customerBUS = new CustomerBUS();
    	ArrayList<CustomerDTO> arrCustomer = customerBUS.getAll();
    	int i = 0;
        for(CustomerDTO itemCustomer : arrCustomer ) {
        	i++;
            model.addRow(new Object[] {
                    itemCustomer.getCustomer_id(),itemCustomer.getCustomer_name(),itemCustomer.getTel(),itemCustomer.getBirthday(),itemCustomer.getEmail(),itemCustomer.getCreate_at()
            });
        }
        cusListTable = new JTable();
        cusListTable.setModel(model);
        sclListCus.setViewportView(cusListTable);
        panel_3 = new JPanel();
        panel_3.setPreferredSize(new Dimension(50, 10));
        pnlContentCusDetail.add(panel_3, BorderLayout.EAST);
        txtIdCus.setText(String.valueOf(i+1));
        getDataFromJtableCustomer();

    }
    public void getDataFromJtableCustomer() {
        List<CustomerDTO> customerDTO = new ArrayList<CustomerDTO>();
        cusListTable.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent me) {
                int i = cusListTable.getSelectedRow();
                TableModel model = cusListTable.getModel();
                int idcs = Integer.parseInt(model.getValueAt(i,0).toString());
                String namecs = model.getValueAt(i,1).toString();
                String telhotel = model.getValueAt(i,2).toString();
                String birthdaycs = model.getValueAt(i,3).toString();
                String  emailcs = model.getValueAt(i,4).toString();
                String  create_atcs =model.getValueAt(i,5).toString();
//	        	add  table to txt
                String idhotelString = String.valueOf(idcs);
                txtIdCus.setText(idhotelString);
                txtNameCus.setText(namecs);
                String telhotelString = String.valueOf(telhotel);
                txtPhoneCus.setText(telhotelString);
                txtEmailCus.setText(emailcs);
                try {
                    Date date1 = new SimpleDateFormat("yyyy-MM-dd").parse(birthdaycs);
                    OldCus.setDate(date1);
                } catch (ParseException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        });

    }
    public  void  RefreshCustomer() {
        txtNameCus.setText("");
        txtPhoneCus.setText("");
        txtEmailCus.setText("");
        OldCus.setDate(null);
        CustomerBUS customerBUS = new CustomerBUS();
    	ArrayList<CustomerDTO> arrCustomer = customerBUS.getAll();
    	int i = 0;
        for(CustomerDTO itemCustomer : arrCustomer ) {
        	i++;
        }
        txtIdCus.setText(String.valueOf(i+1));
        txtSearchCus.setText("");
    }
    public boolean checkPhone(String str){
        String reg = "^(0|\\+84)(\\s|\\.)?((3[2-9])|(5[689])|(7[06-9])|(8[1-689])|(9[0-46-9]))(\\d)(\\s|\\.)?(\\d{3})(\\s|\\.)?(\\d{3})$";
        boolean kt = str.matches(reg);
        return kt;
    }
    public static boolean isEmail(String url) {
        String EMAIL_REGEX = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
        Boolean b = url.matches(EMAIL_REGEX);
        return b;
    }
    public static boolean isURL(String url) {
        try {
            (new java.net.URL(url)).openStream().close();
            return true;
        } catch (Exception ex) { }
        return false;
    }
    public static boolean isNumeric(final CharSequence cs) {
//        if (cs.isEmpty()) {
//            return false;
//        }
        final int sz = cs.length();
        for (int i = 0; i < sz; i++) {
            if (!Character.isDigit(cs.charAt(i))) {
                return false;
            }
        }
        return true;
    }
//  end customer ----------------------------------------------------------------------------------------------------------------------------------------------------------------------------

}
