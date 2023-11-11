package GUI;

import BUS.HotelBUS;
import BUS.PlaceBUS;
import BUS.RegionBUS;
import BUS.TourBUS;
import BUS.VehicleBUS;
import DAO.HotelDAO;
import DTO.*;
import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import javax.swing.border.EtchedBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.text.Normalizer;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Objects;
import java.util.regex.Pattern;

public class TourContent extends JPanel{
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    private JPanel pnlTourContentTitle;
    private JLabel lblTourContentTitle;
    private CardLayout cardLayoutEdit_ListTourDetail;

    private JPanel pnlSearchTour;
    private JPanel pnlIconSrc_Txt;
    private JLabel lblSearchTour;
    private JTextField txtSearchTour;
    private JPanel panel;
    private JPanel panel_1;
    private JPanel panel_2;
    private JPanel panel_6;
    private JPanel pnlContentTourDetail;
    private JPanel pnlEdit_ListTour;
    private JPanel pnlbtnEdit_ListTour;
    private JButton btnListTour;
    private JPanel pnlEdit_ListTourDetail;
    private JPanel pnlListTour_Place;
    private JTable tourListTable;
    private JPanel pnlListPlace;

    private JScrollPane sclListPlace;
    private JTable placeListTable;
    private JButton btnUpdateTour;

    public JPanel getPnlEdit_ListTourDetail() {
        return pnlEdit_ListTourDetail;
    }
    private JPanel pnlEditTour;
    private JScrollPane scrollFillInforTour;
    private JPanel pnlFillTour;
    private JPanel pnlIdTour;
    private JLabel lblIdTour;
    private JTextField txtIdTour;
    private JPanel pnlNameTour;
    private JLabel lblNameTour;
    private JTextField txtNameTour;
    private JPanel pnlDesTour;
    private JLabel lblDesTour;
    private JComboBox cbxDesTour;
    private JPanel pnlVehicle;
    private JLabel lblVehicle;
    private JComboBox cbxVehicle;
    private JPanel pnlHotel;
    private JLabel lblHotel;
    private JComboBox cbxHotel;
    private JPanel pnlButtonTour;
    private JButton btnAddTour;
    private JButton btnDeleteTour;
    private JPanel pnlListTour;
    private JPanel panel_3;
    private JPanel panel_4;
    private JPanel panel_5;

    private JButton btnEditTour;

    private JPanel pnlPriceTour;
    private JPanel pnlStartDay;
    private JPanel pnlEndDay;
    private JPanel pnlDepTour;
    private JLabel lblPriceTour;
    private JTextField txtPriceTour;
    private JLabel lblDepTour;
    private JDateChooser StartDay;
    private JLabel lblStartDay;
    private JLabel lblEndDay;
    private JDateChooser EndDay;

    private JButton btnRefreshTour;

    private JPanel pnlSchedule;
    private JLabel lblSchedule;
    private JTextField txtSchedule;

    private JComboBox cbxDepTour;

    private JScrollPane sclListTour;

    DefaultTableModel model_tour;
    DefaultTableModel model_place ;

    JTextField txtDesTour ;
    JButton btnDesTour ;
    ArrayList<JCheckBox> arrCheckBox = new ArrayList<>();
    ArrayList<String> arrPlaces = new ArrayList<>();
    JPanel pnlPlaceDetail = new JPanel();

    public TourContent() {
        setUpTable();
        init();
        loadTourData();
        btnInteract();
    }

    private void setUpTable() {

        model_place = new DefaultTableModel();
        model_place.addColumn("id");
        model_place.addColumn("Name");
        model_place.addColumn("Describe");
        model_place.addColumn("Address");
        model_place.addColumn("region");
    }

