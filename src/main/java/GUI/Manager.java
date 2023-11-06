package GUI;

import com.toedter.calendar.JDateChooser;
import controller.ManagerControl;

import javax.swing.*;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.*;


public class Manager extends JFrame {
    private CardLayout cardLayout;
    private CardLayout cardLayoutEdit_ListTourDetail;
    private CardLayout cardLayoutEdit_ListCusDetail;
    private CardLayout cardLayoutEdit_ListStatisticalDetail;
    private CardLayout cardLayoutEdit_ListExportExcelDetail;

    private BorderLayout borderLayout;
    private JPanel pnlHeader;
    private JPanel pnlContent;
    private JLabel lblHeaderTitle;
    private JPanel pnlMenu;
    private JPanel pnlMenuTools;
    private JPanel pnlZoom;
    private JPanel pnlHome;
    private JPanel pnlSetting;
    private JLabel lblIconZoomOut;
    private JLabel lblIconZoomIn;
    private JLabel lblIconHome;
    private JLabel lblIconSetting;
    private JPanel pnlMenuDetail;
    private JPanel pnlLogo;
    private JPanel pnlMngList;
    private JPanel pnlBottom;
    private JScrollPane scrollMenuDeTail;
    private JPanel pnlListDetail;

    public JPanel getPnlListDetail() {
        return pnlListDetail;
    }

    public void setPnlListDetail(JPanel pnlListDetail) {
        this.pnlListDetail = pnlListDetail;
    }

    private JPanel pnlTourManager;
    private JPanel pnlCusManager;
    private JPanel pnlDesManager;
    private JPanel pnlBillManager;
    private JPanel pnlSerManager;
    private JPanel pnlHotelManager;
    private JPanel pnlAccManager;
    private JPanel pnlStatistical;
    private JPanel pnlExportExcel;
    private JLabel lblTourManager;
    private JLabel lblCusManager;
    private JLabel lblDesManager;
    private JLabel lblBillManager;
    private JLabel lblSerManager;
    private JLabel lblHotelManager;
    private JLabel lblAccManager;
    private JLabel lblStatistical;
    private JLabel lblExportExcel;
    private JPanel pnlMainContent;
    private TourContent pnlTourContent;
    private CusContent pnlCusContent;
    private DesContent pnlDesContent;
    private BillContent pnlBillContent;
    private SerContent pnlSerContent;
    private HotelContent pnlHotelContent;
    private AccContent pnlAccContent;
    private JPanel pnlStatisticalContent;
    private JPanel pnlExportExcelContent;
    private JLabel lblNewLabel_1;
    private JPanel pnlLogOut;
    private JLabel lblIconLogOut;

