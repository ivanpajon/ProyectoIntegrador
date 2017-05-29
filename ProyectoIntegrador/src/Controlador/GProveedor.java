package Controlador;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import Entidades.Proveedor;

public class GProveedor {
	private Connection cn;
	
	public GProveedor(Connection cn) {
		this.cn = cn;
	}
	
	public void consultarProveedores(ArrayList<Proveedor> proveedores) {
		try {
			Statement st = cn.createStatement();
			ResultSet rs = st.executeQuery("select * from proveedor");
			
			while(rs.next()) {
				Proveedor p = new Proveedor();
				p.setCif(rs.getString(1));
				p.setNombre(rs.getString(2));
				p.setCorreo(rs.getString(3));
				p.setTfno(rs.getString(4));
				p.setDirec(rs.getString(5));
				p.setCod_po(rs.getString(6));
				p.setDesc(rs.getString(7));
				proveedores.add(p);
			}
			
			rs.close();
			st.close();
		}
		catch(Exception e) {
			System.out.println("Error al consultar los proveedores - " + e);
		}
	}

}