    private void init() {


    	setLayout(new BorderLayout(0, 0));

        // Tạo JPanel cho phần tiêu đề của quản lý tour
        pnlTourContentTitle = new JPanel();
        pnlTourContentTitle.setPreferredSize(new Dimension(10, 125));
        add(pnlTourContentTitle, BorderLayout.NORTH);
        pnlTourContentTitle.setLayout(new BorderLayout(0, 0));

        // Tạo JLabel với nhãn là Tour Manager
        lblTourContentTitle = new JLabel("Tour Manager");
        lblTourContentTitle.setPreferredSize(new Dimension(200, 50));
        lblTourContentTitle.setHorizontalAlignment(SwingConstants.CENTER);
        lblTourContentTitle.setFont(new Font("Times New Roman", Font.PLAIN, 24));
        pnlTourContentTitle.add(lblTourContentTitle, BorderLayout.NORTH);

        // Tạo JPanel search tour
        pnlSearchTour = new JPanel();
        pnlSearchTour.setPreferredSize(new Dimension(10, 60));
        pnlTourContentTitle.add(pnlSearchTour, BorderLayout.CENTER);
        pnlSearchTour.setLayout(new BorderLayout(0, 0));

        // Tạo pnlIconSrc_Txt để chứa thanh tìm kiếm và icon tìm kiếm
        pnlIconSrc_Txt = new JPanel();
        pnlSearchTour.add(pnlIconSrc_Txt, BorderLayout.CENTER);
        pnlIconSrc_Txt.setLayout(new BorderLayout(0, 0));

        // Tạo thanh tìm kiếm
        txtSearchTour = new JTextField();
        txtSearchTour.setText("Search Tour");
        pnlIconSrc_Txt.add(txtSearchTour, BorderLayout.CENTER);
        txtSearchTour.setMargin(new Insets(2, 10, 2, 10));
        txtSearchTour.addFocusListener(new FocusListener() {

			@Override
			public void focusLost(FocusEvent e) {
				Font font = txtSearchTour.getFont();
				font = font.deriveFont(Font.ITALIC);
				txtSearchTour.setFont(font);
				txtSearchTour.setForeground(Color.gray);
				txtSearchTour.setText("Search Tour");
			}

			@Override
			public void focusGained(FocusEvent e) {
				txtSearchTour.setText(null);
				txtSearchTour.requestFocus();;
//				manager.removePlaceholderStyle(manager.getTxtSearchTour());
				Font font = txtSearchTour.getFont();
				font = font.deriveFont(Font.PLAIN|Font.BOLD);
				txtSearchTour.setFont(font);
				txtSearchTour.setForeground(Color.black);

			}
		});

        // Tạo icon tìm kiếm
        lblSearchTour = new JLabel();
        lblSearchTour.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
        pnlIconSrc_Txt.add(lblSearchTour, BorderLayout.EAST);
		lblSearchTour.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(Manager.class.getResource("../images/search.png"))));
        lblSearchTour.setCursor(new Cursor(Cursor.HAND_CURSOR));

        // Các JPanel này để căn chỉnh phần pnlIconSrc_Txt ở giữa
        panel = new JPanel();
        panel.setPreferredSize(new Dimension(10, 20));
        pnlSearchTour.add(panel, BorderLayout.NORTH);

        panel_1 = new JPanel();
        panel_1.setPreferredSize(new Dimension(10, 20));
        pnlSearchTour.add(panel_1, BorderLayout.SOUTH);

        panel_2 = new JPanel();
        panel_2.setPreferredSize(new Dimension(250, 10));
        pnlSearchTour.add(panel_2, BorderLayout.EAST);

        panel_6 = new JPanel();
        panel_6.setPreferredSize(new Dimension(250, 10));
        pnlSearchTour.add(panel_6, BorderLayout.WEST);


        pnlContentTourDetail = new JPanel();
        add(pnlContentTourDetail, BorderLayout.CENTER);
        pnlContentTourDetail.setLayout(new BorderLayout(0, 0));

		/*
		Tạo pnlContentTourDetail phần này sẽ gồm:
		pnlbtnEdit_ListTour ở vị trí North chứa nút chuyển qua lại giữa phần nhập dữ liệu và danh sách
		pnlEdit_ListTour ở vị trí Center chứa phần nhập dữ liệu và danh sách,
		và pnlButtonTour ở vị trí South chứa các nút chức năng thêm, xóa, refesh
		*/
        pnlEdit_ListTour = new JPanel();
        pnlContentTourDetail.add(pnlEdit_ListTour, BorderLayout.CENTER);
        pnlEdit_ListTour.setLayout(new BorderLayout(0, 0));

        // Tạo pnlbtnEdit_ListTour cho quản lý tour phần này sẽ chứa nút Edit Tour và List Tour
        pnlbtnEdit_ListTour = new JPanel();
        pnlbtnEdit_ListTour.setPreferredSize(new Dimension(10, 50));
        pnlEdit_ListTour.add(pnlbtnEdit_ListTour, BorderLayout.NORTH);
        pnlbtnEdit_ListTour.setLayout(new BoxLayout(pnlbtnEdit_ListTour, BoxLayout.X_AXIS));
        // Tạo 2 nút Edit Tour và List Tour
        btnEditTour = new JButton("Edit Tour");
        btnEditTour.setContentAreaFilled(false);
        btnEditTour.setFocusPainted(false);
        btnEditTour.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        pnlbtnEdit_ListTour.add(btnEditTour);
        btnEditTour.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent pnlEditToure) {
                cardLayoutEdit_ListTourDetail.show(pnlEdit_ListTourDetail,"pnlEditTour");
            }
        });

        btnListTour = new JButton("List Tour");
        btnListTour.setContentAreaFilled(false);
        btnListTour.setFocusPainted(false);
        btnListTour.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        pnlbtnEdit_ListTour.add(btnListTour);
        btnListTour.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayoutEdit_ListTourDetail.show(pnlEdit_ListTourDetail,"pnlListTour");
            }
        });

        // Tạo pnlEdit_ListTourDetail cho quản lý tour phần này sẽ chứa phần nhập dữ liệu và danh sách
        pnlEdit_ListTourDetail = new JPanel();
        pnlEdit_ListTour.add(pnlEdit_ListTourDetail, BorderLayout.CENTER);
        pnlEdit_ListTourDetail.setLayout(new CardLayout(0, 0));

        // Tạo JPanel phần nhập liệu tour
        pnlEditTour = new JPanel();
        pnlEdit_ListTourDetail.add(pnlEditTour, "pnlEditTour");
        pnlEditTour.setLayout(new BorderLayout(0, 0));

        scrollFillInforTour = new JScrollPane();
        scrollFillInforTour.setBorder(new TitledBorder(null, "Edit Tour", TitledBorder.LEADING, TitledBorder.TOP, null, null));
        pnlEditTour.add(scrollFillInforTour, BorderLayout.CENTER);

        pnlFillTour = new JPanel();
        pnlFillTour.setBorder(null);
        scrollFillInforTour.setViewportView(pnlFillTour);
        pnlFillTour.setLayout(new GridLayout(5, 2, 0, 0));

        pnlIdTour = new JPanel();
        pnlIdTour.setPreferredSize(new Dimension(320, 35));
        pnlFillTour.add(pnlIdTour);
        pnlIdTour.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

        lblIdTour = new JLabel("ID");
        lblIdTour.setPreferredSize(new Dimension(125, 25));
        pnlIdTour.add(lblIdTour);

        txtIdTour = new JTextField();
        txtIdTour.setPreferredSize(new Dimension(100, 25));
        pnlIdTour.add(txtIdTour);
        txtIdTour.setColumns(15);

        pnlNameTour = new JPanel();
        pnlNameTour.setPreferredSize(new Dimension(320, 35));
        pnlFillTour.add(pnlNameTour);
        pnlNameTour.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

        lblNameTour = new JLabel("Name");
        lblNameTour.setPreferredSize(new Dimension(125, 25));
        pnlNameTour.add(lblNameTour);

        txtNameTour = new JTextField();
        txtNameTour.setPreferredSize(new Dimension(100, 25));
        txtNameTour.setColumns(15);
        pnlNameTour.add(txtNameTour);

        pnlDepTour = new JPanel();
        pnlFillTour.add(pnlDepTour);

        lblDepTour = new JLabel("Departure");
        lblDepTour.setPreferredSize(new Dimension(125, 25));
        pnlDepTour.add(lblDepTour);

        cbxDepTour = new JComboBox();
        cbxDepTour.setPreferredSize(new Dimension(166, 25));
        cbxDepTour.setFont(new Font("Times New Roman", Font.PLAIN, 12));
        cbxDepTour.setModel(new DefaultComboBoxModel(new String[] {"An Giang", "Bà Rịa-Vũng Tàu", "Bạc Liêu",
                "Bắc Kạn","Bắc Giang","Bắc Ninh","Bến Tre","Bình Dương","Bình Định","Bình Phước","Bình Thuận","Cà Mau",
                "Cao Bằng","Cần Thơ","Đà Nẵng","Đắk Lắk","Đắk Nông","Điện Biên","Đồng Nai","Đồng Tháp","Gia Lai",
                "Hà Giang","Hà Nam","Hà Nội","Hà Tây","Hà Tĩnh","Hải Dương","Hải Phòng","Hòa Bình","Hồ Chí Minh",
                "Hậu Giang","Hưng Yên","Khánh Hòa","Kiên Giang","Kon Tum","Lai Châu","Lào Cai","Lạng Sơn","Lâm Đồng",
                "Long An","Nam Định","Nghệ An","Ninh Bình","Ninh Thuận","Phú Thọ","Phú Yên","Quảng Bình","Quảng Nam",
                "Quảng Ngãi","Quảng Ninh","Quảng Trị","Sóc Trăng","Sơn La","Tây Ninh","Thái Bình","Thái Nguyên","Thanh Hóa",
                "Thừa Thiên - Huế","Tiền Giang","Trà Vinh","Tuyên Quang","Vĩnh Long","Vĩnh Phúc","Yên Bái"}));
        pnlDepTour.add(cbxDepTour);

        pnlDesTour = new JPanel();
        pnlDesTour.setPreferredSize(new Dimension(320, 35));
        pnlFillTour.add(pnlDesTour);
        pnlDesTour.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

        lblDesTour = new JLabel("Destination");
        lblDesTour.setPreferredSize(new Dimension(125, 25));
        pnlDesTour.add(lblDesTour);

        cbxDesTour = new JComboBox();
        cbxDesTour.setPreferredSize(new Dimension(100, 25));
        cbxDesTour.setFont(new Font("Times New Roman", Font.PLAIN, 12));

        txtDesTour = new JTextField();
        txtDesTour.setPreferredSize(new Dimension(90, 25));
        txtDesTour.setEditable(false);
