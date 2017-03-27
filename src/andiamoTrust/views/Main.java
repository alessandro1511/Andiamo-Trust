package andiamoTrust.views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;

import andiamoTrust.dao.base.MyBatisConnectionFactory;
import andiamoTrust.dao.base.UserDAO;
import andiamoTrust.dao.dto.UserDTO;

public class Main extends Launcher {

	private static final long serialVersionUID = -5136872760546330710L;
	private JFrame frame;
	
	/**
	 * Create the application.
	 */
	public Main() {
		logger = LogManager.getLogger(this.getClass());
		initialize();
	}
	
	/**
	 * Initialize the contents of the frame.
	 */
	public void initialize() {
		getLogger().info("initialization main");
		
		frame = new JFrame();
		frame.setVisible(false);
		frame.getContentPane().setBackground(new Color(21, 58, 76));
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage("img/ayct.png"));
		frame.setBackground(new Color(42, 129, 172));
		frame.setFont(new Font("Calibri", Font.PLAIN, 20));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBounds(0, 0, 1000, 800);
		frame.setLocationRelativeTo(null);
		frame.setResizable(true);
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		
		JPanel pnlInfo = new JPanel();
		pnlInfo.setBackground(new Color(21, 58, 76));
		pnlInfo.setLayout(new BorderLayout(0, 0));
		frame.getContentPane().add(pnlInfo, BorderLayout.NORTH);
		
		JLabel lblLogo = new JLabel("Andiamo Youth Coperative Trust");
		lblLogo.setBorder(new EmptyBorder(0, 20, 0, 0));
		lblLogo.setVerticalAlignment(SwingConstants.CENTER);
		lblLogo.setForeground(new Color(38, 189, 238));
		lblLogo.setFont(new Font("Calibri", Font.PLAIN, 30));
		pnlInfo.add(lblLogo, BorderLayout.WEST);
		
		JPanel pnlUser = new JPanel();
		pnlInfo.add(pnlUser, BorderLayout.EAST);
		pnlUser.setLayout(new BorderLayout(0, 0));
		pnlUser.setBackground(new Color(21, 58, 76));
		
		JLabel lblUserImg = new JLabel("", new ImageIcon("img/user_offline.png"), SwingConstants.CENTER);
		lblUserImg.setBorder(new EmptyBorder(10, 0, 10, 20));
		pnlUser.add(lblUserImg, BorderLayout.EAST);
		JLabel lblUser = new JLabel("");
		lblUser.setBorder(new EmptyBorder(0, 0, 0, 20));
		pnlUser.add(lblUser, BorderLayout.WEST);
		lblUser.setForeground(Color.WHITE);
		lblUser.setFont(new Font("Calibri", Font.PLAIN, 20));
		
