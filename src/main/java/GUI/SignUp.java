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
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
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
import controller.SignUpControl;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class SignUp extends JFrame {

	private JPanel contentPane;
	private JPasswordField txtPass;
	private JPasswordField txtConfPass;
	private JTextField txtEmail;
	private JTextField txtUserName;
	private JPanel panel;
	private JPanel pnlImg;
	private JLabel lblImg;
	private JPanel pnlSignUp;
	private JLabel lblRegister;
	private JLabel lblUserName;
	private JLabel iconUser;
	private JSeparator sepUserName;
	private JLabel lblPass;
	private JLabel iconPass;
	private JSeparator sepPass;
	private JButton iconHiddenPass;
	private JButton iconShowPass;
	private JLabel lblConfPass;
	private JLabel iconConfPass;
	private JSeparator sepConfPass;
	private JLabel lblEmail;
	private JLabel iconEmail;
	private JSeparator sepEmail;
	private JButton btnRegister;
	private JButton btnBackToLogin;
	
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					SignUp frame = new SignUp();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	public SignUp() {
		this.init();
	}
	
	public SignUp(JButton iconShowPass, JButton iconHiddenPass, JButton btnRegister, JButton btnBackToLogin) {
		this.iconShowPass = iconShowPass;
		this.iconHiddenPass = iconHiddenPass;
		this.btnRegister = btnRegister;
		this.btnBackToLogin = btnBackToLogin;	
	}
	
	public JButton getIconHiddenPass() {
		return iconHiddenPass;
	}

	public void setIconHiddenPass(JButton iconHiddenPass) {
		this.iconHiddenPass = iconHiddenPass;
	}

	public JButton getIconShowPass() {
		return iconShowPass;
	}

	public void setIconShowPass(JButton iconShowPass) {
		this.iconShowPass = iconShowPass;
	}

	public JButton getBtnRegister() {
		return btnRegister;
	}

	public void setBtnRegister(JButton btnRegister) {
		this.btnRegister = btnRegister;
	}

	public JButton getBtnBackToLogin() {
		return btnBackToLogin;
	}

	public void setBtnBackToLogin(JButton btnBackToLogin) {
		this.btnBackToLogin = btnBackToLogin;
	}

	public void init() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 500);
		setLocationRelativeTo(null);
		setResizable(false);
		
		// Sự kiện
		ActionListener action = new SignUpControl(this);

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
		lblImg.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(SignUp.class.getResource("../images/bg_signin.jpg"))));
		lblImg.setBounds(0, 0, 395, 461);
		pnlImg.add(lblImg);

		pnlSignUp = new JPanel();
		pnlSignUp.setBackground(new Color(129, 212, 250));
		pnlSignUp.setBounds(393, 0, 395, 461);
		panel.add(pnlSignUp);
		pnlSignUp.setLayout(null);
		
		lblRegister = new JLabel("Register");
		lblRegister.setFont(new Font("Sitka Small", Font.BOLD, 24));
		lblRegister.setBounds(151, 66, 116, 28);
		pnlSignUp.add(lblRegister);
		
		lblUserName = new JLabel("UserName");
		lblUserName.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblUserName.setBounds(110, 119, 58, 14);
		pnlSignUp.add(lblUserName);
		
		iconUser = new JLabel("");
		iconUser.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(SignUp.class.getResource("../images/user.png"))));
		iconUser.setBounds(78, 136, 22, 28);
		pnlSignUp.add(iconUser);
		
		txtUserName = new JTextField();
		txtUserName.setFont(new Font("Arial", Font.BOLD, 12));
		txtUserName.setColumns(10);
		txtUserName.setBorder(null);
		txtUserName.setBackground(new Color(129, 212, 250));
		txtUserName.setBounds(110, 141, 199, 20);
		txtUserName.requestFocusInWindow();
		pnlSignUp.add(txtUserName);
		
		sepUserName = new JSeparator();
		sepUserName.setBackground(Color.BLACK);
		sepUserName.setBounds(110, 160, 199, 2);
		pnlSignUp.add(sepUserName);
		
		lblPass = new JLabel("Password");
		lblPass.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblPass.setBounds(110, 177, 58, 14);
		pnlSignUp.add(lblPass);
		
		iconPass = new JLabel("");
		iconPass.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(SignUp.class.getResource("../images/lock.png"))));
		iconPass.setBounds(78, 193, 22, 28);
		pnlSignUp.add(iconPass);

		txtPass = new JPasswordField();
		txtPass.setEchoChar('*');
		txtPass.setFont(new Font("Arial", Font.BOLD, 12));
		txtPass.setBackground(new Color(129, 212, 250));
		txtPass.setBounds(110, 199, 199, 20);
		txtPass.setBorder(null);
		txtPass.requestFocusInWindow();
		pnlSignUp.add(txtPass);
		txtPass.setColumns(10);

		sepPass = new JSeparator();
		sepPass.setBackground(new Color(0, 0, 0));
		sepPass.setBounds(110, 218, 199, 2);
		pnlSignUp.add(sepPass);

		iconHiddenPass = new JButton(new ImageIcon("../images/hidPass.png"));
