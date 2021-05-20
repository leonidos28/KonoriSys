package MySQLAccess;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SqlAccessSaisieNote {

	public static boolean exist = false;
	public static Connection connect = null;
	public static Statement statement = null;
	private PreparedStatement preparedStatement = null;
	private static ResultSet resultSet = null;

	public String readDataBase(String query, int record, int option) throws Exception {
		try {
			String user = null;
			Class.forName("com.mysql.cj.jdbc.Driver");
			connect = DriverManager.getConnection("jdbc:mysql://localhost/etudiant", "root", "12345678");	
			statement = connect.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, 
                    ResultSet.CONCUR_UPDATABLE);
			resultSet = statement.executeQuery("SELECT * from etudiant ;");
			switch (option) {
			case 1:
				for (int i = 1; i <= record; i++) {
					resultSet.next();
					user = resultSet.getString(query);
				}
				break;
			case 0:
				for (int i = 1; i <= record; i++) {
					resultSet.next();
					
				}
				resultSet.previous();
				user = resultSet.getString(query);
				break;
			}
			
			

			return user;

		} catch (Exception e) {
			throw e;
		} finally {
			 close();
		}

	}

	public static void SavetoDataBaseNote(String value, String cne,String exam,String mat ) throws Exception {
		try {
			int result = 0;
			

			Class.forName("com.mysql.cj.jdbc.Driver");
			connect = DriverManager.getConnection("jdbc:mysql://localhost/etudiant", "root",
					"12345678");
			statement = connect.createStatement();
			
			result = statement.executeUpdate("UPDATE note SET note"+exam+" = '"
					+ value + "' where idEtudiant = "+ cne +" and idMatiere = '"+mat+"' ; ");

		} catch (Exception e) {
			throw e;
		} finally {
			 close();
		}

	}

	public static void FillDataBase(String cne,String mat) throws Exception {
		 try {
			 int result = 0; 
			 
		   Class.forName("com.mysql.cj.jdbc.Driver");
		   connect = DriverManager
		       .getConnection("jdbc:mysql://localhost/etudiant","root","12345678");
		   statement = connect.createStatement();
		  
		   result = statement
		       .executeUpdate("INSERT into note(idMatiere,idEtudiant) values ('"+mat+"','"+cne+"') ; ");
		   


		 } catch (Exception e) {
		   throw e;
		 } finally  {
			 close();
		 }

		}
	public static void existDataBase(String test1,String id1,String test2,String id2) throws Exception {
		 try {
			 String user = null ;
		   // This will load the MySQL driver, each DB has its own driver
		   Class.forName("com.mysql.cj.jdbc.Driver");
		   
		   // Setup the connection with the DB
		   connect = DriverManager
		       .getConnection("jdbc:mysql://localhost/etudiant","root","12345678");

		   // Statements allow to issue SQL queries to the database
		   statement = connect.createStatement();
		   
		   // Result set get the result of the SQL query
		   resultSet = statement
		       .executeQuery("SELECT * from note;");

		   while (resultSet.next()) {
				 user = resultSet.getString(test1);
				 exist = false;
				 if (user.contentEquals(id1)) {
					 user = resultSet.getString(test2);
					 if (user.contentEquals(id2)) {
						 exist = true ;
						 break;
					 }
				 }
				 
				}
		   
		   
		   
		   
		   
		 } catch (Exception e) {
		   throw e;
		 } finally {
			 close();
		 }
	}

	private static void close() {
		try {
			if (resultSet != null) {
				resultSet.close();
			}

			if (statement != null) {
				statement.close();
			}

			if (connect != null) {
				connect.close();
			}
		} catch (Exception e) {

		}
	}

}