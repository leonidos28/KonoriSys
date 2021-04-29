package MySQLAccess;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import Controllers.LoginCooController;
import Controllers.LoginProfController;

public class SqlAccessCooAuth {

	public static Connection connect = null;
	public static Statement statement = null;

	private static ResultSet resultSet = null;

	public ArrayList<String> readDataBaseList(String id) throws Exception {
		try {
			String user = null;
			Class.forName("com.mysql.cj.jdbc.Driver");
			connect = DriverManager.getConnection("jdbc:mysql://localhost/etudiant", "root", "12345678");
			statement = connect.createStatement();			
			resultSet = statement.executeQuery("Select * from coordinateur as c where c.idcoordinateur  = '"+ LoginCooController.idcoo +"';");
			ArrayList<String> listFil = new ArrayList<String>();
			while (resultSet.next()) {
				user = resultSet.getString(id);
				listFil.add(user);		
			}			
			Set<String> set = new HashSet<>(listFil);
			listFil.clear();
			listFil.addAll(set);			
			Collections.sort(listFil);
			return listFil;

		} catch (Exception e) {
			throw e;
		} finally {
			close();
		}

	}
	
	public ArrayList<String> DataBaseDependencies(String id) throws Exception {
		try {
			String user = null;
			Class.forName("com.mysql.cj.jdbc.Driver");
			connect = DriverManager.getConnection("jdbc:mysql://localhost/etudiant", "root", "12345678");
			statement = connect.createStatement();			
			resultSet = statement.executeQuery("Select * from semestre as s ;");
					
			ArrayList<String> listFil = new ArrayList<String>();
			while (resultSet.next()) {
				user = resultSet.getString(id);
				listFil.add(user);		
				System.out.println(user);
			}			
			Set<String> set = new HashSet<>(listFil);
			listFil.clear();
			listFil.addAll(set);			
			Collections.sort(listFil);
			return listFil;

		} catch (Exception e) {
			throw e;
		} finally {
			close();
		}

	}
	
	public static String readDataBase(String semestre, String filiere, String id, String module) throws Exception {
		try {
			String result = null;
			// This will load the MySQL driver, each DB has its own driver
			Class.forName("com.mysql.cj.jdbc.Driver");

			// Setup the connection with the DB
			connect = DriverManager.getConnection("jdbc:mysql://localhost/etudiant", "root", "12345678");

			// Statements allow to issue SQL queries to the database
			statement = connect.createStatement();
			// String query = id;
			// Result set get the result of the SQL query
			resultSet = statement.executeQuery("select * from module where idModule = '" + module + "' ;");

			while (resultSet.next()) {
				result = resultSet.getString(id);

				System.out.println(result);

			}

			return result;

		} catch (Exception e) {
			throw e;
		} finally {
			close();
		}

	}



// You need to close the resultSet
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