//        txtDesTour.setColumns(15);
        pnlDesTour.add(txtDesTour);

        btnDesTour = new JButton("Places");
        btnDesTour.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        	}
        });
        btnDesTour.setFocusPainted(false);
        btnDesTour.setPreferredSize(new Dimension(75, 25));
        pnlDesTour.add(btnDesTour);

        pnlHotel = new JPanel();
        pnlHotel.setPreferredSize(new Dimension(320, 35));
        pnlFillTour.add(pnlHotel);
        pnlHotel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

        lblHotel = new JLabel("Hotel");
        lblHotel.setPreferredSize(new Dimension(125, 25));
        pnlHotel.add(lblHotel);

        cbxHotel = new JComboBox();
        cbxHotel.setPreferredSize(new Dimension(166, 25));
        cbxHotel.setFont(new Font("Times New Roman", Font.PLAIN, 12));
//        cbxHotel.setModel(new DefaultComboBoxModel(new String[] {"ádvcx", "ádasd", "xcv" , "xcva123"}));
//        cbxHotel.addItemListener(new ItemListener() {
//            @Override
//            public void itemStateChanged(ItemEvent e) {
//                System.out.println(cbxHotel.getSelectedItem());
//            }
//        });
        pnlHotel.add(cbxHotel);
        
        pnlVehicle = new JPanel();
        pnlVehicle.setPreferredSize(new Dimension(320, 35));
        pnlFillTour.add(pnlVehicle);
        pnlVehicle.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
        
        lblVehicle = new JLabel("Vehicle");
        lblVehicle.setPreferredSize(new Dimension(125, 25));
        pnlVehicle.add(lblVehicle);
        
        cbxVehicle = new JComboBox();
        cbxVehicle.setPreferredSize(new Dimension(166, 25));
        cbxVehicle.setFont(new Font("Times New Roman", Font.PLAIN, 12));
        pnlVehicle.add(cbxVehicle);
        
        pnlPriceTour = new JPanel();


        lblPriceTour = new JLabel("Price");
        lblPriceTour.setPreferredSize(new Dimension(125, 25));
        pnlPriceTour.add(lblPriceTour);

        txtPriceTour = new JTextField();
        txtPriceTour.setPreferredSize(new Dimension(100, 25));
        pnlPriceTour.add(txtPriceTour);
        txtPriceTour.setColumns(15);

        pnlStartDay = new JPanel();
        pnlFillTour.add(pnlStartDay);

        lblStartDay = new JLabel("Start day");
        lblStartDay.setPreferredSize(new Dimension(125, 25));
        pnlStartDay.add(lblStartDay);

        StartDay = new JDateChooser();
        StartDay.setPreferredSize(new Dimension(166, 25));
        pnlStartDay.add(StartDay);

        pnlEndDay = new JPanel();
        pnlFillTour.add(pnlEndDay);

        lblEndDay = new JLabel("End day");
        lblEndDay.setPreferredSize(new Dimension(125, 25));
        pnlEndDay.add(lblEndDay);

        EndDay = new JDateChooser();
        EndDay.setBorder(null);
        EndDay.setPreferredSize(new Dimension(166, 25));
        pnlEndDay.add(EndDay);

        pnlSchedule = new JPanel();
        pnlFillTour.add(pnlSchedule);
        pnlFillTour.add(pnlPriceTour);


        lblSchedule = new JLabel("Schedule describe");
        lblSchedule.setPreferredSize(new Dimension(125, 25));
        pnlSchedule.add(lblSchedule);

        txtSchedule = new JTextField();
        txtSchedule.setPreferredSize(new Dimension(100, 25));
        txtSchedule.setColumns(15);
        pnlSchedule.add(txtSchedule);

        // Tạo pnlButtonTour phần này sẽ chứa các nút chức năng
        pnlButtonTour = new JPanel();
        pnlButtonTour.setBorder(null);
        pnlButtonTour.setPreferredSize(new Dimension(10, 40));
        pnlEditTour.add(pnlButtonTour, BorderLayout.SOUTH);
        pnlButtonTour.setLayout(new FlowLayout(FlowLayout.CENTER, 40, 10));

        // Tạo nút thêm
        btnAddTour = new JButton("Add");
        btnAddTour.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        btnAddTour.setBackground(new Color(66, 165, 243));
        btnAddTour.setFocusPainted(false);
        btnAddTour.setPreferredSize(new Dimension(100, 25));
        pnlButtonTour.add(btnAddTour);

        // Tạo nút update
        btnUpdateTour = new JButton("Update");
        btnUpdateTour.setBackground(new Color(66, 165, 243));
        btnUpdateTour.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        btnUpdateTour.setFocusPainted(false);
        btnUpdateTour.setPreferredSize(new Dimension(100, 25));
        pnlButtonTour.add(btnUpdateTour);

        // Tạo nút xóa
        btnDeleteTour = new JButton("Delete");
        btnDeleteTour.setBackground(new Color(66, 165, 243));
        btnDeleteTour.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        btnDeleteTour.setFocusPainted(false);
        btnDeleteTour.setPreferredSize(new Dimension(100, 25));
        pnlButtonTour.add(btnDeleteTour);


        // Tạo nút refresh
        btnRefreshTour = new JButton("Refresh");
        btnRefreshTour.setBackground(new Color(66, 165, 243));
        btnRefreshTour.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        btnRefreshTour.setFocusPainted(false);
        btnRefreshTour.setPreferredSize(new Dimension(100, 25));
        pnlButtonTour.add(btnRefreshTour);

        // Tạo JPanel phần danh sách tour
        // Tạo pnlListTour_Place gồm pnlListTour ở vị trí Center và pnlListPlace ở vị trí South
        pnlListTour_Place = new JPanel();
        pnlListTour_Place.setBackground(new Color(240, 240, 240));
        pnlEdit_ListTourDetail.add(pnlListTour_Place, "pnlListTour");
        pnlListTour_Place.setLayout(new GridLayout(2, 1, 0, 30));

        // Tạo JPanel list Tour
        pnlListTour = new JPanel();
        pnlListTour.setBorder(new TitledBorder(null, "List Tour", TitledBorder.LEADING, TitledBorder.TOP, null, null));
        pnlListTour_Place.add(pnlListTour);
        pnlListTour.setLayout(new BorderLayout(0, 0));
        // Tạo Scroll cho list Tour
        sclListTour = new JScrollPane();
        pnlListTour.add(sclListTour);

