package Controlador;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import Entidades.Eventos;

public class GEventos {
private Connection cn;
	
	public GEventos(Connection cn) {
		this.cn = cn;
	}

	public void consultarEventos(ArrayList<Eventos> eventos) {
		try {
			Statement st = cn.createStatement();
			ResultSet rs = st.executeQuery("SELECT * FROM EVENTOS");
			
			while(rs.next()) {
				Eventos e = new Eventos();
				e.setCod_ev(rs.getString(1));
				e.setFecha(rs.getString(2));
				e.setMentor(rs.getString(3));
				e.setCategoria(rs.getString(4));
				e.setDuracion(rs.getString(5));
				e.setLugar(rs.getString(6));
				eventos.add(e);
			}
			
			rs.close();
			st.close();
		}
		catch(Exception e) {
			System.out.println("Error al consultar los eventos - " + e);
		}
	}
	
	public void añadirEvento(Eventos e) {
		Statement st;
		try {
			st = cn.createStatement();
			String insert = "INSERT INTO EVENTOS VALUES('"+e.getCod_ev()+"', '"+e.getFecha()+"', '"+e.getMentor()+"', '"+e.getCategoria()+"', '"+e.getDuracion()+"', '"+e.getLugar()+"')";
			System.out.println(insert);
			
			st.executeUpdate(insert);
			st.close();
		}
		catch(Exception ex) {
			System.out.println("Error añadiendo evento - " + ex);
		}
	}
	
	/*public boolean eliminarDep(int cod) {
		Statement st;
		try {
			st = cn.createStatement();
			String delete = "DELETE FROM DEPT WHERE DEPTNO='" + cod + "'";
			//System.out.println(delete);
			
			st.executeUpdate(delete);
			st.close();
			return true;
		}
		catch(Exception e) {
			System.out.println("Error - " + e.getMessage());
			return false;
		}
	}
	
	public boolean modificarDep(Departamento d) {
		Statement st;
		try {
			st = cn.createStatement();
			String update = "UPDATE DEPT SET DNAME='" + d.getNombre() + "', LOC='" + d.getCiudad() + "' WHERE DEPTNO='" + d.getCod() + "'";
			//System.out.println(update);
			
			st.executeUpdate(update);
			st.close();
			return true;
		}
		catch(Exception e) {
			System.out.println("Error - " + e.getMessage());
			return false;
		}
	}*/
}
