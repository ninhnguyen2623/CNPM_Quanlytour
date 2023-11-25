package GUI;

import DAO.CustomerDAO;
import DAO.ServiceDAO;
import DTO.CustomerDTO;
import DTO.ServiceDTO;

import javax.swing.*;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import BUS.ServiceBUS;

import java.awt.*;
import java.awt.event.*;
import java.text.Normalizer;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.regex.Pattern;

public class SerContent extends JPanel {
    private JPanel pnlSerContentTitle;
    private JLabel lblSerContentTitle;
    private JPanel pnlSearchSer;
    private JLabel lblSearchSer;
    
    private JPanel pnlContentSerDetail;
    private JPanel pnlEdit_ListSer;
    private JPanel pnlbtnEdit_ListSer;
    private JPanel pnlEditSer;
    private JScrollPane scrollFillInforSer;
    private JPanel pnlFillSer;
    private JPanel pnlIdSer;
    private JLabel lblIdSer;
    private JTextField txtIdSer;
    private JPanel pnlNameSer;
    private JLabel lblNameSer;
    private JTextField txtNameSer;
    private JPanel pnlPriceSer;
    private JLabel lblPriceSer;
    private JTextField txtPriceSer;
    private JPanel pnlButtonSer;
    private JButton btnAddSer;
    private JButton btnDeleteSer;
    private JPanel pnlListSer;
    private JButton btnRefreshSer;
    private JPanel panel;
    private JPanel panel_1;
    private JPanel panel_2;
    private JPanel panel_6;
    private JPanel panel_3;
    private JPanel panel_4;
    private JPanel panel_5;
    private JPanel pnlIconSrc_Txt;
    private JTextField txtSearchSer;
    private JButton btnEditSer;
    private JButton btnListSer;
    private JPanel pnlEdit_ListSerDetail;
    private JScrollPane sclListSer;
    private JTable serListTable;
    private CardLayout cardLayoutEdit_ListSerDetail;
    private JButton btnUpdateSer;
    public SerContent() {
        init();
    }

    private void init() {
        setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        setLayout(new BorderLayout(0, 0));
        pnlSerContentTitle = new JPanel();
        pnlSerContentTitle.setPreferredSize(new Dimension(10, 125));
        add(pnlSerContentTitle, BorderLayout.NORTH);
        pnlSerContentTitle.setLayout(new BorderLayout(0, 0));

        lblSerContentTitle = new JLabel("Service Manager");
        lblSerContentTitle.setPreferredSize(new Dimension(200, 50));
        lblSerContentTitle.setHorizontalAlignment(SwingConstants.CENTER);
        lblSerContentTitle.setFont(new Font("Times New Roman", Font.PLAIN, 24));
        pnlSerContentTitle.add(lblSerContentTitle, BorderLayout.NORTH);

        pnlSearchSer = new JPanel();
        pnlSearchSer.setPreferredSize(new Dimension(10, 60));
        pnlSerContentTitle.add(pnlSearchSer, BorderLayout.CENTER);
        pnlSearchSer.setLayout(new BorderLayout(0, 0));

        pnlIconSrc_Txt = new JPanel();
        pnlSearchSer.add(pnlIconSrc_Txt, BorderLayout.CENTER);
        pnlIconSrc_Txt.setLayout(new BorderLayout(0, 0));

        txtSearchSer = new JTextField();
        txtSearchSer.setText("Search Service");
        pnlIconSrc_Txt.add(txtSearchSer, BorderLayout.CENTER);
        txtSearchSer.setMargin(new Insets(2, 10, 2, 10));
        txtSearchSer.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                txtSearchSer.setText(null);
                txtSearchSer.requestFocus();;
                Font font = txtSearchSer.getFont();
                font = font.deriveFont(Font.PLAIN|Font.BOLD);
                txtSearchSer.setFont(font);
                txtSearchSer.setForeground(Color.black);
            }

