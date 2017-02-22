package andiamoTrust.dao.base;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import andiamoTrust.dao.dto.UserDTO;
import andiamoTrust.dao.interfaces.UserDAOInterface;

public class UserDAO {
	
	private SqlSessionFactory sqlSessionFactory = null;
	 
    public UserDAO(SqlSessionFactory sqlSessionFactory){
        this.sqlSessionFactory = sqlSessionFactory;
    }
     
    public List<UserDTO> selectAll() throws Exception{
    	List<UserDTO> list = null;
		SqlSession session = sqlSessionFactory.openSession();
		try {
			UserDAOInterface mapper = session.getMapper(UserDAOInterface.class);
			list = mapper.selectAll();
		} 
		catch(Exception e)
		{	
			throw new Exception(e);
		}
		finally {
			session.close();
		}
		return list;
    }
    
    public UserDTO selectByKeys(UserDTO input) throws Exception{
	   	UserDTO result = null;
		SqlSession session = sqlSessionFactory.openSession();
		try {
			UserDAOInterface mapper = session.getMapper(UserDAOInterface.class);
			result = mapper.selectByKeys(input);
		} 
		catch(Exception e)
		{	
			throw new Exception(e);
		}
		finally {
			session.close();
		}
		return result;
    }
    
    /**
     * Insert an instance of Person into the database.
     * @param person the instance to be persisted.
     */
   public int insert(UserDTO person){
       int id = -1;
        SqlSession session = sqlSessionFactory.openSession();
 
        try {
            id = session.insert("Person.insert", person);
        } finally {
            session.commit();
            session.close();
        }
        return id;
    }
    /**
   * Update an instance of Person into the database.
   * @param person the instance to be persisted.
   */
    public void update(UserDTO person){
       int id = -1;
      SqlSession session = sqlSessionFactory.openSession();
 
      try {
          id = session.update("Person.update", person);
 
      } finally {
          session.commit();
          session.close();
      }
  }
 
    /**
     * Delete an instance of Person from the database.
     * @param id value of the instance to be deleted.
     */
    public void delete(int id){
 
        SqlSession session = sqlSessionFactory.openSession();
 
        try {
            session.delete("Person.delete", id);
        } finally {
            session.commit();
            session.close();
        }
    }
}
