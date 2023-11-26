package GUI;

import BUS.HotelBUS;
import BUS.RoleBUS;
import BUS.TourBUS;
import BUS.UserBUS;
import DTO.HotelDTO;
import DTO.RoleDTO;
import DTO.TourDTO;
import DTO.UserDTO;
import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.nio.file.attribute.UserPrincipal;
import java.text.Normalizer;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Objects;
import java.util.regex.Pattern;

public class AccContent extends JPanel {
    private JPanel pnlIconSrc_Txt;
    private JPanel panel;
    private JPanel panel_1;
    private JPanel panel_2;
    private JPanel panel_6;
    private JPanel panel_3;
    private JPanel panel_4;
    private JPanel panel_5;
    private JPanel pnlAccContentTitle;
    private JLabel lblAccContentTitle;
    private JPanel pnlSearchAcc;
    private JLabel lblSearchAcc;
    private JPanel pnlContentAccDetail;
    private JPanel pnlEdit_ListAcc;
    private JPanel pnlbtnEdit_ListAcc;
    private JPanel pnlEditAcc;
    private JScrollPane scrollFillInforAcc;
    private JPanel pnlFillAcc;
    private JPanel pnlIdAcc;
    private JLabel lblIdAcc;
    private JTextField txtIdAcc;
    private JPanel pnlUserNameAcc;
    private JLabel lblUserNameAcc;
    private JTextField txtUserNameAcc;
    private JPanel pnlPassAcc;
    private JLabel lblPassAcc;
    private JTextField txtPassAcc;
    private JPanel pnlPermissionAcc;
    private JLabel lblPermissionAcc;
    private JComboBox cbxPermissionAcc;
    private JPanel pnlButtonAcc;
    private JButton btnAddAcc;
    private JButton btnDeleteAcc;
    private JPanel pnlListAcc;
    private JButton btnEditTour;
    private JButton btnRefreshAcc;
    private JPanel pnlFullName;
    private JPanel pnlEmpOld;
    private JPanel pnlEmpGender;
    private JPanel pnlEmpTel;
    private JLabel lblFullName;
    private JTextField txtEmpName;
    private JLabel lblEmpOld;
    private JLabel lblEmpGender;
    private JTextField txtEmpTel;
    private JLabel lblEmpTel;
    private ButtonGroup bgGenderEmp;
    private JRadioButton rdbtnMaleEmp;
    private JRadioButton rdbtnFemaleEmp;
    private JDateChooser OldEmp;
    private JScrollPane sclListAcc;
    private JTable accListTable;
    private JTextField txtSearchAcc;

    private JButton btnEditAcc;
    private JButton btnListAcc;
    private JPanel pnlEdit_ListAccDetail;
    private CardLayout cardLayoutEdit_ListAccDetail;
    private DefaultTableModel model_acc;
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    private JButton btnUpdateAcc;


    public AccContent() {
        setUpTable();
        init();
        loadAccData();
        btnInteract();
    }



    private void setUpTable() {
        model_acc = new DefaultTableModel();
        model_acc.addColumn("Id");
        model_acc.addColumn("User_name");
        model_acc.addColumn("Password");
        model_acc.addColumn("Fullname");
        model_acc.addColumn("Tel");
        model_acc.addColumn("Birthday");
        model_acc.addColumn("Gender");
        model_acc.addColumn("Role");

    }