            @Override
            public void focusLost(FocusEvent e) {
                Font font = txtSearchSer.getFont();
                font = font.deriveFont(Font.ITALIC);
                txtSearchSer.setFont(font);
                txtSearchSer.setForeground(Color.gray);
                txtSearchSer.setText("Search Service");
            }
        });

        lblSearchSer = new JLabel("");
        lblSearchSer.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent me) {

                String serString = txtSearchSer.getText().trim();
                if(isNumeric(serString)== true) {
                    int idser = Integer.parseInt(serString.trim());
                    
                    ServiceBUS serviceBUS = new ServiceBUS(); 
                    ServiceDTO  itemService = serviceBUS.getById(idser);
                    if( itemService != null) {
                    	DefaultTableModel model = new DefaultTableModel();
                        model.addColumn("ID");;
                        model.addColumn("Name Service");
                        model.addColumn("Price");
           
                        
                            model.addRow(new Object[] {
                                    itemService.getService_id(),itemService.getService_name(),itemService.getService_price()
                            });
                       
                        serListTable = new JTable();
                        serListTable.setModel(model);
                        sclListSer.setViewportView(serListTable);
                        panel_3 = new JPanel();
                        panel_3.setPreferredSize(new Dimension(50, 10));
                        pnlContentSerDetail.add(panel_3, BorderLayout.EAST);
                        getDataFromJtableSer();
              
                    }
                    if( itemService == null) {
                        JOptionPane.showMessageDialog(null, "Không tìm thấy thông tin Service !");
                    }
                }
                if (isNumeric(serString)== false) {
                	ServiceBUS serviceBUS = new ServiceBUS(); 
                	
                    ArrayList<ServiceDTO> serDTO = serviceBUS.getAll();
                    Boolean checkKQ = false;
                    DefaultTableModel model = new DefaultTableModel();
                    model.addColumn("ID");;
                    model.addColumn("Name Service");
                    model.addColumn("Price");
                    for(ServiceDTO itemService: serDTO) {
                        String temp = Normalizer.normalize(itemService.getService_name(), Normalizer.Form.NFD);
                        String temp2 = Normalizer.normalize(serString, Normalizer.Form.NFD);
                        Pattern pattern = Pattern.compile("\\p{InCombiningDiacriticalMarks}+");
                        if(pattern.matcher(temp).replaceAll("").equalsIgnoreCase(pattern.matcher(temp2).replaceAll(""))) {
                        	 model.addRow(new Object[] {
                                     itemService.getService_id(),itemService.getService_name(),itemService.getService_price()
                             });
                            checkKQ = true;
                        }
                    }
                    serListTable = new JTable();
                    serListTable.setModel(model);
                    sclListSer.setViewportView(serListTable);
                    panel_3 = new JPanel();
                    panel_3.setPreferredSize(new Dimension(50, 10));
                    pnlContentSerDetail.add(panel_3, BorderLayout.EAST);
                    getDataFromJtableSer();
                    if(checkKQ == false) {
                        JOptionPane.showMessageDialog(null, "Không tìm thấy thông tin Service !");
                    }
                }
            }

        });
        lblSearchSer.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
        pnlIconSrc_Txt.add(lblSearchSer, BorderLayout.EAST);
		lblSearchSer.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(Manager.class.getResource("../images/search.png"))));
        lblSearchSer.setCursor(new Cursor(Cursor.HAND_CURSOR));

        panel = new JPanel();
        panel.setPreferredSize(new Dimension(10, 20));
        pnlSearchSer.add(panel, BorderLayout.NORTH);

        panel_1 = new JPanel();
        panel_1.setPreferredSize(new Dimension(10, 20));
        pnlSearchSer.add(panel_1, BorderLayout.SOUTH);

        panel_2 = new JPanel();
        panel_2.setPreferredSize(new Dimension(250, 10));
        pnlSearchSer.add(panel_2, BorderLayout.EAST);

        panel_6 = new JPanel();
        panel_6.setPreferredSize(new Dimension(250, 10));
        pnlSearchSer.add(panel_6, BorderLayout.WEST);

        pnlContentSerDetail = new JPanel();
        add(pnlContentSerDetail, BorderLayout.CENTER);
        pnlContentSerDetail.setLayout(new BorderLayout(0, 0));

        pnlEdit_ListSer = new JPanel();
        pnlContentSerDetail.add(pnlEdit_ListSer, BorderLayout.CENTER);
        pnlEdit_ListSer.setLayout(new BorderLayout(0, 0));

        pnlbtnEdit_ListSer = new JPanel();
        pnlbtnEdit_ListSer.setPreferredSize(new Dimension(10, 50));
        pnlEdit_ListSer.add(pnlbtnEdit_ListSer, BorderLayout.NORTH);
        pnlbtnEdit_ListSer.setLayout(new BoxLayout(pnlbtnEdit_ListSer, BoxLayout.X_AXIS));

        btnEditSer = new JButton("Edit Service");
        btnEditSer.setContentAreaFilled(false);
        btnEditSer.setFocusPainted(false);
        btnEditSer.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        pnlbtnEdit_ListSer.add(btnEditSer);
        btnEditSer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayoutEdit_ListSerDetail.show(pnlEdit_ListSerDetail,"pnlEditSer");
            }
        });

        btnListSer = new JButton("List Service");
        btnListSer.setContentAreaFilled(false);
        btnListSer.setFocusPainted(false);
        btnListSer.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        pnlbtnEdit_ListSer.add(btnListSer);
        btnListSer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayoutEdit_ListSerDetail.show(pnlEdit_ListSerDetail,"pnlListSer");
            }
        });

        pnlEdit_ListSerDetail = new JPanel();
        pnlEdit_ListSer.add(pnlEdit_ListSerDetail, BorderLayout.CENTER);
        pnlEdit_ListSerDetail.setLayout(new CardLayout(0, 0));

        pnlEditSer = new JPanel();
        pnlEdit_ListSerDetail.add(pnlEditSer, "pnlEditSer");
        pnlEditSer.setLayout(new BorderLayout(0, 0));

        scrollFillInforSer = new JScrollPane();
        scrollFillInforSer.setBorder(new TitledBorder(null, "Edit Service", TitledBorder.LEADING, TitledBorder.TOP, null, null));
        pnlEditSer.add(scrollFillInforSer, BorderLayout.CENTER);

        pnlFillSer = new JPanel();
        pnlFillSer.setBorder(null);
        scrollFillInforSer.setViewportView(pnlFillSer);
        pnlFillSer.setLayout(new GridLayout(5, 1, 0, 0));

        pnlIdSer = new JPanel();
        pnlIdSer.setPreferredSize(new Dimension(320, 35));
        pnlFillSer.add(pnlIdSer);
        pnlIdSer.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

        lblIdSer = new JLabel("ID service");
        lblIdSer.setPreferredSize(new Dimension(125, 25));
        pnlIdSer.add(lblIdSer);

        txtIdSer = new JTextField();
        txtIdSer.setPreferredSize(new Dimension(100, 25));
        pnlIdSer.add(txtIdSer);
        txtIdSer.setColumns(20);

        pnlNameSer = new JPanel();
        pnlNameSer.setPreferredSize(new Dimension(320, 35));
        pnlFillSer.add(pnlNameSer);
        pnlNameSer.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

        lblNameSer = new JLabel("Service name");
        lblNameSer.setPreferredSize(new Dimension(125, 25));
        pnlNameSer.add(lblNameSer);

        txtNameSer = new JTextField();
        txtNameSer.setPreferredSize(new Dimension(100, 25));
        txtNameSer.setColumns(20);
        pnlNameSer.add(txtNameSer);

        pnlPriceSer = new JPanel();
        pnlPriceSer.setPreferredSize(new Dimension(320, 35));
        pnlFillSer.add(pnlPriceSer);
        pnlPriceSer.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

        lblPriceSer = new JLabel("Price");
        lblPriceSer.setPreferredSize(new Dimension(125, 25));
        pnlPriceSer.add(lblPriceSer);

        txtPriceSer = new JTextField();
        txtPriceSer.setPreferredSize(new Dimension(100, 25));
        txtPriceSer.setColumns(20);
        pnlPriceSer.add(txtPriceSer);

        pnlButtonSer = new JPanel();
        pnlButtonSer.setPreferredSize(new Dimension(10, 40));
        pnlEditSer.add(pnlButtonSer, BorderLayout.SOUTH);
        pnlButtonSer.setLayout(new FlowLayout(FlowLayout.CENTER, 40, 10));

        btnAddSer = new JButton("Add");
        btnAddSer.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	if(txtIdSer.getText().equals("")|| txtNameSer.getText().equals("")||txtPriceSer.getText().equals("") ) {
                    JOptionPane.showMessageDialog(null, "Bạn chưa nhập đủ thông tin !");
                    return;
                }
                String idString = txtIdSer.getText().trim();
                int idser = Integer.parseInt(idString);
                String nameserString = txtNameSer.getText();
                String serpriceString = txtPriceSer.getText().trim();
                Double priceser = Double.parseDouble(serpriceString);
                ServiceBUS serviceBUS = new ServiceBUS();
                Boolean checkid = false;
                ArrayList< ServiceDTO> jfjfe = serviceBUS.getAll();
                for(ServiceDTO dfas: jfjfe) {
                	if(dfas.getService_id()== idser) {
                		checkid = true;
                	}
                }
                
                if(checkid == true) {
                	JOptionPane.showMessageDialog(null, "id đã tồn tại vui lòng nhập id mới !");
                	return;
                }
                else {
                    ServiceDTO serviceDTO = new ServiceDTO(idser,nameserString,priceser);
                    int result = JOptionPane.showConfirmDialog(null,
                            "Bạn có muốn them Service  " +nameserString,
                            "Xác nhận",
                            JOptionPane.YES_NO_OPTION,
                            JOptionPane.QUESTION_MESSAGE);
                    if(result == JOptionPane.YES_OPTION){

                        serviceBUS.add(serviceDTO);
                        ClassLoaddataService();
                    }
                    RefreshService();
                }
            }
        });
        btnAddSer.setFocusPainted(false);
        btnAddSer.setBackground(new Color(66, 165, 243));
        btnAddSer.setPreferredSize(new Dimension(100, 25));
        pnlButtonSer.add(btnAddSer);

        btnDeleteSer = new JButton("Delete");
        btnDeleteSer.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String idString = txtIdSer.getText().trim();
                if(txtIdSer.getText().equals("")) {
                	JOptionPane.showMessageDialog(null, "id không được để trống !");
                	return;
                }
                int idser = Integer.parseInt(idString);
                ServiceBUS serviceBUS = new ServiceBUS(); 
                Boolean checkid = false;
                ArrayList< ServiceDTO> jfjfe = serviceBUS.getAll();
                for(ServiceDTO dfas: jfjfe) {
                	if(dfas.getService_id()== idser) {
                		checkid = true;
                	}
                }
                if(checkid == false) {
                	JOptionPane.showMessageDialog(null, "id không tồn tại vui lòng nhập id mới !");
                	return;
                }
                else {
                	int result = JOptionPane.showConfirmDialog(null,
                            "Bạn có chắc muốn xoa hotel id: " +idser,
                            "Xác nhận",
                            JOptionPane.YES_NO_OPTION,
                            JOptionPane.QUESTION_MESSAGE);
                    if(result == JOptionPane.YES_OPTION){
                    	serviceBUS.delete(idser);
                        ClassLoaddataService();
                    }
                    RefreshService();
                }
                
            }
        });
        btnDeleteSer.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        btnDeleteSer.setBackground(new Color(66, 165, 243));
        btnDeleteSer.setFocusPainted(false);
        btnDeleteSer.setPreferredSize(new Dimension(100, 25));
        pnlButtonSer.add(btnDeleteSer);

        btnRefreshSer = new JButton("Refresh");
        btnRefreshSer.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                RefreshService();
            }
        });
        btnRefreshSer.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        btnRefreshSer.setBackground(new Color(66, 165, 243));
        btnRefreshSer.setFocusPainted(false);
        btnRefreshSer.setPreferredSize(new Dimension(100, 25));
        pnlButtonSer.add(btnRefreshSer);

        btnUpdateSer = new JButton("Update");
        btnUpdateSer.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String idString = txtIdSer.getText().trim();
                int idser = Integer.parseInt(idString);
                String nameserString = txtNameSer.getText();
                String serpriceString = txtPriceSer.getText().trim();
                Double priceser = Double.parseDouble(serpriceString);
                ServiceBUS serviceBUS = new ServiceBUS(); 
                Boolean checkid = false;
                ArrayList< ServiceDTO> jfjfe = serviceBUS.getAll();
                for(ServiceDTO dfas: jfjfe) {
                	if(dfas.getService_id()== idser) {
                		checkid = true;
                	}
                }
                if(txtIdSer.getText().equals("")|| txtNameSer.getText().equals("")||txtPriceSer.getText().equals("") ) {
                	JOptionPane.showMessageDialog(null, "Bạn chưa nhập đủ thông tin !");
                }
                else if(checkid == false) {
                	JOptionPane.showMessageDialog(null, "id không tồn tại vui lòng nhập id mới !");
                }
                else {
                    ServiceDTO serviceDTO = new ServiceDTO(idser,nameserString,priceser);
                    int result = JOptionPane.showConfirmDialog(null,
                            "Bạn có muốn update Service  " +nameserString,
                            "Xác nhận",
                            JOptionPane.YES_NO_OPTION,
                            JOptionPane.QUESTION_MESSAGE);
                    if(result == JOptionPane.YES_OPTION){
                    	serviceBUS.update(serviceDTO);
                        ClassLoaddataService();
                    }
                    RefreshService();
                }
            }
        });
        btnUpdateSer.setFocusPainted(false);
        btnUpdateSer.setBackground(new Color(66, 165, 243));
        btnUpdateSer.setPreferredSize(new Dimension(100, 25));
        pnlButtonSer.add(btnUpdateSer);

        pnlListSer = new JPanel();
        pnlListSer.setBorder(new TitledBorder(null, "List Service", TitledBorder.LEADING, TitledBorder.TOP, null, null));
        pnlListSer.setBackground(new Color(240, 240, 240));
        pnlEdit_ListSerDetail.add(pnlListSer, "pnlListSer");
        pnlListSer.setLayout(new BorderLayout(0, 0));

        sclListSer = new JScrollPane();
        pnlListSer.add(sclListSer, BorderLayout.CENTER);

