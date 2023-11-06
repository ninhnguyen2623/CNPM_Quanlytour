package GUI;

import DAO.HotelDAO;
import DTO.HotelDTO;


import javax.swing.*;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import BUS.HotelBUS;

import java.awt.*;
import java.awt.event.*;
import java.text.Normalizer;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class HotelContent extends JPanel {
    private JPanel pnlHotelContent;
    private JPanel pnlHotelContentTitle;
    private JLabel lblHotelContentTitle;
    private JPanel pnlSearchHotel;
    private JLabel lblSearchHotel;
    private JPanel pnlContentHotelDetail;
    private JPanel pnlEdit_ListHotel;
    private JPanel pnlbtnEdit_ListHotel;
    private JPanel pnlEditHotel;
    private JScrollPane scrollFillInforHotel;
    private JPanel pnlFillHotel;
    private JPanel pnlIdHotel;
    private JLabel lblIdHotel;
    private JTextField txtIdHotel;
    private JPanel pnlNameHotel;
    private JLabel lblNameHotel;
    private JTextField txtNameHotel;
    private JPanel pnlButtonHotel;
    private JButton btnAddHotel;
    private JButton btnDeleteHotel;
    private JPanel pnlListHotel;
    private JPanel pnlStartHotel;
    private JLabel lblStartHotel;
    private JPanel pnlPhoneHotel;
    private JLabel lblPhoneHotel;
    private JTextField txtPhoneHotel;
    private JPanel pnlWebHotel;
    private JLabel lblWebHotel;
    private JTextField txtWebHotel;
    private JPanel pnlAddressHotel;
    private JLabel lblAddressHotel;
    private JTextField txtAddressHotel;
    private JButton btnRefreshHotel;
    private JComboBox cbxStartHotel;
    private JTable hotelListTable;

    private JScrollPane sclListHotel;
    private JPanel panel;
    private JPanel panel_1;
    private JPanel panel_2;
    private JPanel panel_6;
    private JPanel panel_3;
    private JPanel panel_4;
    private JPanel panel_5;
    private JPanel pnlIconSrc_Txt;
    private JTextField txtSearchHotel;
    private JButton btnEditHotel;
    private JButton btnListHotel;
    private JPanel pnlEdit_ListHotelDetail;
    private CardLayout cardLayoutEdit_ListHotelDetail;
    public HotelContent() {
        init();
    }

    private void init() {

        setLayout(new BorderLayout(0, 0));

        pnlHotelContentTitle = new JPanel();
        pnlHotelContentTitle.setPreferredSize(new Dimension(10, 125));
        add(pnlHotelContentTitle, BorderLayout.NORTH);
        pnlHotelContentTitle.setLayout(new BorderLayout(0, 0));

        lblHotelContentTitle = new JLabel("Hotel Manager");
        lblHotelContentTitle.setPreferredSize(new Dimension(200, 50));
        lblHotelContentTitle.setHorizontalAlignment(SwingConstants.CENTER);
        lblHotelContentTitle.setFont(new Font("Times New Roman", Font.PLAIN, 24));
        pnlHotelContentTitle.add(lblHotelContentTitle, BorderLayout.NORTH);

        pnlSearchHotel = new JPanel();
        pnlSearchHotel.setPreferredSize(new Dimension(10, 60));
        pnlHotelContentTitle.add(pnlSearchHotel, BorderLayout.CENTER);
        pnlSearchHotel.setLayout(new BorderLayout(0, 0));

        pnlIconSrc_Txt = new JPanel();
        pnlSearchHotel.add(pnlIconSrc_Txt, BorderLayout.CENTER);
        pnlIconSrc_Txt.setLayout(new BorderLayout(0, 0));

        txtSearchHotel = new JTextField();
        txtSearchHotel.setText("Search Hotel");
        pnlIconSrc_Txt.add(txtSearchHotel, BorderLayout.CENTER);
        txtSearchHotel.setMargin(new Insets(2, 10, 2, 10));
        txtSearchHotel.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                txtSearchHotel.setText(null);
                txtSearchHotel.requestFocus();;
                Font font = txtSearchHotel.getFont();
                font = font.deriveFont(Font.PLAIN|Font.BOLD);
                txtSearchHotel.setFont(font);
                txtSearchHotel.setForeground(Color.black);
            }

            @Override
            public void focusLost(FocusEvent e) {
                Font font = txtSearchHotel.getFont();
                font = font.deriveFont(Font.ITALIC);
                txtSearchHotel.setFont(font);
                txtSearchHotel.setForeground(Color.gray);
                txtSearchHotel.setText("Search Hotel");
            }
        });


        //		tìm kiem nang cao ------------------------------------------------------------------------------------------------------------------------------------------
        lblSearchHotel = new JLabel("");
        lblSearchHotel.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent me) {
                String shString = txtSearchHotel.getText().trim();
                if(isNumeric(shString)== true) {
                    int idhotel = Integer.parseInt(shString.trim());
                    HotelBUS hotelBUS = new HotelBUS();
                    HotelDTO hotelDTO = hotelBUS.getById(idhotel);
                    if(hotelDTO != null) {
                        String idhotelString = String.valueOf(hotelDTO.getHotel_id());
                        txtIdHotel.setText(idhotelString);
                        txtNameHotel.setText(hotelDTO.getHotel_name());
                        txtAddressHotel.setText(hotelDTO.getAddress());
                        String telhotelString = String.valueOf(hotelDTO.getTel());
                        txtPhoneHotel.setText(telhotelString);
                        txtWebHotel.setText(hotelDTO.getWebsite());
                        cbxStartHotel.setSelectedItem(hotelDTO.getStar());
                    }
                    if(hotelDTO ==null) {
                        JOptionPane.showMessageDialog(null, "Không tìm thấy thông tin Hotel !");
                    }
                }
                if (isNumeric(shString)== false) {
//                    ArrayList<HotelDTO> arrhHotelDTOs = HotelDAO.getInstance().getAll();
                	HotelBUS hotelBUS = new HotelBUS();
                	ArrayList<HotelDTO> arrhHotelDTOs = hotelBUS.getAll();
                    Boolean checkKQ = false;
                    for(HotelDTO jjjHotelDTO: arrhHotelDTOs) {
                        String temp = Normalizer.normalize(jjjHotelDTO.getHotel_name(), Normalizer.Form.NFD);
                        String temp2 = Normalizer.normalize(shString, Normalizer.Form.NFD);
                        Pattern pattern = Pattern.compile("\\p{InCombiningDiacriticalMarks}+");
                        if(pattern.matcher(temp).replaceAll("").equalsIgnoreCase(pattern.matcher(temp2).replaceAll(""))) {
                            String idhotelString = String.valueOf(jjjHotelDTO.getHotel_id());
                            txtIdHotel.setText(idhotelString);
                            txtNameHotel.setText(jjjHotelDTO.getHotel_name());
                            txtAddressHotel.setText(jjjHotelDTO.getAddress());
                            String telhotelString = String.valueOf(jjjHotelDTO.getTel());
                            txtPhoneHotel.setText(telhotelString);
                            txtWebHotel.setText(jjjHotelDTO.getWebsite());
                            cbxStartHotel.setSelectedItem(jjjHotelDTO.getStar());
                            checkKQ = true;
                        }
                    }
                    if(checkKQ == false) {
                        JOptionPane.showMessageDialog(null, "Không tìm thấy thông tin Hotel !");
                    }
                }
            }

        });
