package book.model.DAO;

import java.sql.SQLException;
import java.util.List;

public interface GenericDataAcessObject<T> {
	
	/*
	 
	 	This class defines an interface that will require the class programmer to implement the methods of a create,read,update,delete when 
	 	creating a class to instantiate objects that allow access to the database
	 */
	
	int insert(T entity) throws SQLException;
	T selectById(Integer id) throws SQLException;
	List<T> selectByAll() throws SQLException;
	int update(String email,Integer id) throws SQLException;
	int delete(Integer ind) throws SQLException;

}

