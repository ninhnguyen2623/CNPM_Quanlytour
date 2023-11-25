package GUI;

import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.Window;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import java.awt.AlphaComposite;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import javax.swing.Timer;
import javax.swing.JSlider;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.AbstractButton;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.Path2D;
import java.awt.image.BufferedImage;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.RenderingHints;
import java.awt.Cursor;
import javax.swing.border.LineBorder;
import javax.swing.Icon;

import BUS.UserBUS;
import DTO.UserDTO;
import controller.SignInControl;



public class SignIn extends JFrame {

	private JPanel contentPane;
	private JPanel panel;
	private JPanel pnlImg;
	private JLabel lblImg;
	private JPanel pnlSignIn;
	private JLabel lblLogin;
	private JLabel lblUserName;
	private JLabel iconUser;
	private JTextField txtUserName;
	private JSeparator sepUserName;
	private JLabel lblPass;
	private JLabel iconPass;
	private JPasswordField txtPass;
	private JSeparator sepPass;
	private JButton iconShowPass;
	private JButton iconHiddenPass;
	private JButton btnLogin;
	private JButton btnForgetPassword;
	private JButton btnRegister;
	
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					SignIn frame = new SignIn();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}
	
	public SignIn() {
		this.init();
	}

	public SignIn(JButton iconShowPass, JButton iconHiddenPass, JButton btnLogin, JButton btnForgetPassword, JButton btnRegister) {
		this.iconShowPass = iconShowPass;
		this.iconHiddenPass = iconHiddenPass;
		this.btnLogin = btnLogin;
		this.btnForgetPassword = btnForgetPassword;
		this.btnRegister = btnRegister;
	}
	
	public JButton getIconShowPass() {
		return iconShowPass;
	}

	public void setIconShowPass(JButton iconShowPass) {
		this.iconShowPass = iconShowPass;
	}

	public JButton getIconHiddenPass() {
		return iconHiddenPass;
	}

	public void setIconHiddenPass(JButton iconHiddenPass) {
		this.iconHiddenPass = iconHiddenPass;
	}

	public JButton getBtnLogin() {
		return btnLogin;
	}

	public void setBtnLogin(JButton btnLogin) {
		this.btnLogin = btnLogin;
	}

	public JButton getBtnForgetPassword() {
		return btnForgetPassword;
	}

	public void setBtnForgetPassword(JButton btnForgetPassword) {
		this.btnForgetPassword = btnForgetPassword;
	}

	public JButton getBtnRegister() {
		return btnRegister;
	}

	public void setBtnRegister(JButton btnRegister) {
		this.btnRegister = btnRegister;
	}
	
	public void init() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 500);
		setLocationRelativeTo(null);
		setResizable(false);
		
		// Sự kiện
		ActionListener action = new SignInControl(this);
		
		// Tạo view của Sign In
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		panel = new JPanel();
		panel.setBounds(0, 0, 784, 461);
		contentPane.add(panel);
		panel.setLayout(null);
		
		pnlImg = new JPanel();
		pnlImg.setBounds(0, 0, 395, 461);
		panel.add(pnlImg);
		pnlImg.setLayout(null);
		
		lblImg = new JLabel("");
		lblImg.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(SignIn.class.getResource("../images/bg_signin.jpg"))));
		lblImg.setBounds(0, 0, 395, 461);
		pnlImg.add(lblImg);
		
		pnlSignIn = new JPanel();
		pnlSignIn.setBackground(new Color(129, 212, 250));
		pnlSignIn.setBounds(393, 0, 395, 461);
		panel.add(pnlSignIn);
		pnlSignIn.setLayout(null);
		
		lblLogin = new JLabel("Login");
		lblLogin.setFont(new Font("Sitka Small", Font.BOLD, 24));
		lblLogin.setBounds(161, 66, 84, 28);
		pnlSignIn.add(lblLogin);
		
		lblUserName = new JLabel("User Name");
		lblUserName.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblUserName.setBounds(110, 177, 58, 14);
		pnlSignIn.add(lblUserName);
		
		iconUser = new JLabel("");
		iconUser.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(SignIn.class.getResource("../images/user.png"))));
		iconUser.setBounds(78, 194, 22, 28);
		pnlSignIn.add(iconUser);
		
		txtUserName = new JTextField();
		txtUserName.setFont(new Font("Arial", Font.BOLD, 12));
		txtUserName.setBackground(new Color(129, 212, 250));
		txtUserName.setBounds(110, 199, 199, 20);
		txtUserName.setBorder(null);
		txtUserName.requestFocusInWindow();
		pnlSignIn.add(txtUserName);
		txtUserName.setColumns(10);
		
		sepUserName = new JSeparator();
		sepUserName.setBackground(new Color(0, 0, 0));
		sepUserName.setBounds(110, 218, 199, 2);
		pnlSignIn.add(sepUserName);
		
		lblPass = new JLabel("Password");
		lblPass.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblPass.setBounds(110, 235, 58, 14);
		pnlSignIn.add(lblPass);
		
		iconPass = new JLabel("");
		iconPass.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(SignIn.class.getResource("../images/lock.png"))));
		iconPass.setBounds(78, 252, 22, 28);
		pnlSignIn.add(iconPass);
		
		txtPass = new JPasswordField();
		txtPass.setEchoChar('*');
		txtPass.setFont(new Font("Arial", Font.BOLD, 12));
		txtPass.setBackground(new Color(129, 212, 250));
		txtPass.setBounds(110, 257, 199, 20);
		txtPass.requestFocusInWindow();
		txtPass.setBorder(null);
		pnlSignIn.add(txtPass);
		txtPass.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					Manager mag = new Manager();
					JOptionPane.showMessageDialog(null, "Dang nhap thanh cong");
					dispose();
					mag.setVisible(true);
				}
			}
		});
		
		sepPass = new JSeparator();
		sepPass.setBackground(new Color(0, 0, 0));
		sepPass.setBounds(110, 276, 199, 2);
		pnlSignIn.add(sepPass);
		
		iconHiddenPass = new JButton(new ImageIcon("../images/hidPass.png"));
