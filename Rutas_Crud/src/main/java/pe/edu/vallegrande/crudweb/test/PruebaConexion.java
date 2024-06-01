package pe.edu.vallegrande.crudweb.test;

import pe.edu.vallegrande.crudweb.connection.AccesoDB;

import java.sql.SQLException;

public class PruebaConexion {

	public static void main(String[] args) throws SQLException {
		AccesoDB.getConnection();
		System.out.println("Conexion exitosa");

	}
}