    private void init() {

        setLayout(new BorderLayout(0, 0));

        pnlAccContentTitle = new JPanel();
        pnlAccContentTitle.setPreferredSize(new Dimension(10, 125));
        add(pnlAccContentTitle, BorderLayout.NORTH);
        pnlAccContentTitle.setLayout(new BorderLayout(0, 0));

        lblAccContentTitle = new JLabel("Account Manager");
        lblAccContentTitle.setPreferredSize(new Dimension(200, 50));
        lblAccContentTitle.setHorizontalAlignment(SwingConstants.CENTER);
        lblAccContentTitle.setFont(new Font("Times New Roman", Font.PLAIN, 24));
        pnlAccContentTitle.add(lblAccContentTitle, BorderLayout.NORTH);

        pnlSearchAcc = new JPanel();
        pnlSearchAcc.setPreferredSize(new Dimension(10, 60));
        pnlAccContentTitle.add(pnlSearchAcc, BorderLayout.CENTER);
        pnlSearchAcc.setLayout(new BorderLayout(0, 0));

        pnlIconSrc_Txt = new JPanel();
        pnlSearchAcc.add(pnlIconSrc_Txt, BorderLayout.CENTER);
        pnlIconSrc_Txt.setLayout(new BorderLayout(0, 0));

        txtSearchAcc = new JTextField();
        txtSearchAcc.setText("Search Account");
        pnlIconSrc_Txt.add(txtSearchAcc, BorderLayout.CENTER);
        txtSearchAcc.setMargin(new Insets(2, 10, 2, 10));
        txtSearchAcc.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                txtSearchAcc.setText(null);
                txtSearchAcc.requestFocus();;
                Font font = txtSearchAcc.getFont();
                font = font.deriveFont(Font.PLAIN|Font.BOLD);
                txtSearchAcc.setFont(font);
                txtSearchAcc.setForeground(Color.black);
            }

