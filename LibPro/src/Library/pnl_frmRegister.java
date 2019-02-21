package Library;

import javax.swing.JPanel;
import javax.swing.ButtonGroup;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JRadioButton;

import Classes.Member;
import Classes.getConnection;

import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.JTable;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.swing.border.LineBorder;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.ListSelectionModel;

public class pnl_frmRegister extends JPanel {
	public JTextField txtID;
	public JTextField txtfirstName;
	public JTextField txtlastName;
	public JLabel lblId ;
	public ButtonGroup group;
	public JTextField txtBirthDate;
	public JTextField txtPhone;
	public JTextField txtAddress;
	public JTextField txttotalborrow;
	public JTextField txtremain;
	private JTable tblMember;
	private JRadioButton rdbtnFemale;
	private JRadioButton rdbtnMale;
	private DefaultTableModel model;	
	
	//Theourn
	private ArrayList<Member> arrMembers = new ArrayList<Member>();
	
	/**
	 * Create the panel.
	 */
	public pnl_frmRegister(int x, int y) {
		setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Members Detail", TitledBorder.LEADING, TitledBorder.TOP,null, new Color(0, 0, 0)));
		setBackground(new Color(32, 178, 170));
		this.setBounds(x,y,1095, 641);
		
		initailize();
		SelectSql();
		storeDataToTable();
	}
	private void setTextCondition() {
		if(txtID.getText().equals("")) {
			JOptionPane.showMessageDialog(null, "Enter ID");
			txtID.requestFocus();
		}else if(txtfirstName.getText().equals("")) {
			JOptionPane.showMessageDialog(null, "Enter First Name");
			txtfirstName.requestFocus();
		}else if(txtlastName.getText().equals("")) {
			JOptionPane.showMessageDialog(null, "Enter Last Name");
			txtlastName.requestFocus();
		}else if(txtBirthDate.getText().equals("")) {
			JOptionPane.showMessageDialog(null, "Enter Birht Date");
			txtBirthDate.requestFocus();
		}else if(txtPhone.getText().equals("")) {
			JOptionPane.showMessageDialog(null, "Enter Phone Number");
			txtPhone.requestFocus();
		}else if(txtAddress.getText().equals("")) {
			JOptionPane.showMessageDialog(null, "Enter Address");
			txtAddress.requestFocus();
		}else{
			InsertSql();
		}
	}
	//Theourn Select database into ArrayList
		private void SelectSql() {
		
			String url = "jdbc:mysql://localhost:3306/librarymanagement";
			String user ="root";
			String pass ="123456789";
			String selectsql = "select * from tblmember";
			try {
				Connection myCon = DriverManager.getConnection(url,user,pass);
				PreparedStatement ps = myCon.prepareStatement(selectsql);
				ResultSet rs = ps.executeQuery();
				while(rs.next())
				{
					Member member = new Member();
					member.setMem_id(rs.getString(1)); member.setFirstname(rs.getString(2));
					member.setLastname(rs.getString(3)); member.setGender(rs.getString(4));
					member.setBirthdate(rs.getString(5)); member.setPhone(rs.getString(6));
					member.setAddress(rs.getString(7)); member.setTotalborrow(rs.getString(8));
					member.setRemain(rs.getString(9));
					
					arrMembers.add(member);
				}
				
				ps.close();
				rs.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
			
		}
		
		// Show data in ArrayList on JTable
		private void storeDataToTable()
		{
			for(Member onTable : arrMembers)
			{
				Object[] store = {onTable.getMem_id(),onTable.getFirstname(),onTable.getLastname(),onTable.getGender(),onTable.getBirthdate(),onTable.getPhone(),onTable.getAddress(),
									onTable.getTotalborrow(),onTable.getRemain()};
				
				model.addRow(store);
			}
		}
		
		
		private void InsertSql() {
			String driver = "com.mysql.cj.jdbc.Driver";
			String url = "jdbc:mysql://localhost:3306/librarymanagement";
			String user ="root";
			String pass ="123456789";
			try {
				//Class.forName(driver);
				Connection myCon = DriverManager.getConnection(url,user,pass);
				
				
				String id = txtID.getText();
				String firstname = txtfirstName.getText();
				String lastname = txtlastName.getText();
				String gender = rdbtnMale.isSelected() ? "male" : "female";
				String birthdate = txtBirthDate.getText();
				String phone = txtPhone.getText();
				String address = txtAddress.getText();
				String totalbrw = txttotalborrow.getText();
				String remain = txtremain.getText();
				
				
				int answer = JOptionPane.showConfirmDialog(null, "Do you want to save this?", "Message", JOptionPane.YES_NO_OPTION);
				if(answer == JOptionPane.YES_OPTION) {
					

					String insert = "insert into tblmember values(\'" + id + "\', \'" + firstname + "\',\'" + lastname + "\',\'" + gender + "\',\'" + birthdate + "\',"
							+ "\'" + phone + "\',\'" + address + "\',"+totalbrw+","+remain+")";						
					PreparedStatement ps = myCon.prepareStatement(insert);
					ps.execute();

					ps.close();
					
					model.addRow(new Object[] {
						id,
						firstname,
						lastname,
						gender,
						birthdate,
						phone,
						address,
						totalbrw,
						remain
					});
					
				}
				
			}catch(Exception e1) {
				JOptionPane.showConfirmDialog(null, "Database connection is failed !!", "Message", JOptionPane.CLOSED_OPTION);
			}
		}
	private void initailize() {
		
		String[] columnName=  {
			"ID", "First Name", "Last Name", "Gender", "Birth Date", "Telephone", "Address", "Totol Borrow", "Remain"
		};

		group = new ButtonGroup();
		setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 34, 347, 397);
		panel.setBorder(new TitledBorder(null, "Register Member", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		add(panel);
		panel.setLayout(null);
		
		lblId = new JLabel("ID");
		lblId.setBounds(10, 32, 112, 24);
		panel.add(lblId);
		lblId.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		txtID = new JTextField();
		txtID.setBounds(132, 31, 124, 25);
		panel.add(txtID);
		txtID.setColumns(10);
		
		JLabel lblName = new JLabel("First Name");
		lblName.setBounds(10, 68, 112, 24);
		panel.add(lblName);
		lblName.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		txtfirstName = new JTextField();
		txtfirstName.setBounds(132, 67, 157, 25);
		panel.add(txtfirstName);
		txtfirstName.setColumns(10);
		
			JLabel lblLastName = new JLabel("Last Name");
			lblLastName.setBounds(10, 104, 112, 24);
			panel.add(lblLastName);
			lblLastName.setFont(new Font("Tahoma", Font.BOLD, 14));
			
			txtlastName = new JTextField();
			txtlastName.setBounds(132, 103, 157, 25);
			panel.add(txtlastName);
			txtlastName.setColumns(10);
			
			JLabel lblGender = new JLabel("Gender");
			lblGender.setBounds(10, 135, 112, 24);
			panel.add(lblGender);
			lblGender.setFont(new Font("Tahoma", Font.BOLD, 14));
			
			//Male RadioButton
			rdbtnMale = new JRadioButton("Male");
			rdbtnMale.setBounds(132, 138, 62, 23);
			panel.add(rdbtnMale);
			rdbtnMale.setBackground(SystemColor.menu);
			rdbtnMale.setSelected(true);
			rdbtnMale.setFont(new Font("Tahoma", Font.BOLD, 12));
			group.add(rdbtnMale);
			
			//Female RadioButton
			rdbtnFemale = new JRadioButton("Female");
			rdbtnFemale.setBounds(212, 138, 77, 23);
			panel.add(rdbtnFemale);
			rdbtnFemale.setBackground(SystemColor.menu);
			rdbtnFemale.setFont(new Font("Tahoma", Font.BOLD, 12));
			group.add(rdbtnFemale);
			
			
			JLabel lblBirthDate = new JLabel("Birth Date");
			lblBirthDate.setBounds(10, 170, 112, 24);
			panel.add(lblBirthDate);
			lblBirthDate.setFont(new Font("Tahoma", Font.BOLD, 14));
			
			txtBirthDate = new JTextField();
			txtBirthDate.setBounds(132, 169, 157, 25);
			panel.add(txtBirthDate);
			txtBirthDate.setColumns(10);
			
			JLabel lblPhone = new JLabel("Phone");
			lblPhone.setBounds(10, 206, 112, 24);
			panel.add(lblPhone);
			lblPhone.setFont(new Font("Tahoma", Font.BOLD, 14));
			
			txtPhone = new JTextField();
			txtPhone.setBounds(132, 205, 157, 25);
			panel.add(txtPhone);
			txtPhone.setColumns(10);
			
			JLabel lblAddress = new JLabel("Address");
			lblAddress.setBounds(10, 242, 112, 24);
			panel.add(lblAddress);
			lblAddress.setFont(new Font("Tahoma", Font.BOLD, 14));
			
			txtAddress = new JTextField();
			txtAddress.setBounds(132, 241, 205, 25);
			panel.add(txtAddress);
			txtAddress.setColumns(10);
			
			JLabel lblJop = new JLabel("Total Borrow\r\n");
			lblJop.setBounds(10, 278, 112, 24);
			panel.add(lblJop);
			lblJop.setFont(new Font("Tahoma", Font.BOLD, 14));
			
			txttotalborrow = new JTextField();
			txttotalborrow.setBounds(132, 277, 112, 25);
			panel.add(txttotalborrow);
			txttotalborrow.setColumns(10);
			
			JLabel lblPlaceOfJop = new JLabel("Remain");
			lblPlaceOfJop.setBounds(10, 314, 112, 24);
			panel.add(lblPlaceOfJop);
			lblPlaceOfJop.setFont(new Font("Tahoma", Font.BOLD, 14));
			
			txtremain = new JTextField();
			txtremain.setBounds(132, 313, 112, 25);
			panel.add(txtremain);
			txtremain.setColumns(10);
			
			JPanel panel_1 = new JPanel();
			panel_1.setBounds(10, 442, 347, 111);
			panel_1.setBorder(new LineBorder(new Color(0, 0, 0)));
			add(panel_1);
			panel_1.setLayout(null);
			
			JButton btnEdit = new JButton("Edit");
			btnEdit.setBackground(SystemColor.inactiveCaptionBorder);
			btnEdit.setIcon(new ImageIcon("E:\\Eclipse\\icon\\edit-icon.png"));
			btnEdit.setFont(new Font("Tahoma", Font.BOLD, 11));
			btnEdit.setBounds(120, 15, 105, 36);
			panel_1.add(btnEdit);
			
			JButton btnDelete = new JButton("Delete");
			btnDelete.setBackground(SystemColor.inactiveCaptionBorder);
			btnDelete.setIcon(new ImageIcon("E:\\Eclipse\\icon\\Editing-Delete-icon.png"));
			btnDelete.setFont(new Font("Tahoma", Font.BOLD, 11));
			btnDelete.setBounds(10, 15, 105, 36);
			panel_1.add(btnDelete);
			
			JButton btnSave = new JButton("Save");
			btnSave.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					setTextCondition();
				}
			});
			btnSave.setBackground(SystemColor.inactiveCaptionBorder);
			btnSave.setIcon(new ImageIcon("E:\\Eclipse\\icon\\Save-icon.png"));
			btnSave.setFont(new Font("Tahoma", Font.BOLD, 11));
			btnSave.setBounds(230, 15, 105, 36);
			panel_1.add(btnSave);
			
			JButton btnNew = new JButton("New");
			btnNew.setIcon(new ImageIcon("E:\\Eclipse\\icon\\Actions-edit-clear-icon.png"));
			btnNew.setFont(new Font("Tahoma", Font.BOLD, 11));
			btnNew.setBackground(SystemColor.inactiveCaptionBorder);
			btnNew.setBounds(120, 62, 105, 36);
			panel_1.add(btnNew);
			
			model = new DefaultTableModel();
			model.setColumnIdentifiers(columnName);
			
			JScrollPane scrollPane = new JScrollPane();
			scrollPane.setBounds(367, 34, 718, 485);
			add(scrollPane);
			
			tblMember = new JTable(model);
			scrollPane.setViewportView(tblMember);
			
	}
	static Connection con() {
		return null;
	}
}
