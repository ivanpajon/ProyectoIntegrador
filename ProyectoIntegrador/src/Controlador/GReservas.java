package Controlador;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import Entidades.Maquina;
import Entidades.Proyectos;
import Entidades.ProyectosMaquina;

public class GReservas {
private Connection cn;
	
	public GReservas(Connection cn) {
		this.cn = cn;
	}
	
	public void consultarProyectos(ArrayList<Proyectos> proyectos) {
		try {
			Statement st = cn.createStatement();
			ResultSet rs = st.executeQuery("select distinct nombre from proyectos");
			
			while(rs.next()) {
				Proyectos p = new Proyectos();
				p.setNombre(rs.getString(1));
				proyectos.add(p);
			}
			
			rs.close();
			st.close();
		}
		catch(Exception e) {
			System.out.println("Error al consultar los proyectos - " + e);
		}
	}
	
	public void consultarMaquinas(ArrayList<Maquina> maquinas) {
		try {
			Statement st = cn.createStatement();
			ResultSet rs = st.executeQuery("select cod_ma from maquina");
			
			while(rs.next()) {
				Maquina m = new Maquina();
				m.setNombre(rs.getString(1));
				maquinas.add(m);
			}
			
			rs.close();
			st.close();
		}
		catch(Exception e) {
			System.out.println("Error al consultar las maquinas - " + e);
		}
	}
	
	public void consultarReservas(ArrayList<ProyectosMaquina> reservas, String nombreProyecto) {
		try {
			Statement st = cn.createStatement();
			ResultSet rs = st.executeQuery("select nombre, pr.cod_pr, cod_ma, fecha_inicio,fecha_fin from proyectos pr, proyectosmaquina pm where pr.cod_pr=pm.cod_pr and nombre like '" + nombreProyecto + "'order by pr.cod_pr, cod_ma");
			
			while(rs.next()) {
				ProyectosMaquina pm = new ProyectosMaquina();
				pm.setNombre(rs.getString(1));
				pm.setCod_pr(rs.getString(2));
				pm.setCod_ma(rs.getString(3));
				pm.setFecha_inicio(rs.getString(4));
				pm.setFecha_fin(rs.getString(5));
				reservas.add(pm);
			}
			
			rs.close();
			st.close();
		}
		catch(Exception e) {
			System.out.println("Error al consultar las reservas - " + e);
		}
	}
	
	public boolean comprobarFecha(String fechaInicio, String fechaFin, int codMaquina) {
		try {
			Statement st = cn.createStatement();
			ResultSet rs = st.executeQuery("SELECT * FROM proyectosmaquina WHERE fecha_inicio BETWEEN TO_DATE('" + fechaInicio + "', 'YY-MM-DD') AND TO_DATE('" + fechaFin + "', 'YY-MM-DD') AND COD_MA='" + codMaquina + "'");
			
			if(rs.next()) {
				//System.out.println("La fecha no esta disponible");
				rs.close();
				st.close();
				return false;
			}
			else {
				//System.out.println("La fecha esta disponible");
				rs.close();
				st.close();
				return true;
			}
		}
		catch(Exception e) {
			System.out.println("Error al comprobar la fecha - " + e);
			return false;
		}
	}
	
	public boolean añadirReserva(ProyectosMaquina r) {
		Statement st;
		try {
			st = cn.createStatement();
			String insert = "INSERT INTO PROYECTOSMAQUINA VALUES('"+r.getCod_pr()+"', '"+r.getCod_ma()+"', TO_DATE('"+r.getFecha_inicio()+"', 'YY-MM-DD'), TO_DATE('"+r.getFecha_fin()+"', 'YY-MM-DD'))";
			//System.out.println(insert);
			
			st.executeUpdate(insert);
			st.close();
			return true;
		}
		catch(Exception ex) {
			System.out.println("Error añadiendo la reserva - " + ex);
			return false;
		}
	}
	
	public void borrarReserva(String codProyecto, String codMaquina) {
		Statement st;
		try {
			st = cn.createStatement();
			String delete = "DELETE FROM PROYECTOSMAQUINA WHERE COD_PR='"+codProyecto+"' AND COD_MA='"+codMaquina+"'";
			//System.out.println(delete);
			
			st.executeUpdate(delete);
			st.close();
		}
		catch(Exception ex) {
			System.out.println("Error borrando la reserva - " + ex);
		}
	}
	
	public boolean modificarReserva(ProyectosMaquina r) {
		Statement st;
		try {
			st = cn.createStatement();
			String update = "UPDATE PROYECTOSMAQUINA SET COD_PR='" + r.getCod_pr() + "'," +
					"COD_MA='" + r.getCod_ma() + "'," +
					"FECHA_INICIO=TO_DATE('" + r.getFecha_inicio() + "', 'YY-MM-DD')," +
					"FECHA_FIN=TO_DATE('" + r.getFecha_fin() + "', 'YY-MM-DD')" +
                    "WHERE COD_PR='" + r.getCod_pr() + "'" +
                    "AND COD_MA='" + r.getCod_ma() + "'";
			//System.out.println(update);
			
			st.executeUpdate(update);
			st.close();
			return true;
		}
		catch(Exception ex) {
			System.out.println("Error modificando la reserva - " + ex);
			return false;
		}
	}
}
