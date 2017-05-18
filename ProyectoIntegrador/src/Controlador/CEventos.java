package Controlador;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import Entidades.Eventos;
import OracleAccess.OracleAccess;
import Vista.VEventos;

public class CEventos implements ActionListener {
	VEventos vEventos;
	GEventos gEventos;
	OracleAccess bbdd;
	ArrayList<Eventos> eventos = new ArrayList<Eventos>();
	
	public CEventos(VEventos vEventos, OracleAccess bbdd) {
		this.vEventos = vEventos;
		this.bbdd = bbdd;
		this.gEventos = new GEventos(bbdd.getCn());
		this.gEventos.consultarEventos(eventos);
		
		this.vEventos.tfCodigo.setEnabled(false);
		
		cargarEventos();
	}
	
	private void cargarEventos() {
		for (Eventos e : eventos) {
			DefaultTableModel tabla = (DefaultTableModel) vEventos.table.getModel();
			tabla.addRow(new Object[] {e.getCod_ev(), e.getFecha(), e.getMentor(), e.getCategoria(), e.getDuracion(), e.getLugar()});
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		
		if (obj == vEventos.btnInsertar) {
			añadirEvento();
		}
	}

	private void añadirEvento() {
		if (vEventos.table.getRowCount() >= 0) {
			vEventos.btnBorrar.setEnabled(true);
			vEventos.btnModificar.setEnabled(true);
		}
		if (this.vEventos.tfCodigo.getText().equals("") || this.vEventos.tfFecha.getText().equals("") || this.vEventos.tfMentor.getText().equals("") || this.vEventos.tfCategoria.getText().equals("") || this.vEventos.tfDuracion.getText().equals("") || this.vEventos.tfLugar.getText().equals("")) {
			vEventos.lblLblerror.setForeground(Color.RED);
			vEventos.lblLblerror.setText("Rellene todos los campos por favor");
			//JOptionPane.showMessageDialog(null, "Rellene todos los campos por favor");
		}
		else {
			Eventos e = new Eventos(vEventos.tfCodigo.getText(), vEventos.tfFecha.getText(), vEventos.tfMentor.getText(), vEventos.tfCategoria.getText(), vEventos.tfDuracion.getText(), vEventos.tfLugar.getText());
			eventos.add(e);
			
			DefaultTableModel tabla = (DefaultTableModel) vEventos.table.getModel();
			tabla.addRow(new Object[] {e.getCod_ev(), e.getFecha(), e.getMentor(), e.getCategoria(), e.getDuracion(), e.getLugar()});
			
			gEventos.añadirEvento(e);
		}
	}

}
