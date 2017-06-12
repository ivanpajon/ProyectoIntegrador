package Controlador;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.table.DefaultTableModel;

import Entidades.Proyectos;
import OracleAccess.OracleAccess;
import Vista.VProyectos;

public class CProyectos implements ActionListener, MouseListener {
	VProyectos vProyectos;
	GProyectos gProyectos;
	OracleAccess bbdd;
	ArrayList<Proyectos> proyectos = new ArrayList<Proyectos>();
	
	public CProyectos(VProyectos vProyectos, OracleAccess bbdd) {
		this.vProyectos = vProyectos;
		this.bbdd = bbdd;
		this.gProyectos = new GProyectos(bbdd.getCn());
		this.gProyectos.consultarProyectos(proyectos);
		
		vProyectos.tfCodigo.setEnabled(false);
		vProyectos.btnModificar.setEnabled(false);
		vProyectos.btnBorrar.setEnabled(false);
		
		cargarProyectos();
	}

	private void cargarProyectos() {
		for (Proyectos p : proyectos) {
			DefaultTableModel tabla = (DefaultTableModel) vProyectos.table.getModel();
			tabla.addRow(new Object[] {p.getCod_pr(), p.getNombre(), p.getDes()});
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		
		if (obj == vProyectos.btnInsertar) {
			if (vProyectos.btnInsertar.getText().equals("Insertar")) {
				String codigo = String.valueOf(Integer.parseInt(proyectos.get(proyectos.size()-1).getCod_pr())+1);
				vProyectos.btnInsertar.setText("Guardar");
				vProyectos.btnModificar.setEnabled(false);
				vProyectos.btnBorrar.setEnabled(false);
				limpiar();
				vProyectos.tfCodigo.setText(codigo);
			}
			else {
				vProyectos.btnInsertar.setText("Insertar");
				insertarProyecto();
				limpiar();
			}
		}
		else if (obj == vProyectos.btnModificar) {
			modificarProyecto();
		}
		else if (obj == vProyectos.btnBorrar) {
			borrarProyecto();
		}
	}
	
	private void borrarProyecto() {
		int fila = vProyectos.table.getSelectedRow();
		
		proyectos.remove(fila);
		DefaultTableModel tabla = (DefaultTableModel) vProyectos.table.getModel();
		tabla.removeRow(fila);
		gProyectos.borrarProyecto(vProyectos.tfCodigo.getText());
		
		this.vProyectos.btnBorrar.setEnabled(false);
		this.vProyectos.btnModificar.setEnabled(false);
		limpiar();
	}

	private void modificarProyecto() {
		Proyectos p = new Proyectos();
		p.setCod_pr(vProyectos.tfCodigo.getText());
		p.setNombre(vProyectos.tfNombre.getText());
		p.setDes(vProyectos.tfDescripcion.getText());
		
		if (gProyectos.modificarProyecto(p)) {
			DefaultTableModel tabla = (DefaultTableModel) vProyectos.table.getModel();
			int fila = vProyectos.table.getSelectedRow();
			
			proyectos.set(fila, p);
			tabla.setValueAt(p.getCod_pr(), fila, 0);
			tabla.setValueAt(p.getNombre(), fila, 1);
			tabla.setValueAt(p.getDes(), fila, 2);
			
			vProyectos.lblError.setForeground(Color.GREEN.darker());
			vProyectos.lblError.setText("El proyecto se ha modificado correctamente");
		}
		else {
			vProyectos.lblError.setForeground(Color.RED);
			vProyectos.lblError.setText("Error modificando el proyecto");
		}
	}

	private void insertarProyecto() {
		Proyectos p = new Proyectos();
		p.setCod_pr(vProyectos.tfCodigo.getText());
		p.setNombre(vProyectos.tfNombre.getText());
		p.setDes(vProyectos.tfDescripcion.getText());
		
		if (vProyectos.tfCodigo.getText().equals("") || vProyectos.tfNombre.getText().equals("") || vProyectos.tfDescripcion.getText().equals("")) {
			vProyectos.lblError.setForeground(Color.RED);
			vProyectos.lblError.setText("Rellene todos los campos por favor");
		}
		else {
			if (gProyectos.añadirProyecto(p)) {
				DefaultTableModel tabla = (DefaultTableModel) vProyectos.table.getModel();
				tabla.addRow(new Object[] {p.getCod_pr(), p.getNombre(), p.getDes()});
				proyectos.add(p);
				
				vProyectos.lblError.setForeground(Color.GREEN.darker());
				vProyectos.lblError.setText("Proyecto añadido correctamente");
			}
			else {
				vProyectos.lblError.setForeground(Color.RED);
				vProyectos.lblError.setText("Ocurrió un error al guardar el proyecto");
			}
		}
	}

	private void limpiar() {
		vProyectos.tfCodigo.setText("");
		vProyectos.tfNombre.setText("");
		vProyectos.tfDescripcion.setText("");
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		Object obj = e.getSource();
		
		if (obj == vProyectos.table) {
			int fila = vProyectos.table.getSelectedRow();
			
			vProyectos.tfCodigo.setText(proyectos.get(fila).getCod_pr());
			vProyectos.tfNombre.setText(proyectos.get(fila).getNombre());
			vProyectos.tfDescripcion.setText(proyectos.get(fila).getDes());
			
			vProyectos.btnModificar.setEnabled(true);
			vProyectos.btnBorrar.setEnabled(true);
		}
	}
	@Override
	public void mousePressed(MouseEvent e) {
		
	}
	@Override
	public void mouseReleased(MouseEvent e) {
		
	}
	@Override
	public void mouseEntered(MouseEvent e) {
		
	}
	@Override
	public void mouseExited(MouseEvent e) {
		
	}
}
