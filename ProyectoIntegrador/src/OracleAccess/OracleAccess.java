package OracleAccess;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class OracleAccess {
	// Atributos de la clase
	private String url = "jdbc:oracle:thin:@192.168.141.128:1521:XE";
	private Connection cn;

	// Constructor que crea la conexión
	public OracleAccess() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			cn = DriverManager.getConnection(url, "JAVA", "java");
			System.out.println("- Conexión con ORACLE establecida -");
		}
		catch (Exception e) {
			System.out.println("– Error de Conexión con ORACLE -");
			e.printStackTrace();
		}
	}
	
	public void cerrarBBDD() {
		try {
			cn.close();
			System.out.println("- Base de datos cerrada -");
		}
		catch (SQLException e) {
			//e.printStackTrace();
			System.out.println("- Error al cerrar la base de datos -");
		}//
	}
}