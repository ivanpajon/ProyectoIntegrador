package Controlador;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import Entidades.Pedidos;

public class GPedidos {
	private Connection conexion;

	public GPedidos(Connection cn) {
		this.conexion = cn;
	}
	
	public void cargarArrayListPedido(ArrayList<Pedidos> array) {
		// TODO Auto-generated method stub
		try{
			Statement stmt = conexion.createStatement();
			ResultSet rset = stmt.executeQuery(
					"SELECT COD_PD, FECHA, TOT_IMPORTE, CIF FROM PEDIDOS");
			while(rset.next()){
				Pedidos pd = new Pedidos();
				pd.setCod_pd(rset.getInt(1));
				pd.setFecha(rset.getDate(2));
				pd.setTot_importe(rset.getInt(3));
				pd.setCif(rset.getString(4));
				
				array.add(pd);
			}
			rset.close();
			stmt.close();
		} catch(SQLException s){
			s.printStackTrace();
		}
	}
	
	public void insertarPedido(Pedidos p) {
		Statement stmt;
		try{
			stmt = conexion.createStatement();
			String cadSQL = "INSERT INTO PEDIDOS VALUES ('"+p.getCod_pd()+"','"+p.getFecha()+"', '"+p.getTot_importe()+"', '"+p.getCif()+"')";
			System.out.println(cadSQL);
			stmt.executeUpdate(cadSQL);
			stmt.close();
		} catch(SQLException e1){
			e1.printStackTrace();
		}
	}
	
	
	public boolean comprobar_DNI_CIF (String Cif){
		boolean comprobar = false;
		try{
			Statement stmt = conexion.createStatement();
			ResultSet rset = stmt.executeQuery(
					"SELECT CIF FROM PEDIDOS WHERE CIF = '"+Cif+"'");
			if(rset.next()){
				comprobar = true;
			}
			rset.close();
			stmt.close();
		}catch(SQLException e2){
			e2.printStackTrace();
		}
		return comprobar;
	}
	
	public void BorrarPedido(int Cod) {
		Statement stmt;
		try{
			stmt = conexion.createStatement();
			String cadSQL = "DELETE FROM PEDIDOS WHERE COD_PD = '"+Cod+"'";
			System.out.println(cadSQL);
			stmt.executeUpdate(cadSQL);
			stmt.close();
		} catch(SQLException e3){
			e3.printStackTrace();
		}
	}
	
	public void modificarPedido (Pedidos p) {
		Statement stmt;
		try{
			stmt = conexion.createStatement();
			String total=p.getTot_importe()+"";
			System.out.println(total.replace(".", ","));
			String cadSQL = "UPDATE PEDIDOS SET COD_PD ="+p.getCod_pd()+", FECHA="+p.getFecha()+",TOT_IMPORTE= "+p.getTot_importe()+" where COD_PD='"+p.getCod_pd()+"'";
			//String cadSQL = "UPDATE PEDIDOS SET COD_PD ='"+p.getCod_pd()+"', FECHA='"+p.getFecha()+"',TOT_IMPORTE= '"+total.replace(".", ",")+"' where CIF='"+p.getCif()+"'";

			System.out.println(cadSQL);
			stmt.executeQuery(cadSQL);
		}catch (SQLException e4){
			e4.printStackTrace();
		}
	}
	/*
	private void Buscar(String texto) {
		// TODO Auto-generated method stub
		Statement stmt;
		try{
			stmt = conexion.createStatement();
			String [] titulos={"Cod_Pedido", "Fecha", "Importe/€", "CIF/DNI"};
			 String cadSQL="SELECT * FROM PEDIDOS WHERE COD_PD LIKE '%"+texto+"_%'";
			 System.out.println(cadSQL);
			 stmt.executeUpdate(cadSQL);
		}
		catch(SQLException e5){
			e5.printStackTrace();
		}
	}*/
	
	public void BuscarPedido(int cod, ArrayList<Pedidos> array){
		Statement stmt;
		try{
			stmt = conexion.createStatement();
			String cadSQL = "SELECT COD_PD, FECHA, TOT_IMPORTE, CIF FROM PEDIDOS WHERE COD_PD="+cod;
			ResultSet rset = stmt.executeQuery(cadSQL);
			while(rset.next()){
				Pedidos pd = new Pedidos();
				pd.setCod_pd(rset.getInt(1));
				pd.setFecha(rset.getDate(2));
				pd.setTot_importe(rset.getInt(3));
				pd.setCif(rset.getString(4));
				
				array.add(pd);
				
			}
			rset.close();
			stmt.close();
		}
		catch(SQLException e6){
			e6.printStackTrace();
		}
	}
}
