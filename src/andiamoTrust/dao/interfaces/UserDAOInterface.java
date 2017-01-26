package andiamoTrust.dao.interfaces;

import andiamoTrust.dao.dto.UserDTO;

public interface UserDAOInterface {

	public UserDTO selectByKeys(UserDTO input) throws Exception;
	
}
