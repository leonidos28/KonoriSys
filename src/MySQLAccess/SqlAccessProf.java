package MySQLAccess;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class SqlAccessProf {
	
public Connection connect = null;
public Statement statement = null;
private PreparedStatement preparedStatement = null;
private ResultSet resultSet = null;



public String readDataBase(String id) throws Exception {
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
       .executeQuery("SELECT * from professeur where idprofesseur ='" + id +"' ;");
   
   while (resultSet.next()) {
		 user = resultSet.getString("Mdp");
		 }
   
   return user;

   
   
 } catch (Exception e) {
   throw e;
 } finally {
   close();
 }

}
public  void SavetoDataBaseIDMatiere(String idColumn,String value,String idRow,String semestre,String filiere) throws Exception {
	 try {
		  int result = 0;

	   Class.forName("com.mysql.cj.jdbc.Driver");
	   connect = DriverManager
	       .getConnection("jdbc:mysql://localhost/etudiant","root","12345678");
	   statement = connect.createStatement();
	   result = statement
	       .executeUpdate("UPDATE matiere SET "+idColumn+" = '"+value+"' where idMatiere = '"+idRow+"' ; ");
	       		


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
private void close() {
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