		JTabbedPane tabbedPnlMain = new JTabbedPane(JTabbedPane.LEFT);
		tabbedPnlMain.setFont(new Font("Calibri", Font.PLAIN, 20));
		tabbedPnlMain.setBackground(new Color(21, 58, 76));
		tabbedPnlMain.setForeground(Color.BLACK);
		tabbedPnlMain.setBorder(new EmptyBorder(0, 0, 0, 0));
		JPanel pnlWelcome = new JPanel();
		pnlWelcome.setBorder(new EmptyBorder(0, 0, 0, 0));
		pnlWelcome.setBackground(new Color(42, 129, 172));
		tabbedPnlMain.addTab("Welcome", pnlWelcome);
		JLabel labelWelcome = new JLabel("Welcome");
		labelWelcome.setForeground(Color.WHITE);
		labelWelcome.setMinimumSize(new Dimension(200, 50));
		labelWelcome.setPreferredSize(new Dimension(200, 50));
		labelWelcome.setMaximumSize(new Dimension(200, 50));
		labelWelcome.setFont(new Font("Calibri", Font.PLAIN, 20));
		labelWelcome.setIconTextGap(25);
		labelWelcome.setIcon(new ImageIcon("img/ayct_ico.png"));
		labelWelcome.setHorizontalTextPosition(SwingConstants.RIGHT);
		labelWelcome.setEnabled(true);
		tabbedPnlMain.setTabComponentAt(0, labelWelcome);
		int indexWelcome = tabbedPnlMain.getTabCount() - 1;
		tabbedPnlMain.setEnabledAt(indexWelcome, true);
		JPanel pnlJournalEntry = new JPanel();
		pnlJournalEntry.setBackground(new Color(42, 129, 172));
		pnlJournalEntry.setLayout(null);
		tabbedPnlMain.addTab("Journal Entry", pnlJournalEntry);
		JLabel labelJournalEntry = new JLabel("Journal Entry");
		labelJournalEntry.setForeground(Color.WHITE);
		labelJournalEntry.setMinimumSize(new Dimension(200, 50));
		labelJournalEntry.setPreferredSize(new Dimension(200, 50));
		labelJournalEntry.setMaximumSize(new Dimension(200, 50));
		labelJournalEntry.setFont(new Font("Calibri", Font.PLAIN, 20));
		labelJournalEntry.setIconTextGap(25);
		labelJournalEntry.setIcon(new ImageIcon("img/profiles.png"));
		labelJournalEntry.setHorizontalTextPosition(SwingConstants.RIGHT);
		labelJournalEntry.setEnabled(false);
		tabbedPnlMain.setTabComponentAt(1, labelJournalEntry);
		int indexJournalEntry = tabbedPnlMain.getTabCount() - 1;
		tabbedPnlMain.setEnabledAt(indexJournalEntry, false);
		JPanel pnlSettings = new JPanel();
		pnlSettings.setBackground(new Color(42, 129, 172));
		pnlSettings.setLayout(null);
		tabbedPnlMain.addTab("Settings", pnlSettings);
		JLabel labelSettings = new JLabel("Settings");
		labelSettings.setForeground(Color.WHITE);
		labelSettings.setMinimumSize(new Dimension(200, 50));
		labelSettings.setPreferredSize(new Dimension(200, 50));
		labelSettings.setMaximumSize(new Dimension(200, 50));
		labelSettings.setFont(new Font("Calibri", Font.PLAIN, 20));
		labelSettings.setIconTextGap(25);
		labelSettings.setIcon(new ImageIcon("img/settings.png"));
		labelSettings.setHorizontalTextPosition(SwingConstants.RIGHT);
		labelSettings.setEnabled(false);
		tabbedPnlMain.setTabComponentAt(2, labelSettings);
		int indexSettings = tabbedPnlMain.getTabCount() - 1;
		tabbedPnlMain.setEnabledAt(indexSettings, false);
		frame.getContentPane().add(tabbedPnlMain, BorderLayout.CENTER);
		
		ImageIcon imageIcon = new ImageIcon(new ImageIcon("img/hands.png").getImage().getScaledInstance(500, 500, Image.SCALE_SMOOTH));
		pnlWelcome.setLayout(null);
		
		JPanel pnlLogin = new JPanel();
		pnlLogin.setBackground(new Color(42, 129, 172));
		pnlLogin.setBounds(540, 340, 450, 300);
		pnlWelcome.add(pnlLogin);
		pnlLogin.setLayout(null);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.setBounds(15, 235, 421, 35);
		pnlLogin.add(btnLogin);
		btnLogin.setForeground(Color.BLACK);
		btnLogin.setFont(new Font("Calibri", Font.PLAIN, 20));
		btnLogin.setBackground(new Color(216, 216, 216));
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setBounds(15, 16, 150, 26);
		pnlLogin.add(lblUsername);
		lblUsername.setFont(new Font("Calibri", Font.BOLD, 20));
		
		JTextField txtFieldUsername = new JTextField();
		txtFieldUsername.setBounds(15, 42, 421, 32);
		pnlLogin.add(txtFieldUsername);
		txtFieldUsername.setFont(new Font("Calibri", Font.PLAIN, 20));
		txtFieldUsername.setColumns(10);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(15, 118, 150, 26);
		pnlLogin.add(lblPassword);
		lblPassword.setFont(new Font("Calibri", Font.BOLD, 20));
		
		JPasswordField pwdFieldPassword = new JPasswordField();
		pwdFieldPassword.setBounds(15, 143, 421, 35);
		pnlLogin.add(pwdFieldPassword);
		pwdFieldPassword.setFont(new Font("Calibri", Font.PLAIN, 20));
		
		JPanel pnlRetry = new JPanel();
		pnlRetry.setBackground(new Color(42, 129, 172));
		pnlRetry.setForeground(new Color(0, 0, 0));
		pnlRetry.setBounds(515, 650, 500, 50);
		pnlRetry.setVisible(false);
		
		JPanel pnlLoginUser = new JPanel();
		pnlLoginUser.setBackground(new Color(42, 129, 172));
		pnlLoginUser.setBounds(515, 340, 500, 300);
		pnlLoginUser.setVisible(false);
		pnlWelcome.add(pnlLoginUser);
		pnlLoginUser.setLayout(null);
		
		JLabel lblLoginUser_1 = new JLabel("Welcome to Andiamo Youth Coperative Trust.");
		lblLoginUser_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblLoginUser_1.setFont(new Font("Calibri", Font.PLAIN, 20));
		lblLoginUser_1.setBounds(0, 0, 500, 30);
		pnlLoginUser.add(lblLoginUser_1);
		