//        String [] items4 = {"ID", "Name", "Hotel", "Price", "Start_day", "End_day", "Departure","Describe","create at"};

        tourListTable = new JTable();
        sclListTour.setViewportView(tourListTable);

        // Tạo JPanel list ser1
        pnlListPlace = new JPanel();
        pnlListTour_Place.add(pnlListPlace);
        pnlListPlace.setLayout(new BorderLayout(0, 0));

        sclListPlace = new JScrollPane();
        sclListPlace.setBorder(new TitledBorder(null, "Places of tour", TitledBorder.LEADING, TitledBorder.TOP, null, null));
        pnlListPlace.add(sclListPlace);


        placeListTable = new JTable();
        sclListPlace.setViewportView(placeListTable);

        // panel_3, panel_4, panel_5 này để căn chỉnh phần pnlEdit_ListTour đẹp hơn thôi
        panel_3 = new JPanel();
        panel_3.setPreferredSize(new Dimension(50, 10));
        pnlContentTourDetail.add(panel_3, BorderLayout.EAST);

        panel_4 = new JPanel();
        panel_4.setPreferredSize(new Dimension(50, 10));
        pnlContentTourDetail.add(panel_4, BorderLayout.WEST);

        panel_5 = new JPanel();
        panel_5.setPreferredSize(new Dimension(10, 60));
        pnlContentTourDetail.add(panel_5, BorderLayout.SOUTH);


        // ------------ Change Form -------------------- //

         cardLayoutEdit_ListTourDetail =  (CardLayout)(this.getPnlEdit_ListTourDetail().getLayout());
    }

    // load data from database
    private void loadTourData() {
        // load tour table
    	 model_tour = new DefaultTableModel();
         model_tour.addColumn("Id");
         model_tour.addColumn("Name");
         model_tour.addColumn("Hotel");
         model_tour.addColumn("Vehicle");
         model_tour.addColumn("Region");
         model_tour.addColumn("Price");
         model_tour.addColumn("Start_day");
         model_tour.addColumn("End_day");
         model_tour.addColumn("Departure");
         model_tour.addColumn("Descirbe");
         model_tour.addColumn("Create at");
        TourBUS tb = new TourBUS();
        ArrayList<TourDTO> tours = tb.getAll();
        String new_id = String.valueOf(tours.get(tours.size()-1).getTour_id()+1);
        txtIdTour.setText(new_id);
        for (TourDTO tour : tours) {
            model_tour.addRow(new Object[]{
                    tour.getTour_id(),
                    tour.getTour_name(),
                    tour.getHotel_id(),
                    tour.getVehicle_id(),
                    tour.getRegion_code(),
                    tour.getPrice(),
                    tour.getStart_day(),
                    tour.getEnd_day(),
                    tour.getDeparture_place(),
                    tour.getSchedule_describe(),
                    tour.getCreate_at()
            });
        }
        tourListTable.setModel(model_tour);

        // load combobox hotel
        DefaultComboBoxModel<String> model_hotel = new DefaultComboBoxModel<String>();
        HotelBUS ht = new HotelBUS();
        ArrayList<HotelDTO> hotels = ht.getAll();

        for (HotelDTO hotel : hotels) {
           model_hotel.addElement(hotel.getHotel_id() + "-" + hotel.getHotel_name());
        }
        cbxHotel.setModel(model_hotel);

        // load combobox region
        DefaultComboBoxModel<String> model_region = new DefaultComboBoxModel<String>();
        RegionBUS reg = new RegionBUS();
        ArrayList<RegionDTO> regions = reg.getAll();

        for (RegionDTO region : regions) {
            model_region.addElement(region.getRegion_code());
        }
        cbxDesTour.setModel(model_region);
        
        DefaultComboBoxModel<String> model_vehicle = new DefaultComboBoxModel<String>();
        VehicleBUS jj = new VehicleBUS();
        ArrayList<VehicleDTO> vehicledto = jj.getAll();
        for(VehicleDTO vvv: vehicledto) {
        	model_vehicle.addElement(vvv.getVehicle_id() + "-" + vvv.getTenxe()+"-"+vvv.getSuachua());
        }
        cbxVehicle.setModel(model_vehicle);
    }

    private void btnInteract() {
        tourListTable.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    tourListTableMouseClicked( e);
                } catch (ParseException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });

        btnAddTour.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    btnAddTourActionPerformed( e);
                } catch (ParseException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });

        btnUpdateTour.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                btnUpdateTourActionPerformed(e);
            }
        });

        btnDeleteTour.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                btnDeleteTourActionPerformed(e);
            }
        });

        btnRefreshTour.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                btnRefreshTourActionPerformed(e);
            }
        });
        
        
