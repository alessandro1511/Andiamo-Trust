package andiamoTrust.views;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;

public class Login extends JFrame {

	private static final long serialVersionUID = 6694992819726401761L;
	private JPanel frameLogin;
	private JTextField textField;
	private JPasswordField passwordField;

	/**
	 * Create the frame.
	 */
	public Login() {
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 700, 500);
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
		
		textField = new JTextField();
		textField.setBounds(141, 67, 383, 40);
		textField.setFont(new Font("Calibri", Font.PLAIN, 20));
		pnlLogin.add(textField);
		textField.setColumns(10);
		
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
		pnlRetry.setBounds(137, 119, 406, 320);
		pnlRetry.setBorder(new EmptyBorder(10, 0, 25, 0));
		frameLogin.add(pnlRetry);
		pnlRetry.setLayout(null);
		
		JButton btnNewButton_2 = new JButton("New button");
		btnNewButton_2.setBounds(0, 0, 115, 29);
		pnlRetry.add(btnNewButton_2);
	}
}