//		iconHiddenPass = new JButton();
		iconHiddenPass.addActionListener(action);
		iconHiddenPass.setFocusPainted(false);
		iconHiddenPass.setBorderPainted(false);
		iconHiddenPass.setContentAreaFilled(false);
		iconHiddenPass.setBounds(310, 197, 22, 23);
		iconHiddenPass.setCursor(new Cursor(Cursor.HAND_CURSOR));
		pnlSignUp.add(iconHiddenPass);	
		
		lblConfPass = new JLabel("Confirm Password");
		lblConfPass.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblConfPass.setBounds(110, 235, 90, 14);
		pnlSignUp.add(lblConfPass);
			
		iconConfPass = new JLabel("");
		iconConfPass.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(SignUp.class.getResource("../images/confpass.png"))));
		iconConfPass.setBounds(75, 255, 22, 28);
		pnlSignUp.add(iconConfPass);
		
		txtConfPass = new JPasswordField();
		txtConfPass.setEchoChar('*');
		txtConfPass.setFont(new Font("Arial", Font.BOLD, 12));
		txtConfPass.setBackground(new Color(129, 212, 250));
		txtConfPass.setBounds(110, 257, 199, 20);
		txtConfPass.requestFocusInWindow();
		txtConfPass.setBorder(null);
		pnlSignUp.add(txtConfPass);
		
		sepConfPass = new JSeparator();
		sepConfPass.setBackground(new Color(0, 0, 0));
		sepConfPass.setBounds(110, 276, 199, 2);
		pnlSignUp.add(sepConfPass);
		
		lblEmail = new JLabel("Email");
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblEmail.setBounds(110, 293, 38, 14);
		pnlSignUp.add(lblEmail);
		
		iconEmail = new JLabel("");
		iconEmail.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(SignUp.class.getResource("../images/email.png"))));
		iconEmail.setBounds(78, 311, 22, 28);
		pnlSignUp.add(iconEmail);
		
		txtEmail = new JTextField();
		txtEmail.setFont(new Font("Arial", Font.BOLD, 12));
		txtEmail.setColumns(10);
		txtEmail.setBorder(null);
		txtEmail.setBackground(new Color(129, 212, 250));
		txtEmail.setBounds(110, 315, 199, 20);
		txtEmail.requestFocusInWindow();
		pnlSignUp.add(txtEmail);
	
		sepEmail = new JSeparator();
		sepEmail.setBackground(Color.BLACK);
		sepEmail.setBounds(110, 334, 199, 2);
		pnlSignUp.add(sepEmail);
		
		btnRegister = new JButton("Register");
		btnRegister.addActionListener(action);
		btnRegister.setFocusPainted(false);
		btnRegister.setBorderPainted(false);
		btnRegister.setFont(new Font("Arial", Font.PLAIN, 14));
		btnRegister.setBorder(new LineBorder(new Color(92, 107, 192)));
		btnRegister.setBackground(new Color(125, 229, 251));
		btnRegister.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnRegister.setBounds(110, 356, 199, 37);
		pnlSignUp.add(btnRegister);
		
		btnBackToLogin = new JButton("Back to Login");
		btnBackToLogin.addActionListener(action);
		btnBackToLogin.setBorderPainted(false);
		btnBackToLogin.setFont(new Font("Arial", Font.PLAIN, 11));
		btnBackToLogin.setFocusPainted(false);
		btnBackToLogin.setContentAreaFilled(false);
		btnBackToLogin.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnBackToLogin.setBounds(152, 406, 116, 23);
		pnlSignUp.add(btnBackToLogin);		
	}

	// Show Password
	public void showPass() {
		ActionListener action = new SignUpControl(this);
		iconShowPass = new JButton(new ImageIcon("../images/showPass.png"));
		iconShowPass.addActionListener(action);
		iconShowPass.setFocusPainted(false);
		iconShowPass.setBorderPainted(false);
		iconShowPass.setContentAreaFilled(false);
		iconShowPass.setBounds(310, 197, 22, 23);
		iconShowPass.setCursor(new Cursor(Cursor.HAND_CURSOR));
		pnlSignUp.add(iconShowPass);
		iconShowPass.setVisible(true);
		iconHiddenPass.setVisible(false);
		txtPass.setEchoChar((char)0);
		txtConfPass.setEchoChar((char)0);
	}
	
	// Hidden Password
	public void hidPass() {
		iconShowPass.setVisible(false);
		iconHiddenPass.setVisible(true);
		txtPass.setEchoChar('*');
		txtConfPass.setEchoChar('*');
	}
	
	// Change to Login form
	public void chgLogin() {
		SignIn signIn = new SignIn();
		signIn.setVisible(true);
		dispose();
	}
	
	
}