//		iconHiddenPass = new JButton();f

		iconHiddenPass.addActionListener(action);
		iconHiddenPass.setFocusPainted(false);
		iconHiddenPass.setBorderPainted(false);
		iconHiddenPass.setContentAreaFilled(false);
		iconHiddenPass.setBounds(312, 254, 22, 23);
		iconHiddenPass.setCursor(new Cursor(Cursor.HAND_CURSOR));
		pnlSignIn.add(iconHiddenPass);	
		
		btnLogin = new JButton("Login");
		btnLogin.addActionListener(action);
		
		btnLogin.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				btnLoginPerformed(e);
			}
		});
		
		btnLogin.setFont(new Font("Arial", Font.PLAIN, 14));
		btnLogin.setFocusPainted(false);
		btnLogin.setBorderPainted(false);
		btnLogin.setBorder(new LineBorder(new Color(92, 107, 192)));
		btnLogin.setBackground(new Color(125, 229, 251));
		btnLogin.setBounds(110, 298, 199, 37);
		btnLogin.setCursor(new Cursor(Cursor.HAND_CURSOR));
		pnlSignIn.add(btnLogin);
		
//		btnForgetPassword = new JButton("Forget Password ?");
//		btnForgetPassword.addActionListener(action);
//		btnForgetPassword.setBorderPainted(false);
//		btnForgetPassword.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
//		btnForgetPassword.setContentAreaFilled(false);
//		btnForgetPassword.setFont(new Font("Arial", Font.PLAIN, 11));
//		btnForgetPassword.setFocusPainted(false);
//		btnForgetPassword.setBounds(146, 350, 131, 20);
//		pnlSignIn.add(btnForgetPassword);

