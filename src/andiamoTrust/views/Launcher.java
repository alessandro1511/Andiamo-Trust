package andiamoTrust.views;

import java.awt.EventQueue;
import java.util.List;

import javax.swing.JFrame;

import org.apache.logging.log4j.Logger;

import andiamoTrust.dao.base.MyBatisConnectionFactory;
import andiamoTrust.dao.base.UserDAO;
import andiamoTrust.dao.dto.UserDTO;

public class Launcher extends JFrame {

	private static final long serialVersionUID = 6742096473341635479L;
	protected static Logger logger;
	public static UserDTO sessionUser;
	private static Master window;

	public static void main(String[] args) throws Exception {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					sessionUser = new UserDTO();
					window = new Master();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
		UserDAO userDAO = new UserDAO(MyBatisConnectionFactory.getSqlSessionFactory());
		List<UserDTO> testUser = userDAO.selectAll();
		Thread.sleep(5000);
		window.frame.dispose();
		Main frameLogin = new Main();
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
