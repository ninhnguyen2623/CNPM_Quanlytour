package GUI;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.Normalizer;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import BUS.HotelBUS;
import BUS.VehicleBUS;
import DAO.VehicleDAO;
import DTO.HotelDTO;
import DTO.VehicleDTO;

import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;

public class VehicleContent extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField txt_phuongtien;
	private JTextField txt_laoixe;
	private JTextField txt_serch;
	private JTable tbl_vehicle;
	private JScrollPane scrollPane;
	private JComboBox cbx_trangthai;
	private JComboBox cbx_suachua;
	private JTextField txt_id;

	/**
	 * Create the panel.
	 */
	public VehicleContent() {
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Phương tiện");
		lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel.setBounds(235, 133, 136, 29);
		add(lblNewLabel);
		
		JLabel lblLoiXe = new JLabel("Loại xe");
		lblLoiXe.setHorizontalAlignment(SwingConstants.LEFT);
		lblLoiXe.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblLoiXe.setBounds(235, 165, 136, 29);
		add(lblLoiXe);
		
		JLabel lblTrngThi = new JLabel("Trạng thái");
		lblTrngThi.setHorizontalAlignment(SwingConstants.LEFT);
		lblTrngThi.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblTrngThi.setBounds(235, 194, 136, 29);
		add(lblTrngThi);
		
		txt_phuongtien = new JTextField();
		txt_phuongtien.setBounds(381, 139, 322, 19);
		add(txt_phuongtien);
		txt_phuongtien.setColumns(10);
		
		txt_laoixe = new JTextField();
		txt_laoixe.setColumns(10);
		txt_laoixe.setBounds(381, 171, 322, 19);
		add(txt_laoixe);
		
		txt_serch = new JTextField();
		txt_serch.setColumns(10);
		txt_serch.setBounds(168, 69, 525, 27);
		add(txt_serch);
		
		txt_id = new JTextField();
		txt_id.setColumns(10);
		txt_id.setBounds(381, 107, 322, 19);
		add(txt_id);
		
		JLabel lblVehicle = new JLabel("Vehicle Manager");
		lblVehicle.setHorizontalAlignment(SwingConstants.CENTER);
		lblVehicle.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblVehicle.setBounds(317, 17, 255, 29);
		add(lblVehicle);
		
		JPanel panel = new JPanel();
		panel.setBounds(80, 322, 738, 257);
		add(panel);
		panel.setLayout(null);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 10, 718, 237);
		panel.add(scrollPane);
		
//		tbl_vehicle = new JTable();
		ClassLoaddataVehicle();