// place   ccccc
        
        btnDesTour.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                JPanel popup = new JPanel(new FlowLayout());
                popup.add(cbxDesTour);
                popup.add(new JLabel("Places:"));
                JScrollPane scrollPlaceName = new JScrollPane();
                scrollPlaceName.setPreferredSize(new Dimension(200, 125));
                scrollPlaceName.setViewportView(pnlPlaceDetail);
                pnlPlaceDetail.setLayout(new GridLayout(0, 1, 0, 0));
                popup.add(scrollPlaceName);
//                arrCheckBox.clear();

                // load data following region

                if (pnlPlaceDetail.getComponents().length == 0 ){
                    PlaceBUS pb = new PlaceBUS();
                    ArrayList<PlaceDTO> places = pb.getPlacesByRegionCode(Objects.requireNonNull(cbxDesTour.getSelectedItem()).toString());
                    for (PlaceDTO place : places) {
                        JCheckBox cb = new JCheckBox(place.getPlace_id() +"-" + place.getPlace_name());
                        arrCheckBox.add(cb);
                        pnlPlaceDetail.add(cb);
                    }
                }

                int result = JOptionPane.showConfirmDialog(null, popup, "Choose Places",
                        JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
                if (result == JOptionPane.OK_OPTION) {
//                	check region code hotel
                	String cbxregioncode = (String)cbxDesTour.getSelectedItem();
                	DefaultComboBoxModel<String> model_hotel = new DefaultComboBoxModel<String>();
                    HotelBUS ht = new HotelBUS();
                    ArrayList<HotelDTO> hotels = ht.getAll();

                    for (HotelDTO hotel : hotels) {
                    	if(hotel.getRegion_code().equals(cbxregioncode)){
                    		model_hotel.addElement(hotel.getHotel_id() + "-" + hotel.getHotel_name() +"-"+hotel.getRegion_code());
                    	}
                    }
                    cbxHotel.setModel(model_hotel);
                    System.out.println("ok");
                    arrPlaces.clear();
                    for (JCheckBox cb : arrCheckBox) {
                        if (cb.isSelected()){
                            arrPlaces.add(cb.getText().split("-")[0]);
                        }
                    }
                    txtDesTour.setText(String.join(",",arrPlaces));
                } else {
                    System.out.println("Cancelled");
                }
            }
        });
        
