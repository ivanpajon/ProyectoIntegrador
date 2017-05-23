package Controlador;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

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
			//ResultSet rs = st.executeQuery("SELECT * FROM PROYECTOSMAQUINA ORDER BY COD_PR, COD_MA");
			ResultSet rs = st.executeQuery("select distinct * from proyectos");
			
			while(rs.next()) {
				Proyectos pm = new Proyectos();
				pm.setCod_pr(rs.getString(1));
				pm.setNombre(rs.getString(2));
				pm.setDes(rs.getString(3));
				proyectos.add(pm);
			}
			
			rs.close();
			st.close();
		}
		catch(Exception e) {
			System.out.println("Error al consultar los proyectos - " + e);
		}
	}
	
	public void consultarReservas(ArrayList<ProyectosMaquina> reservas, String nombreProyecto) {
		try {
			Statement st = cn.createStatement();
			ResultSet rs = st.executeQuery("select nombre, pr.cod_pr, cod_ma, fecha_inicio,fecha_fin from proyectos pr,proyectosmaquina pm where pr.cod_pr=pm.cod_pr and nombre like '" + nombreProyecto + "'order by pr.cod_pr, cod_ma");
			
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
}