    public Manager(JPanel pnlZoom, JPanel pnlHome, JPanel pnlSetting, JPanel pnlLogOut, JLabel lblIconZoomOut, JLabel lblIconZoomIn, JLabel lblIconHome, JLabel lblIconSetting, JLabel lblIconLogOut, JPanel pnlTourManager, JPanel pnlCusManager, JPanel pnlDesManager, JPanel pnlBillManager, JPanel pnlSerManager, JPanel pnlHotelManager, JPanel pnlAccManager, JPanel pnlStatistical, JPanel pnlExportExcel, JLabel lblTourManager, JLabel lblCusManager, JLabel lblDesManager, JLabel lblBillManager, JLabel lblSerManager, JLabel lblHotelManager, JLabel lblAccManager, JLabel lblStatistical, JLabel lblExportExcel, CardLayout cardLayout, JPanel pnlMainContent, CardLayout cardLayoutEdit_ListTourDetail, CardLayout cardLayoutEdit_ListCusDetail, CardLayout cardLayoutEdit_ListDesDetail, CardLayout cardLayoutEdit_ListBillDetail, CardLayout cardLayoutEdit_ListSerDetail, CardLayout cardLayoutEdit_ListHotelDetail, CardLayout cardLayoutEdit_ListAccDetail, CardLayout cardLayoutEdit_ListStatisticalDetail, CardLayout cardLayoutEdit_ListExportExcelDetail, JButton btnEditTour, JButton btnListTour, JButton btnEditCus, JButton btnListCus, JPanel pnlEdit_ListTourDetail, JPanel pnlEdit_ListCusDetail, JButton btnEditHotel, JButton btnListHotel, JPanel pnlEdit_ListHotelDetail, JPanel pnlEdit_ListAccDetail, JButton btnEditAcc, JButton btnListAcc, JTextField txtSearchTour, JTextField txtSearchCus, JTextField txtSearchHotel, JTextField txtSearchAcc, JButton btnEditSer, JButton btnListSer, JTextField txtSearchSer, JPanel pnlEdit_ListSerDetail, JButton btnEditBill, JButton btnListBill, JPanel pnlEdit_ListBillDetail, JTextField txtSearchBill, JButton btnEditDes, JButton btnListDes, JPanel pnlEdit_ListDesDetail, JTextField txtSearchDes) {

        this.pnlZoom = pnlZoom;
        this.pnlHome = pnlHome;
        this.pnlSetting = pnlSetting;
        this.pnlLogOut = pnlLogOut;
        this.lblIconZoomOut = lblIconZoomOut;
        this.lblIconZoomIn = lblIconZoomIn;
        this.lblIconHome = lblIconHome;
        this.lblIconSetting = lblIconSetting;
        this.lblIconLogOut = lblIconLogOut;

        this.pnlTourManager = pnlTourManager;
        this.pnlCusManager = pnlCusManager;
        this.pnlDesManager = pnlDesManager;
        this.pnlBillManager = pnlBillManager;
        this.pnlSerManager = pnlSerManager;
        this.pnlHotelManager = pnlHotelManager;
        this.pnlAccManager = pnlAccManager;
        this.pnlStatistical = pnlStatistical;
        this.pnlExportExcel = pnlExportExcel;
        this.lblTourManager = lblTourManager;
        this.lblCusManager = lblCusManager;
        this.lblDesManager = lblDesManager;
        this.lblBillManager = lblBillManager;
        this.lblSerManager = lblSerManager;
        this.lblHotelManager = lblHotelManager;
        this.lblAccManager = lblAccManager;
        this.lblStatistical = lblStatistical;
        this.lblExportExcel = lblExportExcel;
        this.cardLayout = cardLayout;
        this.pnlMainContent = pnlMainContent;
        this.cardLayoutEdit_ListTourDetail = cardLayoutEdit_ListTourDetail;
        this.cardLayoutEdit_ListCusDetail = cardLayoutEdit_ListCusDetail;
        this.cardLayoutEdit_ListStatisticalDetail = cardLayoutEdit_ListAccDetail;
        this.cardLayoutEdit_ListExportExcelDetail = cardLayoutEdit_ListExportExcelDetail;
    }

    public Manager() {
//		EmpMgrModel empManagerModel = new EmpMgrModel();
        init_Manager();
        ChangeForm();

    }

    public CardLayout getCardLayout() {
        return cardLayout;
    }

    public void setCardLayout(CardLayout cardLayout) {
        this.cardLayout = cardLayout;
    }

    public JPanel getPnlZoom() {
        return pnlZoom;
    }

    public void setPnlZoom(JPanel pnlZoom) {
        this.pnlZoom = pnlZoom;
    }

    public JLabel getLblIconZoomOut() {
        return lblIconZoomOut;
    }

    public void setLblIconZoomOut(JLabel lblIconZoomOut) {
        this.lblIconZoomOut = lblIconZoomOut;
    }

    public JLabel getLblIconZoomIn() {
        return lblIconZoomIn;
    }

    public void setLblIconZoomIn(JLabel lblIconZoomIn) {
        this.lblIconZoomIn = lblIconZoomIn;
    }

    public JPanel getPnlHome() {
        return pnlHome;
    }

    public void setPnlHome(JPanel pnlHome) {
        this.pnlHome = pnlHome;
    }

    public JPanel getPnlSetting() {
        return pnlSetting;
    }

