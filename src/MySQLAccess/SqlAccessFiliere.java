package MySQLAccess;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class SqlAccessFiliere {

	public static Connection connect = null;
	public static Statement statement = null;
	private PreparedStatement preparedStatement = null;
	private static ResultSet resultSet = null;

	public ArrayList<String> readDataBaseList(String id) throws Exception {
		try {
			String user = null;
			// This will load the MySQL driver, each DB has its own driver
			Class.forName("com.mysql.cj.jdbc.Driver");

			// Setup the connection with the DB
			connect = DriverManager.getConnection("jdbc:mysql://localhost/etudiant", "root", "Imad28082001");

			// Statements allow to issue SQL queries to the database
			statement = connect.createStatement();
			// String query = id;
			// Result set get the result of the SQL query
			resultSet = statement.executeQuery("select * from "+id+" ;");
			ArrayList<String> listFil = new ArrayList<String>();
			while (resultSet.next()) {
				user = resultSet.getString("id"+id);
					listFil.add(user);
				
				
				System.out.println(user);

			}

			return listFil;

		} catch (Exception e) {
			throw e;
		} finally {
			close();
		}

	}

	public ArrayList<String> readDataBaseModule(String semestre, String filiere) throws Exception {
		try {
			String user = null;
			// This will load the MySQL driver, each DB has its own driver
			Class.forName("com.mysql.cj.jdbc.Driver");

			// Setup the connection with the DB
			connect = DriverManager.getConnection("jdbc:mysql://localhost/etudiant", "root", "Imad28082001");

			// Statements allow to issue SQL queries to the database
			statement = connect.createStatement();
			// String query = id;
			// Result set get the result of the SQL query
			resultSet = statement.executeQuery("select * from module where semestre = '"+semestre+"' and ( filiere = '"+filiere+"' or filiere = 'NA' ) ;");
			ArrayList<String> listFil = new ArrayList<String>();
			while (resultSet.next()) {
				user = resultSet.getString("idModule");
				listFil.add(user);
				System.out.println(user);

			}

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
			connect = DriverManager.getConnection("jdbc:mysql://localhost/etudiant", "root", "Imad28082001");

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

	public ArrayList<String> readDataBaseList(String semestre, String filiere, String id, String module)
			throws Exception {
		try {
			String result = null;
			// This will load the MySQL driver, each DB has its own driver
			Class.forName("com.mysql.cj.jdbc.Driver");

			// Setup the connection with the DB
			connect = DriverManager.getConnection("jdbc:mysql://localhost/etudiant", "root", "Imad28082001");

			// Statements allow to issue SQL queries to the database
			statement = connect.createStatement();
			// String query = id;
			// Result set get the result of the SQL query
			resultSet = statement.executeQuery("select * from matiere where module = '" + module + "' ;");
			ArrayList<String> listFil = new ArrayList<String>();
			while (resultSet.next()) {
				result = resultSet.getString(id);
				if (result != null) {
					listFil.add(result);

				}

			}

			return listFil;

		} catch (Exception e) {
			throw e;
		} finally {
			close();
		}

	}

	private void writeResultSet(ResultSet resultSet) throws SQLException {
		// ResultSet is initially before the first data set
		while (resultSet.next()) {
			// It is possible to get the columns via name
			// also possible to get the columns via the column number
			// which starts at 1
			// e.g. resultSet.getSTring(2);
			String user = resultSet.getString("Mdp");

			System.out.println(user);

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