//		scrollPane.setViewportView(tbl_vehicle);
		
		JButton btn_search_vehicle = new JButton("Search");
		btn_search_vehicle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String shString = txt_serch.getText().trim();
                if(isNumeric(shString)== true) {
                    int idhotel = Integer.parseInt(shString.trim());
                    VehicleBUS vehicleBUS = new VehicleBUS();
                    VehicleDTO vehicleDTO = vehicleBUS.getById(idhotel);
                    if(vehicleDTO != null) {
                        DefaultTableModel model = new DefaultTableModel();
                        model.addColumn("ID");;
                        model.addColumn("Tên xe");
                        model.addColumn("Loại xe");
                        model.addColumn("Trạng thái");
                        model.addColumn("Sửa chữa");
                        model.addRow(new Object[] {
                        		vehicleDTO.getVehicle_id(),vehicleDTO.getTenxe(),vehicleDTO.getLoaixe(),vehicleDTO.getTrangthaixe(),vehicleDTO.getSuachua()
                        });
                        tbl_vehicle = new JTable();
                        tbl_vehicle.setModel(model);
                        scrollPane.setViewportView(tbl_vehicle);
                    }
                    if(vehicleDTO ==null) {
                        JOptionPane.showMessageDialog(null, "Không tìm thấy thông tin vehicle !");
                    }
                }
                if (isNumeric(shString)== false) {
//                    ArrayList<HotelDTO> arrhHotelDTOs = HotelDAO.getInstance().getAll();
                	VehicleBUS vehicleBUS = new VehicleBUS();
                	ArrayList<VehicleDTO> arrDTOs = vehicleBUS.getAll();
                    Boolean checkKQ = false;
                    for(VehicleDTO jjjHotelDTO: arrDTOs) {
                        String temp = Normalizer.normalize(jjjHotelDTO.getTenxe(), Normalizer.Form.NFD);
                        String temp2 = Normalizer.normalize(shString, Normalizer.Form.NFD);
                        Pattern pattern = Pattern.compile("\\p{InCombiningDiacriticalMarks}+");
                        if(pattern.matcher(temp).replaceAll("").equalsIgnoreCase(pattern.matcher(temp2).replaceAll(""))) {
                        	DefaultTableModel model = new DefaultTableModel();
                            model.addColumn("ID");;
                            model.addColumn("Tên xe");
                            model.addColumn("Loại xe");
                            model.addColumn("Trạng thái");
                            model.addColumn("Sửa chữa");
                            model.addRow(new Object[] {
                            		jjjHotelDTO.getVehicle_id(),jjjHotelDTO.getTenxe(),jjjHotelDTO.getLoaixe(),jjjHotelDTO.getTrangthaixe(),jjjHotelDTO.getSuachua()
                            });
                            tbl_vehicle = new JTable();
                            tbl_vehicle.setModel(model);
                            scrollPane.setViewportView(tbl_vehicle);
                            checkKQ = true;
                        }
                    }
                    if(checkKQ == false) {
                        JOptionPane.showMessageDialog(null, "Không tìm thấy thông tin vehicle !");
                    }
                }
			}
		});
		btn_search_vehicle.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btn_search_vehicle.setBounds(703, 66, 87, 29);
		add(btn_search_vehicle);
		
		JButton btn_them = new JButton("THÊM");
		btn_them.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VehicleBUS ddd = new VehicleBUS();
				String idString = txt_id.getText().trim();
                int idVehicle = 0;
                boolean checkid = false;
                if(isNumeric(idString)==false) {
                	JOptionPane.showMessageDialog(null, "ID phải là số !");
                	checkid = true;
                	return;
                }
                if(isNumeric(idString)==true) {
                    idVehicle = Integer.parseInt(idString.trim());
                }
                VehicleDAO fdfdf = new VehicleDAO();
                String tenxe = txt_phuongtien.getText();
                String loaixe = txt_laoixe.getText();
                String trangthai =(String)cbx_trangthai.getSelectedItem();
                String suachua =(String)cbx_suachua.getSelectedItem();
                if(txt_id.getText() == "" || txt_phuongtien.getText() == "" || txt_laoixe.getText() == "") {
                	JOptionPane.showMessageDialog(null,"Dữ liệu không được để trống hoặc sai sót!!");
                	return;
                }
                else {
                	ArrayList<VehicleDTO> ve = ddd.getAll();
                    for(VehicleDTO kkk: ve) {
                    	if(kkk.getVehicle_id()==idVehicle) {
                    		JOptionPane.showMessageDialog(null, "id đã tồn tại !");
                    		checkid = true;
                    	}
                    }
                    if(checkid == false) {
                    	VehicleDTO vehicledto = new VehicleDTO(idVehicle,tenxe,loaixe,trangthai,suachua);
                    	int result = JOptionPane.showConfirmDialog(null,
                                "Bạn có muốn them  " +tenxe,
                                "Xác nhận",
                                JOptionPane.YES_NO_OPTION,
                                JOptionPane.QUESTION_MESSAGE);
                        if(result == JOptionPane.YES_OPTION){
                        	ddd.add(vehicledto);
                        	ClassLoaddataVehicle();
                        }
                    }
                }
			}
		});
		btn_them.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btn_them.setBounds(235, 270, 129, 29);
		add(btn_them);
		
		
		
		JButton btn_capnhat = new JButton("CẬP NHẬT");
		btn_capnhat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VehicleBUS ddd = new VehicleBUS();
				String idString = txt_id.getText().trim();
                int idVehicle = 0;
                boolean checkid = false;
                if(isNumeric(idString)==false) {
                	JOptionPane.showMessageDialog(null, "ID phải là số !");
                	checkid = true;
                	return;
                }
                if(isNumeric(idString)==true) {
                    idVehicle = Integer.parseInt(idString.trim());
                }
                VehicleDAO fdfdf = new VehicleDAO();
                String tenxe = txt_phuongtien.getText();
                String loaixe = txt_laoixe.getText();
                String trangthai =(String)cbx_trangthai.getSelectedItem();
                String suachua =(String)cbx_suachua.getSelectedItem();
                if(txt_id.getText() == "" || txt_phuongtien.getText() == "" || txt_laoixe.getText() == "") {
                	JOptionPane.showMessageDialog(null,"Dữ liệu không được để trống hoặc sai sót!!");
                	return;
                }
                else {
                	ArrayList<VehicleDTO> ve = ddd.getAll();
                    for(VehicleDTO kkk: ve) {
                    	if(kkk.getVehicle_id()==idVehicle) {
                    		checkid = true;
                    	}
                    }
                    if(checkid == false) {
                    	JOptionPane.showMessageDialog(null,"id khong ton tai !");
                    }
                    else {
                    	VehicleDTO vehicledto = new VehicleDTO(idVehicle,tenxe,loaixe,trangthai,suachua);
                    	int result = JOptionPane.showConfirmDialog(null,
                                "Bạn có muốn sửa  " +tenxe,
                                "Xác nhận",
                                JOptionPane.YES_NO_OPTION,
                                JOptionPane.QUESTION_MESSAGE);
                        if(result == JOptionPane.YES_OPTION){
                        	ddd.update(vehicledto);
                        	ClassLoaddataVehicle();
                        }
                    }
                }
			}
		});
		btn_capnhat.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btn_capnhat.setBounds(418, 270, 129, 29);
		add(btn_capnhat);
		
		JButton btn_refesh = new JButton("REFESH");
		btn_refesh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RefeshVehicle();
				ClassLoaddataVehicle();
			}
		});
		btn_refesh.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btn_refesh.setBounds(589, 270, 129, 29);
		add(btn_refesh);
		
		JLabel lblId = new JLabel("ID");
		lblId.setHorizontalAlignment(SwingConstants.LEFT);
		lblId.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblId.setBounds(235, 107, 136, 29);
		add(lblId);
		
		JLabel lblSaCha = new JLabel("Sửa chữa");
		lblSaCha.setHorizontalAlignment(SwingConstants.LEFT);
		lblSaCha.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblSaCha.setBounds(235, 234, 136, 29);
		add(lblSaCha);
		
		cbx_trangthai = new JComboBox();
		cbx_trangthai.setBounds(381, 199, 322, 22);
		cbx_trangthai.setModel(new DefaultComboBoxModel(new String[] {"tốt","xấu","tạm"}));
		add(cbx_trangthai);
		
		cbx_suachua = new JComboBox();
		cbx_suachua.setBounds(381, 239, 322, 22);
		cbx_suachua.setModel(new DefaultComboBoxModel(new String[] {"không","bảo chì","sửa chữa"}));
		add(cbx_suachua);
		
		

	}
	public void ClassLoaddataVehicle() {
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("ID");;
        model.addColumn("Tên xe");
        model.addColumn("Loại xe");
        model.addColumn("Trạng thái");
        model.addColumn("Sửa chữa");
        VehicleBUS vehiclebus = new VehicleBUS();
        ArrayList<VehicleDTO> vhDTO = vehiclebus.getAll();
        int is = 0;
        for(VehicleDTO itemVehicle : vhDTO) {
        	is++;
            model.addRow(new Object[] {
            		itemVehicle.getVehicle_id(),itemVehicle.getTenxe(),itemVehicle.getLoaixe(),itemVehicle.getTrangthaixe(),itemVehicle.getSuachua()
            });
        }
        txt_id.setText(Integer.toString(is+1));
        tbl_vehicle = new JTable();
        tbl_vehicle.setModel(model);
        scrollPane.setViewportView(tbl_vehicle);
        getDataFromJtable();

    }
	public void getDataFromJtable() {
        List<HotelDTO> hotelDTO = new ArrayList<HotelDTO>();
        tbl_vehicle.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent me) {
                int i = tbl_vehicle.getSelectedRow();
                TableModel model = tbl_vehicle.getModel();
                int idhotel = Integer.parseInt(model.getValueAt(i,0).toString());
                String nameHotelString = model.getValueAt(i,1).toString();
                String addressHotelString = model.getValueAt(i,2).toString();
                String telhotel = model.getValueAt(i,3).toString();
                String webHotelString = model.getValueAt(i,4).toString();
//	        	add  table to txt
                String idhotelString = String.valueOf(idhotel);
                txt_id.setText(idhotelString);
                txt_phuongtien.setText(nameHotelString);
                txt_laoixe.setText(addressHotelString);
                cbx_trangthai.setSelectedItem(telhotel);
                cbx_suachua.setSelectedItem(webHotelString);
            }
        });

    }
	public void RefeshVehicle() {
		txt_phuongtien.setText(" ");
		txt_laoixe.setText(" ");
		txt_serch.setText(" ");
		VehicleBUS vehiclebus = new VehicleBUS();
        ArrayList<VehicleDTO> vhDTO = vehiclebus.getAll();
        int i = 0;
        for(VehicleDTO itemVehicle : vhDTO) {
        	i++;
        }
        txt_id.setText(Integer.toString(i+1));
	}
	 public static boolean isNumeric(final CharSequence cs) {
//       if (cs.isEmpty()) {
//           return false;
//       }
       final int sz = cs.length();
       for (int i = 0; i < sz; i++) {
           if (!Character.isDigit(cs.charAt(i))) {
               return false;
           }
       }
       return true;
   }
}
