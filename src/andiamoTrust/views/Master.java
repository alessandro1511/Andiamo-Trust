package andiamoTrust.views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import org.apache.logging.log4j.LogManager;

public class Master extends Launcher {
	
	private static final long serialVersionUID = 6742096473341635479L;
	public static JFrame frame;
	
	/**
	 * Create the application.
	 */
	public Master() throws Exception {
		logger = LogManager.getLogger(this.getClass());
		initialize();
	}
	
	/**
	 * Initialize the contents of the frame.
	 */
	private static void initialize() {
		getLogger().info("initialization master");
		
		frame = new JFrame();
		frame.setVisible(false);
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage("img/ayct_ico.png"));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBounds(0, 0, 600, 400);
		frame.setBackground(Color.WHITE);
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		frame.setUndecorated(true);
		
		ImageIcon imageIcon = new ImageIcon(new ImageIcon("img/ayct.png").getImage().getScaledInstance(600, 400, Image.SCALE_SMOOTH));
		JPanel pnlImage = new JPanel();
		pnlImage.setBackground(Color.WHITE);
		pnlImage.setLayout(new BorderLayout(0, 0));
		JLabel lblImage = new JLabel("", imageIcon, JLabel.CENTER);
		lblImage.setBackground(Color.WHITE);
		pnlImage.add(lblImage);
		frame.getContentPane().add(pnlImage, BorderLayout.CENTER);
		
		frame.setVisible(true);
		getLogger().info("initialization master complete");
	}
}
