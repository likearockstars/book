package book.model.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import book.model.entities.Person;
import book.model.exception.CpfException;


public class PersonDAO implements GenericDataAcessObject<Person>{
	
	private static final String TablePerson = "public.Tb_Person";
	private static final String columnId = "person_id";
	private static final String columnFirstName = "first_name";
	private static final String columnLastName = "last_name";
	private static final String columnEmail = "email";
	
	
	private final Connection connection;
	
	public PersonDAO(Connection connection) {
		
		this.connection = connection;
	}
	

	@Override
	public int insert(Person entity) throws SQLException {
		
		if(entity == null) {
			
			throw new IllegalArgumentException("Dates of person not null!");
		}
		
		String comandInsert = String.format("INSERT INTO %s (%s,%s,%s,%s) VALUES (?,?,?,?)",TablePerson,columnId,columnFirstName,columnLastName,columnEmail);
		
		try(PreparedStatement pstInsert = connection.prepareStatement(comandInsert)){
			
			pstInsert.clearParameters();
			pstInsert.setInt(1,entity.getNumberId());
			pstInsert.setString(2, entity.getFirstName());
			pstInsert.setString(3, entity.getLastName());
			pstInsert.setString(4, entity.getEmail());
			return pstInsert.executeUpdate();
		}catch(SQLException SQLException) {
			
			System.err.println(SQLException);
		}
		
		return 0;
	}

	@Override
	public Person selectById(Integer id) throws SQLException {
		
		String comandSelectById = String.format(
			    "SELECT %s, %s, %s, %s FROM %s WHERE %s = ?", 
			    columnId, columnFirstName, columnLastName, columnEmail, TablePerson, columnId
			);

		
		try(PreparedStatement pstSelectById = connection.prepareStatement(comandSelectById)){
			pstSelectById.setInt(1, id);
			try(ResultSet rs =  pstSelectById.executeQuery()){
				
				if(rs.next()) {
					
					Person person = new Person(rs.getInt(columnId),rs.getString(columnFirstName),rs.getString(columnLastName), rs.getString(columnEmail));
					System.out.println(person.getFirstName());
					return person;
				}
				
			}	
			
		}catch(SQLException SQLException) {
			
			//System.out.println(SQLException.getCause());
			throw new SQLException("Error when selecting person by id");
		}catch(CpfException CpfException) {
			
			System.err.println(CpfException);
		}
		
		return null;
		
		
	}

	@Override
	public List<Person> selectByAll() throws SQLException {
		
		ArrayList<Person> persons = new ArrayList<Person>();
		
		String comandSelectAll = String.format("SELECT * FROM %s",TablePerson);
		
		try(PreparedStatement pstSelectAll = connection.prepareStatement(comandSelectAll)){
			
			try(ResultSet rs = pstSelectAll.executeQuery()){
				
				while(rs.next()) {
					
					Person person = new Person(rs.getInt(columnId),rs.getString(columnFirstName), rs.getString(columnLastName),rs.getString(columnEmail));
					persons.add(person);
				}
				
			}
			
		}catch(SQLException SQLException) {
			
			System.err.println(SQLException);
		}catch(CpfException CpfException) {
			
			System.err.println(CpfException);
		}
		
		return persons;
	}

	@Override
	public int update(String email, Integer id) {
		
		String comandUpdate = String.format("UPDATE %s set %s = ? WHERE %s  = ? ",TablePerson,columnEmail,columnId,id);
		
		// UPDATE Tb_Person set email = ?
		
		try(PreparedStatement pstUpdate = connection.prepareStatement(comandUpdate)) {
			
			pstUpdate.clearParameters();
			pstUpdate.setString(1, email);
			pstUpdate.setInt(2, id);
			return pstUpdate.executeUpdate();
			
		}catch(SQLException SQLException) {
			
			System.err.println(SQLException);
		}
		return 0;
	}




	@Override
	public int delete(Integer id){
		
		String comandDelete = String.format("DELETE FROM %s WHERE %s = ?",TablePerson,columnId);
		
		try(PreparedStatement pstDelete = connection.prepareStatement(comandDelete)){
			
			pstDelete.clearParameters();
			pstDelete.setInt(1, id);
			return pstDelete.executeUpdate();
			
		}catch(SQLException SQLException) {
			
			System.err.println(SQLException);
		}
		
		return 0;
	}
	

}