//        Object [][] data5 = {
//                {"111", "Nha Trang", "Miền Trung", "20", "20","20", "20"},
//                {"111", "Nha Trang", "Miền Trung", "20", "20","20", "20"},
//                {"111", "Nha Trang", "Miền Trung", "20", "20","20", "20"},
//                {"111", "Nha Trang", "Miền Trung", "20", "20","20", "20"},
//                {"111", "Nha Trang", "Miền Trung", "20", "20","20", "20"},
//                {"111", "Nha Trang", "Miền Trung", "20", "20","20", "20"},
//                {"111", "Nha Trang", "Miền Trung", "20", "20","20", "20"},
//                {"111", "Nha Trang", "Miền Trung", "20", "20","20", "20"},
//                {"111", "Nha Trang", "Miền Trung", "20", "20","20", "20"},
//                {"111", "Nha Trang", "Miền Trung", "20", "20","20", "20"},
//                {"111", "Nha Trang", "Miền Trung", "20", "20","20", "20"},
//                {"111", "Nha Trang", "Miền Trung", "20", "20","20", "20"},
//                {"111", "Nha Trang", "Miền Trung", "20", "20","20", "20"},
//                {"111", "Nha Trang", "Miền Trung", "20", "20","20", "20"},
//                {"111", "Nha Trang", "Miền Trung", "20", "20","20", "20"},
//                {"111", "Nha Trang", "Miền Trung", "20", "20","20", "20"},
//                {"111", "Nha Trang", "Miền Trung", "20", "20","20", "20"},
//                {"111", "Nha Trang", "Miền Trung", "20", "20","20", "20"},
//                {"111", "Nha Trang", "Miền Trung", "20", "20","20", "20"},
//                {"111", "Nha Trang", "Miền Trung", "20", "20","20", "20"},
//                {"111", "Nha Trang", "Miền Trung", "20", "20","20", "20"},
//                {"111", "Nha Trang", "Miền Trung", "20", "20","20", "20"},
//                {"111", "Nha Trang", "Miền Trung", "20", "20","20", "20"},
//                {"111", "Nha Trang", "Miền Trung", "20", "20","20", "20"},
//                {"111", "Nha Trang", "Miền Trung", "20", "20","20", "20"},
//                {"111", "Nha Trang", "Miền Trung", "20", "20","20", "20"},
//                {"111", "Nha Trang", "Miền Trung", "20", "20","20", "20"},
//                {"111", "Nha Trang", "Miền Trung", "20", "20","20", "20"},
//                {"111", "Nha Trang", "Miền Trung", "20", "20","20", "20"},
//                {"111", "Nha Trang", "Miền Trung", "20", "20","20", "20"}
//
//        };

