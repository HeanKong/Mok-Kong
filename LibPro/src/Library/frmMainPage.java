package Library;

import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JMenu;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.MouseWheelListener;
import java.util.ArrayList;
import java.awt.event.MouseWheelEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.event.AncestorListener;
import javax.swing.event.AncestorEvent;
import javax.swing.JProgressBar;
import javax.swing.JSlider;
import javax.swing.border.TitledBorder;
import javax.swing.border.LineBorder;
import javax.swing.JMenuItem;
import javax.swing.border.EtchedBorder;
import javax.swing.JSeparator;
import com.toedter.calendar.JDateChooser;

import Classes.Member;

public class frmMainPage {

	private JFrame frame;
	private final JPanel pnl_menu = new JPanel();
	private JPanel pnlBook;
	private JLabel lblHome;
	private JPanel pnlHome;
	private JLabel lblBook;
	private JPanel pnlRegister;
	private JLabel lblRegister;
	private JPanel pnlBorrow;
	private JLabel lblBorrow;
	private JPanel pnlReport;
	private JLabel lblReport;
	private JMenuBar menuBar;
	private JMenu mnOption;
	private JSeparator separator_1;
	private JMenuItem mntmCreateUser;
	private pnl_frmRegister pnlfrmRegister = new pnl_frmRegister(155, 0) ;
	private pnl_Home pnlHomepage = new pnl_Home(155, 0);
	
	

	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frmMainPage window = new frmMainPage();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public frmMainPage() {
		initialize();
		getPanelHome();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage("E:\\Eclipse\\icon\\Books-1-icon.png"));
		Toolkit tk = Toolkit.getDefaultToolkit();
		int xsize = (int) tk.getScreenSize().getWidth()-100;
		int ysize = (int) tk.getScreenSize().getHeight()-50;
		frame.setSize(xsize, ysize);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		pnl_menu.setBackground(new Color(65, 105, 225));
		pnl_menu.setBounds(0, 0, 155, 641);
		frame.getContentPane().add(pnl_menu);
		pnl_menu.setLayout(null);
		
		//panel Home
		pnlHome = new JPanel();
		pnlHome.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		pnlHome.setBackground(new Color(65, 105, 225));
		pnlHome.setBounds(0, 0, 155, 61);
		pnl_menu.add(pnlHome);
		pnlHome.setLayout(null);
		
