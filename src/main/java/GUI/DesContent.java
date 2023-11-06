package GUI;

import DAO.ConnectDatabase;
import DAO.PlaceDAO;
import DAO.ServiceDAO;
import DTO.PlaceDTO;
import DTO.ServiceDTO;

import javax.swing.*;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import BUS.PlaceBUS;

import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.text.Normalizer;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class DesContent extends JPanel{

    private JPanel pnlDesContentTitle;
    private JLabel lblDesContentTitle;
    private JPanel pnlSearchDes;
    private JLabel lblSearchDes;
    private JPanel pnlContentDesDetail;
    private JPanel pnlEdit_ListDes;
    private JPanel pnlbtnEdit_ListDes;
    private JPanel pnlEditDes;
    private JScrollPane scrollFillInforDes;
    private JPanel pnlFillDes;
    private JTextField txtIdDes;
    private JPanel pnlIdDes;
    private JLabel lblIdDes;
    private JPanel pnlNameDes;
    private JLabel lblNameDes;
    private JTextField txtNameDes;
    private JLabel lblDescribeDes;
    private JPanel pnlDescribeDes;
    private JTextField txtDescribeDes;
    private JPanel pnlAddDes;
    private JLabel lblAddDes;
    private JComboBox cbxAddDes;
    private JPanel pnlButtonDes;
    private JButton btnAddDes;
    private JButton btnDeleteDes;
    private JButton btnRefreshDes;
    private JPanel pnlListDes;
    private JTable desListTable;
    private JScrollPane sclListDes;
    private JPanel pnlIconSrc_Txt;
    private JTextField txtSearchDes;
    private JPanel panel;
    private JPanel panel_1;
    private JPanel panel_2;
    private JPanel panel_6;
    private JPanel panel_3;
    private JPanel panel_4;
    private JPanel panel_5;
    private JButton btnEditDes;
    private JButton btnListDes;
    private JPanel pnlEdit_ListDesDetail;
    private CardLayout cardLayoutEdit_ListDesDetail;
    private JComboBox cmbRegionCode;

    private JPanel pnlRegionCodeDes;

    private JLabel lblRegionCodeDes;

    private JTextField txtAddressDes;
    private JButton btnUpdateDes;
    public DesContent() {
        init();
    }

    private void init(){


        setLayout(new BorderLayout(0, 0));

        pnlDesContentTitle = new JPanel();
        pnlDesContentTitle.setPreferredSize(new Dimension(10, 125));
        add(pnlDesContentTitle, BorderLayout.NORTH);
        pnlDesContentTitle.setLayout(new BorderLayout(0, 0));

        lblDesContentTitle = new JLabel("Tourist attraction");
        lblDesContentTitle.setPreferredSize(new Dimension(200, 50));
        lblDesContentTitle.setHorizontalAlignment(SwingConstants.CENTER);
        lblDesContentTitle.setFont(new Font("Times New Roman", Font.PLAIN, 24));
        pnlDesContentTitle.add(lblDesContentTitle, BorderLayout.NORTH);

        pnlSearchDes = new JPanel();
        pnlSearchDes.setPreferredSize(new Dimension(10, 60));
        pnlDesContentTitle.add(pnlSearchDes, BorderLayout.CENTER);
        pnlSearchDes.setLayout(new BorderLayout(0, 0));

        pnlIconSrc_Txt = new JPanel();
        pnlSearchDes.add(pnlIconSrc_Txt, BorderLayout.CENTER);
        pnlIconSrc_Txt.setLayout(new BorderLayout(0, 0));

        txtSearchDes = new JTextField();
        txtSearchDes.setText("Search tourist attraction");
        pnlIconSrc_Txt.add(txtSearchDes, BorderLayout.CENTER);
        txtSearchDes.setMargin(new Insets(2, 10, 2, 10));
        txtSearchDes.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                txtSearchDes.setText(null);
                txtSearchDes.requestFocus();;
                Font font = txtSearchDes.getFont();
                font = font.deriveFont(Font.PLAIN|Font.BOLD);
                txtSearchDes.setFont(font);
                txtSearchDes.setForeground(Color.black);
            }

            @Override
            public void focusLost(FocusEvent e) {
                Font font = txtSearchDes.getFont();
                font = font.deriveFont(Font.ITALIC);
                txtSearchDes.setFont(font);
                txtSearchDes.setForeground(Color.gray);
                txtSearchDes.setText("Search tourist attraction");
            }
        });

        lblSearchDes = new JLabel("");
        lblSearchDes.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent me) {

                String desString = txtSearchDes.getText().trim();
                if(isNumeric(desString)== true) {
                    int iddes = Integer.parseInt(desString.trim());
                    PlaceBUS placeBUS = new PlaceBUS();
                    
                    PlaceDTO desDTO = placeBUS.getById(iddes);
                    if(desDTO != null) {
                        String iddesString = String.valueOf(desDTO.getPlace_id());
                        txtIdDes.setText(iddesString);
                        txtNameDes.setText(desDTO.getPlace_name());
                        txtDescribeDes.setText(desDTO.getPlace_describe());
                        txtAddressDes.setText(desDTO.getPlace_address());
                    }
                    if(desDTO == null) {
                        JOptionPane.showMessageDialog(null, "Không tìm thấy thông tin Place !");
                    }
                }
                if (isNumeric(desString)== false) {
                	PlaceBUS placeBUS = new PlaceBUS();
                    ArrayList<PlaceDTO> desDTO = placeBUS.getAll();
                    Boolean checkKQ = false;
                    for(PlaceDTO itemDesDTO: desDTO) {
                        String temp = Normalizer.normalize(itemDesDTO.getPlace_name(), Normalizer.Form.NFD);
                        String temp2 = Normalizer.normalize(desString, Normalizer.Form.NFD);
                        Pattern pattern = Pattern.compile("\\p{InCombiningDiacriticalMarks}+");
                        if(pattern.matcher(temp).replaceAll("").equalsIgnoreCase(pattern.matcher(temp2).replaceAll(""))) {
                            String iddesString = String.valueOf(itemDesDTO.getPlace_id());
                            txtIdDes.setText(iddesString);
                            txtNameDes.setText(itemDesDTO.getPlace_name());
                            txtDescribeDes.setText(itemDesDTO.getPlace_describe());
                            txtAddressDes.setText(itemDesDTO.getPlace_address());

                            checkKQ = true;
                        }
                    }
                    if(checkKQ == false) {
                        JOptionPane.showMessageDialog(null, "Không tìm thấy thông tin Place !");
                    }
                }
            }

        });
        lblSearchDes.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
        pnlIconSrc_Txt.add(lblSearchDes, BorderLayout.EAST);
        lblSearchDes.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(Manager.class.getResource("../images/search.png"))));
        lblSearchDes.setCursor(new Cursor(Cursor.HAND_CURSOR));

        panel = new JPanel();
        panel.setPreferredSize(new Dimension(10, 20));
        pnlSearchDes.add(panel, BorderLayout.NORTH);

        panel_1 = new JPanel();
        panel_1.setPreferredSize(new Dimension(10, 20));
        pnlSearchDes.add(panel_1, BorderLayout.SOUTH);

        panel_2 = new JPanel();
        panel_2.setPreferredSize(new Dimension(250, 10));
        pnlSearchDes.add(panel_2, BorderLayout.EAST);

        panel_6 = new JPanel();
        panel_6.setPreferredSize(new Dimension(250, 10));
        pnlSearchDes.add(panel_6, BorderLayout.WEST);

        pnlContentDesDetail = new JPanel();
        add(pnlContentDesDetail, BorderLayout.CENTER);
        pnlContentDesDetail.setLayout(new BorderLayout(0, 0));

        pnlEdit_ListDes = new JPanel();
        pnlContentDesDetail.add(pnlEdit_ListDes, BorderLayout.CENTER);
        pnlEdit_ListDes.setLayout(new BorderLayout(0, 0));

        pnlbtnEdit_ListDes = new JPanel();
        pnlbtnEdit_ListDes.setPreferredSize(new Dimension(10, 50));
        pnlEdit_ListDes.add(pnlbtnEdit_ListDes, BorderLayout.NORTH);
        pnlbtnEdit_ListDes.setLayout(new BoxLayout(pnlbtnEdit_ListDes, BoxLayout.X_AXIS));

        btnEditDes = new JButton("Edit tourist attraction");
        btnEditDes.setContentAreaFilled(false);
        btnEditDes.setFocusPainted(false);
        btnEditDes.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        pnlbtnEdit_ListDes.add(btnEditDes);
        btnEditDes.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayoutEdit_ListDesDetail.show(pnlEdit_ListDesDetail,"pnlEditDes");
            }
        });

        btnListDes = new JButton("List tourist attraction");
        btnListDes.setContentAreaFilled(false);
        btnListDes.setFocusPainted(false);
        btnListDes.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        pnlbtnEdit_ListDes.add(btnListDes);
        btnListDes.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayoutEdit_ListDesDetail.show(pnlEdit_ListDesDetail,"pnlListDes");
            }
        });

        pnlEdit_ListDesDetail = new JPanel();
        pnlEdit_ListDes.add(pnlEdit_ListDesDetail, BorderLayout.CENTER);
        pnlEdit_ListDesDetail.setLayout(new CardLayout(0, 0));

        pnlEditDes = new JPanel();
        pnlEdit_ListDesDetail.add(pnlEditDes, "pnlEditDes");
        pnlEditDes.setLayout(new BorderLayout(0, 0));

        scrollFillInforDes = new JScrollPane();
        scrollFillInforDes.setBorder(new TitledBorder(null, "Edit tourist attraction", TitledBorder.LEADING, TitledBorder.TOP, null, null));
        pnlEditDes.add(scrollFillInforDes, BorderLayout.CENTER);

        pnlFillDes = new JPanel();
        pnlFillDes.setBorder(null);
        scrollFillInforDes.setViewportView(pnlFillDes);
        pnlFillDes.setLayout(new GridLayout(6, 1, 0, 0));

        pnlIdDes = new JPanel();
        pnlIdDes.setPreferredSize(new Dimension(320, 35));
        pnlFillDes.add(pnlIdDes);

        lblIdDes = new JLabel("ID");
        lblIdDes.setPreferredSize(new Dimension(125, 25));
        pnlIdDes.add(lblIdDes);

        txtIdDes = new JTextField();
        txtIdDes.setPreferredSize(new Dimension(100, 25));
        pnlIdDes.add(txtIdDes);
        txtIdDes.setColumns(20);

        pnlNameDes = new JPanel();
        pnlNameDes.setPreferredSize(new Dimension(320, 35));
        pnlFillDes.add(pnlNameDes);

        lblNameDes = new JLabel("Name");
        lblNameDes.setPreferredSize(new Dimension(125, 25));
        pnlNameDes.add(lblNameDes);

        txtNameDes = new JTextField();
        txtNameDes.setPreferredSize(new Dimension(100, 25));
        pnlNameDes.add(txtNameDes);
        txtNameDes.setColumns(20);

        pnlDescribeDes = new JPanel();
        pnlDescribeDes.setPreferredSize(new Dimension(320, 35));
        pnlFillDes.add(pnlDescribeDes);

        lblDescribeDes = new JLabel("Describe");
        lblDescribeDes.setPreferredSize(new Dimension(125, 25));
        pnlDescribeDes.add(lblDescribeDes);

        txtDescribeDes = new JTextField();
        txtDescribeDes.setPreferredSize(new Dimension(100, 25));
        pnlDescribeDes.add(txtDescribeDes);
        txtDescribeDes.setColumns(20);

        pnlRegionCodeDes = new JPanel();
        pnlFillDes.add(pnlRegionCodeDes);

        lblRegionCodeDes = new JLabel("Region Code");
        lblRegionCodeDes.setPreferredSize(new Dimension(125, 25));
        pnlRegionCodeDes.add(lblRegionCodeDes);

        cmbRegionCode = new JComboBox();
        cmbRegionCode.setPreferredSize(new Dimension(223, 25));
        cmbRegionCode.setMaximumRowCount(10);
        regionCodeData(cmbRegionCode);
        pnlRegionCodeDes.add(cmbRegionCode);

        pnlAddDes = new JPanel();
        pnlAddDes.setPreferredSize(new Dimension(320, 35));
        pnlFillDes.add(pnlAddDes);

        lblAddDes = new JLabel("Address");
        lblAddDes.setPreferredSize(new Dimension(125, 25));
        pnlAddDes.add(lblAddDes);

        txtAddressDes = new JTextField();
        txtAddressDes.setPreferredSize(new Dimension(100, 25));
        pnlAddDes.add(txtAddressDes);
        txtAddressDes.setColumns(20);


        pnlButtonDes = new JPanel();
        pnlButtonDes.setBorder(null);
        pnlButtonDes.setPreferredSize(new Dimension(10, 40));
        pnlEditDes.add(pnlButtonDes, BorderLayout.SOUTH);
        pnlButtonDes.setLayout(new FlowLayout(FlowLayout.CENTER, 40, 10));

        btnAddDes = new JButton("Add");
        btnAddDes.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String idString = txtIdDes.getText().trim();
                int iddes = Integer.parseInt(idString);
                String namedesString = txtNameDes.getText();
                String describeDesString = txtDescribeDes.getText();
                String  regioncodeDesString = (String)cmbRegionCode.getSelectedItem();
                String valuecoderegion = cmbRegionCode.getSelectedItem().toString();
                String addressDesString = txtAddressDes.getText();
                if(namedesString==""|| describeDesString =="" || addressDesString == "" ) {
                    JOptionPane.showMessageDialog(null, "Bạn chưa nhập đủ thông tin !");
                }
                else {
                    PlaceDTO PlaceDTO = new PlaceDTO(iddes,namedesString,describeDesString,valuecoderegion,addressDesString);
                    int result = JOptionPane.showConfirmDialog(null,
                            "Bạn có muốn them Tourist   " +namedesString,
                            "Xác nhận",
                            JOptionPane.YES_NO_OPTION,
                            JOptionPane.QUESTION_MESSAGE);
                    if(result == JOptionPane.YES_OPTION){
                    	PlaceBUS placeBUS = new PlaceBUS();
                    	placeBUS.add(PlaceDTO);
                        ClassLoaddataDes();
                    }
                    RefreshDes();
                }
            }
        });
        btnAddDes.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        btnAddDes.setFocusPainted(false);
        btnAddDes.setBackground(new Color(66, 165, 243));
        btnAddDes.setPreferredSize(new Dimension(100, 25));
        pnlButtonDes.add(btnAddDes);

        btnDeleteDes = new JButton("Delete");
        btnDeleteDes.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String idString = txtIdDes.getText().trim();
                int iddes = Integer.parseInt(idString);
                int result = JOptionPane.showConfirmDialog(null,
                        "Bạn có chắc muốn xoa place id: " +iddes,
                        "Xác nhận",
                        JOptionPane.YES_NO_OPTION,
                        JOptionPane.QUESTION_MESSAGE);
                if(result == JOptionPane.YES_OPTION){
                	PlaceBUS placeBUS = new PlaceBUS();
                	placeBUS.delete(iddes);
                    ClassLoaddataDes();
                }
                RefreshDes();
            }
        });
        btnDeleteDes.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        btnDeleteDes.setBackground(new Color(66, 165, 243));
        btnDeleteDes.setFocusPainted(false);
        btnDeleteDes.setPreferredSize(new Dimension(100, 25));
        pnlButtonDes.add(btnDeleteDes);

        btnRefreshDes = new JButton("Refresh");
        btnRefreshDes.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                RefreshDes();

            }
        });
        btnRefreshDes.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        btnRefreshDes.setFocusPainted(false);
        btnRefreshDes.setBackground(new Color(66, 165, 243));
        btnRefreshDes.setPreferredSize(new Dimension(100, 25));
        pnlButtonDes.add(btnRefreshDes);

        btnUpdateDes = new JButton("Update");
        btnUpdateDes.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String idString = txtIdDes.getText().trim();
                int iddes = Integer.parseInt(idString);
                String namedesString = txtNameDes.getText();
                String describeDesString = txtDescribeDes.getText();
                String valuecoderegion = cmbRegionCode.getSelectedItem().toString();
                String addressDesString = txtAddressDes.getText();
                if(namedesString==""|| describeDesString =="" || addressDesString == "" ) {
                    JOptionPane.showMessageDialog(null, "Bạn chưa nhập đủ thông tin !");
                }
                else {
                    PlaceDTO PlaceDTO = new PlaceDTO(iddes,namedesString,describeDesString,valuecoderegion,addressDesString);
                    int result = JOptionPane.showConfirmDialog(null,
                            "Bạn có muốn update Place   " +namedesString,
                            "Xác nhận",
                            JOptionPane.YES_NO_OPTION,
                            JOptionPane.QUESTION_MESSAGE);
                    if(result == JOptionPane.YES_OPTION){
                    	PlaceBUS placeBUS = new PlaceBUS();
                    	placeBUS.update(PlaceDTO);
                        ClassLoaddataDes();
                    }
                    RefreshDes();
                }
            }
        });
        btnUpdateDes.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        btnUpdateDes.setFocusPainted(false);
        btnUpdateDes.setBackground(new Color(66, 165, 243));
        btnUpdateDes.setPreferredSize(new Dimension(100, 25));
        pnlButtonDes.add(btnUpdateDes);

        pnlListDes = new JPanel();
        pnlListDes.setBorder(new TitledBorder(null, "List tourist attraction", TitledBorder.LEADING, TitledBorder.TOP, null, null));
        pnlListDes.setBackground(new Color(240, 240, 240));
        pnlEdit_ListDesDetail.add(pnlListDes, "pnlListDes");
        pnlListDes.setLayout(new BorderLayout(0, 0));

        sclListDes = new JScrollPane();
        pnlListDes.add(sclListDes, BorderLayout.CENTER);

        ClassLoaddataDes();

        panel_3 = new JPanel();
        panel_3.setPreferredSize(new Dimension(50, 10));
        pnlContentDesDetail.add(panel_4, BorderLayout.EAST);

        panel_4 = new JPanel();
        panel_4.setPreferredSize(new Dimension(50, 10));
        pnlContentDesDetail.add(panel_4, BorderLayout.WEST);

        panel_5 = new JPanel();
        panel_5.setPreferredSize(new Dimension(10, 60));
        pnlContentDesDetail.add(panel_5, BorderLayout.SOUTH);


        // change form
        cardLayoutEdit_ListDesDetail = (CardLayout)(pnlEdit_ListDesDetail.getLayout());
    }


