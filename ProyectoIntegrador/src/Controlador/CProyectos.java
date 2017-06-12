package Controlador;

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
		//vProyectos.btnModificar.setEnabled(false);
		//vProyectos.btnBorrar.setEnabled(false);
		
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
		
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		Object obj = e.getSource();
		
		if (obj == vProyectos.table) {
			int fila = vProyectos.table.getSelectedRow();
			
			vProyectos.tfCodigo.setText(proyectos.get(fila).getCod_pr());
			vProyectos.tfNombre.setText(proyectos.get(fila).getNombre());
			vProyectos.tfDescripcion.setText(proyectos.get(fila).getDes());
			
			//vProyectos.btnModificar.setEnabled(true);
			//vProyectos.btnBorrar.setEnabled(true);
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