//	end serach ----------------------------------------------------------------------------------------------------------------------------------

        lblSearchHotel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
        pnlIconSrc_Txt.add(lblSearchHotel, BorderLayout.EAST);
		lblSearchHotel.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(Manager.class.getResource("../images/search.png"))));
        lblSearchHotel.setCursor(new Cursor(Cursor.HAND_CURSOR));

        panel = new JPanel();
        panel.setPreferredSize(new Dimension(10, 20));
        pnlSearchHotel.add(panel, BorderLayout.NORTH);

        panel_1 = new JPanel();
        panel_1.setPreferredSize(new Dimension(10, 20));
        pnlSearchHotel.add(panel_1, BorderLayout.SOUTH);

        panel_2 = new JPanel();
        panel_2.setPreferredSize(new Dimension(250, 10));
        pnlSearchHotel.add(panel_2, BorderLayout.EAST);

        panel_6 = new JPanel();
        panel_6.setPreferredSize(new Dimension(250, 10));
        pnlSearchHotel.add(panel_6, BorderLayout.WEST);

        pnlContentHotelDetail = new JPanel();
        add(pnlContentHotelDetail, BorderLayout.CENTER);
        pnlContentHotelDetail.setLayout(new BorderLayout(0, 0));

        pnlEdit_ListHotel = new JPanel();
        pnlContentHotelDetail.add(pnlEdit_ListHotel, BorderLayout.CENTER);
        pnlEdit_ListHotel.setLayout(new BorderLayout(0, 0));

        pnlbtnEdit_ListHotel = new JPanel();
        pnlbtnEdit_ListHotel.setPreferredSize(new Dimension(10, 50));
        pnlEdit_ListHotel.add(pnlbtnEdit_ListHotel, BorderLayout.NORTH);
        pnlbtnEdit_ListHotel.setLayout(new BoxLayout(pnlbtnEdit_ListHotel, BoxLayout.X_AXIS));

        btnEditHotel = new JButton("Edit Hotel");
        btnEditHotel.setContentAreaFilled(false);
        btnEditHotel.setFocusPainted(false);
        btnEditHotel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        pnlbtnEdit_ListHotel.add(btnEditHotel);
        btnEditHotel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayoutEdit_ListHotelDetail.show(pnlEdit_ListHotelDetail,"pnlEditHotel");
            }
        });

        btnListHotel = new JButton("List Hotel");
        btnListHotel.setContentAreaFilled(false);
        btnListHotel.setFocusPainted(false);
        btnListHotel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        pnlbtnEdit_ListHotel.add(btnListHotel);
        btnListHotel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayoutEdit_ListHotelDetail.show(pnlEdit_ListHotelDetail,"pnlListHotel");
            }
        });

        pnlEdit_ListHotelDetail = new JPanel();
        pnlEdit_ListHotel.add(pnlEdit_ListHotelDetail, BorderLayout.CENTER);
        pnlEdit_ListHotelDetail.setLayout(new CardLayout(0, 0));

        pnlEditHotel = new JPanel();
        pnlEdit_ListHotelDetail.add(pnlEditHotel, "pnlEditHotel");
        pnlEditHotel.setLayout(new BorderLayout(0, 0));

        scrollFillInforHotel = new JScrollPane();
        scrollFillInforHotel.setBorder(new TitledBorder(null, "Edit Hotel", TitledBorder.LEADING, TitledBorder.TOP, null, null));
        pnlEditHotel.add(scrollFillInforHotel, BorderLayout.CENTER);

        pnlFillHotel = new JPanel();
        pnlFillHotel.setBorder(null);
        scrollFillInforHotel.setViewportView(pnlFillHotel);
        pnlFillHotel.setLayout(new GridLayout(7, 1, 0, 0));

        pnlIdHotel = new JPanel();
        pnlIdHotel.setPreferredSize(new Dimension(320, 35));
        pnlFillHotel.add(pnlIdHotel);
        pnlIdHotel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

        lblIdHotel = new JLabel("ID");
        lblIdHotel.setPreferredSize(new Dimension(125, 25));
        pnlIdHotel.add(lblIdHotel);

        txtIdHotel = new JTextField();
        txtIdHotel.setPreferredSize(new Dimension(100, 25));
        pnlIdHotel.add(txtIdHotel);
        txtIdHotel.setColumns(20);

        pnlNameHotel = new JPanel();
        pnlNameHotel.setPreferredSize(new Dimension(320, 35));
        pnlFillHotel.add(pnlNameHotel);
        pnlNameHotel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

        lblNameHotel = new JLabel("Name");
        lblNameHotel.setPreferredSize(new Dimension(125, 25));
        pnlNameHotel.add(lblNameHotel);

        txtNameHotel = new JTextField();
        txtNameHotel.setPreferredSize(new Dimension(100, 25));
        txtNameHotel.setColumns(20);
        pnlNameHotel.add(txtNameHotel);

        pnlPhoneHotel= new JPanel();
        pnlPhoneHotel.setPreferredSize(new Dimension(320, 35));
        pnlFillHotel.add(pnlPhoneHotel);
        pnlPhoneHotel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

        lblPhoneHotel = new JLabel("Phone");
        lblPhoneHotel.setPreferredSize(new Dimension(125, 25));
        pnlPhoneHotel.add(lblPhoneHotel);

        txtPhoneHotel = new JTextField();
        txtPhoneHotel.setPreferredSize(new Dimension(100, 25));
        txtPhoneHotel.setColumns(20);
        pnlPhoneHotel.add(txtPhoneHotel);

        pnlAddressHotel = new JPanel();
        pnlAddressHotel.setPreferredSize(new Dimension(320, 35));
        pnlFillHotel.add(pnlAddressHotel);
        pnlAddressHotel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

        lblAddressHotel = new JLabel("Address");
        lblAddressHotel.setPreferredSize(new Dimension(125, 25));
        pnlAddressHotel.add(lblAddressHotel);

        txtAddressHotel = new JTextField();
        txtAddressHotel.setPreferredSize(new Dimension(100, 25));
        txtAddressHotel.setColumns(20);
        pnlAddressHotel.add(txtAddressHotel);

        pnlWebHotel = new JPanel();
        pnlWebHotel.setPreferredSize(new Dimension(320, 35));
        pnlFillHotel.add(pnlWebHotel);
        pnlWebHotel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

        lblWebHotel = new JLabel("Website");
        lblWebHotel.setPreferredSize(new Dimension(125, 25));
        pnlWebHotel.add(lblWebHotel);

        txtWebHotel = new JTextField();
        txtWebHotel.setPreferredSize(new Dimension(100, 25));
        txtWebHotel.setColumns(20);
        pnlWebHotel.add(txtWebHotel);

        pnlStartHotel = new JPanel();
        pnlStartHotel.setPreferredSize(new Dimension(320, 35));
        pnlFillHotel.add(pnlStartHotel);
        pnlStartHotel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

        lblStartHotel = new JLabel("Start");
        lblStartHotel.setPreferredSize(new Dimension(125, 25));
        pnlStartHotel.add(lblStartHotel);

        cbxStartHotel = new JComboBox();
        cbxStartHotel.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5"}));
        cbxStartHotel.setPreferredSize(new Dimension(225, 25));
        pnlStartHotel.add(cbxStartHotel);

        pnlButtonHotel = new JPanel();
        pnlButtonHotel.setPreferredSize(new Dimension(10, 40));
        pnlEditHotel.add(pnlButtonHotel, BorderLayout.SOUTH);
        pnlButtonHotel.setLayout(new FlowLayout(FlowLayout.CENTER, 40, 10));

        btnAddHotel = new JButton("Add");
        btnAddHotel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String idString = txtIdHotel.getText().trim();
                int idhotel = 0;
                if(isNumeric(idString)==false) {
                	JOptionPane.showMessageDialog(null, "ID phải là số !");
                }
                if(isNumeric(idString)==true) {
                    idhotel = Integer.parseInt(idString.trim());
                }
                String nameString = txtNameHotel.getText();
                String addressString = txtAddressHotel.getText();
                String telhotel = txtPhoneHotel.getText().trim();

                String webString = txtWebHotel.getText();
                String cbxString =(String) cbxStartHotel.getSelectedItem();
                int starhotel = Integer.parseInt(cbxString);
                if(idString == "" || nameString==""|| addressString==""|| telhotel==""|| webString=="") {
                    JOptionPane.showMessageDialog(null, "Bạn chưa nhập đủ thông tin !");
                }
                if(checkPhone(telhotel)== false) {
                	JOptionPane.showMessageDialog(null, "Số điện thoại không đúng !");
                }
                if(isURL(webString)== false) {
                	JOptionPane.showMessageDialog(null, "Đường dẫn website không đúng !");
                }
                else {
                    HotelDTO hotelDTO = new HotelDTO(idhotel,nameString,addressString,telhotel,webString,starhotel);
                    int result = JOptionPane.showConfirmDialog(null,
                            "Bạn có muốn them hotel  " +nameString,
                            "Xác nhận",
                            JOptionPane.YES_NO_OPTION,
                            JOptionPane.QUESTION_MESSAGE);
                    if(result == JOptionPane.YES_OPTION){
//                        HotelDAO.getInstance().add(hotelDTO);
                    	HotelBUS hotelBUS = new HotelBUS();
                    	hotelBUS.add(hotelDTO);
                        ClassLoaddataHotel();
                    }
//	                JOptionPane.showMessageDialog(null, "dsfasfasfasfasfas");
                    RefreshHotel();
                }
            }
        });
        btnAddHotel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        btnAddHotel.setFocusPainted(false);
        btnAddHotel.setBackground(new Color(66, 165, 243));
        btnAddHotel.setPreferredSize(new Dimension(100, 25));
        pnlButtonHotel.add(btnAddHotel);

        btnDeleteHotel = new JButton("Delete");
        btnDeleteHotel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String idString = txtIdHotel.getText().trim();
                int idhotel = Integer.parseInt(idString);
                int result = JOptionPane.showConfirmDialog(null,
                        "Bạn có chắc muốn xoa hotel id: " +idhotel,
                        "Xác nhận",
                        JOptionPane.YES_NO_OPTION,
                        JOptionPane.QUESTION_MESSAGE);
                if(result == JOptionPane.YES_OPTION){
//                    HotelDAO.getInstance().delete(idhotel);
                	HotelBUS hotelBUS = new HotelBUS();
                	hotelBUS.delete(idhotel);
                    ClassLoaddataHotel();
                }
                RefreshHotel();
            }
        });
        btnDeleteHotel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        btnDeleteHotel.setBackground(new Color(66, 165, 243));
        btnDeleteHotel.setFocusPainted(false);
        btnDeleteHotel.setPreferredSize(new Dimension(100, 25));
        pnlButtonHotel.add(btnDeleteHotel);

        btnAddHotel = new JButton("Update");
        btnAddHotel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	String idString = txtIdHotel.getText().trim();
                int idhotel = 0;
                if(isNumeric(idString)==false) {
                	JOptionPane.showMessageDialog(null, "ID phải là số !");
                }
                if(isNumeric(idString)==true) {
                    idhotel = Integer.parseInt(idString.trim());
                }
                String nameString = txtNameHotel.getText();
                String addressString = txtAddressHotel.getText();
                String telhotel = txtPhoneHotel.getText().trim();

                String webString = txtWebHotel.getText();
                String cbxString =(String) cbxStartHotel.getSelectedItem();
                int starhotel = Integer.parseInt(cbxString);
                if(idString == "" || nameString==""|| addressString==""|| telhotel==""|| webString=="") {
                	JOptionPane.showMessageDialog(null, "Bạn chưa nhập đủ thông tin !");
                }
                if(checkPhone(telhotel)== false) {
                	JOptionPane.showMessageDialog(null, "Số điện thoại không đúng !");
                }
                if(isURL(webString)== false) {
                	JOptionPane.showMessageDialog(null, "Đường dẫn website không đúng !");
                }
                else {
                    HotelDTO hotelDTO = new HotelDTO(idhotel,nameString,addressString,telhotel,webString,starhotel);
                    int result = JOptionPane.showConfirmDialog(null,
                            "Bạn có muốn update hotel  " +nameString,
                            "Xác nhận",
                            JOptionPane.YES_NO_OPTION,
                            JOptionPane.QUESTION_MESSAGE);
                    if(result == JOptionPane.YES_OPTION){
                    	HotelBUS hotelBUS = new HotelBUS();
                    	hotelBUS.update(hotelDTO);
                        ClassLoaddataHotel();
                    }
//	                JOptionPane.showMessageDialog(null, "dsfasfasfasfasfas");
                    RefreshHotel();
                }
            }
        });
        btnAddHotel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        btnAddHotel.setBackground(new Color(66, 165, 243));
        btnAddHotel.setFocusPainted(false);
        btnAddHotel.setPreferredSize(new Dimension(100, 25));
        pnlButtonHotel.add(btnAddHotel);

        btnRefreshHotel = new JButton("Refresh");
        btnRefreshHotel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                RefreshHotel();

            }
        });
        btnRefreshHotel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        btnRefreshHotel.setBackground(new Color(66, 165, 243));
        btnRefreshHotel.setFocusPainted(false);
        btnRefreshHotel.setPreferredSize(new Dimension(100, 25));
        pnlButtonHotel.add(btnRefreshHotel);

        pnlListHotel = new JPanel();
        pnlListHotel.setBorder(new TitledBorder(null, "List Hotel", TitledBorder.LEADING, TitledBorder.TOP, null, null));
        pnlListHotel.setBackground(new Color(240, 240, 240));
        pnlEdit_ListHotelDetail.add(pnlListHotel, "pnlListHotel");
        pnlListHotel.setLayout(new BorderLayout(0, 0));

        sclListHotel = new JScrollPane();
        pnlListHotel.add(sclListHotel, BorderLayout.CENTER);

        
        ClassLoaddataHotel();
        panel_4 = new JPanel();
        panel_4.setPreferredSize(new Dimension(50, 10));
        pnlContentHotelDetail.add(panel_4, BorderLayout.WEST);

        panel_5 = new JPanel();
        panel_5.setPreferredSize(new Dimension(10, 60));
        pnlContentHotelDetail.add(panel_5, BorderLayout.SOUTH);

        // change form
        cardLayoutEdit_ListHotelDetail = (CardLayout)(pnlEdit_ListHotelDetail.getLayout());
    }


    public void ClassLoaddataHotel() {
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("ID");;
        model.addColumn("Name");
        model.addColumn("Address");
        model.addColumn("Tell");
        model.addColumn("Website");
        model.addColumn("Star");
        HotelBUS hotelBUS = new HotelBUS();
        ArrayList<HotelDTO> htDTO = hotelBUS.getAll();
        for(HotelDTO itemHotel : htDTO) {
            model.addRow(new Object[] {
                    itemHotel.getHotel_id(),itemHotel.getHotel_name(),itemHotel.getAddress(),itemHotel.getTel(),itemHotel.getWebsite(),itemHotel.getStar()
            });
        }
        hotelListTable = new JTable();
        hotelListTable.setModel(model);
        sclListHotel.setViewportView(hotelListTable);
        panel_3 = new JPanel();
        panel_3.setPreferredSize(new Dimension(50, 10));
        pnlContentHotelDetail.add(panel_3, BorderLayout.EAST);
        getDataFromJtable();

    }
    public void RefreshHotel() {
        txtIdHotel.setText(" ");
        txtNameHotel.setText(" ");
        txtAddressHotel.setText(" ");
        txtPhoneHotel.setText(" ");
        txtWebHotel.setText(" ");
        txtSearchHotel.setText("");
    }
    public void getDataFromJtable() {
        List<HotelDTO> hotelDTO = new ArrayList<HotelDTO>();
        hotelListTable.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent me) {
                int i = hotelListTable.getSelectedRow();
                TableModel model = hotelListTable.getModel();
                int idhotel = Integer.parseInt(model.getValueAt(i,0).toString());
                String nameHotelString = model.getValueAt(i,1).toString();
                String addressHotelString = model.getValueAt(i,2).toString();
                String telhotel = model.getValueAt(i,3).toString();
                String webHotelString = model.getValueAt(i,4).toString();
                int starthotel = Integer.parseInt(model.getValueAt(i,5).toString());
//	        	add  table to txt
                String idhotelString = String.valueOf(idhotel);
                txtIdHotel.setText(idhotelString);
                txtNameHotel.setText(nameHotelString);
                txtAddressHotel.setText(addressHotelString);
                String telhotelString = String.valueOf(telhotel);
                txtPhoneHotel.setText(telhotelString);
                txtWebHotel.setText(webHotelString);
                cbxStartHotel.setSelectedItem(starthotel);
            }
        });

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
}
