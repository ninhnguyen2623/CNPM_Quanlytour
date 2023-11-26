package GUI;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.BoxLayout;
import java.awt.Dimension;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.DefaultComboBoxModel;
import java.awt.Cursor;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.CellType;

import com.google.protobuf.TextFormat.ParseException;
import com.toedter.calendar.JDateChooser;

import BUS.BookingBUS;
import BUS.CustomerBUS;
import BUS.TourBUS;
import DAO.BookingDAO;
import DAO.CustomerDAO;
import DAO.TourDAO;
import DTO.BookingDTO;
import DTO.CustomerDTO;
import DTO.TourDTO;

import javax.swing.border.EtchedBorder;
import java.awt.Color;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import java.awt.CardLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class StatisticsContent extends JPanel {

	private JPanel pnlTitle_StatisticList;
//	private JButton btnStatisticBooking;
//	private JButton btnStatisticTour;
//	private JButton btnStatisticCustomer;
	private JPanel pnlStatisticContent;
	private JPanel pnlStatisticsBy;
	private JPanel panel_4;
	private JPanel panel_4_1;
	private JLabel lblBy;
	private JRadioButton rdbtnByYear_Booking;
	private JLabel lblNewLabel_4;
	private JRadioButton rdbtnByMonth_Booking;
	private JPanel panel_5;
	private JPanel panel_5_2;
	private JPanel panel_5_1;
	private JLabel lblSelectMonth;
	private JComboBox cbxMonth_Booking;
	private JLabel lblSelectYear;
	private JLabel lblNewLabel_3;
	private JPanel panel_6;
	private JButton btnShowChart_Booking;
	private JButton btnShowExcel;
	private JPanel pnlDetailBookingList;
	private JComboBox cbxYear_Booking;
	private JPanel pnlTourList;
	private JPanel pnlBookingList;
	private JPanel pnlCustomerList;
	private JScrollPane scrollPane_1;
	private JScrollPane scrollPane_2;
	private JScrollPane scrollPane_3;
	private JTable BookingTable;
	private JTable TourTable;

	private JPanel pnlBookingStatistical;
//	private JPanel pnlTourStatistical;
//	private JPanel pnlCusStatistical;
	private JButton btnView_Booking;
	private JButton btnView_date;
	private JButton btnView_price_date;
//	private JRadioButton rdbtnByYear_Tour;
//	private JRadioButton rdbtnByMonth_Tour;
//	private JComboBox cbxMonth_Tour;
//	private JComboBox cbxYear_Tour;
//	private JButton btnShowChart_Tour;
//	private JButton btnView_Tour;
//	private JPanel pnlDetailTourList;
//	private JRadioButton rdbtnByYear_Cus;
//	private JRadioButton rdbtnByMonth_Cus;
//	private JComboBox cbxMonth_Cus;
//	private JComboBox cbxYear_Cus;
//	private JButton btnShowChart_Cus;
//	private JButton btnView_Cus;
	private JPanel pnlDetailCusList;
//	private JTable CusTable;
	private JDateChooser OldBookingstart;
	private JDateChooser OldBookingend;
	
	private CardLayout cardLayoutPnlContent;
	private JPanel panel;
	private JPanel panel_1;
	private JPanel panel_2;
	private JPanel panel_7;
	private JPanel panel_8;
	private JLabel lblsumprice;
	private JTextField txtprice;
	private JPanel pnlsumprice;
	private JLabel lblNewLabel;
	private JPanel pnlTitle;
	private JPanel pnlBtnStatictical;
	private JLabel lblNewLabel_1;
	private JPanel panel_3;
	public JPanel getPnlStatisticContent() {
		return pnlStatisticContent;
	}

	public void setPnlStatisticContent(JPanel pnlStatisticContent) {
		this.pnlStatisticContent = pnlStatisticContent;
	}

	public JPanel getPnlBookingList() {
		return pnlBookingList;
	}

	public void setPnlBookingList(JPanel pnlBookingList) {
		this.pnlBookingList = pnlBookingList;
	}

	public JPanel getPnlTourList() {
		return pnlTourList;
	}

	public void setPnlTourList(JPanel pnlTourList) {
		this.pnlTourList = pnlTourList;
	}

	public JPanel getPnlCustomerList() {
		return pnlCustomerList;
	}

	public void setPnlCustomerList(JPanel pnlCustomerList) {
		this.pnlCustomerList = pnlCustomerList;
	}


	public StatisticsContent() {
        init();     
    }
	
	public void init() {
		
		setLayout(new BorderLayout(0, 0));
		
		pnlTitle_StatisticList = new JPanel();
		pnlTitle_StatisticList.setPreferredSize(new Dimension(10, 80));
		add(pnlTitle_StatisticList, BorderLayout.NORTH);
		pnlTitle_StatisticList.setLayout(new BorderLayout(0, 0));
		
		pnlTitle = new JPanel();
		pnlTitle.setPreferredSize(new Dimension(10, 60));
		pnlTitle_StatisticList.add(pnlTitle, BorderLayout.NORTH);
		
		lblNewLabel_1 = new JLabel("Statistic Booking");
		lblNewLabel_1.setPreferredSize(new Dimension(250, 50));
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		pnlTitle.add(lblNewLabel_1);
		
		pnlBtnStatictical = new JPanel();
		pnlTitle_StatisticList.add(pnlBtnStatictical);
		pnlBtnStatictical.setLayout(new BoxLayout(pnlBtnStatictical, BoxLayout.X_AXIS));
		
		
		panel_7 = new JPanel();
		panel_7.setPreferredSize(new Dimension(550, 10));
		pnlBtnStatictical.add(panel_7);
		
		pnlStatisticContent = new JPanel();
		add(pnlStatisticContent, BorderLayout.CENTER);
		pnlStatisticContent.setLayout(new CardLayout(0, 0));
		
		pnlBookingStatistical = new JPanel();
		pnlStatisticContent.add(pnlBookingStatistical, "pnlBookingStatistical");
		pnlBookingStatistical.setLayout(new BorderLayout(0, 0));
		
		
		pnlStatisticsBy = new JPanel();
		pnlStatisticsBy.setPreferredSize(new Dimension(50, 150));
		pnlBookingStatistical.add(pnlStatisticsBy, BorderLayout.NORTH);
		pnlStatisticsBy.setLayout(new BorderLayout(0, 0));
		
		panel_4 = new JPanel();
		panel_4.setPreferredSize(new Dimension(10, 37));
		pnlStatisticsBy.add(panel_4, BorderLayout.NORTH);
		panel_4.setLayout(new BoxLayout(panel_4, BoxLayout.X_AXIS));
		
		lblBy = new JLabel("Statistics Booking By price             ");
		panel_4.add(lblBy);
		
		cbxMonth_Booking = new JComboBox();
		cbxMonth_Booking.setModel(new DefaultComboBoxModel(new String[] {"0","1.000.000,00","2.000.000,00","3.000.000,00","4.000.000,00","5.000.000,00","6.000.000,00","7.000.000,00","8.000.000,00","9.000.000,00","10.000.000,00","20.000.000,00","30.000.000,00","40.000.000,00","50.000.000,00"}));
		panel_4.add(cbxMonth_Booking);
		
		
		lblNewLabel_4 = new JLabel("             ");
		panel_4.add(lblNewLabel_4);
		
		cbxYear_Booking = new JComboBox();
		cbxYear_Booking.setModel(new DefaultComboBoxModel(new String[] {"1.000.000,00","2.000.000,00","3.000.000,00","4.000.000,00","5.000.000,00","6.000.000,00","7.000.000,00","8.000.000,00","9.000.000,00","10.000.000,00","20.000.000,00","30.000.000,00","40.000.000,00","50.000.000,00","60.000.000,00"}));
		panel_4.add(cbxYear_Booking);
		
		
		panel_5 = new JPanel();
		panel_5.setPreferredSize(new Dimension(10, 20));
		pnlStatisticsBy.add(panel_5, BorderLayout.CENTER);
		panel_5.setLayout(new BoxLayout(panel_5, BoxLayout.X_AXIS));
		
		lblSelectMonth = new JLabel("Select Day Start         ");
		panel_5.add(lblSelectMonth);
		
		OldBookingstart = new JDateChooser();
		OldBookingstart.setPreferredSize(new Dimension(225, 25));
		panel_5.add(OldBookingstart);
		
		
		lblSelectYear = new JLabel("                    Select Day End            ");
		panel_5.add(lblSelectYear);
		
		OldBookingend = new JDateChooser();
		OldBookingend.setPreferredSize(new Dimension(225, 25));
		panel_5.add(OldBookingend);
		
		
		lblNewLabel = new JLabel("");
		lblNewLabel.setPreferredSize(new Dimension(92, 14));
		panel_5.add(lblNewLabel);
		
		panel_6 = new JPanel();
		panel_6.setPreferredSize(new Dimension(10, 60));
		pnlStatisticsBy.add(panel_6, BorderLayout.SOUTH);
		panel_6.setLayout(new BoxLayout(panel_6, BoxLayout.X_AXIS));
		
		
		
		
		btnShowChart_Booking = new JButton("Chart Booking");
		btnShowChart_Booking.addActionListener(new ActionListener() {
			private String[] items16;

			public void actionPerformed(ActionEvent e) {
				ChartBooking Chart_Booking = new ChartBooking();
				ChartTour dfdf  = new ChartTour();
				dfdf.main(items16);
//				Chart_Booking.main(items16);
			}
		});
		btnShowChart_Booking.setContentAreaFilled(false);
		btnShowChart_Booking.setFocusPainted(false);
		btnShowChart_Booking.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		panel_6.add(btnShowChart_Booking);
		
		btnView_Booking = new JButton("statistics price");

		btnView_Booking.setContentAreaFilled(false);

		btnView_Booking.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		    	
		    	
		    	String startprice = (String) cbxMonth_Booking.getSelectedItem();
		    	String endprice = (String) cbxYear_Booking.getSelectedItem();
		    	String formattedNumber1 = startprice.replaceAll("[^0-9,]", "").replaceAll("\\.", "").replace(",", ".");
		    	String formattedNumber2 = endprice.replaceAll("[^0-9,]", "").replaceAll("\\.", "").replace(",", ".");
//		    	System.out.println(Double.parseDouble(startprice));
		    	DefaultTableModel model = new DefaultTableModel();
		    	model.addColumn("ID");
		    	model.addColumn("Tour");
		    	model.addColumn("Customer");
		    	model.addColumn("Customer Number");
		    	model.addColumn("Total Price");
		    	model.addColumn("Create_At");
		    	
		    	if(Double.parseDouble(formattedNumber1) > Double.parseDouble(formattedNumber2)) {
		    		 JOptionPane.showMessageDialog(null, "giá bắt đầu phải nhỏ hơn giá kết thúc !");
		    		 return;
		    	}
		    	if(Double.parseDouble(formattedNumber1) <= Double.parseDouble(formattedNumber2)) {
		    		Boolean checkkqBoolean = false;
			    	ArrayList<BookingDTO> data = BookingDAO.getInstance().getAll();
		                TourBUS tourbs = new TourBUS();
		                CustomerBUS cusbs = new CustomerBUS();
		                	Double sumpce = .0;
		                for(BookingDTO BookingDTO: data) {
	                        Double stprice = BookingDTO.getTotal_cost();
	                        if(stprice >= Double.parseDouble(formattedNumber1) && stprice <= Double.parseDouble(formattedNumber2) ) { 
	                        	String formatpricce = String.format("%,.2f", BookingDTO.getTotal_cost());
	                        	model.addRow(new Object[] {
	                        			BookingDTO.getBooking_id(),BookingDTO.getTour_id() + "-" + tourbs.getById(BookingDTO.getTour_id()).getTour_name(),BookingDTO.getCustomer_id() + "-" + cusbs.getById(BookingDTO.getCustomer_id()).getCustomer_name(),BookingDTO.getCustomer_number(),formatpricce+" đ",BookingDTO.getCreate_at()
	                        	});
	                        	checkkqBoolean = true;
	                        	sumpce = sumpce + BookingDTO.getTotal_cost();
	                        }
		                }	
//		                System.out.println(sumpce);
		                txtprice.setText(String.format("%,.2f", sumpce)+" đ");
		                if(checkkqBoolean == false) {
		                	
		                	 JOptionPane.showMessageDialog(null, "không có bill trong khoảng giá này !");
			                    DefaultTableModel model2 = (DefaultTableModel) BookingTable.getModel();
			                    while (model2.getRowCount() > 0) {
			                        model2.removeRow(0);
			                    }
			                    txtprice.setText(" ");
			                    return;
		                }
		    	}
		    	BookingTable = new JTable();
	            BookingTable.setModel(model);
	            scrollPane_1.setViewportView(BookingTable);
		    	
	         
		    }
		});

		btnView_Booking.setFocusPainted(false);
		panel_6.add(btnView_Booking);
		
		
		
		
		btnView_date = new JButton("statistics date");
		btnView_date.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Date startdt = OldBookingstart.getDate();
				Date enddt = OldBookingend.getDate();
				
				 ArrayList<BookingDTO> data = BookingDAO.getInstance().getAll();
	                
	                DefaultTableModel model = new DefaultTableModel();
	                model.addColumn("ID");
	                model.addColumn("Tour");
	                model.addColumn("Customer");
	                model.addColumn("Customer Number");
	                model.addColumn("Total Price");
	                model.addColumn("Create_At");
	                boolean checkdate = false;
	                Double sumpce = .0;
	            if(startdt == null || enddt == null) {
	            	JOptionPane.showMessageDialog(null, "ngày không được để trống !");
					return;
	            }
	            else if(startdt.after(enddt)) {
					JOptionPane.showMessageDialog(null, "ngày bắt đầu phải nhỏ hơn ngày kết thúc !");
					return;
				}
				if(startdt.before(enddt)) {
					TourBUS tourbs = new TourBUS();
	                CustomerBUS cusbs = new CustomerBUS();
					 for(BookingDTO BookingDTO: data) {
	                        String date2 = BookingDTO.getCreate_at();
	                        SimpleDateFormat formatter4 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	                        Date date4;
	                        String formatpricce = String.format("%,.2f", BookingDTO.getTotal_cost());
							try {
								date4 = formatter4.parse(date2);
								if(date4.after(startdt) && date4.before(enddt)) { 
		                        	model.addRow(new Object[] {
		                        			BookingDTO.getBooking_id(),BookingDTO.getTour_id() + "-" + tourbs.getById(BookingDTO.getTour_id()).getTour_name(),BookingDTO.getCustomer_id() + "-" + cusbs.getById(BookingDTO.getCustomer_id()).getCustomer_name(),BookingDTO.getCustomer_number(),formatpricce+" đ",BookingDTO.getCreate_at()
		                        	});
		                        	checkdate = true;
		                        	sumpce = sumpce + BookingDTO.getTotal_cost();
		                        }
								
							} catch (java.text.ParseException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}	                        
	                }
					 txtprice.setText(String.format("%,.2f", sumpce)+" đ");
					 if(checkdate == false) {
	                	 JOptionPane.showMessageDialog(null, "không có bill trong khoảng ngày này !");
		                    DefaultTableModel model2 = (DefaultTableModel) BookingTable.getModel();
		                    while (model2.getRowCount() > 0) {
		                        model2.removeRow(0);
		                    }
		                    txtprice.setText(" ");
		                    return;
	                }
				}
				BookingTable = new JTable();
	            BookingTable.setModel(model);
	            scrollPane_1.setViewportView(BookingTable);
				
				
