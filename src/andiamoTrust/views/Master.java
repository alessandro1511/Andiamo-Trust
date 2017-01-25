package andiamoTrust.views;

import java.awt.EventQueue;

import javax.swing.JFrame;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public abstract class Master extends JFrame {

	private static final long serialVersionUID = -5543289367824198141L;
	protected Logger logger;
	
	public Master() {
		logger = LogManager.getLogger(this.getClass());
	}
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Logger getLogger(){
		return logger;
	}
}
