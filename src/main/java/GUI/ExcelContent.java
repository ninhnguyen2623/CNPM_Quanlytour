package GUI;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileFilter;
import javax.swing.table.DefaultTableModel;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.FormulaEvaluator;
import org.apache.poi.ss.usermodel.Row;

import BUS.BookingBUS;
import BUS.CustomerBUS;
import BUS.TourBUS;
import DAO.BookingDAO;
import DAO.CustomerDAO;
import DAO.TourDAO;
import DTO.BookingDTO;
import DTO.CustomerDTO;
import DTO.TourDTO;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.JFileChooser;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.FlowLayout;
import javax.swing.border.TitledBorder;

public class ExcelContent extends JPanel{
	private JTable table_thongke;
	private JPanel pnlStatisticalTour;
	private JLabel lblTitle;
	private JPanel pnlFunc;
	private JPanel pnlFunc1;
	private JPanel pnlFunc2;
	private JPanel pnlFunc3;
	private JPanel pnlList;
	private JScrollPane scrollPane_1;
	private JButton btntkbooking;
	private JButton btnexcelbooking;
	private JButton btnexportbooking;
	private JButton btntktour;
	private JButton btnexceltour;
	private JButton btnexporttour;
	private JButton btntkcustomer;
	private JButton btnexcelcustomer;
	private JButton btnexportcustomer;
	private JPanel panel;
	private JPanel panel_1;
	private JPanel panel_2;
	
	public ExcelContent() {
		setLayout(new BorderLayout(0, 0));
				
		pnlStatisticalTour = new JPanel();
		pnlStatisticalTour.setPreferredSize(new Dimension(10, 80));
		pnlStatisticalTour.setBackground(new Color(240, 240, 240));
		add(pnlStatisticalTour, BorderLayout.NORTH);
		
		lblTitle = new JLabel("Excel");
		lblTitle.setPreferredSize(new Dimension(70, 50));
		lblTitle.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		pnlStatisticalTour.add(lblTitle);
		
		pnlFunc = new JPanel();
		pnlFunc.setBackground(new Color(240, 240, 240));
		add(pnlFunc, BorderLayout.CENTER);
		pnlFunc.setLayout(new GridLayout(0, 3, 0, 0));
		
		pnlFunc1 = new JPanel();
		pnlFunc1.setBackground(new Color(240, 240, 240));
		pnlFunc.add(pnlFunc1);
		
		pnlFunc2 = new JPanel();
		pnlFunc2.setBackground(new Color(240, 240, 240));
		pnlFunc.add(pnlFunc2);
		
		pnlFunc3 = new JPanel();
		pnlFunc3.setBackground(new Color(240, 240, 240));
		pnlFunc.add(pnlFunc3);

		pnlList = new JPanel();
		pnlList.setBackground(new Color(240, 240, 240));
		pnlList.setPreferredSize(new Dimension(10, 400));
		add(pnlList, BorderLayout.SOUTH);
		pnlList.setLayout(new BorderLayout(0, 0));

		scrollPane_1 = new JScrollPane();
		scrollPane_1.setBorder(new TitledBorder(null, "Detail List", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		pnlList.add(scrollPane_1);

		table_thongke = new JTable();
		scrollPane_1.setViewportView(table_thongke);
		
		panel = new JPanel();
		panel.setBackground(new Color(240, 240, 240));
		panel.setPreferredSize(new Dimension(35, 10));
		pnlList.add(panel, BorderLayout.EAST);
		
		panel_1 = new JPanel();
		panel_1.setBackground(new Color(240, 240, 240));
		panel_1.setPreferredSize(new Dimension(10, 50));
		pnlList.add(panel_1, BorderLayout.SOUTH);
		
		panel_2 = new JPanel();
		panel_2.setBackground(new Color(240, 240, 240));
		panel_2.setPreferredSize(new Dimension(35, 10));
		pnlList.add(panel_2, BorderLayout.WEST);
		


		btntkbooking = new JButton("Booking Statistics");
		btntkbooking.setFocusPainted(false);
		btntkbooking.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btntkbooking.setPreferredSize(new Dimension(200, 30));
		btntkbooking.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultTableModel model = new DefaultTableModel();
		        model.addColumn("Booking_ID");;
		        model.addColumn("Tour_ID");
		        model.addColumn("Customer_id");
		        model.addColumn("Customer_number");
		        model.addColumn("Total_cost");
		        model.addColumn("Create_At");
		        BookingBUS bookingBUS = new BookingBUS();
		        ArrayList<BookingDTO> csDTO = bookingBUS.getAll();
		        for(BookingDTO bkDto : csDTO) {
		        	System.out.println(bkDto.toString());
		            model.addRow(new Object[] {
		                    bkDto.getBooking_id(),bkDto.getTour_id(),bkDto.getCustomer_id(),bkDto.getCustomer_number(),bkDto.getTotal_cost(),bkDto.getCreate_at().toString()

		            });
		        }
		        table_thongke = new JTable();
		        table_thongke.setModel(model);
		        scrollPane_1.setViewportView(table_thongke);
//		        table_thongke.setViewportView(table_thongke);
			}
		});
		pnlFunc1.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		btntkbooking.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		pnlFunc1.add(btntkbooking);

