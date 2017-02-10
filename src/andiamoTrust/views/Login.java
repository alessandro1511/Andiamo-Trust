package andiamoTrust.views;

import java.awt.BorderLayout;
import java.awt.Color;
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
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import andiamoTrust.dao.base.MyBatisConnectionFactory;
import andiamoTrust.dao.base.UserDAO;
import andiamoTrust.dao.dto.UserDTO;

public class Login extends Master {

	private static final long serialVersionUID = 6694992819726401761L;
	private JPanel globalPnlLogin;
	private JTextField textUsername;
	private JPasswordField passwordField;

	public Login() {
		getLogger().info("initialization login");
		setIconImage(Toolkit.getDefaultToolkit().getImage("img/ayct.png"));
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 600, 500);
		setLocationRelativeTo(null);
		setResizable(false);
		
		globalPnlLogin = new JPanel();
		globalPnlLogin.setBackground(new Color(42, 129, 172));
		setContentPane(globalPnlLogin);
		globalPnlLogin.setLayout(null);
		
		JPanel pnlLogo = new JPanel();
		pnlLogo.setBackground(new Color(42, 129, 172));
		pnlLogo.setBounds(0, 0, 594, 150);
		globalPnlLogin.add(pnlLogo);
		
		ImageIcon imageIcon = new ImageIcon(new ImageIcon("img/ayct.png").getImage().getScaledInstance(300, 110, Image.SCALE_SMOOTH));
		pnlLogo.setLayout(new BorderLayout(0, 0));
		JLabel lblLogo = new JLabel("", imageIcon, JLabel.CENTER);
		pnlLogo.add(lblLogo);
		lblLogo.setBorder(new EmptyBorder(0, 0, 0, 0));
		lblLogo.setHorizontalAlignment(SwingConstants.CENTER);
		lblLogo.setFont(new Font("Calibri", Font.BOLD, 20));
		
		JPanel pnlLogin = new JPanel();
		pnlLogin.setBounds(15, 150, 564, 257);
		globalPnlLogin.add(pnlLogin);
		pnlLogin.setBackground(new Color(42, 129, 172));
		pnlLogin.setLayout(null);
		pnlLogin.setVisible(true);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setBounds(85, 16, 383, 20);
		lblUsername.setFont(new Font("Calibri", Font.PLAIN, 20));
		pnlLogin.add(lblUsername);
		
		textUsername = new JTextField();
		textUsername.setBounds(85, 40, 383, 40);
		textUsername.setFont(new Font("Calibri", Font.PLAIN, 20));
		pnlLogin.add(textUsername);
		textUsername.setColumns(10);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(85, 96, 383, 20);
		lblPassword.setFont(new Font("Calibri", Font.PLAIN, 20));
		pnlLogin.add(lblPassword);
		
		passwordField = new JPasswordField();
		passwordField.setFont(new Font("Calibri", Font.PLAIN, 20));
		passwordField.setBounds(85, 120, 383, 40);
		pnlLogin.add(passwordField);
		
		JButton btnOk = new JButton("Login");
		btnOk.setForeground(Color.BLACK);
		btnOk.setBackground(new Color(216, 216, 216));
		btnOk.setBounds(85, 201, 383, 40);
		pnlLogin.add(btnOk);
		btnOk.setFont(new Font("Calibri", Font.PLAIN, 20));
		
		JPanel pnlRetry = new JPanel();
		pnlRetry.setBackground(new Color(42, 129, 172));
		pnlRetry.setBounds(15, 150, 564, 257);
		globalPnlLogin.add(pnlRetry);
		pnlRetry.setVisible(false);
		pnlRetry.setBorder(new EmptyBorder(10, 0, 25, 0));
		pnlRetry.setLayout(null);
		
		JLabel lblRetry = new JLabel("The Username or Password are incorrect");
		lblRetry.setHorizontalAlignment(SwingConstants.CENTER);
		lblRetry.setFont(new Font("Calibri", Font.PLAIN, 20));
		lblRetry.setBounds(0, 70, 564, 20);
		pnlRetry.add(lblRetry);
		
		JButton btnRetry = new JButton("Ok, retry");
		btnRetry.setForeground(Color.BLACK);
		btnRetry.setBackground(new Color(216, 216, 216));
		btnRetry.setBounds(85, 201, 383, 40);
		pnlRetry.add(btnRetry);
		btnRetry.setFont(new Font("Calibri", Font.PLAIN, 20));
		
		//Button actions
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				 try {
					 UserDAO userDAO = new UserDAO(MyBatisConnectionFactory.getSqlSessionFactory());
					 UserDTO user = new UserDTO();
					 user.setUsername(textUsername.getText());
					 user.setPassword(passwordField.getText());
					 sessionUser = userDAO.selectByKeys(user);
					 if (sessionUser != null)
					 {
						 getLogger().info("user found");
						 dispose();
						 Main frameMain = new Main();
					 }
					 else
					 {
						 getLogger().info("user didn't find");
						 pnlLogin.setVisible(false);
						 pnlRetry.setVisible(true);
						 passwordField.setText("");
					 }
				 } catch (Exception e) {
					 e.printStackTrace();
				 }
			}
		});
		
		btnRetry.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				getLogger().info("retry insert user");
				pnlRetry.setVisible(false);
				pnlLogin.setVisible(true);
			}
		});
		
		getLogger().info("initialization login complete");
	}
}