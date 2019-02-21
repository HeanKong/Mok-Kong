package Library;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Color;
import javax.swing.ImageIcon;

public class pnl_Home extends JPanel {
	private JLabel lblPic;
	private JLabel lblLiname;

	/**
	 * Create the panel.
	 */
	public pnl_Home(int x, int y) {
		this.setBounds(y, y, 995, 594);
		setLayout(null);
		
		lblPic = new JLabel("");
		lblPic.setIcon(new ImageIcon("E:\\Eclipse\\icon\\Books-1-icon.png"));
		lblPic.setHorizontalAlignment(SwingConstants.CENTER);
		lblPic.setBounds(326, 52, 612, 496);
		add(lblPic);
		
		lblLiname = new JLabel("BIRD LIBRARY");
		lblLiname.setHorizontalAlignment(SwingConstants.CENTER);
		lblLiname.setForeground(new Color(255, 99, 71));
		lblLiname.setFont(new Font("Tahoma", Font.BOLD, 40));
		lblLiname.setBounds(389, 11, 461, 71);
		add(lblLiname);
	}

}