    public void setPnlSetting(JPanel pnlSetting) {
        this.pnlSetting = pnlSetting;
    }

    public JPanel getPnlLogOut() {
        return pnlLogOut;
    }

    public void setPnlLogOut(JPanel pnlLogOut) {
        this.pnlLogOut = pnlLogOut;
    }

    public JLabel getLblIconLogOut() {
        return lblIconLogOut;
    }

    public void setLblIconLogOut(JLabel lblIconLogOut) {
        this.lblIconLogOut = lblIconLogOut;
    }

    public JLabel getLblIconHome() {
        return lblIconHome;
    }

    public void setLblIconHome(JLabel lblIconHome) {
        this.lblIconHome = lblIconHome;
    }

    public JLabel getLblIconSetting() {
        return lblIconSetting;
    }

    public void setLblIconSetting(JLabel lblIconSetting) {
        this.lblIconSetting = lblIconSetting;
    }

    public JPanel getPnlTourManager() {
        return pnlTourManager;
    }

    public void setPnlTourManager(JPanel pnlTourManager) {
        this.pnlTourManager = pnlTourManager;
    }

    public JPanel getPnlCusManager() {
        return pnlCusManager;
    }

    public void setPnlCusManager(JPanel pnlCusManager) {
        this.pnlCusManager = pnlCusManager;
    }

    public JPanel getPnlDesManager() {
        return pnlDesManager;
    }

    public void setPnlDesManager(JPanel pnlDesManager) {
        this.pnlDesManager = pnlDesManager;
    }

    public JPanel getPnlBillManager() {
        return pnlBillManager;
    }

    public void setPnlBillManager(JPanel pnlBillManager) {
        this.pnlBillManager = pnlBillManager;
    }

    public JPanel getPnlSerManager() {
        return pnlSerManager;
    }

    public void setPnlSerManager(JPanel pnlSerManager) {
        this.pnlSerManager = pnlSerManager;
    }

    public JPanel getPnlHotelManager() {
        return pnlHotelManager;
    }

    public void setPnlHotelManager(JPanel pnlHotelManager) {
        this.pnlHotelManager = pnlHotelManager;
    }

    public JPanel getPnlAccManager() {
        return pnlAccManager;
    }

    public void setPnlAccManager(JPanel pnlAccManager) {
        this.pnlAccManager = pnlAccManager;
    }

    public JPanel getPnlStatistical() {
        return pnlStatistical;
    }

    public void setPnlStatistical(JPanel pnlStatistical) {
        this.pnlStatistical = pnlStatistical;
    }

    public JPanel getPnlExportExcel() {
        return pnlExportExcel;
    }

    public void setPnlExportExcel(JPanel pnlExportExcel) {
        this.pnlExportExcel = pnlExportExcel;
    }

    public JLabel getLblTourManager() {
        return lblTourManager;
    }

    public void setLblTourManager(JLabel lblTourManager) {
        this.lblTourManager = lblTourManager;
    }

    public JLabel getLblCusManager() {
        return lblCusManager;
    }

    public void setLblCusManager(JLabel lblCusManager) {
        this.lblCusManager = lblCusManager;
    }

    public JLabel getLblDesManager() {
        return lblDesManager;
    }

    public void setLblDesManager(JLabel lblDesManager) {
        this.lblDesManager = lblDesManager;
    }

    public JPanel getPnlTourContent() {
		return this.pnlTourContent;
	}
    
    public JLabel getLblBillManager() {
        return lblBillManager;
    }

    public void setLblBillManager(JLabel lblBillManager) {
        this.lblBillManager = lblBillManager;
    }

    public JLabel getLblSerManager() {
        return lblSerManager;
    }

    public void setLblSerManager(JLabel lblSerManager) {
        this.lblSerManager = lblSerManager;
    }

    public JLabel getLblHotelManager() {
        return lblHotelManager;
    }

    public void setLblHotelManager(JLabel lblHotelManager) {
        this.lblHotelManager = lblHotelManager;
    }

    public JLabel getLblAccManager() {
        return lblAccManager;
    }

