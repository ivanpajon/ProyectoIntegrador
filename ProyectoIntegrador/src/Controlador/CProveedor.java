package Controlador;

import java.awt.Color;
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
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		
		if (obj == vProveedor.btnInsertar) {
			if (vProveedor.btnInsertar.getText().equals("Insertar")) {
				vProveedor.tfCif.setEnabled(true);
				vProveedor.btnInsertar.setText("Guardar");
				vProveedor.btnModificar.setEnabled(false);
				vProveedor.btnBorrar.setEnabled(false);
				limpiar();
			}
			else {
				vProveedor.tfCif.setEnabled(false);
				vProveedor.btnInsertar.setText("Insertar");
				vProveedor.btnModificar.setEnabled(true);
				vProveedor.btnBorrar.setEnabled(true);
				insertarProveedor();
			}
		}
		else if (obj == vProveedor.btnModificar) {
			if (vProveedor.btnModificar.getText().equals("Modificar")) {
				vProveedor.tfCif.setEnabled(true);
				vProveedor.btnInsertar.setEnabled(false);
				vProveedor.btnBorrar.setEnabled(false);
				vProveedor.btnModificar.setText("Guardar");
			}
			else {
				vProveedor.tfCif.setEnabled(false);
				vProveedor.btnInsertar.setEnabled(true);
				vProveedor.btnBorrar.setEnabled(true);
				vProveedor.btnModificar.setText("Modificar");
				modificarProveedor();
				limpiar();
			}
		}
	}

	private void modificarProveedor() {
		Proveedor p = new Proveedor();
		p.setCif(vProveedor.tfCif.getText());
		p.setNombre(vProveedor.tfNombre.getText());
		p.setCorreo(vProveedor.tfCorreo.getText());
		p.setTfno(vProveedor.tfTelefono.getText());
		p.setDirec(vProveedor.tfDireccion.getText());
		p.setCod_po(vProveedor.tfCodigoPostal.getText());
		p.setDesc(vProveedor.tfDescripcion.getText());
		
		if (gProveedor.modificarProveedor(p)) {
			DefaultTableModel tabla = (DefaultTableModel) vProveedor.table.getModel();
			int fila = vProveedor.table.getSelectedRow();
			
			proveedores.set(fila, p);
			tabla.setValueAt(p.getCif(), fila, 0);
			tabla.setValueAt(p.getNombre(), fila, 1);
			tabla.setValueAt(p.getCorreo(), fila, 2);
			tabla.setValueAt(p.getTfno(), fila, 3);
			tabla.setValueAt(p.getDirec(), fila, 4);
			tabla.setValueAt(p.getCod_po(), fila, 5);
			tabla.setValueAt(p.getDesc(), fila, 6);
			
			vProveedor.lblError.setForeground(Color.GREEN.darker());
			vProveedor.lblError.setText("Proveedor modificado correctamente");
		}
		else {
			vProveedor.lblError.setForeground(Color.RED);
			vProveedor.lblError.setText("Error modificando el proveedor, revise los campos por favor");
		}
	}

	private void limpiar() {
		vProveedor.tfCif.setText("");
		vProveedor.tfNombre.setText("");
		vProveedor.tfCorreo.setText("");
		vProveedor.tfTelefono.setText("");
		vProveedor.tfDireccion.setText("");
		vProveedor.tfCodigoPostal.setText("");
		vProveedor.tfDescripcion.setText("");
	}

	private void insertarProveedor() {
		Proveedor p = new Proveedor();
		p.setCif(vProveedor.tfCif.getText());
		p.setNombre(vProveedor.tfNombre.getText());
		p.setCorreo(vProveedor.tfCorreo.getText());
		p.setTfno(vProveedor.tfTelefono.getText());
		p.setDirec(vProveedor.tfDireccion.getText());
		p.setCod_po(vProveedor.tfCodigoPostal.getText());
		p.setDesc(vProveedor.tfDescripcion.getText());
		
		if (!vProveedor.tfCif.getText().equals("") || !vProveedor.tfNombre.getText().equals("") || !vProveedor.tfCorreo.getText().equals("") || !vProveedor.tfTelefono.getText().equals("") || !vProveedor.tfDireccion.getText().equals("") || !vProveedor.tfCodigoPostal.getText().equals("") || !vProveedor.tfDescripcion.getText().equals("")) {
			if (gProveedor.añadirProveedor(p)) {
				DefaultTableModel tabla = (DefaultTableModel) vProveedor.table.getModel();
				tabla.addRow(new Object[] {p.getCif(), p.getNombre(), p.getCorreo(), p.getTfno(), p.getDirec(), p.getCod_po(), p.getDesc()});
				proveedores.add(p);
				
				vProveedor.lblError.setForeground(Color.GREEN.darker());
				vProveedor.lblError.setText("Proveedor añadido correctamente");
			}
			else {
				vProveedor.lblError.setForeground(Color.RED);
				vProveedor.lblError.setText("Error añadiendo el proveedor, revise los campos por favor");
			}
		}
		else {
			vProveedor.lblError.setForeground(Color.RED);
			vProveedor.lblError.setText("Rellene todos los campos por favor");
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
}
