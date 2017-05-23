package Controlador;

import java.util.ArrayList;

import Entidades.Eventos;
import Entidades.ProyectosMaquina;
import OracleAccess.OracleAccess;
import Vista.VEventos;
import Vista.VReservas;

public class CReservas {
	VReservas vReservas;
	GReservas gReservas;
	OracleAccess bbdd;
	ArrayList<ProyectosMaquina> reservas = new ArrayList<ProyectosMaquina>();
	
	public CReservas(VReservas vReservas, OracleAccess bbdd) {
		this.vReservas = vReservas;
		this.bbdd = bbdd;
		this.gReservas = new GEventos(bbdd.getCn());
		this.gReservas.consultarEventos(reservas);
		
		this.vReservas.dateChooser.getJCalendar().setTodayButtonVisible(true);
		this.vReservas.dateChooser.getJCalendar().setTodayButtonText("Hoy");
		
		cargarEventos();
	}

}
