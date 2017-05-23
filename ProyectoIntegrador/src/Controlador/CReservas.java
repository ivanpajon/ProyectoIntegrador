package Controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.table.DefaultTableModel;

import Entidades.ProyectosMaquina;
import OracleAccess.OracleAccess;
import Vista.VReservas;

public class CReservas implements ActionListener, MouseListener {
	VReservas vReservas;
	GReservas gReservas;
	OracleAccess bbdd;
	ArrayList<ProyectosMaquina> reservas = new ArrayList<ProyectosMaquina>();
	
	public CReservas(VReservas vReservas, OracleAccess bbdd) {
		this.vReservas = vReservas;
		this.bbdd = bbdd;
		this.gReservas = new GReservas(bbdd.getCn());
		this.gReservas.consultarEventos(reservas);
		
		this.vReservas.tfCodigoProyecto.setEnabled(false);
		
		this.vReservas.dateChooserInicio.getJCalendar().setTodayButtonVisible(true);
		this.vReservas.dateChooserInicio.getJCalendar().setTodayButtonText("Hoy");
		
		this.vReservas.dateChooserFin.getJCalendar().setTodayButtonVisible(true);
		this.vReservas.dateChooserFin.getJCalendar().setTodayButtonText("Hoy");
		
		cargarReservas();
	}
	
	private void cargarReservas() {
		for (ProyectosMaquina r : reservas) {
			DefaultTableModel tabla = (DefaultTableModel) vReservas.table.getModel();
			tabla.addRow(new Object[] {r.getNombre(), r.getCod_pr(), r.getCod_ma(), r.getFecha_inicioFormatted(), r.getFecha_finFormatted()});
			vReservas.comboBox.add(r.getNombre());
		}
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		Object obj = e.getSource();
		
		if (obj == vReservas.table) {
			//this.vReservas.btnModificar.setEnabled(true);
			//this.vReservas.btnBorrar.setEnabled(true);
			
			int fila = vReservas.table.rowAtPoint(e.getPoint());
			
			vReservas.tfCodigoProyecto.setText(reservas.get(fila).getCod_pr());
			vReservas.tfCodigoMaquina.setText(reservas.get(fila).getCod_ma());
			
			// Este try-catch hace la misma funcion que las lineas de arriba
			try {
				Date dateInicio = new SimpleDateFormat("yyyy-MM-dd").parse(reservas.get(fila).getFecha_inicio());
				vReservas.dateChooserInicio.setDate(dateInicio);
				
				Date dateFin = new SimpleDateFormat("yyyy-MM-dd").parse(reservas.get(fila).getFecha_fin());
				vReservas.dateChooserFin.setDate(dateFin);
			}
			catch (ParseException ex) {
				System.out.println("Error obteniendo fecha - " + ex);
			}
		}
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}
