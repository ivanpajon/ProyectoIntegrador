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
			ResultSet rs = st.executeQuery("SELECT * FROM EVENTOS ORDER BY COD_EV");
			
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
			String insert = "INSERT INTO EVENTOS VALUES('"+e.getCod_ev()+"', TO_DATE('"+e.getFecha()+"', 'YY-MM-DD'), '"+e.getMentor()+"', '"+e.getCategoria()+"', '"+e.getDuracion()+"', '"+e.getLugar()+"')";
			System.out.println(insert);
			
			st.executeUpdate(insert);
			st.close();
		}
		catch(Exception ex) {
			System.out.println("Error añadiendo el evento - " + ex);
		}
	}
	
	public boolean eliminarEvento(int cod) {
		Statement st;
		try {
			st = cn.createStatement();
			String delete = "DELETE FROM EVENTOS WHERE COD_EV='" + cod + "'";
			System.out.println(delete);
			
			st.executeUpdate(delete);
			st.close();
			return true;
		}
		catch(Exception e) {
			System.out.println("Error eliminando el evento - " + e);
			return false;
		}
	}
	
	public boolean modificarEvento(Eventos e) {
		Statement st;
		try {
			st = cn.createStatement();
			String update = "UPDATE EVENTOS SET FECHA=TO_DATE('" + e.getFecha() + "', 'YY-MM-DD')" +
					                        ", MENTOR='" + e.getMentor() +
					                        "', CATEGORIA='" + e.getCategoria() +
					                        "', DURACION='" + e.getDuracion() +
					                        "', LUGAR='" + e.getLugar() +
					                        "' WHERE COD_EV='" + e.getCod_ev() + "'";
			System.out.println(update);
			
			st.executeUpdate(update);
			st.close();
			return true;
		}
		catch(Exception ex) {
			System.out.println("Error modificando el evento - " + ex);
			return false;
		}
	}
}