// region code 
        cbxDesTour.addItemListener(e1 -> {
            PlaceBUS pb1 = new PlaceBUS();
            arrCheckBox.clear();
            pnlPlaceDetail.removeAll();
            ArrayList<PlaceDTO> places1 = pb1.getPlacesByRegionCode(Objects.requireNonNull(cbxDesTour.getSelectedItem()).toString());
            for (PlaceDTO place : places1) {
                JCheckBox cb = new JCheckBox(place.getPlace_id()+"-"+ place.getPlace_name());
                arrCheckBox.add(cb);
                pnlPlaceDetail.add(cb);
            }
            pnlPlaceDetail.updateUI();
            TourBUS tb = new TourBUS();
            if (!txtIdTour.getText().equals("") && tb.checkExistById(Integer.parseInt(txtIdTour.getText()))) {
                ArrayList<PlaceDTO> placess = tb.getPlacesOfTour(Integer.parseInt(txtIdTour.getText()));
                for (JCheckBox cbx : arrCheckBox) {
                    for (PlaceDTO place : placess)
                        if (Objects.equals(cbx.getText(),place.getPlace_id() +"-"+place.getPlace_name())){
                            cbx.setSelected(true);
                            break;
                        }
                    System.out.println(cbx.isSelected());
                }
            }
        });


        lblSearchTour.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent me) {
                if (Objects.equals(txtSearchTour.getText(), "")) {
                    JOptionPane.showMessageDialog(null,"Ô tìm kiếm đang trống!!");
                    return;
                }
                String shString = txtSearchTour.getText().trim();
                TourBUS tb = new TourBUS();
                if(isNumeric(shString)) {
                    TourDTO tourdto= tb.getById(Integer.parseInt(shString.trim()));
                    if(tourdto != null) {
                        txtIdTour.setText( String.valueOf(tourdto.getTour_id()));
                        txtNameTour.setText(tourdto.getTour_name());
                        cbxDepTour.setSelectedItem(tourdto.getDeparture_place());
                        cbxDesTour.setSelectedItem(tourdto.getRegion_code());
                        VehicleBUS jjjjwrt = new VehicleBUS();
                        VehicleDTO vhhh = jjjjwrt.getById(tourdto.getVehicle_id());
//                        System.out.println(vhhh.toString());
                        cbxVehicle.setSelectedItem(vhhh.getVehicle_id() + "-" + vhhh.getTenxe()+"-"+vhhh.getSuachua());
                        HotelBUS hb = new HotelBUS();
                        HotelDTO hd = hb.getById(tourdto.getHotel_id() );
                        cbxHotel.setSelectedItem(hd.getHotel_id() + "-" + hd.getHotel_name());
                        String date = tourdto.getStart_day();
                        try {
                            StartDay.setDate(new SimpleDateFormat("yyyy-MM-dd").parse(date));
                        } catch (ParseException e) {
                            throw new RuntimeException(e);
                        }
                        date = tourdto.getEnd_day();
                        try {
                            EndDay.setDate(new SimpleDateFormat("yyyy-MM-dd").parse(date));
                        } catch (ParseException e) {
                            throw new RuntimeException(e);
                        }
                        txtSchedule.setText(tourdto.getSchedule_describe());
                        txtPriceTour.setText(String.valueOf(tourdto.getPrice()));
                    }
                    if(tourdto ==null) {
                        JOptionPane.showMessageDialog(null, "Không tìm thấy thông tin Tour !");
                    }
                }
                if (!isNumeric(shString)) {
                    ArrayList<TourDTO> tourdtos = tb.getAll();
                    boolean checkKQ = false;
                    for(TourDTO tourdto: tourdtos) {
                        String temp = Normalizer.normalize(tourdto.getTour_name(), Normalizer.Form.NFD);
                        String temp2 = Normalizer.normalize(shString, Normalizer.Form.NFD);
                        Pattern pattern = Pattern.compile("\\p{InCombiningDiacriticalMarks}+");
                        if(pattern.matcher(temp).replaceAll("").equalsIgnoreCase(pattern.matcher(temp2).replaceAll(""))) {
                            txtIdTour.setText( String.valueOf(tourdto.getTour_id()));
                            txtNameTour.setText(tourdto.getTour_name());
                            cbxDepTour.setSelectedItem(tourdto.getDeparture_place());
                            cbxDesTour.setSelectedItem(tourdto.getRegion_code());
                            HotelBUS hb = new HotelBUS();
                            HotelDTO hd = hb.getById(tourdto.getHotel_id() );
                            cbxHotel.setSelectedItem(hd.getHotel_id() + "-" + hd.getHotel_name());
                            String date = tourdto.getStart_day();
                            try {
                                StartDay.setDate(new SimpleDateFormat("yyyy-MM-dd").parse(date));
                            } catch (ParseException e) {
                                throw new RuntimeException(e);
                            }
                            date = tourdto.getEnd_day();
                            try {
                                EndDay.setDate(new SimpleDateFormat("yyyy-MM-dd").parse(date));
                            } catch (ParseException e) {
                                throw new RuntimeException(e);
                            }
                            txtSchedule.setText(tourdto.getSchedule_describe());
                            txtPriceTour.setText(String.valueOf(tourdto.getPrice()));
                            checkKQ = true;
                            break;
                        }
                    }
                    if(!checkKQ) {
                        JOptionPane.showMessageDialog(null, "Không tìm thấy thông tin Tour !");
                    }
                }
            }

        });

    }

    private void tourListTableMouseClicked(MouseEvent e) throws ParseException {

        // load Places of tour
        int row = tourListTable.getSelectedRow();
        // load form of Tour
        txtIdTour.setText(tourListTable.getValueAt(row,0).toString());
        txtNameTour.setText(tourListTable.getValueAt(row,1).toString());
        cbxDepTour.setSelectedItem(tourListTable.getValueAt(row,8));
        cbxDesTour.setSelectedItem(tourListTable.getValueAt(row,4));
        HotelBUS hb = new HotelBUS();
        HotelDTO hd = hb.getById(Integer.parseInt(tourListTable.getValueAt(row,2).toString()) );
        cbxHotel.setSelectedItem(hd.getHotel_id() + "-" + hd.getHotel_name());
        String date = tourListTable.getValueAt(row,6).toString();
        StartDay.setDate(new SimpleDateFormat("yyyy-MM-dd").parse(date));
        date = tourListTable.getValueAt(row,7).toString();
        EndDay.setDate(new SimpleDateFormat("yyyy-MM-dd").parse(date));
        txtSchedule.setText(tourListTable.getValueAt(row,9).toString());
        txtPriceTour.setText(tourListTable.getValueAt(row,5).toString());

        TourBUS tb = new TourBUS();
        ArrayList<PlaceDTO> places = tb.getPlacesOfTour(Integer.parseInt(tourListTable.getValueAt(row,0).toString()) );
        while (model_place.getRowCount() >= 1){
            model_place.removeRow(0);
        }
        for (PlaceDTO place : places) {
            model_place.addRow(new Object[]{
                    place.getPlace_id(),
                    place.getPlace_name(),
                    place.getPlace_describe(),
                    place.getPlace_address(),
                    place.getRegion_code()
            });
        }
        placeListTable.setModel(model_place);


    }

    private void btnAddTourActionPerformed(ActionEvent e) throws ParseException {
        if (StartDay.getDate() == null || EndDay.getDate() == null || EndDay.getDate().before(StartDay.getDate())) {
            JOptionPane.showMessageDialog(null,"Ngày khởi hành hoặc kết thúc không được để trống," +
                    " ngày kết thúc phải sau ngày khởi hành!!");
            return;
        }

        if (txtIdTour.getText() == "" || txtNameTour.getText() == "" || txtSchedule.getText() == "" || txtPriceTour.getText() == "" || !isNumeric(txtIdTour.getText()) || !isNumeric(txtPriceTour.getText()) || arrPlaces.size() ==0) {
            JOptionPane.showMessageDialog(null,"Dữ liệu không được để trống hoặc sai sót!!");
            return;
        }

        String id = txtIdTour.getText(),
                name = txtNameTour.getText(),
                dep = Objects.requireNonNull(cbxDepTour.getSelectedItem()).toString(),
                region = Objects.requireNonNull(cbxDesTour.getSelectedItem()).toString(),
                hotel = Objects.requireNonNull(cbxHotel.getSelectedItem()).toString(),
                Vehicle = Objects.requireNonNull(cbxVehicle.getSelectedItem()).toString(),
                startday = sdf.format(StartDay.getDate()),
                endday = sdf.format(EndDay.getDate()),
                desc =  txtSchedule.getText(),
                price = txtPriceTour.getText();

        TourDTO td = new TourDTO();
        td.setTour_id(Integer.parseInt(id));
        td.setTour_name(name);
        td.setDeparture_place(dep);
        td.setRegion_code(region);
        td.setHotel_id(Integer.parseInt(hotel.split("-")[0]));
        td.setVehicle_id(Integer.parseInt(Vehicle.split("-")[0]));
        td.setSchedule_describe(desc);
        td.setPrice(Double.parseDouble(price));
        td.setStart_day(startday);
        td.setEnd_day(endday);

        ArrayList<Tour_DetailDTO> tour_details = new ArrayList<>();
        for (String ap : arrPlaces) {
            Tour_DetailDTO tour_detail = new Tour_DetailDTO();
                tour_detail.setTour_id(Integer.parseInt(id));
                tour_detail.setPlace_id( Integer.parseInt(ap));
                tour_details.add(tour_detail);
        }
        System.out.println(arrPlaces);
        if (tour_details.isEmpty()) {
            JOptionPane.showMessageDialog(null,"Bạn chưa chọn địa điểm du lịch!!");
            return;
        }
        TourBUS tb = new TourBUS();
        JOptionPane.showMessageDialog(null,tb.add(td,tour_details));
        loadTourData();
    }

    private void btnUpdateTourActionPerformed(ActionEvent e) {
        if (StartDay.getDate() == null || EndDay.getDate() == null || EndDay.getDate().before(StartDay.getDate())) {
            JOptionPane.showMessageDialog(null,"Ngày khởi hành hoặc kết thúc không được để trống," +
                    " ngày kết thúc phải sau ngày khởi hành!!");
            return;
        }

        if ("".equals(txtIdTour.getText()) || "".equals(txtNameTour.getText()) || "".equals(txtSchedule.getText()) || "".equals(txtPriceTour.getText()) || !isNumeric(txtIdTour.getText()) || !isNumeric(txtPriceTour.getText()) || arrPlaces.isEmpty()) {
            JOptionPane.showMessageDialog(null,"Dữ liệu không được để trống hoặc sai sót!!");
            return;
        }

        String id = txtIdTour.getText(),
                name = txtNameTour.getText(),
                dep = Objects.requireNonNull(cbxDepTour.getSelectedItem()).toString(),
                region = Objects.requireNonNull(cbxDesTour.getSelectedItem()).toString(),
                hotel = Objects.requireNonNull(cbxHotel.getSelectedItem()).toString(),
                		Vehicle = Objects.requireNonNull(cbxHotel.getSelectedItem()).toString(),
                startday = sdf.format(StartDay.getDate()),
                endday = sdf.format(EndDay.getDate()),
                desc =  txtSchedule.getText(),
                price = txtPriceTour.getText();

        System.out.println(region);
        TourDTO td = new TourDTO();
        td.setTour_id(Integer.parseInt(id));
        td.setTour_name(name);
        td.setDeparture_place(dep);
        td.setRegion_code(region);
        td.setHotel_id(Integer.parseInt(hotel.split("-")[0]));
        td.setVehicle_id(Integer.parseInt(Vehicle.split("-")[0]));
        td.setSchedule_describe(desc);
        td.setPrice(Double.parseDouble(price));
        td.setStart_day(startday);
        td.setEnd_day(endday);

        ArrayList<Tour_DetailDTO> tour_details = new ArrayList<>();
        for (String ap : arrPlaces) {
            Tour_DetailDTO tour_detail = new Tour_DetailDTO();
            tour_detail.setTour_id(Integer.parseInt(id));
            tour_detail.setPlace_id( Integer.parseInt(ap));
            tour_details.add(tour_detail);
        }
        System.out.println(arrPlaces);
        if (tour_details.size() == 0) {
            JOptionPane.showMessageDialog(null,"Bạn chưa chọn địa điểm du lịch!!");
            return;
        }
        TourBUS tb = new TourBUS();
        JOptionPane.showMessageDialog(null,tb.update(td,tour_details));
        loadTourData();
    }

    private void btnDeleteTourActionPerformed(ActionEvent e) {
        if (txtIdTour.getText() == "" || !isNumeric(txtIdTour.getText())) {
            JOptionPane.showMessageDialog(null,"Id không được để trống và phải là số!!");
            return;
        }
        String id = txtIdTour.getText();


        TourBUS tb = new TourBUS();
        JOptionPane.showMessageDialog(null,tb.delete(Integer.parseInt(id)));
        loadTourData();
    }

    private void btnRefreshTourActionPerformed(ActionEvent e) {
        while (model_tour.getRowCount() >= 1){
            model_tour.removeRow(0);
        }
        tourListTable.setModel(model_tour);
        loadTourData();
        txtDesTour.setText("");
        txtPriceTour.setText("");
        txtNameTour.setText("");
        txtSchedule.setText("");
    }


    private boolean isNumeric(String strNum) {
        Pattern pattern = Pattern.compile("-?\\d+(\\.\\d+)?");
        if (strNum == null) {
            return false;
        }
        return pattern.matcher(strNum).matches();
    }
}
