package andiamoTrust.views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import andiamoTrust.dao.dto.UserDTO;

public class Master extends JFrame {
	
	private static final long serialVersionUID = 6742096473341635479L;
	protected static Logger logger;
	public static UserDTO sessionUser;
	private static JFrame frame;
	
	/**
	 * Launch the application.
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					logger = LogManager.getLogger(this.getClass());
					Master window = new Master();
					initialize();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
		Thread.sleep(3000);
		frame.dispose();
		Login frameLogin = new Login();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private static void initialize() {
		getLogger().info("initialization master");
		
		frame = new JFrame();
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage("img/ayct_ico.png"));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBounds(0, 0, 600, 400);
		frame.setBackground(Color.WHITE);
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		
		ImageIcon imageIcon = new ImageIcon(new ImageIcon("img/ayct.png").getImage().getScaledInstance(500, 270, Image.SCALE_SMOOTH));
		JPanel pnlImage = new JPanel();
		pnlImage.setBackground(Color.WHITE);
		JLabel lblImage = new JLabel("", imageIcon, JLabel.CENTER);
		lblImage.setBackground(Color.WHITE);
		pnlImage.add(lblImage);
		frame.getContentPane().add(pnlImage, BorderLayout.CENTER);
		
		JPanel pnlLoading = new JPanel();
		pnlLoading.setBackground(Color.WHITE);
		frame.getContentPane().add(pnlLoading, BorderLayout.SOUTH);
		pnlLoading.setLayout(new BorderLayout(0, 0));
		
		JLabel lblLoading = new JLabel("Loading...");
		lblLoading.setHorizontalAlignment(SwingConstants.CENTER);
		lblLoading.setFont(new Font("Calibri", Font.PLAIN, 20));
		lblLoading.setBackground(Color.WHITE);
		pnlLoading.add(lblLoading, BorderLayout.NORTH);
		
		getLogger().info("initialization master complete");
	}

	public static Logger getLogger(){
		return logger;
	}

	public UserDTO getSessionUser() {
		return sessionUser;
	}

	public void setSessionUser(UserDTO sessionUser) {
		this.sessionUser = sessionUser;
	}
}
