package Controlador;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import Entidades.Usuarios;

public class GUsuarios {
	private Connection conexion;

	public GUsuarios(Connection cn) {
		this.conexion = cn;
	}
	
	public void cargarArrayListUsuarios(ArrayList<Usuarios> array) {
		try{
			Statement stmt = conexion.createStatement();
			ResultSet rset = stmt.executeQuery(
					"SELECT * FROM USUARIOS");
			while(rset.next()){
				Usuarios us = new Usuarios();
				us.setID_Socio(rset.getInt(1));
				us.setNombre(rset.getString(2));
				us.setApellido(rset.getString(3));
				us.setCorreo(rset.getString(4));
				us.setTLFN(rset.getInt(5));
				us.setTipo(rset.getString(6));
				array.add(us);
			}
			rset.close();
			stmt.close();
		} catch(SQLException s){
			s.printStackTrace();
		}
	}
	public void modificarUsu(Usuarios u) {
		Statement stmt;
		try{
			stmt = conexion.createStatement();
			String cadSQL = "UPDATE USUARIOS SET NOMBRE ='"+u.getNombre()+"', APELL='"+u.getApellido()+"',CORREO= '"+u.getCorreo()+"',TFNO= '"+u.getTLFN()+"',TIPO_US='"+u.getTipo()+"' WHERE ID_SOCI='"+u.getID_Socio()+"'";
			System.out.println(cadSQL);
			stmt.executeQuery(cadSQL);
		}catch (SQLException s){
			s.printStackTrace();
		}
	}	
	
	public void BorrarUsu(int ID) {
		Statement stmt;
		try{
			stmt = conexion.createStatement();
			String cadSQL = "DELETE FROM USUARIOS WHERE ID_SOCI= '"+ID+"'";
			System.out.println(cadSQL);
			stmt.executeUpdate(cadSQL);
			stmt.close();
		} catch(SQLException e1){
			e1.printStackTrace();
		}
	}
	
	public void insertarUsu(Usuarios Usuar) {
		Statement stmt;
		try{
			stmt = conexion.createStatement();
			String cadSQL = "INSERT INTO USUARIOS VALUES ('"+Usuar.getID_Socio()+"','"+Usuar.getNombre()+"', '"+Usuar.getApellido()+"', '"+Usuar.getCorreo()+"', '"+Usuar.getTLFN()+"', '"+Usuar.getTipo()+"')";
			System.out.println(cadSQL);
			stmt.executeUpdate(cadSQL);
			stmt.close();
		} catch(SQLException e1){
			e1.printStackTrace();
		}
	}
	
	public boolean comprobarID_Socio (int ID){
		boolean comprobar = false;
		try{
			Statement stmt = conexion.createStatement();
			ResultSet rset = stmt.executeQuery(
					"SELECT ID_SOCI FROM USUARIOS WHERE ID_SOCI = '"+ID+"'");
			if(rset.next()){
				comprobar = true;
			}
			rset.close();
			stmt.close();
		}catch(SQLException cd){
			cd.printStackTrace();
		}
		return comprobar;
	}
}