		btnexcelbooking = new JButton("Booking Excel");
		btnexcelbooking.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnexcelbooking.setFocusPainted(false);
		btnexcelbooking.setPreferredSize(new Dimension(200, 30));
		btnexcelbooking.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				XuatExcelBooking();
			}
		});
		btnexcelbooking.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		pnlFunc1.add(btnexcelbooking);
		
		btnexportbooking = new JButton("Booking Export");
		btnexportbooking.setFocusPainted(false);
		btnexportbooking.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnexportbooking.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		btnexportbooking.setPreferredSize(new Dimension(200, 30));
		btnexportbooking.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				exportBooking();
			}
		});
		pnlFunc1.add(btnexportbooking);

		btntktour = new JButton("Tour Statistics");
		btntktour.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btntktour.setFocusPainted(false);
		btntktour.setPreferredSize(new Dimension(200, 30));
		btntktour.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultTableModel model = new DefaultTableModel();
		        model.addColumn("Tour_ID");;
		        model.addColumn("Tour_Name");
		        model.addColumn("Hotel_id");
		        model.addColumn("Price");
		        model.addColumn("Star_Day");
		        model.addColumn("End_Day");
		        model.addColumn("Departure_place");
		        model.addColumn("Schedule-descripbe");
		        model.addColumn("create_at");
		        TourBUS tourBUS = new TourBUS();
		        ArrayList<TourDTO> csDTO = tourBUS.getAll();
		        for(TourDTO itemDao : csDTO) {
		            model.addRow(new Object[] {
		                    itemDao.getTour_id(),itemDao.getTour_name(),itemDao.getHotel_id(),itemDao.getPrice(),itemDao.getStart_day(),itemDao.getEnd_day(),itemDao.getDeparture_place(),
		                    itemDao.getSchedule_describe(),itemDao.getCreate_at().toString()
		            });
		        }
		        table_thongke = new JTable();
		        table_thongke.setModel(model);
		        scrollPane_1.setViewportView(table_thongke);
			}
		});
		pnlFunc2.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		btntktour.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		pnlFunc2.add(btntktour);

		btnexceltour = new JButton("Tour Excel");
		btnexceltour.setFocusPainted(false);
		btnexceltour.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnexceltour.setPreferredSize(new Dimension(200, 30));
		btnexceltour.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				XuatExcelTour();

			}
		});
		btnexceltour.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		pnlFunc2.add(btnexceltour);
		
		btnexporttour = new JButton("Tour Export");
		btnexporttour.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnexporttour.setFocusPainted(false);
		btnexporttour.setPreferredSize(new Dimension(200, 30));
		btnexporttour.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				exportTour();
			}
		});
		btnexporttour.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		pnlFunc2.add(btnexporttour);

		btntkcustomer = new JButton("Customer Statistics");
		btntkcustomer.setFocusPainted(false);
		btntkcustomer.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btntkcustomer.setPreferredSize(new Dimension(200, 30));
		btntkcustomer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 DefaultTableModel model = new DefaultTableModel();
			        model.addColumn("ID");;
			        model.addColumn("Name");
			        model.addColumn("Tel");
			        model.addColumn("Birthday");
			        model.addColumn("Email");
			        model.addColumn("Create_At");
			        CustomerBUS customerBUS = new CustomerBUS();
			        ArrayList<CustomerDTO> csDTO = customerBUS.getAll();
			        for(CustomerDTO itemCustomer : csDTO) {
			            model.addRow(new Object[] {
			                    itemCustomer.getCustomer_id(),itemCustomer.getCustomer_name(),itemCustomer.getTel(),itemCustomer.getBirthday(),itemCustomer.getEmail(),itemCustomer.getCreate_at()
			            });
			        }
			        table_thongke = new JTable();
			        table_thongke.setModel(model);
			        scrollPane_1.setViewportView(table_thongke);
			}
		});
		btntkcustomer.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		pnlFunc3.add(btntkcustomer);

		btnexcelcustomer = new JButton("Customer Excel");
		btnexcelcustomer.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnexcelcustomer.setFocusPainted(false);
		btnexcelcustomer.setPreferredSize(new Dimension(200, 30));
		btnexcelcustomer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				XuatExcelCustomer();
			}
		});
		btnexcelcustomer.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		pnlFunc3.add(btnexcelcustomer);
		
		btnexportcustomer = new JButton("Customer Export");
		btnexportcustomer.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnexportcustomer.setFocusPainted(false);
		btnexportcustomer.setPreferredSize(new Dimension(200, 30));
		btnexportcustomer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				exportCustomer();
			}
		});
		btnexportcustomer.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		pnlFunc3.add(btnexportcustomer);
		
		
		
		
	}
	private void XuatExcelBooking() {
        try {
            JFileChooser jfile = new JFileChooser();
           jfile.setSelectedFile(new File("untitled.xls"));

            int seleted = jfile.showSaveDialog(this);

            if (seleted == JFileChooser.APPROVE_OPTION) {
                String FilePath = jfile.getSelectedFile().getPath();
                System.out.println(FilePath);

                HSSFWorkbook workbook = new HSSFWorkbook();
                HSSFSheet sheet = workbook.createSheet("account");
                BookingBUS bookingBUS = new BookingBUS();
                ArrayList<BookingDTO> list = bookingBUS.getAll();
                int rowPos = 0;
                HSSFRow row = sheet.createRow(rowPos);
                row.createCell(0, CellType.NUMERIC).setCellValue("Booking_Id");
                row.createCell(1, CellType.STRING).setCellValue("Tour_id");
                row.createCell(2, CellType.STRING).setCellValue("Customer_id");
                row.createCell(3, CellType.STRING).setCellValue("Customer_number");
                row.createCell(4, CellType.STRING).setCellValue("Total_cost");
                row.createCell(5, CellType.STRING).setCellValue("Create_at");
                for (BookingDTO ddd: list) {
                	rowPos++;
                	row = sheet.createRow(rowPos);
                    row.createCell(0, CellType.NUMERIC).setCellValue(ddd.getBooking_id());
                    row.createCell(1, CellType.STRING).setCellValue(ddd.getTour_id());
                    row.createCell(2, CellType.STRING).setCellValue(ddd.getCustomer_id());
                    row.createCell(3, CellType.STRING).setCellValue(ddd.getCustomer_number());
                    row.createCell(4, CellType.STRING).setCellValue(ddd.getTotal_cost());
                    row.createCell(5, CellType.STRING).setCellValue(ddd.getCreate_at().toString());
                }
                File file = new File(FilePath);
                try {
                    FileOutputStream fos = new FileOutputStream(file);
                    workbook.write(fos);
                    fos.close();

                } catch (Exception e) {
                    System.out.println("GUI.Table.jButton1MouseClicked()");
                }

            }
            if (seleted == JFileChooser.CANCEL_OPTION) {
            }

        } catch (Exception e) {
        }

    }
	private void XuatExcelTour() {
        try {
            JFileChooser jfile = new JFileChooser();
           jfile.setSelectedFile(new File("untitled.xls"));

            int seleted = jfile.showSaveDialog(this);

            if (seleted == JFileChooser.APPROVE_OPTION) {
                String FilePath = jfile.getSelectedFile().getPath();
                System.out.println(FilePath);

                HSSFWorkbook workbook = new HSSFWorkbook();
                HSSFSheet sheet = workbook.createSheet("account");
                TourBUS tourBUS = new TourBUS();
                ArrayList<TourDTO> list = tourBUS.getAll();
                int rowPos = 0;
                HSSFRow row = sheet.createRow(rowPos);
                row.createCell(0, CellType.NUMERIC).setCellValue("Tour_ID");
                row.createCell(1, CellType.STRING).setCellValue("Tour_Name");
                row.createCell(2, CellType.STRING).setCellValue("Hotel_ID");
                row.createCell(3, CellType.STRING).setCellValue("Price");
                row.createCell(4, CellType.STRING).setCellValue("Star_Day");
                row.createCell(5, CellType.STRING).setCellValue("Star_End");
                row.createCell(6, CellType.STRING).setCellValue("Departure_place");
                row.createCell(7, CellType.STRING).setCellValue("Schedule_descride");
                row.createCell(8, CellType.STRING).setCellValue("Create_at");
                for (TourDTO ddd: list) {
                	rowPos++;
                	row = sheet.createRow(rowPos);
                    row.createCell(0, CellType.NUMERIC).setCellValue(ddd.getTour_id());
                    row.createCell(1, CellType.STRING).setCellValue(ddd.getTour_name());
                    row.createCell(2, CellType.STRING).setCellValue(ddd.getHotel_id());
                    row.createCell(3, CellType.STRING).setCellValue(ddd.getPrice());
                    row.createCell(4, CellType.STRING).setCellValue(ddd.getStart_day());
                    row.createCell(5, CellType.STRING).setCellValue(ddd.getEnd_day());
                    row.createCell(6, CellType.STRING).setCellValue(ddd.getDeparture_place());
                    row.createCell(7, CellType.STRING).setCellValue(ddd.getSchedule_describe());
                    row.createCell(8, CellType.STRING).setCellValue(ddd.getCreate_at().toString());
                }
                File file = new File(FilePath);
                try {
                    FileOutputStream fos = new FileOutputStream(file);
                    workbook.write(fos);
                    fos.close();

                } catch (Exception e) {
                    System.out.println("GUI.Table.jButton1MouseClicked()");
                }

            }
            if (seleted == JFileChooser.CANCEL_OPTION) {
            }

        } catch (Exception e) {
        }

    }
	 private void XuatExcelCustomer() {
	        try {
	            JFileChooser jfile = new JFileChooser();
	           jfile.setSelectedFile(new File("untitled.xls"));

	            int seleted = jfile.showSaveDialog(this);

	            if (seleted == JFileChooser.APPROVE_OPTION) {
	                String FilePath = jfile.getSelectedFile().getPath();
	                System.out.println(FilePath);

	                HSSFWorkbook workbook = new HSSFWorkbook();
	                HSSFSheet sheet = workbook.createSheet("account");
	                CustomerBUS customerBUS = new CustomerBUS();
	                ArrayList<CustomerDTO> list = customerBUS.getAll();
	                int rowPos = 0;
	                HSSFRow row = sheet.createRow(rowPos);
	                row.createCell(0, CellType.NUMERIC).setCellValue("Id");
	                row.createCell(1, CellType.STRING).setCellValue("Name");
	                row.createCell(2, CellType.STRING).setCellValue("Tel");
	                row.createCell(3, CellType.STRING).setCellValue("Birthday");
	                row.createCell(4, CellType.STRING).setCellValue("Email");
	                row.createCell(5, CellType.STRING).setCellValue("Create_at");
	                for (CustomerDTO ddd: list) {
	                	rowPos++;
	                	row = sheet.createRow(rowPos);
	                    row.createCell(0, CellType.NUMERIC).setCellValue(ddd.getCustomer_id());
	                    row.createCell(1, CellType.STRING).setCellValue(ddd.getCustomer_name());
	                    String telString  =String.valueOf(ddd.getTel());
	                    row.createCell(2, CellType.STRING).setCellValue(telString);
	                    row.createCell(3, CellType.STRING).setCellValue(ddd.getBirthday());
	                    row.createCell(4, CellType.STRING).setCellValue(ddd.getEmail());
	                    row.createCell(5, CellType.STRING).setCellValue(ddd.getCreate_at());
	                }
	                File file = new File(FilePath);
	                try {
	                    FileOutputStream fos = new FileOutputStream(file);
	                    workbook.write(fos);
	                    fos.close();

	                } catch (Exception e) {
	                    System.out.println("GUI.Table.jButton1MouseClicked()");
	                }

	            }
	            if (seleted == JFileChooser.CANCEL_OPTION) {
	            }

	        } catch (Exception e) {
	        }

	    }
	 
	 private void exportTour() {                                      

	        try {

	            JFileChooser jfile = new JFileChooser();
	            jfile.setFileFilter(new FileFilter() {

	                public String getDescription() {
	                    return "File Excel (*.xls)";
	                }

	                public boolean accept(File f) {
	                    if (f.isDirectory()) {
	                        return true;
	                    } else {
	                        String filename = f.getName().toLowerCase();
	                        return filename.endsWith(".xls");
	                    }
	                }
	            });
	            int seleted = jfile.showOpenDialog(this);
	            if (seleted == JFileChooser.APPROVE_OPTION) {
	                String FilePath = jfile.getSelectedFile().getPath();

	                FileInputStream fis = new FileInputStream(new File(FilePath));
	                HSSFWorkbook workbook = new HSSFWorkbook(fis);
	                HSSFSheet sheet = workbook.getSheetAt(0);
	                sheet.setRowBreak(0);
	                FormulaEvaluator evaluator = workbook.getCreationHelper().createFormulaEvaluator();

	                DefaultTableModel model = (DefaultTableModel) table_thongke.getModel();
//	                while (model.getRowCount() > 0) {
//	                    model.removeRow(0);
//	                }
	                int i = 0;
	                ArrayList<TourDTO> list = null;
	                for (Row row : sheet) {
	                    TourDTO acc = new TourDTO();
	                    if (i > 0) {
	                        ArrayList<String> item = new ArrayList<String>();
	                        for (Cell cell : row) {

	                            switch (evaluator.evaluateInCell(cell).getCellType()) {
	                                case BOOLEAN:
//	                                System.out.println(cell.getBooleanCellValue());
	                                    break;
	                                case NUMERIC:
	                                    item.add("" + cell.getNumericCellValue());
//	                                System.out.println(cell.getNumericCellValue());
	                                    break;
	                                case STRING:
//	                                System.out.println(cell.getStringCellValue());
	                                    item.add("" + cell.getStringCellValue());
	                                    break;
	                                case BLANK:
	                                    break;
	                                case ERROR:
//	                                System.out.println(cell.getErrorCellValue());
	                                    break;

	                                case FORMULA:
	                                    break;
	                            }

	                        }
	                        TourDTO td = new TourDTO();
	                        float idcus = Float.parseFloat(item.get(0));
	                        td.setTour_id((int)idcus);
	                        td.setTour_name(item.get(1));
	                        float idht = Float.parseFloat(item.get(2));
	                        td.setHotel_id((int)idht);
	                        double ipr = Double.parseDouble(item.get(3));
	                        td.setPrice(ipr);
	                        Date dateStart = new SimpleDateFormat("yyyy-MM-dd").parse(item.get(4));
	                        SimpleDateFormat dddDateFormat = new SimpleDateFormat("yyyy-MM-dd");
	                        String dateStartString = dddDateFormat.format(dateStart);
	                        td.setStart_day(dateStartString);
	                        Date dateEnd = new SimpleDateFormat("yyyy-MM-dd").parse(item.get(5));
	                        SimpleDateFormat ENDDateFormat = new SimpleDateFormat("yyyy-MM-dd");
	                        String dateEndString = ENDDateFormat.format(dateEnd);
	                        td.setEnd_day(dateEndString);
	                        td.setDeparture_place(item.get(6));
	                        td.setSchedule_describe(item.get(7));
	                        TourBUS tourBUS = new TourBUS();
	                        tourBUS.addExcel(td);
//	                        TourDAO.getInstance().add(td);
	                    }

	                    i++;
	                }
	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	        }

	    }
	 private void exportCustomer() {                                      

	        try {

	            JFileChooser jfile = new JFileChooser();
	            jfile.setFileFilter(new FileFilter() {

	                public String getDescription() {
	                    return "File Excel (*.xls)";
	                }

	                public boolean accept(File f) {
	                    if (f.isDirectory()) {
	                        return true;
	                    } else {
	                        String filename = f.getName().toLowerCase();
	                        return filename.endsWith(".xls");
	                    }
	                }
	            });
	            int seleted = jfile.showOpenDialog(this);
	            if (seleted == JFileChooser.APPROVE_OPTION) {
	                String FilePath = jfile.getSelectedFile().getPath();

	                FileInputStream fis = new FileInputStream(new File(FilePath));
	                HSSFWorkbook workbook = new HSSFWorkbook(fis);
	                HSSFSheet sheet = workbook.getSheetAt(0);
	                sheet.setRowBreak(0);
	                FormulaEvaluator evaluator = workbook.getCreationHelper().createFormulaEvaluator();

	                DefaultTableModel model = (DefaultTableModel) table_thongke.getModel();
//	                while (model.getRowCount() > 0) {
//	                    model.removeRow(0);
//	                }
	                int i = 0;
	                ArrayList<CustomerDTO> list = null;
	                for (Row row : sheet) {
	                    CustomerDTO acc = new CustomerDTO();
	                    if (i > 0) {
	                        ArrayList<String> item = new ArrayList<String>();
	                        for (Cell cell : row) {

	                            switch (evaluator.evaluateInCell(cell).getCellType()) {
	                                case BOOLEAN:
//	                                System.out.println(cell.getBooleanCellValue());
	                                    break;
	                                case NUMERIC:
	                                    item.add("" + cell.getNumericCellValue());
//	                                System.out.println(cell.getNumericCellValue());
	                                    break;
	                                case STRING:
//	                                System.out.println(cell.getStringCellValue());
	                                    item.add("" + cell.getStringCellValue());
	                                    break;
	                                case BLANK:
	                                    break;
	                                case ERROR:
//	                                System.out.println(cell.getErrorCellValue());
	                                    break;

	                                case FORMULA:
	                                    break;
	                            }

	                        }
	                        CustomerDTO ddDto = new CustomerDTO();
	                        float idcus = Float.parseFloat(item.get(0));
	                        ddDto.setCustomer_id((int)idcus);
	                        ddDto.setCustomer_name(item.get(1));
	                        ddDto.setTel(item.get(2));
	                        Date date1 = new SimpleDateFormat("yyyy-MM-dd").parse(item.get(3));
	                        SimpleDateFormat dddDateFormat = new SimpleDateFormat("yyyy-MM-dd");
	                        String dateString = dddDateFormat.format(date1);
	                        ddDto.setBirthday(dateString);
	                        ddDto.setEmail(item.get(4));
	                        ddDto.setCreate_at("");
	                        CustomerBUS customerBUS = new CustomerBUS();
	                        customerBUS.add(ddDto);
//	                        CustomerDAO.getInstance().add(ddDto);
	                    }

	                    i++;
	                }
	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	        }

	    }
	 private void exportBooking() {                                      

	        try {

	            JFileChooser jfile = new JFileChooser();
	            jfile.setFileFilter(new FileFilter() {

	                public String getDescription() {
	                    return "File Excel (*.xls)";
	                }

	                public boolean accept(File f) {
	                    if (f.isDirectory()) {
	                        return true;
	                    } else {
	                        String filename = f.getName().toLowerCase();
	                        return filename.endsWith(".xls");
	                    }
	                }
	            });
	            int seleted = jfile.showOpenDialog(this);
	            if (seleted == JFileChooser.APPROVE_OPTION) {
	                String FilePath = jfile.getSelectedFile().getPath();

	                FileInputStream fis = new FileInputStream(new File(FilePath));
	                HSSFWorkbook workbook = new HSSFWorkbook(fis);
	                HSSFSheet sheet = workbook.getSheetAt(0);
	                sheet.setRowBreak(0);
	                FormulaEvaluator evaluator = workbook.getCreationHelper().createFormulaEvaluator();

	                DefaultTableModel model = (DefaultTableModel) table_thongke.getModel();
//	                while (model.getRowCount() > 0) {
//	                    model.removeRow(0);
//	                }
	                int i = 0;
	                ArrayList<BookingDTO> list = null;
	                for (Row row : sheet) {
	                    BookingDTO acc = new BookingDTO();
	                    if (i > 0) {
	                        ArrayList<String> item = new ArrayList<String>();
	                        for (Cell cell : row) {

	                            switch (evaluator.evaluateInCell(cell).getCellType()) {
	                                case BOOLEAN:
//	                                System.out.println(cell.getBooleanCellValue());
	                                    break;
	                                case NUMERIC:
	                                    item.add("" + cell.getNumericCellValue());
//	                                System.out.println(cell.getNumericCellValue());
	                                    break;
	                                case STRING:
//	                                System.out.println(cell.getStringCellValue());
	                                    item.add("" + cell.getStringCellValue());
	                                    break;
	                                case BLANK:
	                                    break;
	                                case ERROR:
//	                                System.out.println(cell.getErrorCellValue());
	                                    break;

	                                case FORMULA:
	                                    break;
	                            }

	                        }
	                        BookingDTO bdo = new BookingDTO();
	                        float idBk = Float.parseFloat(item.get(0));
	                        bdo.setBooking_id((int)idBk);
	                        float idTour = Float.parseFloat(item.get(1));
	                        bdo.setTour_id((int)idTour);
	                        float idcus = Float.parseFloat(item.get(2));
	                        bdo.setCustomer_id((int)idcus);
	                        float cusnum = Float.parseFloat(item.get(3));
	                        bdo.setCustomer_number((int)cusnum);
	                        bdo.setTotal_cost(Double.parseDouble(item.get(4)));
	                        BookingBUS bookingBUS = new BookingBUS();
	                        bookingBUS.addExcel(bdo);
//	                       BookingDAO.getInstance().add(bdo);

	                    }

	                    i++;
	                }
	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	        }

	    }
}
