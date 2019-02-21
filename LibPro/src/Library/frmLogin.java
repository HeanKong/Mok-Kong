package Library;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import javax.swing.border.LineBorder;
import java.awt.Color;

public class frmLogin extends JFrame {

	private JPanel contentPane;
	private JTextField txtusername;
	private JPasswordField txtpassword;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frmLogin frame = new frmLogin();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public frmLogin() {
		initailize();
	}
	private void initailize() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 575, 320);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(Color.BLUE, 4));
		panel.setBounds(0, 0, 559, 281);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblUserName = new JLabel("USER NAME");
		lblUserName.setBounds(10, 68, 113, 25);
		panel.add(lblUserName);
		lblUserName.setIcon(new ImageIcon("E:\\Eclipse\\icon\\blue-user-icon.png"));
		lblUserName.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JLabel lblPassword = new JLabel("PASSWORD");
		lblPassword.setBounds(10, 102, 113, 25);
		panel.add(lblPassword);
		lblPassword.setIcon(new ImageIcon("E:\\Eclipse\\icon\\User-Interface-Password-icon.png"));
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		txtusername = new JTextField();
		txtusername.setBounds(133, 68, 209, 25);
		panel.add(txtusername);
		txtusername.setColumns(10);
		
		txtpassword = new JPasswordField();
		txtpassword.setBounds(133, 104, 209, 25);
		panel.add(txtpassword);
		txtpassword.setColumns(10);
		
		JButton btnLogin = new JButton("LogIn");
		btnLogin.setBounds(134, 166, 99, 28);
		panel.add(btnLogin);
		btnLogin.setIcon(new ImageIcon("E:\\Eclipse\\icon\\system-log-out-icon.png"));
		btnLogin.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.setBounds(243, 166, 113, 28);
		panel.add(btnCancel);
		btnCancel.setIcon(new ImageIcon("E:\\Eclipse\\icon\\Actions-edit-delete-icon.png"));
		btnCancel.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		JLabel lblForgotPasswort = new JLabel("Forgot Password");
		lblForgotPasswort.setBounds(210, 224, 99, 25);
		panel.add(lblForgotPasswort);
		lblForgotPasswort.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblForgotPasswort.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setBounds(380, 67, 153, 127);
		panel.add(lblNewLabel_1);
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setIcon(new ImageIcon("E:\\Eclipse\\icon\\Groups-Meeting-Dark-icon.png"));
		
		JLabel lblNewLabel = new JLabel("LOG IN YOUR ACCOUNT");
		lblNewLabel.setBounds(143, 11, 255, 28);
		panel.add(lblNewLabel);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
	}
}