//        String [] items5 = {"ID", "Name", "Area", "Number of days", "Number of peoples", "Number of peoples", "Number of peoples"};
//        serListTable = new JTable(data5,items5);
//        sclListSer.setViewportView(serListTable);
        ClassLoaddataService();

        panel_3 = new JPanel();
        panel_3.setPreferredSize(new Dimension(50, 10));
        pnlContentSerDetail.add(panel_3, BorderLayout.EAST);

        panel_4 = new JPanel();
        panel_4.setPreferredSize(new Dimension(50, 10));
        pnlContentSerDetail.add(panel_4, BorderLayout.WEST);

        panel_5 = new JPanel();
        panel_5.setPreferredSize(new Dimension(10, 60));
        pnlContentSerDetail.add(panel_5, BorderLayout.SOUTH);

        // change form

        cardLayoutEdit_ListSerDetail = (CardLayout)(pnlEdit_ListSerDetail.getLayout());
    }


    //									Start Service
    public void ClassLoaddataService() {
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("ID");;
        model.addColumn("Name Service");
        model.addColumn("Price");
        ServiceBUS serviceBUS = new ServiceBUS(); 
        ArrayList<ServiceDTO> serDTO = serviceBUS .getAll();
        int i = 0;
        for(ServiceDTO itemService : serDTO) {
        	i++;
            model.addRow(new Object[] {
                    itemService.getService_id(),itemService.getService_name(),itemService.getService_price()
            });
        }
        serListTable = new JTable();
        serListTable.setModel(model);
        sclListSer.setViewportView(serListTable);
        panel_3 = new JPanel();
        panel_3.setPreferredSize(new Dimension(50, 10));
        pnlContentSerDetail.add(panel_3, BorderLayout.EAST);
        getDataFromJtableSer();
        txtIdSer.setText(Integer.toString(i+1));

    }
    public void RefreshService() {
        txtIdSer.setText(" ");
        txtNameSer.setText(" ");
        txtPriceSer.setText(" ");
        ServiceBUS serviceBUS = new ServiceBUS(); 
        ArrayList<ServiceDTO> serDTO = serviceBUS .getAll();
        int i = 0;
        for(ServiceDTO itemService : serDTO) {
        	i++;
           
        }
        txtIdSer.setText(Integer.toString(i+1));
        ClassLoaddataService();
    }
    public void getDataFromJtableSer() {
        List<ServiceDTO> serviceDTO = new ArrayList<ServiceDTO>();
        serListTable.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                int i = serListTable.getSelectedRow();
                TableModel model = serListTable.getModel();
                int idser = Integer.parseInt(model.getValueAt(i,0).toString());
                String nameServiceString = model.getValueAt(i,1).toString();
                Double priceService = Double.parseDouble(model.getValueAt(i,2).toString());


                String idhotelString = String.valueOf(idser);
                txtIdSer.setText(idhotelString);
                txtNameSer.setText(nameServiceString);
                String priceSerlString = String.valueOf(priceService);
                txtPriceSer.setText(priceSerlString);
            }
        });
    }
    public static boolean isNumeric(final CharSequence cs) {
//      if (cs.isEmpty()) {
//          return false;
//      }
      final int sz = cs.length();
      for (int i = 0; i < sz; i++) {
          if (!Character.isDigit(cs.charAt(i))) {
              return false;
          }
      }
      return true;
  }
}
