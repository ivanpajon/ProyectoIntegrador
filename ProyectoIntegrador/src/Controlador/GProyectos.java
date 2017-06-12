package Controlador;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import Entidades.Proyectos;

public class GProyectos {
	private Connection cn;

	public GProyectos(Connection cn) {
		this.cn = cn;
	}
	
	public void consultarProyectos(ArrayList<Proyectos> proyectos) {
		try {
			Statement st = cn.createStatement();
			ResultSet rs = st.executeQuery("select * from proyectos order by cod_pr");
			
			while(rs.next()) {
				Proyectos p = new Proyectos();
				p.setCod_pr(rs.getString(1));
				p.setNombre(rs.getString(2));
				p.setDes(rs.getString(3));
				proyectos.add(p);
			}
			
			rs.close();
			st.close();
		}
		catch(Exception e) {
			System.out.println("Error al consultar los proyectos - " + e);
		}
	}
	
	public boolean añadirProyecto(Proyectos p) {
		Statement st;
		try {
			st = cn.createStatement();
			String insert = "INSERT INTO PROYECTOS VALUES('"+p.getCod_pr()+"', '"+p.getNombre()+"', '"+p.getDes()+"')";
			//System.out.println(insert);
			
			st.executeUpdate(insert);
			st.close();
			return true;
		}
		catch(Exception ex) {
			System.out.println("Error añadiendo el proyecto - " + ex);
			return false;
		}
	}
	
	public boolean modificarProyecto(Proyectos p) {
		Statement st;
		try {
			st = cn.createStatement();
			String update = "UPDATE PROYECTOS SET COD_PR='" + p.getCod_pr() + "'," +
					"NOMBRE='" + p.getNombre() + "'," +
					"DES='" + p.getDes() + "' " +
                    "WHERE COD_PR='" + p.getCod_pr() + "'";
			//System.out.println(update);
			
			st.executeUpdate(update);
			st.close();
			return true;
		}
		catch(Exception ex) {
			System.out.println("Error modificando el proyecto - " + ex);
			return false;
		}
	}
	
	public void borrarProyecto(String codProyecto) {
		Statement st;
		try {
			st = cn.createStatement();
			String delete = "DELETE FROM PROYECTOS WHERE COD_PR='"+codProyecto+"'";
			//System.out.println(delete);
			
			st.executeUpdate(delete);
			st.close();
		}
		catch(Exception ex) {
			System.out.println("Error borrando el proyecto - " + ex);
		}
	}
}
