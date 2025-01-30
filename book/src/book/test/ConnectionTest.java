package book.test;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import book.model.DAO.PersonDAO;
import book.model.entities.Person;
import book.model.exception.CpfException;
import book.utils.ConnectionFactory;

public class ConnectionTest {
	
	public static void main(String[] args) throws CpfException {
		
		try(Connection connection = ConnectionFactory.getConnection("localhost", "5433", "bd_livros", "postgres", "12345")){
			
			if(connection != null) {
				System.out.println("Connection successful!");
			}else {
				System.out.println("Connection error!");
			}
			
		}catch(SQLException SQLException) {
			
			System.err.println(SQLException);
			
		}
	}
	

}
