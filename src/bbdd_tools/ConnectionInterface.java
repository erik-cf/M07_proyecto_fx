package bbdd_tools;

public interface ConnectionInterface {

	String PORT = "3306";
	String USER = "admin";
	String HOST = "localhost";
	String PASSWORD = "P@ssw0rd";
	String DATABASE = "proyecto_fx";
	String DRIVER = "com.mysql.cj.jdbc.Driver";
	String CONNSTRING = "jdbc:mysql://" + HOST + ":" + PORT + "/" + DATABASE;	
	
}
