package pe.edu.vallegrande.crudweb.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class AccesoDB {

	public AccesoDB() {
	}

	public static Connection getConnection() throws SQLException {
		Connection cn = null;
		String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
		String docker = "15000"; // USAR EN CASO DE QUERER  USAR UN CONTENEDOR
		String local = "1433"; // USAR EN CASO DE QUERER  USAR UNA BASE DE DATOS EN LOCAL
	    String DB = "db_Movil_Sur"; // PONER EL NOMBRE DE LA BASE DE DATOS
		String server = "db_Movil_Sur.mssql.somee.com\n";
		String urlDB = "jdbc:sqlserver://"+ server +";databaseName="+ DB +";encrypt=True;TrustServerCertificate=True;loginTimeout=30;";
		String user = "javi_SQLLogin_1";
		String pass = "1juuuc7vuf";
		try {
			Class.forName(driver).getDeclaredConstructor().newInstance();
			cn = DriverManager.getConnection(urlDB, user, pass);
		} catch (SQLException e) {
			throw e;
		} catch (ClassNotFoundException e) {
			throw new SQLException("No se encontro el driver de la base de datos.");
		} catch (Exception e) {
			throw new SQLException("No se puede establecer la conexion con la BD.");
		}
		return cn;
	}
}
