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
}
