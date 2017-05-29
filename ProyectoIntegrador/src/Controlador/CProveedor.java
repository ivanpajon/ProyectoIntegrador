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
	public void mouseClicked(MouseEvent e) {
		Object obj = e.getSource();
		
		if (obj == vProveedor.table) {
			int fila = vProveedor.table.getSelectedRow();
			
			vProveedor.tfCif.setText(proveedores.get(fila).getCif());
			vProveedor.tfNombre.setText(proveedores.get(fila).getNombre());
			vProveedor.tfCorreo.setText(proveedores.get(fila).getCorreo());
			vProveedor.tfTelefono.setText(proveedores.get(fila).getTfno());
			vProveedor.tfDireccion.setText(proveedores.get(fila).getDirec());
			vProveedor.tfCodigoPostal.setText(proveedores.get(fila).getCod_po());
			vProveedor.tfDescripcion.setText(proveedores.get(fila).getDesc());
		}
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
	}

}
