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
			ResultSet rs = st.executeQuery("select * from maquina");
			
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
	
}