		//Label Home
		lblHome = new JLabel("   Home");
		lblHome.setIcon(new ImageIcon("E:\\Eclipse\\icon\\blue-home-icon.png"));
		lblHome.setBackground(new Color(65, 105, 225));
		lblHome.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				setColor(pnlHome);
			}
			@Override
			public void mouseExited(MouseEvent arg0) {
				resetColor(pnlHome);
			}
			@Override
			public void mousePressed(MouseEvent arg0) {
				getPanelHome();
			}
		});
		lblHome.setForeground(new Color(255, 255, 255));
		lblHome.setHorizontalAlignment(SwingConstants.LEFT);
		lblHome.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblHome.setBounds(0, 0, 155, 61);
		pnlHome.add(lblHome);
		
		//panel Book
		pnlBook = new JPanel();
		pnlBook.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		pnlBook.setLayout(null);
		pnlBook.setBackground(new Color(65, 105, 225));
		pnlBook.setBounds(0, 60, 155, 61);
		pnl_menu.add(pnlBook);
		
		//Label Book
		lblBook = new JLabel("   Book");
		lblBook.setIcon(new ImageIcon("E:\\Eclipse\\icon\\Books-icon.png"));
		lblBook.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				setColor(pnlBook);
			}
			public void mouseExited(MouseEvent arg0) {
				resetColor(pnlBook);
			}
		});
		lblBook.setHorizontalAlignment(SwingConstants.LEFT);
		lblBook.setForeground(Color.WHITE);
		lblBook.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblBook.setBackground(new Color(65, 105, 225));
		lblBook.setBounds(0, 0, 155, 61);
		pnlBook.add(lblBook);
		
		//panel Register
		pnlRegister = new JPanel();
		pnlRegister.setLayout(null);
		pnlRegister.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		pnlRegister.setBackground(new Color(65, 105, 225));
		pnlRegister.setBounds(0, 116, 155, 61);
		pnl_menu.add(pnlRegister);
		
		//label Register
		lblRegister = new JLabel("   Register");
		lblRegister.setBounds(0, 0, 155, 61);
		pnlRegister.add(lblRegister);
		lblRegister.addMouseListener(new MouseAdapter() {
			
			public void mouseExited(MouseEvent e) {
				resetColor(pnlRegister);
			}
			
			public void mouseEntered(MouseEvent e) {
				setColor(pnlRegister);
			}
			@Override
			public void mousePressed(MouseEvent arg0) {
				getPanelRegister();
			}
		});
		lblRegister.setIcon(new ImageIcon("E:\\Eclipse\\icon\\Actions-contact-new-icon.png"));
		lblRegister.setHorizontalAlignment(SwingConstants.LEFT);
		lblRegister.setForeground(Color.WHITE);
		lblRegister.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblRegister.setBackground(new Color(65, 105, 225));
		
		//panel Borrow
		pnlBorrow = new JPanel();
		pnlBorrow.setLayout(null);
		pnlBorrow.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		pnlBorrow.setBackground(new Color(65, 105, 225));
		pnlBorrow.setBounds(0, 174, 155, 61);
		pnl_menu.add(pnlBorrow);
		
		//Label Borrow
		lblBorrow = new JLabel("   Borrow");
		lblBorrow.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent arg0) {
				setColor(pnlBorrow);
			}
			public void mouseExited(MouseEvent arg0) {
				resetColor(pnlBorrow);
			}
		});
		lblBorrow.setBounds(0, 0, 155, 61);
		pnlBorrow.add(lblBorrow);
		lblBorrow.setIcon(new ImageIcon("E:\\Eclipse\\icon\\box-out-icon.png"));
		lblBorrow.setHorizontalAlignment(SwingConstants.LEFT);
		lblBorrow.setForeground(Color.WHITE);
		lblBorrow.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblBorrow.setBackground(new Color(65, 105, 225));
		
		//panel Report
		pnlReport = new JPanel();
		pnlReport.setLayout(null);
		pnlReport.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		pnlReport.setBackground(new Color(65, 105, 225));
		pnlReport.setBounds(0, 234, 155, 61);
		pnl_menu.add(pnlReport);
		
		//label Report
		lblReport = new JLabel("   Report");
		lblReport.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				setColor(pnlReport);
			}
			public void mouseExited(MouseEvent arg0) {
				resetColor(pnlReport);
			}
		});
		lblReport.setBounds(0, 0, 155, 61);
		pnlReport.add(lblReport);
		lblReport.setIcon(new ImageIcon("E:\\Eclipse\\icon\\report-icon.png"));
		lblReport.setHorizontalAlignment(SwingConstants.LEFT);
		lblReport.setForeground(Color.WHITE);
		lblReport.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblReport.setBackground(new Color(65, 105, 225));
		
		//menu Bar
		menuBar = new JMenuBar();
		menuBar.setBackground(new Color(95, 158, 160));
		frame.setJMenuBar(menuBar);
		
		//menu Option
		mnOption = new JMenu("");
		mnOption.setForeground(new Color(0, 128, 128));
		mnOption.setIcon(new ImageIcon("E:\\Eclipse\\icon\\Very-Basic-Menu-icon.png"));
		menuBar.add(mnOption);
		
		JMenu mnNewMenu_1 = new JMenu("                                                "
				+ "                                                                    "
				+ "                                                                    "
				+ "                                                                    "
				+ "                                                                    "
				+ "                                                                   ");
		mnNewMenu_1.setEnabled(false);
		menuBar.add(mnNewMenu_1);
		
		JMenu mnNewMenu_2 = new JMenu("");
		mnNewMenu_2.setIcon(new ImageIcon("E:\\Eclipse\\icon\\user-icon (1).png"));
		menuBar.add(mnNewMenu_2);
		
		mntmCreateUser = new JMenuItem("Create User");
		mnNewMenu_2.add(mntmCreateUser);
		
		separator_1 = new JSeparator();
		mnNewMenu_2.add(separator_1);
		
		JMenuItem mntmAdmin = new JMenuItem("Admin");
		mntmAdmin.setIcon(new ImageIcon("E:\\Eclipse\\icon\\user-key-icon.png"));
		mnNewMenu_2.add(mntmAdmin);
		
		JMenuItem mntmLibrarian = new JMenuItem("Librarian");
		mntmLibrarian.setIcon(new ImageIcon("E:\\Eclipse\\icon\\bird-icon (1).png"));
		mnNewMenu_2.add(mntmLibrarian);
		
		JSeparator separator = new JSeparator();
		mnNewMenu_2.add(separator);
		
		JMenuItem mntmLogOut = new JMenuItem("Log Out");
		mntmLogOut.setIcon(new ImageIcon("E:\\Eclipse\\icon\\logout-icon.png"));
		mnNewMenu_2.add(mntmLogOut);
		
		frame.setLocationRelativeTo(null);
		
	}
	public void resetColor(JPanel p) {
		p.setBackground(new Color(65, 105, 225));
	}
	public void setColor(JPanel pl) {
		pl.setBackground(new Color(0, 130, 100));
	}
	private void getPanelRegister() {
		frame.getContentPane().remove(pnlHomepage);
		frame.getContentPane().add(pnlfrmRegister);
		frame.repaint();
	}
	private void getPanelHome() {
		frame.getContentPane().remove(pnlfrmRegister);
		pnlHomepage.setBounds(0, 0, 1250, 641);
		frame.getContentPane().add(pnlHomepage);
		frame.repaint();
	}
}