            @Override
            public void focusLost(FocusEvent e) {
                Font font = txtSearchAcc.getFont();
                font = font.deriveFont(Font.ITALIC);
                txtSearchAcc.setFont(font);
                txtSearchAcc.setForeground(Color.gray);
                txtSearchAcc.setText("Search Account");
            }
        });

        lblSearchAcc = new JLabel("");
        lblSearchAcc.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
        pnlIconSrc_Txt.add(lblSearchAcc, BorderLayout.EAST);
		lblSearchAcc.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(Manager.class.getResource("../images/search.png"))));
        lblSearchAcc.setCursor(new Cursor(Cursor.HAND_CURSOR));

        panel = new JPanel();
        panel.setPreferredSize(new Dimension(10, 20));
        pnlSearchAcc.add(panel, BorderLayout.NORTH);

        panel_1 = new JPanel();
        panel_1.setPreferredSize(new Dimension(10, 20));
        pnlSearchAcc.add(panel_1, BorderLayout.SOUTH);

        panel_2 = new JPanel();
        panel_2.setPreferredSize(new Dimension(250, 10));
        pnlSearchAcc.add(panel_2, BorderLayout.EAST);

        panel_6 = new JPanel();
        panel_6.setPreferredSize(new Dimension(250, 10));
        pnlSearchAcc.add(panel_6, BorderLayout.WEST);

        pnlContentAccDetail = new JPanel();
        add(pnlContentAccDetail, BorderLayout.CENTER);
        pnlContentAccDetail.setLayout(new BorderLayout(0, 0));

        pnlEdit_ListAcc = new JPanel();
        pnlContentAccDetail.add(pnlEdit_ListAcc, BorderLayout.CENTER);
        pnlEdit_ListAcc.setLayout(new BorderLayout(0, 0));

        pnlbtnEdit_ListAcc = new JPanel();
        pnlbtnEdit_ListAcc.setPreferredSize(new Dimension(10, 50));
        pnlEdit_ListAcc.add(pnlbtnEdit_ListAcc, BorderLayout.NORTH);
        pnlbtnEdit_ListAcc.setLayout(new BoxLayout(pnlbtnEdit_ListAcc, BoxLayout.X_AXIS));

        btnEditAcc = new JButton("Edit Account");
        btnEditAcc.setContentAreaFilled(false);
        btnEditAcc.setFocusPainted(false);
        btnEditAcc.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        pnlbtnEdit_ListAcc.add(btnEditAcc);
        btnEditAcc.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayoutEdit_ListAccDetail.show(pnlEdit_ListAccDetail,"pnlEditAcc");
            }
        });

        btnListAcc = new JButton("List Acccount");
        btnListAcc.setContentAreaFilled(false);
        btnListAcc.setFocusPainted(false);
        btnListAcc.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        pnlbtnEdit_ListAcc.add(btnListAcc);
        btnListAcc.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayoutEdit_ListAccDetail.show(pnlEdit_ListAccDetail,"pnlListAcc");
            }
        });

        pnlEdit_ListAccDetail = new JPanel();
        pnlEdit_ListAcc.add(pnlEdit_ListAccDetail, BorderLayout.CENTER);
        pnlEdit_ListAccDetail.setLayout(new CardLayout(0, 0));

        pnlEditAcc = new JPanel();
        pnlEdit_ListAccDetail.add(pnlEditAcc, "pnlEditAcc");
        pnlEditAcc.setLayout(new BorderLayout(0, 0));

        scrollFillInforAcc = new JScrollPane();
        scrollFillInforAcc.setBorder(new TitledBorder(null, "Edit Account", TitledBorder.LEADING, TitledBorder.TOP, null, null));
        pnlEditAcc.add(scrollFillInforAcc, BorderLayout.CENTER);

        pnlFillAcc = new JPanel();
        pnlFillAcc.setBorder(null);
        scrollFillInforAcc.setViewportView(pnlFillAcc);
        pnlFillAcc.setLayout(new GridLayout(8, 1, 0, 0));

        pnlIdAcc = new JPanel();
        pnlIdAcc.setPreferredSize(new Dimension(320, 35));
        pnlFillAcc.add(pnlIdAcc);
        pnlIdAcc.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

        lblIdAcc = new JLabel("ID Account");
        lblIdAcc.setPreferredSize(new Dimension(125, 25));
        pnlIdAcc.add(lblIdAcc);

        txtIdAcc = new JTextField();
        txtIdAcc.setPreferredSize(new Dimension(100, 25));
        pnlIdAcc.add(txtIdAcc);
        txtIdAcc.setColumns(20);

        pnlUserNameAcc = new JPanel();
        pnlUserNameAcc.setPreferredSize(new Dimension(320, 35));
        pnlFillAcc.add(pnlUserNameAcc);
        pnlUserNameAcc.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

        lblUserNameAcc = new JLabel("User name");
        lblUserNameAcc.setPreferredSize(new Dimension(125, 25));
        pnlUserNameAcc.add(lblUserNameAcc);

        txtUserNameAcc = new JTextField();
        txtUserNameAcc.setPreferredSize(new Dimension(100, 25));
        txtUserNameAcc.setColumns(20);
        pnlUserNameAcc.add(txtUserNameAcc);

        pnlPassAcc = new JPanel();
        pnlPassAcc.setPreferredSize(new Dimension(320, 35));
        pnlFillAcc.add(pnlPassAcc);
        pnlPassAcc.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

        lblPassAcc = new JLabel("Password");
        lblPassAcc.setPreferredSize(new Dimension(125, 25));
        pnlPassAcc.add(lblPassAcc);

        txtPassAcc = new JTextField();
        txtPassAcc.setPreferredSize(new Dimension(100, 25));
        txtPassAcc.setColumns(20);
        pnlPassAcc.add(txtPassAcc);

        pnlPermissionAcc = new JPanel();
        pnlPermissionAcc.setPreferredSize(new Dimension(320, 35));
        pnlFillAcc.add(pnlPermissionAcc);
        pnlPermissionAcc.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

        lblPermissionAcc = new JLabel("Permission");
        lblPermissionAcc.setPreferredSize(new Dimension(125, 25));
        pnlPermissionAcc.add(lblPermissionAcc);

        cbxPermissionAcc = new JComboBox();
        cbxPermissionAcc.setPreferredSize(new Dimension(225, 25));
        cbxPermissionAcc.setFont(new Font("Times New Roman", Font.PLAIN, 12));
        cbxPermissionAcc.setModel(new DefaultComboBoxModel(new String[]{"Admin", "Customer management staff", "Tour management staff", "Accountant"}));
        pnlPermissionAcc.add(cbxPermissionAcc);

        pnlFullName = new JPanel();
        pnlFillAcc.add(pnlFullName);

        lblFullName = new JLabel("Employee name");
        lblFullName.setPreferredSize(new Dimension(125, 25));
        pnlFullName.add(lblFullName);

        txtEmpName = new JTextField();
        txtEmpName.setPreferredSize(new Dimension(100, 25));
        txtEmpName.setColumns(20);
        pnlFullName.add(txtEmpName);

        pnlEmpOld = new JPanel();
        pnlFillAcc.add(pnlEmpOld);

        lblEmpOld = new JLabel("Date of birth");
        lblEmpOld.setPreferredSize(new Dimension(125, 25));
        pnlEmpOld.add(lblEmpOld);

        OldEmp = new JDateChooser();
        OldEmp.setPreferredSize(new Dimension(225, 25));
        pnlEmpOld.add(OldEmp);

        pnlEmpGender = new JPanel();
        pnlFillAcc.add(pnlEmpGender);
        pnlEmpGender.setLayout(new FlowLayout(FlowLayout.CENTER, 85, 5));

        lblEmpGender = new JLabel("Gender");
        lblEmpGender.setPreferredSize(new Dimension(43, 25));
        pnlEmpGender.add(lblEmpGender);

        bgGenderEmp = new ButtonGroup();
        rdbtnMaleEmp = new JRadioButton("Male");
        rdbtnMaleEmp.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        rdbtnMaleEmp.setFont(new Font("Times New Roman", Font.PLAIN, 12));
        rdbtnMaleEmp.setFocusPainted(false);
        rdbtnMaleEmp.setPreferredSize(new Dimension(72, 25));
        pnlEmpGender.add(rdbtnMaleEmp);
        bgGenderEmp.add(rdbtnMaleEmp);

        rdbtnFemaleEmp = new JRadioButton("Female");
        rdbtnFemaleEmp.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        rdbtnFemaleEmp.setFont(new Font("Times New Roman", Font.PLAIN, 12));
        rdbtnFemaleEmp.setFocusPainted(false);
        rdbtnFemaleEmp.setPreferredSize(new Dimension(73, 25));
        pnlEmpGender.add(rdbtnFemaleEmp);
        bgGenderEmp.add(rdbtnFemaleEmp);

        pnlEmpTel = new JPanel();
        pnlFillAcc.add(pnlEmpTel);

        lblEmpTel = new JLabel("Phone number");
        lblEmpTel.setPreferredSize(new Dimension(125, 25));
        pnlEmpTel.add(lblEmpTel);

        txtEmpTel = new JTextField();
        txtEmpTel.setPreferredSize(new Dimension(100, 25));
        txtEmpTel.setColumns(20);
        pnlEmpTel.add(txtEmpTel);

        pnlButtonAcc = new JPanel();
        pnlButtonAcc.setPreferredSize(new Dimension(10, 40));
        pnlEditAcc.add(pnlButtonAcc, BorderLayout.SOUTH);
        pnlButtonAcc.setLayout(new FlowLayout(FlowLayout.CENTER, 40, 10));

        btnAddAcc = new JButton("Add");
        btnAddAcc.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        btnAddAcc.setFocusPainted(false);
        btnAddAcc.setBackground(new Color(66, 165, 243));
        btnAddAcc.setPreferredSize(new Dimension(100, 25));
        pnlButtonAcc.add(btnAddAcc);

        btnUpdateAcc = new JButton("Update");
        btnUpdateAcc.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        btnUpdateAcc.setFocusPainted(false);
        btnUpdateAcc.setBackground(new Color(66, 165, 243));
        btnUpdateAcc.setPreferredSize(new Dimension(100, 25));
        pnlButtonAcc.add(btnUpdateAcc);

        btnDeleteAcc = new JButton("Delete");
        btnDeleteAcc.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        btnDeleteAcc.setFocusPainted(false);
        btnDeleteAcc.setBackground(new Color(66, 165, 243));
        btnDeleteAcc.setPreferredSize(new Dimension(100, 25));
        pnlButtonAcc.add(btnDeleteAcc);

        btnRefreshAcc = new JButton("Refresh");
        btnRefreshAcc.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        btnRefreshAcc.setFocusPainted(false);
        btnRefreshAcc.setBackground(new Color(66, 165, 243));
        btnRefreshAcc.setPreferredSize(new Dimension(100, 25));
        pnlButtonAcc.add(btnRefreshAcc);

        pnlListAcc = new JPanel();
        pnlListAcc.setBorder(new TitledBorder(null, "List Account", TitledBorder.LEADING, TitledBorder.TOP, null, null));
        pnlListAcc.setBackground(new Color(240, 240, 240));
        pnlEdit_ListAccDetail.add(pnlListAcc, "pnlListAcc");
        pnlListAcc.setLayout(new BorderLayout(0, 0));

        sclListAcc = new JScrollPane();
        pnlListAcc.add(sclListAcc, BorderLayout.CENTER);


        accListTable = new JTable();
        sclListAcc.setViewportView(accListTable);

        panel_3 = new JPanel();
        panel_3.setPreferredSize(new Dimension(50, 10));
        pnlContentAccDetail.add(panel_3, BorderLayout.EAST);

        panel_4 = new JPanel();
        panel_4.setPreferredSize(new Dimension(50, 10));
        pnlContentAccDetail.add(panel_4, BorderLayout.WEST);

        panel_5 = new JPanel();
        panel_5.setPreferredSize(new Dimension(10, 60));
        pnlContentAccDetail.add(panel_5, BorderLayout.SOUTH);

        // change form
        cardLayoutEdit_ListAccDetail = (CardLayout) (pnlEdit_ListAccDetail.getLayout());
    }

    private void loadAccData() {
        // load account table
    	 model_acc = new DefaultTableModel();
         model_acc.addColumn("Id");
         model_acc.addColumn("User_name");
         model_acc.addColumn("Password");
         model_acc.addColumn("Fullname");
         model_acc.addColumn("Tel");
         model_acc.addColumn("Birthday");
         model_acc.addColumn("Gender");
         model_acc.addColumn("Role");
        UserBUS ubs = new UserBUS();
        ArrayList<UserDTO> users = ubs.getAll();
        String new_id = String.valueOf(users.get(users.size()-1).getUser_id()+1);
        txtIdAcc.setText(new_id);
        for (UserDTO user : users) {
            model_acc.addRow(new Object[] {
                    user.getUser_id(),
                    user.getUser_name(),
                    user.getPassword(),
                    user.getFullname(),
                    user.getTel(),
                    user.getBirthday(),
                    user.getGender(),
                    user.getRole_id()

            });
        }
        accListTable.setModel(model_acc);

        // load combobox Role
        DefaultComboBoxModel<String> model_role = new DefaultComboBoxModel<String>();
        RoleBUS rbs = new RoleBUS();
        ArrayList<RoleDTO> roles = rbs.getAll();
        for (RoleDTO role : roles) {
            model_role.addElement(role.getRole_id()+"-"+role.getRole_name());
        }
        cbxPermissionAcc.setModel(model_role);
    }

    private void btnInteract() {
        accListTable.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int row = accListTable.getSelectedRow();
                // load form acc
                txtIdAcc.setText(accListTable.getValueAt(row,0).toString());
                txtUserNameAcc.setText(accListTable.getValueAt(row,1).toString());
                txtPassAcc.setText(accListTable.getValueAt(row,2).toString());
                RoleBUS rbs = new RoleBUS();
                RoleDTO rdo = rbs.getById(Integer.parseInt(accListTable.getValueAt(row,7).toString()) );
                cbxPermissionAcc.setSelectedItem(rdo.getRole_id()+"-"+rdo.getRole_name());
                txtEmpName.setText(accListTable.getValueAt(row,3).toString());
                String date = accListTable.getValueAt(row,5).toString();
                try {
                    OldEmp.setDate(new SimpleDateFormat("yyyy-MM-dd").parse(date));
                } catch (ParseException ex) {
                    throw new RuntimeException(ex);
                }
                if (Objects.equals(accListTable.getValueAt(row, 6).toString(), "nam")){
                    rdbtnMaleEmp.setSelected(true);
                }
                else rdbtnFemaleEmp.setSelected(true);

                txtEmpTel.setText(accListTable.getValueAt(row,4).toString());
            }
        });

        btnAddAcc.addActionListener(e -> {
            if ( txtUserNameAcc.getText() == "" || txtPassAcc.getText() == ""
            || txtEmpName.getText() == "" || (!rdbtnFemaleEmp.isSelected() && !rdbtnMaleEmp.isSelected())
            || txtEmpTel.getText() == "" || OldEmp.getDate() == null){
                JOptionPane.showMessageDialog(null,"Dữ liệu không được để trống!!");
                return;
            }
            if ( Objects.equals(txtIdAcc.getText(), "") || !isNumeric(txtIdAcc.getText())) {
                JOptionPane.showMessageDialog(null,"Id không được để trống và phải là số!!");
                return;
            }

            if (!isNumeric(txtEmpTel.getText()) || txtEmpTel.getText().length() != 10) {
                JOptionPane.showMessageDialog(null,"Số điện thoại phải là số và 10 chữ số!!");
                return;
            }

            UserDTO udo = new UserDTO();
            udo.setUser_id(Integer.parseInt(txtIdAcc.getText()));
            udo.setUser_name(txtUserNameAcc.getText());
            udo.setPassword(txtPassAcc.getText());
            udo.setFullname(txtEmpName.getText());
            udo.setTel(txtEmpTel.getText());
            udo.setBirthday(sdf.format(OldEmp.getDate()));
            udo.setRole_id(Integer.parseInt(Objects.requireNonNull(cbxPermissionAcc.getSelectedItem()).toString().split("-")[0]) );
            if (rdbtnMaleEmp.isSelected()) {
                udo.setGender("nam");
            }
            else udo.setGender("nữ");

            UserBUS ubs = new UserBUS();
            JOptionPane.showMessageDialog(null,ubs.add(udo));
            loadAccData();
        });

        btnUpdateAcc.addActionListener(e -> {
            if ( txtUserNameAcc.getText() == "" || txtPassAcc.getText() == ""
                    || txtEmpName.getText() == "" || (!rdbtnFemaleEmp.isSelected() && !rdbtnMaleEmp.isSelected())
                    || txtEmpTel.getText() == "" || OldEmp.getDate() == null){
                JOptionPane.showMessageDialog(null,"Dữ liệu không được để trống!!");
                return;
            }
            if ( Objects.equals(txtIdAcc.getText(), "") || !isNumeric(txtIdAcc.getText())) {
                JOptionPane.showMessageDialog(null,"Id không được để trống và phải là số!!");
                return;
            }

            if (!isNumeric(txtEmpTel.getText()) || txtEmpTel.getText().length() != 10) {
                JOptionPane.showMessageDialog(null,"Số điện thoại phải là số và 10 chữ số!!");
                return;
            }

            UserDTO udo = new UserDTO();
            udo.setUser_id(Integer.parseInt(txtIdAcc.getText()));
            udo.setUser_name(txtUserNameAcc.getText());
            udo.setPassword(txtPassAcc.getText());
            udo.setFullname(txtEmpName.getText());
            udo.setTel(txtEmpTel.getText());
            udo.setBirthday(sdf.format(OldEmp.getDate()));
            udo.setRole_id(Integer.parseInt(Objects.requireNonNull(cbxPermissionAcc.getSelectedItem()).toString().split("-")[0]) );
            if (rdbtnMaleEmp.isSelected()) {
                udo.setGender("nam");
            }
            else udo.setGender("nữ");

            UserBUS ubs = new UserBUS();
            JOptionPane.showMessageDialog(null,ubs.update(udo));
            loadAccData();
        });

        btnDeleteAcc.addActionListener(e -> {
            if (Objects.equals(txtIdAcc.getText(), "") || !isNumeric(txtIdAcc.getText())){
                JOptionPane.showMessageDialog(null,"Id không được để trống và phải là số!!");
                return;
            }

            UserBUS ubs = new UserBUS();
            JOptionPane.showMessageDialog(null,ubs.delete(Integer.parseInt(txtIdAcc.getText())));
            loadAccData();
        });

        btnRefreshAcc.addActionListener(e -> {
            while (model_acc.getRowCount() >= 1){
                model_acc.removeRow(0);
            }
            accListTable.setModel(model_acc);
            loadAccData();
            txtUserNameAcc.setText("");
            txtPassAcc.setText("");
            txtEmpName.setText("");
            OldEmp.setDate(null);
            rdbtnMaleEmp.setSelected(false);
            rdbtnFemaleEmp.setSelected(false);
            txtEmpTel.setText("");
        });

        lblSearchAcc.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent me) {
                if (Objects.equals(txtSearchAcc.getText(), "")) {
                    JOptionPane.showMessageDialog(null,"Ô tìm kiếm đang trống!!");
                    return;
                }
                String shString = txtSearchAcc.getText().trim();
                UserBUS ubs = new UserBUS();
                if(isNumeric(shString)) {
                    UserDTO user = ubs.getById(Integer.parseInt(shString.trim()));
                    if(user != null) {
                    	 model_acc = new DefaultTableModel();
                         model_acc.addColumn("Id");
                         model_acc.addColumn("User_name");
                         model_acc.addColumn("Password");
                         model_acc.addColumn("Fullname");
                         model_acc.addColumn("Tel");
                         model_acc.addColumn("Birthday");
                         model_acc.addColumn("Gender");
                         model_acc.addColumn("Role");
                
                            model_acc.addRow(new Object[] {
                                    user.getUser_id(),
                                    user.getUser_name(),
                                    user.getPassword(),
                                    user.getFullname(),
                                    user.getTel(),
                                    user.getBirthday(),
                                    user.getGender(),
                                    user.getRole_id()

                            });
                        
                        accListTable.setModel(model_acc);
                    }
                    if(user ==null) {
                        JOptionPane.showMessageDialog(null, "Không tìm thấy thông tin Account !");
                    }
                }
                if (!isNumeric(shString)) {
                    ArrayList<UserDTO> users = ubs.getAll();
                    boolean checkKQ = false;
                    model_acc = new DefaultTableModel();
                    model_acc.addColumn("Id");
                    model_acc.addColumn("User_name");
                    model_acc.addColumn("Password");
                    model_acc.addColumn("Fullname");
                    model_acc.addColumn("Tel");
                    model_acc.addColumn("Birthday");
                    model_acc.addColumn("Gender");
                    model_acc.addColumn("Role");
                    for(UserDTO user : users) {
                        String temp = Normalizer.normalize(user.getUser_name(), Normalizer.Form.NFD);
                        String temp1 = Normalizer.normalize(user.getFullname(), Normalizer.Form.NFD);
                        String temp2 = Normalizer.normalize(shString, Normalizer.Form.NFD);
                        Pattern pattern = Pattern.compile("\\p{InCombiningDiacriticalMarks}+");
                        boolean check =pattern.matcher(temp).replaceAll("").equalsIgnoreCase(pattern.matcher(temp2).replaceAll(""));
                        boolean check1 =pattern.matcher(temp1).replaceAll("").equalsIgnoreCase(pattern.matcher(temp2).replaceAll(""));
                        if(check || check1) {
                        	model_acc.addRow(new Object[] {
                                    user.getUser_id(),
                                    user.getUser_name(),
                                    user.getPassword(),
                                    user.getFullname(),
                                    user.getTel(),
                                    user.getBirthday(),
                                    user.getGender(),
                                    user.getRole_id()

                            });
                            checkKQ = true;
                            break;
                        }
                    }
                    accListTable.setModel(model_acc);
                    if(!checkKQ) {
                        JOptionPane.showMessageDialog(null, "Không tìm thấy thông tin Account !");
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
