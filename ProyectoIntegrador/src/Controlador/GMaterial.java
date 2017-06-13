package Controlador;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import Entidades.Material;

public class GMaterial {
	private Connection conexion;

	public GMaterial(Connection cn) {
		this.conexion = cn;
	}
	public int cargarArrayMaterial(ArrayList<Material> array) {
		
		try{
			Statement stmt = conexion.createStatement();
			ResultSet rset = stmt.executeQuery(
					"SELECT * FROM MATERIAL");
			//"SELECT COD_MT, NOMBRE, DES, TIPO, STOCK FROM MATERIAL");
			while(rset.next()){
				Material mat = new Material();
				mat.setCod_mt(rset.getInt(1));
				mat.setNombre(rset.getString(2));
				mat.setDescripccion(rset.getString(3));
				mat.setTipo(rset.getString(4));
				mat.setStock(rset.getInt(5));
				array.add(mat);
			}
			rset.close();
			stmt.close();
		} catch(SQLException e1){
			e1.printStackTrace();
		}
		return 0;
		
		
	}
	
	public void ModificarMaterial(Material mat) {
		// TODO Auto-generated method stub
		Statement stmt;
		try{
				stmt = conexion.createStatement();
				String cadSQL = "UPDATE MATERIAL SET NOMBRE = '"+mat.getNombre()+"', DES= '"+mat.getDescripccion()+"', TIPO = '"+mat.getTipo()+"', STOCK = '"
						+mat.getStock()+"' WHERE COD_MT = '"+mat.getCod_mt()+"'";
				System.out.println(cadSQL);
				stmt.executeUpdate(cadSQL);
				stmt.close();
			} catch(SQLException e2){
				e2.printStackTrace();
			}
	}
	
	public void InsertaMaterial(Material mat) {
		// TODO Auto-generated method stub
		Statement stmt;
		try{
			stmt = conexion.createStatement();
			String cadSQL = "INSERT INTO MATERIAL VALUES ('"+mat.getCod_mt()+"','"+mat.getNombre()+"', '"+mat.getDescripccion()+"', '"+mat.getTipo()+"', '"+mat.getStock()+"')";
			System.out.println(cadSQL);
			stmt.executeUpdate(cadSQL);
			stmt.close();
		} catch(SQLException e3){
			e3.printStackTrace();
		}
	}
	
	public void BorrarMaterial(int cod) {
		// TODO Auto-generated method stub
		Statement stmt;
		try{
			stmt = conexion.createStatement();
			String cadSQL = "DELETE FROM MATERIAL WHERE COD_MT = '"+cod+"'";
			System.out.println(cadSQL);
			stmt.executeUpdate(cadSQL);
			stmt.close();
		} catch(SQLException e4){
			e4.printStackTrace();
		}
	}
	
	public void BuscarMaterial(int cod, ArrayList<Material> array){
		Statement stmt;
		try{
			stmt = conexion.createStatement();
			String cadSQL = "SELECT COD_MT, NOMBRE, DES, TIPO, STOCK FROM MATERIAL WHERE COD_MT="+cod;
			ResultSet rset = stmt.executeQuery(cadSQL);
			while(rset.next()){
				Material mat = new Material();
				mat.setCod_mt(rset.getInt(1));
				mat.setNombre(rset.getString(2));
				mat.setDescripccion(rset.getString(3));
				mat.setTipo(rset.getString(4));
				mat.setStock(rset.getInt(5));
				array.add(mat);
				
			}
			rset.close();
			stmt.close();
		} catch(SQLException e5){
			e5.printStackTrace();
		}
	}
	/*
	public boolean comprobarStock (int Stock){
		boolean comprobar = false;
		try{
			Statement stmt = conexion.createStatement();
			ResultSet rset = stmt.executeQuery(
					"SELECT STOCK FROM MATERIAL WHERE STOCK = '"+Stock+"'");
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
	*/
}
