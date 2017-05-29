package Controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.table.DefaultTableModel;

import Entidades.Proveedor;
import OracleAccess.OracleAccess;
import Vista.VProveedor;

public class CProveedor implements ActionListener, MouseListener {
	VProveedor vProveedor;
	GProveedor gProveedor;
	OracleAccess bbdd;
	ArrayList<Proveedor> proveedores = new ArrayList<Proveedor>();
	

	public CProveedor(VProveedor vProveedor, OracleAccess bbdd) {
		this.vProveedor = vProveedor;
		this.bbdd = bbdd;
		this.gProveedor = new GProveedor(bbdd.getCn());
		this.gProveedor.consultarProveedores(proveedores);
		
		cargarProveedores();
	}

	private void cargarProveedores() {
		for (Proveedor p : proveedores) {
			DefaultTableModel tabla = (DefaultTableModel) vProveedor.table.getModel();
			tabla.addRow(new Object[] {p.getCif(), p.getNombre(), p.getCorreo(), p.getTfno(), p.getDirec(), p.getCod_po(), p.getDesc()});
		}
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		
	}

}
