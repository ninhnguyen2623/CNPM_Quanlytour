package GUI;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JButton;

public class VehicleContent extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField txt_phuongtien;
	private JTextField txt_laoixe;
	private JTextField txt_trangthai;
	private JTextField txt_serch;
	private JTable tbl_vehicle;

	/**
	 * Create the panel.
	 */
	public VehicleContent() {
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Phương tiện");
		lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel.setBounds(235, 128, 136, 29);
		add(lblNewLabel);
		
		JLabel lblLoiXe = new JLabel("Loại xe");
		lblLoiXe.setHorizontalAlignment(SwingConstants.LEFT);
		lblLoiXe.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblLoiXe.setBounds(235, 167, 136, 29);
		add(lblLoiXe);
		
		JLabel lblTrngThi = new JLabel("Trạng thái");
		lblTrngThi.setHorizontalAlignment(SwingConstants.LEFT);
		lblTrngThi.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblTrngThi.setBounds(232, 211, 136, 29);
		add(lblTrngThi);
		
		txt_phuongtien = new JTextField();
		txt_phuongtien.setBounds(396, 135, 322, 19);
		add(txt_phuongtien);
		txt_phuongtien.setColumns(10);
		
		txt_laoixe = new JTextField();
		txt_laoixe.setColumns(10);
		txt_laoixe.setBounds(396, 174, 322, 19);
		add(txt_laoixe);
		
		txt_trangthai = new JTextField();
		txt_trangthai.setColumns(10);
		txt_trangthai.setBounds(396, 218, 322, 19);
		add(txt_trangthai);
		
		txt_serch = new JTextField();
		txt_serch.setColumns(10);
		txt_serch.setBounds(168, 69, 525, 27);
		add(txt_serch);
		
		JLabel lblVehicle = new JLabel("Vehicle Manager");
		lblVehicle.setHorizontalAlignment(SwingConstants.CENTER);
		lblVehicle.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblVehicle.setBounds(317, 17, 255, 29);
		add(lblVehicle);
		
		JPanel panel = new JPanel();
		panel.setBounds(80, 322, 738, 257);
		add(panel);
		panel.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 10, 718, 237);
		panel.add(scrollPane);
		
		tbl_vehicle = new JTable();
		scrollPane.setViewportView(tbl_vehicle);
		
		JButton btn_search_vehicle = new JButton("Search");
		btn_search_vehicle.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btn_search_vehicle.setBounds(703, 66, 87, 29);
		add(btn_search_vehicle);
		
		JButton btn_them = new JButton("THÊM");
		btn_them.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btn_them.setBounds(235, 270, 129, 29);
		add(btn_them);
		
		JButton btn_capnhat = new JButton("CẬP NHẬT");
		btn_capnhat.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btn_capnhat.setBounds(418, 270, 129, 29);
		add(btn_capnhat);
		
		JButton btn_refesh = new JButton("REFESH");
		btn_refesh.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btn_refesh.setBounds(589, 270, 129, 29);
		add(btn_refesh);

	}
}