//		
			}
		});

		btnView_date.setContentAreaFilled(false);
		panel_6.add(btnView_date);
		
		btnView_price_date = new JButton("statistics Price and Date");
		btnView_price_date.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String startprice = (String) cbxMonth_Booking.getSelectedItem();
		    	String endprice = (String) cbxYear_Booking.getSelectedItem();
		    	String formattedNumber1 = startprice.replaceAll("[^0-9,]", "").replaceAll("\\.", "").replace(",", ".");
		    	String formattedNumber2 = endprice.replaceAll("[^0-9,]", "").replaceAll("\\.", "").replace(",", ".");
		    	Date startdt = OldBookingstart.getDate();
				Date enddt = OldBookingend.getDate();
//		    	System.out.println(Double.parseDouble(startprice));
		    	DefaultTableModel model = new DefaultTableModel();
		    	model.addColumn("ID");
		    	model.addColumn("Tour ");
		    	model.addColumn("Customer");
		    	model.addColumn("Customer Number");
		    	model.addColumn("Total Price");
		    	model.addColumn("Create_At");
		    	 Double sumpce = .0;
		    	if(Double.parseDouble(formattedNumber1) > Double.parseDouble(formattedNumber2) && startdt.after(enddt) && startdt == null || enddt == null) {
		    		 JOptionPane.showMessageDialog(null, "giá bắt đầu phải nhỏ hơn giá kết thúc và ngày bắt đầu phải lớn hơn ngày kết thúc và ngày không được để trống !");
		    		 return;
		    	}
		    	if(Double.parseDouble(formattedNumber1) <= Double.parseDouble(formattedNumber2) && startdt.before(enddt)) {
		    		Boolean checkkqBoolean = false;
			    	ArrayList<BookingDTO> data = BookingDAO.getInstance().getAll();
		                TourBUS tourbs = new TourBUS();
		                CustomerBUS cusbs = new CustomerBUS();
		                boolean checkdate = false;
		                for(BookingDTO BookingDTO: data) {
		                	String date2 = BookingDTO.getCreate_at();
	                        SimpleDateFormat formatter4 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	                        Date date4;
	                        Double stprice = BookingDTO.getTotal_cost();
	                        String formatpricce = String.format("%,.2f", BookingDTO.getTotal_cost());
	                        try {
								date4 = formatter4.parse(date2);
								if(stprice >= Double.parseDouble(formattedNumber1) && stprice <= Double.parseDouble(formattedNumber2) && date4.after(startdt)  && date4.before(enddt)) { 
		                        	model.addRow(new Object[] {
		                        			BookingDTO.getBooking_id(),BookingDTO.getTour_id() + "-" + tourbs.getById(BookingDTO.getTour_id()).getTour_name(),BookingDTO.getCustomer_id() + "-" + cusbs.getById(BookingDTO.getCustomer_id()).getCustomer_name(),BookingDTO.getCustomer_number(),formatpricce +" đ",BookingDTO.getCreate_at()
		                        	});
		                        	checkdate = true;
		                        	checkkqBoolean = true;
		                        	sumpce = sumpce + BookingDTO.getTotal_cost();
		                        }
								
							} catch (java.text.ParseException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}	 
	                        
		                }	
		                txtprice.setText(String.format("%,.2f", sumpce)+" đ");
		                if(checkkqBoolean == false && checkdate == false) {
		                	 JOptionPane.showMessageDialog(null, "không có bill trong khoảng giá và ngày này !");
			                    DefaultTableModel model2 = (DefaultTableModel) BookingTable.getModel();
			                    while (model2.getRowCount() > 0) {
			                        model2.removeRow(0);
			                    }
			                    txtprice.setText(" ");
			                    return;
		                }
		    	}
		    	BookingTable = new JTable();
	            BookingTable.setModel(model);
	            scrollPane_1.setViewportView(BookingTable);
				
				
				
			}
		});

		btnView_price_date.setContentAreaFilled(false);
		panel_6.add(btnView_price_date);
		
		btnShowExcel = new JButton("Export excel");
		btnShowExcel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(BookingTable.getModel() == null) {
					JOptionPane.showMessageDialog(null, "vui lòng chọn thông tin thống kê trước khi xuất excel !");
					return;
				}
				 TableModel model2 = BookingTable.getModel();
	                ArrayList<Integer> arrayListIdtour = new ArrayList<>();
	                int rowCount = model2.getRowCount();
	                System.out.println(rowCount);
	                boolean checktable = true;
	                for (int row = 0; row < rowCount; row++) {  
	                	    int id = Integer.parseInt(model2.getValueAt(row, 0).toString());
	                	    arrayListIdtour.add(id);	
	                	    checktable = false;
//	                	    System.out.println(id);
	                }
	                
	                try {
	                
	                    JFileChooser jfile = new JFileChooser();
	                    jfile.setSelectedFile(new File("untitled.xls"));

	                    int seleted = jfile.showSaveDialog(jfile);

	                    if (seleted == JFileChooser.APPROVE_OPTION) {
	                        String FilePath = jfile.getSelectedFile().getPath();
	                        System.out.println(FilePath);

	                        HSSFWorkbook workbook = new HSSFWorkbook();
	                        HSSFSheet sheet = workbook.createSheet("account");
	                        BookingBUS bookingBUS = new BookingBUS();
	                        int rowPos = 0;
	                        HSSFRow row = sheet.createRow(rowPos);
	                        row.createCell(0, CellType.NUMERIC).setCellValue("Booking_Id");
	                        row.createCell(1, CellType.STRING).setCellValue("Tour");
	                        row.createCell(2, CellType.STRING).setCellValue("Customer");
	                        row.createCell(3, CellType.STRING).setCellValue("Customer_number");
	                        row.createCell(4, CellType.STRING).setCellValue("Total_cost");
	                        row.createCell(5, CellType.STRING).setCellValue("Create_at");
	                        TourBUS tourbs = new TourBUS();
	                        CustomerBUS cusbs = new CustomerBUS();
	                        for (int a: arrayListIdtour) {
	                        	BookingDTO jejejr = bookingBUS.getById(a);
	                        	rowPos++;
	                        	row = sheet.createRow(rowPos);
	                            row.createCell(0, CellType.NUMERIC).setCellValue(jejejr.getBooking_id());
	                            row.createCell(1, CellType.STRING).setCellValue(jejejr.getTour_id()+"-"+tourbs.getById(jejejr.getTour_id()).getTour_name());
	                            row.createCell(2, CellType.STRING).setCellValue(jejejr.getCustomer_id()+"-"+cusbs.getById(jejejr.getCustomer_id()).getCustomer_name());
	                            row.createCell(3, CellType.STRING).setCellValue(jejejr.getCustomer_number());
	                            row.createCell(4, CellType.STRING).setCellValue(String.format("%,.2f", jejejr.getTotal_cost())+" đ");
	                            row.createCell(5, CellType.STRING).setCellValue(jejejr.getCreate_at().toString());
	                        }
	                        File file = new File(FilePath);
	                        try {
	                            FileOutputStream fos = new FileOutputStream(file);
	                            workbook.write(fos);
	                            fos.close();

	                        } catch (Exception ex) {
	                            System.out.println("GUI.Table.jButton1MouseClicked()");
	                        }

	                    }
	                    if (seleted == JFileChooser.CANCEL_OPTION) {
	                    }

	                } catch (Exception ex) {
	                }
	                
	                
	                
			}
		});

		btnShowExcel.setContentAreaFilled(false);
		panel_6.add(btnShowExcel);
		
		
		pnlDetailBookingList = new JPanel();
		pnlDetailBookingList.setLayout(new CardLayout(0, 0));
		pnlDetailBookingList.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Detail List", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		pnlBookingStatistical.add(pnlDetailBookingList, BorderLayout.CENTER);
		
		scrollPane_1 = new JScrollPane();
		pnlDetailBookingList.add(scrollPane_1, BorderLayout.CENTER);
		
		panel_8 = new JPanel();
		panel_8.setPreferredSize(new Dimension(10, 40));
		pnlBookingStatistical.add(panel_8,BorderLayout.SOUTH);
//		panel_8.setLayout(new BoxLayout(panel_8, BoxLayout.));
		
		lblsumprice = new JLabel("Sum price is:            ");
		panel_8.add(lblsumprice);
		
		 txtprice = new JTextField();
		 txtprice.setPreferredSize(new Dimension(100, 25));
		 panel_8.add(txtprice);
		 txtprice.setColumns(20);
		
		
		cardLayoutPnlContent =  (CardLayout)(this.getPnlStatisticContent().getLayout());
		
		panel = new JPanel();
		panel.setPreferredSize(new Dimension(10, 50));
		add(panel, BorderLayout.SOUTH);
		
		panel_1 = new JPanel();
		panel_1.setPreferredSize(new Dimension(35, 10));
		add(panel_1, BorderLayout.WEST);
		
		panel_2 = new JPanel();
		panel_2.setPreferredSize(new Dimension(35, 10));
		add(panel_2, BorderLayout.EAST);
	
	}
	
	

}