		JLabel lblLoginUser_2 = new JLabel("Now you can work.");
		lblLoginUser_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblLoginUser_2.setFont(new Font("Calibri", Font.PLAIN, 20));
		lblLoginUser_2.setBounds(0, 30, 500, 30);
		pnlLoginUser.add(lblLoginUser_2);
		
		JLabel lblLoginUser_3 = new JLabel("When you finish your activity, please disconnect.");
		lblLoginUser_3.setBounds(0, 90, 500, 30);
		lblLoginUser_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblLoginUser_3.setFont(new Font("Calibri", Font.PLAIN, 20));
		pnlLoginUser.add(lblLoginUser_3);
		
		JButton btnDisconnect = new JButton("Disconnect");
		btnDisconnect.setFont(new Font("Calibri", Font.PLAIN, 20));
		btnDisconnect.setBackground(new Color(216, 216, 216));
		btnDisconnect.setBounds(40, 170, 421, 35);
		pnlLoginUser.add(btnDisconnect);
		pnlRetry.setLayout(new BorderLayout(0, 0));
		pnlWelcome.add(pnlRetry);
		
		JLabel lblRetry = new JLabel("The username or password are incorrect, please retry.");
		lblRetry.setForeground(new Color(38,189, 238));
		lblRetry.setFont(new Font("Calibri", Font.BOLD, 20));
		lblRetry.setHorizontalAlignment(SwingConstants.CENTER);
		pnlRetry.add(lblRetry, BorderLayout.NORTH);
		
		JPanel pnlHands = new JPanel();
		pnlHands.setBackground(new Color(42, 129, 172));
		pnlHands.setBounds(200, 50, 500, 500);
		pnlWelcome.add(pnlHands);
		pnlHands.setLayout(new BorderLayout(0, 0));
		JLabel lblHands = new JLabel("", imageIcon, JLabel.CENTER);
		pnlHands.add(lblHands);
		
		JPanel pnlExtra = new JPanel();
		frame.getContentPane().add(pnlExtra, BorderLayout.SOUTH);
		
		JLabel lblExtra = new JLabel(" ");
		pnlExtra.add(lblExtra);
		
		//Button actions
		btnLogin.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent arg0) {
				try {
					UserDAO userDAO = new UserDAO(MyBatisConnectionFactory.getSqlSessionFactory());
					UserDTO user = new UserDTO();
					user.setUsername(txtFieldUsername.getText());
					user.setPassword(pwdFieldPassword.getText());
					sessionUser = userDAO.selectByKeys(user);
					if (sessionUser != null)
					{
						getLogger().info("user connected");
						lblUser.setText(sessionUser.getName() + " " + sessionUser.getSurname());
						tabbedPnlMain.setEnabledAt(indexJournalEntry, true);
						labelJournalEntry.setEnabled(true);
						tabbedPnlMain.setEnabledAt(indexSettings, true);
						labelSettings.setEnabled(true);
						if (StringUtils.isNotBlank(sessionUser.getSex()) && sessionUser.getSex().toUpperCase().equals("M"))
							lblUserImg.setIcon(new ImageIcon("img/user_m_online.png"));
						else
							lblUserImg.setIcon(new ImageIcon("img/user_f_online.png"));
						pnlRetry.setVisible(false);
						pnlLogin.setVisible(false);
						pnlLoginUser.setVisible(true);
					}
					else
					{
						getLogger().info("user didn't find");
						tabbedPnlMain.setEnabledAt(indexJournalEntry, false);
						labelJournalEntry.setEnabled(false);
						tabbedPnlMain.setEnabledAt(indexSettings, false);
						labelSettings.setEnabled(false);
						pnlLogin.setVisible(true);
						pnlRetry.setVisible(true);
						pnlLoginUser.setVisible(false);
						pwdFieldPassword.setText("");
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
		btnDisconnect.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try{
					getLogger().info("user disconnected");
					sessionUser = new UserDTO();
					tabbedPnlMain.setEnabledAt(indexJournalEntry, false);
					labelJournalEntry.setEnabled(false);
					tabbedPnlMain.setEnabledAt(indexSettings, false);
					labelSettings.setEnabled(false);
					lblUserImg.setIcon(new ImageIcon("img/user_offline.png"));
					lblUser.setText("");
					txtFieldUsername.setText("");
					pwdFieldPassword.setText("");
					pnlLoginUser.setVisible(false);
					pnlRetry.setVisible(false);
					pnlLogin.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
		frame.setVisible(true);
		getLogger().info("initialization main complete");
	}
}