    public void setLblAccManager(JLabel lblAccManager) {
        this.lblAccManager = lblAccManager;
    }

    public JLabel getLblStatistical() {
        return lblStatistical;
    }

    public void setLblStatistical(JLabel lblStatistical) {
        this.lblStatistical = lblStatistical;
    }

    public JLabel getLblExportExcel() {
        return lblExportExcel;
    }

    public void setLblExportExcel(JLabel lblExportExcel) {
        this.lblExportExcel = lblExportExcel;
    }

    public JPanel getPnlMainContent() {
        return pnlMainContent;
    }

    public void setPnlMainContent(JPanel pnlMainContent) {
        this.pnlMainContent = pnlMainContent;
    }

    public CardLayout getCardLayoutEdit_ListTourDetail() {
        return cardLayoutEdit_ListTourDetail;
    }

    public void setCardLayoutEdit_ListTourDetail(CardLayout cardLayoutEdit_ListTourDetail) {
        this.cardLayoutEdit_ListTourDetail = cardLayoutEdit_ListTourDetail;
    }

    public CardLayout getCardLayoutEdit_ListCusDetail() {
        return cardLayoutEdit_ListCusDetail;
    }

    public void setCardLayoutEdit_ListCusDetail(CardLayout cardLayoutEdit_ListCusDetail) {
        this.cardLayoutEdit_ListCusDetail = cardLayoutEdit_ListCusDetail;
    }

    public CardLayout getCardLayoutEdit_ListStatisticalDetail() {
        return cardLayoutEdit_ListStatisticalDetail;
    }

    public void setCardLayoutEdit_ListStatisticalDetail(CardLayout cardLayoutEdit_ListStatisticalDetail) {
        this.cardLayoutEdit_ListStatisticalDetail = cardLayoutEdit_ListStatisticalDetail;
    }

    public CardLayout getCardLayoutEdit_ListExportExcelDetail() {
        return cardLayoutEdit_ListExportExcelDetail;
    }

    public void setCardLayoutEdit_ListExportExcelDetail(CardLayout cardLayoutEdit_ListExportExcelDetail) {
        this.cardLayoutEdit_ListExportExcelDetail = cardLayoutEdit_ListExportExcelDetail;
    }

