package Library;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;

public class frmCreateAcc extends JFrame {

	private JPanel contentPane;
	private JTextField txtCreateuser;
	private JPasswordField txtCreatepass;
	private JPasswordField txtCreatephone;
	private JPasswordField txtCreateqst;
	private JPasswordField txtCreateAns;
	private JPasswordField txtCreaterepass;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frmCreateAcc frame = new frmCreateAcc();
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
	public frmCreateAcc() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 689, 413);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBorder(new LineBorder(Color.BLUE, 4));
		panel.setBounds(0, 0, 673, 374);
		contentPane.add(panel);
		
		JLabel label = new JLabel("USER NAME");
		label.setIcon(new ImageIcon("E:\\Eclipse\\icon\\blue-user-icon.png"));
		label.setFont(new Font("Tahoma", Font.PLAIN, 13));
		label.setBounds(10, 68, 113, 25);
		panel.add(label);
		
		JLabel label_1 = new JLabel("PASSWORD");
		label_1.setIcon(new ImageIcon("E:\\Eclipse\\icon\\User-Interface-Password-icon.png"));
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		label_1.setBounds(10, 102, 113, 25);
		panel.add(label_1);
		
		txtCreateuser = new JTextField();
		txtCreateuser.setColumns(10);
		txtCreateuser.setBounds(174, 70, 209, 25);
		panel.add(txtCreateuser);
		
		txtCreatepass = new JPasswordField();
		txtCreatepass.setColumns(10);
		txtCreatepass.setBounds(174, 104, 209, 25);
		panel.add(txtCreatepass);
		
		JButton btnCreate = new JButton("Create");
		btnCreate.setIcon(new ImageIcon("E:\\Eclipse\\icon\\Apps-File-Save-B-icon.png"));
		btnCreate.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnCreate.setBounds(402, 297, 113, 40);
		panel.add(btnCreate);
		
		JButton txtCreatecancel = new JButton("Cancel");
		txtCreatecancel.setIcon(new ImageIcon("E:\\Eclipse\\icon\\Actions-edit-delete-icon.png"));
		txtCreatecancel.setFont(new Font("Tahoma", Font.BOLD, 12));
		txtCreatecancel.setBounds(538, 297, 113, 40);
		panel.add(txtCreatecancel);
		
		JLabel lblQuestions = new JLabel("Some Question\r\n");
		lblQuestions.setHorizontalAlignment(SwingConstants.CENTER);
		lblQuestions.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblQuestions.setBounds(174, 248, 99, 25);
		panel.add(lblQuestions);
		
		JLabel label_3 = new JLabel("");
		label_3.setIcon(new ImageIcon("E:\\Eclipse\\icon\\Users-icon.png"));
		label_3.setHorizontalAlignment(SwingConstants.CENTER);
		label_3.setBounds(421, 68, 209, 218);
		panel.add(label_3);
		
		JLabel lblCreateYourAccount = new JLabel("CREATE YOUR ACCOUNT");
		lblCreateYourAccount.setHorizontalAlignment(SwingConstants.CENTER);
		lblCreateYourAccount.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblCreateYourAccount.setBounds(194, 11, 255, 28);
		panel.add(lblCreateYourAccount);
		
		JLabel lblTelephone = new JLabel("TELEPHONE");
		lblTelephone.setIcon(new ImageIcon("E:\\Eclipse\\icon\\phone-icon.png"));
		lblTelephone.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblTelephone.setBounds(10, 178, 113, 25);
		panel.add(lblTelephone);
		
		txtCreatephone = new JPasswordField();
		txtCreatephone.setColumns(10);
		txtCreatephone.setBounds(174, 180, 209, 25);
		panel.add(txtCreatephone);
		
		JLabel lblQuestion = new JLabel("QUESTION");
		lblQuestion.setIcon(new ImageIcon("E:\\Eclipse\\icon\\FAQ-icon.png"));
		lblQuestion.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblQuestion.setBounds(10, 216, 113, 25);
		panel.add(lblQuestion);
		
		txtCreateqst = new JPasswordField();
		txtCreateqst.setColumns(10);
		txtCreateqst.setBounds(174, 218, 209, 25);
		panel.add(txtCreateqst);
		
		JLabel lblAnswer = new JLabel("ANSWER");
		lblAnswer.setIcon(new ImageIcon("E:\\Eclipse\\icon\\Exclamation-icon.png"));
		lblAnswer.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblAnswer.setBounds(10, 278, 113, 25);
		panel.add(lblAnswer);
		
		txtCreateAns = new JPasswordField();
		txtCreateAns.setColumns(10);
		txtCreateAns.setBounds(174, 284, 209, 64);
		panel.add(txtCreateAns);
		
		JLabel lblRepassword = new JLabel("RE_PASSWORD");
		lblRepassword.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblRepassword.setBounds(10, 140, 154, 25);
		panel.add(lblRepassword);
		
		txtCreaterepass = new JPasswordField();
		txtCreaterepass.setColumns(10);
		txtCreaterepass.setBounds(174, 144, 209, 25);
		panel.add(txtCreaterepass);
	}
}
