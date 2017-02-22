package andiamoTrust.dao.interfaces;

import java.util.List;

import andiamoTrust.dao.dto.UserDTO;

public interface UserDAOInterface {

	public List<UserDTO> selectAll() throws Exception;
	
	public UserDTO selectByKeys(UserDTO input) throws Exception;
	
}
