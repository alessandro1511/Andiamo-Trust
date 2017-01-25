package andiamoTrust.views;

import java.awt.BorderLayout;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class Login extends Master {

	private static final long serialVersionUID = 6694992819726401761L;
	private JPanel frameLogin;
	private JTextField textUsername;
	private JPasswordField passwordField;

	public Login() {
		getLogger().info("initialization login");
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 706, 791);
		setLocationRelativeTo(null);
		setResizable(false);
		
		frameLogin = new JPanel();
		frameLogin.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(frameLogin);
		frameLogin.setLayout(null);
		
		  
		
		JPanel pnlLogo = new JPanel();
		pnlLogo.setBounds(15, 0, 664, 85);
		frameLogin.add(pnlLogo);
		pnlLogo.setLayout(new BorderLayout(0, 0));
		
		JLabel lblLogin = new JLabel("Login");
		pnlLogo.add(lblLogin);
		lblLogin.setBorder(new EmptyBorder(25, 0, 0, 0));
		lblLogin.setHorizontalAlignment(SwingConstants.CENTER);
		lblLogin.setFont(new Font("Calibri", Font.PLAIN, 60));
		
		JPanel pnlLogin = new JPanel();
		pnlLogin.setBounds(15, 101, 664, 311);
		frameLogin.add(pnlLogin);
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
		
		JButton btnOk = new JButton("Ok");
		btnOk.setBounds(141, 243, 150, 40);
		pnlLogin.add(btnOk);
		btnOk.setFont(new Font("Calibri", Font.PLAIN, 20));
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.setBounds(374, 243, 150, 40);
		pnlLogin.add(btnCancel);
		btnCancel.setFont(new Font("Calibri", Font.PLAIN, 20));
		
		JPanel pnlRetry = new JPanel();
		pnlRetry.setBounds(15, 415, 664, 249);
		pnlRetry.setBorder(new EmptyBorder(10, 0, 25, 0));
		frameLogin.add(pnlRetry);
		pnlRetry.setLayout(null);
		
		JButton btnRetry = new JButton("Ok");
		btnRetry.setFont(new Font("Calibri", Font.PLAIN, 20));
		btnRetry.setBounds(268, 165, 150, 40);
		pnlRetry.add(btnRetry);
		
		JLabel lblRetry = new JLabel("The Username or Password are incorrect. Please Retry.");
		lblRetry.setHorizontalAlignment(SwingConstants.CENTER);
		lblRetry.setFont(new Font("Calibri", Font.PLAIN, 20));
		lblRetry.setBounds(0, 94, 664, 20);
		pnlRetry.add(lblRetry);
		getLogger().info("initialization login complete");
	}
}
