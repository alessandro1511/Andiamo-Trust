package andiamoTrust.views;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 700, 500);
		setLocationRelativeTo(null);
		setResizable(false);
		
		globalPnlLogin = new JPanel();
		globalPnlLogin.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(globalPnlLogin);
		globalPnlLogin.setLayout(null);
		
		JPanel pnlLogo = new JPanel();
		pnlLogo.setBounds(15, 0, 664, 85);
		globalPnlLogin.add(pnlLogo);
		pnlLogo.setLayout(new BorderLayout(0, 0));
		
		JLabel lblLogin = new JLabel("Login");
		pnlLogo.add(lblLogin);
		lblLogin.setBorder(new EmptyBorder(25, 0, 0, 0));
		lblLogin.setHorizontalAlignment(SwingConstants.CENTER);
		lblLogin.setFont(new Font("Calibri", Font.PLAIN, 60));
		
		JPanel pnlLogin = new JPanel();
		pnlLogin.setVisible(true);
		pnlLogin.setBounds(15, 101, 664, 311);
		globalPnlLogin.add(pnlLogin);
		pnlLogin.setLayout(null);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setBounds(141, 43, 383, 20);
		lblUsername.setFont(new Font("Calibri", Font.PLAIN, 20));
		pnlLogin.add(lblUsername);
		
		textUsername = new JTextField();
		textUsername.setBounds(141, 67, 383, 40);
		textUsername.setFont(new Font("Calibri", Font.PLAIN, 20));
		pnlLogin.add(textUsername);
		textUsername.setColumns(10);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(141, 123, 383, 20);
		lblPassword.setFont(new Font("Calibri", Font.PLAIN, 20));
		pnlLogin.add(lblPassword);
		
		passwordField = new JPasswordField();
		passwordField.setFont(new Font("Calibri", Font.PLAIN, 20));
		passwordField.setBounds(141, 147, 383, 40);
		pnlLogin.add(passwordField);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.setBounds(374, 243, 150, 40);
		pnlLogin.add(btnCancel);
		btnCancel.setFont(new Font("Calibri", Font.PLAIN, 20));
		
		JButton btnOk = new JButton("Ok");
		btnOk.setBounds(141, 243, 150, 40);
		pnlLogin.add(btnOk);
		btnOk.setFont(new Font("Calibri", Font.PLAIN, 20));
		
		JPanel pnlRetry = new JPanel();
		pnlRetry.setBounds(15, 163, 664, 249);
		globalPnlLogin.add(pnlRetry);
		pnlRetry.setVisible(false);
		pnlRetry.setVisible(false);
		pnlRetry.setBorder(new EmptyBorder(10, 0, 25, 0));
		pnlRetry.setLayout(null);
		
		JLabel lblRetry = new JLabel("The Username or Password are incorrect.");
		lblRetry.setHorizontalAlignment(SwingConstants.CENTER);
		lblRetry.setFont(new Font("Calibri", Font.PLAIN, 20));
		lblRetry.setBounds(0, 37, 664, 20);
		pnlRetry.add(lblRetry);
		
		JButton btnRetry = new JButton("Ok, retry");
		btnRetry.setFont(new Font("Calibri", Font.PLAIN, 20));
		btnRetry.setBounds(254, 178, 150, 40);
		pnlRetry.add(btnRetry);
		
		//Button actions
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				 try {
					 UserDAO userDAO = new UserDAO(MyBatisConnectionFactory.getSqlSessionFactory());
					 UserDTO user = new UserDTO();
					 user.setUsername(textUsername.getText());
					 user.setPassword(passwordField.getText());
					 UserDTO userResult = userDAO.selectByKeys(user);
					 if (userResult != null)
					 {
						 getLogger().info("user found");
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
		
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
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