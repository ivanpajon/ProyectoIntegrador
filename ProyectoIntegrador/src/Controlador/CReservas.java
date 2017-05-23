package Controlador;

import java.util.ArrayList;

import javax.swing.table.DefaultTableModel;

import Entidades.ProyectosMaquina;
import OracleAccess.OracleAccess;
import Vista.VReservas;

public class CReservas {
	VReservas vReservas;
	GReservas gReservas;
	OracleAccess bbdd;
	ArrayList<ProyectosMaquina> reservas = new ArrayList<ProyectosMaquina>();
	
	public CReservas(VReservas vReservas, OracleAccess bbdd) {
		this.vReservas = vReservas;
		this.bbdd = bbdd;
		this.gReservas = new GReservas(bbdd.getCn());
		this.gReservas.consultarEventos(reservas);
		
		this.vReservas.dateChooserInicio.getJCalendar().setTodayButtonVisible(true);
		this.vReservas.dateChooserInicio.getJCalendar().setTodayButtonText("Hoy");
		
		cargarReservas();
	}
	
	private void cargarReservas() {
		for (ProyectosMaquina r : reservas) {
			DefaultTableModel tabla = (DefaultTableModel) vReservas.table.getModel();
			tabla.addRow(new Object[] {r.getCod_pr(), r.getCod_ma(), r.getFecha_inicioFormatted(), r.getFecha_finFormatted()});
		}
	}

}
