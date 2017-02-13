package andiamoTrust.views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import org.apache.logging.log4j.LogManager;

public class Main extends LauncherViews {

	private static final long serialVersionUID = -5136872760546330710L;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	
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
		
		getContentPane().setBackground(new Color(21, 58, 76));
		setIconImage(Toolkit.getDefaultToolkit().getImage("img/ayct_ico.png"));
		setBackground(new Color(42, 129, 172));
		setFont(new Font("Calibri", Font.PLAIN, 20));
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1000, 800);
		setLocationRelativeTo(null);
		setResizable(true);
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		
		JPanel pnlInfo = new JPanel();
		pnlInfo.setBackground(new Color(21, 58, 76));
		getContentPane().add(pnlInfo, BorderLayout.NORTH);
		pnlInfo.setLayout(new BorderLayout(0, 0));
		
		JLabel lblLogo = new JLabel("Andiamo Youth Coperative Trust");
		lblLogo.setVerticalAlignment(SwingConstants.CENTER);
		lblLogo.setForeground(new Color(38, 189, 238));
		lblLogo.setFont(new Font("Calibri", Font.PLAIN, 30));
		pnlInfo.add(lblLogo, BorderLayout.WEST);
		
		JPanel pnlUser = new JPanel();
		pnlInfo.add(pnlUser, BorderLayout.EAST);
		pnlUser.setLayout(new BorderLayout(0, 0));
		pnlUser.setBackground(new Color(21, 58, 76));
		
		JLabel lblUserImg = new JLabel("", new ImageIcon("img/user.png"), SwingConstants.CENTER);
		lblUserImg.setBorder(new EmptyBorder(10, 0, 10, 20));
		pnlUser.add(lblUserImg, BorderLayout.EAST);
		JLabel lblUser = new JLabel(getSessionUser().getUsername());
		lblUser.setBorder(new EmptyBorder(0, 0, 0, 20));
		pnlUser.add(lblUser, BorderLayout.WEST);
		lblUser.setForeground(Color.WHITE);
		lblUser.setFont(new Font("Calibri", Font.PLAIN, 20));
		
		JTabbedPane tabbedPnlMain = new JTabbedPane(JTabbedPane.LEFT);
		tabbedPnlMain.setFont(new Font("Calibri", Font.PLAIN, 20));
		tabbedPnlMain.setBackground(new Color(21, 58, 76));
		tabbedPnlMain.setForeground(Color.WHITE);
		tabbedPnlMain.setBorder(new EmptyBorder(0, 0, 0, 0));
		getContentPane().add(tabbedPnlMain, BorderLayout.CENTER);
		
		JPanel pnlWelcome = new JPanel();
		pnlWelcome.setBorder(new EmptyBorder(0, 0, 0, 0));
		pnlWelcome.setBackground(new Color(42, 129, 172));
		tabbedPnlMain.addTab("Welcome", null, pnlWelcome, null);
		pnlWelcome.setLayout(null);
		
		JLabel lblTestoDiProva = new JLabel("Testo di prova");
		lblTestoDiProva.setFont(new Font("Calibri", Font.PLAIN, 20));
		lblTestoDiProva.setBounds(112, 112, 221, 20);
		pnlWelcome.add(lblTestoDiProva);
		
		textField = new JTextField();
		textField.setBounds(112, 148, 243, 34);
		pnlWelcome.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(112, 275, 243, 40);
		pnlWelcome.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblTestTest = new JLabel("Test 2 test");
		lblTestTest.setFont(new Font("Calibri", Font.PLAIN, 20));
		lblTestTest.setBounds(112, 239, 131, 20);
		pnlWelcome.add(lblTestTest);
		
		textField_2 = new JTextField();
		textField_2.setBounds(112, 390, 243, 34);
		pnlWelcome.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblTestoNumero = new JLabel("Testo numero 3");
		lblTestoNumero.setBounds(112, 359, 166, 20);
		pnlWelcome.add(lblTestoNumero);
		
		JLabel lblNewTestOlungolabel = new JLabel("New Test olungolabel");
		lblNewTestOlungolabel.setBounds(634, 111, 166, 20);
		pnlWelcome.add(lblNewTestOlungolabel);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(634, 155, 279, 160);
		pnlWelcome.add(textArea);
		
		JPanel pnlJournalEntry = new JPanel();
		pnlJournalEntry.setBackground(new Color(42, 129, 172));
		tabbedPnlMain.addTab("Journal Entry", null, pnlJournalEntry, null);
		pnlJournalEntry.setLayout(null);
		
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