//		btnRegister = new JButton("Register Now");
//		btnRegister.addActionListener(action);
//		btnRegister.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
//		btnRegister.setContentAreaFilled(false);
//		btnRegister.setFocusPainted(false);
//		btnRegister.setBorderPainted(false);
//		btnRegister.setFont(new Font("Arial", Font.PLAIN, 11));
//		btnRegister.setBounds(162, 380, 100, 20);
//		pnlSignIn.add(btnRegister);		
	}
	
	// Show Password
	public void showPass() {
		ActionListener action = new SignInControl(this);
		iconShowPass = new JButton(new ImageIcon("../images/showPass.png"));
		iconShowPass.addActionListener(action);
		iconShowPass.setFocusPainted(false);
		iconShowPass.setBorderPainted(false);
		iconShowPass.setContentAreaFilled(false);
		iconShowPass.setBounds(312, 254, 22, 23);
		iconShowPass.setCursor(new Cursor(Cursor.HAND_CURSOR));
		pnlSignIn.add(iconShowPass);
		iconShowPass.setVisible(true);
		iconHiddenPass.setVisible(false);
		txtPass.setEchoChar((char)0);
	}
	
	// Hidden Password
	public void hidPass() {
		iconShowPass.setVisible(false);
		iconHiddenPass.setVisible(true);
		txtPass.setEchoChar('*');	
	}
	
	private void btnLoginPerformed(MouseEvent evt){

		//Lay username & password
		String username = txtUserName.getText();
		String password = String.valueOf(txtPass.getPassword());
		if(txtUserName.getText().equals("")) {
			JOptionPane.showMessageDialog(null,"Không để trống tên đăng nhập !");
			return;
		}
		if(password.equals("")) {
			JOptionPane.showMessageDialog(null,"Không để trống mật khẩu !");
			return;
		}
		//Kiem tra Db
		UserBUS ubs = new UserBUS();
		System.out.println(ubs.CheckUser(username,password));
		if (ubs.CheckUser(username,password)) {
			Manager mag;
			JOptionPane.showMessageDialog(null,"Dang nhap thanh cong");
			
			UserDTO role = ubs.getByName(username);
			if (role.getRole_id() == 1) {
				mag = new Manager();
				mag.setVisible(true);
				
			}
			else if (role.getRole_id() == 2) {
				mag = new Manager();
				mag.getPnlMainContent().remove(mag.getPnlTourContent());
				mag.getPnlListDetail().remove(mag.getPnlTourManager());
				mag.getPnlListDetail().remove(mag.getPnlDesManager());
				mag.getPnlListDetail().remove(mag.getPnlHotelManager());
				mag.getPnlListDetail().remove(mag.getPnlAccManager());
				mag.getPnlListDetail().remove(mag.getPnlStatistical());
				mag.getPnlListDetail().remove(mag.getPnlExportExcel());
				mag.setVisible(true);
			}
			else if (role.getRole_id() == 3) {
				mag = new Manager();
				mag.getPnlMainContent().remove(mag.getPnlTourContent());
				mag.getPnlListDetail().remove(mag.getPnlTourManager());
				mag.getPnlListDetail().remove(mag.getPnlDesManager());
				mag.getPnlListDetail().remove(mag.getPnlHotelManager());
				mag.getPnlListDetail().remove(mag.getPnlAccManager());
				mag.getPnlListDetail().remove(mag.getPnlSerManager());
				mag.getPnlListDetail().remove(mag.getPnlBillManager());
				mag.getPnlListDetail().remove(mag.getPnlCusManager());
				mag.setVisible(true);
			}
			else {
				mag = new Manager();
				mag.getPnlMainContent().remove(mag.getPnlTourContent());
				mag.getPnlListDetail().remove(mag.getPnlStatistical());
				mag.getPnlListDetail().remove(mag.getPnlExportExcel());
				mag.getPnlListDetail().remove(mag.getPnlAccManager());
				mag.getPnlListDetail().remove(mag.getPnlSerManager());
				mag.getPnlListDetail().remove(mag.getPnlBillManager());
				mag.getPnlListDetail().remove(mag.getPnlCusManager());
				mag.getPnlListDetail().remove(mag.getPnlVehicleManager());
				mag.setVisible(true);
			}
			
			this.dispose();
		}else {
			JOptionPane.showMessageDialog(null,"Sai Thong Tin");
		}


	}
	
	// Change to Register form
	public void chgResgister() {
		SignUp signUp = new SignUp();
		signUp.setVisible(true);
		dispose();
	}
}

