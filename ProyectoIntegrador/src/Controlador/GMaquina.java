package Controlador;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import Entidades.Maquina;

public class GMaquina {
	private Connection cn;

	public GMaquina(Connection cn) {
		this.cn = cn;
	}
	
	public void consultarMaquinas(ArrayList<Maquina> maquinas) {
		try {
			Statement st = cn.createStatement();
			ResultSet rs = st.executeQuery("select * from maquina order by cod_ma");
			
			while(rs.next()) {
				Maquina m = new Maquina();
				m.setCod_ma(rs.getString(1));
				m.setNombre(rs.getString(2));
				m.setDes(rs.getString(3));
				m.setTipo(rs.getString(4));
				maquinas.add(m);
			}
			
			rs.close();
			st.close();
		}
		catch(Exception e) {
			System.out.println("Error al consultar las maquinas - " + e);
		}
	}
	
	public boolean añadirMaquina(Maquina m) {
		Statement st;
		try {
			st = cn.createStatement();
			String insert = "INSERT INTO MAQUINA VALUES('"+m.getCod_ma()+"', '"+m.getNombre()+"', '"+m.getDes()+"', '"+m.getTipo()+"')";
			//System.out.println(insert);
			
			st.executeUpdate(insert);
			st.close();
			return true;
		}
		catch(Exception ex) {
			System.out.println("Error añadiendo la maquina - " + ex);
			return false;
		}
	}
	
	public boolean modificarMaquina(Maquina m) {
		Statement st;
		try {
			st = cn.createStatement();
			String update = "UPDATE MAQUINA SET COD_MA='" + m.getCod_ma() + "'," +
					"NOMBRE='" + m.getNombre() + "'," +
					"DES='" + m.getDes() + "'," +
					"TIPO='" + m.getTipo() + "'" +
                    "WHERE COD_MA='" + m.getCod_ma() + "'";
			//System.out.println(update);
			
			st.executeUpdate(update);
			st.close();
			return true;
		}
		catch(Exception ex) {
			System.out.println("Error modificando la maquina - " + ex);
			return false;
		}
	}
	
	public void borrarMaquina(String codMaquina) {
		Statement st;
		try {
			st = cn.createStatement();
			String delete = "DELETE FROM MAQUINA WHERE COD_MA='"+codMaquina+"'";
			//System.out.println(delete);
			
			st.executeUpdate(delete);
			st.close();
		}
		catch(Exception ex) {
			System.out.println("Error borrando la maquina - " + ex);
		}
	}
	
}
