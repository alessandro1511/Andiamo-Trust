package andiamoTrust.views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.border.EmptyBorder;

import java.awt.Font;
import java.awt.Image;

import javax.swing.ImageIcon;

public class Main extends Master {

	private static final long serialVersionUID = -5136872760546330710L;
	
	public Main() {
		getLogger().info("initialization main");
		setIconImage(Toolkit.getDefaultToolkit().getImage("img/ayct.ico"));
		setBackground(new Color(42, 129, 172));
		setFont(new Font("Calibri", Font.PLAIN, 20));
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1000, 800);
		setLocationRelativeTo(null);
		setResizable(true);
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		
		JPanel pnlInfo = new JPanel();
		getContentPane().add(pnlInfo, BorderLayout.NORTH);
		pnlInfo.setLayout(new BorderLayout(0, 0));
		
		JLabel lblUser = new JLabel("User");
		lblUser.setText(getSessionUser().getUsername());
		lblUser.setFont(new Font("Calibri", Font.PLAIN, 20));
		pnlInfo.add(lblUser, BorderLayout.EAST);
		
		ImageIcon imageIcon = new ImageIcon(new ImageIcon("img/ayct.png").getImage().getScaledInstance(200, 75, Image.SCALE_SMOOTH));
		JLabel lblLogo = new JLabel("", imageIcon, JLabel.CENTER);
		lblLogo.setFont(new Font("Calibri", Font.PLAIN, 20));
		
		pnlInfo.add(lblLogo, BorderLayout.WEST);
		
		JTabbedPane tabbedPnlMain = new JTabbedPane(JTabbedPane.LEFT);
		tabbedPnlMain.setFont(new Font("Calibri", Font.PLAIN, 20));
		getContentPane().add(tabbedPnlMain, BorderLayout.CENTER);
		
		JPanel pnlWelcome = new JPanel();
		pnlWelcome.setBackground(new Color(42, 129, 172));
		tabbedPnlMain.addTab("Welcome", null, pnlWelcome, null);
		
		JPanel pnlJournalEntry = new JPanel();
		pnlJournalEntry.setBackground(new Color(42, 129, 172));
		tabbedPnlMain.addTab("Journal Entry", null, pnlJournalEntry, null);
		
		JPanel pnlSettings = new JPanel();
		pnlSettings.setBackground(new Color(42, 129, 172));
		tabbedPnlMain.addTab("Settings", null, pnlSettings, null);
		pnlSettings.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setBounds(89, 60, 69, 20);
		pnlSettings.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setBounds(220, 158, 69, 20);
		pnlSettings.add(lblNewLabel_2);
		
		JPanel pnlExtra = new JPanel();
		getContentPane().add(pnlExtra, BorderLayout.SOUTH);
		
		JLabel lblNewLabel_3 = new JLabel("New label");
		pnlExtra.add(lblNewLabel_3);
		
		getLogger().info("initialization main complete");
	}
}