// 												Start Tourist Atraction

    public void ClassLoaddataDes() {
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("ID");;
        model.addColumn("Name Place");
        model.addColumn("Describe");
        model.addColumn("Region Code");
        model.addColumn("Address");
        PlaceBUS placeBUS = new PlaceBUS();
        ArrayList<PlaceDTO> desDTO = placeBUS.getAll();
        for(PlaceDTO itemDes : desDTO) {
            model.addRow(new Object[] {
                    itemDes.getPlace_id(),itemDes.getPlace_name(),itemDes.getPlace_describe(),itemDes.getRegion_code(),itemDes.getPlace_address()
            });
        }
        desListTable = new JTable();
        desListTable.setModel(model);
        sclListDes.setViewportView(desListTable);
        panel_4 = new JPanel();
        panel_4.setPreferredSize(new Dimension(50, 10));
        pnlContentDesDetail.add(panel_4, BorderLayout.EAST);
        getDataFromJtableDes();

    }
    public void RefreshDes() {
        txtIdDes.setText(" ");
        txtNameDes.setText(" ");
        txtDescribeDes.setText(" ");
        txtAddressDes.setText(" ");
    }
    public void getDataFromJtableDes() {
        List<PlaceDTO> placeDTO = new ArrayList<PlaceDTO>();
        desListTable.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent me) {
                int i = desListTable.getSelectedRow();
                TableModel model = desListTable.getModel();
                int iddes = Integer.parseInt(model.getValueAt(i,0).toString());
                String nameDesString = model.getValueAt(i,1).toString();
                String decribeDesString = model.getValueAt(i,2).toString();
                String coderegionString = (String) model.getValueAt(i,3);
                String addressDesString = model.getValueAt(i,4).toString();



                String iddesString = String.valueOf(iddes);
                txtIdDes.setText(iddesString);
                txtNameDes.setText(nameDesString);
                txtDescribeDes.setText(decribeDesString);
                txtAddressDes.setText(addressDesString);

            }
        });
    }

//												End Tourist Atraction

    public  void regionCodeData (JComboBox<String> cmbRegionCode) {
        ConnectDatabase conndb = new ConnectDatabase();
        try {
            Connection conn = conndb.getConnection();
            String query = "Select region_code from region";
            ResultSet rs = conn.createStatement().executeQuery(query);
            while (rs.next()) {
                cmbRegionCode.addItem(rs.getString("region_code"));
            }
        }
        catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
        finally {
            conndb.closeConnection();
        }
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