    public void init_Manager() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 1100, 700);
        setLocationRelativeTo(null);

        // Sự kiện MouseListener , ActionListener , FocusListener
        MouseListener mouseListener = new ManagerControl(this);


        borderLayout = new BorderLayout();
        getContentPane().setLayout(borderLayout);

        // Create pnlHeader at NORTH
        pnlHeader = new JPanel();
        pnlHeader.setBackground(new Color(33, 150, 243));
        getContentPane().add(pnlHeader, BorderLayout.NORTH);
        pnlHeader.setLayout(new FlowLayout(FlowLayout.CENTER, 15, 15));

        // Create pnlContent at CENTER
        pnlContent = new JPanel();
        getContentPane().add(pnlContent, BorderLayout.CENTER);

        // Create title into pnlHeader
        lblHeaderTitle = new JLabel("Quản Lí Tour Du Lịch");
        lblHeaderTitle.setFont(new Font("Tahoma", Font.BOLD, 24));
        pnlHeader.add(lblHeaderTitle);
        pnlContent.setLayout(new BorderLayout(0, 0));

        // Create pnlMenu at WEST
        pnlMenu = new JPanel();
        pnlContent.add(pnlMenu, BorderLayout.WEST);
        pnlMenu.setLayout(new BorderLayout());

        // Create pnlMenuTools at WEST into pnlMenu
        pnlMenuTools = new JPanel();
        pnlMenuTools.setBackground(new Color(33, 150, 243));
        pnlMenuTools.setAlignmentX(Component.LEFT_ALIGNMENT);
        pnlMenuTools.setPreferredSize(new Dimension(50, 10));
        pnlMenu.add(pnlMenuTools, BorderLayout.WEST);
        pnlMenuTools.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

        // Create pnlZoom, pnlHome, pnlSetting into pnlMenuTools
        pnlZoom = new JPanel();
        pnlZoom.setBackground(new Color(33, 150, 243));
        pnlZoom.setPreferredSize(new Dimension(50, 33));
        pnlZoom.setLayout(null);
        pnlMenuTools.add(pnlZoom);

        pnlHome = new JPanel();
        pnlHome.setBackground(new Color(33, 150, 243));
        pnlHome.setPreferredSize(new Dimension(50, 33));
        pnlMenuTools.add(pnlHome);

        pnlSetting = new JPanel();
        pnlSetting.setBackground(new Color(33, 150, 243));
        pnlSetting.setPreferredSize(new Dimension(50, 33));
        pnlMenuTools.add(pnlSetting);
        pnlSetting.setLayout(null);

        pnlLogOut = new JPanel();
        pnlLogOut.setBackground(new Color(33, 150, 243));
        pnlLogOut.setPreferredSize(new Dimension(50, 33));
        pnlMenuTools.add(pnlLogOut);
        pnlLogOut.setLayout(null);

        // Create lblIconZoom into pnlZoom
        lblIconZoomOut = new JLabel("", JLabel.CENTER);
        lblIconZoomOut.setToolTipText("Hidden Menu");
        lblIconZoomOut.setBounds(0, 0, 50, 33);
		lblIconZoomOut.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(Manager.class.getResource("../images/zoomout.png"))));
        lblIconZoomOut.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        lblIconZoomOut.addMouseListener(mouseListener);
        pnlZoom.add(lblIconZoomOut);


        // Create lblIconHome into pnlHome
        lblIconHome = new JLabel("", JLabel.CENTER);
        lblIconHome.setToolTipText("Home");
        lblIconHome.setBounds(0, 0, 50, 33);
		lblIconHome.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(Manager.class.getResource("../images/home.png"))));
        lblIconHome.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        lblIconHome.addMouseListener(mouseListener);
        pnlHome.add(lblIconHome);

        // Create lblIconSetting into pnlSetting
        lblIconSetting = new JLabel("", JLabel.CENTER);
        lblIconSetting.setToolTipText("Setting");
        lblIconSetting.setBounds(0, 0, 50, 33);
		lblIconSetting.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(Manager.class.getResource("../images/settings.png"))));
        lblIconSetting.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        lblIconSetting.addMouseListener(mouseListener);
        pnlSetting.add(lblIconSetting);

        // Create lblIconSetting into pnlSetting
        lblIconLogOut = new JLabel("", JLabel.CENTER);
        lblIconLogOut.setToolTipText("Log out");
        lblIconLogOut.setBounds(0, 0, 50, 33);
		lblIconLogOut.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(Manager.class.getResource("../images/log-out.png"))));
        lblIconLogOut.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        lblIconLogOut.addMouseListener(mouseListener);
        pnlLogOut.add(lblIconLogOut);


        lblIconLogOut.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                close();
                SignIn si = new SignIn();
                si.setVisible(true);
            }
        });

        // Create pnlMenuDetail into pnlMenu
        pnlMenuDetail = new JPanel();
        pnlMenuDetail.setBackground(new Color(255, 255, 255));
        pnlMenuDetail.setPreferredSize(new Dimension(222, 10));
        pnlMenu.add(pnlMenuDetail, BorderLayout.CENTER);
        pnlMenuDetail.setLayout(new BorderLayout());

        //Create pnlLogo into pnlMenuDetail at NORTH
        pnlLogo = new JPanel();
        pnlLogo.setBackground(new Color(66, 165, 243));
        pnlLogo.setPreferredSize(new Dimension(10, 150));
        pnlMenuDetail.add(pnlLogo, BorderLayout.NORTH);
        pnlLogo.setLayout(new BorderLayout(0, 0));

        lblNewLabel_1 = new JLabel("");

        lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(Manager.class.getResource("../images/logo.png"))));
        pnlLogo.add(lblNewLabel_1, BorderLayout.CENTER);

        //Create pnlMngList into pnlMenuDetail at CENTER
        pnlMngList = new JPanel();
        pnlMngList.setAutoscrolls(true);
        pnlMngList.setBackground(new Color(255, 255, 255));
        pnlMenuDetail.add(pnlMngList, BorderLayout.CENTER);
        pnlMngList.setLayout(new BorderLayout(0, 0));

        //Create pnlBottom into pnlMenuDetail at SOUTH
        pnlBottom = new JPanel();
        pnlBottom.setBackground(new Color(66, 165, 243));
        pnlBottom.setPreferredSize(new Dimension(10, 83));
        pnlMngList.add(pnlBottom, BorderLayout.SOUTH);

        //Create scrollMenuDeTail into pnlMngList at CENTER
        scrollMenuDeTail = new JScrollPane();
        scrollMenuDeTail.setBackground(new Color(66, 165, 243));
        scrollMenuDeTail.setBorder(null);
        pnlMngList.add(scrollMenuDeTail, BorderLayout.CENTER);

        //Create pnlListDetail into scrollMenuDeTail
        pnlListDetail = new JPanel();
        pnlListDetail.setBackground(new Color(66, 165, 243));
        pnlListDetail.setAlignmentY(Component.TOP_ALIGNMENT);
        scrollMenuDeTail.setViewportView(pnlListDetail);
        pnlListDetail.setLayout(new GridLayout(9, 1, 0, 0));
	
		/* 
		Create pnlTourManager, pnlCusManager, pnlStaffManager, pnlBillManager, pnlSerManager,
		pnlHotelManager, pnlVehManager, pnlAccManager, pnlStatisticalManager into pnlListDetail
		*/
        pnlTourManager = new JPanel();
        pnlTourManager.setBounds(0, 3, 172, 34);
        pnlTourManager.setBackground(new Color(66, 165, 243));
        pnlListDetail.add(pnlTourManager);
        pnlTourManager.setLayout(new GridLayout(0, 1, 0, 0));

        pnlCusManager = new JPanel();
        pnlCusManager.setBounds(0, 3, 172, 34);
        pnlCusManager.setBackground(new Color(66, 165, 243));
        pnlListDetail.add(pnlCusManager);
        pnlCusManager.setLayout(new GridLayout(0, 1, 0, 0));

        pnlDesManager = new JPanel();
        pnlDesManager.setBounds(0, 3, 172, 34);
        pnlDesManager.setBackground(new Color(66, 165, 243));
        pnlListDetail.add(pnlDesManager);
        pnlDesManager.setLayout(new GridLayout(0, 1, 0, 0));

        pnlBillManager = new JPanel();
        pnlBillManager.setBounds(0, 3, 172, 34);
        pnlBillManager.setBackground(new Color(66, 165, 243));
        pnlListDetail.add(pnlBillManager);
        pnlBillManager.setLayout(new GridLayout(0, 1, 0, 0));

        pnlSerManager = new JPanel();
        pnlSerManager.setBounds(0, 3, 172, 34);
        pnlSerManager.setBackground(new Color(66, 165, 243));
        pnlListDetail.add(pnlSerManager);
        pnlSerManager.setLayout(new GridLayout(0, 1, 0, 0));

        pnlHotelManager = new JPanel();
        pnlHotelManager.setBounds(0, 3, 172, 34);
        pnlHotelManager.setBackground(new Color(66, 165, 243));
        pnlListDetail.add(pnlHotelManager);
        pnlHotelManager.setLayout(new GridLayout(0, 1, 0, 0));

        pnlAccManager = new JPanel();
        pnlAccManager.setBounds(0, 3, 172, 34);
        pnlAccManager.setBackground(new Color(66, 165, 243));
        pnlListDetail.add(pnlAccManager);
        pnlAccManager.setLayout(new GridLayout(0, 1, 0, 0));

        pnlStatistical = new JPanel();
        pnlStatistical.setBounds(0, 3, 172, 34);
        pnlStatistical.setBackground(new Color(66, 165, 243));
        pnlListDetail.add(pnlStatistical);
        pnlStatistical.setLayout(new GridLayout(0, 1, 0, 0));

        pnlExportExcel = new JPanel();
        pnlExportExcel.setBounds(0, 3, 172, 34);
        pnlExportExcel.setBackground(new Color(66, 165, 243));
        pnlListDetail.add(pnlExportExcel);
        pnlExportExcel.setLayout(new GridLayout(0, 1, 0, 0));


        lblTourManager = new JLabel("   Tour Manager");
        lblTourManager.setPreferredSize(new Dimension(76, 41));
		lblTourManager.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(Manager.class.getResource("../images/travel.png"))));
        lblTourManager.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblTourManager.setCursor(new Cursor(Cursor.HAND_CURSOR));
        pnlTourManager.add(lblTourManager);
        lblTourManager.addMouseListener(mouseListener);

        lblCusManager = new JLabel("   Customer Manager");
        lblCusManager.setPreferredSize(new Dimension(76, 41));
		lblCusManager.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(Manager.class.getResource("../images/customer.png"))));
        lblCusManager.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblCusManager.setCursor(new Cursor(Cursor.HAND_CURSOR));
        pnlCusManager.add(lblCusManager);
        lblCusManager.addMouseListener(mouseListener);

        lblDesManager = new JLabel("   Tourist attraction");
        lblDesManager.setPreferredSize(new Dimension(76, 41));
		lblDesManager.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(Manager.class.getResource("../images/destination.png"))));
        lblDesManager.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblDesManager.setCursor(new Cursor(Cursor.HAND_CURSOR));
        pnlDesManager.add(lblDesManager);
        lblDesManager.addMouseListener(mouseListener);

        lblBillManager = new JLabel("   Bill Manager");
        lblBillManager.setPreferredSize(new Dimension(76, 41));
		lblBillManager.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(Manager.class.getResource("../images/ticket.png"))));
        lblBillManager.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblBillManager.setCursor(new Cursor(Cursor.HAND_CURSOR));
        pnlBillManager.add(lblBillManager);
        lblBillManager.addMouseListener(mouseListener);

        lblSerManager = new JLabel("   Service Manager");
        lblSerManager.setPreferredSize(new Dimension(76, 41));
		lblSerManager.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(Manager.class.getResource("../images/service.png"))));
        lblSerManager.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblSerManager.setCursor(new Cursor(Cursor.HAND_CURSOR));
        pnlSerManager.add(lblSerManager);
        lblSerManager.addMouseListener(mouseListener);

        lblHotelManager = new JLabel("   Hotel Manager");
        lblHotelManager.setPreferredSize(new Dimension(76, 41));
		lblHotelManager.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(Manager.class.getResource("../images/hotel.png"))));
        lblHotelManager.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblHotelManager.setCursor(new Cursor(Cursor.HAND_CURSOR));
        pnlHotelManager.add(lblHotelManager);
        lblHotelManager.addMouseListener(mouseListener);

        lblAccManager = new JLabel("   Account Manager");
        lblAccManager.setPreferredSize(new Dimension(76, 41));
		lblAccManager.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(Manager.class.getResource("../images/account.png"))));
        lblAccManager.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblAccManager.setCursor(new Cursor(Cursor.HAND_CURSOR));
        pnlAccManager.add(lblAccManager);
        lblAccManager.addMouseListener(mouseListener);

        lblStatistical = new JLabel("   Statistical");
        lblStatistical.setPreferredSize(new Dimension(76, 41));
		lblStatistical.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(Manager.class.getResource("../images/statistical.png"))));
        lblStatistical.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblStatistical.setCursor(new Cursor(Cursor.HAND_CURSOR));
        pnlStatistical.add(lblStatistical);
        lblStatistical.addMouseListener(mouseListener);

        lblExportExcel = new JLabel("   Excel");
        lblExportExcel.setPreferredSize(new Dimension(76, 41));
		lblExportExcel.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(Manager.class.getResource("../images/excel.png"))));
        lblExportExcel.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblExportExcel.setCursor(new Cursor(Cursor.HAND_CURSOR));
        pnlExportExcel.add(lblExportExcel);
        lblExportExcel.addMouseListener(mouseListener);
		
		/* 
		Create pnlMainContent to contain pnlTourContent, pnlCusContent, pnlStaffContent, pnlBillContent,
		pnlSerContent, pnlHotelContent, pnlVehContent, pnlAccContent, pnlStatisticalContent
		*/
        pnlMainContent = new JPanel();
        pnlContent.add(pnlMainContent, BorderLayout.CENTER);
        pnlMainContent.setLayout(new CardLayout(0, 0));


        // ------------------------------ Tạo form quản lý tour ------------------------------
        pnlTourContent = new TourContent();
        pnlMainContent.add(pnlTourContent, "pnlTourContent");

        // ------------------------------ Tạo form quản lý khách hàng ------------------------------
        pnlCusContent = new CusContent();
        pnlMainContent.add(pnlCusContent, "pnlCusContent");

        // ------------------------------ Tạo form quản lý địa điểm du lịch ------------------------------
        pnlDesContent = new DesContent();
        pnlMainContent.add(pnlDesContent, "pnlDesContent");

        // ------------------------------ Tạo form quản lý hóa đơn ------------------------------
        pnlBillContent = new BillContent();
        pnlMainContent.add(pnlBillContent, "pnlBillContent");

        // ------------------------------ Tạo form quản lý dịch vụ ------------------------------
        pnlSerContent = new SerContent();
        pnlMainContent.add(pnlSerContent, "pnlSerContent");

        // ------------------------------ Tạo form quản lý khách sạn ------------------------------
        pnlHotelContent = new HotelContent();
        pnlMainContent.add(pnlHotelContent, "pnlHotelContent");

        // ------------------------------ Tạo form quản lý tài khoản ------------------------------
        pnlAccContent = new AccContent();
        pnlMainContent.add(pnlAccContent,"pnlAccContent");

        // ------------------------------ Tạo form báo cáo thống kê ------------------------------
        pnlStatisticalContent = new StatisticsContent();
        pnlMainContent.add(pnlStatisticalContent, "pnlStatisticalContent");

        // ------------------------------ Tạo form nhập xuất excel ------------------------------
        pnlExportExcelContent = new ExcelContent();
        pnlMainContent.add(pnlExportExcelContent, "pnlExportExcelContent");


    }

    public void ChangeForm() {
        cardLayout = (CardLayout) (pnlMainContent.getLayout());
    }


    // ZoomOutMenu function to make hidden pnlMenuDetail
    public void ZoomOutMenu() {
        MouseListener mouseListener = new ManagerControl(this);
        lblIconZoomIn = new JLabel("", JLabel.CENTER);
        lblIconZoomIn.setToolTipText("Show Menu");
        lblIconZoomIn.setBounds(0, 0, 50, 33);
		lblIconZoomIn.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(Manager.class.getResource("../images/zoomin.png"))));
        lblIconZoomIn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        lblIconZoomIn.addMouseListener(mouseListener);
        pnlZoom.add(lblIconZoomIn);
        pnlMenuDetail.setVisible(false);
        lblIconZoomOut.setVisible(false);
        lblIconZoomIn.setVisible(true);
    }

    // ZoomInMenu function to make show pnlMenuDetail
    public void ZoomInMenu() {
        pnlMenuDetail.setVisible(true);
        lblIconZoomOut.setVisible(true);
        lblIconZoomIn.setVisible(false);
    }

    public void addPlaceholderStyle(JTextField jTextField) {
        Font font = jTextField.getFont();
        font = font.deriveFont(Font.ITALIC);
        jTextField.setFont(font);
        jTextField.setForeground(Color.gray);
    }

    public void removePlaceholderStyle(JTextField jTextField) {
        Font font = jTextField.getFont();
        font = font.deriveFont(Font.PLAIN | Font.BOLD);
        jTextField.setFont(font);
        jTextField.setForeground(Color.black);
    }

    private void close() {
        this.dispose();
    }


}
